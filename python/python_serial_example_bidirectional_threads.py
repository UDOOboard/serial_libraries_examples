import serial
import time
import threading

class SerialPortManager:
    
    def __init__(self):
        self.port = serial.Serial('/dev/ttyMCC',115200,timeout=1)

    def write(self, message):
        print("Writing data to serial port: " + message)
        self.port.write(message)
        self.port.flushOutput()

    def readx(self):
        return self.port.readline()

    def close(self):
        return self.port.close()



runSerialThread = True
serialMgr = SerialPortManager()

def read_from_port(serial_port):
    while runSerialThread:
        line = serial_port.readx()
        if line:
            print("Read from serial port: " + line)
    serial_port.close()


serialthread = threading.Thread(target=read_from_port, args=(serialMgr,))
serialthread.daemon = True
serialthread.start()
print("Serial thread started. Press Ctrl+C to close it.")

serialMgr.write("aaaa" + chr(13))

while True:
    try:
        time.sleep(1)
    except KeyboardInterrupt:
        print("Closing the connection")
        runSerialThread = False
        serialthread.join()
        exit(0)

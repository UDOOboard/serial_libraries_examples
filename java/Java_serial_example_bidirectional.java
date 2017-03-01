/**
*  Copyright (C) 2014 Ekironji <ekironjisolutions@gmail.com>
*
*  This file is part of serial libraries examples for UDOO
*
*  Serial libraries examples for UDOO is free software: you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This libraries are distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
*
*  You should have received a copy of the GNU General Public License
*  along with this program.  If not, see <http://www.gnu.org/licenses/>.
*
*/

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class Java_serial_example_bidirectional {

		static Serial UDOOserial;

		public static void main(String[] args) {

			UDOOserial = new Serial();

			System.out.println("connecting to serial port...");
			try {
				UDOOserial.connect("/dev/ttyACM0");
				System.out.println("Connected!");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}

			byte[] outBuff = new byte[2];
			
			try{
				UDOOserial.read_startBufferThread();
				outBuff[0] = (byte)13;
				outBuff[1] = (byte)1;
				UDOOserial.writeByteArray(outBuff);
				
				Thread.sleep(1000);
				
				outBuff[0] = (byte)13;
				outBuff[1] = (byte)0;
				UDOOserial.writeByteArray(outBuff);

				Thread.sleep(1000);
			} catch(IOException ioe) {
				ioe.printStackTrace();
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
			System.exit(0);	
		}
		

		public static class Serial {

			private SerialPort mSerialPort;
			private OutputStream out;
			private InputStream in;

			public Serial() {
			}

			public void connect(String portName) throws Exception {
				CommPortIdentifier mCommPortIdentifier = CommPortIdentifier.getPortIdentifier(portName);
				if (mCommPortIdentifier.isCurrentlyOwned()) {
					System.out.println("Error: Port is currently in use!");
				} else {
					CommPort mCommPort = mCommPortIdentifier.open(this.getClass().getName(), 2000);
					if(mCommPort instanceof SerialPort) {
						mSerialPort = (SerialPort) mCommPort;
						mSerialPort.setSerialPortParams(115200,
										SerialPort.DATABITS_8,
										SerialPort.STOPBITS_1,
										SerialPort.PARITY_NONE);
						mSerialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

						out = mSerialPort.getOutputStream();
						in = mSerialPort.getInputStream();
					} else {
						System.out.println("Error: Only serial ports are handled by this example!");
					}
				}
			}

			public void writeByteArray(byte[] msg) throws IOException {
				out.write(msg);
			}

			public void read_startBufferThread() {
				(new Thread(new SerialReader(in))).start();
			}

			public void disconnect() {
				try {
					if (out != null) {
						out.close();
						out = null;
					}
					if (mSerialPort != null) {
						mSerialPort.close();
						mSerialPort = null;
					}
				} catch (Exception e) {
					System.out.println("Error: Port not closed!");
				} finally {
					out = null;
					mSerialPort = null;
				}
			}

			public static class SerialReader implements Runnable {

				InputStream in;

				public SerialReader(InputStream in) {
					this.in = in;
				}

				public void run() {
					byte[] buffer = new byte[7];
					int len = -1;
					String mStringReceived = "";
					try {
						while((len = this.in.read(buffer)) > -1) {
							mStringReceived += new String(buffer, 0, len);
							if (buffer[len-1] == '\n') {
								System.out.println(mStringReceived);
								mStringReceived = "";
							}
						}
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}

		}
}

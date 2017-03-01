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

public class Java_serial_example {

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

			try{
				System.out.println("write chars to Arduino...");
				UDOOserial.writeChar('1');
				Thread.sleep(1000);
				UDOOserial.writeChar('0');
			} catch(IOException ioe) {
				ioe.printStackTrace();
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			} finally {
				UDOOserial.disconnect();
			}

			System.out.println("Finished!");
			System.exit(0);
		}


		public static class Serial {

			private SerialPort mSerialPort;
			private OutputStream out;
		
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
					} else {
						System.out.println("Error: Only serial ports are handled by this example!");
					}
				}
			}

			public void writeChar(char msg) throws IOException {
				out.write(msg);
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

		}

}

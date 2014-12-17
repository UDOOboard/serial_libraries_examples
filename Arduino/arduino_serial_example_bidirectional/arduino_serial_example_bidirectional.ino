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

byte inByte;

boolean received = false;   // store if Arduino received something

// the setup routine runs once when you press reset:
void setup() {
  // initialize serial port at a baud rate of 115200 bps
  Serial.begin(115200);
  delay(100);
  Serial.println("start");
}

#define RCVSIZE 2

void loop() {
  // put your main code here, to run repeatedly: 
  byte msg[RCVSIZE];
  int count = 0;
  
  while (Serial.available() > 0) {
    
    // get the new byte:
    byte inByte = (byte)Serial.read();
    //Serial.println(inByte);
    msg[count] = inByte;
    count++;
    
    received = true;
  }
  
  if(received) {
    
    pinMode(msg[0], OUTPUT);
    digitalWrite(msg[0], msg[1]);
    if (msg[1] ==  1) {
      Serial.print(msg[0]);Serial.println(" ON");
    } else if (msg[1] == 0) {
      Serial.print(msg[0]);Serial.println(" OFF");
    }
    
    received = false;
  }
  
  delay(10);
}

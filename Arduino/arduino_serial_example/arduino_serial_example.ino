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

// Attach a LED to Pin 13
int led = 13;

char inChar;

// the setup routine runs once when you press reset:
void setup() {
  // initialize the digital pin as an output and turn off 
  pinMode(led, OUTPUT);
  digitalWrite(led, LOW);
  
  // initialize serial port at a baud rate of 115200 bps
  Serial.begin(115200);
  delay(100);
  Serial.println("start");
}

void loop() {
  
  inChar = '\0';
  
  while (Serial.available()) {
    
    // get the new byte:
    inChar = (char)Serial.read();
  }
  
  //Serial.print("inChar= ");Serial.println(inChar);
  //char byteParsed = parseResponse(inChar);
  
  if (inChar == '1') { // compare received data
    digitalWrite(led, HIGH); // turn on light
  } else if (inChar == '0') {
    digitalWrite(led, LOW);  // turn off light
  }

  delay(10); 
}

// the characters sent to Arduino as String are interpreted as ASCII,
// we decrease 48 to return to ASCII range 
char parseResponse(char received) {
  return received - 48;
}



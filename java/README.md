JAVA Serial libraries for UDOO NEO
-----------------

This file describes how to compile and run the Java examples contained in this folder.

1 - Flash the Arduino&trade; Sketch using the Arduino IDE

1 - Install the OpenJDK Development Kit (JDK) (the headless version is good enough for this examples) and the javarxtx serial library.

    sudo apt install openjdk-8-jdk-headless librxtx-java

2 - Open a terminal and navigate to this folder:

    cd serial_libraries_examples/java/

3 - Check if the Arduino 101 is assigned to the default port `/dev/ttyACM0`, otherwise modify this string in the .java sources with correct tty and save:

    UDOOserial.connect("/dev/ttyACM0");

4 - Compile the Java file:

for Java_serial_example.java:

    javac -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example.java

for Java_serial_example_bidirectional.java:

    javac -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example_bidirectional.java

5 - Run the Java program:

for Java_serial_example.java:

    java -Djava.library.path=/usr/lib/jni -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example

for Java_serial_example_bidirectional.java:

    java -Djava.library.path=/usr/lib/jni -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example_bidirectional

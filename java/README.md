JAVA Serial libraries for UDOO
-----------------

This file describes how to compile and run the Java examples contained in this folder.

1 - Open a terminal and navigate to this folder:

    cd serial_libraries_examples/java/

2 - Compile the Java file:

for Java_serial_example.java:

    javac -cp /opt/arduino-1.5.4/lib/RXTXcomm.jar:. Java_serial_example.java

for Java_serial_example_bidirectional.java:

    javac -cp /opt/arduino-1.5.4/lib/RXTXcomm.jar:. Java_serial_example_bidirectional.java

3 - Run the Java program:

for Java_serial_example.java:

     java -Djava.library.path=/usr/lib/jni -cp /opt/arduino-1.5.4/lib/RXTXcomm.jar:. Java_serial_example

for Java_serial_example_bidirectional.java:

    java -Djava.library.path=/usr/lib/jni -cp /opt/arduino-1.5.4/lib/RXTXcomm.jar:. Java_serial_example_bidirectional




Installation Instructions with Vanilla Java Libraries 
--------------

Install librxtx-java

    sudo apt-get install librxtx-java

Copy appropriate libraries and symlink them

    cp /usr/lib/jni/librxtxSerial-2.2pre1.so /usr/lib/jvm/java-7-openjdk-armhf/jre/lib/arm/ 
    cd /usr/lib/jvm/java-7-openjdk-armhf/jre/lib/arm/
    sudo ln -s librxtxSerial-2.2pre1.so librxtxSerial.so

Now symlink them to allow UDOO's /dev/ttymxc3 serial port binding

    sudo ln -s /dev/ttymxc3 /dev/ttyS0

compile and run the example:

    $ javac -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example.java
    $ java -Djava.library.path=/usr/lib/jni -cp /usr/share/java/RXTXcomm.jar:. Java_Serial_example



Alternate Solution with UDOO's libraries
----------

    cp /opt/arduino-1.5.4/lib/librxtxSerial-2.2pre1.so /usr/lib/jvm/java-7-openjdk-armhf/jre/lib/arm/ 
    cd /usr/lib/jvm/java-7-openjdk-armhf/jre/lib/arm/
    sudo ln -s librxtxSerial-2.2pre1.so librxtxSerial.so

compile and run the example:

    $ javac -cp /opt/arduino-1.5.4/lib/RXTXcomm.jar:. Java_serial_example.java
    $ java -Djava.library.path=/usr/lib/jni -cp /opt/arduino-1.5.4/lib/RXTXcomm.jar:. Java_serial_example








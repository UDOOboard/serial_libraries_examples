JAVA Serial libraries for UDOO
-----------------

This file describes how to compile and run the Java examples contained in this folder.

1 - Install the Java library to manage the serial:
(NB: jump to the step 2 if you have this example preinstalled in you UDOObuntu distribution, release 1.1 and above)

1a. If you are in a UDOO distribution with the Arduino IDE preinstalled(UDOObuntu 1.0, Debian Wheezy 1.1) use the library contained in the /lib folder(this recompiled library handles properly the /dev/ttymxc3 internal serial of UDOO):

    sudo cp /opt/arduino-1.5.4/lib/librxtxSerial-2.2pre1.so /usr/lib/jvm/java-7-openjdk-armhf/jre/lib/arm/
	sudo cp /opt/arduino-1.5.4/lib/RXTXcomm.jar /usr/share/java/
    cd /usr/lib/jvm/java-7-openjdk-armhf/jre/lib/arm/
    sudo ln -s librxtxSerial-2.2pre1.so librxtxSerial.so

1b. If you are in other UDOO distributions use the standard Vanilla JAVA Libraries.	

Install librxtx-java from repositories

    sudo apt-get install librxtx-java

Copy appropriate libraries and symlink them

    sudo cp /usr/lib/jni/librxtxSerial-2.2pre1.so /usr/lib/jvm/java-7-openjdk-armhf/jre/lib/arm/ 
    cd /usr/lib/jvm/java-7-openjdk-armhf/jre/lib/arm/
    sudo ln -s librxtxSerial-2.2pre1.so librxtxSerial.so

Now symlink them to allow UDOO's /dev/ttymxc3 serial port binding

    sudo ln -s /dev/ttymxc3 /dev/ttyS0

(NB: using this library you need to modify the code of the examples substituting in both the JAVA files the String "/dev/ttymxc3" with "/dev/ttyS0".)

2 - Open a terminal and navigate to this folder:

    cd serial_libraries_examples/java/

3 - Compile the Java file:

for Java_serial_example.java:

    javac -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example.java

for Java_serial_example_bidirectional.java:

    javac -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example_bidirectional.java

4 - Run the Java program:

for Java_serial_example.java:

    java -Djava.library.path=/usr/lib/jni -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example

for Java_serial_example_bidirectional.java:

    java -Djava.library.path=/usr/lib/jni -cp /usr/share/java/RXTXcomm.jar:. Java_serial_example_bidirectional
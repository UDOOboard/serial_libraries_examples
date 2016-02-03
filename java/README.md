JAVA Serial libraries for UDOO
-----------------

This file describes how to compile and run the Java examples contained in this folder.

1 - Starting from UDOObuntu2  all the libraries and link should be preinstalled. Otherwise install the java serial library and create the needed serial link with these commands:

	sudo apt-get install librxtx-java
	sudo ln -s /dev/ttymxc3 /dev/ttyS0

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

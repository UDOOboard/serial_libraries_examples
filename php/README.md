PHP Serial Libraries for UDOO
--------

This file describes how to run the PHP examples contained in this folder.

To run these PHP examples, we will use the PHP interpreter and its embedded Web Server. The same examples can be executed over Apache or nginx too.

1 - Flash the Arduino Sketch using the Arduino IDE

2 - Navigate in this folder:

    cd serial_libraries_examples/php/


3 - Start the embedded web server:

    php -S 0.0.0.0:8080


4 - Open a browser (on your UDOO or on your computer) and run the examples writing in the address bar:

For the basic serial example:

    http://127.0.0.1:8080/index.php


For the bidirectional serial example:

    http://127.0.0.1:8080/index_bidirectional.php

Please note, use `127.0.0.1` if you open the browser directly on the UDOO; otherwise use `192.168.7.2` if you are using the USB connection. WiFi/Ethernet IP address are supported too.




PHP Serial Libraries for UDOO
--------

This file describes how to run the PHP examples contained in this folder.

To run these PHP examples, we will use the PHP interpreter and its embedded Web Server. The same examples can be executed over Apache or nginx too.

1 - Flash the Arduino Sketch using the Arduino IDE

2 - Create the needed serial link [substitute `/dev/ttyREAL` with: `/dev/ttymxc3` for the UDOO QUAD/DUAL - `/dev/ttyMCC` for the UDOO NEO]:

    sudo ln -s /dev/ttyREAL /dev/ttyS0

3 - Navigate in this folder:

    cd serial_libraries_examples/php/


4 - Start the embedded web server:

    php -S 0.0.0.0:8080


5 - Open a browser (on your UDOO or on your computer) and run the examples writing in the address bar:

For the basic serial example:

    http://127.0.0.1:8080/index.php


For the bidirectional serial example:

    http://127.0.0.1:8080/index_bidirectional.php

Please note, use `127.0.0.1` if you open the browser directly on the UDOO; If you want to connect from an external PC WiFi/Ethernet IP address are supported too. 
If you are working on UDOO NEO connected with USB connection you can use `192.168.7.2`.




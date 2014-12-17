This file describes how to run the PHP examples contained in this folder. To run this PHP examples you need a PHP interpreter and a Web Server.  The easiest way is install a preconfigured LAMP environment using tasksel.

1 - In a terminal run:

    sudo apt-get update
    sudo apt-get install tasksel

2 - Install LAMP following the instruction:

    sudo tasksel install lamp-server 

3 - Grant www-data user appropriate permissions for the serial port:

    sudo adduser www-data intserial

4 - Navigate in this folder and copy the php files in the Apache web server folder (/var/www/):

    cd serial_libraries_examples/php/
    sudo cp php_serial* /var/www/

(Note: php_serial.class.php is the library we use to communicate with the serial port)

5 - Open a browser and go to these pages writing in the address bar:

for php_serial_example.php:

    localhost/php_serial_example.php

for php_serial_example_bidirectional.php:

    localhost/php_serial_example_bidirectional.php




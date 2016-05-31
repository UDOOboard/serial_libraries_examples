Python serial libraries for UDOO
------------

This file describes how to run the python examples contained in this folder.

1- Install the Python library to manage the serial:
(NB: jump this step if you have this example preinstalled in you UDOObuntu distribution, release 1.1 and above)

    sudo pip install pyserial
1 - Starting from UDOObuntu2 all the libraries and link should be preinstalled. Otherwise install the Python serial library and create the needed serial link with these commands:

    sudo apt-get install python-serial

2 - Create the needed serial link [substitute `/dev/ttyREAL` with: `/dev/ttymxc3` for the UDOO QUAD/DUAL - `/dev/ttyMCC` for the UDOO NEO]:

    sudo ln -s /dev/ttyREAL /dev/ttyS0

3- Open a terminal and navigate to this folder:

    cd serial_libraries_examples/python/

4- Run the python program:

for the base python_serial_example.py:

    python python_serial_example.py

for the bidirectional python_serial_example_bidirectional.py:

    python python_serial_example_bidirectional.py

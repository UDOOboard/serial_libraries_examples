Python serial libraries for UDOO X86 running Linux (tested with Ubuntu 16.04 LTS)
------------

This file describes how to run the python examples contained in this folder.

1 - Install the Python serial library from `apt`:

    sudo apt install python-serial

2 - Open a terminal and navigate to this folder:

    cd serial_libraries_examples/python/

3 - Check if the Arduino 101 is assigned to the default port `/dev/ttyACM0`, otherwise modify this string in the .py sources with correct tty and save:

    ser = serial.Serial('/dev/ttyACM0', 115200,timeout=1)

4 - Run the python program:

for the base python_serial_example.py:

    python python_serial_example.py

for the bidirectional python_serial_example_bidirectional.py:

    python python_serial_example_bidirectional.py

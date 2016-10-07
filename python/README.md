Python serial libraries for UDOO
------------

This file describes how to run the python examples contained in this folder.

1 - Edit the port name inside the example, or create the needed symlink. Replace `/dev/ttyREAL` with: `/dev/ttymxc3` for the UDOO QUAD/DUAL - `/dev/ttyMCC` for the UDOO NEO:

    sudo ln -s /dev/ttyREAL /dev/ttyS0

2 - Run the python example:

for the base example:

    python python_serial_example.py

for the bidirectional one:

    python python_serial_example_bidirectional.py

a bidirectional example using thread to read/write can be run with:

    python python_serial_example_bidirectional_threads.py

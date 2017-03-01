<?php
/**
 *  Copyright (C) 2014 Ekironji <ekironjisolutions@gmail.com>
 *
 *  This file is part of serial libraries examples for UDOO
 *
 *  Serial libraries examples for UDOO is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This libraries are distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

define("PORT","/dev/ttyACM0");
$ledOn = false;

if (isset($_GET['action'])) {
	include "php_serial.class.php";
	
	$serial = new phpSerial;
	$serial->deviceSet(PORT);
	$serial->confBaudRate(115200);
	$serial->confParity("none");
	$serial->confStopBits(1);
	$serial->confFlowControl("none");
	$serial->deviceOpen();
    
	if ($_GET['action'] == "on") {
		$serial->sendMessage(chr(13).chr(1));
		$ledOn = true;
	} elseif ($_GET['action'] == "off") {
		$serial->sendMessage(chr(13).chr(0));
		$ledOn = false;
	}

	$read = $serial->readPort();
       	echo "Arduino response is: $read";
}
?>

<!DOCTYPE html>
<html>
	<head>
		<title>LED 13 example</title>
	</head>
	<body>
		<div style="text-align:center;">
			<?php if ($ledOn) { ?>
			<img src="light.png" style="width:100px;"><br>
			<a href="?action=off">LED is ON, turn it OFF</a>
			<?php } else { ?>
			<img src="light.png" style="width:100px; filter:grayscale(100%); -webkit-filter: grayscale(100%);"><br>
			<a href="?action=on">LED is OFF, turn it ON</a>
			<?php } ?>
		</div>
	</body>
</html>

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

<?php
define("PORT","/dev/ttymxc3");

if(isset($_GET['action'])) {
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
	} else if ($_GET['action'] == "off") {
		$serial->sendMessage(chr(13).chr(0));
	}
	
	$read = $serial->readPort();
	print $read;
	
}

?>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"> 
<title>UDOO - Serial Example</title> 
</head> 
<body> 
<br>
<h1>UDOO - Serial Example</h1>
 
<a href="<?=$_SERVER['PHP_SELF'] . "?action=on" ?>">
<button style="width:100px""><h1>ON</h1></button></a>
<a href="<?=$_SERVER['PHP_SELF'] . "?action=off" ?>">
<button style="width:100px""><h1>OFF</h1></button></a>
</body> 
</html>

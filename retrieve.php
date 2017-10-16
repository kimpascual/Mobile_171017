<?php
	$host = "localhost";
	$un   = "admin";
	$pw   = "admin";
	$db   = "id2553265_mobile_app";
	
	//web based connection
	$con = mysqli_connect("localhost", "id2553265_admin", "admin", "id2553265_mobile_app");
	//local based connection
	//$con = mysqli_connect($host, $un, $pw, $db);
	
	$players = $_POST["players"];
	$desc = $_POST["desc"];
	$images = $_POST["images"];
	
	?>
	
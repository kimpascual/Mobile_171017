<?php
	$host = "localhost";
	$un   = "admin";
	$pw   = "admin";
	$db   = "id2553265_mobile_app";
	
	//web based connection
	$con = mysqli_connect("localhost", "id2553265_admin", "admin", "id2553265_mobile_app");
	//local based connection
	//$con = mysqli_connect($host, $un, $pw, $db);
	
	$username = $_POST["username"];
	$password = $_POST["password"];
	
	$statement = mysqli_prepare($con, "SELECT A.Username,B.* FROM Account A, Account_Description B
	WHERE A.Username = '$username' 
		AND A.Password = '$password'
		AND B.User_ID = A.User_ID ");
		
	mysqli_stmt_execute($statement);
	
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $userName, $userID, $firstName, $lastName, $emailAdd, $homeAdd, $Dept, $Div, $acctType);
	
	$response = array();
	$response["success"] = false;
	
	while(mysqli_stmt_fetch($statement)){
		$response["success"]   = true;
		$response["username"]  = $userName;
		$response["userID"]    = $userID;
                $response["firstName"] = $firstName;
		$response["lastName"]  = $lastName;
                $response["emailAdd"]  = $emailAdd;
		$response["homeAdd"]   = $homeAdd;
		$response["Dept"]      = $Dept;
		$response["Div"]       = $Div;
		$response["AcctType"]  = $acctType;
	}
	
	echo json_encode($response);


?>
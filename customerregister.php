<?php


if($_SERVER["REQUEST_METHOD"]=="POST"){

	require 'connection.php';
	createStudent();

}
function createstudent()
{
    global $connect;

	$Customer_name = isset($_POST["Customer_name"]);
	$Customer_email = isset($_POST["Customer_email"]);
	$Customer_password = isset($_POST["Customer_password"]);
	$Phone_number = isset($_POST["Phone_number"]);
	$Address = isset($_POST["Address"]);
	
	$query = "INSERT INTO `customer` (`Customer_id`, `Customer_name`, `Customer_email`, `Customer_password`, `Phone_number`, `Address`) VALUES (NULL,'".$Customer_name."','".$Customer_email."','".$Customer_password."','".$Phone_number."','".$Address."')";

	mysqli_query($connect,$query) or die(mysqli_error($connect));
	mysqli_close($connect);

}


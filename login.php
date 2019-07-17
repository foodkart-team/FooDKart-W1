<?php

session_start();

if($_SERVER["REQUEST_METHOD"]=="POST"){

	require 'connection.php';
	loginapp();

}

function loginapp(){

	global $connect;
 

$email = $_POST["email"];
$password = $_POST ['password'];


$q1 = "SELECT * from admin where email = '$email' && password = '$password'";
$q2 = "SELECT * from customer where Customer_email = '$email' && Customer_password = '$password'";



$result1 = mysqli_query($connect, $q1);
$result2 = mysqli_query($connect, $q2);

$num1 = mysqli_num_rows($result1);
$num2 = mysqli_num_rows($result2); 
  // returns number of rows in a set.


if($num1 == 1){
	echo"1";
}

else if($num2 == 1){
  echo "2";
}
else
{
  echo"4";
}

}


?>




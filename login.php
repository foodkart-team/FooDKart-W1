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
$q3 = "SELECT * from `restaurant` where `r_email` = '$email' && `r_password`= '$password'";



$result1 = mysqli_query($connect, $q1);
$result2 = mysqli_query($connect, $q2);
$result3 = mysqli_query($connect,$q3);



$num1 = mysqli_num_rows($result1);
$num2 = mysqli_num_rows($result2);
$num3 = mysqli_num_rows($result3);


  // returns number of rows in a set.


if($num1 == 1){
	echo"1";
}

else if($num2 == 1){
  echo"2";
 if($num2>0){
  	 $raw = mysqli_fetch_assoc($result2);
     echo json_encode(array("register"=>$raw));
 		}
  }

else if($num3 == 1)
{
  echo"3";
}

else{
echo "4";
}

}




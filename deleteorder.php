<?php

session_start();

if($_SERVER["REQUEST_METHOD"]=="POST"){

	require 'connection.php';
	loginapp();

}

function loginapp(){

	global $connect;
 
$Order_number = $_POST["Order_number"];

$q1 = "SELECT * from `order` where `Order_number` = '$Order_number'";

$q2="DELETE FROM `order` WHERE `order`.`Order_number` = '$Order_number'";	


$result1 = mysqli_query($connect, $q1);

$num1 = mysqli_num_rows($result1);

if($num1 == 1){
if(mysqli_query($connect,$q2)){
echo"lol";
}
else{
	echo"lk";
}


}
}

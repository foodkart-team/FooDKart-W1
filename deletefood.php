<?php

session_start();

if($_SERVER["REQUEST_METHOD"]=="POST"){

	require 'connection.php';
	loginapp();

}

function loginapp(){

	global $connect;
 
$item_name = $_POST["item_name"];

$q1 = "SELECT * from `resfood` where `item_name` = '$item_name'";


$q2="DELETE FROM `resfood` WHERE `resfood`.`item_name` = '$item_name'";	

$result1 = mysqli_query($connect, $q1);

$num1 = mysqli_num_rows($result1);

if($num1 == 1){
echo"j";
if(mysqli_query($connect,$q2)){
echo"lol";
}


}
}

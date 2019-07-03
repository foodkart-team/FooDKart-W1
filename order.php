<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){

	require 'connection.php';
	createStudent();

}

function Createstudent(){
 
global $connect;

    $item_name = $_POST["item_name"];
	$no_of_items = $_POST["no_of_items"];
	$order_message = $_POST["order_message"];
	$Current_phn_num = $_POST["Current_phn_num"];
	$Current_Location = $_POST["Current_Location"];
  
  	$query1 = "INSERT INTO `order` ( `order_message`, `Current_phn_num`, `Current_Location`) VALUES ('".$order_message."','".$Current_phn_num."','".$Current_Location."')";
    
    $query2 = "INSERT INTO `item` ( `item_name`, `no_of_items`) VALUES ('".$item_name."','".$no_of_items."')";


   $sql1=mysqli_query($connect , $query1);
   $sql2=mysqli_query($connect,$query2);

   if(empty($item_name) || empty($no_of_items) || empty($order_message) || empty($Current_phn_num) || empty($Current_Location)){

   	echo"1";

   }
else{

	if($sql1 && $sql2){

		echo"okay";

	}

	else{

		echo"servererror";
	}
}
}

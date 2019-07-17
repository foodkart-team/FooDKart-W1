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
  
  	
  	$query1 = "INSERT INTO `order` ( `order_message`, `Current_phn_num`, `Current_Location`,`item_name`,`no_of_items`) VALUES ('".$order_message."','".$Current_phn_num."','".$Current_Location."','".$item_name."','".$no_of_items."')";
    
    $q="SELECT * FROM `resfood` where `item_name`='$item_name'";
	$sql=mysqli_query($connect,$q);
  
   
   if(empty($item_name) || empty($no_of_items) || empty($order_message) || empty($Current_phn_num) || empty($Current_Location))
   {
	echo"1";
	}
	else if(mysqli_num_rows($sql)==0)
	{
	echo"2";	
	} 
	else if(!ctype_digit($no_of_items)|| $no_of_items > 20)
	{
	echo"3";
	}
	else if(!preg_match("/^\d{10}+$/",$Current_phn_num))
	{
	echo"4";
	}
	else{				
		$sql1=mysqli_query($connect , $query1);
						if($sql1 )
						{
							echo"5";
						}
						else
						{
							echo"servererror";
						}
		}

}
		



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
    
    


  
   if(empty($item_name) || empty($no_of_items) || empty($order_message) || empty($Current_phn_num) || empty($Current_Location))
   {

   	echo"1";

   }
	else{
		$q="SELECT * FROM `resfood` where `item_name`='$item_name'";
		$sql=mysqli_query($connect,$q);
       
        if(mysqli_num_rows($sql)==0)
        {  	
			echo"nofood";	
		} 
		
		else{
				if(!is_numeric($no_of_items) || !is_numeric($Current_phn_num))
				{
					echo"notvalidin";
				}
				else{
						$sql1=mysqli_query($connect , $query1);
						if($sql1 )
						{
							echo"okay";
						}

						else
						{
							echo"servererror";
						}
				}
			}
		}

}

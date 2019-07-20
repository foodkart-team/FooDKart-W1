<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){

	require 'connection.php';
	addfood();

}


function addfood(){
 
global $connect;

    $item_name = $_POST["item_name"];
	$price = $_POST["price"];
	

  	$query1 = "INSERT INTO `resfood` ( `item_name`, `price`) VALUES ('".$item_name."','".$price."')";
    
    if(empty($item_name) || empty($price))
   {

   	echo"empty";

   }
	else{
		$q="SELECT * FROM `resfood` where `item_name`='$item_name'";
		$sql=mysqli_query($connect,$q);
       
        if(mysqli_num_rows($sql)>0)
        {  	
			echo"nofood";
			$query2 = "DELETE FROM `resfood` WHERE `resfood`.`item_no`='$item_no";
							$sql2=mysqli_query($connect,$query2);
	
		} 
		
		else{
						$sql1=mysqli_query($connect , $query1);
						if($sql1)
						{   
						    $item_no = mysqli_insert_id($connect);
													
						}

						
				}
			}
		

}

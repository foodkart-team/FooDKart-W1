<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){

	require 'connection.php';
	regres();

}


function regres(){
 
global $connect;

    $r_name = $_POST["r_name"];
	$r_email = $_POST["r_email"];
	$r_address = $_POST["r_address"];
	$r_phn_num = $_POST["r_phn_num"];
	$r_password = $_POST["r_password"];
  
  	
  	$query1 = "INSERT INTO `restaurant` ( `r_name`, `r_email`, `r_address`,`r_phn_num`,`r_password`) VALUES ('".$r_name."','".$r_email."','".$r_address."','".$r_phn_num."','".$r_password."')";
    
    if(empty($r_name) || empty($r_email) || empty($r_address) || empty($r_phn_num) || empty($r_password))
   {

   	echo"1";

   }
	else{
		$q="SELECT * FROM `restaurant` where `r_name`='$r_name'";
		$sql=mysqli_query($connect,$q);
       
        if(mysqli_num_rows($sql)>0)
        {  	
			echo"exist";	
		} 
		
		else{
						$sql1=mysqli_query($connect , $query1);
						if($sql1 )
						{
							echo"added";
						}

						else
						{
							echo"servererror";
						}
				}
			
		}

}

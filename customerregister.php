<?php


if($_SERVER["REQUEST_METHOD"]=="POST"){

	require 'connection.php';
	createStudent();

}
function createstudent()
{
    global $connect;

	$Customer_name = $_POST["Customer_name"];
	$Customer_email = $_POST["Customer_email"];
	$Customer_password = $_POST["Customer_password"];
	$Phone_number = $_POST["Phone_number"];
	$Address = $_POST["Address"];
	
	$query = "INSERT INTO `customer` (`Customer_id`, `Customer_name`, `Customer_email`, `Customer_password`, `Phone_number`, `Address`) VALUES (NULL,'".$Customer_name."','".$Customer_email."','".$Customer_password."','".$Phone_number."','".$Address."')";

	if(empty($Customer_name) || empty($Customer_email) || empty($Customer_password) || empty($Phone_number) || empty($Address)){
		echo "1";
	}
	else{
       $value = "select * from customer where Customer_email = '$Customer_email'";
       $query2 = mysqli_query($connect,$value);
       if(mysqli_num_rows($query2) > 0){

       echo"2";

       }
       else{
              
              if(mysqli_query($connect,$query)){

              	echo"3";

              }

              else{

              	echo"4";
              }
       }
	}


}

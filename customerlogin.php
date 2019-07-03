

<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){

	include 'connection.php';
	showStudent();

}

function showStudent(){

	global $connect;

	$Customer_email = isset($_POST["Customer_email"]);
	$Customer_password = isset($_POST["Customer_password"]);

    $query = "select * from customer where Customer_email = '$Customer_email' && Customer_password = '$Customer_password'";
	
	$result = mysqli_query($connect,$query);
	$number_of_rows = mysqli_num_rows($result);

	$temp_array = array();

	if($number_of_rows > 0){

		while($row = mysqli_fetch_assoc($result)){
			$temp_array[]= $row; 
		}
	}
header('content-Type: application/json');
echo json_encode(array("customer"=>$temp_array));
mysqli_close($connect);
}






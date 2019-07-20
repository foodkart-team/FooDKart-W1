

<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){

	include 'connection.php';
	addres();
	

}

function addres(){

	global $connect;
   

	$query = "SELECT * from restaurant";
     
	$result = mysqli_query($connect,$query);
    	
    $temp_array = array();

    
	if(mysqli_num_rows($result)>0){

while($row=mysqli_fetch_assoc($result)){
	$temp_array[]=$row;
     }
	}
header('content-Type: application/json');

echo json_encode(array("restaurant"=>$temp_array));
}




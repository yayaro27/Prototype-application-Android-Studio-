<?php

function connexionPDO(){
	$login = "root";
	$mdp = "";
	$bd = "mca";
	$serveur ="localhost";

	try{
		$conn = new PDO("mysql:host=".$serveur.";dbname=".$bd."", $login, $mdp);
		//echo "<h1>Connection réussie</h1>";
		return $conn;
	}catch (PDOException $e){
		print("erreur de connexionPDO");
		die();
	}

}



?>
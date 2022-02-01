
<?php
include "fonctions.php";



	try
	{
		
		$cox = connexionPDO();
		$req = $cox ->prepare("select nom,description,image from challenge");
		$req->execute();
		if($ligne = $req -> fetchAll(PDO::FETCH_ASSOC))
		{//ici c'est pas safe
			//var_dump($ligne);
			print(json_encode($ligne, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE | JSON_UNESCAPED_SLASHES | JSON_PARTIAL_OUTPUT_ON_ERROR));
		}
	}
	catch(PDOException $e)
	{
		print "Problème sur la page php".$e->getMessage();
		die();
	}


?>
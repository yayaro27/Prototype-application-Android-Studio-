
<?php
include "fonctions.php";





if(isset($_GET['message'])){
			$message=$_GET["message"];
			try{
				$cox = connexionPDO();
				$req = $cox ->prepare('insert into blog values("'.$message.'")');
				$req->execute();
				

			}catch(PDOException $e){
				print "Problème sur la page php".$e->getMessage();
				die();}
				
}
if (isset($_GET["recupmessage"]) && $_GET["recupmessage"]=="true") {
	$cox = connexionPDO();
	$res = $cox ->prepare('select message from blog');
				$res->execute();
				if($ligne["message"] = $res -> fetchAll(PDO::FETCH_ASSOC)){
				//var_dump($ligne);
				print(json_encode($ligne));}	
}
?>


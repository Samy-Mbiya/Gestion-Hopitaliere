<?php 
require ("../Connexion.php");

	if($_POST)
	{		
		$code=$_POST['code'];
		if($code=1)
		{
			//MISE A JOUR Consultation
			//************************
			$Id_consultation=$_POST['Id_consultation'];
			$S=$_POST['S'];
			$ATCD=$_POST['ATCD'];
			$HM=$_POST['HM'];
			$CA=$_POST['CA'];
			$E=$_POST['E'];
			$D=$_POST['D'];
			$rs=$conn->query("SELECT * FROM consultation WHERE $Id_consultation ='$Id_consultation'" );
			
			if($S!="" and $D!="" )// Champ non vide
			{
				if($rs->fetch()==null){ //Recherche reussie donc Mise a joure ou pas
					echo 'Le Consultation  n\'existe pas';
				}
				else{
					$req = $conn->prepare('UPDATE consultation SET Nom = :Nom_P, Post_nom = :Pnom_P, Prenom = :Prnom_P, Sexe = :S_P, DN = :Dn_P, EC = :Ec_P, Adresse = :Ad_P, Phone = :Ph_P, Profession = :Pr_P, Employeur = :Em_P WHERE id_pa = :id_P');
					$req->execute(array(
						'id_P'    =>$id_P,
						'Nom_P'   => $Nom_P,
						'Pnom_P'  => $Pnom_P,
						'Prnom_P' => $Prnom_P,
						'S_P'     =>$S_P,
						'Dn_P'    => $Dn_P,
						'Ec_P'    => $Ec_P,
						'Ad_P'    => $Ad_P,
						'Ph_P'    =>$Ph_P,
						'Pr_P'    => $Pr_P,
						'Em_P'    => $Em_P
					));
					
				}
				
			}
		
			}
			
		if($code=2)
		{
			//MISE A JOUR FICHE DE SURVELLANCE
			//********************************
			$id_sv=$_POST['Id_sv'];
			$id_sr=$_POST['Id_sur'];
			$id_p=$_POST['id_p'];
			$Date=$_POST['Dt'];
			$Heure=$_POST['H'];
			$T=$_POST['T'];
			$TAS=$_POST['TAS'];
			$TAD=$_POST['TAD'];
			$FC=$_POST['FC'];
			$FR=$_POST['FR'];
			$Pd=$_POST['Pd'];
			$Ob=$_POST['Ob'];
			$rs=$conn->query("SELECT * FROM  surveiller, sv WHERE surveiller.Id_surveiller='$id_sr' AND sv.Id_sv='$id_sv'" );
			
			if($T !="" and $TAS!="" and $FC !="" and $Pd!="" )// Champ non vide
			{
				if($rs->fetch()==null){ //Recherche reussie donc Mise a joure ou pas
					echo 'Le patient n\'existe pas';
				}
				else{
					
					$req = $conn->prepare('UPDATE sv SET TC = :TC_p, TAS = :TAS_p, TAD = :TAD_p, FC = :FC_p, FR = :FR_p, O = :O_p, Poid = :Poid_p WHERE Id_sv = :id_sv');
					$req->execute(array(
						'id_sv'    =>$id_sv,
						'TC_p'   => $T,
						'TAS_p'  => $TAS,
						'TAD_p'  => $TAD,
						'FC_p' => $FC,
						'FR_p'     =>$FR,
						'O_p'    => $Ob,
						'Poid_p'    => $Pd
						));
						
					/*$req2 = $conn->prepare('UPDATE surveiller SET Id_pr = :id_p, Id_sv = :id_sv, Date = :Date_sur, Heure = :Heure_sur WHERE Id_surveiller = :id_sr');
					$req->execute(array(
						'id_sr'    =>$id_sr,
						'id_sv'    =>$id_sv,
						'id_p'   => $id_p,
						'Date_sur'    =>$Date,
						'Heure_sur'   => $Heure
						));*/
						
						
				}
				
			}
		}//Fin code 2
		
		if($code=4){
					//Partie d l'enregistrement du LABO
					//**********************************
					if (isset($_POST['val'])){
						for ($i = 0, $c = count($_POST['val']); $i < $c; $i++)
						{
							$req = $conn->prepare('UPDATE labo SET Valeur = :Valeur WHERE  Id_la = :Id_la ');
							$req->execute(array(
								'Id_la'   => $_POST['lab'][$i],
								'Valeur'  => $_POST['val'][$i]
								));
						}
       			 	}
			}
  	}	
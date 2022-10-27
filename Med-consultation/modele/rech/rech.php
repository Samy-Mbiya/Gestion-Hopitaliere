<?php 
	
	if($_POST){
			require ("../Connexion.php") ;//Appel de la connexion
			
			//Recherche Patient
			$N_P=$_POST['N_P'];
			$PN_P=$_POST['PN_P'];
			$rs=$conn->query("SELECT * FROM patient WHERE Nom LIKE '%$N_P%' OR Post_nom LIKE '%$PN_P%' ");
			
			
			//Verification de l'utilisateur
			if($_POST['code']==1)
			{
				$N_u=$_POST['User'];
				$Pw_u=$_POST['Pw'];
				$rc=$conn->query("SELECT * FROM personnel WHERE Nom='$N_u' AND Mot_de_passe='$Pw_u'");
				$compt=$conn->query("SELECT COUNT(*) AS Id_pr FROM personnel WHERE Nom='$N_u' AND Mot_de_passe='$Pw_u' ");	
				$ts=$compt->fetch();
				$nb=$ts['Id_pr'];
				
					if($nb==1){// verification de l'existance et si la valeure est vide
						session_start();
        				$_SESSION['User'] = $_POST['User'];
						echo "<script type='text/javascript'>  document.location.replace('Liste_Patients.php');</script>";
						exit();
					}else{
						echo "Le Login ou le mot de passe est mal saisie!";
					}//Fin SI
			}
			
		if($_POST['code']==2)//Champ vide
		{
			 ?>
        
				 <table id="datatables-example" class="table table-striped table-bordered" width="100%" cellspacing="0">
					<thead>
							<tr>
							  <th>#</th>
							  <th>Nom</th>
							  <th>Post-Nom</th>
							  <th>Prenom</th>
							  <th>Modifier</th>
							  <th>Supprimer</th>
							</tr>
						</thead>
					<?php while ($p=$rs->fetch()) { ?>
					<tbody>
							<tr>
								<td>
									<a href="../vue/Patient.php?id_pa=<?php echo ($p['id_pa'])?>&Nom=<?php echo ($p['Nom'])?>&Post_nom=<?php echo ($p['Post_nom'])?>&Prenom=<?php echo ($p['Prenom'])?>&Sexe=<?php echo ($p['Sexe'])?>&DN=<?php echo ($p['DN'])?>&EC=<?php echo ($p['EC'])?>&Ad=<?php echo ($p['Adresse'])?>&Phone=<?php echo ($p['Phone'])?>&Prof=<?php echo ($p['Profession'])?>&EM=<?php echo ($p['Employeur'])?>"><?php echo ($p['id_pa'])?></a>
								  </td>
								<td>
									<a href="../vue/Patient.php?id_pa=<?php echo ($p['id_pa'])?>&Nom=<?php echo ($p['Nom'])?>&Post_nom=<?php echo ($p['Post_nom'])?>&Prenom=<?php echo ($p['Prenom'])?>&Sexe=<?php echo ($p['Sexe'])?>&DN=<?php echo ($p['DN'])?>&EC=<?php echo ($p['EC'])?>&Ad=<?php echo ($p['Adresse'])?>&Phone=<?php echo ($p['Phone'])?>&Prof=<?php echo ($p['Profession'])?>&EM=<?php echo ($p['Employeur'])?> "><?php echo ($p['Nom'])?></a>
								 </td>
								<td>
									<a href="../vue/Patient.php?id_pa=<?php echo ($p['id_pa'])?>&Nom=<?php echo ($p['Nom'])?>&Post_nom=<?php echo ($p['Post_nom'])?>&Prenom=<?php echo ($p['Prenom'])?>&Sexe=<?php echo ($p['Sexe'])?>&DN=<?php echo ($p['DN'])?>&EC=<?php echo ($p['EC'])?>&Ad=<?php echo ($p['Adresse'])?>&Phone=<?php echo ($p['Phone'])?>&Prof=<?php echo ($p['Profession'])?>&EM=<?php echo ($p['Employeur'])?>"><?php echo ($p['Post_nom'])?>
									</a>
								</td>
								<td><a href="../vue/Patient.php?id_pa=<?php echo ($p['id_pa'])?>&Nom=<?php echo ($p['Nom'])?>&Post_nom=<?php echo ($p['Post_nom'])?>&Prenom=<?php echo ($p['Prenom'])?>&Sexe=<?php echo ($p['Sexe'])?>&DN=<?php echo ($p['DN'])?>&EC=<?php echo ($p['EC'])?>&Ad=<?php echo ($p['Adresse'])?>&Phone=<?php echo ($p['Phone'])?>&Prof=<?php echo ($p['Profession'])?>&EM=<?php echo ($p['Employeur'])?>"><?php echo ($p['Prenom'])?></a>
								</td>
								<td>
									<a href="../vue/mj.php?id_pa=<?php echo ($p['id_pa'])?>&Nom=<?php echo ($p['Nom'])?>&Post_nom=<?php echo ($p['Post_nom'])?>&Prenom=<?php echo ($p['Prenom'])?>&Sexe=<?php echo ($p['Sexe'])?>&DN=<?php echo ($p['DN'])?>&EC=<?php echo ($p['EC'])?>&Ad=<?php echo ($p['Adresse'])?>&Phone=<?php echo ($p['Phone'])?>&Prof=<?php echo ($p['Profession'])?>&EM=<?php echo ($p['Employeur'])?>&code=1"> <button class="btn btn-mini btn btn-success" type="button"><i class="icon-edit"></i> Modifier</button>
                    </a>
                </td>
                <td>
                	<a href="../vue/sup.php?id_pa=<?php echo ($p['id_pa'])?>&Nom=<?php echo ($p['Nom'])?>&Post_nom=<?php echo ($p['Post_nom'])?>&Prenom=<?php echo ($p['Prenom'])?>&Sexe=<?php echo ($p['Sexe'])?>&DN=<?php echo ($p['DN'])?>&EC=<?php echo ($p['EC'])?>&Ad=<?php echo ($p['Adresse'])?>&Phone=<?php echo ($p['Phone'])?>&Prof=<?php echo ($p['Profession'])?>&EM=<?php echo ($p['Employeur'])?>&code=1"><button class="btn btn-mini btn btn-danger" type="button"><i class="icon-remove"></i>Supprimer</button>
                    </a>
								</td>
							</tr>
					<?php } ?>
							
						</tbody>
				</table>
<?php
		}
	}

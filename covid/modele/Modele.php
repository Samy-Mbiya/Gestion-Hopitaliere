<!-- AFFICHAGE DE PATIENT -->
<!-- -------------------- -->
<?php require ("Connexion.php") ?> <!-- Appel de la connexion -->

<!-- Affichage en SQL -->    
<?php 

	$rs=$conn->query('SELECT DISTINCT patient.id_pa, patient.Nom,patient.Post_nom, patient.Prenom  FROM patient, covid WHERE patient.id_pa = covid.Id_pa ORDER BY covid.Id_covid DESC LIMIT 0 , 25 ');
?>
<!-- Affichage de liste des Patient -->
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
                	<a href="../vue/Patient.php?id_pa=<?php echo ($p['id_pa'])?>"><?php echo ($p['id_pa'])?></a>
                  </td>
                <td>
                	<a href="../vue/Patient.php?id_pa=<?php echo ($p['id_pa'])?> "><?php echo ($p['Nom'])?></a>
                 </td>
                <td>
                	<a href="../vue/Patient.php?id_pa=<?php echo ($p['id_pa'])?>"><?php echo ($p['Post_nom'])?>
                    </a>
                </td>
                <td><a href="../vue/Patient.php?id_pa=<?php echo ($p['id_pa'])?>"><?php echo ($p['Prenom'])?></a>
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



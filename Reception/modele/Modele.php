<!-- AFFICHAGE DE PATIENT -->
<!-- -------------------- -->
<?php require ("Connexion.php") ?> <!-- Appel de la connexion -->

<!-- Affichage en SQL -->    
<?php 

	$rs=$conn->query('SELECT * FROM patient ORDER BY id_pa DESC LIMIT 0 , 15 ');
?>
<!-- Affichage de liste des Patient -->
 <table id="datatables-example" class="table table-striped table-bordered" width="100%" cellspacing="0">
	<thead>
            <tr>
              <th>#</th>
              <th>Nom</th>
              <th>Post-Nom</th>
              <th>Prenom</th>
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
            </tr>
	<?php } ?>
        </tbody>
</table>



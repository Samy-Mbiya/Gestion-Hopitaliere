<!-- AFFICHAGE DE PATIENT POUR TEST COVID -->
<!-- -------------------- -->
<?php require("Connexion.php") ?>
<!-- Appel de la connexion -->

<!-- Affichage en SQL -->
<?php

$rs = $conn->query("SELECT  DISTINCT patient.id_pa, patient.Nom, patient.Post_nom, patient.Prenom FROM covid, patient WHERE (patient.id_pa = covid.Id_pa) AND (covid.resultat='') ORDER BY covid.Id_covid LIMIT 25" );
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
  <?php while ($p = $rs->fetch()) { 
    ?>
    <tbody>
      <tr>
        <td>
          <a href="../vue/Patient_covid.php?id_pa=<?php echo ($p['id_pa']) ?>&Nom=<?php echo ($p['Nom']) ?>&Post_nom=<?php echo ($p['Post_nom']) ?>&Prenom=<?php echo ($p['Prenom']) ?>"><?php echo ($p['id_pa']) ?></a>
        </td>
        <td>
          <a href="../vue/Patient_covid.php?id_pa=<?php echo ($p['id_pa']) ?>&Nom=<?php echo ($p['Nom']) ?>&Post_nom=<?php echo ($p['Post_nom']) ?>&Prenom=<?php echo ($p['Prenom']) ?> "><?php echo ($p['Nom']) ?></a>
        </td>
        <td>
          <a href="../vue/Patient_covid.php?id_pa=<?php echo ($p['id_pa']) ?>&Nom=<?php echo ($p['Nom']) ?>&Post_nom=<?php echo ($p['Post_nom']) ?>&Prenom=<?php echo ($p['Prenom']) ?>"><?php echo ($p['Post_nom']) ?>
          </a>
        </td>
        <td><a href="../vue/Patient_covid.php?id_pa=<?php echo ($p['id_pa']) ?>&Nom=<?php echo ($p['Nom']) ?>&Post_nom=<?php echo ($p['Post_nom']) ?>&Prenom=<?php echo ($p['Prenom']) ?>"><?php echo ($p['Prenom']) ?></a>
        </td>
      </tr>
    <?php } ?>
    </tbody>
</table>
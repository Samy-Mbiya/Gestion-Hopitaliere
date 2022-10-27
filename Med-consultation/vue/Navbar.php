	
	<?php
	// verification de la connexion
    session_start(); 
    if (!isset($_SESSION['User'])) {
   		echo "<script type='text/javascript'>  document.location.replace('index.php');</script>";
       exit(); 
    } 
    ?>
    <div class="container">
    <!-- Menu
    ================================================== -->
    <div class="row">
      <div class="span3 bs-docs-sidebar" id="non-print">
        <ul class="nav nav-list bs-docs-sidenav affix-top"  >
		  <li><a href="#"><i class="icon-chevron-right"></i>Bienvenue Docteur <?php echo htmlentities(trim($_SESSION['User'])); ?></a></li>
		  <li><a href="Liste_Patients.php"><i class="icon-chevron-right"></i>Liste des Patients</a></li>
		  <li><a href="Enregistrement.php"><i class="icon-chevron-right"></i>Nouveau Patients</a></li>
      <li><a href="deconnexion.php"><i class="icon-chevron-right"></i> Deconnexion</a></li>
        </ul>
      </div>

<?php
	require (".../vue/Head.php");
	require (".../vue/Navbar.php");
	require (".../modele/Connexion.php");
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header">
            <h1>Information du Patient</h1>
          </div> 
          <div class="bs-docs-example">
		  
          <!-- Information du patient-->
            <?php 
				require ("Info_ Patient.php");
				$id=$_GET['id_pa'];
              	$id_tr=$_GET['Id_T'];
				$aff=$conn->query("SELECT * FROM traitement WHERE Id_tr='$id_tr'");
			?>
            <div class="bs-docs-example" id="IFP" >
			 Prescription faite par Docteur <b><?php echo $_GET['Pr']?></p>
            <div id="myTabContent" class="tab-content" >
				<h2>Cardexe de soin</h2>
            	<div>
					<?php 
						while($t=$aff->fetch()){
							$t['Id_tr'];
						}
					?>
				</div>
            </div>
          </div>
         </div>
        </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
 
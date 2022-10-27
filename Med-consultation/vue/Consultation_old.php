<?php
	require 'Head.php';
	require 'Navbar.php';
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
              	$id_consultation=$_GET['Id_consultation'];
				$aff1=$conn->query("SELECT * FROM  consultation, personnel WHERE consultation.Id_pa='$id' AND consultation.Id_pr=personnel.Id_pr AND consultation.Id_consultation='$id_consultation' ORDER BY consultation.Id_consultation DESC ");
			?>
          
            <div id="NCAff"></div><!-- Enregistrement de la consultation -->
            
            <div class="bs-docs-example" id="IFP" >
            
			<p ><a href="Patient.php?id_pa=<?php echo $id ?>"><i class="icon-fast-backward"></i>Retour</a></p> 
			 Consultation faite par Docteur <b><?php echo $_GET['Pr']?></b> le <?php echo $_GET['date'].' vers '.$_GET['heure'] ?></p>
            <div id="myTabContent" class="tab-content" >
             
			
                <p>
                  <h4><u>Résultat COVID</u></h4> 
                  <!-- Information Examen Pratique --> 
                  <?php 
                    $aff2=$conn->query("
                    SELECT * FROM labo WHERE Id_pa='$id' AND Id_cons='$id_consultation'");
                  ?>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Nom de l'examen</th>
                        <th>Type de l'examen</th>
                        <th> Valeur labo</th>
                      </tr>
                    </thead>
                    <tbody>
                     <?php while($t=$aff2->fetch()) {?>
                      <tr>
                        <td><?php echo $t['Nom_ex']; ?></td>
                        <td><?php echo $t['Type_ex']; ?></td>
                        <td><?php echo $t['Valeur']; ?></td>
						<td></td>
                      </tr>
                     <?php } ?>
					
                    </tbody>
                  </table>
                </p>
              </div>
			  
			  
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
 
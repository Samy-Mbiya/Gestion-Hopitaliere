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
            require 'Info_ Patient.php';
            $user=$_SESSION['User'];
            ?>

          
            <div id="NCAff"></div><!-- Enregistrement de la consultation -->
            
            <div class="bs-docs-example" id="IFP" >
              
              <div  >
                 <!-- Covid
                  +++++++++++++++++++-->
                  <!-- Liste des examens-->
                <p>
                	<?php $aff1=$conn->query("SELECT * FROM  covid WHERE covid.Id_pa='$id'  ORDER BY covid.Id_covid DESC "); ?>
                  <h2>Liste des resultats</h2>
                  
                  <a href="Labo.php?id_pa=<?php echo "$id" ?>&user=1">
                    <button type="submit" class="btn btn-primary" id="covidNnew"><i class="icon-ok-sign"></i>New</button>
                  </a>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>N°</th>
                        <th>Date</th>
                        <th>Resultat</th>
                        <th>Demandeur</th>
                        <th>Laborantin</th>
                        <th>Imprimer</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                    	<?php while($p=$aff1->fetch()) {?>
                          <tr>
                          <td>
                                <?php echo $p['Id_covid'] ?>
						            	  </td>
                            <td>
                                <?php echo $p['date'] ?>
						            	  </td>
                            <td>
                                <?php 
                                 echo $p['resultat'];
                                ?>
							              </td>
                            <td> 
                                <?php 
                                  echo $p['id_user_rec'];
                                ?>
							              </td>
                            <td>
                                <?php 
                                  echo $p['id_user_labo'];
                                ?>
							              </td>
                            <td>
                            <?php 
                              $resultat= $p['resultat'];
                                 if ($resultat !="")
                                  {
                             ?>
                                    <a href="Resultat_covid.php?id_pa=<?php echo "$id" ?>&Id_covid=<?Php echo $p['Id_covid']?>">
                                      <button type="submit" class="btn btn-primary" id="QR_CODE" ><i class="icon-print"></i>
                                        Imprimer
                                      </button>
                                    </a>
                              <?php

                                  }

                                ?>
								              <a href="">                                
								              </a>
							              </td>
                          </tr>
                      	<?php }?>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                    </tbody>
                  </table>
                </p>
              
            </div>
          </div>
         </div>
        </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
 
<?php
  require 'Head.php';
  require 'Navbar.php';
  ?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header" >
            <h1>Suppression des information du Patient</h1>
          </div>
          <div class="bs-docs-example">

          <!-- Suppression  -->
          <div id="message"></div>
          <div id="Pat"></div>
          <div id="form_pat"></div>
          <?php 
					$code=$_GET['code'];
					$id=$_GET['id_pa'];
					$aff=$conn->query("SELECT * FROM  patient WHERE id_pa='$id'");
				?>
     
          <form method="post" >     	
                <?php
					if($code==1)
						{
				?>  		<!-- SUPPRESSION DU PATIENT -->
                            <table class="table-hover">
                              <tbody>
                                <tr>
                                  <td>Nom</td>
                                  <td><?php echo $_GET['Nom']?></td>
                                  <td></td>
                                </tr>
                                <tr>
                                  <td>Post Nom</td>
                                  <td><?php echo $_GET['Post_nom']?></td>
                                  <td></td>
                                </tr>
                                <tr>
                                  <td>Presnom</td>
                                  <td><?php echo $_GET['Prenom']?></td>
                                  <td></td>
                                </tr>
                                <tr>
                                   <td>Sexe</td>
                                   <td><?php echo $_GET['Sexe']?></td>
                                   <td></td>
                                </tr>
                                <tr>
                                  <td>Ne</td>
                                  <td><?php echo  $_GET['DN']?></td>
                                  <td></td>
                                </tr>
                                <tr>
                                  <td>Etat Civil</td>
                                  <td><?php echo $_GET['EC']?></td>
                                  <td></td>
                                  <td></td>
                                </tr>
                                 <tr>
                                  <td>Adresse</td>
                                  <td><?php echo $_GET['Ad']?></td>
                                  <td></td>
                                </tr>
                                <tr>
                                   <td>Phone</td>
                                   <td><?php echo $_GET['Phone']?></td>
                                   <td></td>
                                </tr>
                                <tr>
                                  <td>Profession</td>
                                  <td><?php echo $_GET['Prof']?></td>
                                  <td></td>
                                </tr>
                                <tr>
                                  <td>Emploiyeur</td>
                                  <td><?php echo $_GET['EM']?></td>
                                  <td></td>
                                </tr>
                                <tr>
                                  <td></td>
                                  <td style="padding-left: 50px;"><a href="Liste_Patients.php"><button type="submit" class="btn btn-primary" id="SP"><i class="icon-ok-sign"></i> Supprimer</button></a></td>
                                  <td></td>
                                </tr>
                                <tr>
                                	<td><input type="text" name="code" id="code"  value="<?php echo $_GET['code']?>" class="input-xlarge" type="text"  style="visibility:collapse"/></td>
                                    <td><input type="text" name="ID_P" id="ID_P"  value="<?php echo $_GET['id_pa']?>" class="input-xlarge" type="text" style="visibility:collapse"/></td>
                                  <td></td>
                                </tr>
                              </tbody>
                            </table>
                         </form>
                         
                            <!-- SUPPRESSION DE FICHE DE SURVEILLANCE -->
                       <?php }
					   		if($code==2)
							{?>
                            	<form method="post">
								<table class="table-hover">
								  <tbody>
                                    <tr>
									  <td>Date :</td>
									  <td><?php echo $_GET['Date']?></td>
									  <td></td>
									</tr>
									<tr>
									  <td>Heure :</td>
									  <td><?php echo $_GET['Heure']?></td>
									  <td></td>
									</tr>
									<tr>
									  <td>T :</td>
									  <td><?php echo $_GET['TC']?></td>
									  <td></td>
									</tr>
									<tr>
									  <td>TA :</td>
									  <td><?php echo $_GET['TA']?></td>
									  <td></td>
									</tr>
									<tr>
									   <td>FC :</td>
									   <td><?php echo $_GET['FC']?></td>
									   <td></td>
									</tr>
									<tr>
									  <td>FR</td>
									  <td><?php echo  $_GET['FR']?></td>
									  <td></td>
									</tr>
									<tr>
									  <td>PoidS :</td>
									  <td><?php echo $_GET['Poid']?></td>
									  <td></td>
									  <td></td>
									</tr>
									 <tr>
									  <td>Observation</td>
									  <td><?php echo $_GET['O']?></td>
									  <td></td>
									</tr>
									<tr>
									  <td></td>
									  <td style="padding-left: 50px;"><a href="Liste_Patients.php"><button type="submit" class="btn btn-primary" id="SFS"><i class="icon-ok-sign"></i> Supprimer</button></a></td>
									  <td></td>
									</tr>
                                    <tr>
                                    	<td><input type="text" name="id_pa" id="id_pa"  value="<?php echo $_GET['id_pa']?>" class="input-xlarge" type="text"  style="visibility:collapse"/></td>
										<td><input type="text" name="Id_sur" id="Id_sur"  value="<?php echo $_GET['Id_sur']?>" class="input-xlarge" type="text" style="visibility:collapse"/></td>
									  	<td><input type="text" name="code" id="code"  value="<?php echo $_GET['code']?>" class="input-xlarge"  style="visibility:collapse"/></td>
									 	<td><input type="text" name="Id_sv" id="Id_sv"  value="<?php echo $_GET['Id_sv']?>" class="input-xlarge" type="text"  style="visibility:collapse"/></td>
									</tr>
								  </tbody>
								</table>	
							<?php	}
					   ?>
            </div>
          </form>
          </div>
         </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
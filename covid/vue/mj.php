<?php
  require 'Head.php';
  require 'Navbar.php';
  
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header" >
            <h1>Modification des information du Patient</h1>
          </div>
          <div class="bs-docs-example">
          
          <!-- MISE A JOUR  -->
    
          <div id="message"></div>
          <div id="Pat"></div>
          <?php $code=$_GET['code']?>
		  <?php if ($code==1) {?>
          
          <!-- Mise a Jour Patient  -->
          <form method="post" id="p_mj"  >
          	<div id="form_pat" >  
            <table class="table-hover">
              <tbody>
              <tr>
                  <td><input type="text" name="ID_P" id="ID_P"  value="<?php echo $_GET['id_pa']?>" class="input-xlarge" type="text" style="visibility:collapse"/></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Nom</td>
                  <td><input type="text" name="N_P" id="N_P" value="<?php echo $_GET['Nom']?>" class="input-xlarge" type="text" /></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Post Nom</td>
                  <td><input type="text" name="PN_P" id="PN_P" value="<?php echo $_GET['Post_nom']?>" class="input-xlarge" type="text" /></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Presnom</td>
                  <td><input type="text" name="PRN_P" id="PRN_P" value="<?php echo $_GET['Prenom']?>" class="input-xlarge" type="text" /></td>
                  <td></td>
                </tr>
                <tr>
                   <td>Sexe</td>
                   <td><input type="text" name="S_P"  id="S_P" value="<?php echo $_GET['Sexe']?>" class="input-xlarge" type="text" /></td>
                   <td></td>
                </tr>
                <tr>
                  <td>Ne</td>
                  <td><input type="date" name="DN_P"  id="DN_P" value="<?php echo  $_GET['DN']?>" class="input-xlarge" type="text" /></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Etat Civil</td>
                  <td><input type="text" name="EC_P" id="EC_P" class="input-xlarge" value="<?php echo $_GET['EC']?>" type="text" placeholder=""/></td>
                  <td></td>
                  <td></td>
                </tr>
                 <tr>
                  <td>Adresse</td>
                  <td><input type="text" name="A_P" id="A_P" value="<?php echo $_GET['Ad']?>" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                   <td>Phone</td>
                   <td><input type="tel" name="PH_P" id="PH_P" value="<?php echo $_GET['Phone']?>" class="input-xlarge" type="text" placeholder=""/></td>
                   <td></td>
                </tr>
                <tr>
                  <td>Profession</td>
                  <td><input type="text" name="PR_P" id="PR_P" value="<?php echo $_GET['Prof']?>" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Emploiyeur</td>
                  <td><input type="text" name="E_P" id="E_P" value="<?php echo $_GET['EM']?>" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td style="padding-left: 50px;"><a href=""><button type="submit" class="btn btn-primary" id="MP"><i class="icon-ok-sign"></i> Modifier</button></a></td>
                  <td></td>
                </tr>
              </tbody>
            </table>
            <input type="text" name="code" id="code" value="<?php echo $code ?>" style="visibility:collapse"/> 
            </div>
          </form>
         <?php 
		 }// Fin Si pour Patient
		 
		 
		 if($code==2)
		 {	
		?>
        	
        	<!-- Mise a Jour Fiche de surveillance  -->
         	<form method="post" >
         		<table>
         			<tbody>
                        <tr>
                        	<td>Date :</td>
                            <td><input   type="text" value="<?php echo $_GET['Date']?>" id="Date"  name="Dt" /></td>
                         </tr>
                         <tr>
                        	<td>Heure :</td>
                            <td><input   type="text" value="<?php echo $_GET['Heure']?>" id="Heure"  name="H" /></td>
                         </tr>
                         <tr>
                        	<td>T :</td>
                            <td><input  type="text" value="<?php echo $_GET['TC']?>" id="T" name="T"></td>
                          </tr>
                          <tr>
                          	<td>TAS :</td>
                            <td><input type="text" value="<?php echo $_GET['TAS']?>" id="TAS" name="TAS"></td>
                          </tr>
						   <tr>
                          	<td>TAD :</td>
                            <td><input type="text" value="<?php echo $_GET['TAD']?>" id="TAD" name="TAD"></td>
                          </tr>
                          <tr>
                          	<td>FC :</td>
                            <td><input  type="text" value="<?php echo $_GET['FC']?>" id="FC" name="FC"></td>
                          </tr>
                          <tr>
                          	<td>FR :</td>
                            <td><input type="text" value="<?php echo $_GET['FR']?>" id="FR" name="FR"></td>
                          </tr>
                          <tr>
                          	<td> Poids :</td>
                            <td><input type="text" value="<?php echo $_GET['Poid']?>" id="Poids" name="Pd"></td>
                          </tr>
                          <tr>
                          	<td>Observation</td>
                            <td><input  type="text" value="<?php echo $_GET['O']?>" id="Ob" name="Ob"></td>
                          </tr>
                          <tr>
                          	<td></td>
                            <td><button class="btn btn-primary" id="FS_M"><i class="icon-ok-sign"></i> Modification</button></td>
                          </tr>
                       </tbody>
                     </table>
                     <input style="width:10px; visibility:collapse" value="<?php echo $_GET['Id_pa'] ?>"  name="Id_pa" id="Id_p"/>
                     <input style="width:10px; visibility:collapse" value="<?php echo $_GET['Id_sv'] ?>"  name="Id_sv"/>
                     <input style="width:10px; visibility:collapse" value="<?php echo $_GET['Id_sur'] ?>"  name="Id_sur"/> 
                      
       		 	</form> 
			<?php }
		 ?>
          </div>
         </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
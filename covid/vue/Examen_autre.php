<?php
	require 'Head.php';
	require 'Navbar.php';
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header">
            <h1>Examen du Patient</h1>
          </div> 
          <div class="bs-docs-example">

          <!-- Information du patient-->
           <?php require ("Info_ Patient.php");?>
			<?php 
				//Nombre d'enregistrement de la table sv
				$req1=$conn->query('SELECT COUNT(*) AS Id_consultation FROM consultation');
				$resul=$req1->fetch();
				$nb=$resul['Id_consultation'];
			?>
			<div id="message"></div>
            <div class="bs-docs-example" id="IFP" >
			<ul id="myTab" class="nav nav-tabs">
              <li class="active"><a href="#s" data-toggle="tab">Echographiee</a></li>
              <li><a href="#u" data-toggle="tab">Radio</a></li>
            </ul>
           	 <div id="myTabContent" class="tab-content" >
              <div class="tab-pane fade in active" id="s">
			   <!-- Echographie
                  +++++++++++++++++++-->
                <p>
				<div id="message"></div>
				<table>
                  	<tr>
                        <form method="post" >
                        	<?php 
								$date=date("d/m/Y");
								$heure=date("H:i");
							?>
                            <td><input  class="input-mini" type="text" placeholder="<?php echo $date; ?>" id="Date" value="<?php echo $date ?>" name="Dt" /></td>
                            <td><input  class="input-mini-samy" type="text" placeholder="<?php echo $heure; ?>" id="Heure" value="<?php echo $heure ?>" name="H" /></td>
                            <td><input class="input-mini-samy" type="text" placeholder="T" id="T" name="T"></td>
                            <td><input class="input-mini-samy" type="text" placeholder="TAS" id="TAS" name="TAS"></td>
							<td><input class="input-mini-samy" type="text" placeholder="TAD" id="TAD" name="TAD"></td>
                            <td><input class="input-mini-samy" type="text" placeholder="FC" id="FC" name="FC"></td>
                            <td><input class="input-mini-samy" type="text" placeholder="FR" id="FR" name="FR"></td>
                            <td><input class="input-mini-samy" type="text" placeholder="Poids" id="Poids" name="Pd"></td>
                            <td><input  type="text" placeholder="Observation" id="Ob" name="Ob"></td>
                            <td><button class="btn btn-primary" id="FS_ER"><i class="icon-ok-sign"></i> Enregistrer</button></td>
                            <td><input style="width:10px; visibility:collapse" value="<?php echo $id ?>"  name="id_p" id="id_pp"/></td>
                            <td><input style="width:10px; visibility:collapse" value="2"  name="code" id="code"/></td>
                        </form>
                      </tr>
                  </table>
				</p>
              </div>
				
			<div class="tab-pane fade" id="u">
            	<p>
					<!-- RADIO
                  +++++++++++++++++++-->
				  		
					  		<table class="table">
								<tbody>
								  <tr>
									<td><input type="checkbox" value="UriSed" name="option[]"  id="Sed"  style="margin-bottom:5px"/>  Sed</td>
									<td><input type="checkbox" value="UriSucre" name="option[]"  id="Sucre"  style="margin-bottom:5px"/>  Sucre</td>
									<td><input type="checkbox" value="UriAlb" name="option[]"  id="Alb"  style="margin-bottom:5px"/>  Alb</td>
									<td><input type="checkbox" value="UriGram" name="option[]"  id="Gram"  style="margin-bottom:5px"/>  Gram</td>
									<td><input type="checkbox" value="UriTest_grossesse" name="option[]"  id="Test_grossesse"  style="margin-bottom:5px"/>  Test grossesse</td>
								  </tr>
								  <tr>
									<td><input type="checkbox" value="UriCombur_test" name="option[]"  id="Combur_test"  style="margin-bottom:5px"/>  Combur test</td>
									<td><input type="text" name="autre[]"  id="Autre"  placeholder="Autre"/> </td>
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
 
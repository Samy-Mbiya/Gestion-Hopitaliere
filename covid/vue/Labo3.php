
<?php
  require 'Head.php';
  require 'Navbar.php';
  
?><title>Document sans titre</title>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns"> 
			<div class="page-header">
            	<h1>Laboratoire </h1>
          	</div> 
          <div class="bs-docs-example">
	
			  <!-- Information du patient-->
				<?php require ("Info_ Patient.php");?>
			  <!-- Information de la Consultation -->
			  <?php 
					$id=$_GET['id_pa'];
					$Id_con=$_GET['Id_con'];
					//$aff1=$conn->query("SELECT * FROM consultation WHERE CAT='EP' AND Id_pa='$id'");
				 ?>
				<div class="bs-docs-example" align="left"> 
				<div id="message"></div>
				<form method="post">
					<table class="table-hover">
					  <tbody>
						</tr>
					  <?php //while($p=$aff1->fetch()) {
					  		//$Id_con=$p['Id_consultation'];
					  		$aff2=$conn->query("SELECT * FROM labo WHERE Id_pa='$id' AND Id_cons='$Id_con' AND Valeur='' ");
								while($t=$aff2->fetch()) {
					  ?>
									<tr>
										<td>
											<label><?php echo $t['Nom_ex'] ?>/<?php echo $t['Type_ex'] ?> </label>
										</td>
										<td>
											<input type="text" name="val[]" id="val"/>
											<input style="width:10px; visibility:collapse" value="4"  name="code" id="code"/><input style="width:10px; visibility:collapse" value="<?php echo $t['Id_la'] ?>"  name="lab[]" id="id_lab"/>
										</td>
									</tr>
							<?php } ?>
						<?php //} ?>
					 </tbody>
				  	</table>
					<div align="right"><button class="btn btn-primary" id="Er_Labo"><i class="icon-ok-sign"></i> Valider</button></div>
				</form>	  
           	</div>
         </div>
       </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
 
<?php 
	require 'Head.php';
	require 'Navbar.php';
	$user=$_SESSION['User'];
	$rs=$conn->query("SELECT * FROM  personnel WHERE Nom='$user' ");
?>
 <div class="span9">
 <section id="dropdowns">
 	<!-- Nouvelle consultation-->
	<div class="page-header">
    	<h3>Nouvelle Consultation</h3>
    </div> 
	<div class="bs-docs-example">
		<!-- Information du patient-->
		<?php 
			require 'Info_ Patient.php';
			$id=$_GET['id_pa'];
            $id_consultation=$_GET['Id_consultation'];
			$aff1=$conn->query("SELECT * FROM  consultation, personnel WHERE consultation.Id_pa='$id' AND consultation.Id_pr=personnel.Id_pr AND consultation.Id_consultation='$id_consultation' ORDER BY consultation.Id_consultation DESC ");
			?>
	</div>
 	<div class="bs-docs-example">
		<p ><a href="Patient.php?id_pa=<?php echo $id ?>"><i class="icon-fast-backward"></i>Retour</a></p>
		<p> Consultation faite par Docteur <b><?php echo $_GET['Pr']?></b> le <?php echo $_GET['date'].' vers '.$_GET['heure'] ?></p>
	
        	<form method="post">
                <table class="table-hover">
                  <tbody>
				  	 <?php while($p=$aff1->fetch()) {?>
                    <tr>
                      <td><textarea rows="5"  id="S"  name="S"><?php echo $p['s']?></textarea></td>
                      <td width="10px"></td>
                      <td><textarea rows="5" placeholder="ATCD" id="ATCD" name="ATCD"><?php echo $p['ATCD']?></textarea></td>
					  <td width="10px"></td>
                      <td><textarea rows="5" placeholder="Histoire de la maladie" id="HM" name="HM" ><?php echo $p['HMA']?></textarea></td>
                    </tr>
                    <tr>
					 <td><textarea rows="5" placeholder="Complement d'anamnese" id="CA" name="CA" ><?php echo $p['CA']?></textarea></td>
					 <td width="10px"></td>
                      <td><textarea rows="5" placeholder="Examen physique" id="E" name="E"><?php echo $p['EP']?></textarea></td>
                      <td width="10px"></td>
                      <td><textarea rows="5" placeholder="Diagnostique" id="D" name="D"><?php echo $p['A']?></textarea></td>
					  <input style="width:10px; visibility:collapse" value="<?php echo $p['Id_consultation']?>"  name="Id_consultation" id="Id_consultation"/>
                    </tr>
					<?php } ?>
                  </tbody>
                </table>
				<div class="bs-docs-example">
                            <?php while($p=$rs->fetch()) {
								echo "Consultation modifier par Docteur ". $p['Nom'];
								if($p['Nom']==$user){
									$code=1;
								}
							?>
								<input style="width:10px; visibility:collapse" value="<?php echo $code;?>"  name="code" id="code"/>
                       			<input style="width:10px; visibility:collapse" value="<?php echo $p['Id_pr']?>"  name="Pr" id="Pr"/>
								<?php 
									$jour=date('d');
									$jour_cons=substr($_GET['date'],0,2);
									$jours= $jour-$jour_cons;
									//echo $jour;
									echo $jours;
								?>
								<input style="width:10px; visibility:collapse" value="<?php echo $jours ?>"  name="J" id="J"/>
								<input style="width:10px; visibility:collapse" value="<?php echo $p['Nom'] ?>"  name="Nom_Med" id="Nom_Med"/>
                           <?php  }?>
                          <input style="width:10px; visibility:collapse" value="1"  name="id_p" id="id_p"/>
                          <button type="submit" class="btn btn-primary" id="Mj" ><i class="icon-ok-sign"></i>Modification</button>
						  
                </div>
              </form>
     </div>
</section>
</div>
    </div>
  </div>
<?php
  require 'Footer.php';
 
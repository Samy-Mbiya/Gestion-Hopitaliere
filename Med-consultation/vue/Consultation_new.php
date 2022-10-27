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
		<table>
			<tr>
				<td>
					<!-- Information du patient-->
					<?php require 'Info_ Patient.php';?>
				</td>
				<td width="30%"> </td>
			</tr>
		</table>
	</div>
 	<div class="bs-docs-example">
		<p ><a href="Patient.php?id_pa=<?php echo $id ?>"><i class="icon-fast-backward"></i>Retour</a></p>
		
        	<form method="post">
                <table class="table-hover">
                  <tbody>
                    <tr>
                      <td>
                      	<input type="text" id="S" name="S" value="Symtome dominant" />
                      </td>
                      <td width="10px">
                      </td>
                      <td><input type="text" id="ATCD" name="ATCD" value="ATCD" /></td>
					  <td width="10px"></td>
                      <td><input type="text" id="HM" name="HM" value="Histoire de la maladie"/></td>
                    </tr>
                    <tr>
					 <td><input type="text" id="CA" name="CA" value="Complement d'anamnese" /></td>
					 <td width="10px" /></td>
                      <td><input type="text" id="E" name="E" value="Examen physique" /></td>
                      <td width="10px"></td>
                      <td><input type="text" placeholder="Diagnostique" id="D" name="D"value="Diagnostique" /></td>
                      <td><input style="width:10px; visibility:collapse" value="3"  name="code" id="code"/></td>
					  <td></td>
                    </tr>
                  </tbody>
                </table>
				<div class="bs-docs-example">
                            <?php while($p=$rs->fetch()) {
							echo "Consultation faite par Docteur ". $p['Nom'];
							?>
								
                       			<input style="width:10px; visibility:collapse" value="<?php echo $p['Id_pr']?>"  name="Pr" id="Pr"/>
                           <?php  }?>
                          </select>
                          <select id="ES" name="ES">
                          	<option value="EP">Laboratoire</option>
                          </select>
                          <input style="width:10px; visibility:collapse" value="<?php echo $id ?>"  name="id_p" id="id_p"/>
                          <button type="submit" class="btn btn-primary" id="ErC" ><i class="icon-ok-sign"></i>Enregistrer </button>
						  
                </div>
              </form>
     </div>
</section>
</div>
    </div>
  </div>
<?php
  require 'Footer.php';
 
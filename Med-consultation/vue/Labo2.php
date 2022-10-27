
<?php
  require 'Head.php';
  require 'Navbar.php';
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns"> 
			<div class="page-header">
            	<h1>Liste des examens de labo </h1>
          	</div> 
          <div class="bs-docs-example">
			  <?php 
					$aff1=$conn->query("SELECT DISTINCT patient.id_pa, patient.Nom, patient.Post_nom,patient.Sexe, patient.DN, consultation.Date,consultation.Heure, consultation.Id_consultation FROM  consultation, patient, labo WHERE labo.Id_pa=patient.id_pa AND labo.Id_cons=consultation.Id_consultation AND labo.Valeur=''");
				 ?>
				<div class="bs-docs-example" align="left">            
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Numero</th>
						<th>Nom</th>
						<th>Post Nom</th>
						<th>Sexe</th>
						<th>Age</th>
						<th>Date</th>
						<th>Heure</th>
                      </tr>
                    </thead>
                    <?php
						 $i=1;
					 while($p=$aff1->fetch()) {?>
                    <tbody>
                      <tr>
                      	<td><a href="Labo3.php?id_pa=<?php echo $p['id_pa'] ?>&Id_con=<?php echo $p['Id_consultation']?>"><?php echo $i++ ?></a></td>
						<td><a href="Labo3.php?id_pa=<?php echo $p['id_pa'] ?>&Id_con=<?php echo $p['Id_consultation']?>"><?php echo $p['Nom'] ?></a></td>
						<td><a href="Labo3.php?id_pa=<?php echo $p['id_pa'] ?>&Id_con=<?php echo $p['Id_consultation']?>"><?php echo $p['Post_nom'] ?></a></td>
						<td><a href="Labo3.php?id_pa=<?php echo $p['id_pa'] ?>&Id_con=<?php echo $p['Id_consultation']?>"><?php echo $p['Sexe'] ?></a></td>
						<td><?php 
								$ans=date('Y');
								$pp=substr($p['DN'],6);
								$age= $ans-$pp;
								echo $age;
									
						 ?></td>
						 <td><a href="Labo3.php?id_pa=<?php echo $p['id_pa'] ?>&Id_con=<?php echo $p['Id_consultation']?>"><?php echo $p['Date'] ?></a></td>
						 <td><a href="Labo3.php?id_pa=<?php echo $p['id_pa'] ?>&Id_con=<?php echo $p['Id_consultation']?>"><?php echo $p['Heure'] ?></a></td>
					</tr>
					<?php } ?>
				 </tbody>
			  </table>       
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
 
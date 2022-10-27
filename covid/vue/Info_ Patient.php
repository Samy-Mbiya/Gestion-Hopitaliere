
          <!-- Information du patient-->
            <?php //require 'Info_Patient.php'; 
				$id=$_GET['id_pa'];
				$aff=$conn->query("SELECT * FROM  patient WHERE id_pa='$id'");
			?>
          	<table class="table-hover">
              <tbody>
              	</tbody><?php while($pa=$aff->fetch()) {?>
                <tr>
                  <td>Nom:</td>
                  <td><?php 
                    $nom=$pa['Nom'];
                    echo $nom; ?></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Post Nom:</td>
                  <td><?php 
                    $postnom=$pa['Post_nom'];
                    echo $postnom; ?></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Presnom:</td>
                  <td><?php
                     $Prenom=$pa['Prenom'];
                    echo $Prenom; ?></td>
                  <td></td>
                </tr>
                <tr>
                   <td>Sexe:</td>
                   <td><?php echo $pa['Sexe']; ?></td>
                   <td></td>
                </tr>
                <tr>
                  <td>Ne:</td>
                  <td><?php echo $pa['DN']; ?></td>
                  <td></td>
                </tr>
                 <tr>
                  <td>Adresse :</td>
                  <td><?php echo $pa['Adresse']; ?></td>
                  <td></td>
                </tr>
                <tr>
                   <td>Phone :</td>
                   <td><?php echo $pa['Phone']; ?></td>
                   <td></td>
                </tr>
                <tr>
                   <td>Num Identité :</td>
                   <td><?php echo $pa['Profession']; ?></td>
                   <td></td>
                </tr>
                <?php }?>
              </tbody>
			</table>
          
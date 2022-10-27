<?php
require 'Head.php';
require 'Navbar.php';
//require("../modele/Connexion.php");
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
      <?php require("Info_ Patient.php"); ?>
      <p><a href="Patient.php?id_pa=<?php echo $id ?>" id="head"><i class="icon-fast-backward"></i>Retour</a></p>
      <!-- Information de la Consultation -->
      <?php
      $id = $_GET['id_pa'];
      $Id_con = $_GET['Id_consultation'];
      ?>
      <div class="bs-docs-example" align="left">
        <div id="message"></div>
        <form method="post">
          <table class="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Type de l'examen</th>
                <th> Valeur labo</th>
              </tr>
            </thead>
            <tbody>
              <?php
              $aff2 = $conn->query("SELECT * FROM labo WHERE Id_pa='$id' AND Id_cons='$Id_con'");
              while ($t = $aff2->fetch()) {
              ?>
                <tr>
                  <td>
                    <label><?php echo $t['Nom_ex'] ?>/<?php echo $t['Type_ex'] ?></label>
                  </td>
                  <td>
                    <input type="text" name="val[]" id="val" value="<?php echo $t['Valeur']; ?>" />
                    <input style="width:10px; visibility:collapse" value="4" name="code" id="code" /><input style="width:10px; visibility:collapse" value="<?php echo $t['Id_la'] ?>" name="lab[]" id="id_lab" />
                  </td>
                </tr>
              <?php } ?>
              <?php //} 
              ?>
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

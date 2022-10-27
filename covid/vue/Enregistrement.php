<?php
  require 'Head.php';
  require 'Navbar.php';
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header" >
            <h1 id="Titre">Enregistrement du Patient</h1>
          </div>
          <div class="bs-docs-example">

          <!-- Enregistrement  action="../modele/Ajout.php"-->
          <div id="message"></div>
          <div id="Pat"></div>
          <form method="post" >
          	<div id="form_pat">   
            <table class="table-hover">
              <tbody>
                <tr>
                  <td>Nom</td>
                  <td><input type="text" name="N_P" id="N_P" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Post Nom</td>
                  <td><input type="text" name="PN_P" id="PN_P" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Presnom</td>
                  <td><input type="text" name="PRN_P" id="PRN_P" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                   <td>Sexe</td>
                   <td><input type="text" name="S_P"  id="S_P" class="input-xlarge" type="text" placeholder=""/></td>
                   <td></td>
                </tr>
                <tr>
                  <td>Ne</td>
                  <td><input type="date" name="DN_P"  id="DN_P" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Etat Civil</td>
                  <td><input type="text" name="EC_P" id="EC_P" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                  <td></td>
                </tr>
                 <tr>
                  <td>Adresse</td>
                  <td><input type="text" name="A_P" id="A_P" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                   <td>Phone</td>
                   <td><input type="tel" name="PH_P" id="PH_P" class="input-xlarge" type="text" placeholder=""/></td>
                   <td></td>
                </tr>
                <tr>
                  <td>Num Passport</td>
                  <td><input type="text" name="PR_P" id="PR_P" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Emploiyeur</td>
                  <td><input type="text" name="E_P" id="E_P" class="input-xlarge" type="text" placeholder=""/></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td style="padding-left: 50px;"><a href="Patient.php"><button type="submit" class="btn btn-primary" id="EP"><i class="icon-ok-sign"></i> Enregistrer</button></a></td>
                  <td></td>
                </tr>
              </tbody>
            </table>
            </div>
          </form>
          </div>
         </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
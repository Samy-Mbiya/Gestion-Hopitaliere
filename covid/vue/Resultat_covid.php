<?php
	require 'Head.php';
	require 'Navbar.php';
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header-covid">
          <div class="gauche">
            <img src="img/codingboss.png" alt="code logo">
            <br>
            <b>bis,avenue Mont des Arts C/Lingwala</b><br>
            <b>(+243)812902286-815203932</b><br>
            <b>michelmusafiri@gmail.com</b><br>
            <b><u>www.clinique-de-l-espoir.org</u></b>
          </div>      
           <img src="img/mins_Sate.png" class="droite" alt="code logo">
           <b class="droite">N°1250/CAB/MIN/SPHP/3011/CP/SAC/2022</b>
          </div> 
          <div class="centre">
          <div class="marge_bloque"><h1><u> CENTRE COVID DE L'ESPOIR</u></h1></div>
			    <div class="marge_bloque"><h2><u> Résultat Test COVID</u></h2></div>
          </div>
          <div class="bs-docs-example">
            <h4><u>IDENTITE</u></h4>
          <!-- Information du patient-->
            <?php 
				require ("Info_ Patient.php");
				$id_P=$_GET['id_pa'];
        $id_covid=$_GET['Id_covid'];
			?>
          
            <div id="NCAff" class="filigrame"></div><!-- Enregistrement de la consultation -->
            
            <div class="bs-docs-example" id="IFP" >
            
			<p id="non-print" ><a href="Patient.php?id_pa=<?php echo $id ?>"><i class="icon-fast-backward"></i>Retour</a></p> 
            <div id="myTabContent" class="tab-content" >
                <p>
                  <h4><u>Résultat COVID</u></h4> 
                  <!-- Information Examen Pratique --> 
                  <?php 
                    $aff2=$conn->query("
                    SELECT * FROM  covid WHERE covid.Id_covid='$id_covid' ");
                  ?>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Test Covid 19 RT-PCR</th>
                        <th>Resultat</th>
                      </tr>
                    </thead>
                    <tbody>
                     <?php while($t=$aff2->fetch()) {?>
                      <tr>
                        <td><?php echo "00".$t['Id_covid']; ?></td>
                        <td><b><?php echo $t['resultat']; ?><b></td>
						            <td></td>
                      </tr>
                    </tbody>
                  </table>
                </p>
              <div class="bas">
               <!-- QR CODE -->
               <div class="QrCode">
                <?php 
                  $info_test="CME/ Patient= ".$nom."-".$postnom." ".$Prenom." Test covid N°".$t['Id_covid']." = ".$t['resultat'].", le ".date("d-m-Y");
                ?>
                  <img src="https://chart.googleapis.com/chart?cht=qr&chl=<?php echo $info_test ?>&chs=160x160&chld=L|0" class="qr-code img-thumbnail img-responsive" />
                </div>
                <!-- LOGO -->
                <div class="logo"><img src="img/Cachet.png" alt="Cachet"></div>
                <div class="Texts-bas">
                  <u> Responsable Labortoire</u> <br>
                  <b>JP KIMFUMU DITUWENE</b><br>
                  <p>
                  <?php echo "Fait à Kinshasa, le ".date("d-m-Y"); ?>
                </p>
                </div>
              </div>
              </div>
              <?php 
                 } 
                ?>
            </div>
          </div>
         </div>
        </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
 
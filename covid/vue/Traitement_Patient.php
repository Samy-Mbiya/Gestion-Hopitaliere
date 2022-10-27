<?php
	require 'Head.php';
	require 'Navbar.php';
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header">
            <h1>Information du Patient</h1>
          </div> 
          <div class="bs-docs-example">
			<?php require (".../vue/Patient.php");?>
           <!-- Information de la maladie -->
            <div class="bs-docs-example">
            <ul id="myTab" class="nav nav-tabs">
              <li class="active"><a href="#sv" data-toggle="tab">Signes Vitaux</a></li>
              <li><a href="#c" data-toggle="tab">Consultation</a></li>
              <li><a href="#fs" data-toggle="tab">Fiche de surveillance</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade in active" id="sv">
                <p>
                  <!-- Signe Viteaux
                  +++++++++++++++++++-->
                  <!-- Recherche-->
                  <h2>Recherche <input type="text" class="search-query" placeholder="Search"></h2>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Date</th>
                        <th>T</th>
                        <th>TA</th>
                        <th>FC</th>
                        <th>FR</th>
                        <th>Observation</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>

                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>10/04/2017</td>
                        <td>3</td>
                        <td>4</td>
                        <td>7</td>
                        <td>4</td>
                        <td>7</td>
                        <td><a href="#"> <button class="btn btn-mini btn btn-success" type="button"><i class="icon-edit"></i></button></a></td>
                        <td><a href="#"><button class="btn btn-mini btn btn-danger" type="button"><i class="icon-remove"></i></button></a></td>
                        
                      </tr>
                      <tr>
                        <td>10/04/2017</td>
                        <td>3</td>
                        <td>4</td>
                        <td>7</td>
                        <td>4</td>
                        <td>7</td>
                        <td><a href="#"> <button class="btn btn-mini btn btn-success" type="button"><i class="icon-edit"></i></button></a></td>
                        <td><a href="#"><button class="btn btn-mini btn btn-danger" type="button"><i class="icon-remove"></i></button></a></td>
                      </tr>
                      <tr>
                         <td><input class="input-mini" type="text" placeholder="Date"></td>
                        <td><input class="input-mini" type="text" placeholder="T"></td>
                        <td><input class="input-mini" type="text" placeholder="TA"></td>
                        <td><input class="input-mini" type="text" placeholder="FC"></td>
                        <td><input class="input-mini" type="text" placeholder="FR"></td>
                        <td><input class="input-mini" type="text" placeholder="Observation"></td>
                        <td><button type="submit" class="btn btn-primary"><i class="icon-ok-sign"></i> Enregistrer</button></td>
                      </tr>
                    </tbody>
                  </table>
                </p>
              </div>
              <div class="tab-pane fade" id="c">
                <p>
                    <!-- Consultation
                  +++++++++++++++++++-->
                  <!-- Recherche-->
                  <h2>Recherche <input type="text" class="search-query" placeholder="Search"></h2>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>Date</th>
                        <th>Docteur</th>
                        <th>Diagnostique</th>
                        <th>Modifier</th>
                        <th>Suppremer</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td><a href="Consultation_old.php"> 10/04/2017</a></td>
                        <td>Michel</td>
                        <td><a href="Consultation_old.php">  jjkeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee</a></td>
                        <td><a href="#"> <button class="btn btn-mini btn btn-success" type="button"><i class="icon-edit"></i></button></a></td>
                        <td><a href="#"><button class="btn btn-mini btn btn-danger" type="button"><i class="icon-remove"></i></button></a></td>
                      </tr>
                      <tr>
                        <td>1</td>
                        <td><a href="#"> 10/04/2017</a></td>
                        <td>Michel</td>
                        <td><a href="#">  jjkeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee</a></td>
                        <td><a href="#"> <button class="btn btn-mini btn btn-success" type="button"><i class="icon-edit"></i></button></a></td>
                        <td><a href="#"><button class="btn btn-mini btn btn-danger" type="button"><i class="icon-remove"></i></button></a></td>
                      </tr>
                      <tr>
                        <td>1</td>
                        <td><a href="#"> 10/04/2017</a></td>
                        <td>Michel</td>
                        <td><a href="#">  jjkeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee</a></td>
                        <td><a href="#"> <button class="btn btn-mini btn btn-success" type="button"><i class="icon-edit"></i></button></a></td>
                        <td><a href="#"><button class="btn btn-mini btn btn-danger" type="button"><i class="icon-remove"></i></button></a></td>
                      </tr>
                      <tr>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td><a href="Consultation_new.php"><button type="submit" class="btn btn-primary"><i class="icon-ok-sign"></i>New Consultation</button></a></td>
                      </tr>
                    </tbody>
                  </table>
                </p>
              </div>
              <div class="tab-pane fade" id="fs">
                 <p>
                    <!-- Fiche de surveance
                  +++++++++++++++++++++++-->
                  <!-- Recherche-->
                  <h2>Recherche <input type="text" class="search-query" placeholder="Search"></h2>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>Medicament</th>
                        <th>Date</th>
                        <th>Heure</th>
                        <th>Modifier</th>
                        <th>Suppremer</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>Kisi</td>
                        <td>10/04/2017</td>
                        <td>20H10</td>
                        <td><a href="#"> <button class="btn btn-mini btn btn-success" type="button"><i class="icon-edit"></i></button></a></td>
                        <td><a href="#"><button class="btn btn-mini btn btn-danger" type="button"><i class="icon-remove"></i></button></a></td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>Kisi</td>
                        <td>10/04/2017</td>
                        <td>20H10</td>
                        <td><a href="#"> <button class="btn btn-mini btn btn-success" type="button"><i class="icon-edit"></i></button></a></td>
                        <td><a href="#"><button class="btn btn-mini btn btn-danger" type="button"><i class="icon-remove"></i></button></a></td>
                      </tr>
                      <tr>
                        <td>#</td>
                        <td><input class="input-mini" type="text" placeholder="Medicament"></td>
                        <td><input class="input-mini" type="text" placeholder="Date"></td>
                        <td><input class="input-mini" type="text" placeholder="Heure"></td>
                        <td></td>
                        <td><button type="submit" class="btn btn-primary"><i class="icon-ok-sign"></i>New Consultation</button></td>
                      </tr>
                    </tbody>
                  </table>
                </p>
              </div>
            </div>
          </div>


          </div>

         </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
 

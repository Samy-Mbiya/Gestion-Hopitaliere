 <?php
  require 'Head.php';
  require 'Navbar.php';

  ?>
 <div class="span9">
   <!-- Contenue
        ================================================== -->
   <section id="dropdowns">
     <div class="page-header">
       <h1>Information médical du Patient</h1>
     </div>
     <div class="bs-docs-example">
       <!-- Information du patient-->
       <h4><u>Information du Patient</u></h4>
       <?php require 'Info_ Patient.php'; ?>
       <div>
         <div>
           <h4><u>Liste des Consultations</u></h4>
         </div>
         <p>
           <?php $aff1 = $conn->query("SELECT * FROM  consultation, personnel WHERE consultation.Id_pa='$id' AND consultation.Id_pr=personnel.Id_pr  ORDER BY consultation.Id_consultation DESC "); ?>
           <!-- Consultation
                  +++++++++++++++++++-->
           <!-- Recherche-->
         <table class="table">
           <thead>
             <tr>
               <th>Date</th>
               <th>Docteur</th>
               <th>Detail</th>
               <th>Consultation</th>
               <th>Evolution</th>
               <th>Laboratoire</th>
               <th>Imagerie</th>
               <th>Ordonnace</th>
           </thead>
           <tbody>
             <?php while ($p = $aff1->fetch()) { ?>
               <tr>
                 <td>
                   <a href="Consultation_detail.php?id_pa=<?php echo "$id" ?>&id_pr=<?php echo $p['Id_pr'] ?>&Id_consultation=<?php echo $p['Id_consultation'] ?>& Pr=<?php echo $p['Nom'] ?>&date=<?php echo $p['Date'] ?>&heure=<?php echo $p['Heure'] ?>">
                     <?php
                      $Date = substr($p['Date'], 0, 8);
                      echo  $Date;
                      ?>
                   </a>
                 </td>
                 <td>
                   <a href="Consultation_detail.php?id_pa=<?php echo "$id" ?>&id_pr=<?php echo $p['Id_pr'] ?>&Id_consultation=<?php echo $p['Id_consultation'] ?>& Pr=<?php echo $p['Nom'] ?>&date=<?php echo $p['Date'] ?>&heure=<?php echo $p['Heure'] ?>">
                     <?php echo $p['Nom'] ?>
                   </a>
                 </td>
                 <td>
                   <a href="Consultation_detail.php?id_pa=<?php echo "$id" ?>&id_pr=<?php echo $p['Id_pr'] ?>&Id_consultation=<?php echo $p['Id_consultation'] ?>& Pr=<?php echo $p['Nom'] ?>&date=<?php echo $p['Date'] ?>&heure=<?php echo $p['Heure'] ?>">
                     <button class="btn btn-info mb-2"> Généralité </button>
                   </a>
                 </td>
                 <td>
                   <a href="Consultation_consultation.php?id_pa=<?php echo "$id" ?>&id_pr=<?php echo $p['Id_pr'] ?>&Id_consultation=<?php echo $p['Id_consultation'] ?>& Pr=<?php echo $p['Nom'] ?>&date=<?php echo $p['Date'] ?>&heure=<?php echo $p['Heure'] ?>">
                     <button class="btn btn-info mb-2"> Consultation </button>
                   </a>
                 </td>
                 <td>
                   <a href="Consultation_evolution.php?id_pa=<?php echo "$id" ?>&id_pr=<?php echo $p['Id_pr'] ?>&Id_consultation=<?php echo $p['Id_consultation'] ?>& Pr=<?php echo $p['Nom'] ?>&date=<?php echo $p['Date'] ?>&heure=<?php echo $p['Heure'] ?>">
                     <button class="btn btn-info mb-2"> Evolution </button>
                   </a>
                 </td>
                 <td>
                   <a href="Consultation_EP.php?id_pa=<?php echo "$id" ?>&id_pr=<?php echo $p['Id_pr'] ?>&Id_consultation=<?php echo $p['Id_consultation'] ?>& Pr=<?php echo $p['Nom'] ?>&date=<?php echo $p['Date'] ?>&heure=<?php echo $p['Heure'] ?>">
                     <button class="btn btn-info mb-2"> Labo </button>
                   </a>
                 </td>
                 <td>
                   <a href="Consultation_Imagerie.php?id_pa=<?php echo "$id" ?>&id_pr=<?php echo $p['Id_pr'] ?>&Id_consultation=<?php echo $p['Id_consultation'] ?>& Pr=<?php echo $p['Nom'] ?>&date=<?php echo $p['Date'] ?>&heure=<?php echo $p['Heure'] ?>">
                     <button class="btn btn-info mb-2"> Imagerie </button>
                   </a>
                 </td>
                 <td>
                   <a href="Consultation_ordonnance.php?id_pa=<?php echo "$id" ?>&id_pr=<?php echo $p['Id_pr'] ?>&Id_consultation=<?php echo $p['Id_consultation'] ?>& Pr=<?php echo $p['Nom'] ?>&date=<?php echo $p['Date'] ?>&heure=<?php echo $p['Heure'] ?>">
                     <button class="btn btn-info mb-2"> Ordonnance </button>
                   </a>
                 </td>
               </tr>
             <?php } ?>
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
 <?php
  require 'Footer.php';

 <!-- Information du Personnel  -->
 <?php
    $personnel = htmlentities(trim($_SESSION['User']));
    $aff3 = $conn->query("
                      SELECT * FROM personnel WHERE Nom='$personnel'");
    while ($pers = $aff3->fetch()) {
        $Nom_per = $pers['Nom'];
        $Prenom_pers = $pers['Prenom'];
        $Cenom = $pers['CNOM'];
    }
    ?>
 <h4>Docteur <?php
                echo $Prenom_pers . " " . $Nom_per
                ?></h4>
 <h4>CNOM :<?php echo $Cenom ?></h4>
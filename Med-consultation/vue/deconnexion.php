<?php
    session_start(); 
    session_unset(); 
    session_destroy(); 
    echo "<script type='text/javascript'>  document.location.replace('index.php');</script>";
    exit(); 
    ?>

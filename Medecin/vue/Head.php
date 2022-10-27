<!DOCTYPE html>
<html >
	<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Centre medical de l'espoir</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/docs.css" rel="stylesheet">
    <link href="css/prettify.css" rel="stylesheet">
    <link href="css/Style.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
    <![endif]-->

    <script src="//secure.gaug.es/track.js" data-site-id="4f0dc9fef5a1f55508000013" id="gauges-tracker" async="" type="text/javascript"></script>
    <script src="//www.google-analytics.com/analytics.js" async=""></script>
    <script type="text/javascript" async="" id="gauges-tracker" data-site-id="4f0dc9fef5a1f55508000013" src="js/track.txt"></script>
    <script async="" src="js/analytics.txt"></script>
	<script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      ga('create', 'UA-146052-10', 'getbootstrap.com');
      ga('send', 'pageview');
    </script>
    <script id="_carbonads_projs" type="text/javascript" src="js/C6AILKT.txt"></script>
    <style id="holderjs-style" type="text/css">.holderjs-fluid {font-size:16px;font-weight:bold;text-align:center;font-family:sans-serif;margin:0}.holderjs-fluid {font-size:16px;font-weight:bold;text-align:center;font-family:sans-serif;margin:0}</style>
    <script src="//srv.carbonads.net/ads/.json?segment=placement:&amp;callback=_carbonads_go" type="text/javascript" id="_carbonads_projs"></script>    
    
    </head>
  <body data-spy="scroll" data-target=".bs-docs-sidebar">

    <?php
      try
      {
        // On se connecte à MySQL
         $conn = new PDO('mysql:host=192.168.85.2;dbname=ce2;charset=utf8', 'medecin', 'Simms2007');
         //$conn = new PDO('mysql:host=localhost;dbname=ce2;charset=utf8', 'root', '');

      }

      catch(Exception $e)

      {
          // En cas d'erreur, on affiche un message et on arrête tout
              die('Erreur : '.$e->getMessage());

      }?>

      <!-- Navbar
    ================================================== -->
    <div class="navbar navbar-inverse navbar-fixed-top" id="head">
      <div class="navbar-inner" id="head">
        <div class="container">
          <a class="brand" href="#"><img src="img/LOGO1.png"  id="head" width="100" ></a>
          <div class="nav-collapse collapse">
            <ul class="nav" id="head">
              <li class="">
                <a href="#"><h4>CENTRE MEDICAL DE L'ESPOIR</h4></a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>

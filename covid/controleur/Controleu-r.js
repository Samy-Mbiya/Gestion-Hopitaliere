$(document).ready(function(){
	
	Fonc_1 ();        
});

function Fonc_1 () {
	
	affichage ();
	recherche_pat();
	Enrg_FS ();
	 Mj();
	lien();
	
        }
		
function affichage ()
{
	//affichage
	$.get("../modele/Modele.php",function(data){ // on recuper les donnees dans la page Modele.php
	$("#Liste_Patient").html(data); // on l'affiche a la page dans la div voulu
        	});
	}
	
function Enrg_FS ()
{
		// Enregistrement Consultation ErC
		$.get("../vue/Consultation_new.php",function(data){ // on recuper les donnees dans la page Modele.php
				$("#ErC").click(function(event){
					event.preventDefault(); /* garde le chargement sans bouger*/
					var Id_p=$('#id_p').val();
					var S=$('#S').val();
					var Pr=$('#Pr').val();
					var ATCD=$('#ATCD').val();
					var HM=$('#HM').val();
					var CA=$('#CA').val();
					var E=$('#E').val();
					var D=$('#D').val();
					var ES=$('#ES').val();
					var code_cons="&new_cons=1";
					var url="../vue/Patient.php?id_pa="+Id_p;
					var url2="../vue/Labo.php?id_pa="+Id_p+code_cons;
					if (S=="" || ATCD=="" || HM=="" || CA=="" || E=="" || D==""){
						alert('Entrez les informations de la consultation SVP');
						
					}else{
						$.ajax({
							url:"../modele/Ajout/ajout.php",/*la page ou vont les donnees*/
							method:"post",
							data:$('form').serialize(),/*les donnees sont recuper*/
							dataType:"text",
							success: function(strMessage){
								$("#message").html(strMessage)/* En cas de reussite on affiche les donnees dans l'identifiant message */
								if(ES="Vide"){
										window.location=url;
									}
								if(ES="EP"){
											window.location=url2;
										}
									
								
							}}
						)
					}// Fin condition si
					});
					
				}); //Fin Enregistrement Consultation
		
		// Enregistrement Examen Labo coté Medecin 
		$.get("../vue/Labo.php",function(data){ // on recuper les donnees dans la page Modele.php
				$("#covid").click(function(event){
					event.preventDefault(); /* garde le chargement sans bouger*/
					var Id_p=$('#id_p').val();
					//var HCT=$('#HCT').val();
					var url="../vue/Patient.php?id_pa="+Id_p;
					
						$.ajax({
							url:"../modele/Ajout/ajout.php",/*la page ou vont les donnees*/
							method:"post",
							data:$('form').serialize(),/*les donnees sont recuper*/
							dataType:"text",
							success: function(strMessage){
								$("#message").html(strMessage)/* En cas de reussite on affiche les donnees dans l'identifiant message */
								
										window.location=url;										
							}}
						)
					});
					
				}); //Fin Enregistrement Examen
		
		// Enregistrement Traitement
		$.get("../vue/Consultation_old.php",function(data){ // 
				$("#En_T").click(function(event){
					event.preventDefault(); /* garde le chargement sans bouger*/
					var Med=$('#Med').val();
					var Nb_prise="";
					var Qt_p="";
					var V_adm="";
					var Nb_j="";
					var url=$(location).attr('href');
					if(Med==""){
						alert("Entrez les informations du traitement");
						} else{
								$.ajax({
							url:"../modele/Ajout/ajout.php",/*la page ou vont les donnees*/
							method:"post",
							data:$('form').serialize(),/*les donnees sont recuper*/
							dataType:"text",
							success: function(strMessage){
								$("#message").html(strMessage)/* En cas de reussite on affiche les donnees dans l'identifiant message */
										window.location=url;
								}}
							)
						}// Fin Si
					});// Fin Boutton Er_Labo
					
				}); //Fin Enregistrement Traitement
		
		
	
	}// Fin Enregistrement Total
		
function Mj()
{
	// Mofication de la Consultation 
	$.get("../vue/Consultation_mj.php",function(data){
		$("#Mj").click(function (event){
								 alert ('yes');
					event.preventDefault();
					var S=$('#S').val();
					var ATCD=$('#ATCD').val();
					var HM=$('#HM').val();
					var CA=$('#CA').val();
					var E=$('#E').val();
					var D=$('#D').val();
					var url="../vue/Patient.php?id_pa=";
					if (S=="" || ATCD=="" || HM=="" || CA=="" || E=="" || D=="" ){
						alert('Entrez les informations du la consultation SVP');
					}else{
								$.ajax({
									url:"../modele/mj/mj1.php",/*la page ou vont les donnees*/
									method:"post",
									data:$('form').serialize(),/*les donnees sont recuper*/
									dataType:"text",
									success: function(strMessage){
										$("#message").html(strMessage);/* En cas de reussite on affiche les donnees dans l'identifiant message */
										alert('La Modification du Consultation a été fait avec succé' );
										window.location=url;
										
									}}
								)// Fin Ajax
							}// Fin condition si
				});
												 });
	}

function recherche_pat(){
	
	//Login
	$.get("../vue/index.php",function(data){ // on recuper les donnees dans la page Liste_Patients.php
		$("#lg").click( function (event){
								  		event.preventDefault();
										 var user=$('#User').val();
										 var pw=$('#PW').val;
										if (user=="" || pw=="" ){
											alert('Entrez votre Identifiant et votre Mot de passe');
										}else{
												$.ajax({
													url:"../modele/rech/rech.php",/*la page ou vont les donnees*/
													method:"post",
													data:$('form').serialize(),/*les donnees sont recuper*/
													dataType:"text",
													success: function(strMessage){
														$("#message").html(strMessage);
													}}
												)// Fin ajax
											}
										 });
											   });
	
	//Recherche du Patient
	$.get("../vue/Liste_Patients.php",function(data){ // on recuper les donnees dans la page Liste_Patients.php
	$("#Recherche").click( function (event){
			event.preventDefault();
			var N_P=$('#NP').val();
			var PN_P=$('#PNP').val();
			var  code=$('#code').val();
			if (N_P=="" || PN_P=="" ){
				alert('Entrez les informations du patient (Identifiant) SVP');
			}else{
						$.ajax({
							url:"../modele/rech/rech.php",/*la page ou vont les donnees*/
							method:"post",
							data:$('form').serialize(),/*les donnees sont recuper*/
							dataType:"text",
							success: function(strMessage){
								$("#message").html(strMessage)/* En cas de reussite on affiche les donnees dans l'identifiant message */
								$("#Liste_Patient").hide(); // on fait disparetre la div
							}}
						)// Fin ajax
					}// Fin condition si
		}); 
     });// Fin recherche Patient	
	
	// Affichage des information du patient 
	$.get("../modele/rech/rech.php",function(data){ // on recuper les donnees dans la page Liste_Patients.php
	$("#Aff").click( function (event){
			event.preventDefault();
			var id_p=$('#id_p').val();
			alert('yeeeees');
		}); 
     });// Fin recherche Patient
	
	}
	
function lien ()
{
	//Lien
	$.get("../vue/Consultation_old.php",function(data){ // on recuper les donnees dans la page Modele.php
												 
			 $("#En_Aj").click(function (event){
				 event.preventDefault();
				 var exam=$('#ES').val();
				 var id_p=$('#id_pp').val();
				  var id_cons=$('#id_cons').val();
				 var olde_cons="&new_cons=2";
				if(exam=="L"){
					window.location="../vue/Labo.php?id_pa="+id_p+"&id_cons="+id_cons+olde_cons;
					}													
				 });
	
        	});
	} 
	 

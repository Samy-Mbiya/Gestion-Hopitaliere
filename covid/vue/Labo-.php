<?php
	require 'Head.php';
	require 'Navbar.php';
	
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header">
            <h1>Demande de l'examen</h1>
          </div> 
          <div class="bs-docs-example">

          <!-- Information du patient-->
           <?php 
           	require ("Info_ Patient.php");
           	$user=$_SESSION['User'];
           ?>
			<div id="message"></div>
            <div class="bs-docs-example" id="IFP" >
			
           	 	<div id="myTabContent" class="tab-content" >
              		<div class="tab-pane fade in active" id="he">
			   <!-- SANG
                  +++++++++++++++++++-->
                	<p>
					<div id="message"></div>
					<form method="post">
					  <table class="table">
						<tbody>
						  
						  <tr>
							<td>Description</td>
							<td><input type="text"  name="covidDesc"  id="covidDesc"  placeholder="Description"/> </td>
							<td>
								<input style="width:10px; visibility:collapse" value="<?php echo $user ?>"  name="user" id="user"/>
							</td>
							<td>
								<input style="width:10px; visibility:collapse" value="4"  name="code" id="code"/>
								 <input style="width:10px; visibility:collapse" value="<?php echo $id ?>"  name="id_p" id="id_p"/>
							</td>
							<td><button type="submit" class="btn btn-primary" id="covid"><i class="icon-ok-sign"></i> Valider</button></td>		
						</tr>  
						</tbody>
					  </table>
					</p>		
				</div>
			</form>
          </div>
		 </div>
        </section>
      </div>
    </div>
  </div>
<?php
  require 'Footer.php';
 
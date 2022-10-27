<?php
	require 'Head.php';
	require 'Navbar.php';
?>
      <div class="span9">
        <!-- Contenue
        ================================================== -->
        <section id="dropdowns">
          <div class="page-header">
            <h1>Examen du Patient</h1>
          </div> 
          <div class="bs-docs-example">

          <!-- Information du patient-->
           <?php 
		   	require 'Info_ Patient.php';
			 $user=$_SESSION['User'];
			 //$dates=date('Y/m/d');
			 //echo $dates; 
			 
		   ?>
			
			<div id="message"></div>
           	 <div id="myTabContent" class="tab-content" >
              <div class="tab-pane fade in active" id="he">
			   <!-- COVID
                  +++++++++++++++++++-->
                <p>
				<div id="message"></div>
					<form method="post">
					  <table class="table">
						<tbody>
						  <tr>
							<td><input type="checkbox" value="COVID" name="option[]"  id="COVID"  style="margin-bottom:5px"/>  COVID</td>  
							<td>
							<input style="width:10px; visibility:collapse" value="4"  name="code" id="code"/>
								<input style="width:10px; visibility:collapse" value="<?php echo $user ?>"  name="user" id="user"/>
								<input style="width:10px; visibility:collapse" value="<?php echo $id ?>"  name="id_p" id="id_p"/>
								<td><button class="btn btn-primary" id="Er_Sans"><i class="icon-ok-sign"></i> Valider</button></td>
							</td>
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
 
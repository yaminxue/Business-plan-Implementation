<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*,java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customized Tour Guide Finder</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/responsiveslides.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/jquery.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="js/common.js"></script>
<script src="js/typeahead.js"></script>
<script src="js/headtail.js"></script>

<script>
	$(function() {
		// Slideshow 1
		$("#slider1").responsiveSlides({
			maxwidth : 2500,
			speed : 900
		});
	});
</script>
<script>
	$(document).ready(function() {
		$("#search_form").remove();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".item").click(function() {
			var v = $(this).text();
			$("#searchbox").attr("value", v);
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#searchbox").keyup(
						function() {
							$("#searchTable").empty();

							var url = "FindYourGuide/searchRemind.action";

							$.ajax({
								type : 'get',
								url : url,
								data : "q=" + this.value,
								dataType : 'json',
								success : function(data) {
									$.each(data, function(i, city) {

										var _tr = $("<tr><td class='item'>"
												+ city + "</td></tr>");
										$("#searchTable").append(_tr);
									});
								}
							});
							$("#searchremind").slideDown("slow");

						});
				$("#searchbox").change(function() {
					$("#searchremind").slideUp("slow");
				});
			});
</script>
<script type="text/javascript">
	$(function() {
		$('[name="kn"]')
				.typeahead(
						{
							'source' : [
"Amsterdam",
"Ireland",
"Galway",
"Cork",
"Austria",
"Edinburgh",
"Barcelona",
"Berlin",
"Bristol",
"Brighton",
"Birmingham",
"Belfast",
"Paris",
"Dublin",
"Denmark",
"Turin",
"Russia",
"Florence",
"Frankfurt",
"France",
"Finland",
"Granada",
"Copenhagen",
"Netherlands",
"Kiev",
"Czech Republic",
"London",
"Rotterdam",
"Lyon",
"Leicester",
"Rome",
"Leeds",
"Marseille",
"Moscow",
"Munich",
"Manchester",
"Milan",
"Madrid",
"Southampton",
"Naples",
"Nice",
"Oxford",
"Norway",
"Geneva",
"Sweden",
"Switzerland",
"Zurich",
"VALENCIA",
"Ukraine",
"Vienna",
"Venice",
"Spain",
"Greece",
"Italy",
"Athens",
"Istanbul",
"Britain", 
									 ],
							'items' : 8,
						});

		//搜索框提示
		$('[name="area"]')
				.typeahead(
						{
							'source' : [
"Amsterdam",
"Ireland",
"Galway",
"Cork",
"Austria",
"Edinburgh",
"Barcelona",
"Berlin",
"Bristol",
"Brighton",
"Birmingham",
"Belfast",
"Paris",
"Dublin",
"Denmark",
"Turin",
"Russia",
"Florence",
"Frankfurt",
"France",
"Finland",
"Granada",
"Copenhagen",
"Netherlands",
"Kiev",
"Czech Republic",
"London",
"Rotterdam",
"Lyon",
"Leicester",
"Rome",
"Leeds",
"Marseille",
"Moscow",
"Munich",
"Manchester",
"Milan",
"Madrid",
"Southampton",
"Naples",
"Nice",
"Oxford",
"Norway",
"Geneva",
"Sweden",
"Switzerland",
"Zurich",
"VALENCIA",
"Ukraine",
"Vienna",
"Venice",
"Spain",
"Greece",
"Italy",
"Athens",
"Istanbul",
"Britain",  ],
							'items' : 8,
						});

	});
</script>


<%
	
	String loginStatus=(String)request.getParameter("loginStatus");

	if(loginStatus!=null){
		
	if(loginStatus.endsWith("false")){
		
		%>
		<script >
			$(document).ready(function(){
				alert("please login!");
			});
		</script>
		<% 
	}
	}
%>


</head>

<body>
	<div id="div1"></div>

	<!--start-image-slider---->
	<div class="image-slider">
		<!-- Slideshow 1 -->
		<ul class="rslides" id="slider1">
			<li><img src="images/1.jpg" alt=""></li>
			<li><img src="images/2.jpg" alt=""></li>
			<li><img src="images/3.jpg" alt=""></li>
			<li><img src="images/slider4.jpg" alt=""></li>
			<li><img src="images/slider2.jpg" alt=""></li>
			<li><img src="images/slider3.jpg" alt=""></li>
			<li><img src="images/slider1.jpg" alt=""></li>
		</ul>
		<!-- Slideshow 2 -->
	</div>
	<!--End-image-slider---->
	<!---End-wrap---->
	<div class="clear"></div>
	<!---start-content---->
	<div class="content">
		<div class="content_top">
			<div class="wrap" align="center">
				<!--搜索开始-->
				<form class="input-group" id="search_form2" style="width: 50%;"
					action="guideSearch" method="get">
					<div class="row">
						<div class="col-md-5 col-sm-5 col-xs-5 col-lg-5"
							style="padding: 0;">
							<input type="text" id="searchbox" class="form-control input-lg"
								value="" name="kn" autocomplete="off" required="required"
								placeholder="Where do you want to go?"
								style="border-radius: 4px 0px 0px 4px;">
						</div>
						<div class="col-md-3 col-sm-3 col-xs-3 col-lg-3"
							style="padding: 0;">
							<input type="text" class="form-control input-lg start_date"
								value="" name="ts" placeholder="Time of start">
						</div>
						<div class="col-md-3 col-sm-3 col-xs-3 col-lg-3"
							style="padding: 0;">
							<input type="text" class="form-control input-lg end_date"
								value="" name="te" placeholder="Time of End">
						</div>
						<div class="col-md-1 col-sm-1 col-xs-1 col-lg-1"
							style="padding: 0;">
							<span class="input-group-btn"> <input type="hidden"
								name="cookie_enable"> <input type="hidden"
								id="search_form_status">
								<button class="btn btn-primary input-lg" type="submit"
									style="border-radius: 0px 4px 4px 0;">
									 Search
								</button>
							</span>
						</div>

						<!-- 
                	<div style="margin:0px;
								padding:50px;
								height:200px;
								
								text-align:center;
								background:white;
							border:solid 1px #c3c3c3;
							filter:alpha(opacity=60);
 							 /* CSS3 standard */
  							opacity:0.6;
							display:none;" id="searchremind">
                	<table id="searchTable">
						
                	
               	 	</table> 
               	 	</div>-->


					</div>
				</form>

				<h1>WELCOME</h1>
				<p>
					Want to have your own off-beat experience when travelling abroad?<br>
					Want to make friends and have fun on the trip?<br> What to
					find someone who can help you when you are in an unfamiliar place
					without language barrier?<br> Try our services of customized
					tour guide.
				</p>



			</div>
		</div>

		<div class="content-grids">
			<div class="wrap">
			<s:action name="guideSelect" executeResult="false"></s:action>
				<div class="specials-heading">
					<h3>Our Tour Guides</h3>
					<br>
				</div>
				
				<s:iterator value="#request.guideList"> 
				<div class="grid">
					<a href="#"><img src=" <s:property value='filepath'/>" title="image-name" width="250" height="230"/></a>
					<h3 ><s:property value="name"/></h3>
					<p><s:property value="details"/></p>
					<a class="button" href="guidedetail.jsp?ID=<s:property value='id'/> ">More</a>
					
				</div>
				</s:iterator>
				
				<!--  <div class="grid">
					<a href="#"><img src="images/guide2.jpg" title="image-name" /></a>
					<h3>Miko Liu</h3>
					<p>My name is Miko. I like traveling around the world. YOU
						cannot imagine the places where I have been to. I like to make
						friends.</p>
					<a class="button" href="#">More</a>
				</div>
				
				<div class="grid last-grid">
					<a href="#"><img src="images/guide3.jpg" title="image-name" /></a>
					<h3>Huahua Li</h3>
					<p>I am an easy-going person and I am very familiar with the
						places of interests of the city I am living in.</p>
					<a class="button" href="#">More</a> <br>
					<br>
					<br>
				</div>
				-->
				
				
				
				<div align=center>
					<a class="button" href="#">More Guides</a>
				</div>
				
			
				<div class="clear"></div>
			</div>
		</div>
		<div class="specials">
			<div class="wrap">
				<div class="specials-heading">
					<h3>Popular Places</h3>
				</div>
				<div class="specials-grids">
					<div class="special-grid">
						<img src="images/idublin.jpg" title="image-name" /> <b>Dublin</b>
						<p>Dublin has many landmarks and monuments dating back
							hundreds of years. One of the oldest is Dublin Castle, which was
							first founded as a major defensive work on the orders of King
							John of England in 1204, shortly after the Norman invasion of
							Ireland in 1169, when it was commanded that a castle be built
							with strong walls and good ditches for the defence of the city,
							the administration of justice, and the protection of the King's
							treasure.</p>
					</div>
					<div class="special-grid">
						<img src="images/icork.jpg" title="image-name" /> <b>Cork</b>
						<p>Cork features architecturally notable buildings originating
							from the Medieval to Modern periods. The only notable remnant of
							the Medieval era is the Red Abbey. There are two cathedrals in
							the city; St. Mary's Cathedral and Saint Fin Barre's Cathedral.
							St Mary's Cathedral, often referred to as the North Cathedral, is
							the Catholic cathedral of the city and was begun in 1808. Its
							distinctive tower was added in the 1860s. St Fin Barre's
							Cathedral serves the Protestant faith and is possibly the more
							famous of the two. It is built on the foundations of an earlier
							cathedral. Work began in 1862 and ended in 1879 under the
							direction of architect William Burges.</p>
					</div>
					<div class="special-grid spe-grid">
						<img src="images/igalway.jpg" title="image-name" /> <b>Galway</b>
						<p>Galway is a city in the West of Ireland in the province of
							Connacht. Galway City Council is the local authority for the
							city. Galway lies on the River Corrib between Lough Corrib and
							Galway Bay and is surrounded by County Galway. It is the fourth
							most populous urban area in the Republic of Ireland and the sixth
							most populous city in Ireland.</p>
					</div>

					<div class="clear"></div>
					<div align=center>
						<br>
						<a class="button" href="destination.jsp">Choose your
							destination</a>
					</div>
					<div align=center><br><a class="button" href="message.jsp" target="_blank">Message</a></div>
				</div>
			</div>
		</div>
	</div>



	<!---End-content---->
	<div class="clear"></div>




	<div id="div2"></div>
</body>
</html>
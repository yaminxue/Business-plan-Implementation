<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Perfect Destination Traveling Website Template | Contact</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />	
<link href="css/responsiveslides.css"rel="stylesheet" >
<link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script src="js/common.js"></script>
    <script src="js/typeahead.js"></script>
    <script src="js/headtail.js"></script>
  
	<%
		if(session.getAttribute("id")==null){
			%>
			<script>
				alert("Please login!");
				
			</script>
			<%
			
			response.sendRedirect("/FindYourGuide/index.jsp?loginStatus=false");
			}
		else{
			System.out.println(session.getAttribute("id"));
		}
	%>	
</head>
	<script type="text/javascript"> 
  // 显示图片的js 
function viewimg(){ 
var imgup=document.getElementById("uploadImg"); 

//判断是否是图片格式 
var imgname=imgup.value.substring(imgup.value.lastIndexOf("."),imgup.value.length) 
imgname=imgname.toLowerCase() 
	if ((imgname!='.jpg')&&(imgname!='.gif')&&(imgname!='.jpeg')&&(imgname!='.png')&&(imgname!='.bmp')){ 
		alert("请选择图片文件，谢谢!"); 
		imgup.focus(); 
		//清空file里面的值 
		imgup.select();   
	document.selection.clear(); 

	} 
	else{ 
	//显示图片 
	var imgpath=getPath(imgup);
	document.getElementById("viewImg").innerHTML="<img src='viewImg.jsp?fileName="+imgpath+"' border=0 width=300 height=200>"; 
	//document.getElementById("viewImg").innerText="yes!"; 
	} 
	} 

function getPath(obj){ 
   if(obj){ 
   if (window.navigator.userAgent.indexOf("MSIE")>=1){ 
     obj.select(); 
     return document.selection.createRange().text; 
   }else if(window.navigator.userAgent.indexOf("Firefox")>=1){ 
     if(obj.files){ 
         return obj.files.item(0).getAsDataURL();   
     } 
     return obj.value; 
   }    
   return obj.value;    
   } 
} 



</script> 

<body>
		<!---start-wrap---->
			
			<div id="div1"></div>
			
		
		<!---End-wrap---->
		<div class="clear"> </div>
		<!---start-content---->
		<div class="content">
			<div class="wrap">
			<!---start-contact---->
			<div class="section group">				
				<div class="col span_1_of_3">
					<div class="contact_info">
			    	 	<h3>You can make friends and also make money via being a tour guide</h3>
			    	 		
      				</div>
      			<div class="company_address">
				     	<h3>Company Information :</h3>
						    	<p>Loyld Buidling, Trinity College Dublin,</p>
						   		<p>College Green, Dublin2,</p>
						   		<p>Ireland</p>
				   		<p>Phone:(00) 222 666 444</p>
				   		<p>Fax: (000) 000 00 00 0</p>
				 	 	<p>Email: <span>company.com</span></p>
				   		<p>Follow on: <span>Facebook</span>, <span>Twitter</span></p>
				   </div>
				</div>				
				<div class="col span_2_of_3">
				  <div >
				  	<h3>Please Fill the forms</h3>
					     <s:form action="GuideReg" theme="simple" enctype="multipart/form-data" method="post">
					    	<div >
						    	<span><label>Name:</label></span>
						    	<span><input name="name" type="text"  ><span>&nbsp;&nbsp;
						    
							
						    	<span><label>Age:</label><span>
								<span><input name="age" type="text" ></span>&nbsp;&nbsp;
								
								<span><label>Gender:</label></span>
						    	<span><select name="gender">
			                            <option value="male">Male</option>
			                            <option value="female">Female</option>
								</select></span><hr>
								
						   
						     	<span><label>Country:</label></span>
						    	<span><input name="nation" type="text" ></span>&nbsp;&nbsp;
						 
						     	<span><label>City:</label></span>
						    	<span><input name="city" type="text" ></span>&nbsp;&nbsp;
						   
					
						     	<span><label>Duration:</label></span>
						    	<span><input name="duration" type="text" ></span><hr>
						  
						     	<span><label>Occupation:</label></span>
						    	<span><input name="occupation" type="text" ></span>&nbsp;&nbsp;
						  
						     	<span><label>Hometown:</label></span>
						    	<span><input name="hometown" type="text" ></span><hr>
						    	
						    	<span><label>Language Skill:</label></span>
						    	<span><input name="language" type="text" ></span>&nbsp;&nbsp;
						    
						     	<span><label>Tour Guide Experience:</label></span>
						    	<span><input name="exp" type="text" ></span><hr>
						   
						     	
						   
						     	<span><label>Have cars:</label></span>
						    	<span><select name="car">
			                            <option value="yes">Yes</option>
			                            <option value="no">No</option>
								</select></span>&nbsp;&nbsp;&nbsp;&nbsp;
						  
						     	<span><label>Car Type:</label></span>
						    	<span><input name="cartype" type="text" ></span><hr>
						   
						     	<span><label>Tips and Charges required by you:</label></span>
						    	<span><input name="tips" type="text" ></span><hr>

						    </div>
						    
						  
						    <div  >
						    ​<textarea name="detail" placeholder="write down your detailed info" rows="10" cols="70"></textarea><br><br>
						    </div>
						    Select the photos you want to upload: 
						    <s:file id="uploadImg" size="40" name="img" onchange="viewimg()"></s:file>
						
						    
						    <div id="viewImg" ></div>
						    <div align=center>
						   		<br><span><input type="submit" class="mybutton" value="Submit" id="submit"></span><br>
						    </div>
						    
							</s:form>
						    </div>
						    
						  
						   

				    </div>
  				</div>				
			  </div>
			  </div>
			<!---End-contact---->
			<div class="clear"> </div>
		</div>
		<!---End-content---->
		<div class="clear"> </div>
		
	

		
		<div id="div2"></div>
		
		<div class="clear"> </div>
		<div class="copy-right">
			<p>Guide Finder</p>
		</div>
	</body>
</html>
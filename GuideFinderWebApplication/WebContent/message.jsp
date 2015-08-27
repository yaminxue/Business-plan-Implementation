<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="background-color:#20B2AA">
<head>

<script type="text/javascript" src="js/getXmlHttpObject.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<script type="text/javascript">

	 function createXMLHttpRequest() {
		var xmlHttp;
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
		return xmlHttp;
	 } 

		function readMessage(){
			var xmlHttp = createXMLHttpRequest();
			loginUser = "${sessionScope.id}";
			var i,txt,con,sendTime,sen;
			var url = "readMessage.action?receiver=" + loginUser;
			
			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					var xml=xmlHttp.responseXML;
					txt="";
					con = xml.getElementsByTagName("app_content");
					sendTime = xml.getElementsByTagName("sendTime");
					sen = xml.getElementsByTagName("sender");
					 for(i=0;i<con.length;i++){
						txt=txt+ "From " + sen[i].childNodes[0].nodeValue +": "+ con[i].childNodes[0].nodeValue +"   "
						+ sendTime[i].childNodes[0].nodeValue + "\r\n";
					}  
					document.getElementById("chatContent").innerHTML=txt;
				}
			}
			var url1 = encodeURI(url);
			xmlHttp.open("GET", url1, true);
			xmlHttp.send(null);
		}
		
	function sendMessage(){
		
		setInterval("readMessage()", "2000");
		
			content = document.getElementById("content").value;
			receiver = document.getElementById("to").value;
			
			var url= "sendMessage.action?content=" + content +"&receiver=" + receiver + "&sender=" +loginUser;
			var xmlHttp = createXMLHttpRequest();
			
			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					clear();
				}	
			} 
			var url1 = encodeURI(url);
			xmlHttp.open("GET", url1, true);
			xmlHttp.send(null);
	}
	
	function clear(){
		document.getElementById("content").value="";
	}

	
</script>
</head>

<body onload="readMessage()">

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
	}
	%>
	
	<center>
		<h1 style="margin-top: 80px">
			You can check & send messages here.
		</h1>
		<textarea style="background-color: #F0FFFF" rows="20" cols="50"
			id="chatContent" name="chatContent"></textarea>
		<br>
		<p>To (type in receiver's full name):</p>
		<input type="text" style="width: 300px" id="to" name="content">
		<br>
		<p>Message:</p>
		<input type="text" style="width: 300px" id="content" name="content">
		<br> <input type="button" onclick="sendMessage()" value="submit">
	</center>
</body>
</html>
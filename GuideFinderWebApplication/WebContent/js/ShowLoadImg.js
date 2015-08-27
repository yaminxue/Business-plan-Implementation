/**
 * 
 */
$("#uploadImg").change(function(){
	$("#viewImg").text("yes");
	var img=$(this);
	var imgpath=getPath(img);
	var imgname=imgup.value.substring(img.value.lastIndexOf("."),img.value.length) 
	imgname=imgname.toLowerCase();
	if ((imgname!='.jpg')&&(imgname!='.gif')&&(imgname!='.jpeg')&&(imgname!='.png')&&(imgname!='.bmp')){ 
		alert("Please select picture!"); 
		imgup.focus(); 
		
		imgup.select();   
		document.selection.clear(); 

		} 
		else{ 
		
		$("#viewImg").html("<img src='"+imgpath+"' border=0 width=100 height=60>" );
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
});
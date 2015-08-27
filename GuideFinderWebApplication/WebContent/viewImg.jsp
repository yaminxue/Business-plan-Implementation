<%@ page contentType="text/html; charset=utf-8" language="java"
import="java.sql.*,java.util.*,java.io.*" errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件预览</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
</head>
<%
   out.clear();
   out = pageContext.pushBody();
   response.setContentType("image/jpeg");//设置显示文件或图片的格式如:application/pdf
 
   try {
   String imgName = request.getParameter("fileName");
    String imgPath1 = imgName;
    System.out.println(imgPath1);
    //String imgPath2 = "D:/IPM/hardware/error.jpg";
     
    //判断该路径下的文件是否存在
    File file = new File(imgPath1);
    if (file.exists()&& !imgName.equals("")) {
     DataOutputStream temps = new DataOutputStream(response
       .getOutputStream());
     DataInputStream in = new DataInputStream(
       new FileInputStream(imgPath1));
 
     byte[] b = new byte[2048];
     while ((in.read(b)) != -1) {
      temps.write(b);
      temps.flush();
     }
 
     in.close();
     temps.close();
    } else {
    /*DataOutputStream temps = new DataOutputStream(response
           .getOutputStream());
         DataInputStream in = new DataInputStream(
           new FileInputStream(imgPath2));
 
         byte[] b = new byte[2048];
         while ((in.read(b)) != -1) {
          temps.write(b);
          temps.flush();
         }
 
         in.close();
         temps.close(); */
    }
 
   } catch (Exception e) {
    out.println(e.getMessage());
   }
%>
<body>
</body>
</html>
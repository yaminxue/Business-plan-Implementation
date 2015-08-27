<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Perfect Destination Traveling Website Template | Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
		  <script>
		    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 1
			      $("#slider1").responsiveSlides({
			        maxwidth: 2500,
			        speed: 600
			      });
			});
		  </script>
		  <%
	if(session.getAttribute("id")==null){
		%>
		<script>
			alert("Please login!");
			
		</script>
		<%
		
		response.sendRedirect("/GuideFinder/index.jsp?loginStatus=false");
		}
	else{
		
	}
	%>
		     
 </head>
    <body>
		<div id="div1"></div>
<div style="padding-top:60px;">
<!-- 主体部分 -->
<s:action name="orderListShow" executeResult="false"></s:action>
 <div class="container" style="margin-top:30px;">
  <div class="row">
    <div class="col-md-3 col-sm-3 col-xs-3">
      <h2 class="text-default">Order</h2>
      <p class="text-size1">
        <a href="index.jsp">back</a>
      </p>
    </div>
    <div class="col-md-9 col-sm-9 col-xs-9">
<div style="margin-top:100px;">
				<div class="specials-heading">
						<h3>Your Order</h3><br>
					</div>
				<s:iterator value="#request.orderList">
				 <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
<!--导游名字--><s:property value="city"/>
</div>
<div class="col-md-3 col-sm-3 col-xs-3">
<s:property value="order_ID"/>
</div>
          <div class="col-md-6 col-sm-6 col-xs-6">
            <p class="text-center text-wor">
              <a href="javascript:;" class="btn btn-link" data-toggle="modal" 
                data-target="#place<s:property value='order_ID'/>"><!--订单信息-->Order Details</a>
           </p>
   </div>
   
</div>
</s:iterator>
				<div class="clear"> </div>
			</div>
		 </div>
    </div>
	</div>
  <div class="text-center">
      </div>
<div style="height:30px;"></div>
    </div>
<!-- 主题结束 --></div>
<!-- model place -->
<s:iterator value="#request.orderList">
<form action="orderDelete.action?orderID=<s:property value='order_ID' />" method="post">
<div class="modal fade" id="place<s:property value='order_ID'/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="width:400px;">
      <div class="modal-header moda-fix" style="margin:10px 15px;padding:0 0 10px;">
        <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">&times;</span>
          <span class="sr-only">Close</span>
        </button>
        <h4 class="modal-title text-center" id="place" style="color:#000;font-size:22px;">
          Book Details
        </h4>
      </div>
      <div class="modal-body" style="padding:15px 30px;height:533px;overflow-y:scroll;">
      	<div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Order ID</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9" >
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center" ><s:property value='order_ID' /></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>StartDate</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value='startTime'/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>EndDate</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value='endTime'/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Number of People</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value='number'/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>City</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:20px;" class="text-center"><s:property value='city'/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Comment</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value='comment'/>
              </p>
          </div>
          <Button  type="submit" class="btn btn-info next_box" style="width:200px;">Delete</Button>
        </div>
        </div>
      </div>
    </div>
  </div>
  </form>
  </s:iterator>
        <div id="div2"></div>
		
	</body>
</html>

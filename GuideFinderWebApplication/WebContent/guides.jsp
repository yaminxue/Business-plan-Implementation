<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Perfect Destination Traveling Website Template | Services</title>
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
    <script src="js/responsiveslides.min.js"></script>
</head>
<body>
<div id="div1"></div>
		 
				<!---start-services---->
<div class="container" style="margin-top: 30px;margin-bottom:30px;">
					<div class="row">
					  <div class="services-header">
						<h3><s:property value="#request.SearchedPlace"/> Guides</h3>
					  </div>
					   <div class="col-md-3 col-sm-3 col-xs-3" style="border:1px solid #E5E5E5; border-radius:4px;padding:0;margin-bottom:20px;">
							          <div style="padding:20px 12px 12px;background-color:#fff;border-radius:4px;">
<!-- 广告位 -->
		<ul class="rslides" id="slider1">
			<li><img src="images/citi.jpg" alt=""></li>
			<li><img src="images/alibaba.png" alt=""></li>
			<li><img src="images/airbnb.png" alt=""></li>
		</ul>
            </div>
            
            </div>
       <div class="col-md-9 col-sm-9 col-xs-9 data-div">
           <s:iterator value="#request.SearchedGuideList">      
           <div class="col-md-4 col-sm-4 col-xs-4" style="padding:0 6px 6px 6px;position: relative;">
								              <div class="thumbnail modal-content1 cur_box" style="margin-bottom:4px;border:1px solid #f2f2f2;">
                  <div class="caption">
                      <div class="text-center">
                        <a href="guidedetail.jsp?ID=<s:property value='guide_ID'/>">
                          <img src=" <s:property value='headicon'/>"  style="width:auto; height:auto; ">
                        </a>
                        
                      </div>
                  <div class="caption" style="padding:9px 0 0;">
                      <!-- <strong> -->
                          <small>
                           <s:property value="tips"/>                         </small>
                      <!-- </strong> -->
                      <p style="margin:5px 0;">
                        <small>
                          <!-- <strong> -->
                            <s:property value="name"/>                        <!-- </strong> -->
                          <!-- <img src="/static/bootstrap/images/5.png" style="float:right;"/> -->
                          <!-- <img src="/static/bootstrap/images/4.png" style="float:right;"/> -->
                        </small>
                      </p>
                      <div style="font-size:12px;">
                        <div class="pull-right"></div>
                        <a href="">
                          <!-- <strong> -->
                             <s:property value="city"/>   <!-- </strong> -->
                        </a>
                      </div>
                   </div>
                  </div>
              </div>
          </div>		
		</s:iterator> 		
			
				 
				
				<!---End-services---->
		</div>		
		<!---End-content---->
		<div class="clear"> </div>
		
	
		
		 <div id="div2"></div>
		 
	</body>
</html>
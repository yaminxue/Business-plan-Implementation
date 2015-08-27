<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>guide detail</title>

	
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
   

  </head>
  
  <body>
    
   <%
	//if(session.getAttribute("id")==null){
		%>
		
		<%
		
		//response.sendRedirect("/GuideFinder/index.jsp?loginStatus=false");
		//}
	//else{
		
	//}
	%>
<script>
		    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 1
			      $("#slider1").responsiveSlides({
			        maxwidth: 2500,
			        speed: 600
			      });
			      $("#slider2").responsiveSlides({
				        maxwidth: 2500,
				        speed: 600
				      });
			});
		  </script>
		  
		
<div id="div1"></div>
<s:action name="guideDetails" executeResult="false"></s:action>


<div style="padding-top:60px;">
<!-- start content   此标题以下中文内容从数据库读取！！！！！！！！！-->
<!-- <div style="width:100%;"> -->
  <div class="container container1">
      <div class="col-md-8 col-sm-8 col-xs-8" style="max-width:70%;">
        <img src=" <s:property value='#request.guideDetails.headicon'/>" style="width:100%;position:relative;"/>
        <!-- <img src="/static/bootstrap/images/2.png" style="position:absolute;top:5px;left:21px;cursor:pointer;" class="blu_hea"/> -->
        <img src="/static/bootstrap/images/3.png" style="position:absolute;top:5px;left:21px;cursor:pointer;display:none;" class="grat_hea"/>
        <div style="border:1px solid #E1E1E1;border-top:0;width:100%;padding:10px;background-color:#fff;">
          <div class="row">
          
            <div class="col-md-2 col-sm-2 col-xs-2">
              <p class="text-center gud-ig">
                <img src=" <s:property value='#request.guideDetails.headicon'/>" style="width:50px;height:50px;border-radius: 50%;margin-bottom:10px;"/><br/>
                <s:property value="#request.guideDetails.name"/>   <button class="btn btn-link btn-sm" > <a href="chat.jsp?user=<s:property value="#request.guideDetails.guide_ID"/>" target="_blank" >Chat</a></button>            </p>
            </div>
            <div class="col-md-10 col-sm-10 col-xs-10">
              <p style="height:70px;font-size:20px;padding-top:10px;">
                <strong><s:property value="#request.guideDetails.tips"/></strong>
              </p>
              <p class="text-primary" style="font-size:16px;margin-top:-6px;">
                <a href="javascript:;">
                               <s:property value="#request.guideDetails.city"/>                </a>
                <img src="images/4.png" style="float:right;"/>
                                <img src="images/5.png" style="float:right;"/>
                              </p>
            </div>
          </div>
        </div>
                <div class="detail-box">
          <h3 class="text-center derail-h3">Personal Info</h3>

          <div class="row text-fi" style="padding-left: 0; margin-top:20px;">
            <div class="col-md-3 col-sm-3 col-xs-3">
              <p class="text-self1"><s:property value="#request.guideDetails.name"/></p>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
              <p class="text-self1"><s:property value="#request.guideDetails.age"/></p>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
              <p class="text-self1"><s:property value="#request.guideDetails.exp"/></p>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
              <p style="margin:0;height:26px;line-height:26px;" class="text-right">
               <a href="javascript:;" class="btn bt_cor" data-toggle="modal" 
                data-target="#myModal11">More Details</a>
              </p>
            </div>
          </div>
        </div>

        <div class="detail-box">
          <h3 class="text-center derail-h3">Guide Tags</h3>
          <div class="row"><div class="col-md-3 col-sm-3 col-xs-3 label-div" ><p><img src="images/liu_xue_sheng.png" />留学生</p></div>
		  <div class="col-md-3 col-sm-3 col-xs-3 label-div" ><p><img src="images/90.png" />90后</p></div>
		  <div class="col-md-3 col-sm-3 col-xs-3 label-div" ><p><img src="images/man.png" />男</p></div></div>
        </div>       
        <div>
		<h3 class="text-center derail-h3">ID Authentication</h3>
          <div class="col-md-3 col-sm-3 col-xs-3">
              <img src="images/shenfen.png"/>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
              <img src="images/telphoto.png"/>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-3">
              <img src="images/smail.png"/>
            </div>
        </div>   
          <div style="height:50px;"></div>		
        <div style="padding:10px;margin-bottom:20px;">
        </div>

        <div class="detail-bg" tabindex="0">
          <div id="item-list" class="abou_box">
           <!--这里要从数据库里读取整个页面-->
          </div>
          
        </div>
        <div  style="padding-top:10px;" id="album-list">
          
          
          
        </div>
      </div>
    <div id="scroll-box" offsetHeight="">
      <div class="col-md-4 col-sm-4 col-xs-4" style="position: relative;text-align:right;" offsetHeight="0">
        <div class="right_box" style="z-index:9;">
          <div style="position: relative;" class="img-bx">
            
          </div>
          <div class="rig-box" style="width:300px;float:right;">
            <div class="row text-center gud-to" style="margin:0;">
              <div class="col-md-6 col-sm-6 col-xs-6 gue-left bn-cor">
                <a href="javascript:;" class="btn bt_cor" data-toggle="modal" 
                data-target="#myModalFee"><font color=black>
                  About Fee</font>
                </a>
              </div>
              <div class="col-md-6 col-sm-6 col-xs-6 bn-cor">
                <a href="javascript:;" class="btn bt_cor contact_box" data-toggle="modal" 
                data-target="#Book"><font color=black>Request to Book</font></a>
              </div>
           <!--备用-->
			 <div>
              </div>
          
		  </div>  
            <div class="text-center gud-t">
			 <p class="gud-re">Domestic Hot Line: 400-223-8336</p>
              <p class="text-size1">Overseas Hot Line:  0086 23 61720373</p>
            </div>
        <div class="image-slider">
		<!-- Slideshow 1 -->
		<ul class="rslides" id="slider2">
			<s:iterator value="#request.photolist" id="str">
			<li><img src=" <s:property value='str'/>" alt=""></li>
			</s:iterator>
			
		</ul>
		<!-- Slideshow 2 -->
	</div>
	<div class="col-md-6 col-sm-6 col-xs-6 bn-cor">
                <a href="javascript:;" class="btn bt_cor contact_box" data-toggle="modal" 
                data-target="#Photo"><font color=black>Add Photo</font></a>
              </div>
    </div>

        </div>
      </div>
    </div>
  </div>
<!-- </div> -->
<!-- 评论回复开始 -->
<div style="width:100%;background-color:#F6F6F6;padding:26px 0;" id="remark-list">

</div>
<!-- 资费说明开始 -->
<!-- Modal -->
<div class="modal fade" id="myModalFee" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="width:480px;">
      <div class="modal-header moda-fix" style="margin:10px 15px;padding:0 0 10px;">
        <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">&times;</span>
          <span class="sr-only">Close</span>
        </button>
        <h3 class="modal-title text-center text-self" id="myModalLabel" style="color:#000;">Fees</h3>
      </div>
      <div class="modal-body" style="margin:10px 20px;padding:0;height:513px;overflow-y:scroll;">
        <p class="text-se">
          <span class="txet-blue">Total Cost</span> = <span class="txet-blue">Deposit</span> + <span class="txet-blue">Travel Cost</span> + <span class="txet-blue">Additional Charges</span>
        </p>
        
        <p class="text-self text-se" style="font-size:18px;">Rate</p>
        <p class="text-se">Without Cars/day</p>
        <p class="text-se">Deposit
          <span class="txet-blue">50</span> Euro + Cash Payment<span class="txet-blue"> 150Euro</span>
        </p>
        <p class="text-se">With cars/day</p>
        <p class="text-se">Deposit
          <span class="txet-blue">50</span> Euro + Cash Payment<span class="txet-blue"> 300Euro</span>
        </p>
        <p class="text-se gu-bor text-het">Refer to additional charges</p>
        <!-- <p class="text-se gu-bor text-het"></p> -->
        <p class="txet-blue text-se">Tips and charges required by guides</p>
       <p class="text-se gu-bor text-het">1.tips
   6人以下: 5美金/人，6到10人:4 美金/人，10人以上: 3美金/人
2.price of picking up at airport： 75美金
   
 （如客人预定了当日接机+当日向导服务，接机费用则不再另外计算）</p>
        <p class="txet-blue text-se text-het">Fee Specs</p>
        <ul>
          <li class="text-se">
            1 
		    Fees for meals: travelers need be responsible for guides' meal fees	
          </li>
          <li class="text-se">
            2 
			Travelers need be responsible for guides' public transport fees and ticket fees
          </li>
          <li class="text-se">
            3 
			Travelers need be responsible for guides' toll and parking fees
          </li>
          <li class="text-se">
            4 
			Travelers need be responsible for guides' petrol fees if guides provide cars       
			</li>
         
          
        </ul>
      </div>
    </div>
  </div>
</div>

<!-- details -->
<!-- Modal -->
<div class="modal fade" id="myModal11" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="width:480px;">
      <div class="modal-header moda-fix" style="margin:10px 15px;padding:0 0 10px;">
        <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">&times;</span>
          <span class="sr-only">Close</span>
        </button>
        <h4 class="modal-title text-center" id="myModalLabel1" style="color:#000;font-size:22px;">
          Guide Details
        </h4>
      </div>
      <div class="modal-body" style="padding:15px 30px;height:533px;overflow-y:scroll;">
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Name</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.name"/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Age</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.age"/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Country</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.nation"/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>City</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.city"/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Gender</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center">
              <span ><s:property value="#request.guideDetails.gender"/></span>            </p>
          </div>
        </div>
        
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Duration</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.duration"/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Occupation</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.occupation"/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Hometown</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.hometown"/></p>
          </div>
        </div>
        
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Experience</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.exp"/></p>
          </div>
        </div>
       
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Language</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:35px;line-height:32px;" class="text-center"><s:property value="#request.guideDetails.language"/></p>
          </div>
        </div>
       
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Have cars?</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.car"/></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <p>Car Type</p>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9">
            <p style="border-bottom:1px solid #E2E2E2;height:30px;" class="text-center"><s:property value="#request.guideDetails.cartype"/></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--提交Model-->
<div class="modal fade" id="Book" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <form id="orderAdd" action="orderAdd" method="post">
  <div class="modal-dialog" style="width:400px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="text-center" style="margin:0;">Submit Your Requirement</h4>
      </div>
      <div class="modal-body" style="padding:15px 30px 0;">
        <div class="row">
          <p class="text-center">Date</p>
        </div>
        <div class="row" style="padding:0 15px;">
          <div class="col-md-5">
            <p class="text-center" style="margin-top:5px;margin-bottom:0;">Start</p>
            <input type="text" class="form-control input-lg start_date" value="" name="startTime">StartTime</button>         
          </div>
          <div class="col-md-2">
            <p class="text-center" style="margin-top:12px;">
              <img src="images/right_arrow.png"/>
            </p>
          </div>
          <div class="col-md-5">
            <p class="text-center" style="margin-top:5px;margin-bottom:0;">End</p>
            <input type="text" class="form-control input-lg start_date" value="" name="endTime">EndTime</button>         
          </div>
        </div>
        <div class="row">
          <p class="text-center" style="margin-top:10px;">Number of travelers</p>
        </div>
        <div class="row" style="padding:0 15px;">
          <div class="col-md-8" style="padding:0;">
            <input type="text" class="form-control" style="height:40px;" name="number" placeholder="please type integer">
          </div>
          <div class="col-md-4" style="padding:0;">
            <p style="line-height:40px;" class="text-center"></p>
          </div>
          
        </div>    
        <div class="row">
          <p class="text-center">city</p>
        </div>
        <div class="row" style="padding:0 15px;">
          <p class="text-center">
            <input type="text" class="form-control" placeholder="please type city name" style="height:40px;" name="city" required="required" autocomplete="off"/>
          </p>
        </div>
        <div class="row">
          <p class="text-center">comment</p>
        </div>
        <p style="margin:0;">
          <input type="text" name="comment" class="form-control" placeholder="comment"/>
        </p>
      </div>
      <div class="modal-footer" style="border-top: 0;">
        <p class="text-center">
          <button type="submit" class="btn btn-info next_box" style="width:200px;">Submit</button>
        </p>
      </div>
      </div>
    </div>
  </form>
</div>

<div class="modal fade" id="Photo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <s:form id="addPhotoForm" action="photoAdd" theme="simple" enctype="multipart/form-data" method="post">
  <div class="modal-dialog" style="width:400px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="text-center" style="margin:0;">Add Photo</h4>
      </div>
      <div class="modal-body" style="padding:15px 30px 0;">
        <div class="row">
          <p class="text-center">Select Image</p>
        </div>
        <div class="row" style="padding:0 15px;">
          <s:file id="addPhoto" name="photosUpload"></s:file>
        </div>
        
      </div>
      <div class="modal-footer" style="border-top: 0;">
        <p class="text-center">
          <button type="submit" class="btn btn-info next_box" style="width:200px;">Submit</button>
        </p>
      </div>
      </div>
    </div>
  </s:form>
</div>


<!-- end content -->



	<div id="div2"></div>
	</div>
	
  </body>
</html>
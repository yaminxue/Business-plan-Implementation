$(document).ready(function() {
	var time=300;
	$(".help_box").on('mouseover',function(){
		$(this).children('.hel_we').find('img').attr("src","/static/bootstrap/images/ar-cut.png");
		$(this).one('mouseout',function(){
		  $('.arr-bg img').attr("src","/static/bootstrap/images/ar_cur.png");
		})
	});
	$(".for_ward").on('click',function(){
		$(this).siblings('.help-box').show();
		$(".big_help").stop().animate({left:-200},time);
		$(".help-box").stop().animate({left:200},time,function(){
          $(".arr-bg").hide();
		});
	});
	$(".back").on('click',function(){
		$(".help-box").stop().animate({left:200},time,function(){
		  $(".help-box").hide();
		});
		$(".arr-bg").show();
		$(".big_help").stop().animate({left:0},time);
		
	});
	//左侧点击相应右侧页面显示
	$('.li_box').on('click',function(){
		var liboxs=$('.big_help').find('.li_box');
		var indexNum=liboxs.index(this);
		$('.how_box').hide();
		$('.how_box').eq(indexNum+1).show();
	});
	$('.li_box >.hel_we').on('click',function(){
		var laboxs=$('.li_box').find('.hel_we');
		laboxs.removeClass('hel_current');
		$(this).addClass('hel_current');
	});
});
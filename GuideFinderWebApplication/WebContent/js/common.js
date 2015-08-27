$(function(){

    //登录后跳转地址
    var loginCallBack = '';

    //显示登录BOX
    function showLoginBox(){
      closeAllBox();
      $('#login-box').modal('show');
    }

    //显示登录BOX
    function showLoginBox(){
      closeAllBox();
      $('#login-box').modal('show');
    }

    //显示提交需求表单
    function showDemandBox(){
      closeAllBox();
      $('#demand-box').modal('show');
    }

    function showRegisterBox(){
        closeAllBox();
        $('#register-box').modal('show'); 
    }

    //关闭所有弹出框
    function closeAllBox(){
        $('.alert-box').each(function(){
           $(this).modal('hide')
        })
    }

    //想起密码
    $('#re_pass').click(function(){
      showLoginBox();
    })

    //忘记密码
    $('.forget_pass').click(function(){
      closeAllBox();
      $('#forget-box').modal('show')
    })

    //快速注册
    $('.fast_reg').click(function(){
      closeAllBox();
      $('#register-box').modal('show')
    })

	  //显示登录框按钮
    $('.login_box_show').click(function(){
      showLoginBox();
    })

    //点击已有账号登录，跳出登录
    $('#re_login').click(function(){
      showLoginBox();
    })

    //显示提交需求按钮
    $('.demand_box_show').click(function(){
      showDemandBox();
    })

    //登录选择地区编号
    $('[name="area_prefix"]').change(function(){
        $('#forget-tele-country').text($(this).val())
    })

    //忘记账号选择地区编号
    $('#tele_country').change(function(){
        $('#show-tele-country').text($(this).val())
    })

    

    //登录AJAX
    $('.login-btn').click(function(){
        $(this).text('登录中...');
        $(this).attr('disabled',true);
    	  login($(this).closest('form'),false);
        
        return false;
    })

    //登出AJAX
    $('#login-out').live('click',function(){
    	$.ajax({
            url: $(this).attr('href'),
            type: 'post',
            // dataType: 'json',
            success: function(res){
            	res = jQuery.parseJSON(res);
             	if(res.status == 1){
             		// alert(res.message);
             		location.reload();
             	}
            }
        });
        return false;
    })

    //提交需求开始形成时间日历
    $('.start_date').datetimepicker({
        bootcssVer: 3,
        format: 'yyyy-mm-dd',
        language:  'EN-US',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 1
    });

    //提交需求结束形成时间日历
    $('.end_date').datetimepicker({
        bootcssVer: 3,
        format: 'yyyy-mm-dd',
        language:  'EN-US',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 1
    });

    //需求提交表单
      $('#demand-form').submit(function(){
        $('#show-demand').val('1')
        if($('#token').val()!= '')
        {
          var _form = $('#demand-form');
          $.ajax({
            url: _form.attr('action'),
            type: 'post',
            data: _form.serialize(),
            success: function(res){
              res = jQuery.parseJSON(res);
              alert(res.message);
              if(res.status == 1)
              {
                location.reload();
              }else
              {
                $('#register-box').modal('hide');
                $('#demand-box').modal('show');
              }
            }
          });
        }else{
          showRegisterBox();
        }
        return false;
      })

      //注册表单提交
      $('#register-form').submit(function(){
        var _this = $(this);
        $(this).find(':submit').text('Processing..');
        $(this).find(':submit').attr('disabled',true);
        $.ajax({
          url: $(this).attr('action'),
          type: 'post',
          data: $(this).serialize(),
          success: function(res){
            res = jQuery.parseJSON(res);
            $('#token').val(res.message)
            if(res.status == '1')
            { 
              if($('#show-demand').val() == '1')
              {
                $('#demand-form').submit();
              }else if($('#show-apply').val()==1){
                closeAllBox()
                $('#apply-form').submit();
              }else{
                                    location.reload();
              }
            }else if(res.status == '0'){
              alert(res.message);
            }
            _this.find(':submit').text('Done');
            _this.find(':submit').attr('disabled',false);
          }
        });
        return false;
      })

      //短信验证码
      $('#verify-btn').click(function(){
        if($(this).closest('form').find('[name="telephone"]').val()== '')
        {
          alert('请填写你的电话号码');return false;
        }
        $('#verify-btn').attr('disabled',true)
        $(this).text('发送中..');
        $.ajax({
          url: '/public/verify',
          type: 'post',
          data: {
            'telephone': $(this).closest('form').find('[name="telephone"]').val(),
            'prefix'   : $(this).closest('form').find('[name="area_prefix"]').val()
          },
          success: function(res){
            res = jQuery.parseJSON(res);
            alert(res.message)
            $('#verify-btn').attr('disabled',false)
            if(res.status)
            {
              timer()
            }
          }
        });
        return false;
      })

      var _time = 61;
      var scrollTimer
      function timer(){
        $('#verify-btn').attr('disabled',true)
        scrollTimer = setInterval(scroll_time,1000);
      }

      //计数器工作
      function scroll_time(){
        _time--;
        $('#verify-btn').text(_time+'秒');
        if(_time == 0){
          clearInterval(scrollTimer);
          $('#verify-btn').attr('disabled',false)
          $('#verify-btn').text('获取');
          _time = 5;
        }
      }

      //忘记密码提交
      $('#forget-form').submit(function(){
        $.ajax({
          url: $(this).attr('action'),
          type: 'post',
          data: $(this).serialize(),
          success: function(res){
            res = jQuery.parseJSON(res);
            alert(res.message)
            if(res.status == '1')
            {
              showLoginBox();
            }
          }
        });
        return false;
      })

    //订单相关前登录
    $('.detail-link').click(function(){
      if($('#token').val() == ''){
        loginCallBack = $(this).attr('href');
        showLoginBox()
      }else{
        location.href=$(this).attr('href');
      }
      return false;
    })

    //登录函数
    function login(_form, reload){
      //判断登录表单的填写内容
      if(_form.attr('id')=='phone-login'){
          if($('#tele-number').val() == undefined){
              alert('Please fill in the login phone number');
              $('.login-btn').text('login');
              $('.login-btn').attr('disabled',false);
              return false;
          }
          _form.find('[name="user_name"]').val(_form.find('#tele_country').val()+_form.find('#tele-number').val())
      }else if(_form.attr('id')=='email-login'){
          if(_form.find('[name="user_name"]').val()==''){
              alert('Please fill in the login email address');
              $('.login-btn').text('login');
              $('.login-btn').attr('disabled',false);
              return false;
          }    
      }
      if(_form.find('[name="user_pwd"]').val()==''){
          alert('Please fill in the login password');
          $('.login-btn').text('login');
          $('.login-btn').attr('disabled',false);
          return false;
      }
      //ajax提交
      $.ajax({
        url: _form.attr('action'),
        type: 'post',
        data: _form.serialize(),
        success: function(res){
          res = jQuery.parseJSON(res);
          if(res.status == 1){
            //页面重新加载
            if(reload == true){
                location.reload();
            }else{
              $('#token').val(res.token)
              $('.login_box_show').parent().after(res.login_box).hide();
              if(loginCallBack != '')
              {
                location.href=loginCallBack;
              }else if($('#show-demand').val() == '1')
              {
                showDemandBox();
              }else{
                closeAllBox()
              }
            }
          }else{
            $('#show-demand').val('')
            loginCallBack = '';
            alert(res.message);
          }
          $('.login-btn').text('登录');
          $('.login-btn').attr('disabled',false);
        }
      });
    }

    //添加收藏
    $('.add-collect').live('click',function(){
      if($('#token').val() == '')
      {
        showLoginBox();
        return false;
      }
      common_loading();
      var _this = $(this);
      $.ajax({
        url: '/service/addCollection',
        type: 'post',
        data: {
          gid : $(this).data('gid')
        },
        success: function(res){
          res = jQuery.parseJSON(res);
          // alert(res.message);
          if(res.status == 1){
            _this.attr('src','/static/bootstrap/images/2.png');
            _this.removeClass('add-collect');
            _this.addClass('remove-collect');
          }
          common_unloading();
        }
      });
    })

    //移除收藏
    $('.remove-collect').live('click',function(){
      if($('#token').val() == '')
      {
        showLoginBox();
        return false;
      }
      common_loading();
      var _this = $(this);
      $.ajax({
        url: '/service/removeCollection',
        type: 'post',
        data: {
          gid : $(this).data('gid')
        },
        success: function(res){
          res = jQuery.parseJSON(res);
          // alert(res.message);
          if(res.status == 1){
            _this.attr('src','/static/bootstrap/images/3.png');
            _this.removeClass('remove-collect');
            _this.addClass('add-collect');
          }
          common_unloading();
        }
      });
    })

    //加载动画 
    var common_gao=$(document).height();
    var common_wingao=$(window).height();
    function common_loading()
    {
      $(".gray,.dis-load").show();
      $(".gray").height(common_gao).fadeTo(0,0.4);
      $(".dis-load").css("top",common_wingao/2-50);
    }

    function common_unloading()
    {
      $(".gray,.dis-load").hide();
    }

})

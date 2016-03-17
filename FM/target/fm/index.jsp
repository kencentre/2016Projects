<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 2016/3/8
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>软件学院财务管理系统</title>
    <LINK REL="SHORTCUT ICON" HREF="<%=request.getContextPath()%>/image/logo.jpg">
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/vendor/bootstrap.css" rel="stylesheet">

    <!-- 登录 -->
    <link href="<%=request.getContextPath()%>/css/app/signin.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/vendor/carousel.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/css/app/nav.css" rel="stylesheet">


    <script type="application/javascript">
        var UNAME_COOKIE_NAME = "lastLoginUserName";
        $(function(){
            // 如果name 没有 value，将cookie 中存储过的name 值写入
            var eleName = $("input[name=username]");
            eleName.val(Cookie.get(UNAME_COOKIE_NAME));

            // 禁止复制粘贴
            $("input:password").bind("copy cut paste",function(e){
                return false;
            });

            // 登录按钮被点击时，记住当前name
            $("form").submit(function(){
                Cookie.set(UNAME_COOKIE_NAME, $.trim(eleName.val()),null,7*24*60);
                // 将密码字段使用 MD5 (MD5 （密码） + 验证码) 编码后发给服务器
                var username = eleName.val();
                var elePassword = $("input[name=password]");
                var password = elePassword.val();
                var captcha = $("input[name=captcha]").val();
//                eleName.val(doMD5(username, captcha));
//                elePassword.val(doMD5(password,captcha));
            });

            // 加载验证码
            //drawCaptcha2();
//            drawCaptcha2();
        });
        function drawCaptcha(){
            console.log("正在加载。。。");
            $.ajax("<%=request.getContextPath()%>/preLogin").done(function(data){
                console.log(data);
                $("#captchaImg").attr("src",data.imgData);
            }).fail(function(){
                alert("验证码加载失败")
            });
        }

        function drawCaptcha2(){
            console.log("正在加载。。。");
            //var formParam = $("#form1").serialize();//序列化表格内容为字符串
            $.ajax({
                type: "GET",
                url:"<%=request.getContextPath()%>/preLogin",
                success: function(data,textStatus){
                    console.log(data);
                    console.log(textStatus);
                    $("#captchaImg").attr("src",data.imgData);
                },
                error:function(){
                    alert("验证码加载失败");
                }
            });
        }

        function doMD5(param1,param2){
            return ($.md5($.md5(param1)+ param2));
        }

        function checkLogin(){
            $.ajax({
                type: "POST",
                url:"<%=request.getContextPath()%>/login",
                data:{
                    loginInfo:{
                      username:$("input[name=username]").val(),
                      password:$("input[name=password]").val(),
                      captcha:$("input[name=captcha]").val()
                    }
                },
                success: function(data,textStatus){
                    if(data.result){
                        alert(data.captchaError + "\n" + data.userInfoError);
                    }
                },
                error:function(){
                    alert("登录校验失败");
                }
            });
        }

    </script>
</head>

<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-fixed-top main-navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">天津大学软件学院</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav menu" id="mytab">
                        <li class="active nav-current" role="presentation"><a href="">主页</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right  menu" id="mytab_right">
                        <li><a href="#" data-toggle="modal" data-target="#myModal">登录</a></li>
                        <li><a href="">关于</a></li>
                    </ul>
                </div>
            </div>

        </nav>

    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h2 class="modal-title" id="exampleModalLabel">登录</h2>
            </div>
            <div class="modal-body">
                <form class="form-signin" action="<%=request.getContextPath()%>/login" method="post">

                    <!--<label for="name" class="sr-only">用户名</label>-->
                    <input  name="username" type="text" id="name" class="form-control"  placeholder="用户名" required autofocus style="margin-bottom: 15px;border-radius: 10px;">

                    <!--<label for="password" class="sr-only">密码</label>-->
                    <input  name="password" type="password" id="password" class="form-control" placeholder="密码" style="margin-bottom: 15px; border-radius: 10px;" required>

                    <!--<div class="checkbox">-->
                    <!--<label>-->
                    <!--<input type="checkbox" value="remember-me"> 记住我-->
                    <!--</label>-->
                    <!--</div>-->
                    <!--<div class="form-group has-feedback">-->

                    <!--<label for="captcha" class="sr-only ">验证码</label>-->
                    <input id=captcha type="text" name="captcha" class="form-control" placeholder="验证码" required  autocomplete="off" style="width: 200px;margin-right: 10px;display: inline-block;margin-bottom: 30px;border-radius: 10px;"/><span><img src="" onclick="drawCaptcha2();" id="captchaImg"  style="cursor:pointer;" style="width: auto"></span>
                    <!--</div>-->
                    <c:if test="${error}">
                        <div class="form-group has-error has-feedback">
                            <label class="control-label" for="inputError2">Error:</label>
                            <input type="text" class="form-control " id="inputError2" aria-describedby="inputError2Status" value="${captchaError} ${userInfoError}">
                            <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
                            <span id="inputError2Status" class="sr-only">(error)</span>
                        </div>
                    </c:if>

                    <input type="submit" class="btn btn-lg btn-primary btn-block" value="登录">
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class=""></li>
        <li class="active" data-target="#myCarousel" data-slide-to="1"></li>
        <li class="" data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item">
            <!--<img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">-->
            <img class="first-slide" src="<%=request.getContextPath()%>/image/first.jpg" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Example headline.</h1>
                    <p>Note: If you're viewing this page via a <code>file://</code>
                        URL, the "next" and "previous" Glyphicon buttons on the left and right
                        might not load/display properly due to web browser security rules.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                </div>
            </div>
        </div>
        <div class="item active">
            <img class="second-slide" src="<%=request.getContextPath()%>/image/seconde.jpg" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Another example headline.</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget
                        quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor
                        id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide" src="<%=request.getContextPath()%>/image/third.jpg" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>One more for good measure.</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget
                        quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor
                        id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" height="140" width="140">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
                euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi
                leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo
                cursus magna.</p>
            <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" height="140" width="140">
            <h2>Heading</h2>
            <p>Duis mollis, est non commodo luctus, nisi erat porttitor
                ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus
                sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor
                mauris condimentum nibh.</p>
            <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" height="140" width="140">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
                in, egestas eget quam. Vestibulum id ligula porta felis euismod semper.
                Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                ut fermentum massa justo sit amet risus.</p>
            <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor
                fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
                commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus,
                tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
            <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor
                fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
                commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus,
                tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
            <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor
                fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
                commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus,
                tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->


    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>© 2015 tju.scc, Inc. · <a href="#">developer</a> · <a href="#">HaoXiaotian</a></p>
    </footer>

</div><!-- /.container -->





<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%=request.getContextPath()%>/js/vendor/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/vendor/bootstrap.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<%=request.getContextPath()%>/js/vendor/ie10-viewport-bug-workaround.js"></script>
<!--<script type="text/javascript" src="js/vendor/jquery-2.1.4.js"></script>-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/vendor/cookie_util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/vendor/md5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/vendor/jquery_md5.js"></script>




<script>

    $(function(){
        $("#mytab li").mouseover(function(e){
            e.preventDefault();
            $(this).tab("show");
            $("#mytab li").eq($(this).index()).addClass("nav-current active").siblings().removeClass("nav-current active");
        });
        $("#mytab li").mouseout(function(e){
            e.preventDefault();
            $("#mytab li").eq($(this).index()).removeClass("nav-current active");
        });

        $("#mytab_right li").mouseover(function(e){
            e.preventDefault();
            $(this).tab("show");
            $("#mytab_right li").eq($(this).index()).addClass("nav-current active").siblings().removeClass("nav-current active");
        });
        $("#mytab_right li").mouseout(function(e){
            e.preventDefault();
            $("#mytab_right li").eq($(this).index()).removeClass("nav-current active");
        });

        drawCaptcha2();
    });
</script>
</body></html>
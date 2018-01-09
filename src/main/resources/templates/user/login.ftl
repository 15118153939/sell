<html>

<#include "../common/header.ftl">

<body background="/sell/img/login/bg.jpg">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-4 column">
                </div>
                <div class="col-md-4 column">
                    <form role="form" method="post" action="/sell/seller/login">
                        <div class="form-group">
                            <label>用户名：</label><input class="form-control" id="username" name="username" type="text" />
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">密码：</label><input class="form-control" id="password" name="password" type="password" />
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" />Check me out</label>
                        </div> <button class="btn btn-default" type="submit">登录</button>
                    </form>
                </div>
                <div class="col-md-4 column">
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
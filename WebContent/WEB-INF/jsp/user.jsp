<%@ page language="java" import="java.util.*,com.clps.managersystem.model.User" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>用户系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user"><%=((User)session.getAttribute("user")).getUserName() %></span><a href="" title="退出系统" class="dl-log-quit">[注销]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">用户</div></li><li class="nav-item dl-selected"><div class="nav-item-inner nav-order">待开发功能</div></li>		

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'个人中心',items:[{id:'2',text:'个人信息',href:'editForm.action'},{id:'3',text:'安全中心',href:'QuestionForm.action'}]}]},
                      {id:'7',menu:[{text:'待开发功能',items:[{id:'8',text:'待开发功能',href:''},{id:'9',text:'待开发功能',href:''}]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>
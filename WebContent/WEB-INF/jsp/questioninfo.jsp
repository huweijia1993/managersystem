<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css1/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css1/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css1/style.css" />
    <script type="text/javascript" src="Js1/jquery.js"></script>
    <script type="text/javascript" src="Js1/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js1/bootstrap.js"></script>
    <script type="text/javascript" src="Js1/ckform.js"></script>
    <script type="text/javascript" src="Js1/common.js"></script>
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>

<form class="form-inline definewidth m20" action="c1-index.jsp" method="get">  
    
   问题：
    <input type="text" name="cName"  class="abc input-default" list="cName" autocomplete="off">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">模糊查询</button>&nbsp;&nbsp;
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>ID</th>
        <th>问题</th>
        <th>状态</th>
        <th colspan="1">管理操作</th>
    </tr>
    </thead>
	     <tr>
            <td></td>
            <td></td>
            <td></td>
            <td>
                  <a href=''>修改状态</a>                 
            </td>
        </tr>
        </table>
<br><br>        
<form action="" method="post">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">问题</td>
        <td><input type="text" name="cNum" required value=""/></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
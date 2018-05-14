<%--
  Created by IntelliJ IDEA.
  User: 庚壬
  Date: 2018/3/14
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <title>导航栏的字形图标</title>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css">
    <script type="text/javascript" src="{pageContext.request.contextPath}/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
    <link rel="stylesheet" href="{pageContext.request.contextPath}/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css" type="text/css" />
</head>
<body>

<div >

    <form action="${pageContext.request.contextPath}/admin/blog/write" method="post">
        <div style="padding-left:10%">
            <textarea id="contextTo" name="content" ></textarea>
            <textarea id="summary" name="summary" ></textarea>
        </div>
        <div style="padding-left:5%">
            <input type="text" value="在这里输入标题"  id="head" name="title"></div>

        <div>
            <input type="submit" value="提交" onClick="button_onclick();" style="width:50%;height:1.5em">
        </div>


    </form>
    <div style="width:70%;padding-left:10%">
        <script id="container" name="content" type="text/plain" >这里写你的初始化内容</script>
        <script type="text/javascript">
            var editor = UE.getEditor('container');
        </script>
    </div>

    <script>
        function button_onclick(){
            alert("ssssssssssssssssssss");
            var html = editor.getContent();
            document.getElementById("contextTo").value = html;
            var simpl = editor.getPlainTxt().substr(0,100);
            document.getElementById("summary").value = simpl;


        }
    </script>
    <script>
        SyntaxHighlighter.all() //执行代码高亮
    </script>

</div>
</body>
</html>

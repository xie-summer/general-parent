<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>主页</title>
    <link rel="shortcut icon" href="${resPath }/zxgj/img/logo.png"/>
    <style type="text/css">
    	.aoutDiv1{
			height: 550px;clear: both;
		}
		.asearchDiv{
/* 			max-width: 1190px; */
		}
		.asearchDiv1{
			clear:both; height: 60px;margin-top: 20px;
		}
		.asearchDiv2{
			width: 640px;height: 40px;padding-top: 10px;
		}
		.asearchText{
			border: 1px solid #b6b6b6;vertical-align: top;height: 36px;width: 520px;-webkit-appearance: textfield;padding: 1px;background-color: white;border-image-source: initial;border-image-slice: initial;border-image-width: initial;border-image-outset: initial;border-image-repeat: initial;-webkit-rtl-ordering: logical;-webkit-user-select: text;cursor: auto;margin: 0em;color: initial;letter-spacing: normal;word-spacing: normal;text-transform: none;text-indent: 0px;text-shadow: none;display: inline-block;text-align: start;
		}
		.asearchbutton{
			cursor: pointer;width: 100px;height: 40px;color: white;background-color: #E12422;font-size: 16px;border: 0;line-height: 40px;
		}
		
		.label-list {
		    margin-right: -24px;
		    margin-top: -10px;
		    padding-bottom: 50px;
		}

		.label-list a {
		    color: #666;
		    text-decoration: none;
		    display: block;
		    float: left;
		    border: 1px solid #EEEFF2;
		    border-radius: 2px;
		    box-sizing: border-box;
		    width: 132.5px;
		    height: 50px;
		    line-height: 48px;
		    margin: 12px 20px 0 0;
		    background: #F9F9F9;
		}
		.label-list a {
		    width: 116px;
		    margin-right: 10.3px;
		    -webkit-transition: all .2s;
		    -o-transition: all .2s;
		    transition: all .2s;
		    cursor: pointer;
		}
		.label-list a:hover {
		    border-color: #ff5200;
		    background: #ff5200;
		    color: #fff;
		    transition: background,border-color .2s;
		}
		.classify-more {
		    height: 70px;
		    box-sizing: border-box;
		    text-align: center;
		    padding-top: 20px;
		}
		.classify-more p {
		    display: inline-block;
		    width: 552px;
		    border-top: 1px solid #ddd;
		    height: 0;
		}
		.classify-more p span {
		    display: inline-block;
		    padding: 0 31px;
		    background: #fff;
		    position: relative;
		    top: -11px;
		}
		.classify-more p span a{
			padding: 20px;
			font-size: 14px;
    		color: #666;
    		-webkit-transition: all .2s;
		    -o-transition: all .2s;
		    transition: all .2s;
		    cursor: pointer;
		    text-decoration: none;
		}
		
		.totalMenu a{
			width: 116px;
			margin-left: 10px;
			cursor: pointer;
			float: left;
			color: #666;
			display: block;
			border-right: 1px solid #EEEFF2;
		    border-left: 1px solid #EEEFF2;
		    text-decoration: none;		
		}
		.totalMenu a:hover{
			background: #F9F9F9;
		}
    </style>
</head>
<body>
	
	<div align="center" class="asearchDiv">
    	<div align="center"  class="asearchDiv1">
    		<div class="asearchDiv2" >
    			<span><input type="text" class="asearchText" id="searchValue" maxlength="60" value="" ></span>
    			<span><input type="button" onclick="" value="搜索一下" class="asearchbutton" id="searchButton" ></span>
    		</div>
    	</div>
   	</div>
   	
   	<div align="center"> 
   		<div style="width: 800px;border-bottom: 1px solid #EEEFF2;overflow: auto;padding-top: 40px;">
   			<div style="width: 396px;" class="totalMenu">
	   			<a href="javascript:void(0)" onclick="loadTypeData()">类型</a>
	   			<a href="javascript:void(0)" onclick="loadTipData()">标签</a>
	   			<a href="javascript:void(0)" >星标</a>
   			</div>
   		</div>
   	</div>
   	
	<div id="tipLabel" class = "label-list" align="center" style="margin-top: 20px;">
		<div style="width: 520px;">
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
			<a href="#">dddd (10)</a>
		</div>
	</div>
	
	<div class="classify-more" style="margin-top: -30px;">
        <p>
        	<span>
        		<a rel="nofollow" href="/zhuanti.html" target="_blank" style="padding: 20px;" class="click-statistics" special-name="查看更多">查看更多</a>
        	</span>
        </p>
    </div>
    <script type="text/javascript">
    	function loadTipData(){
	    	$.ajax({
	    		url:"${path}/grab/getTipList",
	    		type:"post",
	    		success:function(data){
	    			console.info(data);
	    		}
	    	})
    	}
    	
    	function loadTypeData(){
	    	$.ajax({
	    		url:"${path}/grab/getTypeList",
	    		type:"post",
	    		success:function(data){
	    			console.info(data);
	    		}
	    	})
    	}
    	
    </script>
</body>
</html>
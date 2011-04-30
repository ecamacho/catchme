<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">
    <head>
        <title>CatchMe - collect all your friends</title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="content">
        <div id="logo">
			<h1><a href="index.html">CatchMe</a></h1>
		</div>
		<ul id="menu">
			<li><a href="#">About</a></li>
		</ul>
		<div class="line"></div>
        <g:layoutBody />
		<g:facebookConnectJavascript/>
        </div>
    </body>
</html>
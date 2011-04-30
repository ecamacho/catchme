<html>
    <head>
        <title>Catch Me Login</title>
        <meta name="layout" content="main" />        

	</head>
	<body>
	<p id="top">Catch up with your contacts.</p>

        <div id="pitch">
			<h1>CatchMe notifies you when your contacts are near to your current location.</h1>
			<h2>Get notified when your friends are hanging out in a place near to you.</h2>
            <br />
            <div class="login">
            <button class="large red awesome"
                 onclick="login()">Login with Facebook</button>
            </div>
		</div>


		  <br/>
		

    <script type="text/javascript">
        function login() {
            window.location = 'https://www.facebook.com/dialog/oauth?client_id=218761638136588&redirect_uri=http://localhost:8080/catchme/configuration&scope=email,user_relationships,user_checkins';
        }

    </script>
		
		
	</body>
	
</html>
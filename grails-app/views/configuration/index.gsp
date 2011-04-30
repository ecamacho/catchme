<html>
    <head>
        <title>Welcome to Grails</title>
        <meta name="layout" content="main" />        

	</head>
	<body>
		Welcome <fb:name uid="loggedinuser" useyou="false"></fb:name>
        <button title="logout" onclick="FB.logout(onLogout()); return(false);">logout</button>
        <br/>
		<fb:profile-pic uid="loggedinuser" size="normal" />
		<br />
        ${messageContacts}
        <br/>
		<script type="text/javascript">

            function onLogout() {
                window.location = "/catchme"
            }

		</script>
	</body>
	
</html>		
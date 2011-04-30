package catchme

import org.apache.commons.io.IOUtils
import org.apache.commons.httpclient.HttpClient

import org.apache.commons.httpclient.methods.GetMethod
import grails.converters.*
import org.codehaus.groovy.grails.web.json.*
import tidyslice.CatchmeUser
import tidyslice.Contact;

class ConfigurationController {

	def facebookConnectService
	
    def index = {

		def redirect_url = URLEncoder.encode("http://localhost:8080/catchme/configuration")

		if (params.code){

			def code = params.code
			params.code = null
			def access_token = readURL("https://graph.facebook.com/oauth/access_token?client_id=218761638136588&redirect_uri=$redirect_url&client_secret=44b84af37339a40e7a520e503124b9a2&code=$code")
			def loggedUser = saveCurrentUserIfNotExists(access_token)


		
		} else {
			println "request.requestURL"
		}
	 }
	
	
	def readURL (String url) {

		StringBuilder builder = new StringBuilder()
		HttpClient httpclient = new HttpClient()
		def get = new GetMethod(url)
		def result = httpclient.executeMethod(get);

        def rawToken = get.getResponseBodyAsString()
        def accessToken = rawToken.substring( "access_token=".length(), rawToken.indexOf("&expires"))

        builder.append( accessToken )
		return builder.toString()
	}
	
	def access_token = {
		println "access token $params.access_token"
		render(view:"index", model:[:])		
	}

    def saveCurrentUserIfNotExists( String accessToken ) {
        def currentUser = JSON.parse( "https://graph.facebook.com/me?access_token=$accessToken".toURL().text )
        println currentUser
        def existingUser = CatchmeUser.findByUsername( currentUser.username )
        if( !existingUser ) {
            println "saving user"
            existingUser = new CatchmeUser( username:currentUser.username,
                                              firstName: currentUser.first_name,
                                              lastName: currentUser.last_name,
                                              email: currentUser.email).save()
            saveUserContacts( existingUser, accessToken )
        }
        existingUser
    }

    def saveUserContacts( CatchmeUser currentUser, String access_token ) {
         def friends = JSON.parse( "https://graph.facebook.com/me/friends?access_token=$access_token".toURL().text ).data
			friends.each{ friend ->
				def contact =  JSON.parse( "https://graph.facebook.com/$friend.id".toURL().text )
                println "saving contact $contact"
                if ( contact.username ) {
                    def contactDB = new Contact( username:contact.username,
                                 firstName:contact.first_name,
                                 lastName:contact.last_name,
                                 user:currentUser,
                                 fbId: contact.id,
                                 type: 1
                    )
                    if( contactDB.save() ) {
                        println "saved contact $contactDB"
                    } else {
                        contactDB.errors.allErrors.each { println it }
                    }
                }

			}
    }
	
	
}

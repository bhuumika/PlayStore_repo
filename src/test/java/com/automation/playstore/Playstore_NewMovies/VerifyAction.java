package com.automation.playstore.Playstore_NewMovies;

import org.testng.Assert;

import org.testng.annotations.Test;

public class VerifyAction  {
	
Action action= new Action();

//To test whether the user has added the first released movie of every category under GENRES and printed it's respective directors 
@Test
public void launchUrl() throws InterruptedException
{
	//Calling of invokeBrowser function to launch the Chrome browser and open Google Play store web application
	String url1=action.invokeBrowser();
	//Validate home page of Google Play store is opened
	Assert.assertEquals("https://play.google.com/store?hl=en",url1 );
	
	
	//Calling of signIntoPlaystore function to open sign-in page 
	String title1=action.signIntoPlaystore();
	//Validate user is successfully navigated to sign-in page of Google Play store
	Assert.assertEquals("Sign in - Google Accounts", title1);
	
	
	//Calling of inputCredentials function to successfully enter user credentials and login to Google Play store
	String title2 =action.inputCredentials();
	//Validate user is successfully logged into Google Play store
	Assert.assertEquals("Sign in - Google Accounts", title2);
	
	
	//Calling of selectMoviesTab function to click on the Movie tab from side bar
	String url2=action.selectMoviesTab();
	//Validate : User has clicked Movies tab
	Assert.assertEquals("https://play.google.com/store/movies?hl=en", url2);
	
	
	//Calling of selectNewReleases function to click on the New Releases tab 
	String url3=action.selectNewReleases();
	//Validate user is navigated inside New Releases tab
	Assert.assertEquals("https://play.google.com/store/movies/new?hl=en", url3);
	
	//Calling of selectGenres function to select Genres tab and add the first most new released movie under every category of movie
	action.selectGenres();
	//Display the respective directors of the first most new released movie under every category of movie
	action.printDirectorName();
}
}

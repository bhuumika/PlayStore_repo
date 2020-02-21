package com.automation.playstore.Playstore_NewMovies;

public class Locator  {
	
	String Sign_in,Email,Next2,Password,Next1,Movies,NewReleases,Genres,movieDropdown,drpdwn_class,Add_to_wishlist,Read_More;
	Locator()
	{
		Sign_in="//a[contains(text(),'Sign in')]";
		Email="//input[@type='email'][@id='identifierId']";
		Next1="//span[contains(text(),'Next')]";
		Password="//input[@type='password'][@aria-label='Enter your password']";
		Next2="//span[@class='RveJvd snByac'][contains(text(),'Next')]";
		Movies="//span[contains(text(),'Movies')]";
		NewReleases="//a[contains(text(),'New releases')]";
		Genres="//span[contains(text(),'Genres')]";
		movieDropdown="//a[contains(text(),'Movies')]";
		drpdwn_class="//ul[@class='TEOqAc']/li/a";
		Add_to_wishlist="//span[contains(text(),'Add to Wishlist')]";
		Read_More="//span[contains(text(),'Read more')]";
	
}
	}

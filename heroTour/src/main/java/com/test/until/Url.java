package com.test.until;

public class Url {
	//get All heroes
	public static final String HEROES = "/heroes";
	//add Hero
	public static final String SAVEHERO = "/heroes/addHero";
	//delete hero by id
	public static final String DELETEHERO = "/heroes/delete/{id}";
	//get Single Hero by id
	public static final String HERO = "/heroes/{id}";
	//update Hero
	public static final String UPDATEHERO = "/heroes/update";
	//search Hero
	public static final String SEARCHHERO = "/heroes/name/{key}";

}

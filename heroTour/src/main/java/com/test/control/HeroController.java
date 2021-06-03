package com.test.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.object.Hero;
import com.test.service.HeroService;
import com.test.until.Url;

@RequestMapping("/api")
@RestController
public class HeroController {

	@Autowired
	HeroService heroService;

	/**
	 * get AllHeroes
	 * @return
	 */

	@RequestMapping(Url.HEROES)
	public List<Hero> getAllHeroes() {
		List<Hero> heroes = heroService.getAllHeroes();
		return heroes;

	}

	/**
	 * add Hero
	 * @param hero
	 */

	@ResponseBody
	@PostMapping(Url.SAVEHERO)
	public void saveHero(@RequestBody Hero hero) {

		heroService.saveHero(hero);

	}

	/**
	 * delete hero by id
	 * @param id
	 */

	@ResponseBody
	@RequestMapping(Url.DELETEHERO)
	public void deleteHero(@PathVariable("id") int id) {
		heroService.deleteHero(id);
	}

	/**
	 * get Single Hero by id
	 * @param id
	 */

	@ResponseBody
	@RequestMapping(Url.HERO)
	public Hero getHeroInfo(@PathVariable("id") int id) {
		Hero he = heroService.getHero(id);
		return he;
	}

	/**
	 * update Hero
	 * @param hero
	 */
	@ResponseBody
	@PutMapping(Url.UPDATEHERO)
	public void updateHero(@RequestBody Hero hero) {

		heroService.updateHero(hero);

	}

	/**
	 * search Hero
	 * @param key
	 * @return
	 */
	@ResponseBody
	@RequestMapping(Url.SEARCHHERO)
	public List<Hero> findByName(@PathVariable("key") String key) {

		List<Hero> heroes = heroService.searchHeroByName(key);
		return heroes;
	}
}

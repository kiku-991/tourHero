package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.HeroEntity;
import com.test.object.Hero;
import com.test.repository.HeroRepository;

@Service
public class HeroService {

	@Autowired
	HeroRepository heroRepository;

	/**
	 * getAllHeroes
	 * @return heroList
	 */
	public List<Hero> getAllHeroes() {
		List<HeroEntity> heroes = heroRepository.findAllByOrderByIdAsc();
		List<Hero> heroList = new ArrayList<>();
		for (HeroEntity hero : heroes) {
			Hero h = new Hero();
			h.setId(hero.getId());
			h.setName(hero.getName());
			heroList.add(h);
		}
		return heroList;
	}

	/**
	 * get Single Hero
	 * @param id
	 * @return
	 */
	public Hero getHero(int id) {
		HeroEntity hero = heroRepository.findById(id);

		Hero h = new Hero();
		h.setId(hero.getId());
		h.setName(hero.getName());
		return h;

	}

	/**
	 * save Hero
	 */
	public void saveHero(Hero heros) {
		HeroEntity hero = new HeroEntity();

		hero.setName(heros.getName());
		heroRepository.save(hero);
	}

	/**
	 * delete Hero
	 * @param id
	 */
	public void deleteHero(int id) {

		heroRepository.deleteById(id);
	}

	/**
	 * update Hero 
	 * @param hero
	 */
	public void updateHero(Hero hero) {
		HeroEntity he = new HeroEntity();
		he.setId(hero.getId());
		he.setName(hero.getName());
		heroRepository.save(he);
	}

	/**
	 * search Hero by keyword
	 * @param name
	 * @return
	 */
	public List<Hero> searchHeroByName(String name) {
		List<HeroEntity> heroes = heroRepository.getHeroByNameLike(name);
		List<Hero> hero = new ArrayList<>();
		for (HeroEntity hs : heroes) {
			Hero h = new Hero();
			h.setId(hs.getId());
			h.setName(hs.getName());
			hero.add(h);
		}
		return hero;
	}
}

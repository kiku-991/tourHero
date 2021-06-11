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
		h.setAge(hero.getAge());
		h.setImg(hero.getImg());
		return h;

	}

	/**
	 * save Hero
	 */
	public void saveHero(Hero heros) {
		HeroEntity hero = new HeroEntity();

		hero.setName(heros.getName());
		hero.setAge(hero.getAge());
		hero.setImg(hero.getImg());
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
		he.setAge(hero.getAge());
		//String old = hero.getImg();
//		String newUrl = old.replace("C:\\fakepath\\", "");
//		String nowUrl = Url.SRC + newUrl;
		he.setImg(hero.getImg());
		heroRepository.save(he);

		//savePic(file, Url.SAVEPATH + newUrl);

	}

	/*private void savePic(MultipartFile file, String fileName) {
	
		OutputStream os = null;
		try {
			String path = "D:\\testFile\\";
			// 2、保存到临时文件
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流保存到本地文件
	
			File tempFile = new File(path);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
			// 开始读取
			while ((len = file.getInputStream().read(bs)) != -1) {
				os.write(bs, 0, len);
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 完毕，关闭所有链接
			try {
				os.close();
				file.getInputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}*/

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

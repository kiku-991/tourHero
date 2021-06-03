package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.entity.HeroEntity;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Integer> {

	HeroEntity findById(int id);

	List<HeroEntity> findAllByOrderByIdAsc();

	
	@Query(value = "select\r\n"
			+ "    * \r\n"
			+ "from\r\n"
			+ "    hero \r\n"
			+ "where\r\n"
			+ "    name like concat(concat('%', :key ),'%')", nativeQuery = true)

	List<HeroEntity> getHeroByNameLike(String key);

}

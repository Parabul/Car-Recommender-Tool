package com.parabul.adviser.dao.reposiroties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.parabul.adviser.dao.entities.CarInfo;

@Repository
public interface CarInfoRepository extends JpaRepository<CarInfo, Long>, QueryDslPredicateExecutor<CarInfo> {

	List<CarInfo> findByTitle(String title);

	@Query("select c.title from CarInfo c group by c.title order by count(c.id) desc")
	List<String> getTitles();

	@Query("select DISTINCT(c.transmissiontype) from CarInfo c")
	List<String> getTransmissiontype();
}

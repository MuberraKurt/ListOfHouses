package com.project.houses.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.houses.entities.concretes.House;

public interface HouseDao extends JpaRepository<House,Integer> {
	House getByPropertyName(String propertyName);
	
	List<House> getByIdOrPropertyName(int id,String propertyName);
	
	@Query("From House where id=:id and propertyName=:propertyName")
	List<House> getByIdAndName(int id,String propertyName);
	
	List<House> getByPropertyNameStartsWith(String propertyName);
	
	List<House> getByPropertyNameContains(String propertyName);
	
}

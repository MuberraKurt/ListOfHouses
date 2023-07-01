package com.project.houses.business.abstracts;

import java.util.List;

import com.project.houses.core.utilities.results.DataResult;
import com.project.houses.core.utilities.results.Result;
import com.project.houses.entities.concretes.House;

public interface HouseService {
	DataResult<List<House>> getAll();
	
	DataResult<List<House>> getAllSorted(String type);
	
	Result add(House house);
	
	DataResult<House> getByPropertyName(String propertyName);
	
	DataResult<List<House>> getAll(int pageNo, int pageSize);
	
	DataResult<List<House>> getByIdOrPropertyName(int id,String propertyName);
	
	DataResult<List<House>> getByIdAndName(int id,String propertyName);
	
	DataResult<List<House>> getByPropertyNameStartsWith(String propertyName);
	
	DataResult<List<House>> getByPropertyNameContains(String propertyName);
}

package com.project.houses.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.project.houses.business.abstracts.HouseService;
import com.project.houses.core.utilities.results.DataResult;
import com.project.houses.core.utilities.results.Result;
import com.project.houses.core.utilities.results.SuccessDataResult;
import com.project.houses.core.utilities.results.SuccessResult;
import com.project.houses.dataAccess.abstracts.HouseDao;
import com.project.houses.entities.concretes.House;

@Service
public class HouseManager implements HouseService {

	private HouseDao houseDao;
	
	@Autowired
	public HouseManager(HouseDao houseDao) {
		super();
		this.houseDao = houseDao;
	}

	@Override
	public DataResult<List<House>> getAll() {

		return new SuccessDataResult<List<House>>
		(this.houseDao.findAll(),"Data listed");
				
	}

	@Override
	public Result add(House house) {
		this.houseDao.save(house);
		return new SuccessResult("House is added.");
	}

	@Override
	public DataResult<House> getByPropertyName(String propertyName) {
		return new SuccessDataResult<House>
		(this.houseDao.getByPropertyName(propertyName),"Data listed");
	}

	@Override
	public DataResult<List<House>> getByIdOrPropertyName(int id, String propertyName) {
		return new SuccessDataResult<List<House>>
		(this.houseDao.getByIdOrPropertyName(id, propertyName),"Data listed");
	}

	@Override
	public DataResult<List<House>> getByIdAndName(int id, String propertyName) {
		//business codes
		
		return new SuccessDataResult<List<House>>
		(this.houseDao.getByIdAndName(id, propertyName),"Data listed");
	}

	@Override
	public DataResult<List<House>> getByPropertyNameStartsWith(String propertyName) {
		return new SuccessDataResult<List<House>>
		(this.houseDao.getByPropertyNameStartsWith(propertyName),"Data listed");
	}

	@Override
	public DataResult<List<House>> getByPropertyNameContains(String propertyName) {
		return new SuccessDataResult<List<House>>
		(this.houseDao.getByPropertyNameContains(propertyName),"Data listed");
	}

	@Override
	public DataResult<List<House>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
	
		return new SuccessDataResult<List<House>>
		(this.houseDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<House>> getAllSorted(String type) {
		if(type.equals("Desc")) {
			Sort sort=Sort.by(Sort.Direction.DESC,"propertyName");
			return new SuccessDataResult<List<House>>
			(this.houseDao.findAll(sort));
		}else {
			Sort sort=Sort.by(Sort.Direction.ASC,"propertyName");
			return new SuccessDataResult<List<House>>
			(this.houseDao.findAll(sort));
		}
	} 

}

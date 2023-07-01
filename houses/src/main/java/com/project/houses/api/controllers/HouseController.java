package com.project.houses.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.houses.business.abstracts.HouseService;
import com.project.houses.core.utilities.results.DataResult;
import com.project.houses.core.utilities.results.ErrorDataResult;
import com.project.houses.entities.concretes.House;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/houses")
public class HouseController {
	
	private HouseService houseService;
	
	@Autowired
	public HouseController(HouseService houseService) {
		super();
		this.houseService = houseService;
	}

	@GetMapping("/getAll")
	public DataResult<List<House>> getAll(){
		return this.houseService.getAll();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<House>> getAll(int pageNo, int pageSize){
		return this.houseService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSortedAsPropertyName(Desc or Asc)")
	public DataResult<List<House>> getAllSorted(String type){
		return this.houseService.getAllSorted(type);
	}
	
	/*
	 * @PostMapping("/add") 
	 * public Result add(@RequestBody House house){
	 * return this.houseService.add(house); 
	 * }
	 */
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody House house){
		return ResponseEntity.ok(this.houseService.add(house));
	}
	
	@GetMapping("/getByPropertyName")
	public DataResult<House> getByPropertyName(@RequestParam String propertyName){
		return this.houseService.getByPropertyName(propertyName);
	}
	
	@GetMapping("/getByIdOrPropertyName")
	public DataResult<List<House>> getByIdOrPropertyName(@RequestParam int id,@RequestParam String propertyName){
		return this.houseService.getByIdOrPropertyName(id, propertyName);
	}
	
	@GetMapping("/getByIdAndName")
	public DataResult<List<House>> getByIdAndName(@RequestParam int id,@RequestParam String propertyName){
		return this.houseService.getByIdAndName(id, propertyName);
	}
	
	@GetMapping("/getByPropertyNameStartsWith")
	public DataResult<List<House>> getByPropertyNameStartsWith(@RequestParam String propertyName){
		return this.houseService.getByPropertyNameStartsWith(propertyName);
	}
	
	@GetMapping("/getByPropertyNameContains")
	public DataResult<List<House>> getByPropertyNameContains(@RequestParam String propertyName){
		return this.houseService.getByPropertyNameContains(propertyName);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<Integer, String> validationErrors =new HashMap<Integer,String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.hashCode(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors
		=new ErrorDataResult<Object>(validationErrors,"Validation Errors");
		return errors;
	}
}

package com.project.houses.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="housing_prices")
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="property_name")
	private String propertyName;
	
	@Column(name="price")
	private int price;
	
	@Column(name="house_type")
	private String houseType;
	
	@Column(name="area_in_sq_ft")
	private int area;
	
	@Column(name="no_of_bedrooms")
	private int noOfBedrooms;
	
	@Column(name="no_of_bathrooms")
	private int noOfBathrooms;
	
	@Column(name="no_of_receptions")
	private int noOfReceptions;
	
	@Column(name="location")
	private String location;
	
	@Column(name="city_county")
	private String cityCounty;
	
	@Column(name="postal_code")
	private String postalCode;
	
}

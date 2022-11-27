package com.nairv.microservices.service;

import java.util.UUID;

import com.nairv.microservices.dto.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);

	BeerDto createBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);
	
	String deleteBeer(UUID beerId);

}

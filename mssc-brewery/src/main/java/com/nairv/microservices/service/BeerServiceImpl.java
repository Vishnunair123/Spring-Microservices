package com.nairv.microservices.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nairv.microservices.dto.BeerDto;

@Service
public class BeerServiceImpl implements BeerService{

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(beerId)
				.beerName("Kingfisher").beerStyle("brewery").build();
	}

	@Override
	public BeerDto createBeer(BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("bira").beerStyle("brewery").build();
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		return BeerDto.builder().id(beerId).beerName("haywards500").beerStyle("brewery").build();
	}
	
	@Override
	public String deleteBeer(UUID beerId) {
		return "No Beer found!!!";
	}

}

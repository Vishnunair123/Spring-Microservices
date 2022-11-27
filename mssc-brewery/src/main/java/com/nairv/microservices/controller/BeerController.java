package com.nairv.microservices.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nairv.microservices.dto.BeerDto;
import com.nairv.microservices.service.BeerService;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	private BeerService beerService;
	
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> handlePost(@RequestBody BeerDto beerDto) {
		BeerDto savedBeerDto = beerService.createBeer(beerDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/v1/beer/"+savedBeerDto.getId().toString());
		return new ResponseEntity<>(headers.entrySet(), HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
		BeerDto updateBeerDto = beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity<>(updateBeerDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{beerId}")
	public String deleteBeer(@PathVariable("beerId") UUID beerId){
		return beerService.deleteBeer(beerId);
	}
}

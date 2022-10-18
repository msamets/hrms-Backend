package hrms.lecture63.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hrms.lecture63.business.abstracts.CityService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.City;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {
	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody City city) {
		return ResponseEntity.ok(this.cityService.add(city));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}


}

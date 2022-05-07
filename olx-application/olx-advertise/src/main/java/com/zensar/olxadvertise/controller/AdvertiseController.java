package com.zensar.olxadvertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.entity.AdvertiseDetails;
import com.zensar.service.AdvertiseService;

@RestController
// @RequestMapping(produces=
// {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, consumes=
// { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
public class AdvertiseController {

	@Autowired
	private AdvertiseService advertiseService;

	@PostMapping(value = "/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Advertise> addAdvertise(@RequestBody Advertise ads,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		Advertise advertise = advertiseService.addAdvertise(ads, username, password);
		return new ResponseEntity<Advertise>(advertise, HttpStatus.CREATED);
	}

	@GetMapping(value = "/user/advertise/{postId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Advertise getAdvertise(@PathVariable long postId, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		return advertiseService.getAdvertise(postId, username, password);

	}

	@PutMapping(value = "/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Advertise updateAdvertise(@PathVariable long id, @RequestBody Advertise advertises,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		return advertiseService.updateAdvertise(id, advertises, username, password);

	}

	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Advertise> getAllAdvertise(@RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		return advertiseService.getAllAdvertise(username, password);
	}

	@DeleteMapping(value = "/user/advertise/{postId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public boolean deleteAdvertise(@PathVariable("postId") long id, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		return advertiseService.deleteAdvertise(id, username, password);
	}

	@GetMapping(value = "/advertise/search/{filtercriteria}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Advertise searchAdvertisementsByCriteria(@PathVariable long filtercriteria, String category, String toDate,
			String fromDate) {
		return advertiseService.searchAdvertisementsByCriteria(category, toDate, filtercriteria, fromDate);
	}

	@GetMapping(value = "/advertise/search", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Advertise> searchAdvertise() {

		return advertiseService.searchAdvertise();

	}

	@GetMapping(value = "/advertise/{postId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseDetails> advertiseDetails(@PathVariable("postId") long id,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {

		return advertiseService.advertiseDetails(id, username, password);

	}

}

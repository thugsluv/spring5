package io.namoosori.travelclub.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.web.shared.NameValueList;

@RestController
@RequestMapping("/club")  // 공통으로 설계된 /club을 삭제 할 수 있다.
public class ClubController {
	
//	@GetMapping("/test")
//	public String test() {
//		return "Hello String MVC~~";
//	}
	
	private ClubService clubService;
	
	public ClubController(ClubService clubService) {
		this.clubService = clubService;
	}
	
	//@PostMapping("/club") // localhost:8090/club
	@PostMapping // localhost:8090/club
	public String register(@RequestBody TravelClubCdo travelClubCdo) {
		return clubService.registerClub(travelClubCdo);
	}
	
	//@GetMapping("/club/all")
	@GetMapping("/all")
	public List<TravelClub> findAll(){
		return clubService.findAll();
	}
	
	//@GetMapping("/club/{clubId}")
	@GetMapping("/{clubId}")
	public TravelClub find(@PathVariable String clubId) {
		return clubService.findClubById(clubId);
	}
	
	//@GetMapping("/club")  // localhost:8090/club?name=javaclub
	@GetMapping  // localhost:8090/club?name=javaclub
	public List<TravelClub> findByName(@RequestParam String name){
		return clubService.findClubsByName(name);
	}
	
	//@PutMapping("/club/{clubId}")
	@PutMapping("/{clubId}")
	public void modify(@PathVariable String clubId, @RequestBody NameValueList nameValueList) {
		clubService.modify(clubId, nameValueList);
	}
	
	//@DeleteMapping("/club/{clubId}")
	@DeleteMapping("/{clubId}")
	public void delete(@PathVariable String clubId) {
		clubService.remove(clubId);
	}
}

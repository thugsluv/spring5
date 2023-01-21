package io.namoosori.travelclub.spring;

import java.util.Arrays;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;

public class TravelClubApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanNames));
		
		/*
		TravelClubCdo clubCdo = new TravelClubCdo("TravelClub","Test TravelClub");
		ClubService clubService = context.getBean("clubService", ClubService.class);
		
		
		String clubId = clubService.registerClub(clubCdo);
		
		
		TravelClub foundedClub = clubService.findClubById(clubId);
		System.out.println("Club name " + foundedClub.getName());
		System.out.println("Club intro " + foundedClub.getIntro());
		System.out.println("Club foundationTime " + new Date( foundedClub.getFoundationTime() ) );
		
		System.out.println("ID : "+clubId);
		*/
	
		
		MemberService memberSerivce = context.getBean("memberServiceLogic", MemberService.class);
		
		String memberId = memberSerivce.registerMember(
					new MemberCdo("test@test.com", "Lee", "Test Man", "010-2222-3333", "1980-06-01")
				);
		
		CommunityMember foundedMember = memberSerivce.findMemberById(memberId);
		System.out.println( foundedMember.toString() );
	}

}

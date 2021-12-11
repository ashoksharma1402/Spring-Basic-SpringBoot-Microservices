package com.ashokit.jwttest;

import com.ashokit.util.JwtUtil;

import io.jsonwebtoken.Claims;

public class Test {
	public static void main(String[] args) {
//		//generating key
//		String key="NIT";
//		
//		//Generating token
//		String token=
//					Jwts.builder()
//						.setId("A5266")
//						.setSubject("AJAY")
//						.setIssuer("NareshIT")
//						.setIssuedAt(new Date(System.currentTimeMillis()))
//						.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))
//						.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes()))
//						.compact();
//		System.out.println(token);
//		//Pasring or read or validiating or claiminf token
//		Claims c= 
//				Jwts.parser()
//					.setSigningKey(Base64.getEncoder().encode(key.getBytes()))	//secreate key
//					.parseClaimsJws(token)
//					.getBody();
//		
//		System.out.println(c.getSubject());
//		System.out.println(c.getId());
//		System.out.println(c.getIssuer());
//		System.out.println(c.getExpiration());
		
	JwtUtil util=new JwtUtil();
	String key = "ASHOKIT";
	String token = util.generateToken("AA885", "ASHU", key );
	System.out.println(token);
	
	Claims c = util.getClaims("NITTEST", token);
	
	System.out.println(c.getId());
	System.out.println(c.getSubject());
	System.out.println(c.getExpiration());
	
	
	
	}

}

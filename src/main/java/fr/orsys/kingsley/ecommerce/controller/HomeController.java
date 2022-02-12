package fr.orsys.kingsley.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.kingsley.ecommerce.dto.JwtRequest;
import fr.orsys.kingsley.ecommerce.dto.JwtResponse;
import fr.orsys.kingsley.ecommerce.serviceImpl.MyUserDetailsService;
import fr.orsys.kingsley.ecommerce.utils.JwtUtility;

@RestController
public class HomeController {
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to JWT Tutorial";
	}
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

	    try{
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        jwtRequest.getUsername(),
	                        jwtRequest.getPassword()
	                )
	        );
	    } catch (BadCredentialsException e) {
	        throw new Exception("Invalid Credentials", e);
	    }

	    final UserDetails userDetails
	            = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

	    final String token =
	            jwtUtility.generateToken(userDetails);

	    return new JwtResponse(token);
	}
}

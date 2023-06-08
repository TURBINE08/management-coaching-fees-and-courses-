package com.imgglobalinfotech.fees.management.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.imgglobalinfotech.fees.management.healper.JwtUtil;
import com.imgglobalinfotech.fees.management.service.CustomUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// get token 1st
		String requestToken = request.getHeader("Authorization");
		// Authorization is use to hold header token
		// and we send the token in Authorization key
		// and token start with Bearer example Bearer 58754fjfjiefe5f5
		// here 58754fjfjiefe5f5 this is the actual token
		System.err.println(requestToken);
		String username = null;
		String token = null;
		if (requestToken != null && requestToken.startsWith("Bearer ")) {
			token = requestToken.substring(7);
			try {
				username = this.jwtTokenHelper.GetUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				System.out.println("unable to get Jwt token");
			} catch (ExpiredJwtException e) {
				System.out.println("jwt token has expired");
			} catch (MalformedJwtException e) {
				System.out.println("invalid jwt exception");
			}

			// once we get the token, now validate the token (2nd step)
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
				if (this.jwtTokenHelper.validateToken(token, userDetails)) {
					// if condition is true then it start to validate

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken); // set
																									// above
				} else {
					System.out.println("invalid jwt token");
				}

			} else {
				System.out.println("username is null or context is not null");

			}

//			filterChain.doFilter(request, response);

		} else {
			System.out.println("jwt token does not begin with Bearer");
		}

		filterChain.doFilter(request, response);

	}
}

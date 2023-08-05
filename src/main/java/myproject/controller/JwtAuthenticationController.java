package myproject.controller;//package com.controller.jwt;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import myproject.domain.Student;
import myproject.jwt.JwtRequest;
import myproject.jwt.JwtResponse;
import myproject.jwt.JwtTokenUtil;
import myproject.service.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jwt")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class JwtAuthenticationController {
   AuthenticationManager authenticationManager;
   JwtTokenUtil jwtTokenUtil;

   UserDetailsService service;

   StudentServiceImpl studentServiceImpl;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = service.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registration")
    public void registration(@RequestBody Student user) {
        studentServiceImpl.add(user);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            /*
            * Attempts to authenticate the passed {@link Authentication} object, returning a
             * fully populated <code>Authentication</code> object (including granted authorities)
             * if successful.
            * */

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

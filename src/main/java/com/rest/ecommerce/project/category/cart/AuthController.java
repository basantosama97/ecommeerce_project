package com.rest.ecommerce.project.category.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;


    @RequestMapping("/hello")
    public String hello(){
        return  "Basant is here";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
       try {
           Authentication authenticate = authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
           );
       } catch (BadCredentialsException e){
           throw new Exception("Incorrect username or password", e);
       }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

    @PostMapping("/user/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {


        if(userRepository.findUserByEmail(signUpRequest.getEmail()) != null) {
            return new ResponseEntity(new NormalApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }


        // Creating user's account
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUsername(signUpRequest.getName());
        jwtUser.setPhoneNumber(signUpRequest.getPhoneNumber());
        jwtUser.setEmail(signUpRequest.getEmail());
        jwtUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        jwtUser.setLoggedIn(true);
//        jwtUser.setAddress((List<address>) signUpRequest.getAddress());
        userRepository.save(jwtUser);

        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", jwtUser));

    }

    @PostMapping("/add/address")
    public ResponseEntity<?> addAddress (@Valid @RequestBody AddressRequest addressRequest){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object currentPrincipalName = authentication.getDetails();

        JwtUser user = userRepository.findByEmail(authentication.getName());

        address address1 = new address();
        address1.setBlock_(addressRequest.getBlock());
        address1.setBuilding(addressRequest.getBuilding());
        address1.setCity(addressRequest.getCity());
        address1.setFloor(addressRequest.getFloor());
        address1.setExtraInfo(addressRequest.getExtraInfo());
        address1.setStreet(addressRequest.getStreet());
        address1.setUser(user);
        addressRepository.save(address1);
        user.getAddress().add(address1);
        userRepository.save(user);

        return ResponseEntity.ok(new NormalApiResponse(true, "User registered successfully"));

    }

//    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    @ResponseBody
//    public Object currentUserName(Authentication authentication) {
//        return authentication.getPrincipal();
//    }


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsernameOrEmail());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


}
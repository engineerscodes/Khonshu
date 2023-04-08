package com.engineerscodes.app.Controller;


import com.engineerscodes.app.Config.Config;
import com.engineerscodes.app.Entity.person;
import com.engineerscodes.app.repository.PersonRepo;
import org.keycloak.common.VerificationException;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;



@RestController
public class AccountController {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    Config config;


    @PostMapping ("/setup")
    public String AccountSetup(@RequestBody  person p)  {
        String token = config.token();
        try {
            AccessToken accessToken = config.getAccessToken();
            System.out.println(accessToken);
        } catch (VerificationException e) {
            throw new RuntimeException(e);
        }

        personRepo.save(p);

       return "NULL";
    }

    @GetMapping("/all")
    public String accounts(){
        return "all";
    }


}

package com.engineerscodes.app.Controller;


import com.engineerscodes.app.Entity.person;
import com.engineerscodes.app.Util.Node;
import com.engineerscodes.app.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;



@RestController
public class AccountController {

    @Autowired
    PersonRepo personRepo;


    @PostMapping ("/setup")
    public String AccountSetup(@RequestBody  person p)  {
        personRepo.save(p);
       return "NULL";
    }


}

package com.engineerscodes.app.Controller;


import com.engineerscodes.app.Util.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("/account")
@ComponentScan({"com.engineerscodes.app.Util"})
public class AccountController {

    @Autowired
    Node node;

    @GetMapping("/setup")
    public String AccountSetup()  {
       return node.getIP();
    }


}

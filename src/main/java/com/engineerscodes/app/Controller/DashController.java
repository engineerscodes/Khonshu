package com.engineerscodes.app.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author NAVEEN ,
 * 05 Mar, 2023
 */

@RestController
@RequestMapping("/chats")
public class DashController {


    @GetMapping("/")
    public String processlist(){
       return "Hi : -> <- " ;
    }

}

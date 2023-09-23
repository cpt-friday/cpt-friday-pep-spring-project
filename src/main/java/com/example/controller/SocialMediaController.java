package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.*;
import com.example.repository.AccountRepository;
import com.example.service.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {
    AccountService as;
    MessageService ms;
    @Autowired
    public SocialMediaController(AccountService as, MessageService ms){
        this.as = as;
        this.ms = ms;
    }

    @PostMapping("register")
    public ResponseEntity<Account> register(@RequestBody Account acc){
        if(as.accountNameExists(acc.getUsername())){
            return ResponseEntity.status(409).build();
        }
        Optional<Account> opt = as.addAccount(acc);
        return opt.isEmpty() ? (
            ResponseEntity.status(400).build()
        ) : ResponseEntity.status(200).body(opt.get());
        
    }

    @PostMapping("login")
    public ResponseEntity<Account> login(@RequestBody Account acc){
        Optional<Account> opt = as.getAccountByUsername(acc.getUsername());
        if(opt.isEmpty()) return ResponseEntity.status(401).build();
        Account logged = opt.get();
        if(!logged.getPassword().equals(acc.getPassword())) return ResponseEntity.status(401).build();
        return ResponseEntity.status(200).body(logged);
    }

    //messages
    //messages/{message_id}
    //accounts/{account_id}/messages
}

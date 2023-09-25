package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.*;
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

    // @PostMapping("register")
    // public ResponseEntity<Account> register(@RequestBody Account acc){
    //     if(as.accountNameExists(acc.getUsername())){
    //         return ResponseEntity.status(409).build();
    //     }
    //     Optional<Account> opt = as.addAccount(acc);
    //     return opt.isEmpty() ? (
    //         ResponseEntity.status(400).build()
    //     ) : ResponseEntity.status(200).body(opt.get());
        
    // }

    // @PostMapping("login")
    // public ResponseEntity<Account> login(@RequestBody Account acc){
    //     Optional<Account> opt = as.getAccountByUsername(acc.getUsername());
    //     if(opt.isEmpty()) return ResponseEntity.status(401).build();
    //     Account logged = opt.get();
    //     if(!logged.getPassword().equals(acc.getPassword())) return ResponseEntity.status(401).build();
    //     return ResponseEntity.status(200).body(logged);
    // }

    // //failed blank message test
    // @PostMapping("messages")
    // public ResponseEntity<Message> createMessage(@RequestBody Message msg){
    //     if(!as.accountExists(msg.getPosted_by())) return ResponseEntity.status(400).build();
    //     Optional<Message> opt = ms.addMessage(msg);
    //     return opt.isEmpty() ? (
    //         ResponseEntity.status(400).build()
    //     ) : ResponseEntity.status(200).body(opt.get());
    // }

    // @GetMapping("messages")
    // public ResponseEntity<List<Message>> getAllMessages(){
    //     return ResponseEntity.status(200).body(ms.getAllMessages());
    // }

    // //failed both tests
    // @GetMapping("messages/{message_id}")
    // public ResponseEntity<Message> getMessageByID(@PathVariable int messageID){
    //     //TODO
    // }

    // @DeleteMapping("messages/{message_id}")
    // public ResponseEntity<Message> deleteMessageByID(@PathVariable int message_id){
    //     Optional<Message> delMSG = ms.getMessageByID(message_id);
    //     if(delMSG.isEmpty()) return ResponseEntity.status(200).build();
    //     ms.deleteMessage(message_id);
    //     return ResponseEntity.status(200).body(delMSG.get());
    // }

    // @PatchMapping("messages/{message_id}")
    // public ResponseEntity<Message> updateMessageByID(@PathVariable int message_id, @RequestBody Message newMSG){

    // }

    // @GetMapping("accounts/{account_id}/messages")
    // public ResponseEntity<Message> getMessagesFromAccount(@PathVariable int account_id){

    // }


    /**
     * TODO:
     *      Methods:
     *          - update message given ID
     *          - get all messages given accountID
     *      Debug:
     *          - fix blank message create
     *          - fix get message by ID
     * 
     * 
     * 
     *      Strategies:
     *          - Make ResponseEntity and build it up before returning it?
     *          - Assume everything in repo layer and service layer goes right unless exceptions are thrown
     */
}

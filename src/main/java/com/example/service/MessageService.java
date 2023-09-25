package com.example.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.*;
import com.example.exception.*;

@Service
public class MessageService {
    AccountRepository ar;
    MessageRepository mr;
    @Autowired
    public MessageService(AccountRepository ar, MessageRepository mr){
        this.ar = ar;
        this.mr = mr;
    }

    public Message addMessage(Message msg){
        if(msg.getMessage_text().isBlank() || msg.getMessage_text().length() >= 255) throw new InvalidContentsException("Message text is either blank or too long", new Throwable());
        return mr.save(msg);
    }

    public List<Message> getAllMessages(){
        return mr.findAll();
    }

    public Message getMessageByID(int messageID) throws MessageNotExistsException{
        Optional<Message> opt = mr.findById(messageID);
        if(opt.isEmpty()) throw new MessageNotExistsException("Message with specfied ID does not exist here", new Throwable());
        return opt.get();
    }

    public List<Message> getByUserKey(int postedBy) throws AccountNotExistsException{
        Optional<Account> opt = ar.findById(postedBy);
        if(opt.isEmpty()) throw new AccountNotExistsException("Account cannot be found, messages unable to be retrieved", new Throwable());
        return mr.findAllPostedBy(postedBy);
    }

    public void deleteMessage(int id){
        mr.deleteById(id);
    }

    public void updateMessage(int id, Message nMsg) throws MessageNotExistsException{
        Optional<Message> opt = mr.findById(id);
        if(opt.isEmpty()) throw new MessageNotExistsException("Message with ID doesn't exist, cannot be updated", new Throwable());
        if(nMsg.getMessage_text().isBlank() || nMsg.getMessage_text().length() >= 255) throw new InvalidContentsException("Invalid contents for message to be updated", new Throwable());
        Message msg = opt.get();
        msg.setMessage_text(nMsg.getMessage_text());
        mr.save(msg);
    }
    
}

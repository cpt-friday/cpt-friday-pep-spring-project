package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    MessageRepository mr;
    @Autowired
    public MessageService(MessageRepository mr){
        this.mr = mr;
    }

    public Optional<Message> addMessage(Message msg){
        if(msg.getMessage_text().isBlank() || msg.getMessage_text().length() >= 255) return null;
        else return Optional.of(mr.save(msg));
    }

    public List<Message> getAllMessages(){
        return mr.findAll();
    }

    public Message getMessageByID(int id){
        Optional<Message> opt = mr.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }

    public void deleteMessage(int id){
        mr.deleteById(id);
    }

    public void updateMessage(int id, Message nMsg){
        Optional<Message> opt = mr.findById(id);
        if(opt.isPresent()){
            Message msg = opt.get();
            msg.setMessage_text(nMsg.getMessage_text());
            msg.setPosted_by(nMsg.getPosted_by());
            msg.setTime_posted_epoch(nMsg.getTime_posted_epoch());
            mr.save(msg);
        }
    }
}

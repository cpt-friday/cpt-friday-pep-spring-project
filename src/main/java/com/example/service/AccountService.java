package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    AccountRepository ar;
    @Autowired
    public AccountService(AccountRepository ar){
        this.ar = ar;
    }

    //Given an account object, this method adds (persists) account object to database
    public Optional<Account> addAccount(Account acc){
        if(acc.getUsername().isBlank() || acc.getPassword().length() < 4) return null;
        else return Optional.of(ar.save(acc));
    }

    public List<Account> getAllAccounts(){
        return ar.findAll();
    }

    public Optional<Account> getAccountByID(int id){
        return ar.findById(id);
    }

    public boolean accountNameExists(String username){
        return ar.existsByUsername(username);
    }

    public Optional<Account> getAccountByUsername(String username){
        return ar.findByUsername(username);
    }

    public void deleteAccountByID(int id){
        ar.deleteById(id);
    }

    public void updateAccount(int id, Account nAcc){
        Optional<Account> opt = ar.findById(id);
        if(opt.isPresent()){
            Account acc = opt.get();
            acc.setUsername(nAcc.getUsername());
            acc.setPassword(nAcc.getPassword());
            ar.save(acc);
        }
    }
}

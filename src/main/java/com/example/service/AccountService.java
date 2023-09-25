package com.example.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.exception.*;

@Service
public class AccountService {
    AccountRepository ar;
    @Autowired
    public AccountService(AccountRepository ar){
        this.ar = ar;
    }

    public Account addAccount(Account acc){
        if(acc.getUsername().isBlank() || acc.getPassword().length() < 4){
            throw new InvalidContentsException("Username is blank and/or password is below 4 characters long", new Throwable());
        }
        return ar.save(acc);
    }

    public List<Account> getAllAccounts(){
        return ar.findAll();
    }

    public Account getAccountByID(int accountID) throws AccountNotExistsException{
        Optional<Account> opt = ar.findById(accountID);
        if(opt.isEmpty()) throw new AccountNotExistsException("Account with such ID does not exist", new Throwable());
        return opt.get();
    }

    public boolean accountNameExists(String username){
        return ar.existsByUsername(username);
    }

    public boolean accountExists(int id){
        return ar.existsById(id);
    }

    public Account getAccountByUsername(String username) throws AccountNotExistsException{
        Optional<Account> opt = ar.findByUsername(username);
        if(opt.isEmpty()) throw new AccountNotExistsException("Account with such Username does not exist", new Throwable());
        return opt.get();
    }

    public void deleteAccountByID(int accountID){
        ar.deleteById(accountID);
    }

    public void updateAccount(int id, Account nAcc) throws AccountNotExistsException{
        Optional<Account> opt = ar.findById(id);
        if(opt.isEmpty()) throw new AccountNotExistsException("Account with that ID cannot be found, cannot be updated", new Throwable());
        if(nAcc.getUsername().isBlank() || nAcc.getPassword().length() < 4) throw new InvalidContentsException("Invalid parameters for account to be updated", new Throwable());
        Account acc = opt.get();
        acc.setUsername(nAcc.getUsername());
        acc.setPassword(nAcc.getPassword());
        ar.save(acc);
    }
}

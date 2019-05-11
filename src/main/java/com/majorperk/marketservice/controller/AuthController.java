package com.majorperk.marketservice.controller;

import com.majorperk.marketservice.model.Account;
import com.majorperk.marketservice.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public boolean authenticate(@RequestBody Auth auth) {
        
        try {
            Account account = accountRepository.findByEmail(auth.username);
            
            if (auth.password.equals(account.getPassword())) {
                return true;
            } else {
                return false;
            }

        } catch (NullPointerException np ) {
            System.out.println("Unable to find user: " + auth.username);
            return false;

        } catch (Exception e) {
            System.out.println("Unable to authenticate user: " + auth.username + " ::: " + e);

            return false;
        }
    }

}

class Auth {
    String username;
    String password;
    String jwt;
    boolean remember;

    Auth() {
    }

    Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    Auth(String username, String password, boolean remember) {
        this.username = username;
        this.password = password;
        this.remember = remember;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * @param jwt the jwt to set
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    /**
     * @return the remember
     */
    public boolean isRemember() {
        return remember;
    }

    /**
     * @param remember the remember to set
     */
    public void setRemember(boolean remember) {
        this.remember = remember;
    }

}
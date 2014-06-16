package com.its.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author alexander
 */
public class AppController {
    
    protected static String appTitle = "Issue Tracking System";
    
    protected String getHashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);        
    }
}

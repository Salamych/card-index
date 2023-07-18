package com.hubbersport.mokito.test_double.dummy;

public class DummyEmailService implements EmailService{

    @Override
    public void sendEmail(String message) {
        throw new AssertionError("Method not implemented !!!");
    }
    
}

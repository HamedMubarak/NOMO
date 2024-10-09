package org.device;

import org.base.Base;
import org.screens.Checkout;
import org.screens.Home;
import org.screens.LoginForm;

public class Device extends Base {

    public Home home;
    public LoginForm loginForm;
    public Checkout checkout;

    public Device(){
        home = new Home();
        loginForm = new LoginForm();
        checkout = new Checkout();
    }
}

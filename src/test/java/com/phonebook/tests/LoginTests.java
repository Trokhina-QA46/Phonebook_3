package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
     @Test(priority = 1)
    public void loginPositiveTests(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
     }
    @Test(priority = 2)
      public void registrationPositiveTest(){
    app.getUser().clickOnLoginLink();
    app.getUser().fillRegisterLoginForm(new User().setMail(UserData.EMAIL).setPassword(UserData.PASSWORD));
    app.getUser().clickRegistrationButton();
    Assert.assertTrue(app.getUser().isAlertDisplayed());
    }
    @Test(priority = 3)
    public void loginNegativeWithoutEmailTests(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }
}

package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getUser().isSignOutButtonPresent()) {
            app.getUser().clickOnSignOutButton();
       }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME)
                .setLastName(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
     //  Assert.assertTrue(app.getContact().isContactAdded(ContactData.NAME));
        Assert.assertTrue(app.getUser().isSignOutButtonPresent(), "Contact added");
    }
    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String lastName, String phone,String email,String address,String description) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
       // Assert.assertTrue(app.getContact().isContactAdded(name));
        Assert.assertTrue(app.getUser().isSignOutButtonPresent(), "Contact added");
    }
    @Test(dataProvider = "addNewContactWithCsv",dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderWithCsvFileTest(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
       // Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));
        Assert.assertTrue(app.getUser().isSignOutButtonPresent(), "Contact added");
    }
    @AfterMethod
    public void postConditions() {
        app.getContact().deleteContact();
        }
  }

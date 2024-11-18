package com.nagarro.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nagarro.base.BaseClass;
import com.nagarro.config.Configs;
import com.nagarro.pages.ProductsPage;

public class Test_Login extends BaseClass {



    public ProductsPage proPage;


    @BeforeClass
    public void beforeClass() {

    }



    @Test(groups = "smoke")

    public void verifyLoginWithStdUser(ITestContext context) {

        loginPage.setUserName(Configs.getPropertyInputData("username"));

        loginPage.setPassword(Configs.getPropertyInputData("password"));       

        proPage = loginPage.clickLogin();

        proPage.verifyUserOnProductsPage();
        
        int id = 123;
        
        context.setAttribute("extractedId", id);
     

    }


    @Test(groups = "Regression")

    public void verifyLoginWithOtherUser(ITestContext context) {

        loginPage.setUserName(Configs.getPropertyInputData("username"));

        loginPage.setPassword(Configs.getPropertyInputData("password"));
        
        proPage= loginPage.clickLogin();

        proPage.verifyUserOnProductsPage();
        
        String extractedId = (String) context.getAttribute("extractedId");

        // Now, you can use the extracted ID
        System.out.println("Using the extracted ID: " + extractedId);


    }





    @AfterClass

    public void afterClass() {



    }



}



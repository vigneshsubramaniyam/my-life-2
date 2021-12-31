package org.test.Test;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
       Libglobal l=new Libglobal();
       l.getdriver();
       l.loadurl("http://adactinhotelapp.com/");
       WebElement txtUser = l.findElementById("username");
    l.insertValue(txtUser, l.getData(1, 0));
    WebElement txtPass = l.findElementById("password");
    l.insertValue(txtPass, l.getData(1, 1));
  
    WebElement btnLogin = l.findElementById("login");
    l.click(btnLogin);
    }
}

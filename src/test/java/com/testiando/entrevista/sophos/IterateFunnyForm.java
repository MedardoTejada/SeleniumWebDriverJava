package com.testiando.entrevista.sophos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IterateFunnyForm {

    public static void main(String[] args) {

        // iniciamos estableciendo variables reutilizables y configuración del navegador
        String url = "https://tasks.evalartapp.com/automatization/forms/test";
        int initialCycle = 1;
        int finalCycle = 10;
        String nameUser = "678823";
        String passwordUser = "10df2f32286b7120Mi00LTMyODg3Ng==30e0c83e6c29f1c3";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Inicio del ciclo
        while (initialCycle <= finalCycle) {
            try {
                // Abrimos navegador e iniciamos sesion
                driver.manage().window().maximize();
                driver.get(url);
                successLoginPage(driver, nameUser, passwordUser);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

                // Luego de iniciar sesion completaremos el formulario
                completePrincipalForm(driver);

                initialCycle++;
            } catch (Exception e) { // Si algo falla reiniciaremos el contador del ciclo
                System.out.println("Error inesperado, reiniciaremos el ciclo: " + e.getMessage());
                initialCycle = 1;
            } finally {
                driver.quit();  //cerramos el navegador siempre que acaba un ciclo
                try {
                    Thread.sleep(1996);  //establecemos un tiempo de espera antes del siguiente ciclo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void completePrincipalForm(WebDriver driver) {

    }

    public static void successLoginPage(WebDriver driver, String nameUser, String passwordUser) {

        try {
            WebElement userNameBox = driver.findElement(By.name("username"));
            WebElement passwordBox = driver.findElement(By.name("password"));

            userNameBox.clear();
            passwordBox.clear();

            userNameBox.sendKeys(nameUser);
            passwordBox.sendKeys(passwordUser);

            userNameBox.submit();
            //passwordBox.submit();
        } catch (Exception e) {
            System.out.println("Error intentando hacer loggin " + e.getMessage());
        }

    }

}

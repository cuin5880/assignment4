package edu.csumb.cst438fa16.hangman.webclient;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User story:
 *
 *  As a user I want to guess a letter to find out the word.  
 *
 * 
 */
public class HangmanAccept{
    
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/hangman.html");
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    /**
     * Acceptance test:
     *  When on the webpage, I will enter a letter as a guess.
     *  That letter will then appear as an already guessed letter.   
     */
    @Test
    public void showGuessedLetter() {
        driver.findElement(By.id("newGuesses")).sendKeys("x");
        driver.findElement(By.id("submit")).click();
        
     
        // The page will close after 30 seconds
        (new WebDriverWait(driver, 30))
        .until(ExpectedConditions.textToBe(By.id("oldGuesses"), "x"));
        
        // Success
    }
}
package questionschecklist;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import java.time.Duration;

import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class DropDownChecklist {
    private WebDriver driver;
    private static By question;
    private static By answer;
    private static String answerText;

    public DropDownChecklist(By question, By answer, String answerText) { //конструктор класса
        DropDownChecklist.question = question;
        DropDownChecklist.answer = answer;
        DropDownChecklist.answerText = answerText;
    }

    @Parameterized.Parameters  //параметризация
    public static Object[][] getCredentials() {
        return new Object[][]{
                {MainPage.questionFirst, MainPage.answerFirst, MainPage.answerFirstText},
                {MainPage.questionSecond, MainPage.answerSecond, MainPage.answerSecondText},
                {MainPage.questionThird, MainPage.answerThird, MainPage.answerThirdText},
                {MainPage.questionFourth, MainPage.answerFourth, MainPage.answerFourthText},
                {MainPage.questionFifth, MainPage.answerFifth, MainPage.answerFifthText},
                {MainPage.questionSix, MainPage.answerSix, MainPage.answerSixText},
                {MainPage.questionSeven, MainPage.answerSeven, MainPage.answerSevenText},
                {MainPage.questionEight, MainPage.answerEight, MainPage.answerEightText}
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.scrollToElement();
        mainPage.clickCookie();
    }

    @Test
    public void shownTextOfQuestionByClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion(question);
        mainPage.getAnswerText(answer);
        MatcherAssert.assertThat(mainPage.getAnswerText(answer), is(answerText));  // списка вопросов
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

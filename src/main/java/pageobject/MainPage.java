package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final String urlHomePage = "https://qa-scooter.praktikum-services.ru/";
    // url главной страницы

    public static By orderButtonAbove = By.xpath(".//button[@class='Button_Button__ra12g']");
    // кнопка Заказать сверху

    public static By orderButtonCenter = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");
    // кнопка заказать по центру

    private final By questionImportant = By.xpath(".//div[text()='Вопросы о важном']");
    // Заголовок Вопросы о важном

    private final By cookieButton = By.id("rcc-confirm-button");
    // кнопка с куки


    //------------Вопросы------------------------------------------
    public static By questionFirst = By.id("accordion__heading-0");
    //вопрос №1 Сколько это стоит? И как оплатить?
    public static By questionSecond = By.id("accordion__heading-1");
    //вопрос №2 Хочу сразу несколько самокатов! Так можно?
    public static By questionThird = By.id("accordion__heading-2");
    //вопрос №3 Как рассчитывается время аренды?
    public static By questionFourth = By.id("accordion__heading-3");
    //вопрос №4 Можно ли заказать самокат прямо на сегодня?
    public static By questionFifth = By.id("accordion__heading-4");
    //вопрос №5 Можно ли продлить заказ или вернуть самокат раньше?
    public static By questionSix = By.id("accordion__heading-5");
    //вопрос №6 Вы привозите зарядку вместе с самокатом?
    public static By questionSeven = By.id("accordion__heading-6");
    //вопрос №7 Можно ли отменить заказ?
    public static By questionEight = By.id("accordion__heading-7");
    //вопрос №8 Я живу за МКАДом, привезёте?


    //------------Ответы на вопросы -----------------------------------
    public static By answerFirst = By.id("accordion__panel-0");
    //Ответ на вопрос №1
    public static By answerSecond = By.id("accordion__panel-1");
    //Ответ на вопрос №2
    public static By answerThird = By.id("accordion__panel-2");
    //Ответ на вопрос №3
    public static By answerFourth = By.id("accord121ion__panel-3");
    //Ответ на вопрос №4
    public static By answerFifth = By.id("accordion__panel-4");
    //Ответ на вопрос №5
    public static By answerSix = By.id("accordion__panel-5");
    //Ответ на вопрос №6
    public static By answerSeven = By.id("accordion__panel-6");
    //Ответ на вопрос №7
    public static By answerEight = By.id("accordion__panel-7");
    //Ответ на вопрос №8


    //-----------Текст ответов на вопросы-------------------------------------
    public static  String answerFirstText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Текст ответа на вопрос №1
    public static  String answerSecondText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Текст ответа на вопрос №2
    public static  String answerThirdText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    //Текст ответа на вопрос №3
    public static  String answerFourthText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Текст ответа на вопрос №4
    public static String answerFifthText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Текст ответа на вопрос №5
    public static String answerSixText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    //Текст ответа на вопрос №6
    public static  String answerSevenText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    //Текст ответа на вопрос №7
    public static  String answerEightText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    //Текст ответа на вопрос №8


    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(urlHomePage);
    }
    //метод открыть страницу

    public void scrollToElement() {
        WebElement element = driver.findElement(questionImportant);//текст вопросы о важном
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //проскролить до заголовка Вопросы о важном

    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }
    //кликнуть на принятие куки

    public void clickQuestion(By question) {
        driver.findElement(question).click();
    }
    //нажать на вопрос

    public String getAnswerText(By answer) {
        return driver.findElement(answer).getText();
    }
    //получить текст ответа на вопрос

    public void clickOrderButton(By orderButton) {
        driver.findElement(orderButton).click();
    }
    //нажать на кнопу Заказать

}

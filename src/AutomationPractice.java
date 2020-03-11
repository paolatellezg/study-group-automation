import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class AutomationPractice {

    public static WebDriver configurationDriver(String page){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
       // WebDriverWait=new WebDriverWait(driver,2);
        System.out.println("Ir a la página");
        driver.navigate().to(page);
        driver.manage().window().maximize();
        return driver;
    }

    class Product{

        //Properties
       private boolean mouseOverStatus;
        private WebElement btnAddToCart, btnQuickView, btnMore, imgProductPhoto;
        private float value;
        private String productName, productCategory;


        Product(){

        }


        //Actions or methods
       public static SelectProduct(int productIndex){

       }
        public static addProduct(int productIndex){

        }
    }
    public static void main(String[] args) throws Exception{

    WebDriver driver= configurationDriver("http://automationpractice.com/index.php?");
    Actions over=new Actions(driver);

    WebElement popularTab=driver.findElement(By.xpath("//*[@class=\"homefeatured\"]"));
    popularTab.click();
    Thread.sleep(3000);
    WebElement productPop= driver.findElement(By.xpath("//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')][4]"));
    over.moveToElement(productPop).perform();
    productPop.click();
    WebElement addToCartButton = productPop.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
    addToCartButton.click();
    Thread.sleep(3000);
    WebElement btnContinueShopping=driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='button-container']//span[contains(@class,'continue')]"));
    btnContinueShopping.click();
    Thread.sleep(3000);


    WebElement bestSellerTab=driver.findElement(By.xpath("//ul[@id='home-page-tabs']//li[2]//a[contains(@class,'blockbestsellers')]"));
    bestSellerTab.click();
    Thread.sleep(3000);
    WebElement productBS=driver.findElement(By.xpath("//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')][3]"));
    productBS.click();
    over.moveToElement(productBS).perform();
    WebElement bestSellerAddCart=productBS.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
    bestSellerAddCart.click();
    Thread.sleep(3000);
    btnContinueShopping=driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='button-container']//span[contains(@class,'continue')]"));
    btnContinueShopping.click();
    Thread.sleep(3000);

    WebElement bestSellerTab=driver.findElement(By.xpath("//ul[@id='home-page-tabs']//li[2]//a[contains(@class,'blockbestsellers')]"));
    bestSellerTab.click();
    Thread.sleep(3000);
    WebElement productBS=driver.findElement(By.xpath("//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')][7]"));
    productBS.click();
    over.moveToElement(productBS).perform();
    WebElement bestSellerAddCart=productBS.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
    bestSellerAddCart.click();
    Thread.sleep(3000);
    btnContinueShopping=driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='button-container']//span[contains(@class,'continue')]"));
    btnContinueShopping.click();
    Thread.sleep(3000);

  driver.close();

    }


}


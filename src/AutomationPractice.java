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

    private static class Product{

        //Properties
       private boolean mouseOverStatus;
        private WebElement btnAddToCart, btnQuickView, btnMore, imgProductPhoto, product;
        private float value;
        private String tabName;
        private int productIndex;
        private WebDriver driver;
        private Actions over;

        public Product(WebDriver driver, String tabName, int productIndex){
        this.tabName=tabName;
        this.productIndex=productIndex;
        this.driver=driver;
        this.over=new Actions(driver);
        }

        //Actions or methods
        public void selectTab (String tabName) throws InterruptedException {//definir tabname en algún lado
            if(tabName=="Popular") {
                WebElement popularTab = this.driver.findElement(By.xpath("//*[@class=\"homefeatured\"]"));
                popularTab.click();
                Thread.sleep(3000);
            }else {
                WebElement bestSellerTab = this.driver.findElement(By.xpath("//ul[@id='home-page-tabs']//li[2]//a[contains(@class,'blockbestsellers')]"));
                bestSellerTab.click();
                Thread.sleep(3000);
            }
        }

       public WebElement overProduct(int productIndex, String tabName){
            WebElement product;
            if(tabName=="Popular") {
                product = this.driver.findElement(By.xpath("//ul[@id='homefeatured']//li[contains(@class,'ajax_block_product')]["+productIndex+"]"));
                }
            else {
                product = this.driver.findElement(By.xpath("//ul[@id='blockbestsellers']//li[contains(@class,'ajax_block_product')]["+productIndex+"]"));
                }
           this.over.moveToElement(product).perform();
            return product;
       }
        public void addProduct(WebElement product) throws InterruptedException {

                WebElement addToCartButton = product.findElement(By.xpath("div//a[contains(@class,'ajax_add_to_cart_button')]"));
                addToCartButton.click();
                Thread.sleep(3000);
        }
        public void continueShopping() throws InterruptedException {
            WebElement btnContinueShopping=this.driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='button-container']//span[contains(@class,'continue')]"));
            btnContinueShopping.click();
            Thread.sleep(3000);
        }
        public void addProductToCart() throws InterruptedException {
            this.selectTab(this.tabName);
            WebElement product=this.overProduct(this.productIndex,this.tabName);
            this.addProduct(product);
            this.continueShopping();
        }
    }

    public static void main(String[] args) throws Exception{

    WebDriver driver= configurationDriver("http://automationpractice.com/index.php?");
    Product dress1=new Product(driver,"Popular", 3);
    Product dress2=new Product(driver, "BestSeller", 7);
    Product dress3=new Product(driver, "BestSeller", 4);

    dress1.addProductToCart();
    dress2.addProductToCart();
    dress3.addProductToCart();
    driver.close();
    }


}


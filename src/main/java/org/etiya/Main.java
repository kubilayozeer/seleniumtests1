package org.etiya;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        String title = webDriver.getTitle();
       System.out.println(title);



        //html
        WebElement input = webDriver.findElement(By.id("user-name"));
        input.sendKeys("standard_user");

        Thread.sleep(5000);

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(5000);

        // Ürün listesi testi
        // findElements---

            List<WebElement> productList = webDriver.findElements(By.className("inventory_item"));
            System.out.println("Toplam ürün sayısı: " + productList.size());
        Thread.sleep(2000);
        // Fiyat sıralama testi
        // findElemnt--
            WebElement priceSortButton = webDriver.findElement(By.className("product_sort_container"));
            priceSortButton.click();
            List<WebElement> sortedProducts = webDriver.findElements(By.className("inventory_item_price"));
            System.out.println("Fiyat sıralaması yapıldı. İlk ürünün fiyatı: " + sortedProducts.get(0).getText());
        Thread.sleep(2000);
        // Ürünü sepete ekleme
        //findelement
        WebElement addToCartButton = webDriver.findElement(By.xpath("//button[text()='ADD TO CART']"));
        addToCartButton.click();
        System.out.println("Ürün sepete eklendi.");
        Thread.sleep(2000);

        // Sepet simgesine gitme ve sepetin güncellendiğini kontrol etme
        //click
        WebElement cartIcon = webDriver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
        System.out.println("Sepet sayfasına gidildi.");
        Thread.sleep(2000);
        WebElement cartQuantity = webDriver.findElement(By.className("shopping_cart_badge"));
        int cartItemCount = Integer.parseInt(cartQuantity.getText());
        if (cartItemCount == 1) {
            System.out.println("Sepet başarıyla güncellendi. Sepetinizde 1 ürün var.");
        } else {
            System.out.println("Sepet güncellenemedi.");
            Thread.sleep(2000);
        }



                // Ödeme işlemi testi
                    WebElement checkoutButton = webDriver.findElement(By.id("checkout"));
                    checkoutButton.click();
                    System.out.println("Ödeme işlemi başlatıldı.");
                    Thread.sleep(2000);
                    // Ödeme bilgilerini doldurma
                    WebElement firstNameField = webDriver.findElement(By.id("first-name"));
                    firstNameField.sendKeys("John");

                    WebElement lastNameField = webDriver.findElement(By.id("last-name"));
                    lastNameField.sendKeys("Doe");

                    WebElement zipCodeField = webDriver.findElement(By.id("postal-code"));
                    zipCodeField.sendKeys("12345");

                    WebElement continueButton = webDriver.findElement(By.id("continue"));
                    continueButton.click();
                    System.out.println("Ödeme bilgileri girildi.");
                    Thread.sleep(2000);

                    // Ödeme özeti kontrolü
                    WebElement finishButton = webDriver.findElement(By.id("finish"));
                    finishButton.click();

                    WebElement completeHeader = webDriver.findElement(By.className("complete-header"));
                    if (completeHeader.getText().equals("THANK YOU FOR YOUR ORDER")) {
                        System.out.println("Ödeme başarıyla tamamlandı.");
                    } else {
                        System.out.println("Ödeme tamamlanamadı.");
                        Thread.sleep(2000);
                    }
        // scrollIntoView()  bir webElement'in görünür olacağı şekilde sayfayı kaydırmakta kullanılır.
        //JavascriptExecutor ve executeScript() tarayıcıda JavaScript kodlarını çalıştırmakta kullanılır.
        // Burada id'si bilinmeyen bir element locate edilmiş, bu nedenle By.xpath() locator'ı kullanılmıştır.
        WebElement element1 = webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[5]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element1);
        Thread.sleep(2000);

        // click() webElement'e "click"leme işlemi için kullanılır.
        WebElement addToCart = webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[3]/button"));
        addToCart.click();
        Thread.sleep(2000);

        // navigate().refresh() sayfayı yenilemek için kullanılır.
        webDriver.navigate().refresh();

        // keyDown(Keys.).sendKeys(Keys.).perform() atanmış tuşlar ile işlem yapmak için kullanılır.
        // keyDown(Keys.) klavye tuşlarını basılı tutmayı, sendKeys(Keys.) tuşa basmayı,
        // perform() ise önceki adımlarda tanımlanan işlemleri gerçekleştirmek için kullanılır.
        // Burada 'Control' tuşuna basılı tutularak 'Home' ile sayfa en üste kaydırılmıştır.
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        Thread.sleep(2000);

        // Burada sepete git dendiğinde, yeni sekmede boş sepet açıyor.
        WebElement basket = webDriver.findElement(By.id("shopping_cart_container"));
        basket.click();
        Thread.sleep(6000);

        WebElement uccizgi = webDriver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button"));
        uccizgi.click();
        Thread.sleep(2000);
        WebElement carpi = webDriver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[2]/div/button"));
        carpi.click();
        Thread.sleep(2000);

        //navigate().back() bir önceki sayfaya dönmek için kullanılır.
        webDriver.navigate().back();
        Thread.sleep(1000);

        //navigate().forward() bir önceki sayfaya dönmek için kullanılır.
        webDriver.navigate().forward();
        Thread.sleep(1000);

        //isDisplayed() bir webElement'in varlığını/görünürlüğünü kontrol etmek için kullanılır.
        WebElement maskotGorsel = webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[1]"));
        boolean maskotGorunuyorMu = maskotGorsel.isDisplayed();

        if(maskotGorunuyorMu) {
            System.out.println("Maskot görünüyor!");
        }
        else {
            System.out.println("Maskot görünmüyor!");
        }
        //manage().window().fullscreen() Sayfayıı tam ekran yapmak için kullanılır.
        webDriver.manage().window().fullscreen();
        Thread.sleep(2000);

        webDriver.quit();
            }


    }

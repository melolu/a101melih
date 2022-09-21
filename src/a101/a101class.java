package a101;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

//bu test selenium ile yapilmistir. cucumber veya benzeri baska test methodlari verilen dokumanda belirtilmedigi icin
//dogrudan selenium methodlari ile yapilmistir
//en dogru sonuclar icin selenium 4.4 surumunu tercih ediniz


public class a101class extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.a101.com.tr");
        WebElement cerezKabul = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        cerezKabul.click();

        WebElement giyimAksesuar = driver.findElement(By.cssSelector("[title='GİYİM & AKSESUAR'"));
        Actions actions = new Actions(driver);
        actions.moveToElement(giyimAksesuar).build().perform();
        WebElement dizaltiCorap = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Dizaltı Çorap")));
        actions.moveToElement(dizaltiCorap).build().perform();
        dizaltiCorap.click();

        WebElement siyahCorapFiltrele = driver.findElement(By.cssSelector("[value='SİYAH']"));
        siyahCorapFiltrele.click();
        WebElement siyahCorapSecim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-actions']")));
        siyahCorapSecim.click();

        WebElement urunRenkDogrulama = driver.findElement(By.cssSelector("[class='selected-variant-text'] span"));
        Assert.assertTrue(urunRenkDogrulama.getText().toLowerCase().contains("siyah"));
        System.out.println("Urunun siyah renk oldugu dogrulandi");

        WebElement sepeteEkle = driver.findElement(By.xpath("//button[contains(@class,'add-to-basket')]"));
        sepeteEkle.click();

        WebElement sepetiGoruntule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='go-to-shop']")));
        sepetiGoruntule.click();

        WebElement sepetiOnayla = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sepeti Onayla")));
        sepetiOnayla.click();

        WebElement uyeOlmadanDevam = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("ÜYE OLMADAN DEVAM ET")));
        uyeOlmadanDevam.click();

        WebElement email = driver.findElement(By.xpath("//input[@name='user_email']"));
        email.sendKeys("101deneme3@gmail.com");

        WebElement devamEt = driver.findElement(By.xpath("//button[@class='button block green']"));
        devamEt.click();

        WebElement adresOlustur = driver.findElement(By.xpath("//a[@class='new-address js-new-address']"));
        adresOlustur.click();

        WebElement adresBasligi = driver.findElement(By.cssSelector("input[name='title']"));
        adresBasligi.sendKeys("Evim");

        WebElement isimGirisi = driver.findElement(By.xpath("//input[@name='first_name']"));
        isimGirisi.sendKeys("market");

        WebElement soyadGirisi = driver.findElement(By.xpath("//input[@name='last_name']"));
        soyadGirisi.sendKeys("reyonu");

        WebElement telefonNo = driver.findElement(By.xpath("//input[@name='phone_number']"));
        telefonNo.sendKeys("8508082101");

        WebElement sehirMenu = driver.findElement(By.xpath("//select[@name='city']"));
        Select sehir = new Select(sehirMenu);
        sehir.selectByVisibleText("İSTANBUL");

        WebElement ilceMenu = driver.findElement(By.xpath("//select[@name='township']"));
        Select ilce = new Select(ilceMenu);
        ilce.selectByVisibleText("AVCILAR");

        WebElement mahalleMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='district']")));
        actions.moveToElement(mahalleMenu).sendKeys(Keys.ENTER).build().perform();
        Select mahalle = new Select(mahalleMenu);
        mahalle.selectByVisibleText("MERKEZ MAH");

        WebElement acikAdres = driver.findElement(By.xpath("//textarea[@name='line']"));
        acikAdres.sendKeys("Merkez mah. Merkez sok. AVCILAR/İSTANBUL");

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[6]")));
        save.click();

        WebElement kaydetVeDevam = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cargo']//button")));
        kaydetVeDevam.click();

        wait.until(ExpectedConditions.urlContains("checkout"));

        WebElement garantiPay=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-type='gpay'])[1]")));
        garantiPay.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='payment-tab payment-tab-gpay js-payment-tab active']")));

        WebElement checkbox=driver.findElement(By.xpath("(//input[@class='checkout__contract__checkbox js-checkout-agreement'])[1]"));
        checkbox.click();

        WebElement garantiPayOde=driver.findElement(By.linkText("Garanti Pay ile Öde"));
        garantiPayOde.click();

        wait.until(ExpectedConditions.urlContains("sanal"));
        Assert.assertTrue(driver.getCurrentUrl().contains("sanal"));
        System.out.println("Odeme ekranina gidildi");

        BekleveKapat();
    }
}

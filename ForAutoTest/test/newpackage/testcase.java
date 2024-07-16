package newpackage;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Automated test case for form submission using Selenium WebDriver.
 */
public class testcase {

    private WebDriver driver;

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(1000); // Thêm thời gian chờ 1 giây để đóng trình duyệt
            driver.quit();
        }
    }

    // Hàm chờ để tạo thời gian cho các hành động trên trình duyệt
    public void waitTime(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Test case đăng ký thành công
    @Test
    public void testSuccess() {
        testcase func = new testcase();
        // Khởi tạo Chrome
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:9999/ForAutoTest/register.jsp");

        // Nhập họ tên
        WebElement nameInput = driver.findElement(By.id("full_name"));
        nameInput.sendKeys("John Doe");
        func.waitTime(1000);

        // Chọn giới tính
        WebElement genderMale = driver.findElement(By.id("male"));
        genderMale.click();
        func.waitTime(1000);

        // Chọn sở thích
        WebElement hobbyReading = driver.findElement(By.id("reading"));
        hobbyReading.click();
        func.waitTime(1000);

        // Chọn nghề nghiệp
        WebElement jobSelect = driver.findElement(By.id("job"));
        jobSelect.sendKeys("Developer");
        func.waitTime(1000);

        // Nhập tên đăng nhập
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("johndoe");
        func.waitTime(1000);

        // Nhập mật khẩu
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("password123");
        func.waitTime(1000);

        // Nhập email
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("johndoe@gmail.com");
        func.waitTime(1000);

        // Nhập số điện thoại
        WebElement phoneInput = driver.findElement(By.id("phone_number"));
        phoneInput.sendKeys("01234567890");
        func.waitTime(1000);

        // Nhấn nút đăng ký
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        func.waitTime(3000);
    }

    // Test case kiểm tra thông báo lỗi khi không nhập họ tên
    @Test
    public void test1() {
        testcase func = new testcase();
        // Khởi tạo Chrome
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:9999/ForAutoTest/register.jsp");

        // Chọn giới tính
        WebElement genderMale = driver.findElement(By.id("male"));
        genderMale.click();
        func.waitTime(1000);

        // Chọn sở thích
        WebElement hobbyReading = driver.findElement(By.id("reading"));
        hobbyReading.click();
        func.waitTime(1000);

        // Chọn nghề nghiệp
        WebElement jobSelect = driver.findElement(By.id("job"));
        jobSelect.sendKeys("Developer");
        func.waitTime(1000);

        // Nhập tên đăng nhập
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("johndoe");
        func.waitTime(1000);

        // Nhập mật khẩu
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("password123");
        func.waitTime(1000);

        // Nhập email
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("johndoe@gmail.com");
        func.waitTime(1000);

        // Nhập số điện thoại
        WebElement phoneInput = driver.findElement(By.id("phone_number"));
        phoneInput.sendKeys("01234567890");
        func.waitTime(1000);

        // Nhấn nút đăng ký
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        func.waitTime(3000);

        // Kiểm tra thông báo lỗi
        WebElement nameError = driver.findElement(By.id("nameError"));
        assert nameError.getText().equals("Full Name is required.");
    }

    // Test case kiểm tra thông báo lỗi khi mật khẩu ít hơn 6 ký tự
    @Test
    public void test2() {
        testcase func = new testcase();
        // Khởi tạo Chrome
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:9999/ForAutoTest/register.jsp");

        // Nhập họ tên
        WebElement nameInput = driver.findElement(By.id("full_name"));
        nameInput.sendKeys("John Doe");
        func.waitTime(1000);

        // Chọn giới tính
        WebElement genderMale = driver.findElement(By.id("male"));
        genderMale.click();
        func.waitTime(1000);

        // Chọn sở thích
        WebElement hobbyReading = driver.findElement(By.id("reading"));
        hobbyReading.click();
        func.waitTime(1000);

        // Chọn nghề nghiệp
        WebElement jobSelect = driver.findElement(By.id("job"));
        jobSelect.sendKeys("Developer");
        func.waitTime(1000);

        // Nhập tên đăng nhập
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("johndoe");
        func.waitTime(1000);

        // Nhập mật khẩu
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("123");
        func.waitTime(1000);

        // Nhập email
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("johndoe@gmail.com");
        func.waitTime(1000);

        // Nhập số điện thoại
        WebElement phoneInput = driver.findElement(By.id("phone_number"));
        phoneInput.sendKeys("01234567890");
        func.waitTime(1000);

        // Nhấn nút đăng ký
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        func.waitTime(3000);

        // Kiểm tra thông báo lỗi
        WebElement passwordError = driver.findElement(By.id("passwordError"));
        assert passwordError.getText().equals("Password must be more than 6 characters.");
    }

    // Test case kiểm tra thông báo lỗi khi email sai định dạng
    @Test
    public void test3() {
        testcase func = new testcase();
        // Khởi tạo Chrome
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:9999/ForAutoTest/register.jsp");

        // Nhập họ tên
        WebElement nameInput = driver.findElement(By.id("full_name"));
        nameInput.sendKeys("John Doe");
        func.waitTime(1000);

        // Chọn giới tính
        WebElement genderMale = driver.findElement(By.id("male"));
        genderMale.click();
        func.waitTime(1000);

        // Chọn sở thích
        WebElement hobbyReading = driver.findElement(By.id("reading"));
        hobbyReading.click();
        func.waitTime(1000);

        // Chọn nghề nghiệp
        WebElement jobSelect = driver.findElement(By.id("job"));
        jobSelect.sendKeys("Developer");
        func.waitTime(1000);

        // Nhập tên đăng nhập
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("johndoe");
        func.waitTime(1000);

        // Nhập mật khẩu
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("password123");
        func.waitTime(1000);

        // Nhập email sai định dạng
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("johndoe@");
        func.waitTime(1000);

        // Nhập số điện thoại
        WebElement phoneInput = driver.findElement(By.id("phone_number"));
        phoneInput.sendKeys("01234567890");
        func.waitTime(1000);

        // Nhấn nút đăng ký
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        func.waitTime(3000);

        // Kiểm tra thông báo lỗi
        WebElement emailError = driver.findElement(By.id("emailError"));
        assert emailError.getText().equals("Invalid email format.");
    }

    // Test case kiểm tra thông báo lỗi khi số điện thoại không bắt đầu bằng số 0
    @Test
    public void test4() {
        testcase func = new testcase();
        // Khởi tạo Chrome
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:9999/ForAutoTest/register.jsp");

        // Nhập họ tên
        WebElement nameInput = driver.findElement(By.id("full_name"));
        nameInput.sendKeys("John Doe");
        func.waitTime(1000);

        // Chọn giới tính
        WebElement genderMale = driver.findElement(By.id("male"));
        genderMale.click();
        func.waitTime(1000);

        // Chọn sở thích
        WebElement hobbyReading = driver.findElement(By.id("reading"));
        hobbyReading.click();
        func.waitTime(1000);

        // Chọn nghề nghiệp
        WebElement jobSelect = driver.findElement(By.id("job"));
        jobSelect.sendKeys("Developer");
        func.waitTime(1000);

        // Nhập tên đăng nhập
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("johndoe");
        func.waitTime(1000);

        // Nhập mật khẩu
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("password123");
        func.waitTime(1000);

        // Nhập email
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("johndoe@gmail.com");
        func.waitTime(1000);

        // Nhập số điện thoại không bắt đầu bằng số 0
        WebElement phoneInput = driver.findElement(By.id("phone_number"));
        phoneInput.sendKeys("1234567890");
        func.waitTime(1000);

        // Nhấn nút đăng ký
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        func.waitTime(3000);

        // Kiểm tra thông báo lỗi
        WebElement phoneError = driver.findElement(By.id("phoneError"));
        assert phoneError.getText().equals("Phone number is required and must start with 0.");
    }
}

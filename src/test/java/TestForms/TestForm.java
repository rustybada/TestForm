package TestForms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;




public class TestForm {
//Annotation to maximize the Browser before tests execution.
    @BeforeAll
    public static void maxBrowser(){
        Configuration.startMaximized = true;
    }
    // Our tests
    @Test
    public void testLabels(){
        String name = "Rustam";
        String lastName = "Badamshin";
        String email = "Rustam@gmail.com";
        String Mobile = "8881221321";
        String subjects = "QA";
        String currentAddress = "World";

        open("https://demoqa.com/automation-practice-form");

        $(".main-header").shouldBe(Condition.visible); //Checking the "Text Box" element.

        //Checking if the labels are correct!
        /*$("#userName-label").shouldHave(text("Name"));
        $("#userEmail-label").shouldHave(text("Email"));
        $("#genterWrapper").shouldHave(text("Gender"));
        $("#userNumber-label").shouldHave(text("Mobile(10 Digits)"));
        $("#dateOfBirth-label").shouldHave(text("Date of Birth"));
        $("#subjects-label").shouldHave(text("Subjects"));
        $("#dateOfBirth-label").shouldHave(text("Date of Birth"));
        $("#subjects-label", 1).shouldHave(text("Hobbies"));
        $("#subjects-label", 2).shouldHave(text("Picture"));
        $("#currentAddress-label").shouldHave(text("Current Address"));
        $("#stateCity-label").shouldHave(text("State and City"));*/

        //Test the Form
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(Mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1994");
        $("[aria-label='Choose Saturday, January 15th, 1994']").click();
        $("[id=subjectsInput]").setValue("Chemistry").pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/QA.jpg"));
        $("[id=currentAddress]").setValue("Kazakhstan, Karaganda");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Del").pressEnter();
        $("[id=submit]").pressEnter();
        $(".table-responsive").shouldHave(text("Rustam Badamshin"), text("Rustam@gmail.com"),
                text("Male"), text("8881221321"), text("15 January,1994"), text("Chemistry"),
                text("Reading"), text("Kazakhstan, Karaganda"),
                text("NCR Delhi"));
    }




}

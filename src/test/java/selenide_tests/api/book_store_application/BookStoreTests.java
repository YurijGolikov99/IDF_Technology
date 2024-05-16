package selenide_tests.api.book_store_application;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import selenide.api_module.steps.boock_store_application.BookStoreCommonSteps;

public class BookStoreTests {

    private final BookStoreCommonSteps bookStoreCommonSteps = new BookStoreCommonSteps();

    //перед повторным запуском, стоит удалить пользователя
    @DisplayName("Успешная регистрация с валидными данными")
    @AllureId("")
    @Issue("IDF-T3")
    @Tags({@Tag("UI"), @Tag("IM_SERVICE"), @Tag("SMOKE")})
    @Epic("Книжный магазин")
//    @Service(AllureServiceConstants.IM_MONITORING_SERVICE)
//    @Layer(AllureLayer.SYSTEM_TESTS)
    @Test
    public void testSuccessRegistrationWithValidDate(){
        bookStoreCommonSteps.enterValidData();
    }

    @Test
    public void testSuccessRegistrationWithValidDate2(){
        bookStoreCommonSteps.enterValidData2();
    }

    @Test
    public void loginWithValidDate(){
    }

    @Test
    public void deleteUsers(){

    }
}

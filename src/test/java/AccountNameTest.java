import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import net.datafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class AccountNameTest {

    public Account account;

    @DisplayName("Проверка минимальной длины имени")
    @Test
    public void minNameLength_ok(){
        Faker faker = new Faker(new Locale("ru"));
        account = new Account(faker.letterify("? ?"));
        Assert.assertTrue(account.checkNameToEmboss());
    }
    @DisplayName("Проверка максимальной длины имени")
    @Test
    public void maxNameLength_ok(){
        Faker faker = new Faker(new Locale("ru"));
        String name;

        do {
            name = String.format("%s %s",faker.name().firstName(),faker.name().lastName());
        } while(name.length()!=19);

        account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }
    @DisplayName("Стандартная проверка длины имени")
    @Test
    public void averageNameLength_ok() {
        Faker faker = new Faker(new Locale("ru"));
        String name;

        do {
            name = String.format("%s %s",faker.name().firstName(),faker.name().lastName());
        } while(name.length()>19);

        account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }
    @DisplayName("Проверка на лишние пробелы в середине имени")
    @Test
    public void moreThenOneSpaceInName_fail(){
        Faker faker = new Faker(new Locale("ru"));
        String name;

        do {
            name = String.format("%s фон %s",faker.name().firstName(),faker.name().lastName());
        } while(name.length()>19);

        account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());

    }
    @DisplayName("Проверка пробелов в начале имени")
    @Test
    public void leadSpaceInName_fail(){
        Faker faker = new Faker(new Locale("ru"));
        String name;

        do {
            name = String.format(" %s",faker.name().firstName());
        } while(name.length()>19);

        account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }
    @DisplayName("Проверка пробелов в конце имени")
    @Test
    public void lastSpaceInName_fail(){
        Faker faker = new Faker(new Locale("ru"));
        String name;

        do {
            name = String.format("%s ",faker.name().firstName());
        } while(name.length()>19);

        account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }
}

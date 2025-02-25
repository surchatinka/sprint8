import net.datafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class AccountNameTest {

    public Account account;

    @Test
    public void minNameLength_ok(){
        Faker faker = new Faker(new Locale("ru"));
        account = new Account(faker.letterify("? ?"));
        Assert.assertTrue(account.checkNameToEmboss());
    }
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

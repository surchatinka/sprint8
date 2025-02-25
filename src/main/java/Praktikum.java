import net.datafaker.Faker;

import java.util.Locale;

public class Praktikum {

    public static void main(String[] args) {

        Faker faker = new Faker(new Locale("ru"));
        String name = faker.letterify("?????? ??????");
        Account account = new Account(name);
        System.out.printf("Результат проверки - %b",account.checkNameToEmboss());
        /*
             В этом методе заложи логику работы с классом Account.
             Нужно создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
             и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
         */
    }

}


//В классе Praktikum тебе нужно создать переменную со строкой, которая содержит имя и фамилию. После — создать экземпляр класса Account.
//Чтобы задать условие для проверки, вызови метод checkNameToEmboss().
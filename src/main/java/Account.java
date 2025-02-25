public class Account {

    private static final String SPACE = " ";
    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 19;
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    private boolean checkMinNameLength() {
        return name.length() >= MIN_LENGTH;
    }
    private boolean checkMaxNameLength(){
        return name.length() <= MAX_LENGTH;
    }
    private boolean checkTrimSpaces(){
        return name.trim().equals(name);
    }
    private boolean isOnlyOneSpaceInName(){
        return name.lastIndexOf(SPACE) == name.indexOf(SPACE);
    }
    public boolean checkNameToEmboss() {
         return this.checkMaxNameLength()
                 && this.checkMinNameLength()
                 && this.checkTrimSpaces()
                 && this.isOnlyOneSpaceInName();
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
    }

}
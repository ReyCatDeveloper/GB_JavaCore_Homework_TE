package lesson6_7;

import java.util.Scanner;

public class Interface {
    private static final Scanner in = new Scanner(System.in);
    private static int userSelect;
    public static void userAsk() {

        int cityNumber;

        do {
            System.out.println("Выберите цифру города:");
            System.out.println("1 - Москва | 2 - Санкт-Петербург | 3 - Ташкент | 4 - Баку | 5 - Минск | 6 - ВЫХОД |");
            cityNumber = in.nextInt();
        } while (cityNumber <= 0 || cityNumber > 7);

        userSelect = cityNumber;
    }

    public static void continueAsk(){
        int userDecision = 0;
        do {
            System.out.println("Продолжить? :");
            System.out.println("1 - да | 2 - нет (ВЫХОД) |");
            userDecision = in.nextInt();
        } while (userDecision < 1 || userDecision > 2);
        if (userDecision == 2){
            System.out.println("ВЫХОД");
            System.exit(1);
        }
    }

    public static int getUserSelect() {
        return userSelect;
    }

    public static void setUserSelect(int userSelect) {
        Interface.userSelect = userSelect;
    }

    public String buildURL(){

        return "";
    }

}

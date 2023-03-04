package lesson6_7;

import java.util.Scanner;

public class Interface {
    private static Scanner in = new Scanner(System.in);
    private static String userSelect;
    public static void userAsk() {
        in = new Scanner(System.in);
        int cityNumber;
        String cityNumberString;

        do {
            System.out.println("Выберите цифру города:");
            System.out.println("1 - Москва | 2 - Санкт-Петербург | 3 - Ташкент | 4 - Баку | 5 - Минск | 0 - ЖУРНАЛ | exit - ВЫХОД |");
            cityNumberString = in.nextLine();
            try{
                cityNumber = Integer.parseInt(cityNumberString);
            }catch (NumberFormatException e){
                cityNumber = -1;
            }

        } while ((cityNumberString.intern() != ("exit") == true) && (cityNumber < 0 || cityNumber > 6) == true);

        userSelect = cityNumberString;
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

    public static String getUserSelect() {
        return userSelect;
    }

    public static void setUserSelect(String userSelect) {
        Interface.userSelect = userSelect;
    }

    public String buildURL(){

        return "";
    }

}

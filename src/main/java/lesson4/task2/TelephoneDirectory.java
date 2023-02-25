package lesson4.task2;

import java.util.ArrayList;

public class TelephoneDirectory {
    ArrayList<TelephoneDirectoryEntry> entries = new ArrayList<>();

    public void add(String surname, int fonNumber){
        String convert_fonNumber = "+"+String.valueOf(fonNumber);
        entries.add(new TelephoneDirectoryEntry(surname,convert_fonNumber));
    }

    public ArrayList<String> get(String surnameForSearch){
        ArrayList<String> fonNumbers = new ArrayList<>();

        for (int i = 0; i < entries.size(); i++){
            if(surnameForSearch.intern() == entries.get(i).surname.intern()){
                fonNumbers.add(entries.get(i).fonNumber);
                System.out.println(entries.get(i).fonNumber);
            }
        }


        return fonNumbers;
    }

}

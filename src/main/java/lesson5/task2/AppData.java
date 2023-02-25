package lesson5.task2;

public class AppData {
    private String[] header;
    private  int[][] data;

    public AppData(String[] header, int[][] data){
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void showHeaders(){
        System.out.println("\nпоказ заголовков");
        for (int i = 0; i < header.length; i++){
            System.out.print(header[i]+" | ");
        }
    }

    public void showData(){
        System.out.println("\nпоказ данных");
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                System.out.print(data[i][j]+" | ");
            }
            System.out.println();

        }
    }
}

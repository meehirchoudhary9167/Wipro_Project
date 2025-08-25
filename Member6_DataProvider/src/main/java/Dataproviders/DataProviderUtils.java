package Dataproviders;

public class DataProviderUtils {
    public static void printData(Object[][] data) {
        for (Object[] row : data) {
            for (Object col : row) {
                System.out.print(col + " | ");
            }
            System.out.println();
        }
    }
}
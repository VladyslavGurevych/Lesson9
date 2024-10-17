package app;


import java.util.Random;

public class Lesson9 {
    public static void main(String[] args) {
        int[][] square = new int[4][4];
        Random rand = new Random();
        int evenSum = 0;
        int oddSum = 0;
        long evenMul = 1L;
        long oddMul = 1L;
        int sumOfLine = 0;
        int sumOfRow = 0;
        int diag = 0;
        int diag2 = 0;
        String noMagic = "Матриця не є магічним квадратом.";
        String yesMagic = "Матриця є магічним квадратом.";

        System.out.println("Матриця 4x4:");
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = rand.nextInt(50) + 1;
                System.out.print(square[i][j] + " ");
                if (i % 2 == 0) {
                    evenSum += square[i][j];
                    evenMul *= square[i][j];
                } else {
                    oddSum += square[i][j];
                    oddMul *= square[i][j];
                }
            }
            System.out.println();
        }
        System.out.printf("\nСума елементів у парних рядках (рядок 0, 2): " + evenSum +
                "\nСума елементів у непарних рядках (рядок 1, 3): " + oddSum +
                "\nДобуток елементів у парних стовпцях (стовпець 0, 2): " + evenMul +
                "\nДобуток елементів у непарних стовпцях (стовпець 1, 3): " + oddMul + "\n");


        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                sumOfLine += square[j][i];
                sumOfRow += square[i][j];
                if (i == j) {
                    diag += square[i][j];
                }
            }
            if (sumOfLine != sumOfRow) {
                break;
            }
            diag2 += square[i][square.length - i - 1];
        }
        if (diag == diag2 && sumOfRow / square.length == diag2) {
            System.out.printf("Сума стовпців = " + sumOfRow + "\nСума стовпців рядків = " + sumOfLine +
                    "\nСума діагоналі = " + diag + "\nСума зворотньої діагоналі = " + diag2 +
                    "\n" + yesMagic);
        } else {
            System.out.println(noMagic);
        }
    }
}
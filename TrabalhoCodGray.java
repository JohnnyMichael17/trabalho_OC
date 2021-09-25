import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.InternationalFormatter;

public class TrabalhoCodGray {

    public static int[] convertBin(int desc) {
        int[] bin = new int[6];
        try {

            for (int i = bin.length - 1; desc > 0; i--) {
                bin[i] = desc % 2;
                desc = desc / 2;
            }
            return bin;

        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("numero invalido");
            bin = null;

        }

        return bin;
    }

    public static int[] convertGray(int[] bin) {
        int[] gray = new int[6];
        gray[0] = bin[0];
        for (int i = 1; i < gray.length; i++) {

            if (bin[i] + bin[i - 1] == 2 || bin[i] + bin[i - 1] == 0)
                gray[i] = 0;

            if (bin[i] + bin[i - 1] == 1)
                gray[i] = 1;

        }
        return gray;

    }

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        int[] bin = convertBin(tc.nextInt());

        if (bin != null) {
            int gray[] = convertGray(bin);
            for (int i = 0; i < gray.length; i++) {
                System.out.print(bin[i]);

            }
            System.out.println();
            gray = convertGray(bin);
            for (int i = 0; i < gray.length; i++) {
                System.out.print(gray[i]);

            }
        }

      
    }
    

}
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class TrabalhoCodGray {

    public static int[] readFiles(String arquivo) {
        try {
            File file = new File(arquivo);
            Scanner entrada = new Scanner(file);
            int aux = 0;

            while (entrada.hasNextInt()) {
                aux++;
                entrada.nextInt();
            }
            int[] array = new int[aux];
            Scanner entrada2 = new Scanner(file);

            for (int i = 0; i < array.length; i++)
                array[i] = entrada2.nextInt();

            entrada.close();
            entrada2.close();

            return array;

        } catch (Exception e) {
            return null;
        }
    }

    public static int[] convertBin(int desc) {
        int[] bin = new int[5];

        try {
            for (int i = bin.length - 1; desc > 0; i--) {
                bin[i] = desc % 2;
                desc = desc / 2;
            }
            return bin;

        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("\nNumero invalido!");
            bin = null;

        }
        return bin;
    }

    public static int[] convertGray(int[] bin) {
        int[] gray = new int[5];
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

        int[] data = readFiles("entrada.txt");
        System.out.println(Arrays.toString(data));

        int aux = 0;
        while (aux <= data.length - 1) {
            int[] bin = convertBin(data[aux]);

            if (bin != null) {
                int gray[] = convertGray(bin);

                System.out.print("\nBinario: ");

                for (int i = 0; i < gray.length; i++)
                    System.out.print(bin[i]);

                System.out.print("\nGray: ");

                gray = convertGray(bin);
                for (int i = 0; i < gray.length; i++)
                    System.out.print(gray[i]);
            }
            System.out.println();
            aux++;
        }
    }
}
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TrabalhoCodGray {

    public static int[] ler(String caminho) {
        try {
            File arquivo = new File(caminho);
            Scanner entrada = new Scanner(arquivo);
            int aux = 0;

            while (entrada.hasNextInt()) {
                aux++;
                entrada.nextInt();
            }
            int[] array = new int[aux];
            Scanner entrada2 = new Scanner(arquivo);

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
        int[] bin = new int[6];

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
        //leitura do arquivo
        int[] data = ler("entrada.txt");
        System.out.println();
        //variavel que ira armazenar o valor das converções
        String saida = new String(Arrays.toString(data)+"\n");

        int aux = 0;
        while (aux <= data.length - 1) {
            int[] bin = convertBin(data[aux]);

            if (bin != null) {
                int gray[] = convertGray(bin);
                saida = saida.concat("Entrada : "+ data[aux]+"\n");
                saida = saida.concat("Binario: ");

                for (int i = 0; i < gray.length; i++)
                saida = saida.concat(bin[i]+"");

                saida = saida.concat("\nGray: ");
                

                gray = convertGray(bin);
                for (int i = 0; i < gray.length; i++) 
                saida = saida.concat(gray[i]+"");
            }
            saida = saida.concat("\n");
            saida = saida.concat("\n");
            aux++;
        }
        //Variavel que salvara as converções em "saida" no arquivo "saida.txt"
        BufferedWriter escritor = null;
        try{
        escritor = new BufferedWriter( new FileWriter("saida.txt"));
        escritor.write(saida);
        if ( escritor != null)
        escritor.close();
        System.out.println("Programa finalizado");
        }
        catch ( IOException e){
            System.out.println("Erro ao gerar arquivo");
        }
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        String[] inputFiles = {
                "src/ConjuntoDeDados/aleatorio_100.csv",
                "src/ConjuntoDeDados/aleatorio_1000.csv",
                "src/ConjuntoDeDados/aleatorio_10000.csv",
                "src/ConjuntoDeDados/crescente_100.csv",
                "src/ConjuntoDeDados/crescente_1000.csv",
                "src/ConjuntoDeDados/crescente_10000.csv",
                "src/ConjuntoDeDados/decrescente_100.csv",
                "src/ConjuntoDeDados/decrescente_1000.csv",
                "src/ConjuntoDeDados/decrescente_10000.csv"
        };

        String[] outputFiles = {
                "src/ConjuntoDeDados_Saida/saida_aleatorio_100.csv",
                "src/ConjuntoDeDados_Saida/saida_aleatorio_1000.csv",
                "src/ConjuntoDeDados_Saida/saida_aleatorio_10000.csv",
                "src/ConjuntoDeDados_Saida/saida_crescente_100.csv",
                "src/ConjuntoDeDados_Saida/saida_crescente_1000.csv",
                "src/ConjuntoDeDados_Saida/saida_crescente_10000.csv",
                "src/ConjuntoDeDados_Saida/saida_decrescente_100.csv",
                "src/ConjuntoDeDados_Saida/saida_decrescente_1000.csv",
                "src/ConjuntoDeDados_Saida/saida_decrescente_10000.csv"
        };

        for (int i = 0; i < inputFiles.length; i++) {
            String inputFilePath = inputFiles[i];
            String outputFilePath = outputFiles[i];

            int[] valores = Sort.loadNumbers(inputFilePath);

            long startTime = System.nanoTime();

            //Sort.bubbleSort(valores);
            Sort.insertionSort(valores);
            //Sort.quickSort(valores, 0, valores.length - 1);

            long endTime = System.nanoTime();

            long elapsedTime = endTime - startTime;
            System.out.printf(PURPLE + "\nTempo de execução para %s: " + RESET + "%,d ns%n", inputFilePath, elapsedTime);

            Sort.saveNumbersInCSVFile(outputFilePath, valores);
            System.out.println(BLUE + "\nOrdenação concluída para: " + RESET + inputFilePath + GREEN + "\n" + "salva em: " + RESET + outputFilePath + "\n");
        }
    }
}

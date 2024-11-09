public class Main {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        // Lista de arquivos de entrada e saída
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

        // Percorre cada arquivo de entrada e saída
        for (int i = 0; i < inputFiles.length; i++) {
            String inputFilePath = inputFiles[i];
            String outputFilePath = outputFiles[i];

            // Lê os dados do arquivo CSV
            int[] valores = Sort.loadNumbers(inputFilePath);

            // Escolha o método de ordenação desejado e descomente a linha correspondente
            long startTime = System.nanoTime();

            // Sort.bubbleSort(valores);
            // Sort.insertionSort(valores);
            Sort.quickSort(valores, 0, valores.length - 1);

            long endTime = System.nanoTime();
            System.out.println(PURPLE + "\nTempo de execução para " + RESET + inputFilePath + ": " + (endTime - startTime) / 1_000_000.0 + " ms");

            // Escreve os dados ordenados no arquivo de saída correspondente
            Sort.saveNumbersInCSVFile(outputFilePath, valores);
            System.out.println(BLUE + "\nOrdenação concluída para: " + RESET + inputFilePath + GREEN + "\n" + "salva em: " + RESET + outputFilePath + "\n");
        }
    }
}

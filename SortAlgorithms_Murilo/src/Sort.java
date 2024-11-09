import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sort {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    // Carrega os números de um arquivo CSV
    public static int[] loadNumbers(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                System.out.println(RED + "\nIgnorando valor inválido inserido no arquivo: " +RESET+ line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(RED + "Erro ao carregar arquivo: " + e.getMessage());
        }
        // Converte a lista para um array de inteiros
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    // Salva os números em um arquivo CSV
    public static void saveNumbersInCSVFile(String filePath, int[] numbers) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int number : numbers) {
                writer.write(number + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    // Bubble Sort - Ordena o array de forma simples
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort - Ordena o array de forma simples
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // Move os elementos maiores para a posição correta
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Quick Sort - Ordena o array de forma simples
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Particiona o array
            int pivotIndex = partition(arr, low, high);
            // Ordena as duas metades
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Particionamento usado pelo Quick Sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Troca os elementos
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Coloca o pivô na posição correta
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

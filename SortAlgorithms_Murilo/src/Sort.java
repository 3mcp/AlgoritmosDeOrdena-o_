import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sort {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
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
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void saveNumbersInCSVFile(String filePath, int[] numbers) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int number : numbers) {
                writer.write(number + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivoIndex = partition(array, low, high);
            quickSort(array, low, pivoIndex - 1);
            quickSort(array, pivoIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivo = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivo) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

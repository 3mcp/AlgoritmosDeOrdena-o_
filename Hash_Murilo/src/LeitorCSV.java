import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class LeitorCSV {
    public static ArrayList<String> lerArquivo(String caminho) throws IOException {
        ArrayList<String> nomes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        while ((linha = br.readLine()) != null) {
            nomes.add(linha.trim());
        }
        br.close();
        return nomes;
    }
}

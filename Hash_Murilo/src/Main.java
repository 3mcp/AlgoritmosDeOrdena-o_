import java.util.ArrayList;
import java.io.IOException;

public class Main {
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        try {
            ArrayList<String> nomes = LeitorCSV.lerArquivo("C:\\Users\\Usuario\\IdeaProjects\\Hash_Murilo\\src\\nomes_csv\\female_names.txt");

            TabelaHash tabela1 = new TabelaHashFuncao1(5000);
            TabelaHash tabela2 = new TabelaHashFuncao2(5000);

            long inicio = System.nanoTime();
            for (String nome : nomes) {
                tabela1.inserir(nome);
            }
            long tempoInsercao1 = System.nanoTime() - inicio;

            inicio = System.nanoTime();
            for (String nome : nomes) {
                tabela2.inserir(nome);
            }
            long tempoInsercao2 = System.nanoTime() - inicio;

            System.out.println(BLUE + "Tabela Hash com Função 1:" + RESET);
            System.out.println(BLUE + "Número de colisões: " + RESET + tabela1.getColisoes());
            System.out.println(BLUE + "Tempo de inserção: " + RESET + tempoInsercao1 + " ns");
            tabela1.mostrarDistribuicao();

            System.out.println(GREEN + "\nTabela Hash com Função 2:" + RESET);
            System.out.println(GREEN + "Número de colisões: " + RESET + tabela2.getColisoes());
            System.out.println(GREEN + "Tempo de inserção: " + RESET + tempoInsercao2 + " ns");
            tabela2.mostrarDistribuicao();

            inicio = System.nanoTime();
            for (String nome : nomes) {
                tabela1.buscar(nome);
            }
            long tempoBusca1 = System.nanoTime() - inicio;

            inicio = System.nanoTime();
            for (String nome : nomes) {
                tabela2.buscar(nome);
            }
            long tempoBusca2 = System.nanoTime() - inicio;

            System.out.println(BLUE + "\nTempo de busca na Tabela Hash com Função 1: " + RESET + tempoBusca1 + " ns");
            System.out.println(GREEN + "Tempo de busca na Tabela Hash com Função 2: " + RESET + tempoBusca2 + " ns");

        } catch (IOException e) {
            System.out.println(RED + "Erro ao ler o arquivo: " + e.getMessage() + RESET);
        }
    }
}

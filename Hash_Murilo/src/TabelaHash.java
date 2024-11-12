import java.util.LinkedList;
public abstract class TabelaHash {
    protected LinkedList<String>[] tabela;
    protected int tamanho;
    protected int colisoes = 0;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    public abstract int funcaoHash(String chave);

    public void inserir(String nome) {
        int indice = funcaoHash(nome);
        if (!tabela[indice].isEmpty()) colisoes++;
        tabela[indice].add(nome);
    }

    public boolean buscar(String nome) {
        int indice = funcaoHash(nome);
        return tabela[indice].contains(nome);
    }

    public int getColisoes() {
        return colisoes;
    }

    public void mostrarDistribuicao() {
        for (int i = 0; i < tabela.length; i++) {
            System.out.println("Posição " + i + ": " + tabela[i].size() + " nomes");
        }
    }
}


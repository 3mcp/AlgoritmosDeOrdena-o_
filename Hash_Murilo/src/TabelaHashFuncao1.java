public class TabelaHashFuncao1 extends TabelaHash{
    public TabelaHashFuncao1(int tamanho) {
        super(tamanho);
    }

    @Override
    public int funcaoHash(String chave) {
        return Math.abs(chave.hashCode()) % tamanho;
    }
}

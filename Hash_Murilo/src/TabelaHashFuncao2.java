public class TabelaHashFuncao2 extends TabelaHash{
    public TabelaHashFuncao2(int tamanho) {
        super(tamanho);
    }

    @Override
    public int funcaoHash(String chave) {
        int hash = 7;
        for (int i = 0; i < chave.length(); i++) {
            hash = hash * 31 + chave.charAt(i);
        }
        return Math.abs(hash) % tamanho;
    }
}

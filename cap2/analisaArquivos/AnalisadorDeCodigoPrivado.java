package cap2.analisaArquivos;

public class AnalisadorDeCodigoPrivado {
    private int qtdIfs = 0;

    public int analisa() {
        List<File> todosArquivos = arquivos.todosJava();

        for(File arquivo: todosArquivos) {
            contaIfs(arquivo);
        }
        return qtdIfs;
    }

    private void contaIfs(File arquivo) {
        String codigo= IOUtils.readFile(arquivo);
            String[] tokens = codigo.split("");

            for(String token: tokens) {
                if(token.equals("if"))
                    qtdIfs++;
            }
    }
}

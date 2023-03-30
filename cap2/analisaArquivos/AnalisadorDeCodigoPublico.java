package cap2.analisaArquivos;

import java.io.File;
import java.util.List;

public class AnalisadorDeCodigoPublico {
    public int analisa() {
        List<File> todosArquivos = arquivos.todosJava();
        int qtdIfs = 0;
        for(File arquivo: todosArquivos) {
            String codigo= IOUtils.readFile(arquivo);
            String[] tokens = codigo.split("");

            for(String token: tokens) {
                if(token.equals("if"))
                    qtdIfs++;
            }
        }
        return qtdIfs;
    }
}

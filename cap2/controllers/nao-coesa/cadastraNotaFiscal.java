package cap2.controllers;

@Path("/notaFiscal/nova")
public void cadastraNotaFiscal(NotaFiscal nf) {
    
    if(nf.ehValida()){
        //faz alguma regra de negócio qualquer
    if(nf.ehDeSaoPaulo()){
        nf.duplicaImpostos();
    }
    if(nf.ultrapassaValorLimite()){
        SMTP smtp  = new SMTP();
            String template = leTemplateDoArquivo();
            smtp.enviaEmail(nf.getUsuario(), template);
    }
    //persiste no banco de dados
    String sql = "insert into NF (...) values (...)";
    PrepareStatement stmt = conexao.preparaSql(sql);
    stmt.execute();

    //envia nf pra um webservice qualquer

    SOAP ws = new SOAP();
    ws.setURL("http://www.meuerp.com.br");
    ws.setPort(80);
    ws.send(nf);

    //exibe página de sucesso
    return view("sucesso.jsp");
    }
    else{
        return view("erro-de-validacao.jsp");
    }
}

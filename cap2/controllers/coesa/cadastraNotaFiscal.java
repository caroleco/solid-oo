package cap2.controllers;

@Path("/notaFiscal/nova")
public void cadastraNotaFiscal(NotaFiscal nf) {
    
    if(nf.ehValida()){
        //regra de negócio bem dividida em classes

        RegrasDeCadastro regras = new DuplicaImpostoParaSaoPaulo(
            new EmailSeUltrapassaValorLimite());

            regras.aplica(nf);

            //persiste no banco de dados
            NotaFiscalDao dao = new NotaFiscalDao();
            dao.salva(nf);

            //envia nf para um webservice qualquer.
            WebService ws = new WebServiceDoERPInterno();
            ws.envia(nf);

            //exibe página de sucesso
            return view("sucesso.jsp");
    } else {
        //exibe página de erro
        return view("erro-de-validacao.jsp");
    }
}

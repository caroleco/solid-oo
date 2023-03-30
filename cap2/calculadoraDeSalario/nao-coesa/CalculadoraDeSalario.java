class CalculadoraDeSalario {
    public double calcula(Funcionario funcionario) {

        private double dezOuVintePorcento(Funcionario funcionario) {
            if(funcionario.getSalarioBase() > 3000.0) {
                return funcionario.getSalarioBase() * 0.8;
            } else {
                return funcionario.getSalarioBase() * 0.9;
            }
        }

        if(DESENVOLVEDOR.equals(funcionario.getCargo())) {
            return dezOuVintePorcento(funcionario);
        }

        if(DBA.equals(funcionario.getCargo()) || TESTER.equals(funcionario.getCargo())) {
            return quinzeOuVinteCincoPorcento(funcionario);
        }

        throw new RuntimeException("funcionario inválido");
    }
}

//toda classe que não é coesa não para de crescer nunca.
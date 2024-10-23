package org.common;

public class SqlExitDML {

    private final int codigo;
    private Throwable erro;

    public SqlExitDML() {
        this.codigo = -1;
    }

    public SqlExitDML(int codigo) {
        this.codigo = codigo;
    }
    public SqlExitDML(int codigo, Throwable erro) {
        this(codigo);
        this.erro = erro;
    }

    public int getCodigo() {
        return codigo;
    }

    public Throwable getErro() {
        return erro;
    }

    public String toString() {
        switch (codigo) {
            case 1 -> {
                return "Operação concluída com sucesso";
            }
            case -1 -> {
                return String.format("Erro no banco de dados: '%s'", erro.getMessage());
            }
            case 0 -> {
                return "Operação concluída, porém sem efeitos.";
            }
            default -> {
                return String.format("Erro interno. Código de saída: %d", codigo);
            }
        }
    }
}

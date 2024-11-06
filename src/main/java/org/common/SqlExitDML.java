package org.common;

/**
 * Classe utilizada para produzir mensagens de saída de
 * comandos DML (insert, update, delete) com base em um código dado
 * pela saída dos métodos `inserir` `alterar` e `remover` do DAOGeneric entre outros.
 * Em caso de exceções, a classe pode receber o objeto da exceção e incluir os seus dados na
 * mensagem de erro gerada.
 */
public class SqlExitDML {

    private final int codigo;
    private Throwable erro;

    /** Construtor padrão, inicializa o código com -1
     */

    public SqlExitDML() {
        this.codigo = -1;
    }

    /**Construtor com código de saída
     * @param codigo Código de saída
     */
    public SqlExitDML(int codigo) {
        this.codigo = codigo;
    }

    /** Construtor com código de saída e erro
     * @param erro Erro lançado
     */
    public SqlExitDML(Throwable erro) {
        this();
        this.erro = erro;
    }

    /** 'Getter' do código de saída
     * @return Código de saída
     */
    public int getCodigo() {
        return this.codigo;
    }

    /** 'Getter' do erro lançado
     * @return Erro lançado
     */
    public Throwable getErro() {
        return this.erro;
    }

    /** Verifica se a saída contém erros
     * @return true se sim, false senão.
     */
    public boolean hasErro() { return this.erro != null; }

    /** Método toString para exibição do objeto SqlExitDML
     * @return Erro lançado
     */
    public String toString() {
        switch (codigo) {
            case 1 -> {
                return "Operação concluída com sucesso";
            }
            case -1 -> {
                return String.format("Erro no banco de dados: '%s'", this.erro.getMessage());
            }
            case 0 -> {
                return "Não foi encontrado.";
            }
            case -2 -> {
                return "Operação inválida";
            }
            default -> {
                return String.format("Erro interno. Código de saída: %d", codigo);
            }
        }
    }
}
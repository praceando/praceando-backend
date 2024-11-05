package org.common;

import java.util.LinkedHashMap;

public abstract class Tabela {
//    public String getNomeBanco(String nomeInterface) {
//        if (this.getNomeInterface().equals(nomeInterface)) {
//            return this.getNomeBanco();
//        }
//        throw new IllegalArgumentException("Tabela do banco " + nomeBanco + " não reconhecida para" + this.nomeBanco);
//    }
//
//    public String getInterface(String nomeBanco) {
//        if (this.getNomeBanco().equals(nomeBanco)) {
//            return this.getNomeInterface();
//        }
//        throw new IllegalArgumentException("Tabela do banco " + nomeBanco + " não reconhecida para" + this.nomeInterface);
//    }

    /**Obtém as colunas da tabela usadas no banco.
     * @return Array com as colunas da tabela
     */
    public String[] getColunasBanco() {
        return this.getColunas().keySet().toArray(new String[]{});
    }

    /**Obtém as colunas da tabela para ser utilizadas na interface HTML.
     * @return Array com as colunas da tabela
     */
    public String[] getColunasInterface() {
        return this.getColunas().values().toArray(new String[]{});
    }

    public boolean matches(String nome) {
        return this.getNomeBanco().equals(nome) || this.getNomeInterface().equals(nome);
    }

    public String toString() {
        return String.format("'%s' <-> '%s'", this.getNomeBanco(), this.getNomeInterface());
    }

    /**
     * Usado para retornar o nome da tabela usado no banco de dados
     * @return O Nome da tabela no banco
     */
    public abstract String getNomeBanco();

    /** Retorna o nome em linguagem convencional, serve para ser mostrado nas páginas para o usuário.
     * @return Nome da tabela para o usuário
     */
    public abstract String getNomeInterface();

    /**
     * Retorna um dicionário sequenciado das colunas da tabela, contendo a chave como o nome
     * no banco de dados e o valor como o nome mostrado na página web
     * @return Dicionário mapeado nomeBanco -> nomeInterface
     */
    public abstract LinkedHashMap<String, String> getColunas();

}
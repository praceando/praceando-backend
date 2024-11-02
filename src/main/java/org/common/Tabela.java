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
    public String[] getColunasBanco() {
        return getColunas().sequencedKeySet().toArray(new String[]{});
    }
    public String[] getColunasInterface() {
        return getColunas().sequencedValues().toArray(new String[]{});
    }

    public String toString() {
        return String.format("'%s' <-> '%s'", this.getNomeBanco(), this.getNomeInterface());
    }

    public abstract String getNomeBanco();
    public abstract String getNomeInterface();
    public abstract LinkedHashMap<String, String> getColunas();

}

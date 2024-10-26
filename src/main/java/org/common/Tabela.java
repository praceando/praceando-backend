package org.common;

public class Tabela {
    public String nomeInterface;
    public String nomeBanco;

    public Tabela(String nomeInterface, String nomeBanco) {
        this.nomeInterface = nomeInterface;
        this.nomeBanco = nomeBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getNomeInterface() {
        return nomeInterface;
    }

    public String toString() {
        return this.nomeInterface;
    }

    public String getNomeBanco(String nomeInterface) {
        if (this.nomeInterface.equals(nomeInterface)) {
            return this.nomeBanco;
        }
        return null;
    }

    public String getInterface(String nomeBanco) {
        if (this.nomeBanco.equals(nomeBanco)) {
            return this.nomeInterface;
        }
        return null;
    }
}

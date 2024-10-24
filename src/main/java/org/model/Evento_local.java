package org.model;
import java.util.Date;

public class Evento_local {
    private String nome;
    private double latitud;
    private double longitud;
<<<<<<< HEAD
    private Date dt_atualizacao;
=======

    /**
     * Construtor que inicia os atributos da classe
     * @param nome Nome do evento
     * @param latitud Latitude do local do evento
     * @param longitud Longitude do local do evento
     */
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

    public Evento_local(String nome, double latitud, double longitud) {
        this.nome = nome;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public Evento_local() {}

<<<<<<< HEAD
=======
    /**
     * Getter do nome do evento
     * @return Nome do evento
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public String getNome() {
        return nome;
    }

<<<<<<< HEAD
=======
    /**
     * Getter da latitude do local do evento
     * @return Latitude do local do evento
     */

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    public double getLatitud() {
        return latitud;
    }

<<<<<<< HEAD
    public double getLongitud() {
        return longitud;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }
}

=======
    /**
     * Getter da longitude do local do evento
     * @return Longitude do local do evento
     */

    public double getLongitud() {
        return longitud;
    }
}
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130

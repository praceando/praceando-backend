package org.common;

import org.model.*;

import java.text.ParseException;
import java.util.Map;

public class ModelCreator {
    public static Model createModel(String tabelaNome, Map<String, String> params) throws ParseException {
        switch (tabelaNome) {
            case "tag" -> {
                return new Tag(params);
            }
            case "evento_local" -> {
                return new Evento_local(params);
            }
            case "avatar" -> {
                return new Avatar(params);
            }
            case "produto" -> {
                return new Produto(params);
            }
            case "frase_sustentavel" -> {
                return new FraseSustentavel(params);
            }
        }
        System.out.println("RETORNOU NULL!!!!!!!! " + tabelaNome);
        return null;
    }
}

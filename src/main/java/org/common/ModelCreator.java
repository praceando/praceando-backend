package org.common;
import org.model.*;
import java.text.ParseException;
import java.util.Map;

public class ModelCreator {

    /** Método que cria o objeto Model a partir do nome da tabela e dos parâmetros
     * @param tabelaNome Nome da tabela
     * @param params Map com os parâmetros
     * @return Objeto Model
     * @throws ParseException Caso ocorra algum erro na criacao do objeto
     */
    public static Model createModel(String tabelaNome, Map<String, String> params) throws ParseException {
        switch (tabelaNome) {
            case "tag" -> {
                return new Tag(params);
            }
            case "evento_local" -> {
                return new EventoLocal(params);
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
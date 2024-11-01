package org.common.html;
import org.common.Constants;
import org.common.Senha;
import org.model.Model;
import java.lang.reflect.Field;

public class HTMLGenerator {

    /**Obtém as colunas de uma tabela.
     * @param tabelaNome Nome da tabela
     * @return Array com as colunas da tabela
     */
    public static String[] getColunas(String tabelaNome) {

        String[] colunas = new String[]{};

        // Adiciona as colunas de cada tabela
        switch (tabelaNome) {
            case "admin" -> colunas = new String[]{
                    "ID", "Nome", "E-mail", "Ativo", "Senha"
            };
            case "avatar" -> colunas = new String[]{
                    "ID", "URL"
            };
            case "evento_local" -> colunas = new String[]{
                    "ID", "Nome", "Latitude", "Longitude"
            };
            case "frase_sustentavel" -> colunas = new String[] {
                    "ID", "Descrição"
            };
            case "produto" -> colunas = new String[]{
                    "ID", "Nome", "Descrição", "Preço", "Categoria",
                    "Estoque", "Desativação"
            };
            case "tag" -> colunas = new String[]{
                    "ID", "Nome", "Categoria", "Descrição"
            };
        }
        // Retorna o array com as colunas
        return colunas;
    }

    /** Método para retornar o HTML da linha de um Model
     * Utilizado na página de visualização
     * @param model Model para gerar o HTML
     * @return HTML da linha do objeto
     */
    public static String linhaFromModel(Model model) {
        StringBuilder linhaHTML = new StringBuilder();

        Field[] fields = model.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(model);

                // Converter valor para cada caso
                if (value instanceof java.util.Date) {
                    value = Constants.FORMATO_DATA.format(value);
                } else if (value instanceof Senha) {
                    value = "************";
                } else if (value instanceof Boolean) {
                    value = (Boolean) value ? "Sim" : "Não";
                }

                // Adicionar a linha
                linhaHTML.append("<td>")
                        .append(value != null ? value.toString() : "<i>Não definido</i>")
                        .append("</td>");

            } catch (IllegalAccessException iae) {
                iae.printStackTrace();
                linhaHTML.append(String.format("<td>Inaccessible: '%s'</td>", field.getName()));
            }
        }
        return linhaHTML.toString();
    }
}
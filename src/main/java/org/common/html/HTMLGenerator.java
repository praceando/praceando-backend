package org.common.html;
import org.common.Constants;
import org.common.Senha;
import org.model.Model;
import java.lang.reflect.Field;

public class HTMLGenerator {

    /** Método para gerar um HTML da linha de um Model utilizado na página de visualizar
     * Utilizado na página de visualização
     * @param model Model para gerar o HTML
     * @return HTML da linha do objeto
     */
    public static String linhaFromModel(Model model) {
        StringBuilder linhaHTML = new StringBuilder();

        // Pega todos os fields da classe
        Field[] fields = model.getClass().getDeclaredFields();

        // Itera os fields
        for (Field field : fields) {
            field.setAccessible(true); // faz acessível
            try {
                Object value = field.get(model);

                // Converter valor para cada caso
                if (value instanceof java.sql.Time) {
                    value = Constants.FORMATO_TEMPO.format(value);
                } else if (value instanceof java.sql.Date) {
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

                // Em caso de ser incessível mostra um erro
            } catch (IllegalAccessException iae) {
                iae.printStackTrace();
                linhaHTML.append(String.format("<td>Inaccessible: '%s'</td>", field.getName()));
            }
        }
        // Retorna string contendo o HTML gerado
        return linhaHTML.toString();
    }
}
package org.common.html;
import org.common.Constants;
import org.common.Senha;
import org.model.Model;
import java.lang.reflect.Field;

public class HTMLGenerator {

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
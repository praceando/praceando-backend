package org.common.html;
import org.common.Constants;
import org.common.Senha;
import org.model.Model;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

public class HTMLGenerator {

    /**Obtém as colunas de uma tabela para ser utilizadas na interface HTML.
     * @param tabelaBanco Nome da tabela
     * @return Array com as colunas da tabela
     */
    @Deprecated
    public static String[] getColunasInterface(String tabelaBanco) {
        try {
            return Objects.requireNonNull(Constants.getTabela(tabelaBanco)).getColunasInterface();
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new NullPointerException("Objeto tabela '" + tabelaBanco + "' não encontrada para extração de colunas da Interface.");
        }
    }

    /**Obtém as colunas de uma tabela para ser utilizadas no banco.
     * @param tabelaBanco Nome da tabela
     * @return Array com as colunas da tabela
     */
    @Deprecated
    public static String[] getColunasBanco(String tabelaBanco) {
        try {
            return Objects.requireNonNull(Constants.getTabela(tabelaBanco)).getColunasBanco();
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new NullPointerException("Objeto tabela '" + tabelaBanco + "' não encontrada para extração de colunas de Banco.");
        }
    }

    /** Retorna um dicionário contendo as colunas do banco mapeadas com os seus relativos mostrados nas páginas HTML
     * @return Map contendo as colunas no modelo banco -> interface
     */
    @Deprecated
    public static Map<String, String> getColunas(String tabelaBanco) {
        return Objects.requireNonNull(Constants.getTabela(tabelaBanco)).getColunas();
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
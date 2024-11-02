package org.common.html;
import org.common.Constants;
import org.common.Senha;
import org.model.Model;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class HTMLGenerator {

    /**Obtém as colunas de uma tabela para ser utilizadas na interface HTML.
     * @param tabelaBanco Nome da tabela
     * @return Array com as colunas da tabela
     */
    public static String[] getColunasInterface(String tabelaBanco) {

        String[] colunas = new String[]{};
        // Adiciona as colunas de cada tabela
        switch (tabelaBanco) {
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

    /**Obtém as colunas de uma tabela para ser utilizadas no banco.
     * @param tabelaBanco Nome da tabela
     * @return Array com as colunas da tabela
     */
    public static String[] getColunasBanco(String tabelaBanco) {

        String[] colunas = new String[]{};

        // Adiciona as colunas de cada tabela
        switch (tabelaBanco) {
            case "admin" -> colunas = new String[]{
                    "id", "nome", "email", "is_ativo", "senha"
            };
            case "avatar" -> colunas = new String[]{
                    "id", "url_avatar"
            };
            case "evento_local" -> colunas = new String[]{
                    "id", "nome", "lat", "lon"
            };
            case "frase_sustentavel" -> colunas = new String[] {
                    "id", "descricao"
            };
            case "produto" -> colunas = new String[]{
                    "id", "nome", "descricao", "preco", "categoria",
                    "estoque", "dt_desativacao", "dt_atualizacao"
            };
            case "tag" -> colunas = new String[]{
                    "id", "nome", "categoria", "descricao"
            };
        }
        // Retorna o array com as colunas
        return colunas;
    }

    /** Retorna um dicionário contendo as colunas do banco mapeadas com os seus relativos mostrados nas páginas HTML
     * @return Map contendo as colunas no modelo banco -> interface
     */
    public static Map<String, String> getColunas(String tabelaBanco) {
        Map<String, String> map = new LinkedHashMap<>();
        String[] colunasBanco = getColunasBanco(tabelaBanco);
        String[] colunasInterface = getColunasInterface(tabelaBanco);

        for (int i = 0; i < colunasInterface.length; i++) {
            map.put(colunasBanco[i], colunasInterface[i]);
        }
        return map;
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
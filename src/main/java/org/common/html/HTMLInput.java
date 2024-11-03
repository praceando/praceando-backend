package org.common.html;
import org.common.Constants;
import org.model.Model;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class HTMLInput {
    protected final String name;
    protected final String label;
    protected final String type;
    protected String value;

    protected final boolean isRequired;
    protected final boolean isReadOnly;

    /** Método construtor padrão
     * @param name Nome do campo
     * @param label Rótulo do campo
     * @param type Tipo do campo
     * @param isRequired Se o campo é obrigatório
     */
    public HTMLInput(String name, String label, String type, boolean isRequired, boolean isReadOnly, String value) {
        this.name = name;
        this.label = label;
        this.type = type;
        this.value = value;
        this.isRequired = isRequired;
        this.isReadOnly = isReadOnly;
    }

    /** Método construtor com placeholder padrão
     * @param name Nome do campo
     * @param label Rótulo do campo
     * @param type Tipo do campo
     * @param isRequired Se o campo é obrigatório
     */
    public HTMLInput(String name, String label, String type, boolean isRequired) {
        this(name, label, type, isRequired, false, null);
    }

    /** Método para retornar o nome do campo
     * @return String Nome do campo
     */
    public String getName() {
        return this.name;
    }

    /** Método para retornar o rótulo do campo
     * @param value Valor do campo
     */
    public void setValue(String value) {
        this.value = value;
    }

    /** Método toString para gerar o HTML do input
     * @return String HTML do input
     */
    protected static String surroundContainer(String content) {
        return String.format("<div class=\"inputContainer\">" +
                content +
                "</div>");
    }

    /** Método para retornar o HTML do label do input
     * @return String HTML do label do input
     */
    protected String getLabelTag() {
        return String.format("<label for=\"%s\">%s</label>\n", name, label);
    }

    /** Método para retornar o HTML do input
     * @return String HTML do input
     */
    public String toString() {
        return surroundContainer(
                String.format(
                     getLabelTag() +
                    "   <input type=\"%s\" id=\"%s\" name=\"%s\" class=\"inputForm\" %s %s %s/>",
                    type, name, name,
                    value != null ? String.format("value=\"%s\"", value) : "",
                    isRequired ? "required" : "",
                    isReadOnly ? "readonly" : ""
                )
        );
    }

    /** Método para gerar os inputs de acordo com o nome da tabela
     * @param tableName Nome da tabela
     * @return Array de HTMLInput
     * @throws UnsupportedOperationException Se não encontrado colunas de inserir para a tabela
     */
    public static HTMLInput[] getInputs(String tableName) throws UnsupportedOperationException {
        HTMLInput[] inputs;

        switch (tableName) {
            case "avatar" -> inputs = new HTMLInput[]{
                    new HTMLInput("url_avatar", "Imagem", "image", true),
            };

            case "evento_local" -> inputs = new HTMLInput[]{
                    new HTMLInput("nome", "Nome", "text", true),
                    new HTMLDecimalInput("latitude", "Latitude", ".00000001", true, false),
                    new HTMLDecimalInput("longitude", "Longitude", ".00000001", true, false)
            };

            case "frase_sustentavel" -> inputs = new HTMLInput[]{
                    new HTMLInput("descricao", "Descrição", "text", true),
            };

            case "produto" -> inputs = new HTMLInput[]{
                    new HTMLInput("nome", "Nome", "text", true),
                    new HTMLInput("descricao", "Descrição", "text", true),
                    new HTMLDecimalInput("preco", "Preço (R$)", ".01", true, false),
                    new HTMLInput("estoque", "Estoque", "number", true),
                    new HTMLInput("categoria", "Categoria", "text", true),
                    new HTMLInput("dt_desativacao", "Data de Desativação", "date", false, false, "")
            };

            case "tag" -> inputs = new HTMLInput[]{
                    new HTMLInput("nome", "Nome", "text", true),
                    new HTMLSelection("categoria", "Categoria", Constants.SELECT_CATEGORIA_TAGS, true),
                    new HTMLInput("descricao", "Descrição", "text", true),
            };
            default -> throw new UnsupportedOperationException(String.format("Não encontrado colunas de inserir para '%s'", tableName));
        }
        return inputs;
    }

    /** Método para gerar o formulário HTML a partir de um array de HTMLInput
     * @param inputs Array de HTMLInput
     * @return Lista de strings com o HTML do formulário
     */
    public static List<String> getForm(HTMLInput[] inputs) {
        List<String> form = new ArrayList<>();
        for (HTMLInput htmlInput : inputs) {
            form.add(htmlInput.toString());
        }
        return form;
    }

    /** Método para gerar o formulário HTML a partir do nome da tabela
     * @param tabelaNome Nome da tabela
     * @return String HTML do formulário
     * @throws UnsupportedOperationException Se não encontrado colunas de inserir para a tabela
     */
    public static String getForm(String tabelaNome) throws UnsupportedOperationException {
        return String.join("\n", getForm(getInputs(tabelaNome)));
    }

    /** Método para preencher os inputs de um formulário com os valores de um mapa
     * @param form Array de HTMLInput
     * @param params Mapa com os valores
     * @throws UnsupportedOperationException Se não encontrado colunas de inserir para a tabela
     */
    public static void fillInputs(HTMLInput[] form, Map<String, String> params) throws UnsupportedOperationException {
        for (HTMLInput htmlInput : form) {
            htmlInput.setValue(params.get(htmlInput.name));
        }
    }

    /** Método para gerar o formulário HTML a partir do nome da tabela e do Model
     * @param form Array de HTMLInput
     * @param m Model com os valores
     * @return Lista de strings com o HTML do formulário
     */
    public static List<String> getForm(HTMLInput[] form, Model m) {
        fillInputs(form, m.getParams());

        List<String> formList = getForm(form);
        formList.add(0, new HTMLInput("id", "ID", "number", true, true , String.valueOf(m.getId())).toString());
        return formList;
    }

    /** Método para gerar o formulário HTML a partir do nome da tabela e do Model
     * @param tabelaNome Nome da tabela
     * @param m Model com os valores
     * @return String HTML do formulário
     */
    public static String getForm(String tabelaNome, Model m) {
        return String.join("\n", getForm(getInputs(tabelaNome), m));
    }
}
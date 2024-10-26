package org.common.html;
import java.util.List;
import java.util.ArrayList;

public class HTMLInput {
    private final String name;
    private final String label;
    private final String type;
    private final boolean isRequired;
    private final String value;

    /** Método construtor padrão
     * @param name Nome do campo
     * @param label Rótulo do campo
     * @param type Tipo do campo
     * @param isRequired Se o campo é obrigatório
     * @param value Texto do campo por default.
     */
    public HTMLInput(String name, String label, String type, boolean isRequired, String value) {
        this.name = name;
        this.label = label;
        this.type = type;
        this.isRequired = isRequired;
        this.value = value;
    }

    /** Método construtor com placeholder padrão
     * @param name Nome do campo
     * @param label Rótulo do campo
     * @param type Tipo do campo
     * @param isRequired Se o campo é obrigatório
     */
    public HTMLInput(String name, String label, String type, boolean isRequired) {
        this(name, label, type, isRequired, null);
    }

    public String getName() {
        return name;
    }

    /** Método toString para gerar o HTML do input
     * @return String HTML do input
     */
    public String toString() {
        return String.format(
                "<div class=\"inputContainer\">" +
                "   <label for=\"%s\">%s</label>\n" +
                "   <input type=\"%s\" id=\"%s\" name=\"%s\" class=\"inputForm\" %s %s/>" +
                "</div>",
                name, label, type, name, name,
                value != null ? String.format("value=%s", value) : "",
                isRequired ? "required" : ""
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
                    new HTMLInput("b64_avatar", "B64", "image", true),
            };

            case "evento_local" -> inputs = new HTMLInput[]{
                    new HTMLInput("nome", "Nome", "text", true),
                    new HTMLInput("latitude", "Latitude", "number", true),
                    new HTMLInput("longitude", "Longitude", "number", true)
            };

            case "frase_sustentavel" -> inputs = new HTMLInput[]{
                    new HTMLInput("descricao", "Descrição", "text", true),
            };

            case "produto" -> inputs = new HTMLInput[]{
                    new HTMLInput("nome", "Nome", "text", true),
                    new HTMLInput("descricao", "Descrição", "text", true),
                    new HTMLInput("preco", "Preço", "number", true),
                    new HTMLInput("estoque", "Estoque", "number", true),
                    new HTMLInput("categoria", "Categoria", "text", true),
            };

            case "tag" -> inputs = new HTMLInput[]{
                    new HTMLInput("nome", "Nome", "text", true),
                    new HTMLInput("categoria", "Categoria", "text", true), // TODO: Fazer combobox
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
     * @param tablename Nome da tabela
     * @return String HTML do formulário
     * @throws UnsupportedOperationException Se não encontrado colunas de inserir para a tabela
     */
    public static String getForm(String tablename) throws UnsupportedOperationException {
        return String.join("\n", getForm(getInputs(tablename)));
    }
}
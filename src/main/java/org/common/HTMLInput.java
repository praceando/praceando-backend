package org.common;
import java.util.List;
import java.util.ArrayList;

public class HTMLInput {
    private final String name;
    private final String label;
    private final String type;
    private final boolean isRequired;
    private final String placeholder;

    public HTMLInput(String name, String label, String type, boolean isRequired, String placeholder) {
        this.name = name;
        this.label = label;
        this.type = type;
        this.isRequired = isRequired;
        this.placeholder = placeholder;
    }

    public HTMLInput(String name, String label, String type, boolean isRequired) {
        this(name, label, type, isRequired, null);
    }



    public String toString() {
        return String.format(
                "<div class=\"inputContainer\">" +
                "   <label for=\"%s\">%s</label>\n" +
                "   <input type=\"%s\" id=\"%s\" name=\"%s\" class=\"inputForm\" %s %s/>" +
                "</div>",
                name, label, type, name, name,
                placeholder != null ? String.format("placeholder=%s", placeholder) : "",
                isRequired ? "required" : ""
        );
    }

    public static HTMLInput[] getInputs(String tableName) throws UnsupportedOperationException {
        HTMLInput[] inputs = new HTMLInput[]{};

        switch (tableName) {
            case "tag" -> {
                inputs = new HTMLInput[]{
                        new HTMLInput("nome", "Nome", "text", true),
                        new HTMLInput("categoria", "Categoria", "text", true), // TODO: Fazer combobox
                };
            }
            case "evento_local" -> {
            }
            default -> throw new UnsupportedOperationException(String.format("Não encontrado colunas de inserir para '%s'", tableName));
        }
        return inputs;
    }

    public static List<String> getForm(HTMLInput[] inputs) {
        List<String> form = new ArrayList<>();
        for (HTMLInput htmlInput : inputs) {
            form.add(htmlInput.toString());
        }
        return form;
    }

    public static String getForm(String tablename) throws UnsupportedOperationException {
        return String.join("\n", getForm(getInputs(tablename)));
    }
}

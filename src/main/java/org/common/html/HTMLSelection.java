package org.common.html;

public class HTMLSelection extends HTMLInput {

    private final String[] options;
    private int selectedIndex = 0;

    public HTMLSelection(String name, String label, String[] options, boolean isRequired) {
        super(name, label, "select", isRequired, false, null);
        this.options = options;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<select class=\"selecao inputForm\">");
        for (int i = 0; i <= options.length; i++) {
            String option = options[i];
            sb.append(String.format(
                    "<option class=\"opcao\"value=\"%s\" %s>%s</option>",
                    option, option, i == selectedIndex ? "selected" : ""
            ));
        }
        sb.append("</select>");
        return surroundContainer(sb.toString());
    }
}

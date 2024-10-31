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
        sb.append(String.format("<label for=\"%s\">%s</label>", this.name, this.label));
        sb.append(String.format("<select name=\"%s\"class=\"selecao inputForm\">", this.name));
        for (int i = 0; i < options.length; i++) {
            String option = options[i];
            sb.append(String.format(
                    "<option class=\"opcao\"value=\"%s\" %s>%s</option>",
                    option, i == selectedIndex ? "selected" : "", option
            ));
        }
        sb.append("</select>");
        return surroundContainer(sb.toString());
    }
}
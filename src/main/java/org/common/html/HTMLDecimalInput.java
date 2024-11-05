package org.common.html;

public class HTMLDecimalInput extends HTMLInput {

    public String step;
    public double min = 0;
    public double max = -1;

    /** Método construtor do componente de entrada decimal HTML.
     * @param name Nome do campo no formulário.
     * @param label Nome do campo de visualização.
     * @param isRequired Indica se o campo é obrigatório.
     * @param isReadOnly Indica se o campo é somente leitura.
     * @param value Valor inicial do campo.
     */
    public HTMLDecimalInput(String name, String label, boolean isRequired, boolean isReadOnly, String value) {
        super(name, label, "number", isRequired, isReadOnly, value);
    }

    /** Método construtor do componente de entrada decimal HTML.
     * @param name Nome do campo no formulário.
     * @param label Nome do campo de visualização.
     * @param value Valor inicial do campo.
     * @param step Valor do incremento do campo.
     * @param isRequired Indica se o campo é obrigatório.
     * @param isReadOnly Indica se o campo é somente leitura.
     */
    public HTMLDecimalInput(String name, String label, String value, String step, boolean isRequired, boolean isReadOnly) {
        this(name, label, isRequired, isReadOnly, value);
        this.step = step;
    }

    /** Método construtor do componente de entrada decimal HTML.
     * @param name Nome do campo no formulário.
     * @param label Nome do campo de visualização.
     * @param step Valor do incremento do campo.
     * @param isRequired Indica se o campo é obrigatório.
     * @param isReadOnly Indica se o campo é somente leitura.
     */
    public HTMLDecimalInput(String name, String label, String step, boolean isRequired, boolean isReadOnly) {
        this(name, label, null, step, isRequired, isReadOnly);
    }

    /** Método construtor do componente de entrada decimal HTML.
     * @param name Nome do campo no formulário.
     * @param label Nome do campo de visualização.
     * @param value Valor inicial do campo.
     * @param step Valor do incremento do campo.
     * @param min Valor mínimo do campo.
     * @param max Valor máximo do campo.
     * @param isRequired Indica se o campo é obrigatório.
     * @param isReadOnly Indica se o campo é somente leitura.
     */
    public HTMLDecimalInput(String name, String label, String value, String step, double min, double max, boolean isRequired, boolean isReadOnly) {
        this(name, label, value, step, isRequired, isReadOnly);
        this.min = min;
        this.max = max;
    }

    /**
     * Método que retorna o HTML do componente de entrada decimal.
     * @return String com o HTML do componente de entrada decimal.
     */
    public String toString() {
        return surroundContainer(String.format(
            getLabelTag() +
                "<input type=\"number\" id=\"%s\" inputMode=\"decimal\" name=\"%s\" class=\"inputForm\" step=\"%s\" %s %s %s %s %s>",
                name, name, step,
                min, max < min ? "" : String.format("max=\"%f\"", max),
                value != null ? String.format("value=\"%s\"", value) : "",
                isRequired ? "required" : "",
                isReadOnly ? "readonly" : ""
            )
        );
    }
}
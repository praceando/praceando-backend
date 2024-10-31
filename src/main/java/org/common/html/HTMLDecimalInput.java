package org.common.html;

import org.common.Constants;

public class HTMLDecimalInput extends HTMLInput {

    public double step;
    public double min = 0;
    public double max = -1;

    public HTMLDecimalInput(String name, String label, boolean isRequired, boolean isReadOnly, String value) {
        super(name, label, "number", isRequired, isReadOnly, value);
    }

    public HTMLDecimalInput(String name, String label, String value, double step, boolean isRequired, boolean isReadOnly) {
        this(name, label, isRequired, isReadOnly, value);
        this.step = step;
    }

    public HTMLDecimalInput(String name, String label, double step, boolean isRequired, boolean isReadOnly) {
        this(name, label, null, step, isRequired, isReadOnly);
    }

    public HTMLDecimalInput(String name, String label, String value, double step, double min, double max, boolean isRequired, boolean isReadOnly) {
        this(name, label, value, step, isRequired, isReadOnly);
        this.min = min;
        this.max = max;
    }

    private int getStepSize() {
        return String.valueOf(step).length() - 2;
    }

    public String toString() {
        String fmt = "%." + getStepSize() + "f";
        return surroundContainer(String.format(
            getLabelTag() +
                "<input type=\"number\" id=\"%s\" inputMode=\"decimal\" name=\"%s\" class=\"inputForm\" step="+String.format(fmt, step)+" %s %s %s %s %s>",
                name, name, step,
                min, max < min ? "" : String.format("max=\"%f\"", max),
                value != null ? String.format("value=\"%s\"", value) : "",
                isRequired ? "required" : "",
                isReadOnly ? "readonly" : ""
            )
        );
    }
}

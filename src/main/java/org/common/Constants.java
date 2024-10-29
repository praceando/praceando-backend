package org.common;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Constants {
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[^._\\s\\W]{2,}\\.[^._\\s\\W]{2,}@germinare\\.org\\.br$");
    public static final Pattern SENHA_PATTERN = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,}$");
    public static final String[] SELECT_CATEGORIA_TAGS =  {
            "Esportes e Atividades Físicas",
            "Meio Ambiente e Sustentabilidade",
            "Arte e Cultura",
            "Turismo e Lazer",
            "Sociedade e Comunidade",
            "Saúde e Bem-estar",
            "Educação e Tecnologia",
            "Gastronomia"
    };

    public static final SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy");

}

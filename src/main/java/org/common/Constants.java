package org.common;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Constants {
    // Padrão para validar e-mails
    // Deve ter 2 caracteres antes do ponto e 2 após, seguido de "@germinare.org.br"
    public static final Pattern emailPattern = Pattern.compile("^[^._\\s\\W]{2,}\\.[^._\\s\\W]{2,}@germinare\\.org\\.br$");

    // Padrão de expressão regular para validar senhas
    // A senha deve ter pelo menos 8 caracteres, incluindo pelo menos um dígito, uma letra maiúscula e uma letra minúscula
    public static final Pattern senhaPattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,}$");

    // Formato de data definido como "dd/MM/yyyy"
    // Usado para formatar e analisar datas nesse padrão
    public static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[^._\\s\\W]{2,}\\.[^._\\s\\W]{2,}@germinare\\.org\\.br$");
    public static final Pattern SENHA_PATTERN = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,}$");
    public static final String NUMBER_REGEX = "^(-(?!-))?\\d+((?<=\\d),(?!,))?\\d+$";
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

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
}

package org.common;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class Constants {

      /*==========================================================================================
      ||                                      REGEXES                                           ||
      ==========================================================================================*/

    // Padrão de expressão regular para validar senhas
    // A senha deve ter pelo menos 8 caracteres, incluindo pelo menos um dígito, uma letra maiúscula e uma letra minúscula
    public static final Pattern SENHA_PATTERN = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,}$");

    // Padrão para validar e-mails
    // Deve ter 2 caracteres antes do ponto e 2 após, seguido de "@germinare.org.br"
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[^._\\s\\W]{2,}\\.[^._\\s\\W]{2,}@germinare\\.org\\.br$");


    // Formato de data definido como "dd/MM/yyyy"
    // Usado para formatar e analisar datas nesse padrão
    public static final SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat FORMATO_DATA_AMERICANO = new SimpleDateFormat("yyyy-MM-dd");

    public static final String[] SELECT_CATEGORIA_TAGS = {
            "Esportes e Atividades Físicas",
            "Meio Ambiente e Sustentabilidade",
            "Arte e Cultura",
            "Turismo e Lazer",
            "Sociedade e Comunidade",
            "Saúde e Bem-estar",
            "Educação e Tecnologia",
            "Gastronomia",
            "Outros"
    };


      /*==========================================================================================
      ||                                NOMEAÇÃO DE TABELAS                                     ||
      ==========================================================================================*/

    public static final Tabela TABELA_LOG = new Tabela() {
        @Override public String getNomeBanco() {
            return "log";
        }
        @Override public String getNomeInterface() {
            return "Registros";
        }

        @Override
        public LinkedHashMap<String, String> getColunas() {
            LinkedHashMap<String, String> colunas = new LinkedHashMap<>();
            colunas.put("id", "ID");
            colunas.put("dt_log", "Data");
            colunas.put("operacao", "Operação");
            colunas.put("query", "Query SQL");
            return colunas;
        }
    };

    public static final Tabela TABELA_AVATAR = new Tabela() {
        @Override public String getNomeBanco() {
            return "avatar";
        }
        @Override public String getNomeInterface() {
            return "Avatares";
        }

        @Override
        public LinkedHashMap<String, String> getColunas() {
            LinkedHashMap<String, String> colunas = new LinkedHashMap<>();
            colunas.put("id", "ID");
            colunas.put("url_avatar", "URL");
            colunas.put("dt_atualizacao", "Data de Atualização");
            return colunas;
        }
    };

    public static final Tabela TABELA_TAG = new Tabela() {
        @Override public String getNomeBanco() {
            return "tag";
        }
        @Override public String getNomeInterface() {
            return "Tags";
        }

        @Override
        public LinkedHashMap<String, String> getColunas() {
            LinkedHashMap<String, String> colunas = new LinkedHashMap<>();
            colunas.put("id", "ID");
            colunas.put("nome", "Nome");
            colunas.put("categoria", "Categoria");
            colunas.put("descricao", "Descrição");
            colunas.put("dt_atualizacao", "Data de Atualização");
            return colunas;
        }
    };

    public static final Tabela TABELA_FRASE_SUSTENTAVEL = new Tabela() {
        @Override public String getNomeBanco() {
            return "frase_sustentavel";
        }
        @Override public String getNomeInterface() {
            return "Frases sustentáveis";
        }

        @Override
        public LinkedHashMap<String, String> getColunas() {
            LinkedHashMap<String, String> colunas = new LinkedHashMap<>();
            colunas.put("id", "ID");
            colunas.put("descricao", "Descrição");
            colunas.put("dt_atualizacao", "Data de Atualização");
            return colunas;
        }
    };

    public static final Tabela TABELA_ADMIN = new Tabela() {
        @Override public String getNomeBanco() {
            return "admin";
        }
        @Override public String getNomeInterface() {
            return "Admins";
        }

        @Override
        public LinkedHashMap<String, String> getColunas() {
            LinkedHashMap<String, String> colunas = new LinkedHashMap<>();
            colunas.put("id", "ID");
            colunas.put("nome", "Nome");
            colunas.put("email", "E-mail");
            colunas.put("is_ativo", "Ativo");
            colunas.put("senha", "Senha");
            colunas.put("dt_atualizacao", "Data de Atualização");
            return colunas;
        }
    };

    public static final Tabela TABELA_PRODUTO = new Tabela() {
        @Override public String getNomeBanco() {
            return "produto";
        }
        @Override public String getNomeInterface() {
            return "Produtos";
        }

        @Override
        public LinkedHashMap<String, String> getColunas() {
            LinkedHashMap<String, String> colunas = new LinkedHashMap<>();
            colunas.put("id", "ID");
            colunas.put("nome", "Nome");
            colunas.put("descricao", "Descrição");
            colunas.put("preco", "Preço");
            colunas.put("categoria", "Categoria");
            colunas.put("estoque", "Estoque");
            colunas.put("dt_desativacao", "Data desativação");
            colunas.put("dt_atualizacao", "Data de Atualização");

            return colunas;
        }
    };

    public static final Tabela TABELA_EVENTO_LOCAL = new Tabela() {
        @Override public String getNomeBanco() {
            return "evento_local";
        }
        @Override public String getNomeInterface() {
            return "Locais de eventos";
        }

        @Override
        public LinkedHashMap<String, String> getColunas() {
            LinkedHashMap<String, String> colunas = new LinkedHashMap<>();
            colunas.put("id", "ID");
            colunas.put("nome", "Nome");
            colunas.put("lat", "Latitude");
            colunas.put("lon", "Longitude");
            colunas.put("dt_atualizacao", "Data de Atualização");
            return colunas;
        }
    };

    public static final Tabela[] TABELAS = new Tabela[]{
            TABELA_LOG,
            TABELA_AVATAR,
            TABELA_TAG,
            TABELA_FRASE_SUSTENTAVEL,
            TABELA_ADMIN,
            TABELA_PRODUTO,
            TABELA_EVENTO_LOCAL
    };

    /**
     * Com base no nome da tabela no banco de dados, retorne o objeto tabela
     * @param nomeBanco Nome do banco
     * @return Objeto tabela relativo
     */
    public static Tabela getTabela(String nomeBanco) {
        for (Tabela t : TABELAS) {
            if (t.getNomeBanco().equals(nomeBanco)) {
                return t;
            }
        }
        return null;
    }
}

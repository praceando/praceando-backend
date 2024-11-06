package org.controller.util;
import org.model.Model;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Operações de auxílio de ordenação e filtragem de models.
 */
public class TableOperations {

    /**
     * Ordena uma lista de models por uma coluna
     * @param models Lista de models
     * @param coluna Qual coluna/campo a ser ordenado por
     * @param orderBy "asc" | "desc" para Crescente e Decrescente
     */
    public static void orderBy(List<Model> models, String coluna, String orderBy) {
        if (orderBy == null) {
            return;
        }

        boolean asc = !"desc".equalsIgnoreCase(orderBy);

        models.sort((model1, model2) -> {
            try {
                Field field1 = model1.getClass().getDeclaredField(coluna);
                Field field2 = model2.getClass().getDeclaredField(coluna);

                field1.setAccessible(true);
                field2.setAccessible(true);

                Object valor1 = field1.get(model1);
                Object valor2 = field2.get(model2);

                if (valor1 == null && valor2 == null) return 0;
                if (valor1 == null) return asc ? -1 : 1;
                if (valor2 == null) return asc ? 1 : -1;

                if (valor1 instanceof String && valor2 instanceof String) {
                    return asc ? ((String) valor1).compareToIgnoreCase((String) valor2) : (((String) valor2).compareToIgnoreCase((String) valor1));
                } else {
                    Comparable<Object> valor1_ = (Comparable<Object>) valor1;
                    Comparable<Object> valor2_ = (Comparable<Object>) valor2;
                    return asc ? valor1_.compareTo(valor2_) : valor2_.compareTo(valor1_);
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0;
        });
    }

    /**
     * Filtra todos os models de uma lista de models que contenham uma string de filtro em um campo especificado
     * @param models Lista de models
     * @param coluna Coluna a filtrar por
     * @param filterString Filtro
     * @param incluirNDef Inclui resultados null?
     */
    public static void filterByColumn(List<Model> models, String coluna, String filterString, boolean incluirNDef) {
        if (models == null || (filterString == null || filterString.isEmpty() || coluna == null || coluna.isEmpty())) {
            return;
        }

        models.removeIf(model -> {
            try {
                Field attr = model.getClass().getDeclaredField(coluna);
                attr.setAccessible(true);
                Object valor = attr.get(model);

                if (valor == null && !incluirNDef) {
                    return true;
                }

                String valorStr = valor != null ? valor.toString() : "Não definido";

                if (valorStr.toLowerCase().contains(filterString.toLowerCase())) {
                    return false;
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            return true;
        });
    }

}

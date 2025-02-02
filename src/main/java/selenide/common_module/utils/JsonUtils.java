package selenide.common_module.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Методы, связанные с чтением и записью JSON-файлов и объектов,
public class JsonUtils {
    private ObjectMapper objectMapper;

    //Читает JSON-файл по указанному пути и преобразует его в объект Map.
    @SneakyThrows
    public Map<String, Object> getMapFromFile(String filePath) {
        return objectMapper.readValue(new File(filePath), HashMap.class);
    }

    //Читает JSON-файл и преобразует его содержимое в строку (JSON-строку)
    @SneakyThrows
    public String getStringFromFile(String filePath) {
        return objectMapper.writeValueAsString(objectMapper.readValue(new File(filePath), HashMap.class));
    }

    //Преобразует карту (Map) в JSON-строку.
    @SneakyThrows
    public String getStringFromMap(Map<String, Object> json) {
        return objectMapper.writeValueAsString(json);
    }

    /**
     * Читает JSON-файл, доступный в classpath приложения, используя Spring Framework.
     * Этот метод подходит для чтения ресурсов, упакованных внутри JAR или доступных через classpath.
     * Особенно полезен в больших и распределенных приложениях, где файлы могут быть размещены в разных местах.
     * @param fileName имя файла в classpath.
     * @param context контекст приложения Spring, используемый для поиска ресурсов.
     * @return преобразованный в ObjectNode объект JSON из найденного ресурса.
     * @throws IOException если ресурсы не найдены или произошла ошибка при чтении.
     */
    @SneakyThrows
    public ObjectNode getObjectNodeFromFile(String fileName, ApplicationContext context) {
        Resource[] resources = context.getResources("classpath*://" + fileName);
        if (resources.length == 0) {
            System.out.printf("Файл '%s' не найден%n", fileName);
        }
        return (ObjectNode) objectMapper.readTree(resources[0].getURL());
    }

    @SneakyThrows
    public File getFileByName(String fileName, ApplicationContext context) {
        Resource[] resources = context.getResources("classpath*://" + fileName);
        if (resources.length == 0) {
            System.out.printf("Файл '%s' не найден%n", fileName);
        }
        return resources[0].getFile();
    }

    /**
     * Рекурсивный поиск поля на любом уровне вложенности в JSON.
     *   Рекурсивно - означает, что метод или функция вызывает сам себя для решения более мелкой части той же задачи.
     * @param node         текущий узел JSON
     * @param fieldName    имя искомого поля
     * @param expectedValue ожидаемое значение поля
     * @return true, если поле с заданным значением найдено
     */
    public boolean containsFieldWithValue(JsonNode node, String fieldName, String expectedValue) {
        //Проверяет, содержит ли текущий узел указанное поле и его значение.
        if (node.has(fieldName) && node.get(fieldName).asText().equals(expectedValue)) {
            return true;
        }
        //Если текущий узел является объектом (node.isObject()),
        // метод обходит все дочерние узлы (ключи-значения) и рекурсивно вызывает сам себя.
        if (node.isObject()) {
            for (JsonNode child : node) {
                if (containsFieldWithValue(child, fieldName, expectedValue)) {
                    return true;
                }
            }
            //Если текущий узел является массивом (node.isArray()),
            // метод обходит все элементы массива и также рекурсивно вызывает сам себя.
        } else if (node.isArray()) {
            for (JsonNode arrayElement : node) {
                if (containsFieldWithValue(arrayElement, fieldName, expectedValue)) {
                    return true;
                }
            }
        }
        return false;
    }

}


package weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherParser {

    public static void parse(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            JsonNode current = root.get("currentConditions");

            System.out.println("\n=== INFORMAÇÕES DO CLIMA ===");
            System.out.println("Temperatura atual: " + current.get("temp") + "°C");
            System.out.println("Temperatura máxima: " + current.get("tempmax") + "°C");
            System.out.println("Temperatura mínima: " + current.get("tempmin") + "°C");
            System.out.println("Umidade do ar: " + current.get("humidity") + "%");
            System.out.println("Condição do tempo: " + current.get("conditions").asText());
            System.out.println("Precipitação: " + current.get("precip") + "mm");
            System.out.println("Velocidade do vento: " + current.get("windspeed") + "km/h");
            System.out.println("Direção do vento: " + current.get("winddir") + "°");

        } catch (Exception e) {
            System.out.println("Erro ao processar a resposta JSON: " + e.getMessage());
        }
    }
}

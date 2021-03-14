import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, IOException {
        System.out.println("Hola mundo");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("https://swapi.dev/api/people");
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    ApiResponse<Character> parsedResponse = mapper.readValue(
                            result, mapper.getTypeFactory().constructParametricType(ApiResponse.class, Character.class));
                    createData(parsedResponse);
                }
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }

    public static void createData(ApiResponse<Character> response){
        int size = response.getResults().size();
        Object[][] data = new Object[size][3];
        int k = 0;
        for (Character i: response.getResults()){
            data[k][0] = i.getName();
            data[k][1] = i.getHeight();
            data[k][2] = i.getBirth_year();
            k++;
        }
        Object[][] data2 = {{"Daniel", "Villar","Esquiar"},
                {"Carlos", "Villar","Patinar"},
                {"Karinna", "Villar","Escalar"},
                {"Mario", "Diaz","Correr"},
                {"Sylvia", "Uribe","Modelar"}};
        Table tabla = new Table();
        tabla.setData(data);
        tabla.crearTable();
        tabla.pack();
        tabla.setVisible(true);

    }
}

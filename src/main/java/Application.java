import br.com.exercise.resource.DocumentReaderResource;
import br.com.exercise.service.DocumentReaderService;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        DocumentReaderResource documentReaderResource = new DocumentReaderResource(new DocumentReaderService());
        System.out.println(documentReaderResource.readDocument());
    }
}

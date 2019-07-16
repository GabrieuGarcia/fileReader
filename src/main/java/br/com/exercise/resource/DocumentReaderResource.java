package br.com.exercise.resource;

import br.com.exercise.service.DocumentReaderService;

import java.io.IOException;

public class DocumentReaderResource {

    private DocumentReaderService documentReaderService;

    public DocumentReaderResource(DocumentReaderService documentReaderService) {
        this.documentReaderService = documentReaderService;
    }

    public String readDocument()  throws IOException {
        return documentReaderService.readDocument();
    }

}

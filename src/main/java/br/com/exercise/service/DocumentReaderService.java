package br.com.exercise.service;

import br.com.exercise.model.Client;
import br.com.exercise.model.Item;
import br.com.exercise.model.Sale;
import br.com.exercise.model.Salesman;

import java.io.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DocumentReaderService {

    private final String USER_HOME = "user.home";
    private final String DAT_DOCUMENT = ".dat";
    private final String DAT_DOCUMENT_IN = "/data/in";
    private final String SYSTEM_DAT_DOCUMENT_ACCESS = System.getProperty(USER_HOME) + DAT_DOCUMENT_IN;
    private final String DAT_DOCUMENT_OUT = "/dados/out/";
    private final String DOCUMENT_DIVISOR = "ç";
    private final String ITEM_DIVISOR = ",";
    private final String ITEM_VALUES_DIVISOR = "-";


    public String readDocument() throws IOException {

        try {
            List<File> filesFound = getDocumentFile();
            divideDocumentFile(filesFound);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "deu";
    }


    private List<File> getDocumentFile() throws FileNotFoundException {

        File fileFoundOnPath = new File(SYSTEM_DAT_DOCUMENT_ACCESS);
        List<File> filesFound = new ArrayList<>();

        for (File file : fileFoundOnPath.listFiles()) {
            if(file.getName().endsWith(DAT_DOCUMENT)){
                filesFound.add(file);
            } else {
                throw new FileNotFoundException();
            }
        }
        return filesFound;
    }

    private void divideDocumentFile(List<File> filesFound) throws IOException {

        for (File file : filesFound) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);

            while (bufferedReaderFile.readLine() != null) {

                String[] lines = bufferedReaderFile.readLine().split(DOCUMENT_DIVISOR);

                if (lines[0].equals(Salesman.SALESMAN_CODE)) {
                    Salesman salesman = new Salesman();
                    salesman.setId(lines[1]);
                    System.out.println(salesman.getId());
                    salesman.setName(lines[2]);
                    salesman.setSalary(new BigDecimal(lines[3]));

                } else if (lines[0].equals(Client.CLIENT_CODE)) {
                    Client client = new Client();
                    client.setId(lines[1]);
                    client.setName(lines[2]);
                    client.setBusinessArea(lines[3]);

                } else if (lines[0].equals(Sale.SALE_CODE)) {
                    Sale sale = new Sale();
                    sale.setId(lines[1]);
                    sale.setName(lines[2]);
                    setSaleItens(lines[3], sale);
                }
            }
        }
    }

    private void setSaleItens(String lineIncomming, Sale sale) throws IOException {

        String[] line = lineIncomming.split(ITEM_VALUES_DIVISOR);

        for (String info : line) {
            FileReader fileReader = new FileReader(info);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String[] lines = bufferedReaderFile.readLine().split(ITEM_VALUES_DIVISOR);
            Item item = new Item();
            item.setItemId(lines[0]);
            item.setItemQuantity(Integer.parseInt(lines[1]));
            item.setItemPrice(new BigDecimal(lines[2]));
            sale.getItemList().add(item);
        }
    }
}

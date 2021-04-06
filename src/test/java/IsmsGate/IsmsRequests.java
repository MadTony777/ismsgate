package IsmsGate;

import Utilities.SoapClient;
import Utilities.SoapClientBuilder;
import Utilities.SoapRequest;
import Utilities.SoapResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IsmsRequests extends BaseClass{

    public static SoapClient soapClient;


    public String RequestMethod (String fileName, String environment) throws Exception {
        final Logger log = LoggerFactory.getLogger(UnitTests.class);
        String URL = "";
        switch (environment){
            case "stage":
                URL = url_stg;
                break;
            case "test":
                URL = url_tst;
        }
        soapClient = SoapClientBuilder.create().build();
        String rightBody = new String(Files.readAllBytes(Paths.get(paths + fileName)), StandardCharsets.UTF_8);
        SoapResponse<String> response = soapClient.call(new SoapRequest(URL, soapAction, rightBody));
        String result = String.valueOf(response);
        log.info(result);
        soapClient.close();
        return result;
    }
}

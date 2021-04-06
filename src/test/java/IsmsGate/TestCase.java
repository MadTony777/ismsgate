package IsmsGate;



public class TestCase {
    public String CaseTemplate (String fileName, String environment) throws Exception {

        IsmsRequests ismsrequest = new IsmsRequests();

        String result = ismsrequest.RequestMethod(fileName, environment);
        return result;
    }
}

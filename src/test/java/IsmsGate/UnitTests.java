package IsmsGate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;



public class UnitTests {
    TestCase testcase = new TestCase();
    String arg = System.getProperty("arg", "test");
    public String environment = arg;
    private static final Logger log = LoggerFactory.getLogger(UnitTests.class);

    @BeforeEach
    public void executedBeforeEach(TestInfo testInfo) {
        log.info("Starting test: "+ testInfo.getDisplayName());
    }

    @AfterEach
    public void executedAfterEach() {

        log.info("End test\n");
    }


    @Test
    public void IsmsGate_Positive_noAuth_COMPLETED() throws Exception {

        String ismsresponce = testcase.CaseTemplate("Positive_noAuth.xml", environment);
        assertThat(ismsresponce, containsString( "<return/>"));

    }


    @Test
    public void IsmsGate_Negative_noAuth_COMPLETED() throws Exception {
        String ismsresponce = testcase.CaseTemplate("Negative_noAuth.xml", environment);
        assertThat(ismsresponce, containsString( "Validation failed for"));
    }


    @Test
    public void IsmsGate_Positive_Auth_COMPLETED() throws Exception {
        String ismsresponce = testcase.CaseTemplate("Positive_Auth.xml", environment);
        assertThat(ismsresponce, containsString( "<return/>"));
    }


    @Test
    public void IsmsGate_Negative_Auth_COMPLETED() throws Exception {
        String ismsresponce = testcase.CaseTemplate("Negative_Auth.xml", environment);
        assertThat(ismsresponce, containsString( "Validation failed for"));
    }
}

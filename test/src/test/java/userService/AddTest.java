package userService;

import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import java.io.IOException;

import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class AddTest extends TestHelpers{

    @Before
    public void initialize() throws IOException {
        cleanupUsers();
    }

    @Test
    @Parameters(method = "test_add_Success")
    public void testAddSuccess(String testDescription, String name) throws IOException {

        //Given

        //When
        addUser(name);

        //Then
        checkUser(name.replace("%20", " "));
    }

    private static Object[] test_add_Success() {
        return $(
                $("Valid Username",                 "JohnSnow"),
                $("Valid Username with space",      "John%20Snow"),
                $("Valid Username long",            LONG_STRING),
                $("Valid Username utf support",     UTF_CHARS)
        );
    }

}


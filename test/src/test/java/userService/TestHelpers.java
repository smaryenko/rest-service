package userService;

import org.testng.asserts.SoftAssert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestHelpers extends TestBase{

    public String addUser(String name) throws IOException {
        return sendRequest(SERVICE_URL + "/add/" + name);
    }

    public String getUsers() throws IOException {
        return sendRequest(SERVICE_URL + "/get/");
    }

    public String removeUser(String name) throws IOException {
        return sendRequest(SERVICE_URL + "/remove/" + name);
    }

    public String cleanupUsers() throws IOException {
        return sendRequest(SERVICE_URL + "/cleanup/");
    }

    public void checkUser(String name) throws IOException {
        String valideteString = "\"name\":\""+ name + "\"";

        String list = getUsers();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(list.contains(valideteString),
                                String.format("User %s was not in the collection", name));
        softAssert.assertTrue(list.indexOf(valideteString) == list.lastIndexOf(valideteString),
                                String.format("User %s was not in the collection multiple times", name));
        softAssert.assertAll();
    }

    public static String sendRequest(String url) throws IOException {
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Authorization", "Basic key");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String list = response.toString();
        System.out.println(list);
        return list;
    }

}


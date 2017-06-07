package restclient;

import java.io.IOException;

import java.net.MalformedURLException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.core.MultivaluedMap;

import Decoder.BASE64Encoder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class restclient {
    public restclient() {
        super();
    }

    public static void main(String[] args) {


        //********************Get Method on Secured Service********************//
        //              Client c = Client.create();
        //              WebResource resource = c.resource("https://apex-a423930.db.em2.oraclecloudapps.com/apex/hr/empinfo/");
        //              String response = resource.get(String.class);
        //              System.out.println(response);

        //              ----------------------------------------------------------------------------------------------

        //              String url = "https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/";
        //              String name = "mhashash@fsa.com.sa";
        //              String password = "Fsa@1234";
        //              String authString = name + ":" + password;
        //              String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
        //              System.out.println("Base64 encoded auth string: " + authStringEnc);
        //              Client restClient = Client.create();
        //              WebResource webResource = restClient.resource(url);
        //              ClientResponse resp = webResource.accept("application/javascript")
        //                                               .header("Authorization", "Basic " + authStringEnc)
        //                                               .get(ClientResponse.class);
        //              if(resp.getStatus() == 200){
        ////                    201 created,204 no content
        //                  System.out.println("Successful");
        //                  String output = resp.getEntity(String.class);
        //                      System.out.println(output);
        //              } else if(resp.getStatus() != 200){
        //                      System.err.println("Unable to connect to the server");
        //              }


        //              ---------------------------------------------------------------------------------------------
        //********************POST Method Passing Parameters in header********************//
        //              String url = "https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/";
        //              String name = "mhashash@fsa.com.sa";
        //              String password = "Fsa@1234";
        //              String authString = name + ":" + password;
        //              String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
        //              System.out.println("Base64 encoded auth string: " + authStringEnc);
        //
        //              Client restClient = Client.create();
        //              WebResource webResource = restClient.resource(url);
        //              ClientResponse resp = webResource.accept("application/javascript")
        //                              .header("Authorization", "Basic " + authStringEnc).header("PRIMARY_KEY", "aaa")
        //                              .header("CONTRACT_NUMBER", "aaa").header("BOQ_NUMBER", "aaa").header("WIR_NUMBER", "aaa")
        //                              .post(ClientResponse.class);
        //
        //              if(resp.getStatus() == 200){
        //                      System.out.println("Successful : Response to a successful GET, PUT, PATCH or DELETE");
        //                      String output = resp.getEntity(String.class);
        //                      System.out.println(output);
        //              } else if(resp.getStatus() == 201){
        //                      System.err.println("Created : POST Successful");
        //              } else if(resp.getStatus() == 204){
        //                      System.err.println("No content : Response to a successful request that won't be returning a body (like a DELETE request)");
        //              } else if(resp.getStatus() == 304){
        //                      System.err.println("Not Modified : Used when HTTP caching headers are in play");
        //              } else if(resp.getStatus() == 400){
        //                      System.err.println("Bad request : The request is malformed, such as if the body does not parse");
        //              } else if(resp.getStatus() == 401){
        //                      System.err.println("Unauthorized : When no or invalid authentication details are provided. Also useful to trigger an auth popup if the API is used from a browser");
        //              } else if(resp.getStatus() == 403){
        //                      System.err.println("Forbidden : When authentication succeeded but authenticated user doesn't have access to the resource");
        //              } else if(resp.getStatus() == 404){
        //                      System.err.println("Not found : When a non-existent resource is requested");
        //              } else if(resp.getStatus() == 405){
        //                      System.err.println("Method not allowed : When an HTTP method is being requested that isn't allowed for the authenticated user");
        //              } else if(resp.getStatus() == 409){
        //                      System.err.println("Conflict : An attempt was made to create an object that already exists");
        //              } else if(resp.getStatus() == 410){
        //                      System.err.println("Gone : Indicates that the resource at this end point is no longer available. Useful as a blanket response for old API versions");
        //              } else if(resp.getStatus() == 415){
        //                      System.err.println("Unsupported media type : If incorrect content type was provided as part of the request");
        //              } else if(resp.getStatus() == 422){
        //                      System.err.println("Unprocessable entity : Used for validation errors");
        //              } else if(resp.getStatus() == 429){
        //                      System.err.println("Too many requests : When a request is rejected due to rate limiting");
        //              } else if(resp.getStatus() == 500){
        //                      System.err.println("Internal server error : The execution of the service failed in some way");
        //              } else {
        //                      System.err.println("Unknown error");
        //              }
        //              resp.close();

        //              ---------------------------------------------------------------------------------------------

        //********************POST Method Passing Parameters in JSON********************//
        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input =
                "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            //                      if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            //                              throw new RuntimeException("Failed : HTTP error code : "
            //                                      + conn.getResponseCode());
            //                      }

            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public String deductionsetuprestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String deductiontxnrestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String ipcsummaryrestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String ipcreportrestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String contractheaderrestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String ipcworkdonerestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String ipcmonthlyrestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String purchaseorderrestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String ipcbalanceduerestclient(String input)

    {

        try {

            URL url =
                new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            input =
                    "{\"wir\":[{\"APPROVED_QUANTITY\":\"eee\",\"BOQ_NUMBER\":\"eee\",\"CONTRACT_NUMBER\":\"eee\",\"PERIOD\":\"eee\",\"PRIMARY_KEY\":\"eee\",\"READY_TO_BILL\":\"eee\",\"REMARKS\":\"eee\",\"REPORT_DATA\":\"eee\",\"UNIT_OF_MEASURE\":\"eee\",\"WIR_DATE\":\"eee\",\"WIR_NUMBER\":\"eee\",\"WIR_TOTAL\":\"eee\"},{\"APPROVED_QUANTITY\":\"fff\",\"BOQ_NUMBER\":\"fff\",\"CONTRACT_NUMBER\":\"fff\",\"PERIOD\":\"fff\",\"PRIMARY_KEY\":\"fff\",\"READY_TO_BILL\":\"fff\",\"REMARKS\":\"fff\",\"REPORT_DATA\":\"fff\",\"UNIT_OF_MEASURE\":\"fff\",\"WIR_DATE\":\"fff\",\"WIR_NUMBER\":\"fff\",\"WIR_TOTAL\":\"fff\"}]}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();


            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }
}

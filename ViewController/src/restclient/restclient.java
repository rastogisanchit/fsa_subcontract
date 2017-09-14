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
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class restclient {

    private String name = "mhashash@fsa.com.sa";
    private String password = "Fsa@1234";

    public restclient() {
        super();
    }

    public void importCertificates() {
        try {
            TrustManager[] trustAllCerts =
                new TrustManager[] { new X509TrustManager() {
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                                                   String authType) throws java.security.cert.CertificateException {
                    }

                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                                                   String authType) throws java.security.cert.CertificateException {
                    }

                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        // or you can return null too
                        return new java.security.cert.X509Certificate[0];
                    }
                } };


            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                    public boolean verify(String string,
                                          SSLSession sslSession) {
                        return true;
                    }
                });
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        } catch (KeyManagementException e) {
            System.out.println(e);
        }
    }

    //    public static void main(String[] args) throws MalformedURLException {
    //        URL getUrl =
    //            new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/hr/empinfo/");
    //        URL postUrl =
    //            new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_boq_service/wirentry/");
    //        RestClient rc = new RestClient();
    //        rc.importCertificates();
    //        //        rc.RestGETOperation(getUrl);
    //        rc.RestPOSTOperation(postUrl);
    //
    //        //        Client c = Client.create();
    //        //        WebResource resource = c.resource(url.toString());
    //        //        String response = resource.get(String.class);
    //        //        System.out.println(response);
    //    }

    public String RestGETOperation(URL url) {
        String authString = name + ":" + password;
        String output = "";
        String authStringEnc =
            new BASE64Encoder().encode(authString.getBytes());
        //        System.out.println("Base64 encoded auth string: " + authStringEnc);
        try {
            Client restClient = Client.create();
            WebResource webResource = restClient.resource(url.toString());

            //        ClientResponse resp = webResource.accept("application/javascript").header("Authorization", "Basic " + authStringEnc).get(ClientResponse.class);
            ClientResponse resp = webResource.get(ClientResponse.class);

            if (resp.getStatus() == 200) {
                System.out.println("Successful");
                output = resp.getEntity(String.class);
                //            System.out.println(output);
            } else if (resp.getStatus() != 200) {
                System.err.println("Unable to connect to the server");
            }
        } catch (UniformInterfaceException uie) {
            System.out.println("UniformInterfaceException");
            //            uie.printStackTrace();
        } catch (ClientHandlerException che) {
            System.out.println("ClientHandlerException");
            //            che.printStackTrace();
        }
        return output;
    }

    public void RestPOSTOperation(URL url, String json) {
        try {
            String authString = name + ":" + password;
            String authStringEnc =
                new BASE64Encoder().encode(authString.getBytes());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            //            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
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
    }

    public void RestPUTOperation(URL url, String json) {
        try {
            String authString = name + ":" + password;
            String authStringEnc =
                new BASE64Encoder().encode(authString.getBytes());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            //            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            if (json != "") {
                conn.setRequestProperty("Content-Type", "application/json");
                OutputStream os = conn.getOutputStream();
                os.write(json.getBytes());
                os.flush();
            }

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

    public void RestDELETEOperation(URL url) {
        try {
            String authString = name + ":" + password;
            String authStringEnc =
                new BASE64Encoder().encode(authString.getBytes());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            //            conn.setRequestProperty("Content-Type", "application/json");
            //            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);

            //            OutputStream os = conn.getOutputStream();
            //            os.write(json.getBytes());
            //            os.flush();

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
}

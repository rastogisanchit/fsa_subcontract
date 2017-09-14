package nonlaborresourcemodel.facade;

import com.oracle.xmlns.oxp.service.publicreportservice.AccessDeniedException_Exception;
import com.oracle.xmlns.oxp.service.publicreportservice.ExternalReportWSSService;
import com.oracle.xmlns.oxp.service.publicreportservice.ExternalReportWSSService_Service;

import com.oracle.xmlns.oxp.service.publicreportservice.InvalidParametersException_Exception;
import com.oracle.xmlns.oxp.service.publicreportservice.ObjectFactory;
import com.oracle.xmlns.oxp.service.publicreportservice.OperationFailedException_Exception;
import com.oracle.xmlns.oxp.service.publicreportservice.ReportRequest;
import com.oracle.xmlns.oxp.service.publicreportservice.ReportResponse;

import com.sun.xml.ws.developer.WSBindingProvider;

import java.io.IOException;
import java.io.StringReader;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import javax.net.ssl.X509TrustManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import nonlaborresourcemodel.POJO.NonLaborResourcesPOJO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import weblogic.wsee.jws.jaxws.owsm.SecurityPoliciesFeature;

public class NonLaborResourcesFacade {
    private List<NonLaborResourcesPOJO> _NONLABORESOURCELIST;
    private String _USERNAME = "CHANDER";
    private String _PASSWORD = "fsa12345";

    public NonLaborResourcesFacade() {
        super();
        _NONLABORESOURCELIST = new ArrayList<NonLaborResourcesPOJO>();
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
                        // or we can return null too
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

    public List<NonLaborResourcesPOJO> getNonLaborResources() {
        String nonlaborname = "";
        importCertificates();
        ExternalReportWSSService_Service externalReportWSSService_Service;
        externalReportWSSService_Service =
                new ExternalReportWSSService_Service();
        SecurityPoliciesFeature securityFeatures =
            new SecurityPoliciesFeature(new String[] { "oracle/wss_username_token_over_ssl_client_policy" });
        //                new SecurityPoliciesFeature(new String[] { "oracle/wss_saml_token_bearer_over_ssl_client_policy" });

        ExternalReportWSSService externalReportWSSService =
            externalReportWSSService_Service.getExternalReportWSSService(securityFeatures);

        WSBindingProvider wsbp = (WSBindingProvider)externalReportWSSService;
        Map<String, Object> requestContext = wsbp.getRequestContext();
        requestContext.put(WSBindingProvider.USERNAME_PROPERTY,
                           this._USERNAME);
        requestContext.put(WSBindingProvider.PASSWORD_PROPERTY,
                           this._PASSWORD);
        requestContext.put(WSBindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                           "https://eehx-test.bi.em3.oraclecloud.com:443/xmlpserver/services/ExternalReportWSSService");
        String data = "";

        try {
            ObjectFactory of = new ObjectFactory();
            ReportRequest reportRequest = of.createReportRequest();
            reportRequest.setReportAbsolutePath("/Custom/Non_Labor_Resoures.xdo");
            reportRequest.setAttributeFormat("xml");
            reportRequest.setSizeOfDataChunkDownload(-1);
            ReportResponse reportResponse;

            reportResponse =
                    externalReportWSSService.runReport(reportRequest, "");
            data = new String(reportResponse.getReportBytes());
        } catch (InvalidParametersException_Exception e) {
            System.out.println("InvalidParametersException_Exception");
        } catch (AccessDeniedException_Exception e) {
            System.out.println("AccessDeniedException_Exception");
        } catch (OperationFailedException_Exception e) {
            System.out.println("OperationFailedException_Exception");
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(data));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("G_1");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element row_element = (Element)nodes.item(i);
                nonlaborname =
                        row_element.getElementsByTagName("NLR_NAME").item(0).getTextContent();
                _NONLABORESOURCELIST.add(new NonLaborResourcesPOJO(nonlaborname));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException saxe) {
            saxe.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        return _NONLABORESOURCELIST;
    }

    public static void main(String[] args) {
        NonLaborResourcesFacade nonLaborResourcesFacade =
            new NonLaborResourcesFacade();
        nonLaborResourcesFacade.getNonLaborResources();
    }
}

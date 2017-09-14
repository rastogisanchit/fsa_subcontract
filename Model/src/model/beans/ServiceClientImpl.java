package model.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.io.StringReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import model.pojo.ContractHeaderPOJO;
import model.pojo.ContractIdPOJO;
import model.pojo.ContractLinePOJO;
import model.pojo.DeductionNamePOJO;
import model.pojo.ProjectDetailsPOJO;

import nonlaborresourcemodel.POJO.NonLaborResourcesPOJO;

import nonlaborresourcemodel.facade.NonLaborResourcesFacade;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ServiceClientImpl {
    private List<ContractIdPOJO> _CONTRACTLIST;
    private List<ContractHeaderPOJO> _CONTRACTHEADERLIST;
    private List<ContractLinePOJO> _CONTRACTLINELIST;
    private List<ProjectDetailsPOJO> _PROJECTDETAILSLIST;
    private List<DeductionNamePOJO> _LABOURDEDUCTIONAMELIST;
    private List<NonLaborResourcesPOJO> _NONLABORESOURCELIST;

    private String _USERNAME = "CHANDER";
    private String _PASSWORD = "fsa12345";
    private String _CONTRACTSERVICE_URL =
        "https://eehx-test.crm.em3.oraclecloud.com:443/external-contractmanagement-contractsCoreTransactionContracts/ContractService";
    private String _PROJECTSERVICE_URL =
        "https://eehx-test.prj.em3.oraclecloud.com:443/pjfProjectDefinition/ProjectDefinitionPublicServiceV2";
    private String _HRJOBSERVICE_URL =
        "https://eehx-test.hcm.em3.oraclecloud.com:443/hcmWorkJobsV2/JobService";
    private String _FINDCONTRACTS_PAYLOAD =
        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/\" xmlns:typ1=\"http://xmlns.oracle.com/adf/svc/types/\">\n" +
        "   <soapenv:Header/>\n" +
        "   <soapenv:Body>\n" +
        "      <typ:findContract>\n" +
        "         <typ:findCriteria>\n" +
        "            <typ1:fetchStart>0</typ1:fetchStart>\n" +
        "            <typ1:fetchSize>499</typ1:fetchSize>\n" +
        "            <typ1:filter>\n" +
        "               <typ1:group>\n" +
        "                  <typ1:item>\n" +
        "                     <typ1:upperCaseCompare>true</typ1:upperCaseCompare>\n" +
        "                     <typ1:attribute>CreatedBy</typ1:attribute>\n" +
        "                     <typ1:operator>=</typ1:operator>\n" +
        "                     <typ1:value>snoor</typ1:value>\n" +
        "                  </typ1:item>\n" +
        "                  <typ1:conjunction>And</typ1:conjunction>\n" +
        "                  <typ1:item>\n" +
        "                  <typ1:upperCaseCompare>true</typ1:upperCaseCompare>\n" +
        "                     <typ1:attribute>BuyOrSell</typ1:attribute>\n" +
        "                     <typ1:operator>=</typ1:operator>\n" +
        "                     <typ1:value>B</typ1:value>\n" +
        "                  </typ1:item>\n" +
        "                  <typ1:conjunction>And</typ1:conjunction>\n" +
        "                  <typ1:item>\n" +
        "                  <typ1:upperCaseCompare>true</typ1:upperCaseCompare>\n" +
        "                     <typ1:attribute>Status</typ1:attribute>\n" +
        "                     <typ1:operator>=</typ1:operator>\n" +
        "                     <typ1:value>Active</typ1:value>\n" +
        "                  </typ1:item>\n" +
        "               </typ1:group>\n" +
        "            </typ1:filter>\n" +
        "            <typ1:findAttribute>Id</typ1:findAttribute>\n" +
        "            <typ1:findAttribute>MajorVersion</typ1:findAttribute>\n" +
        "            <typ1:findAttribute>ContractNumber</typ1:findAttribute>\n" +
        "          </typ:findCriteria>\n" +
        "         <typ:findControl>\n" +
        "            <typ1:retrieveAllTranslations>false</typ1:retrieveAllTranslations>\n" +
        "         </typ:findControl>\n" +
        "      </typ:findContract>\n" +
        "   </soapenv:Body>\n" +
        "</soapenv:Envelope>";

    private String _FINDPROJECTS_PAYLOAD =
        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/projects/foundation/projectDefinition/publicService/maintainProjectV2/types/\" xmlns:typ1=\"http://xmlns.oracle.com/adf/svc/types/\">\n" +
        "   <soapenv:Header/>\n" +
        "   <soapenv:Body>\n" +
        "      <typ:findProject>\n" +
        "         <typ:findCriteria>\n" +
        "               <typ1:findAttribute>ProjectNumber</typ1:findAttribute>\n" +
        "               <typ1:findAttribute>ProjectName</typ1:findAttribute>\n" +
        "         </typ:findCriteria>\n" +
        "      </typ:findProject>\n" +
        "   </soapenv:Body>\n" +
        "</soapenv:Envelope>";

    private String _FINDHRJOBS_PAYLOAD =
        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/workStructures/jobs/jobServiceV2/types/\" xmlns:typ1=\"http://xmlns.oracle.com/adf/svc/types/\">\n" +
        "   <soapenv:Header/>\n" +
        "   <soapenv:Body>\n" +
        "      <typ:findJob>\n" +
        "         <typ:findCriteria>\n" +
        "         <typ1:fetchStart>0</typ1:fetchStart>\n" +
        "            <typ1:fetchSize>-1</typ1:fetchSize>\n" +
        "            <typ1:findAttribute>Name</typ1:findAttribute>\n" +
        "         </typ:findCriteria>\n" +
        "      </typ:findJob>\n" +
        "   </soapenv:Body>\n" +
        "</soapenv:Envelope>\n";


    public ServiceClientImpl() {
        super();
        _CONTRACTLIST = new ArrayList<ContractIdPOJO>();
        _CONTRACTHEADERLIST = new ArrayList<ContractHeaderPOJO>();
        _CONTRACTLINELIST = new ArrayList<ContractLinePOJO>();
        _PROJECTDETAILSLIST = new ArrayList<ProjectDetailsPOJO>();
        _LABOURDEDUCTIONAMELIST = new ArrayList<DeductionNamePOJO>();
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
    String deductionenabled;

    public static void main(String[] args) throws Exception {
        ServiceClientImpl sci = new ServiceClientImpl();
        sci.importCertificates();

        //        sci.getLabourDeductionNameDetails();
        //        sci.getNonLaborResources();

        //                String findContracts_Response =
        //                    sci.httpPost_GetResponse(sci._CONTRACTSERVICE_URL,
        //                                             sci._FINDCONTRACTS_PAYLOAD,
        //                                             sci._USERNAME + ":" + sci._PASSWORD);
        //                sci.findContracts_ResponseParser(findContracts_Response);
        //
        //                for (int i = 0; i < sci._CONTRACTLIST.size(); i++) {
        //                    System.out.println("Contract Id : " +
        //                                       sci._CONTRACTLIST.get(i).getContractid() +
        //                                       " | Contract Number : " +
        //                                       sci._CONTRACTLIST.get(i).getContractnumber());
        //                }
        //
        //        System.out.println("----------------------------------------------------------------------------------------");

        sci.getContractHeader("300000055048046", "1");
        for (int i = 0; i < sci._CONTRACTHEADERLIST.size(); i++) {
            System.out.println("Contract Number : " +
                               sci._CONTRACTHEADERLIST.get(i).getContractnumber() +
                               " | Contract Type : " +
                               sci._CONTRACTHEADERLIST.get(i).getContracttype() +
                               " | Deduction Enabled : " +
                               sci._CONTRACTHEADERLIST.get(i).getDeduction() +
                               " | ProjectNumber:" +
                               sci._CONTRACTHEADERLIST.get(i).getProjectnumber() +
                               " | ProjectName:" +
                               sci._CONTRACTHEADERLIST.get(i).getProjectname() +
                               " | PartyName:" +
                               sci._CONTRACTHEADERLIST.get(i).getPartyname() +
                               " | Amount:" +
                               sci._CONTRACTHEADERLIST.get(i).getAmount() +
                               " | PartyNumber:" +
                               sci._CONTRACTHEADERLIST.get(i).getPartynumber() +
                               " | Advancepercent:" +
                               sci._CONTRACTHEADERLIST.get(i).getAdvancepercent() +
                               " | Retentionpercent:" +
                               sci._CONTRACTHEADERLIST.get(i).getRetentionpercent() +
                               " | SupplierSite:" +
                               sci._CONTRACTHEADERLIST.get(i).getSuppliersite() +
                               " | PaymentTerms:" +
                               sci._CONTRACTHEADERLIST.get(i).getPaymenterms());
        }


        //        System.out.println("----------------------------------------------------------------------------------------");
        //                        sci.getContractLines("300000002852081", "1");
        //                        for (int i = 0; i < sci._CONTRACTLINELIST.size(); i++) {
        //                            System.out.println("Contract Number : " +
        //                                               sci._CONTRACTLINELIST.get(i).getContractnumber() +
        //                                               " | Line Number : " +
        //                                               sci._CONTRACTLINELIST.get(i).getBoqnumber() +
        //                                               " | UOM : " +
        //                                               sci._CONTRACTLINELIST.get(i).getUnitofmeasure() +
        //                                                " | Supplier : " +
        //                                               sci._CONTRACTLINELIST.get(i).getSupplier()+
        //                                                " | SupplierName : " +
        //                                                sci._CONTRACTLINELIST.get(i).getSupplierSiteName());
        //                        }

        //                String LabourDeductionNameDetails_Response =
        //                    sci.httpPost_GetResponse(sci._HRJOBSERVICE_URL,
        //                                             sci._FINDHRJOBS_PAYLOAD,
        //                                             sci._USERNAME + ":" + sci._PASSWORD);
        //                 System.out.println("LabourDeductionNameDetails_Response : " +
        //                                   LabourDeductionNameDetails_Response);
        //                sci.getLabourDeductionNameDetails_ResponseParser(LabourDeductionNameDetails_Response);
        //                for (int i = 0; i < sci._LABOURDEDUCTIONAMELIST.size(); i++) {
        //                    System.out.println("Deduction Name : " +
        //                                       sci._LABOURDEDUCTIONAMELIST.get(i).getDeductionname());
        //                }
        //                String findPartyDetails_Response =
        //                    sci.httpPost_GetResponse(sci._PARTYSERVICE_URL,
        //                                             sci._FINDPARTIES_PAYLOAD,
        //                                             sci._USERNAME + ":" + sci._PASSWORD);
        //                sci.getPartyDetails_ResponseParser(findPartyDetails_Response);
        //                for (int i = 0; i < sci._PARTYDETAILSLIST.size(); i++) {
        //                    System.out.println("Party Id : " +
        //                                       sci._PARTYDETAILSLIST.get(i).getPartyid() +
        //                                       " | Party Name : " +
        //                                       sci._PARTYDETAILSLIST.get(i).getPartyname() +
        //                                       " | Party Number : " +
        //                                       sci._PARTYDETAILSLIST.get(i).getPartynumber());
        //                }
        //
        //        System.out.println("----------------------------------------------------------------------------------------");
        //        String findProjectDetails_Response =
        //            sci.httpPost_GetResponse(sci._PROJECTSERVICE_URL,
        //                                     sci._FINDPROJECTS_PAYLOAD,
        //                                     sci._USERNAME + ":" + sci._PASSWORD);
        //        //                System.out.println(findProjectDetails_Response);
        //
        //        sci.getProjectDetails_ResponseParser(findProjectDetails_Response);
        //        for (int i = 0; i < sci._PROJECTDETAILSLIST.size(); i++) {
        //            System.out.println("Project Number : " +
        //                               sci._PROJECTDETAILSLIST.get(i).getProjectnumber() +
        //                               " | Project Name : " +
        //                               sci._PROJECTDETAILSLIST.get(i).getProjectname());
        //        }
        //        System.out.println("----------------------------------------------------------------------------------------");

    }


    private String httpPost_GetResponse(String DestinationURL, String Data,
                                        String AithorizationString) {
        URL url;
        String response = "";
        try {
            url = new URL(DestinationURL);

            HttpURLConnection conn;

            conn = (HttpURLConnection)url.openConnection();

            if (conn == null) {
                return null;
            }
            conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setFollowRedirects(true);
            conn.setAllowUserInteraction(false);
            conn.setRequestMethod("POST");

            byte[] authBytes = AithorizationString.getBytes("UTF-8");
            String auth =
                com.sun.org.apache.xml.internal.security.utils.Base64.encode(authBytes);
            conn.setRequestProperty("Authorization", "Basic " + auth);

            OutputStream out = conn.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
            writer.write(Data);
            writer.close();
            out.close();

            InputStream in = conn.getInputStream();
            InputStreamReader iReader = new InputStreamReader(in);
            BufferedReader bReader = new BufferedReader(iReader);

            String line;

            while ((line = bReader.readLine()) != null) {
                response += line;
            }
            iReader.close();
            bReader.close();
            in.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed Exception : " + e);
        } catch (IOException e) {
            System.out.println("IO Exception : " + e);
        }

        return response;
    }
    //************************************Start**of***LabourDeductionNameDetails**************************************************************************************//

    public void getLabourDeductionNameDetails_ResponseParser(String ResponsePayload) {
        _LABOURDEDUCTIONAMELIST.clear();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(ResponsePayload));
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xPath = xFactory.newXPath();
            javax.xml.namespace.NamespaceContext ns =
                new javax.xml.namespace.NamespaceContext() {
                @Override
                public String getNamespaceURI(String prefix) {
                    if ("env".equals(prefix)) {
                        return "http://schemas.xmlsoap.org/soap/envelope/";
                    } else if ("ns0".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/hcm/workStructures/jobs/jobServiceV2/types/";
                    } else if ("ns0".equals(prefix)) {
                        return "http://xmlns.oracle.com/adf/svc/types/";
                    } else if ("ns1".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/hcm/workStructures/jobs/jobServiceV2/";
                    } else if ("ns2".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/hcm/workStructures/jobs/jobServiceV2/types/s";
                    } else if ("ns4".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/hcm/workStructures/jobs/flex/jobCustomerFlex/";
                    } else if ("ns7".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/hcm/workStructures/jobs/flex/jobLegDeveloperFlex/classification/";
                    } else if ("xsi".equals(prefix)) {
                        return "http://www.w3.org/2001/XMLSchema-instance";
                    } else if ("xml".equals(prefix)) {
                        return javax.xml.XMLConstants.XML_NS_URI;
                    }
                    return javax.xml.XMLConstants.NULL_NS_URI;
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    return null;
                }

                @Override
                public Iterator<?> getPrefixes(String namespaceURI) {
                    return null;
                }
            };
            xPath.setNamespaceContext(ns);
            XPathExpression result_element_childs =
                xPath.compile("/env:Envelope/env:Body/ns0:findJobResponse");
            Element findContractResponse_element_child_elements =
                (Element)result_element_childs.evaluate(doc,
                                                        XPathConstants.NODE);
            NodeList result_element =
                findContractResponse_element_child_elements.getElementsByTagName("result");

            Element result_element_child_elements =
                (Element)result_element.item(0);

            if (result_element_child_elements != null) {
                NodeList value_element =
                    result_element_child_elements.getElementsByTagName("Value");
                for (int i = 0; i < value_element.getLength(); i++) {
                    Element value_element_child_elements =
                        (Element)value_element.item(i);
                    //System.out.println("valueof= " +i);
                    String name = "";
                    try {
                        name =
value_element_child_elements.getElementsByTagName("Name").item(0).getTextContent();
                        if (name == "") {
                            name = "No Data Found";
                        }
                    } catch (Exception e) {
                        name = "Not Available";
                    }
                    this._LABOURDEDUCTIONAMELIST.add(new DeductionNamePOJO(name));
                }
            }
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException");
        } catch (SAXException e) {
            System.out.println("SAXException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (XPathExpressionException e) {
            System.out.println("XPathExpressionException");
        }
    }
    //**********************************end*of*LabourDeductionNameDetails**************************************************************************************************8//

    public void findContracts_ResponseParser(String ResponsePayload) {
        _CONTRACTLIST.clear();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(ResponsePayload));
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xPath = xFactory.newXPath();
            javax.xml.namespace.NamespaceContext ns =
                new javax.xml.namespace.NamespaceContext() {

                @Override
                public String getNamespaceURI(String prefix) {
                    if ("env".equals(prefix)) {
                        return "http://schemas.xmlsoap.org/soap/envelope/";
                    } else if ("ns0".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/";
                    } else if ("ns1".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/";
                    } else if ("ns2".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/";
                    } else if ("ns2".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/parties/flex/partyContact/";
                    } else if ("ns3".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/parties/flex/party/";
                    } else if ("ns4".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/flex/contracts/coreAuthoring/lines/";
                    } else if ("ns5".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/billing/contracts/contractPublicService/";
                    } else if ("ns6".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/header/flex/header/";
                    } else if ("ns7".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/billing/contracts/flex/BilllPlanDff/";
                    } else if ("ns8".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/billing/contracts/contractBillingService/";
                    } else if ("xsi".equals(prefix)) {
                        return "http://www.w3.org/2001/XMLSchema-instance";
                    } else if ("xml".equals(prefix)) {
                        return javax.xml.XMLConstants.XML_NS_URI;
                    }
                    return javax.xml.XMLConstants.NULL_NS_URI;
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    return null;
                }

                @Override
                public Iterator<?> getPrefixes(String namespaceURI) {
                    return null;
                }
            };

            xPath.setNamespaceContext(ns);
            XPathExpression result_element_childs =
                xPath.compile("/env:Envelope/env:Body/ns0:findContractResponse");
            Element findContractResponse_element_child_elements =
                (Element)result_element_childs.evaluate(doc,
                                                        XPathConstants.NODE);
            NodeList result_element =
                findContractResponse_element_child_elements.getElementsByTagName("result");

            Element result_element_child_elements =
                (Element)result_element.item(0);

            if (result_element_child_elements != null) {
                NodeList value_element =
                    result_element_child_elements.getElementsByTagName("Value");
                for (int i = 0; i < value_element.getLength(); i++) {
                    Element value_element_child_elements =
                        (Element)value_element.item(i);
                    //                    NodeList ContractLine_element =
                    //                        value_element_child_elements.getElementsByTagName("ContractLine");
                    //                    if (ContractLine_element.getLength() > 0) {
                    //                        for (int j = 0; j < 1; j++) {
                    //                    Element ContractLine_element_child_elements =
                    //                        (Element)value_element.item(i);
                    //                            if ("Item, project".equals(ContractLine_element_child_elements.getElementsByTagName("LineTypeName").item(0).getTextContent())) {
                    String id = "";
                    String major_version = "";
                    String contract_number = "";
                    try {
                        id =
 value_element_child_elements.getElementsByTagName("Id").item(0).getTextContent();
                        if (id == "") {
                            id = "No Data Found";
                        }
                    } catch (Exception e) {
                        id = "Not Available";
                    }
                    try {
                        major_version =
                                value_element_child_elements.getElementsByTagName("MajorVersion").item(0).getTextContent();
                        if (major_version == "") {
                            major_version = "No Data Found";
                        }
                    } catch (Exception e) {
                        major_version = "Not Available";
                    }
                    try {
                        contract_number =
                                value_element_child_elements.getElementsByTagName("ContractNumber").item(0).getTextContent();
                        contract_number =
                                contract_number.substring(0, contract_number.length() -
                                                          1);
                        if (contract_number == "") {
                            contract_number = "No Data Found";
                        }
                    } catch (Exception e) {
                        contract_number = "Not Available";
                    }
                    //                    System.out.println(contract_number + "/" + id + "/" +
                    //                                       major_version);

                    //Logic for adding only highest version contract number in list
                    if (_CONTRACTLIST.size() == 0) {
                        _CONTRACTLIST.add(new ContractIdPOJO(contract_number +
                                                             "/" + id + "/" +
                                                             major_version,
                                                             contract_number));
                    } else {
                        Boolean contractnumbermatchflag = false;
                        for (int index = 0; index < _CONTRACTLIST.size();
                             index++) {
                            String[] temp =
                                _CONTRACTLIST.get(index).getContractid().split("/");
                            String listcontractnumber = temp[0];
                            String listcontractid = temp[1];
                            String listcontractversion = temp[2];
                            if (listcontractnumber.equals(contract_number)) {
                                contractnumbermatchflag = true;
                                if (Integer.parseInt(listcontractversion) <
                                    Integer.parseInt(major_version)) {
                                    _CONTRACTLIST.get(index).setContractid(contract_number +
                                                                           "/" +
                                                                           id +
                                                                           "/" +
                                                                           major_version);
                                }
                            }
                        }
                        if (contractnumbermatchflag == false) {
                            _CONTRACTLIST.add(new ContractIdPOJO(contract_number +
                                                                 "/" + id +
                                                                 "/" +
                                                                 major_version,
                                                                 contract_number));
                        }
                    }
                    //                                break;
                    //                            }
                    //                        }
                    //                    } else {
                    //                    }
                }
            } else {
                System.out.println("Result Element null");
            }
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException");
        } catch (SAXException e) {
            System.out.println("SAXException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (XPathExpressionException e) {
            System.out.println("XPathExpressionException");
        }
    }

    public void getContractHeader_ResponseParser(String ResponsePayload) {
        _CONTRACTHEADERLIST.clear();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(ResponsePayload));
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xPath = xFactory.newXPath();
            javax.xml.namespace.NamespaceContext ns =
                new javax.xml.namespace.NamespaceContext() {

                @Override
                public String getNamespaceURI(String prefix) {
                    if ("env".equals(prefix)) {
                        return "http://schemas.xmlsoap.org/soap/envelope/";
                    } else if ("ns0".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/";
                    } else if ("ns1".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/";
                    } else if ("ns2".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/";
                    } else if ("ns2".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/parties/flex/partyContact/";
                    } else if ("ns3".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/parties/flex/party/";
                    } else if ("ns4".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/billing/contracts/contractPublicService/";
                    } else if ("ns5".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/billing/contracts/contractPublicService/";
                    } else if ("ns6".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/header/flex/header/";
                    } else if ("xsi".equals(prefix)) {
                        return "http://www.w3.org/2001/XMLSchema-instance";
                    } else if ("xml".equals(prefix)) {
                        return javax.xml.XMLConstants.XML_NS_URI;
                    }
                    return javax.xml.XMLConstants.NULL_NS_URI;
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    return null;
                }

                @Override
                public Iterator<?> getPrefixes(String namespaceURI) {
                    return null;
                }

            };

            xPath.setNamespaceContext(ns);
            XPathExpression result_element_childs =
                xPath.compile("/env:Envelope/env:Body/ns0:getContractResponse/ns2:result");

            Element result_element_child_elements =
                (Element)result_element_childs.evaluate(doc,
                                                        XPathConstants.NODE);

            if (result_element_child_elements != null) {
                //                NodeList ContractLine_element =
                //                    result_element_child_elements.getElementsByTagName("ContractLine");
                //                if (ContractLine_element.getLength() > 0) {
                //                    for (int j = 0; j < 1; j++) {
                //                        Element ContractLine_element_child_elements =
                //                            (Element)ContractLine_element.item(0);
                //                        if ("Item, project".equals(ContractLine_element_child_elements.getElementsByTagName("LineTypeName").item(0).getTextContent())) {

                String contract_number = "";
                String contract_type_name = "";
                String start_date = "";
                String end_date = "";
                String currency = "";
                String currency_code = "";
                String description = "";
                String status = "";
                String major_version = "";
                String contractheaderflexfieldva_advancepayment = "";
                String contractheaderflexfieldva_retentionpercent = "";
                String contractheaderflexfieldva_subcontractdeduction = "";
                String contractheaderflexfieldva_projectNo = "";
                String project_name = "";
                String Payment_terms = "";
                String Amount = "";
                String party_name = "";
                String party_number = "";
                String supplier_site = "";
                //Sub-elements of 'result' element
                try {
                    major_version =
                            result_element_child_elements.getElementsByTagName("MajorVersion").item(0).getTextContent();
                    if (major_version == "") {
                        major_version = "No Data Found";
                    }
                } catch (Exception e) {
                    major_version = "Not Available";
                }
                try {
                    contract_type_name =
                            result_element_child_elements.getElementsByTagName("ContractTypeName").item(0).getTextContent();
                    if (contract_type_name == "") {
                        contract_type_name = "No Data Found";
                    }
                } catch (Exception e) {
                    contract_type_name = "Not Available";
                }
                try {
                    contract_number =
                            result_element_child_elements.getElementsByTagName("ContractNumber").item(0).getTextContent();
                    if (contract_number == "") {
                        contract_number = "No Data Found";
                    }
                } catch (Exception e) {
                    contract_number = "Not Available";
                }
                //                String party_id =
                //                    result_element_child_elements.getElementsByTagName("PartyId").item(0).getTextContent();
                try {
                    party_name =
                            result_element_child_elements.getElementsByTagName("PartyName").item(0).getTextContent();
                    if (party_name == "") {
                        party_name = "No Data Found";
                    }
                } catch (Exception e) {
                    party_name = "Not Available";
                }
                try {
                    party_number =
                            result_element_child_elements.getElementsByTagName("PartyNumber").item(0).getTextContent();
                    if (party_number == "") {
                        party_number = "No Data Found";
                    }
                } catch (Exception e) {
                    party_number = "Not Available";
                }
                try {
                    currency_code =
                            result_element_child_elements.getElementsByTagName("CurrencyCode").item(0).getTextContent();
                    if (currency_code == "") {
                        currency_code = "No Data Found";
                    }
                } catch (Exception e) {
                    currency_code = "Not Available";
                }
                try {
                    currency =
                            result_element_child_elements.getElementsByTagName("Currency").item(0).getTextContent();
                    if (currency == "") {
                        currency = "No Data Found";
                    }
                } catch (Exception e) {
                    currency = "Not Available";
                }
                try {
                    start_date =
                            result_element_child_elements.getElementsByTagName("StartDate").item(0).getTextContent();
                    if (start_date == "") {
                        start_date = "No Data Found";
                    }
                } catch (Exception e) {
                    start_date = "Not Available";
                }
                try {
                    end_date =
                            result_element_child_elements.getElementsByTagName("EndDate").item(0).getTextContent();
                    if (end_date == "") {
                        end_date = "No Data Found";
                    }
                } catch (Exception e) {
                    end_date = "Not Available";
                }
                //                String sts_code =
                //                    result_element_child_elements.getElementsByTagName("StsCode").item(0).getTextContent();
                //                String supplier_id =
                //                    result_element_child_elements.getElementsByTagName("SupplierId").item(0).getTextContent();
                //                String primary_party_id =
                //                    result_element_child_elements.getElementsByTagName("PrimaryPartyId").item(0).getTextContent();
                //                String person_id =
                //                    result_element_child_elements.getElementsByTagName("PersonId").item(0).getTextContent();
                //                String state_transition_flow_state =
                //                    result_element_child_elements.getElementsByTagName("StateTransitionFlowState").item(0).getTextContent();
                //                String estimated_amount =
                //                    result_element_child_elements.getElementsByTagName("EstimatedAmount").item(0).getTextContent();
                status =
                        result_element_child_elements.getElementsByTagName("Status").item(0).getTextContent();
                try {
                    supplier_site =
                            result_element_child_elements.getElementsByTagName("SupplierSite").item(0).getTextContent();
                    if (supplier_site == "") {
                        supplier_site = "No Data Found";
                    }
                } catch (Exception e) {
                    supplier_site = "Not Available";
                }
                //                System.out.println("supplier_site : " + supplier_site);

                try {
                    description =
                            result_element_child_elements.getElementsByTagName("Description").item(0).getTextContent();
                    if (description == "") {
                        description = "No Data Found";
                    }
                } catch (Exception e) {
                    description = "Not Available";
                }

                //Sub-elements of 'ContractHeaderFlexfieldVA' element inside 'result' element
                NodeList contractheaderflexfieldva =
                    result_element_child_elements.getElementsByTagName("ContractHeaderFlexfieldVA");
                Element contractheaderflexfieldva_subelements =
                    (Element)contractheaderflexfieldva.item(0);
                //                String contractheaderflexfieldva_id =
                //                    contractheaderflexfieldva_subelements.getElementsByTagName("Id").item(0).getTextContent();
                try {
                    contractheaderflexfieldva_advancepayment =
                            contractheaderflexfieldva_subelements.getElementsByTagName("advancePayment").item(0).getTextContent();
                    if (contractheaderflexfieldva_advancepayment == "") {
                        contractheaderflexfieldva_advancepayment =
                                "No Data Found";
                    }
                } catch (Exception e) {
                    contractheaderflexfieldva_advancepayment = "Not Available";
                }
                try {
                    contractheaderflexfieldva_retentionpercent =
                            contractheaderflexfieldva_subelements.getElementsByTagName("retentionPercent").item(0).getTextContent();
                    if (contractheaderflexfieldva_retentionpercent == "") {
                        contractheaderflexfieldva_retentionpercent =
                                "No Data Found";
                    }
                } catch (Exception e) {
                    contractheaderflexfieldva_retentionpercent =
                            "Not Available";
                }
                try {
                    contractheaderflexfieldva_subcontractdeduction =
                            contractheaderflexfieldva_subelements.getElementsByTagName("Deduction").item(0).getTextContent();
                    if (contractheaderflexfieldva_subcontractdeduction == "") {
                        contractheaderflexfieldva_subcontractdeduction =
                                "No Data Found";
                    }
                } catch (Exception e) {
                    contractheaderflexfieldva_subcontractdeduction =
                            "Not Available";
                }
                try {
                    contractheaderflexfieldva_projectNo =
                            contractheaderflexfieldva_subelements.getElementsByTagName("projectNo").item(0).getTextContent();
                    if (contractheaderflexfieldva_projectNo == "") {
                        contractheaderflexfieldva_projectNo = "No Data Found";
                    }
                } catch (Exception e) {
                    contractheaderflexfieldva_projectNo = "Not Available";
                }

                try {
                    project_name =
                            result_element_child_elements.getElementsByTagName("projectName").item(0).getTextContent();
                    if (project_name == "") {
                        project_name = "No Data Found";
                    }
                } catch (Exception e) {
                    project_name = "Not Available";
                }
                try {
                    Amount =
                            result_element_child_elements.getElementsByTagName("EstimatedAmount").item(0).getTextContent();
                    if (Amount == "") {
                        Amount = "No Data Found";
                    }
                } catch (Exception e) {
                    Amount = "Not Available";
                }


                //Sub-elements of 'ContractParty' element inside 'result' element
                //                            NodeList ContractPartylist =
                //                                result_element_child_elements.getElementsByTagName("ContractParty");
                //                            Element ContractParty =
                //                                (Element)ContractPartylist.item(0);
                //                            String ContractParty_Id =
                //                                ContractParty.getElementsByTagName("Id").item(0).getTextContent();
                //                            String ContractParty_PartyRoleCode =
                //                                ContractParty.getElementsByTagName("PartyRoleCode").item(0).getTextContent();
                //                            String ContractParty_Role =
                //                                ContractParty.getElementsByTagName("Role").item(0).getTextContent();
                //                            String ContractParty_PartyId =
                //                                ContractParty.getElementsByTagName("PartyId").item(0).getTextContent();
                //                            String ContractParty_PartyName =
                //                                ContractParty.getElementsByTagName("PartyName").item(0).getTextContent();

                //Sub-elements of 'ContractPartyContact' element inside 'ContractParty' element inside 'result' element
                //                            NodeList ContractParty_subelements_ContractPartyContact =
                //                                ContractParty.getElementsByTagName("ContractPartyContact");
                //                            Element ContractParty_subelements_ContractPartyContact_subelements =
                //                                (Element)ContractParty_subelements_ContractPartyContact.item(0);
                //                            String ContractParty_ContractPartyContact_Id =
                //                                ContractParty_subelements_ContractPartyContact_subelements.getElementsByTagName("Id").item(0).getTextContent();
                //                            String ContractParty_ContractPartyContact_ContactRoleCode =
                //                                ContractParty_subelements_ContractPartyContact_subelements.getElementsByTagName("ContactRoleCode").item(0).getTextContent();
                //                            String ContractParty_ContractPartyContact_Role =
                //                                ContractParty_subelements_ContractPartyContact_subelements.getElementsByTagName("Role").item(0).getTextContent();
                //                            String ContractParty_ContractPartyContact_ContactId =
                //                                ContractParty_subelements_ContractPartyContact_subelements.getElementsByTagName("ContactId").item(0).getTextContent();
                //                            String ContractParty_ContractPartyContact_AccessLevel =
                //                                ContractParty_subelements_ContractPartyContact_subelements.getElementsByTagName("AccessLevel").item(0).getTextContent();
                //                            String ContractParty_ContractPartyContact_AccessLevelName =
                //                                ContractParty_subelements_ContractPartyContact_subelements.getElementsByTagName("AccessLevelName").item(0).getTextContent();
                //                            String ContractParty_ContractPartyContact_PartyContactName =
                //                                ContractParty_subelements_ContractPartyContact_subelements.getElementsByTagName("PartyContactName").item(0).getTextContent();

                NodeList bill_plan_element =
                    result_element_child_elements.getElementsByTagName("BillPlan");
                if (bill_plan_element.getLength() > 0) {
                    Element bill_plan_element_child_elements =
                        (Element)bill_plan_element.item(0);
                    try {
                        Payment_terms =
                                bill_plan_element_child_elements.getElementsByTagName("PaymentTerms").item(0).getTextContent();
                        if (Payment_terms == "") {
                            Payment_terms = "No Data Found";
                        }
                    } catch (Exception e) {
                        Payment_terms = "Not Available";
                    }
                }

                //                System.out.println("contract_type_name : " +
                //                                   contract_type_name + " | major_version : " +
                //                                   major_version + "Project_no : " +
                //                                   contractheaderflexfieldva_projectNo +
                //                                   "Project_name :" + project_name);

                _CONTRACTHEADERLIST.add(new ContractHeaderPOJO(contract_number,
                                                               contract_type_name,
                                                               start_date,
                                                               end_date,
                                                               currency,
                                                               currency_code,
                                                               description,
                                                               status,
                                                               major_version,
                                                               contractheaderflexfieldva_advancepayment,
                                                               contractheaderflexfieldva_retentionpercent,
                                                               contractheaderflexfieldva_subcontractdeduction,
                                                               contractheaderflexfieldva_projectNo,
                                                               project_name,
                                                               Payment_terms,
                                                               Amount,
                                                               party_name,
                                                               party_number,
                                                               supplier_site));
                //                            break;
                //                        }
                //                    }
                //                } else {
                //                    System.out.println("Contract Lines not present.");
                //                }
            } else {
                System.out.println("Result Element null");
            }
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException");
        } catch (SAXException e) {
            System.out.println("SAXException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (XPathExpressionException e) {
            System.out.println("XPathExpressionException");
        }
    }

    public void getContractLines_ResponseParser(String ResponsePayload) {
        _CONTRACTLINELIST.clear();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(ResponsePayload));
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xPath = xFactory.newXPath();
            javax.xml.namespace.NamespaceContext ns =
                new javax.xml.namespace.NamespaceContext() {

                @Override
                public String getNamespaceURI(String prefix) {
                    if ("env".equals(prefix)) {
                        return "http://schemas.xmlsoap.org/soap/envelope/";
                    } else if ("ns0".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/";
                    } else if ("ns1".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/";
                    } else if ("ns2".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/";
                    } else if ("ns2".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/parties/flex/partyContact/";
                    } else if ("ns3".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/parties/flex/party/";
                    } else if ("ns4".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/billing/contracts/contractPublicService/";
                    } else if ("ns5".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/billing/contracts/contractPublicService/";
                    } else if ("ns6".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/contracts/coreAuthoring/header/flex/header/";
                    } else if ("xsi".equals(prefix)) {
                        return "http://www.w3.org/2001/XMLSchema-instance";
                    } else if ("xml".equals(prefix)) {
                        return javax.xml.XMLConstants.XML_NS_URI;
                    }
                    return javax.xml.XMLConstants.NULL_NS_URI;
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    return null;
                }

                @Override
                public Iterator<?> getPrefixes(String namespaceURI) {
                    return null;
                }

            };

            xPath.setNamespaceContext(ns);
            XPathExpression result_element_childs =
                xPath.compile("/env:Envelope/env:Body/ns0:getContractResponse/ns2:result");

            Element result_element_child_elements =
                (Element)result_element_childs.evaluate(doc,
                                                        XPathConstants.NODE);

            if (result_element_child_elements != null) {
                NodeList ContractLine_element =
                    result_element_child_elements.getElementsByTagName("ContractLine");
                if (ContractLine_element.getLength() > 0) {
                    for (int i = 0; i < ContractLine_element.getLength();
                         i++) {
                        Element ContractLine_element_child_elements =
                            (Element)ContractLine_element.item(i);
                        if ("Sub Contract Item - Buy".equals(ContractLine_element_child_elements.getElementsByTagName("LineTypeName").item(0).getTextContent())) {
                            String ContractNumber = "";
                            String ContractLine_LineNumber = "";
                            String ContractLine_ItemDescription = "";
                            String ContractLine_UnitOfMeasure = "";
                            String ContractLine_ItemQuantity = "";
                            String ContractLine_UnitPrice = "";
                            String ContractLine_LineAmount = "";
                            String ContractLine_Supplier = "";
                            String ContractLine_SupplierSiteName = "";

                            //Sub-element of 'result' element
                            try {
                                ContractNumber =
                                        result_element_child_elements.getElementsByTagName("ContractNumber").item(0).getTextContent();
                                if (ContractNumber == "") {
                                    ContractNumber = "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractNumber = "Not Available";
                            }

                            //Sub-elements of 'ContractLine' element inside 'result' element
                            Element ContractLine_subelements =
                                (Element)ContractLine_element.item(i);
                            try {
                                ContractLine_LineNumber =
                                        ContractLine_subelements.getElementsByTagName("LineNumber").item(0).getTextContent();
                                if (ContractLine_LineNumber == "") {
                                    ContractLine_LineNumber = "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractLine_LineNumber = "Not Available";
                            }


                            //                            String ContractLine_Id =
                            //                                ContractLine_subelements.getElementsByTagName("Id").item(0).getTextContent();
                            //                            String ContractLine_LineTypeName =
                            //                                ContractLine_subelements.getElementsByTagName("LineTypeName").item(0).getTextContent();
                            //                            String ContractLine_StsCode =
                            //                                ContractLine_subelements.getElementsByTagName("StsCode").item(0).getTextContent();
                            //                            String ContractLine_LineStatus =
                            ContractLine_subelements.getElementsByTagName("LineStatus").item(0).getTextContent();
                            try {
                                ContractLine_UnitOfMeasure =
                                        ContractLine_subelements.getElementsByTagName("UnitOfMeasure").item(0).getTextContent();
                                if (ContractLine_UnitOfMeasure == "") {
                                    ContractLine_UnitOfMeasure =
                                            "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractLine_UnitOfMeasure = "Not Available";
                            }
                            try {
                                ContractLine_ItemQuantity =
                                        ContractLine_subelements.getElementsByTagName("ItemQuantity").item(0).getTextContent();
                                if (ContractLine_ItemQuantity == "") {
                                    ContractLine_ItemQuantity =
                                            "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractLine_ItemQuantity = "Not Available";
                            }
                            try {
                                ContractLine_UnitPrice =
                                        ContractLine_subelements.getElementsByTagName("UnitPrice").item(0).getTextContent();
                                if (ContractLine_UnitPrice == "") {
                                    ContractLine_UnitPrice = "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractLine_UnitPrice = "Not Available";
                            }
                            //                            String ContractLine_LineValueAmount =
                            //                                ContractLine_subelements.getElementsByTagName("LineValueAmount").item(0).getTextContent();
                            try {
                                ContractLine_LineAmount =
                                        ContractLine_subelements.getElementsByTagName("LineAmount").item(0).getTextContent();
                                if (ContractLine_LineAmount == "") {
                                    ContractLine_LineAmount = "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractLine_LineAmount = "Not Available";
                            }
                            //                            String ContractLine_Comments =
                            //                                ContractLine_subelements.getElementsByTagName("Comments").item(0).getTextContent();
                            try {
                                ContractLine_Supplier =
                                        ContractLine_subelements.getElementsByTagName("Supplier").item(0).getTextContent();
                                if (ContractLine_Supplier == "") {
                                    ContractLine_Supplier = "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractLine_Supplier = "Not Available";
                            }

                            try {
                                ContractLine_SupplierSiteName =
                                        ContractLine_subelements.getElementsByTagName("SupplierSiteName").item(0).getTextContent();
                                if (ContractLine_SupplierSiteName == "") {
                                    ContractLine_SupplierSiteName =
                                            "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractLine_SupplierSiteName =
                                        "Not Available";
                            }

                            try {
                                ContractLine_ItemDescription =
                                        ContractLine_subelements.getElementsByTagName("ItemDescription").item(0).getTextContent();
                                if (ContractLine_ItemDescription == "") {
                                    ContractLine_ItemDescription =
                                            "No Data Found";
                                }
                            } catch (Exception e) {
                                ContractLine_ItemDescription = "Not Available";
                            }


                            _CONTRACTLINELIST.add(new ContractLinePOJO(ContractNumber,
                                                                       ContractLine_LineNumber,
                                                                       ContractLine_ItemDescription,
                                                                       ContractLine_UnitOfMeasure,
                                                                       ContractLine_ItemQuantity,
                                                                       ContractLine_UnitPrice,
                                                                       ContractLine_LineAmount,
                                                                       ContractLine_Supplier,
                                                                       ContractLine_SupplierSiteName));
                        }
                    }
                } else {
                    System.out.println("Contract Lines not present.");
                }
            } else {
                System.out.println("Result Element null");
            }
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException");
        } catch (SAXException e) {
            System.out.println("SAXException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (XPathExpressionException e) {
            System.out.println("XPathExpressionException");
        }
    }

    public void getProjectDetails_ResponseParser(String ResponsePayload) {
        _PROJECTDETAILSLIST.clear();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(ResponsePayload));
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xPath = xFactory.newXPath();
            javax.xml.namespace.NamespaceContext ns =
                new javax.xml.namespace.NamespaceContext() {

                @Override
                public String getNamespaceURI(String prefix) {
                    if ("env".equals(prefix)) {
                        return "http://schemas.xmlsoap.org/soap/envelope/";
                    } else if ("ns0".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/foundation/projectDefinition/publicService/maintainProjectV2/types/";
                    } else if ("ns1".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/foundation/projectDefinition/publicService/maintainProjectV2/";
                    } else if ("ns2".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/foundation/projectDefinition/flex/ProjectDff/";
                    } else if ("ns3".equals(prefix)) {
                        return "http://xmlns.oracle.com/apps/projects/foundation/projectDefinition/publicService/maintainProjectV2/types/";
                    } else if ("xsi".equals(prefix)) {
                        return "http://www.w3.org/2001/XMLSchema-instance";
                    } else if ("xml".equals(prefix)) {
                        return javax.xml.XMLConstants.XML_NS_URI;
                    }
                    return javax.xml.XMLConstants.NULL_NS_URI;
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    return null;
                }

                @Override
                public Iterator<?> getPrefixes(String namespaceURI) {
                    return null;
                }
            };

            xPath.setNamespaceContext(ns);
            XPathExpression result_element_childs =
                xPath.compile("/env:Envelope/env:Body/ns0:findProjectResponse");

            Element findProjectResponse_element_child_elements =
                (Element)result_element_childs.evaluate(doc,
                                                        XPathConstants.NODE);

            NodeList result_element =
                findProjectResponse_element_child_elements.getElementsByTagName("result");

            Element result_element_child_elements =
                (Element)result_element.item(0);

            if (result_element_child_elements != null) {
                NodeList value_element =
                    result_element_child_elements.getElementsByTagName("Value");
                for (int i = 0; i < value_element.getLength(); i++) {
                    Element value_element_child_elements =
                        (Element)value_element.item(i);
                    String projectnumber = "";
                    String projectname = "";
                    try {
                        projectnumber =
                                value_element_child_elements.getElementsByTagName("ProjectNumber").item(0).getTextContent();
                        if (projectnumber == "") {
                            projectnumber = "No Data Found";
                        }
                    } catch (Exception e) {
                        projectnumber = "Not Available";
                    }
                    try {
                        projectname =
                                value_element_child_elements.getElementsByTagName("ProjectName").item(0).getTextContent();
                        if (projectname == "") {
                            projectname = "No Data Found";
                        }
                    } catch (Exception e) {
                        projectname = "Not Available";
                    }
                    _PROJECTDETAILSLIST.add(new ProjectDetailsPOJO(projectnumber,
                                                                   projectname));
                }
            }
        } catch (XPathExpressionException xpee) {
            xpee.printStackTrace();
        } catch (DOMException dome) {
            dome.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException saxe) {
            saxe.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
    }

    //    public List<> getNonLaborResource() {
    //
    //        try {
    //            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    //            DocumentBuilder db = dbf.newDocumentBuilder();
    //            InputSource is = new InputSource();
    //            is.setCharacterStream(new StringReader(ResponsePayload));
    //
    //            Document doc = db.parse(is);
    //            NodeList nodes = doc.getElementsByTagName("G_1");
    //            System.out.println("**********");
    //            System.out.println("Length: " + nodes.getLength());
    //        } catch (IOException ioe) {
    //            ioe.printStackTrace();
    //        } catch (SAXException saxe) {
    //            saxe.printStackTrace();
    //        } catch (ParserConfigurationException pce) {
    //            pce.printStackTrace();
    //        }
    //    }

    public List<ContractIdPOJO> getContractNumbers() {
        this.importCertificates();
        String response = "";
        try {
            response =
                    httpPost_GetResponse(_CONTRACTSERVICE_URL, _FINDCONTRACTS_PAYLOAD,
                                         _USERNAME + ":" + _PASSWORD);
        } catch (Exception e) {
            System.out.println("Exception in getting contract header response");
        }
        //        System.out.println(response);
        findContracts_ResponseParser(response);
        return _CONTRACTLIST;
    }

    public List<ContractHeaderPOJO> getContractHeader(String ContractId,
                                                      String Version) {
        this.importCertificates();
        String getContractHeader_Payload =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <typ:getContract>\n" +
            "         <typ:id>" + ContractId + "</typ:id>\n" +
            "         <typ:majorVersion>" + Version + "</typ:majorVersion>\n" +
            "      </typ:getContract>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";
        String response = "";
        try {
            response =
                    httpPost_GetResponse(_CONTRACTSERVICE_URL, getContractHeader_Payload,
                                         _USERNAME + ":" + _PASSWORD);
        } catch (Exception e) {
            System.out.println("Exception in getting contract header response");
        }
        if (response != "") {
            //Parse the response
            getContractHeader_ResponseParser(response);
        }
        return _CONTRACTHEADERLIST;
    }

    public List<ContractLinePOJO> getContractLines(String ContractId,
                                                   String Version) {
        this.importCertificates();
        String getContractLine_Payload =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/contracts/coreAuthoring/contractService/types/\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <typ:getContract>\n" +
            "         <typ:id>" + ContractId + "</typ:id>\n" +
            "         <typ:majorVersion>" + Version + "</typ:majorVersion>\n" +
            "      </typ:getContract>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";
        String response = "";
        try {
            response =
                    httpPost_GetResponse(_CONTRACTSERVICE_URL, getContractLine_Payload,
                                         _USERNAME + ":" + _PASSWORD);
        } catch (Exception e) {
            System.out.println("Exception in getting contract header response");
        }
        if (response != "") {
            getContractLines_ResponseParser(response);
        }
        return _CONTRACTLINELIST;
    }

    public List<ProjectDetailsPOJO> getProjectDetails() {
        String response = "";

        try {
            response =
                    httpPost_GetResponse(_PROJECTSERVICE_URL, _FINDPROJECTS_PAYLOAD,
                                         _USERNAME + ":" + _PASSWORD);
        } catch (Exception e) {
            System.out.println("Exception in getting project service response");
        }
        if (response != "") {
            //            System.out.println("Response : " + response);
            getProjectDetails_ResponseParser(response);
        }
        return _PROJECTDETAILSLIST;
    }

    public List<DeductionNamePOJO> getLabourDeductionNameDetails() {
        String response = "";
        try {
            response =
                    httpPost_GetResponse(_HRJOBSERVICE_URL, _FINDHRJOBS_PAYLOAD,
                                         _USERNAME + ":" + _PASSWORD);
        } catch (Exception e) {
            System.out.println("Exception in getting project service response");
        }
        if (response != "") {
            //            System.out.println(response);
            getLabourDeductionNameDetails_ResponseParser(response);
        }
        return _LABOURDEDUCTIONAMELIST;
    }

    public List<NonLaborResourcesPOJO> getNonLaborResources() {

        NonLaborResourcesFacade nonLaborResourcesFacade =
            new NonLaborResourcesFacade();
        _NONLABORESOURCELIST = nonLaborResourcesFacade.getNonLaborResources();

        return _NONLABORESOURCELIST;
    }
}

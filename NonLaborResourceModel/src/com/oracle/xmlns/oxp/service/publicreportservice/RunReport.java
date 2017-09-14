
package com.oracle.xmlns.oxp.service.publicreportservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportRequest" type="{http://xmlns.oracle.com/oxp/service/PublicReportService}ReportRequest"/>
 *         &lt;element name="appParams" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reportRequest",
    "appParams"
})
@XmlRootElement(name = "runReport")
public class RunReport {

    @XmlElement(required = true)
    protected ReportRequest reportRequest;
    @XmlElement(required = true)
    protected String appParams;

    /**
     * Gets the value of the reportRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ReportRequest }
     *     
     */
    public ReportRequest getReportRequest() {
        return reportRequest;
    }

    /**
     * Sets the value of the reportRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportRequest }
     *     
     */
    public void setReportRequest(ReportRequest value) {
        this.reportRequest = value;
    }

    /**
     * Gets the value of the appParams property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppParams() {
        return appParams;
    }

    /**
     * Sets the value of the appParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppParams(String value) {
        this.appParams = value;
    }

}

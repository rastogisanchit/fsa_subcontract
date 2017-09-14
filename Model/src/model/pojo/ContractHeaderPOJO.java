package model.pojo;

public class ContractHeaderPOJO {

    private String contractnumber;
    private String contracttype;
    private String startdate;
    private String enddate;
    private String currency;
    private String currencycode;
    private String description;
    private String status;
    private String version;
    private String advancepercent;
    private String retentionpercent;
    private String deduction;
    private String projectnumber;
    private String projectname;
    private String paymenterms;
    private String amount;
    private String partyname;
    private String partynumber;
    private String suppliersite;

    public ContractHeaderPOJO() {
        super();
    }

    public ContractHeaderPOJO(String contractnumber, String contracttype,
                              String startdate, String enddate,
                              String currency, String currencycode,
                              String description, String status,
                              String version, String advancepercent,
                              String retentionpercent, String deduction,
                              String projectnumber, String projectname,
                              String paymenterms, String amount,
                              String partyname, String partynumber,
                              String suppliersite) {
        this.contractnumber = contractnumber;
        this.contracttype = contracttype;
        this.startdate = startdate;
        this.enddate = enddate;
        this.currency = currency;
        this.currencycode = currencycode;
        this.description = description;
        this.status = status;
        this.version = version;
        this.advancepercent = advancepercent;
        this.retentionpercent = retentionpercent;
        this.deduction = deduction;
        this.projectnumber = projectnumber;
        this.projectname = projectname;
        this.paymenterms = paymenterms;
        this.amount = amount;
        this.partyname = partyname;
        this.partynumber = partynumber;
        this.suppliersite = suppliersite;
    }

    //    public ContractHeaderPOJO(String contractnumber, String contracttype,
    //                              String startdate, String enddate,
    //                              String currency, String currencycode,
    //                              String description, String status,
    //                              String version, String advancepercent,
    //                              String retentionpercent, String deduction,
    //                              String projectnumber, String projectname,
    //                              String paymenterms, String amount,String partyname,
    //                              String partynumber , String supplier) {
    //        super();
    //        this.contractnumber = contractnumber;
    //        this.contracttype = contracttype;
    //        this.startdate = startdate;
    //        this.enddate = enddate;
    //        this.currency = currency;
    //        this.currencycode = currencycode;
    //        this.description = description;
    //        this.status = status;
    //        this.version = version;
    //        this.advancepercent = advancepercent;
    //        this.retentionpercent = retentionpercent;
    //        this.deduction = deduction;
    //        this.projectnumber = projectnumber;
    //        this.projectname = projectname;
    //        this.paymenterms = paymenterms;
    //        this.amount = amount;
    //        this.partyname = partyname;
    //        this.partynumber = partynumber;
    //        this.supplier= supplier;
    //    }


    public void setContractnumber(String contractnumber) {
        this.contractnumber = contractnumber;
    }

    public String getContractnumber() {
        return contractnumber;
    }

    public void setContracttype(String contracttype) {
        this.contracttype = contracttype;
    }

    public String getContracttype() {
        return contracttype;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setAdvancepercent(String advancepercent) {
        this.advancepercent = advancepercent;
    }

    public String getAdvancepercent() {
        return advancepercent;
    }

    public void setRetentionpercent(String retentionpercent) {
        this.retentionpercent = retentionpercent;
    }

    public String getRetentionpercent() {
        return retentionpercent;
    }

    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    public String getDeduction() {
        return deduction;
    }

    public void setProjectnumber(String projectnumber) {
        this.projectnumber = projectnumber;
    }

    public String getProjectnumber() {
        return projectnumber;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setPaymenterms(String paymenterms) {
        this.paymenterms = paymenterms;
    }

    public String getPaymenterms() {
        return paymenterms;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartynumber(String partynumber) {
        this.partynumber = partynumber;
    }

    public String getPartynumber() {
        return partynumber;
    }

    public void setSuppliersite(String suppliersite) {
        this.suppliersite = suppliersite;
    }

    public String getSuppliersite() {
        return suppliersite;
    }
}

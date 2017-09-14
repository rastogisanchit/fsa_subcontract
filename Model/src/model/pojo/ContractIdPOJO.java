package model.pojo;

public class ContractIdPOJO {

    private String contractid;
    private String contractnumber;

    public ContractIdPOJO() {
        super();
    }

    public ContractIdPOJO(String contractid, String contractnumber) {
        super();
        this.contractid = contractid;
        this.contractnumber = contractnumber;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractnumber(String contractnumber) {
        this.contractnumber = contractnumber;
    }

    public String getContractnumber() {
        return contractnumber;
    }
}

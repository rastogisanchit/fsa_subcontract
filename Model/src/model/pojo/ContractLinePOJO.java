package model.pojo;
public class ContractLinePOJO {
    
    private String contractnumber;
    private String boqnumber;
    private String boqdescription;
    private String unitofmeasure;
    private String quantity;
    private String rate;
    private String amount;
    private String Supplier;
    private String SupplierSiteName;
    
    public ContractLinePOJO() {
        super();
    }


    public ContractLinePOJO(String contractnumber, String boqnumber,
                            String boqdescription, String unitofmeasure,
                            String quantity, String rate, String amount,
                            String Supplier, String SupplierSiteName) {
        super();
        this.contractnumber = contractnumber;
        this.boqnumber = boqnumber;
        this.boqdescription = boqdescription;
        this.unitofmeasure = unitofmeasure;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
        this.Supplier = Supplier;
        this.SupplierSiteName = SupplierSiteName;
    }


    public void setContractnumber(String contractnumber) {
        this.contractnumber = contractnumber;
    }

    public String getContractnumber() {
        return contractnumber;
    }

    public void setBoqnumber(String boqnumber) {
        this.boqnumber = boqnumber;
    }

    public String getBoqnumber() {
        return boqnumber;
    }

    public void setBoqdescription(String boqdescription) {
        this.boqdescription = boqdescription;
    }

    public String getBoqdescription() {
        return boqdescription;
    }

    public void setUnitofmeasure(String unitofmeasure) {
        this.unitofmeasure = unitofmeasure;
    }

    public String getUnitofmeasure() {
        return unitofmeasure;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplierSiteName(String SupplierSiteName) {
        this.SupplierSiteName = SupplierSiteName;
    }

    public String getSupplierSiteName() {
        return SupplierSiteName;
    }

    
}

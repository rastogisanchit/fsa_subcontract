package pojo;

public class DeductionDetailsPOJO {
    private String deductiontype;
    private String deductionname;
    private String unitrate;
    public DeductionDetailsPOJO() {
        super();
    }

    public DeductionDetailsPOJO(String deductiontype, String deductionname,
                                String unitrate) {
        super();
        this.deductiontype = deductiontype;
        this.deductionname = deductionname;
        this.unitrate = unitrate;
    }

    public void setDeductiontype(String deductiontype) {
        this.deductiontype = deductiontype;
    }

    public String getDeductiontype() {
        return deductiontype;
    }

    public void setDeductionname(String deductionname) {
        this.deductionname = deductionname;
    }

    public String getDeductionname() {
        return deductionname;
    }

    public void setUnitrate(String unitrate) {
        this.unitrate = unitrate;
    }

    public String getUnitrate() {
        return unitrate;
    }
}

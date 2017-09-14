package pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class deductionsetupPOJO {
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public deductionsetupPOJO() {
        super();
    }
    
    private String subcontract_num;
    private String contract_type;
    private String version;
    private String deduction_type;
    private String deduction_name;
    private String UOM;
    private String Unit_Rate;

    public deductionsetupPOJO(String subcontract_num, String contract_type,
                              String version, String deduction_type,
                              String deduction_name, String UOM,
                              String Unit_Rate) {
        super();
        this.subcontract_num = subcontract_num;
        this.contract_type = contract_type;
        this.version = version;
        this.deduction_type = deduction_type;
        this.deduction_name = deduction_name;
        this.UOM = UOM;
        this.Unit_Rate = Unit_Rate;
    }

    public void setSubcontract_num(String subcontract_num) {
        String oldSubcontract_num = this.subcontract_num;
        this.subcontract_num = subcontract_num;
        propertyChangeSupport.firePropertyChange("subcontract_num", oldSubcontract_num, subcontract_num);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getSubcontract_num() {
        return subcontract_num;
    }

    public void setContract_type(String contract_type) {
        String oldContract_type = this.contract_type;
        this.contract_type = contract_type;
        propertyChangeSupport.firePropertyChange("contract_type", oldContract_type, contract_type);
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setVersion(String version) {
        String oldVersion = this.version;
        this.version = version;
        propertyChangeSupport.firePropertyChange("version", oldVersion, version);
    }

    public String getVersion() {
        return version;
    }

    public void setDeduction_type(String deduction_type) {
        String oldDeduction_type = this.deduction_type;
        this.deduction_type = deduction_type;
        propertyChangeSupport.firePropertyChange("deduction_type", oldDeduction_type, deduction_type);
    }

    public String getDeduction_type() {
        return deduction_type;
    }

    public void setDeduction_name(String deduction_name) {
        String oldDeduction_name = this.deduction_name;
        this.deduction_name = deduction_name;
        propertyChangeSupport.firePropertyChange("deduction_name", oldDeduction_name, deduction_name);
    }

    public String getDeduction_name() {
        return deduction_name;
    }

    public void setUOM(String UOM) {
        String oldUOM = this.UOM;
        this.UOM = UOM;
        propertyChangeSupport.firePropertyChange("UOM", oldUOM, UOM);
    }

    public String getUOM() {
        return UOM;
    }

    public void setUnit_Rate(String Unit_Rate) {
        String oldUnit_Rate = this.Unit_Rate;
        this.Unit_Rate = Unit_Rate;
        propertyChangeSupport.firePropertyChange("Unit_Rate", oldUnit_Rate, Unit_Rate);
    }

    public String getUnit_Rate() {
        return Unit_Rate;
    }
}

package pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class deductiontxnPOJO {
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public deductiontxnPOJO() {
        super();
    }
    private String subcontract_num;
    private String deduction_type;
    private String deduction_name;
    private String unit_rate;
    private String quantity;
    private String deduction_amount;
    private String debit_memo;
    private String total_deduction_amount;

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

    public void setUnit_rate(String unit_rate) {
        String oldUnit_rate = this.unit_rate;
        this.unit_rate = unit_rate;
        propertyChangeSupport.firePropertyChange("unit_rate", oldUnit_rate, unit_rate);
    }

    public String getUnit_rate() {
        return unit_rate;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        propertyChangeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setDeduction_amount(String deduction_amount) {
        String oldDeduction_amount = this.deduction_amount;
        this.deduction_amount = deduction_amount;
        propertyChangeSupport.firePropertyChange("deduction_amount", oldDeduction_amount, deduction_amount);
    }

    public String getDeduction_amount() {
        return deduction_amount;
    }

    public void setDebit_memo(String debit_memo) {
        String oldDebit_memo = this.debit_memo;
        this.debit_memo = debit_memo;
        propertyChangeSupport.firePropertyChange("debit_memo", oldDebit_memo, debit_memo);
    }

    public String getDebit_memo() {
        return debit_memo;
    }

    public void setTotal_deduction_amount(String total_deduction_amount) {
        String oldTotal_deduction_amount = this.total_deduction_amount;
        this.total_deduction_amount = total_deduction_amount;
        propertyChangeSupport.firePropertyChange("total_deduction_amount", oldTotal_deduction_amount, total_deduction_amount);
    }

    public String getTotal_deduction_amount() {
        return total_deduction_amount;
    }
}

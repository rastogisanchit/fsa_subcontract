package pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.faces.model.SelectItem;

public class deductiontxnPOJO {
    private transient PropertyChangeSupport propertyChangeSupport =
        new PropertyChangeSupport(this);

    public deductiontxnPOJO() {
        super();
    }
    private String subcontract_number;
    private String deduction_type;
    private String deduction_name;
    private String unit_rate;
    private String quantity;
    private String deduction_amount;
    private String month;
    private String debit_memo;
    private String period;
    private String total_deduction_amount;
    private String debit_memo_status;
    private String submitted_date_time;

    public deductiontxnPOJO(String subcontract_number, String deduction_type,
                            String deduction_name, String unit_rate,
                            String quantity, String deduction_amount,
                            String month, String debit_memo, String period,
                            String total_deduction_amount,
                            String debit_memo_status,
                            String submitted_date_time) {
        super();
        this.subcontract_number = subcontract_number;
        this.deduction_type = deduction_type;
        this.deduction_name = deduction_name;
        this.unit_rate = unit_rate;
        this.quantity = quantity;
        this.deduction_amount = deduction_amount;
        this.month = month;
        this.debit_memo = debit_memo;
        this.period = period;
        this.total_deduction_amount = total_deduction_amount;
        this.debit_memo_status = debit_memo_status;
        this.submitted_date_time = submitted_date_time;
    }

    public void setSubcontract_number(String subcontract_number) {
        this.subcontract_number = subcontract_number;
    }

    public String getSubcontract_number() {
        return subcontract_number;
    }
   
    public void setDeduction_name(String deduction_name) {
        String oldDeduction_name = this.deduction_name;
        this.deduction_name = deduction_name;
        propertyChangeSupport.firePropertyChange("deduction_name",
                                                 oldDeduction_name,
                                                 deduction_name);
    }

    public String getDeduction_name() {
        return deduction_name;
    }

    public void setUnit_rate(String unit_rate) {
        String oldUnit_rate = this.unit_rate;
        this.unit_rate = unit_rate;
        propertyChangeSupport.firePropertyChange("unit_rate", oldUnit_rate,
                                                 unit_rate);
    }

    public String getUnit_rate() {
        return unit_rate;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        propertyChangeSupport.firePropertyChange("quantity", oldQuantity,
                                                 quantity);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setDeduction_amount(String deduction_amount) {
        String oldDeduction_amount = this.deduction_amount;
        this.deduction_amount = deduction_amount;
        propertyChangeSupport.firePropertyChange("deduction_amount",
                                                 oldDeduction_amount,
                                                 deduction_amount);
    }

    public String getDeduction_amount() {
        return deduction_amount;
    }

    public void setDebit_memo(String debit_memo) {
        String oldDebit_memo = this.debit_memo;
        this.debit_memo = debit_memo;
        propertyChangeSupport.firePropertyChange("debit_memo", oldDebit_memo,
                                                 debit_memo);
    }

    public String getDebit_memo() {
        return debit_memo;
    }

    public void setTotal_deduction_amount(String total_deduction_amount) {
        String oldTotal_deduction_amount = this.total_deduction_amount;
        this.total_deduction_amount = total_deduction_amount;
        propertyChangeSupport.firePropertyChange("total_deduction_amount",
                                                 oldTotal_deduction_amount,
                                                 total_deduction_amount);
    }

    public String getTotal_deduction_amount() {
        return total_deduction_amount;
    }

    public void setDeduction_type(String deduction_type) {
        this.deduction_type = deduction_type;
    }

    public String getDeduction_type() {
        return deduction_type;
    }

    public void setDebit_memo_status(String debit_memo_status) {
        this.debit_memo_status = debit_memo_status;
    }

    public String getDebit_memo_status() {
        return debit_memo_status;
    }

    public void setSubmitted_date_time(String submitted_date_time) {
        this.submitted_date_time = submitted_date_time;
    }

    public String getSubmitted_date_time() {
        return submitted_date_time;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }
}

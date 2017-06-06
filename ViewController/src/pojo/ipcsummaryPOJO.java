package pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ipcsummaryPOJO {
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ipcsummaryPOJO() {
        super();
    }
    
    private String subcontract_num;
    private String cumulative_work_done;
    private String current_work_done;
    private String labor_deduction;
    private String equipment_deduction;
    private String performance_bond;
    private String other_panelties;
    private String other_deductions;
    private String total;
    private String recoupment;
    private String retention;
    private String total_current_contract_deductions;
    private String total_deductions;
    private String current_ipc_tobe_paid;

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

    public void setCumulative_work_done(String cumulative_work_done) {
        String oldCumulative_work_done = this.cumulative_work_done;
        this.cumulative_work_done = cumulative_work_done;
        propertyChangeSupport.firePropertyChange("cumulative_work_done", oldCumulative_work_done, cumulative_work_done);
    }

    public String getCumulative_work_done() {
        return cumulative_work_done;
    }

    public void setCurrent_work_done(String current_work_done) {
        String oldCurrent_work_done = this.current_work_done;
        this.current_work_done = current_work_done;
        propertyChangeSupport.firePropertyChange("current_work_done", oldCurrent_work_done, current_work_done);
    }

    public String getCurrent_work_done() {
        return current_work_done;
    }

    public void setLabor_deduction(String labor_deduction) {
        String oldLabor_deduction = this.labor_deduction;
        this.labor_deduction = labor_deduction;
        propertyChangeSupport.firePropertyChange("labor_deduction", oldLabor_deduction, labor_deduction);
    }

    public String getLabor_deduction() {
        return labor_deduction;
    }

    public void setEquipment_deduction(String equipment_deduction) {
        String oldEquipment_deduction = this.equipment_deduction;
        this.equipment_deduction = equipment_deduction;
        propertyChangeSupport.firePropertyChange("equipment_deduction", oldEquipment_deduction, equipment_deduction);
    }

    public String getEquipment_deduction() {
        return equipment_deduction;
    }

    public void setPerformance_bond(String performance_bond) {
        String oldPerformance_bond = this.performance_bond;
        this.performance_bond = performance_bond;
        propertyChangeSupport.firePropertyChange("performance_bond", oldPerformance_bond, performance_bond);
    }

    public String getPerformance_bond() {
        return performance_bond;
    }

    public void setOther_panelties(String other_panelties) {
        String oldOther_panelties = this.other_panelties;
        this.other_panelties = other_panelties;
        propertyChangeSupport.firePropertyChange("other_panelties", oldOther_panelties, other_panelties);
    }

    public String getOther_panelties() {
        return other_panelties;
    }

    public void setOther_deductions(String other_deductions) {
        String oldOther_deductions = this.other_deductions;
        this.other_deductions = other_deductions;
        propertyChangeSupport.firePropertyChange("other_deductions", oldOther_deductions, other_deductions);
    }

    public String getOther_deductions() {
        return other_deductions;
    }

    public void setTotal_deductions(String total_deductions) {
        String oldTotal_deductions = this.total_deductions;
        this.total_deductions = total_deductions;
        propertyChangeSupport.firePropertyChange("total_deductions", oldTotal_deductions, total_deductions);
    }

    public String getTotal_deductions() {
        return total_deductions;
    }

    public void setRecoupment(String recoupment) {
        String oldRecoupment = this.recoupment;
        this.recoupment = recoupment;
        propertyChangeSupport.firePropertyChange("recoupment", oldRecoupment, recoupment);
    }

    public String getRecoupment() {
        return recoupment;
    }

    public void setRetention(String retention) {
        String oldRetention = this.retention;
        this.retention = retention;
        propertyChangeSupport.firePropertyChange("retention", oldRetention, retention);
    }

    public String getRetention() {
        return retention;
    }

    public void setTotal_current_contract_deductions(String total_current_contract_deductions) {
        String oldTotal_current_contract_deductions = this.total_current_contract_deductions;
        this.total_current_contract_deductions = total_current_contract_deductions;
        propertyChangeSupport.firePropertyChange("total_current_contract_deductions", oldTotal_current_contract_deductions, total_current_contract_deductions);
    }

    public String getTotal_current_contract_deductions() {
        return total_current_contract_deductions;
    }


    public void setCurrent_ipc_tobe_paid(String current_ipc_tobe_paid) {
        String oldCurrent_ipc_tobe_paid = this.current_ipc_tobe_paid;
        this.current_ipc_tobe_paid = current_ipc_tobe_paid;
        propertyChangeSupport.firePropertyChange("current_ipc_tobe_paid", oldCurrent_ipc_tobe_paid, current_ipc_tobe_paid);
    }

    public String getCurrent_ipc_tobe_paid() {
        return current_ipc_tobe_paid;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        PropertyChangeSupport oldPropertyChangeSupport = this.propertyChangeSupport;
        this.propertyChangeSupport = propertyChangeSupport;
        propertyChangeSupport.firePropertyChange("propertyChangeSupport", oldPropertyChangeSupport, propertyChangeSupport);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public void setTotal(String total) {
        String oldTotal = this.total;
        this.total = total;
        propertyChangeSupport.firePropertyChange("total", oldTotal, total);
    }

    public String getTotal() {
        return total;
    }
}

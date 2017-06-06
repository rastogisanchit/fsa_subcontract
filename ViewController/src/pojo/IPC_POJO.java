package pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class IPC_POJO {
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public IPC_POJO() {
        super();
    }
    private String subcontract_num;
    private String contract_type;
    private String nature_of_work;
    private String project_num;
    private String project_name;
    private String contract_value;
    private String contract_version;
    private String PO;
    private String subcontractor_num;
    private String subcontractor_name;
    private String subcontractor_location;
    private String prepayment_inv_num;
    private String prepayment_inv_amount;
    private String prepayment_inv_status;
    private String ipc_num;
    private String ipc_description;
    private String ipc_status;
    private String ipc_date;
    private String ipc_period;
    private String work_conf_receipt;
    private String std_inv_num;
    private String std_inv_status;
    private String std_inv_accounted;
    private String retention_per;
    private String prepayment_per;
    private String BOQ;
    private String UOM;
    private String QTY;
    private String RATE;
    private String TOTAL;
    private String previous_qty;
    private String current_qty;
    private String total_qty;
    private String previous_amount;
    private String current_amount;
    private String total_amount;

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

    public void setNature_of_work(String nature_of_work) {
        String oldNature_of_work = this.nature_of_work;
        this.nature_of_work = nature_of_work;
        propertyChangeSupport.firePropertyChange("nature_of_work", oldNature_of_work, nature_of_work);
    }

    public String getNature_of_work() {
        return nature_of_work;
    }

    public void setProject_num(String project_num) {
        String oldProject_num = this.project_num;
        this.project_num = project_num;
        propertyChangeSupport.firePropertyChange("project_num", oldProject_num, project_num);
    }

    public String getProject_num() {
        return project_num;
    }

    public void setProject_name(String project_name) {
        String oldProject_name = this.project_name;
        this.project_name = project_name;
        propertyChangeSupport.firePropertyChange("project_name", oldProject_name, project_name);
    }

    public String getProject_name() {
        return project_name;
    }

    public void setContract_value(String contract_value) {
        String oldContract_value = this.contract_value;
        this.contract_value = contract_value;
        propertyChangeSupport.firePropertyChange("contract_value", oldContract_value, contract_value);
    }

    public String getContract_value() {
        return contract_value;
    }

    public void setContract_version(String contract_version) {
        String oldContract_version = this.contract_version;
        this.contract_version = contract_version;
        propertyChangeSupport.firePropertyChange("contract_version", oldContract_version, contract_version);
    }

    public String getContract_version() {
        return contract_version;
    }

    public void setPO(String PO) {
        String oldPO = this.PO;
        this.PO = PO;
        propertyChangeSupport.firePropertyChange("PO", oldPO, PO);
    }

    public String getPO() {
        return PO;
    }

    public void setSubcontractor_num(String subcontractor_num) {
        String oldSubcontractor_num = this.subcontractor_num;
        this.subcontractor_num = subcontractor_num;
        propertyChangeSupport.firePropertyChange("subcontractor_num", oldSubcontractor_num, subcontractor_num);
    }

    public String getSubcontractor_num() {
        return subcontractor_num;
    }

    public void setSubcontractor_name(String subcontractor_name) {
        String oldSubcontractor_name = this.subcontractor_name;
        this.subcontractor_name = subcontractor_name;
        propertyChangeSupport.firePropertyChange("subcontractor_name", oldSubcontractor_name, subcontractor_name);
    }

    public String getSubcontractor_name() {
        return subcontractor_name;
    }

    public void setSubcontractor_location(String subcontractor_location) {
        String oldSubcontractor_location = this.subcontractor_location;
        this.subcontractor_location = subcontractor_location;
        propertyChangeSupport.firePropertyChange("subcontractor_location", oldSubcontractor_location, subcontractor_location);
    }

    public String getSubcontractor_location() {
        return subcontractor_location;
    }

    public void setPrepayment_inv_num(String prepayment_inv_num) {
        String oldPrepayment_inv_num = this.prepayment_inv_num;
        this.prepayment_inv_num = prepayment_inv_num;
        propertyChangeSupport.firePropertyChange("prepayment_inv_num", oldPrepayment_inv_num, prepayment_inv_num);
    }

    public String getPrepayment_inv_num() {
        return prepayment_inv_num;
    }

    public void setPrepayment_inv_amount(String prepayment_inv_amount) {
        String oldPrepayment_inv_amount = this.prepayment_inv_amount;
        this.prepayment_inv_amount = prepayment_inv_amount;
        propertyChangeSupport.firePropertyChange("prepayment_inv_amount", oldPrepayment_inv_amount, prepayment_inv_amount);
    }

    public String getPrepayment_inv_amount() {
        return prepayment_inv_amount;
    }

    public void setPrepayment_inv_status(String prepayment_inv_status) {
        String oldPrepayment_inv_status = this.prepayment_inv_status;
        this.prepayment_inv_status = prepayment_inv_status;
        propertyChangeSupport.firePropertyChange("prepayment_inv_status", oldPrepayment_inv_status, prepayment_inv_status);
    }

    public String getPrepayment_inv_status() {
        return prepayment_inv_status;
    }

    public void setIpc_num(String ipc_num) {
        String oldIpc_num = this.ipc_num;
        this.ipc_num = ipc_num;
        propertyChangeSupport.firePropertyChange("ipc_num", oldIpc_num, ipc_num);
    }

    public String getIpc_num() {
        return ipc_num;
    }

    public void setIpc_description(String ipc_description) {
        String oldIpc_description = this.ipc_description;
        this.ipc_description = ipc_description;
        propertyChangeSupport.firePropertyChange("ipc_description", oldIpc_description, ipc_description);
    }

    public String getIpc_description() {
        return ipc_description;
    }

    public void setIpc_status(String ipc_status) {
        String oldIpc_status = this.ipc_status;
        this.ipc_status = ipc_status;
        propertyChangeSupport.firePropertyChange("ipc_status", oldIpc_status, ipc_status);
    }

    public String getIpc_status() {
        return ipc_status;
    }

    public void setIpc_date(String ipc_date) {
        String oldIpc_date = this.ipc_date;
        this.ipc_date = ipc_date;
        propertyChangeSupport.firePropertyChange("ipc_date", oldIpc_date, ipc_date);
    }

    public String getIpc_date() {
        return ipc_date;
    }

    public void setIpc_period(String ipc_period) {
        String oldIpc_period = this.ipc_period;
        this.ipc_period = ipc_period;
        propertyChangeSupport.firePropertyChange("ipc_period", oldIpc_period, ipc_period);
    }

    public String getIpc_period() {
        return ipc_period;
    }

    public void setWork_conf_receipt(String work_conf_receipt) {
        String oldWork_conf_receipt = this.work_conf_receipt;
        this.work_conf_receipt = work_conf_receipt;
        propertyChangeSupport.firePropertyChange("work_conf_receipt", oldWork_conf_receipt, work_conf_receipt);
    }

    public String getWork_conf_receipt() {
        return work_conf_receipt;
    }

    public void setStd_inv_num(String std_inv_num) {
        String oldStd_inv_num = this.std_inv_num;
        this.std_inv_num = std_inv_num;
        propertyChangeSupport.firePropertyChange("std_inv_num", oldStd_inv_num, std_inv_num);
    }

    public String getStd_inv_num() {
        return std_inv_num;
    }

    public void setStd_inv_status(String std_inv_status) {
        String oldStd_inv_status = this.std_inv_status;
        this.std_inv_status = std_inv_status;
        propertyChangeSupport.firePropertyChange("std_inv_status", oldStd_inv_status, std_inv_status);
    }

    public String getStd_inv_status() {
        return std_inv_status;
    }

    public void setStd_inv_accounted(String std_inv_accounted) {
        String oldStd_inv_accounted = this.std_inv_accounted;
        this.std_inv_accounted = std_inv_accounted;
        propertyChangeSupport.firePropertyChange("std_inv_accounted", oldStd_inv_accounted, std_inv_accounted);
    }

    public String getStd_inv_accounted() {
        return std_inv_accounted;
    }

    public void setRetention_per(String retention_per) {
        String oldRetention_per = this.retention_per;
        this.retention_per = retention_per;
        propertyChangeSupport.firePropertyChange("retention_per", oldRetention_per, retention_per);
    }

    public String getRetention_per() {
        return retention_per;
    }

    public void setPrepayment_per(String prepayment_per) {
        String oldPrepayment_per = this.prepayment_per;
        this.prepayment_per = prepayment_per;
        propertyChangeSupport.firePropertyChange("prepayment_per", oldPrepayment_per, prepayment_per);
    }

    public String getPrepayment_per() {
        return prepayment_per;
    }

    public void setBOQ(String BOQ) {
        String oldBOQ = this.BOQ;
        this.BOQ = BOQ;
        propertyChangeSupport.firePropertyChange("BOQ", oldBOQ, BOQ);
    }

    public String getBOQ() {
        return BOQ;
    }

    public void setUOM(String UOM) {
        String oldUOM = this.UOM;
        this.UOM = UOM;
        propertyChangeSupport.firePropertyChange("UOM", oldUOM, UOM);
    }

    public String getUOM() {
        return UOM;
    }

    public void setQTY(String QTY) {
        String oldQTY = this.QTY;
        this.QTY = QTY;
        propertyChangeSupport.firePropertyChange("QTY", oldQTY, QTY);
    }

    public String getQTY() {
        return QTY;
    }

    public void setRATE(String RATE) {
        String oldRATE = this.RATE;
        this.RATE = RATE;
        propertyChangeSupport.firePropertyChange("RATE", oldRATE, RATE);
    }

    public String getRATE() {
        return RATE;
    }

    public void setTOTAL(String TOTAL) {
        String oldTOTAL = this.TOTAL;
        this.TOTAL = TOTAL;
        propertyChangeSupport.firePropertyChange("TOTAL", oldTOTAL, TOTAL);
    }

    public String getTOTAL() {
        return TOTAL;
    }

    public void setPrevious_qty(String previous_qty) {
        String oldPrevious_qty = this.previous_qty;
        this.previous_qty = previous_qty;
        propertyChangeSupport.firePropertyChange("previous_qty", oldPrevious_qty, previous_qty);
    }

    public String getPrevious_qty() {
        return previous_qty;
    }

    public void setCurrent_qty(String current_qty) {
        String oldCurrent_qty = this.current_qty;
        this.current_qty = current_qty;
        propertyChangeSupport.firePropertyChange("current_qty", oldCurrent_qty, current_qty);
    }

    public String getCurrent_qty() {
        return current_qty;
    }

    public void setTotal_qty(String total_qty) {
        String oldTotal_qty = this.total_qty;
        this.total_qty = total_qty;
        propertyChangeSupport.firePropertyChange("total_qty", oldTotal_qty, total_qty);
    }

    public String getTotal_qty() {
        return total_qty;
    }

    public void setPrevious_amount(String previous_amount) {
        String oldPrevious_amount = this.previous_amount;
        this.previous_amount = previous_amount;
        propertyChangeSupport.firePropertyChange("previous_amount", oldPrevious_amount, previous_amount);
    }

    public String getPrevious_amount() {
        return previous_amount;
    }

    public void setCurrent_amount(String current_amount) {
        String oldCurrent_amount = this.current_amount;
        this.current_amount = current_amount;
        propertyChangeSupport.firePropertyChange("current_amount", oldCurrent_amount, current_amount);
    }

    public String getCurrent_amount() {
        return current_amount;
    }

    public void setTotal_amount(String total_amount) {
        String oldTotal_amount = this.total_amount;
        this.total_amount = total_amount;
        propertyChangeSupport.firePropertyChange("total_amount", oldTotal_amount, total_amount);
    }

    public String getTotal_amount() {
        return total_amount;
    }
}

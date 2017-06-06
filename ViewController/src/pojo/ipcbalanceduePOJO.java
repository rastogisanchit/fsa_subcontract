package pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ipcbalanceduePOJO {
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ipcbalanceduePOJO() {
        super();
    }
    
    private String IPC;
    private String AP_Invoice;
    private String amount;
    private String type;
    private String status;

    public void setIPC(String IPC) {
        String oldIPC = this.IPC;
        this.IPC = IPC;
        propertyChangeSupport.firePropertyChange("IPC", oldIPC, IPC);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getIPC() {
        return IPC;
    }

    public void setAP_Invoice(String AP_Invoice) {
        String oldAP_Invoice = this.AP_Invoice;
        this.AP_Invoice = AP_Invoice;
        propertyChangeSupport.firePropertyChange("AP_Invoice", oldAP_Invoice, AP_Invoice);
    }

    public String getAP_Invoice() {
        return AP_Invoice;
    }

    public void setAmount(String amount) {
        String oldAmount = this.amount;
        this.amount = amount;
        propertyChangeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public String getAmount() {
        return amount;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        propertyChangeSupport.firePropertyChange("type", oldType, type);
    }

    public String getType() {
        return type;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getStatus() {
        return status;
    }
}

package pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ipcreportPOJO {
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ipcreportPOJO() {
        super();
    }
    private String contract;
    private String contract_type;
    private String project;
    private String project_name;
    private String item;
    private String description;
    private String unit;
    private String estimated_quantity;
    private String unit_rate;
    private String total_estimate_price;

    public void setContract(String contract) {
        String oldContract = this.contract;
        this.contract = contract;
        propertyChangeSupport.firePropertyChange("contract", oldContract, contract);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getContract() {
        return contract;
    }

    public void setContract_type(String contract_type) {
        String oldContract_type = this.contract_type;
        this.contract_type = contract_type;
        propertyChangeSupport.firePropertyChange("contract_type", oldContract_type, contract_type);
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setProject(String project) {
        String oldProject = this.project;
        this.project = project;
        propertyChangeSupport.firePropertyChange("project", oldProject, project);
    }

    public String getProject() {
        return project;
    }

    public void setProject_name(String project_name) {
        String oldProject_name = this.project_name;
        this.project_name = project_name;
        propertyChangeSupport.firePropertyChange("project_name", oldProject_name, project_name);
    }

    public String getProject_name() {
        return project_name;
    }

    public void setItem(String item) {
        String oldItem = this.item;
        this.item = item;
        propertyChangeSupport.firePropertyChange("item", oldItem, item);
    }

    public String getItem() {
        return item;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        propertyChangeSupport.firePropertyChange("description", oldDescription, description);
    }

    public String getDescription() {
        return description;
    }

    public void setUnit(String unit) {
        String oldUnit = this.unit;
        this.unit = unit;
        propertyChangeSupport.firePropertyChange("unit", oldUnit, unit);
    }

    public String getUnit() {
        return unit;
    }

    public void setEstimated_quantity(String estimated_quantity) {
        String oldEstimated_quantity = this.estimated_quantity;
        this.estimated_quantity = estimated_quantity;
        propertyChangeSupport.firePropertyChange("estimated_quantity", oldEstimated_quantity, estimated_quantity);
    }

    public String getEstimated_quantity() {
        return estimated_quantity;
    }

    public void setUnit_rate(String unit_rate) {
        String oldUnit_rate = this.unit_rate;
        this.unit_rate = unit_rate;
        propertyChangeSupport.firePropertyChange("unit_rate", oldUnit_rate, unit_rate);
    }

    public String getUnit_rate() {
        return unit_rate;
    }

    public void setTotal_estimate_price(String total_estimate_price) {
        String oldTotal_estimate_price = this.total_estimate_price;
        this.total_estimate_price = total_estimate_price;
        propertyChangeSupport.firePropertyChange("total_estimate_price", oldTotal_estimate_price, total_estimate_price);
    }

    public String getTotal_estimate_price() {
        return total_estimate_price;
    }
}

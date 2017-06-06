package pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PO_POJO {
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public PO_POJO() {
        super();
    }
    
    private String type;
    private String supplier;
    private String supplier_site;
    private String payment_terms;
    private String line_num;
    private String line_type;
    private String item;
    private String description;
    private String category;
    private String UOM;
    private String quantity;
    private String rate;
    private String price;
    private String destination_type;
    private String need_by_date;
    private String project;
    private String task;
    private String expenditure_type;
    private String expenditure_item_date;
    private String expenditure_organization;
    private String subcontract_num;

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        propertyChangeSupport.firePropertyChange("type", oldType, type);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getType() {
        return type;
    }

    public void setSupplier(String supplier) {
        String oldSupplier = this.supplier;
        this.supplier = supplier;
        propertyChangeSupport.firePropertyChange("supplier", oldSupplier, supplier);
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier_site(String supplier_site) {
        String oldSupplier_site = this.supplier_site;
        this.supplier_site = supplier_site;
        propertyChangeSupport.firePropertyChange("supplier_site", oldSupplier_site, supplier_site);
    }

    public String getSupplier_site() {
        return supplier_site;
    }

    public void setPayment_terms(String payment_terms) {
        String oldPayment_terms = this.payment_terms;
        this.payment_terms = payment_terms;
        propertyChangeSupport.firePropertyChange("payment_terms", oldPayment_terms, payment_terms);
    }

    public String getPayment_terms() {
        return payment_terms;
    }

    public void setLine_num(String line_num) {
        String oldLine_num = this.line_num;
        this.line_num = line_num;
        propertyChangeSupport.firePropertyChange("line_num", oldLine_num, line_num);
    }

    public String getLine_num() {
        return line_num;
    }

    public void setLine_type(String line_type) {
        String oldLine_type = this.line_type;
        this.line_type = line_type;
        propertyChangeSupport.firePropertyChange("line_type", oldLine_type, line_type);
    }

    public String getLine_type() {
        return line_type;
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

    public void setCategory(String category) {
        String oldCategory = this.category;
        this.category = category;
        propertyChangeSupport.firePropertyChange("category", oldCategory, category);
    }

    public String getCategory() {
        return category;
    }

    public void setUOM(String UOM) {
        String oldUOM = this.UOM;
        this.UOM = UOM;
        propertyChangeSupport.firePropertyChange("UOM", oldUOM, UOM);
    }

    public String getUOM() {
        return UOM;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        propertyChangeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setRate(String rate) {
        String oldRate = this.rate;
        this.rate = rate;
        propertyChangeSupport.firePropertyChange("rate", oldRate, rate);
    }

    public String getRate() {
        return rate;
    }

    public void setPrice(String price) {
        String oldPrice = this.price;
        this.price = price;
        propertyChangeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getPrice() {
        return price;
    }

    public void setDestination_type(String destination_type) {
        String oldDestination_type = this.destination_type;
        this.destination_type = destination_type;
        propertyChangeSupport.firePropertyChange("destination_type", oldDestination_type, destination_type);
    }

    public String getDestination_type() {
        return destination_type;
    }

    public void setNeed_by_date(String need_by_date) {
        String oldNeed_by_date = this.need_by_date;
        this.need_by_date = need_by_date;
        propertyChangeSupport.firePropertyChange("need_by_date", oldNeed_by_date, need_by_date);
    }

    public String getNeed_by_date() {
        return need_by_date;
    }

    public void setProject(String project) {
        String oldProject = this.project;
        this.project = project;
        propertyChangeSupport.firePropertyChange("project", oldProject, project);
    }

    public String getProject() {
        return project;
    }

    public void setTask(String task) {
        String oldTask = this.task;
        this.task = task;
        propertyChangeSupport.firePropertyChange("task", oldTask, task);
    }

    public String getTask() {
        return task;
    }

    public void setExpenditure_type(String expenditure_type) {
        String oldExpenditure_type = this.expenditure_type;
        this.expenditure_type = expenditure_type;
        propertyChangeSupport.firePropertyChange("expenditure_type", oldExpenditure_type, expenditure_type);
    }

    public String getExpenditure_type() {
        return expenditure_type;
    }

    public void setExpenditure_item_date(String expenditure_item_date) {
        String oldExpenditure_item_date = this.expenditure_item_date;
        this.expenditure_item_date = expenditure_item_date;
        propertyChangeSupport.firePropertyChange("expenditure_item_date", oldExpenditure_item_date, expenditure_item_date);
    }

    public String getExpenditure_item_date() {
        return expenditure_item_date;
    }

    public void setExpenditure_organization(String expenditure_organization) {
        String oldExpenditure_organization = this.expenditure_organization;
        this.expenditure_organization = expenditure_organization;
        propertyChangeSupport.firePropertyChange("expenditure_organization", oldExpenditure_organization, expenditure_organization);
    }

    public String getExpenditure_organization() {
        return expenditure_organization;
    }

    public void setSubcontract_num(String subcontract_num) {
        String oldSubcontract_num = this.subcontract_num;
        this.subcontract_num = subcontract_num;
        propertyChangeSupport.firePropertyChange("subcontract_num", oldSubcontract_num, subcontract_num);
    }

    public String getSubcontract_num() {
        return subcontract_num;
    }
}

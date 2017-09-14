package beans;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import model.AM.AppModuleImpl;

import oracle.jbo.RowSetIterator;
import oracle.jbo.server.ViewObjectImpl;

public class PO {
    private String contractype="";
    private String supplier="";
    private String suppliersite="";
    private String payementterms="";
    
    public PO() {
    }

    public void test(ActionEvent actionEvent) {
        // Add event code here...
    }

    public AppModuleImpl getAppModule() {
        AppModuleImpl am = (AppModuleImpl)resolvElDC("AppModuleDataControl");
        return am;
    }

    public Object resolvElDC(String data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data." + data +
                                            ".dataProvider}", Object.class);
        return valueExp.getValue(elContext);
    }

    public void contractNumberValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        ViewObjectImpl ch_vo = getAppModule().getContractHeaderVO1();
        ViewObjectImpl cl_vo = getAppModule().getContractLineVO1();
        
        if (valueChangeEvent.getNewValue() == null) {
            ch_vo.setNamedWhereClauseParam("ch_parameterbind", 0);
            ch_vo.executeQuery();
            
            cl_vo.setNamedWhereClauseParam("cl_parameterbind", 0);
            cl_vo.executeQuery();
            
        } else if (valueChangeEvent.getNewValue() != null) 
        {           
            String id_version = valueChangeEvent.getNewValue().toString();
            String[] temp = id_version.split("/");
            String contractnum = temp[0];
            String contractId = temp[1];
            String majorversion = temp[2];
            ch_vo.setNamedWhereClauseParam("ch_parameterbind", 1);
            ch_vo.ensureVariableManager().setVariableValue("ch_cntrctidbind",
                                                           contractId);
            ch_vo.ensureVariableManager().setVariableValue("ch_cntrctversionbind",
                                                           majorversion);
            ch_vo.executeQuery();
            
            RowSetIterator ch_vo_iter = ch_vo.createRowSetIterator(null);
            contractype =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("ContractType"));
            
            payementterms=String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("PaymentTerms"));
            ch_vo_iter.closeRowSetIterator();
            
            
            cl_vo.setNamedWhereClauseParam("cl_parameterbind", 1);
            cl_vo.ensureVariableManager().setVariableValue("cl_cntrctidbind",
                                                           contractId);
            cl_vo.ensureVariableManager().setVariableValue("cl_cntrctversionbind",
                                                           majorversion);
            cl_vo.executeQuery();
            RowSetIterator cl_vo_iter = cl_vo.createRowSetIterator(null);
            supplier= String.valueOf(cl_vo_iter.getRowAtRangeIndex(0).getAttribute("Supplier"));
            suppliersite=String.valueOf(cl_vo_iter.getRowAtRangeIndex(0).getAttribute("SupplierSiteName"));
            cl_vo_iter.closeRowSetIterator();
        }
    }

    public void setContractype(String contractype) {
        this.contractype = contractype;
    }

    public String getContractype() {
        return contractype;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSuppliersite(String suppliersite) {
        this.suppliersite = suppliersite;
    }

    public String getSuppliersite() {
        return suppliersite;
    }

    public void setPayementterms(String payementterms) {
        this.payementterms = payementterms;
    }

    public String getPayementterms() {
        return payementterms;
    }
}

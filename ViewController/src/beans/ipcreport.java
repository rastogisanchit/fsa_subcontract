package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.AM.AppModuleImpl;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.server.ViewObjectImpl;

import pojo.deductionsetupPOJO;
import pojo.ipcreportPOJO;

public class ipcreport {
    private RichInputText itembind;
    private RichInputText descriptionbind;
    private RichInputText unitbind;
    private RichInputText estimatesquanitytbind;
    private RichInputText unitratebind;
    private RichInputText totalestimatedpricebind;
    
    
    private Integer _currentSelectedIndex;
    List<ipcreportPOJO> ipcreportlist =  new ArrayList<ipcreportPOJO>();
    public ipcreport() {
    }
    
    public void addNewRow(ActionEvent actionEvent) {
        ipcreportlist.add(new ipcreportPOJO("", "", "","", "", ""));
    }
    
    public void onRowRemoval(ActionEvent actionEvent) {
        Integer currentIndex = getCurrentSelectedIndex();
        ipcreportPOJO dT0 = ipcreportlist.remove(currentIndex.intValue());
        if (dT0 == null) {
            System.out.println("Element with index " + currentIndex +
                               " not found in list!");
        }
        UIComponent ui = (UIComponent)actionEvent.getSource();
        AdfFacesContext.getCurrentInstance().addPartialTarget(ui.getParent().getParent().getParent());

    }
    
    public void onSubmit(ActionEvent actionEvent) {
        Iterator i = ipcreportlist.iterator();
        while (i.hasNext()) {
            ipcreportPOJO val = (ipcreportPOJO)i.next();
            System.out.println("Item-" + val.getItem());
            System.out.println("Description-" + val.getDescription());
            System.out.println("Unit-" + val.getUnit());
            System.out.println("Estimated Qunatity-" + val.getEstimated_quantity());
            System.out.println("Unit Rate-" + val.getUnit_rate());
            System.out.println("Total Estimated Price-" + val.getTotal_estimate_price());
        }
    }
    public void setItembind(RichInputText itembind) {
        this.itembind = itembind;
    }

    public RichInputText getItembind() {
        return itembind;
    }

    public void setDescriptionbind(RichInputText descriptionbind) {
        this.descriptionbind = descriptionbind;
    }

    public RichInputText getDescriptionbind() {
        return descriptionbind;
    }

    public void setUnitbind(RichInputText unitbind) {
        this.unitbind = unitbind;
    }

    public RichInputText getUnitbind() {
        return unitbind;
    }

    public void setEstimatesquanitytbind(RichInputText estimatesquanitytbind) {
        this.estimatesquanitytbind = estimatesquanitytbind;
    }

    public RichInputText getEstimatesquanitytbind() {
        return estimatesquanitytbind;
    }

    public void setUnitratebind(RichInputText unitratebind) {
        this.unitratebind = unitratebind;
    }

    public RichInputText getUnitratebind() {
        return unitratebind;
    }

    public void setTotalestimatedpricebind(RichInputText totalestimatedpricebind) {
        this.totalestimatedpricebind = totalestimatedpricebind;
    }

    public RichInputText getTotalestimatedpricebind() {
        return totalestimatedpricebind;
    }

    public void setCurrentSelectedIndex(Integer _currentSelectedIndex) {
        this._currentSelectedIndex = _currentSelectedIndex;
    }

    public Integer getCurrentSelectedIndex() {
        return _currentSelectedIndex;
    }

    public void setIpcreportlist(List<ipcreportPOJO> ipcreportlist) {
        this.ipcreportlist = ipcreportlist;
    }

    public List<ipcreportPOJO> getIpcreportlist() {
        return ipcreportlist;
    }


    public void contractNumberIpcValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        System.out.println("Contract Number: " +
                           valueChangeEvent.getNewValue());
        ViewObjectImpl vo = getAppModule().getContractHeaderVO1();
        if (valueChangeEvent.getNewValue() != null) {
            ViewCriteria vc = vo.getViewCriteria("ContractHeaderVO_VC");
            vo.applyViewCriteria(vc);
            vo.setNamedWhereClauseParam("parameterbind", "1");
            vo.setNamedWhereClauseParam("cntrctnumbind",
                                        valueChangeEvent.getNewValue());
            vo.executeQuery();
        } else {
            vo.clearViewCriterias();
            vo.setNamedWhereClauseParam("parameterbind", "0");
            vo.executeQuery();
        }
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
}

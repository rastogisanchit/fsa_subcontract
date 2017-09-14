package beans;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import model.AM.AppModuleImpl;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.ViewCriteria;

public class ipc {
    private String contractnum = "";
    private String contractype = "";
    private String version = "";
    private String amountbind = "";
    private String subcontractornumbind = "";
    private String subcontractornamebind = "";
    private String subcontractorlocationbind = "";
    private String retentionbind = "";
    private String prepaymentbind = "";
    private String _PROJECTNUMBERVALUEBIND = "";
    private String _PROJECTNAMEVALUEBIND = "";


    public ipc() {
    }

    public void test(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void setPROJECTNUMBERVALUEBIND(String _PROJECTNUMBERVALUEBIND) {
        this._PROJECTNUMBERVALUEBIND = _PROJECTNUMBERVALUEBIND;
    }

    public String getPROJECTNUMBERVALUEBIND() {
        return _PROJECTNUMBERVALUEBIND;
    }

    public void setPROJECTNAMEVALUEBIND(String _PROJECTNAMEVALUEBIND) {
        this._PROJECTNAMEVALUEBIND = _PROJECTNAMEVALUEBIND;
    }

    public String getPROJECTNAMEVALUEBIND() {
        return _PROJECTNAMEVALUEBIND;
    }

    public void setContractype(String contractype) {
        this.contractype = contractype;
    }

    public String getContractype() {
        return contractype;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setAmountbind(String amountbind) {
        this.amountbind = amountbind;
    }

    public String getAmountbind() {
        return amountbind;
    }

    public void setSubcontractornumbind(String subcontractornumbind) {
        this.subcontractornumbind = subcontractornumbind;
    }

    public String getSubcontractornumbind() {
        return subcontractornumbind;
    }

    public void setSubcontractornamebind(String subcontractornamebind) {
        this.subcontractornamebind = subcontractornamebind;
    }

    public String getSubcontractornamebind() {
        return subcontractornamebind;
    }

    public void setSubcontractorlocationbind(String subcontractorlocationbind) {
        this.subcontractorlocationbind = subcontractorlocationbind;
    }

    public String getSubcontractorlocationbind() {
        return subcontractorlocationbind;
    }

    public void setRetentionbind(String retentionbind) {
        this.retentionbind = retentionbind;
    }

    public String getRetentionbind() {
        return retentionbind;
    }

    public void setPrepaymentbind(String prepaymentbind) {
        this.prepaymentbind = prepaymentbind;
    }

    public String getPrepaymentbind() {
        return prepaymentbind;
    }
    
    public void contractNumberValueChangeEvent(ValueChangeEvent valueChangeEvent) {

        ViewObjectImpl ch_vo = getAppModule().getContractHeaderVO1();
        ViewObjectImpl cl_vo = getAppModule().getContractLineVO1();
        ViewObjectImpl pd_vo = getAppModule().getProjectDetailsPVO1();

        if (valueChangeEvent.getNewValue() == null) {
            _PROJECTNUMBERVALUEBIND = "";
            _PROJECTNAMEVALUEBIND = "";

            ch_vo.setNamedWhereClauseParam("ch_parameterbind", 0);
            ch_vo.executeQuery();

            cl_vo.setNamedWhereClauseParam("cl_parameterbind", 0);
            cl_vo.executeQuery();

            pd_vo.clearViewCriterias();
            pd_vo.setNamedWhereClauseParam("pd_parameterbind", 0);
            pd_vo.executeQuery();

        } else if (valueChangeEvent.getNewValue() != null) {

            String id_version = valueChangeEvent.getNewValue().toString();
            String[] temp = id_version.split("/");
            contractnum = temp[0];
            String contractId = temp[1];
            String majorversion = temp[2];
            ch_vo.setNamedWhereClauseParam("ch_parameterbind", 1);
            ch_vo.ensureVariableManager().setVariableValue("ch_cntrctidbind",
                                                           contractId);
            ch_vo.ensureVariableManager().setVariableValue("ch_cntrctversionbind",
                                                           majorversion);
            ch_vo.executeQuery();

            cl_vo.setNamedWhereClauseParam("cl_parameterbind", 1);
            cl_vo.ensureVariableManager().setVariableValue("cl_cntrctidbind",
                                                           contractId);
            cl_vo.ensureVariableManager().setVariableValue("cl_cntrctversionbind",
                                                           majorversion);
            cl_vo.executeQuery();

            RowSetIterator ch_vo_iter = ch_vo.createRowSetIterator(null);
            contractype =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("ContractType"));
            version =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("Version"));
            amountbind =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("Amount"));
            subcontractornumbind =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("PartyNumber"));
            subcontractornamebind =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("PartyName"));
            subcontractorlocationbind =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("SupplierSite"));
            retentionbind =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("RetentionPercent"));
            prepaymentbind =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("AdvancePercent"));
            _PROJECTNUMBERVALUEBIND =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("ProjectNumber"));
            _PROJECTNAMEVALUEBIND =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("ProjectName"));
            System.out.println("1 _PROJECTNUMBERVALUEBIND : " +
                               _PROJECTNUMBERVALUEBIND +
                               " | _PROJECTNAMEVALUEBIND : " +
                               _PROJECTNAMEVALUEBIND);

            //            while (iter.hasNext()) {
            //                Row r = iter.next();
            //                contractype = (String)r.getAttribute("ContractType");
            //                version = (String)r.getAttribute("Version");
            //            }
            ch_vo_iter.closeRowSetIterator();

            if (_PROJECTNUMBERVALUEBIND == "Not Available" ||
                _PROJECTNUMBERVALUEBIND == "No Data Found") {
                _PROJECTNAMEVALUEBIND = _PROJECTNUMBERVALUEBIND;
                System.out.println("2 _PROJECTNUMBERVALUEBIND : " +
                                   _PROJECTNUMBERVALUEBIND +
                                   " | _PROJECTNAMEVALUEBIND : " +
                                   _PROJECTNAMEVALUEBIND);
            } else {
                ViewCriteria vc =
                    pd_vo.getViewCriteria("ProjectDetailsPVO_VC");
                pd_vo.applyViewCriteria(vc);
                pd_vo.setNamedWhereClauseParam("pd_parameterbind", 1);
                pd_vo.ensureVariableManager().setVariableValue("pd_projectnumberbind",
                                                               _PROJECTNUMBERVALUEBIND);
                pd_vo.executeQuery();

                System.out.println("3 _PROJECTNUMBERVALUEBIND : " +
                                   _PROJECTNUMBERVALUEBIND +
                                   " | _PROJECTNAMEVALUEBIND : " +
                                   _PROJECTNAMEVALUEBIND);

                RowSetIterator pd_vo_iter = pd_vo.createRowSetIterator(null);
                _PROJECTNAMEVALUEBIND =
                        pd_vo_iter.getRowAtRangeIndex(0).getAttribute("ProjectName").toString();
                pd_vo_iter.closeRowSetIterator();
            }

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

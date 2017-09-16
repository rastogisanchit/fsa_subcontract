package beans;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import model.AM.AppModuleImpl;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pojo.deductionsetupPOJO;

import restclient.restclient;


public class deductionsetup {

    private List<deductionsetupPOJO> labourdeductionlist;
    private List<deductionsetupPOJO> equipmentdeductionlist;
    private List<deductionsetupPOJO> qualitydeductionlist;
    private List<deductionsetupPOJO> otherdeductionlist;
    private List<deductionsetupPOJO> newrecordlist;
    private List<deductionsetupPOJO> updaterecordlist;
    private List<deductionsetupPOJO> deleterecordlist;
    private List<SelectItem> deductionnamelist;
    private List<SelectItem> lddeductionnamelist;
    private List<SelectItem> eddeductionnamelist;
    private List<SelectItem> _PERIOD_MONTHLIST;
    private List<SelectItem> _PERIOD_YEARLIST;

    private Integer _currentSelectedIndexld;
    private Integer _currentSelectedIndexed;
    private Integer _currentSelectedIndexqd;
    private Integer _currentSelectedIndexod;
    private int CURRENTSELECTEDINDEX;

    private String contractnum = "";
    private String contractype = "";
    private String version = "";
    private String PERIOD;
    private String deductionenable = "";

    private RichInputText deductionnamebind;
    private RichInputText uombind;
    private RichInputText ratebind;
    private RichInputText enabledbind;

    private RichShowDetailItem ldtabbind;
    private RichShowDetailItem edtabbind;
    private RichShowDetailItem qdtabbind;
    private RichShowDetailItem odtabbind;

    private RichCommandButton addrowbtnld;
    private RichCommandButton addrowbtnEQ;
    private RichCommandButton addrowbtnQD;
    private RichCommandButton addrowbtnOD;

    private RichCommandButton cancelbtn;
    private RichCommandButton cancelbtnED;
    private RichCommandButton cancelbtnQD;
    private RichCommandButton cancelbtnOD;

    private RichSelectOneChoice lddeductionname;
    private RichInputText deductionenabledbind;
    private RichPopup deductionpopupbind;

    private RichSelectOneChoice MONTHBINDVAR;
    private RichSelectOneChoice YEARBINDVAR;

    private RichPopup ADDLABOURDEDUCTIONPOPUPBINDVAR;
    private RichPopup ADDEQUIPMENTDEDUCTIONPOPUPBINDVAR;
    private RichPopup ADDQUALITYDEDUCTIONPOPUPBINDVAR;
    private RichPopup ADDOTHERDEDUCTIONPOPUPBINDVAR;

    private RichTable LABORDEDUCTIONTABLEBIND;
    private RichInputText lduomnbind;
    private RichInputText ldratebind;
    private RichPopup DEDUCTIONEXISTPOPUPBIND;

    private RichSelectOneChoice eddeductionname;
    private RichInputText eduombind;
    private RichInputText edratebind;
    private RichTable EQUIPMENTDEDUCTIONTABLEBIND;
    private RichInputText qddeductionname;
    private RichInputText qduombind;
    private RichInputText qdratebind;
    private RichInputText oddeductionname;
    private RichInputText oduombind;
    private RichInputText odratebind;
    private RichTable QUALITYDEDUCTIONTABLEBIND;
    private RichTable OTHERDEDUCTIONTABLEBIND;
    private RichSelectOneChoice CONTRACTNUMBERLOVBINDVAR;
    private RichPopup ADDNEWROWPROMPTPOPUPBINDVAR;
    private RichPopup SUBMITPROMPTPOPUPBINDVAR;
    private RichPopup DATASAVEDPOPUPBINDVAR;
    private RichInputText inputcontracttype;
    private RichInputText inputversion;

    public deductionsetup() {
        labourdeductionlist = new ArrayList<deductionsetupPOJO>();
        equipmentdeductionlist = new ArrayList<deductionsetupPOJO>();
        qualitydeductionlist = new ArrayList<deductionsetupPOJO>();
        otherdeductionlist = new ArrayList<deductionsetupPOJO>();

        deductionnamelist = new ArrayList<SelectItem>();
        lddeductionnamelist = new ArrayList<SelectItem>();
        eddeductionnamelist = new ArrayList<SelectItem>();

        newrecordlist = new ArrayList<deductionsetupPOJO>();
        updaterecordlist = new ArrayList<deductionsetupPOJO>();
        deleterecordlist = new ArrayList<deductionsetupPOJO>();
    }

    public void setDeductionnamebind(RichInputText deductionnamebind) {
        this.deductionnamebind = deductionnamebind;
    }

    public RichInputText getDeductionnamebind() {
        return deductionnamebind;
    }

    public void setUombind(RichInputText uombind) {
        this.uombind = uombind;
    }

    public RichInputText getUombind() {
        return uombind;
    }

    public void setRatebind(RichInputText ratebind) {
        this.ratebind = ratebind;
    }

    public RichInputText getRatebind() {
        return ratebind;
    }

    public void setLdtabbind(RichShowDetailItem ldtabbind) {
        this.ldtabbind = ldtabbind;
    }

    public RichShowDetailItem getLdtabbind() {
        return ldtabbind;
    }

    public void setLabourdeductionlist(List<deductionsetupPOJO> labourdeductionlist) {
        this.labourdeductionlist = labourdeductionlist;
    }

    public List<deductionsetupPOJO> getLabourdeductionlist() {
        return labourdeductionlist;
    }

    public void setEquipmentdeductionlist(List<deductionsetupPOJO> equipmentdeductionlist) {
        this.equipmentdeductionlist = equipmentdeductionlist;
    }

    public List<deductionsetupPOJO> getEquipmentdeductionlist() {
        return equipmentdeductionlist;
    }

    public void setOtherdeductionlist(List<deductionsetupPOJO> otherdeductionlist) {
        this.otherdeductionlist = otherdeductionlist;
    }

    public List<deductionsetupPOJO> getOtherdeductionlist() {
        return otherdeductionlist;
    }

    public void setQualitydeductionlist(List<deductionsetupPOJO> qualitydeductionlist) {
        this.qualitydeductionlist = qualitydeductionlist;
    }

    public List<deductionsetupPOJO> getQualitydeductionlist() {
        return qualitydeductionlist;
    }

    public void setPERIOD_MONTHLIST(List<SelectItem> _PERIOD_MONTHLIST) {
        this._PERIOD_MONTHLIST = _PERIOD_MONTHLIST;
    }

    public List<SelectItem> getPERIOD_MONTHLIST() {
        if (_PERIOD_MONTHLIST == null) {
            _PERIOD_MONTHLIST = new ArrayList<SelectItem>();
            _PERIOD_MONTHLIST.add(new SelectItem("09", "September"));
        }
        return _PERIOD_MONTHLIST;
    }

    public void setPERIOD_YEARLIST(List<SelectItem> _PERIOD_YEARLIST) {
        this._PERIOD_YEARLIST = _PERIOD_YEARLIST;
    }

    public List<SelectItem> getPERIOD_YEARLIST() {
        if (_PERIOD_YEARLIST == null) {
            _PERIOD_YEARLIST = new ArrayList<SelectItem>();
            int year = Calendar.getInstance().get(Calendar.YEAR);
            _PERIOD_YEARLIST.add(new SelectItem(year));
        }
        return _PERIOD_YEARLIST;
    }

    public void setEdtabbind(RichShowDetailItem edtabbind) {
        this.edtabbind = edtabbind;
    }

    public RichShowDetailItem getEdtabbind() {
        return edtabbind;
    }

    public void setQdtabbind(RichShowDetailItem qdtabbind) {
        this.qdtabbind = qdtabbind;
    }

    public RichShowDetailItem getQdtabbind() {
        return qdtabbind;
    }

    public void setOdtabbind(RichShowDetailItem odtabbind) {
        this.odtabbind = odtabbind;
    }

    public RichShowDetailItem getOdtabbind() {
        return odtabbind;
    }

    public void setCurrentSelectedIndexld(Integer _currentSelectedIndexld) {
        this._currentSelectedIndexld = _currentSelectedIndexld;
    }

    public Integer getCurrentSelectedIndexld() {
        return _currentSelectedIndexld;
    }

    public void setCurrentSelectedIndexed(Integer _currentSelectedIndexed) {
        this._currentSelectedIndexed = _currentSelectedIndexed;
    }

    public Integer getCurrentSelectedIndexed() {
        return _currentSelectedIndexed;
    }

    public void setCurrentSelectedIndexqd(Integer _currentSelectedIndexqd) {
        this._currentSelectedIndexqd = _currentSelectedIndexqd;
    }

    public Integer getCurrentSelectedIndexqd() {
        return _currentSelectedIndexqd;
    }

    public void setCurrentSelectedIndexod(Integer _currentSelectedIndexod) {
        this._currentSelectedIndexod = _currentSelectedIndexod;
    }

    public Integer getCurrentSelectedIndexod() {
        return _currentSelectedIndexod;
    }

    public void setCancelbtn(RichCommandButton cancelbtn) {
        this.cancelbtn = cancelbtn;
    }

    public RichCommandButton getCancelbtn() {
        return cancelbtn;
    }

    public void setAddrowbtnEQ(RichCommandButton addrowbtnEQ) {
        this.addrowbtnEQ = addrowbtnEQ;
    }

    public RichCommandButton getAddrowbtnEQ() {
        return addrowbtnEQ;
    }

    public void setAddrowbtnQD(RichCommandButton addrowbtnQD) {
        this.addrowbtnQD = addrowbtnQD;
    }

    public RichCommandButton getAddrowbtnQD() {
        return addrowbtnQD;
    }

    public void setAddrowbtnld(RichCommandButton addrowbtnld) {
        this.addrowbtnld = addrowbtnld;
    }

    public RichCommandButton getAddrowbtnld() {
        return addrowbtnld;
    }

    public void setAddrowbtnOD(RichCommandButton addrowbtnOD) {
        this.addrowbtnOD = addrowbtnOD;
    }

    public RichCommandButton getAddrowbtnOD() {
        return addrowbtnOD;
    }

    public void setCancelbtnED(RichCommandButton cancelbtnED) {
        this.cancelbtnED = cancelbtnED;
    }

    public RichCommandButton getCancelbtnED() {
        return cancelbtnED;
    }

    public void setCancelbtnQD(RichCommandButton cancelbtnQD) {
        this.cancelbtnQD = cancelbtnQD;
    }

    public RichCommandButton getCancelbtnQD() {
        return cancelbtnQD;
    }

    public void setCancelbtnOD(RichCommandButton cancelbtnOD) {
        this.cancelbtnOD = cancelbtnOD;
    }

    public RichCommandButton getCancelbtnOD() {
        return cancelbtnOD;
    }

    public void setEnabledbind(RichInputText enabledbind) {
        this.enabledbind = enabledbind;
    }

    public RichInputText getEnabledbind() {
        return enabledbind;
    }

    public void setDeductionnamelist(List<SelectItem> deductionnamelist) {
        this.deductionnamelist = deductionnamelist;
    }

    public List<SelectItem> getDeductionnamelist() {
        return deductionnamelist;
    }

    public void setLddeductionnamelist(List<SelectItem> lddeductionnamelist) {
        this.lddeductionnamelist = lddeductionnamelist;
    }

    public List<SelectItem> getLddeductionnamelist() {
        return lddeductionnamelist;
    }

    public void setLddeductionname(RichSelectOneChoice lddeductionname) {
        this.lddeductionname = lddeductionname;
    }

    public RichSelectOneChoice getLddeductionname() {
        return lddeductionname;
    }

    public void setDeductionenabledbind(RichInputText deductionenabledbind) {
        this.deductionenabledbind = deductionenabledbind;
    }

    public RichInputText getDeductionenabledbind() {
        return deductionenabledbind;
    }

    public void setDeductionpopupbind(RichPopup deductionpopupbind) {
        this.deductionpopupbind = deductionpopupbind;
    }

    public RichPopup getDeductionpopupbind() {
        return deductionpopupbind;
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

    public void setMONTHBINDVAR(RichSelectOneChoice MONTHBINDVAR) {
        this.MONTHBINDVAR = MONTHBINDVAR;
    }

    public RichSelectOneChoice getMONTHBINDVAR() {
        return MONTHBINDVAR;
    }

    public void setYEARBINDVAR(RichSelectOneChoice YEARBINDVAR) {
        this.YEARBINDVAR = YEARBINDVAR;
    }

    public RichSelectOneChoice getYEARBINDVAR() {
        return YEARBINDVAR;
    }

    public void setADDLABOURDEDUCTIONPOPUPBINDVAR(RichPopup ADDLABOURDEDUCTIONPOPUPBINDVAR) {
        this.ADDLABOURDEDUCTIONPOPUPBINDVAR = ADDLABOURDEDUCTIONPOPUPBINDVAR;
    }

    public RichPopup getADDLABOURDEDUCTIONPOPUPBINDVAR() {
        return ADDLABOURDEDUCTIONPOPUPBINDVAR;
    }

    public void setADDEQUIPMENTDEDUCTIONPOPUPBINDVAR(RichPopup ADDEQUIPMENTDEDUCTIONPOPUPBINDVAR) {
        this.ADDEQUIPMENTDEDUCTIONPOPUPBINDVAR =
                ADDEQUIPMENTDEDUCTIONPOPUPBINDVAR;
    }

    public RichPopup getADDEQUIPMENTDEDUCTIONPOPUPBINDVAR() {
        return ADDEQUIPMENTDEDUCTIONPOPUPBINDVAR;
    }

    public void setADDQUALITYDEDUCTIONPOPUPBINDVAR(RichPopup ADDQUALITYDEDUCTIONPOPUPBINDVAR) {
        this.ADDQUALITYDEDUCTIONPOPUPBINDVAR = ADDQUALITYDEDUCTIONPOPUPBINDVAR;
    }

    public RichPopup getADDQUALITYDEDUCTIONPOPUPBINDVAR() {
        return ADDQUALITYDEDUCTIONPOPUPBINDVAR;
    }

    public void setADDOTHERDEDUCTIONPOPUPBINDVAR(RichPopup ADDOTHERDEDUCTIONPOPUPBINDVAR) {
        this.ADDOTHERDEDUCTIONPOPUPBINDVAR = ADDOTHERDEDUCTIONPOPUPBINDVAR;
    }

    public RichPopup getADDOTHERDEDUCTIONPOPUPBINDVAR() {
        return ADDOTHERDEDUCTIONPOPUPBINDVAR;
    }

    public void setLduomnbind(RichInputText lduomnbind) {
        this.lduomnbind = lduomnbind;
    }

    public RichInputText getLduomnbind() {
        return lduomnbind;
    }

    public void setLdratebind(RichInputText ldratebind) {
        this.ldratebind = ldratebind;
    }

    public RichInputText getLdratebind() {
        return ldratebind;
    }

    public void setDEDUCTIONEXISTPOPUPBIND(RichPopup DEDUCTIONEXISTPOPUPBIND) {
        this.DEDUCTIONEXISTPOPUPBIND = DEDUCTIONEXISTPOPUPBIND;
    }

    public RichPopup getDEDUCTIONEXISTPOPUPBIND() {
        return DEDUCTIONEXISTPOPUPBIND;
    }

    public void setEddeductionnamelist(List<SelectItem> eddeductionnamelist) {
        this.eddeductionnamelist = eddeductionnamelist;
    }

    public List<SelectItem> getEddeductionnamelist() {
        return eddeductionnamelist;
    }

    public void setLABORDEDUCTIONTABLEBIND(RichTable LABORDEDUCTIONTABLEBIND) {
        this.LABORDEDUCTIONTABLEBIND = LABORDEDUCTIONTABLEBIND;
    }

    public RichTable getLABORDEDUCTIONTABLEBIND() {
        return LABORDEDUCTIONTABLEBIND;
    }

    public void setEddeductionname(RichSelectOneChoice eddeductionname) {
        this.eddeductionname = eddeductionname;
    }

    public RichSelectOneChoice getEddeductionname() {
        return eddeductionname;
    }

    public void setEduombind(RichInputText eduombind) {
        this.eduombind = eduombind;
    }

    public RichInputText getEduombind() {
        return eduombind;
    }

    public void setEdratebind(RichInputText edratebind) {
        this.edratebind = edratebind;
    }

    public RichInputText getEdratebind() {
        return edratebind;
    }

    public void setEQUIPMENTDEDUCTIONTABLEBIND(RichTable EQUIPMENTDEDUCTIONTABLEBIND) {
        this.EQUIPMENTDEDUCTIONTABLEBIND = EQUIPMENTDEDUCTIONTABLEBIND;
    }

    public RichTable getEQUIPMENTDEDUCTIONTABLEBIND() {
        return EQUIPMENTDEDUCTIONTABLEBIND;
    }

    public void setQddeductionname(RichInputText qddeductionname) {
        this.qddeductionname = qddeductionname;
    }

    public RichInputText getQddeductionname() {
        return qddeductionname;
    }

    public void setQduombind(RichInputText qduombind) {
        this.qduombind = qduombind;
    }

    public RichInputText getQduombind() {
        return qduombind;
    }

    public void setQdratebind(RichInputText qdratebind) {
        this.qdratebind = qdratebind;
    }

    public RichInputText getQdratebind() {
        return qdratebind;
    }

    public void setOddeductionname(RichInputText oddeductionname) {
        this.oddeductionname = oddeductionname;
    }

    public RichInputText getOddeductionname() {
        return oddeductionname;
    }

    public void setOduombind(RichInputText oduombind) {
        this.oduombind = oduombind;
    }

    public RichInputText getOduombind() {
        return oduombind;
    }

    public void setOdratebind(RichInputText odratebind) {
        this.odratebind = odratebind;
    }

    public RichInputText getOdratebind() {
        return odratebind;
    }

    public void setQUALITYDEDUCTIONTABLEBIND(RichTable QUALITYDEDUCTIONTABLEBIND) {
        this.QUALITYDEDUCTIONTABLEBIND = QUALITYDEDUCTIONTABLEBIND;
    }

    public RichTable getQUALITYDEDUCTIONTABLEBIND() {
        return QUALITYDEDUCTIONTABLEBIND;
    }

    public void setOTHERDEDUCTIONTABLEBIND(RichTable OTHERDEDUCTIONTABLEBIND) {
        this.OTHERDEDUCTIONTABLEBIND = OTHERDEDUCTIONTABLEBIND;
    }

    public RichTable getOTHERDEDUCTIONTABLEBIND() {
        return OTHERDEDUCTIONTABLEBIND;
    }

    public void setCONTRACTNUMBERLOVBINDVAR(RichSelectOneChoice CONTRACTNUMBERLOVBINDVAR) {
        this.CONTRACTNUMBERLOVBINDVAR = CONTRACTNUMBERLOVBINDVAR;
    }

    public RichSelectOneChoice getCONTRACTNUMBERLOVBINDVAR() {
        return CONTRACTNUMBERLOVBINDVAR;
    }

    public void setADDNEWROWPROMPTPOPUPBINDVAR(RichPopup ADDNEWROWPROMPTPOPUPBINDVAR) {
        this.ADDNEWROWPROMPTPOPUPBINDVAR = ADDNEWROWPROMPTPOPUPBINDVAR;
    }

    public RichPopup getADDNEWROWPROMPTPOPUPBINDVAR() {
        return ADDNEWROWPROMPTPOPUPBINDVAR;
    }

    public void setSUBMITPROMPTPOPUPBINDVAR(RichPopup SUBMITPROMPTPOPUPBINDVAR) {
        this.SUBMITPROMPTPOPUPBINDVAR = SUBMITPROMPTPOPUPBINDVAR;
    }

    public RichPopup getSUBMITPROMPTPOPUPBINDVAR() {
        return SUBMITPROMPTPOPUPBINDVAR;
    }

    public void setCURRENTSELECTEDINDEX(int CURRENTSELECTEDINDEX) {
        this.CURRENTSELECTEDINDEX = CURRENTSELECTEDINDEX;
    }

    public int getCURRENTSELECTEDINDEX() {
        return CURRENTSELECTEDINDEX;
    }

    public void setDATASAVEDPOPUPBINDVAR(RichPopup DATASAVEDPOPUPBINDVAR) {
        this.DATASAVEDPOPUPBINDVAR = DATASAVEDPOPUPBINDVAR;
    }

    public RichPopup getDATASAVEDPOPUPBINDVAR() {
        return DATASAVEDPOPUPBINDVAR;
    }

    public void setInputcontracttype(RichInputText inputcontracttype) {
        this.inputcontracttype = inputcontracttype;
    }

    public RichInputText getInputcontracttype() {
        return inputcontracttype;
    }

    public void setInputversion(RichInputText inputversion) {
        this.inputversion = inputversion;
    }

    public RichInputText getInputversion() {
        return inputversion;
    }

    public void setDeductionenable(String deductionenable) {
        this.deductionenable = deductionenable;
    }

    public String getDeductionenable() {
        return deductionenable;
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

    //    public void setButtonDisabled(Boolean value) {
    //        addrowbtnld.setDisabled(value);
    //        addrowbtnEQ.setDisabled(value);
    //        addrowbtnQD.setDisabled(value);
    //        addrowbtnOD.setDisabled(value);
    //        cancelbtn.setDisabled(value);
    //    }

    private void showPopup(RichPopup pop, boolean visible) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context != null && pop != null) {
                String popupId = pop.getClientId(context);
                if (popupId != null) {
                    StringBuilder script = new StringBuilder();
                    script.append("var popup = AdfPage.PAGE.findComponent('").append(popupId).append("'); ");
                    if (visible) {
                        script.append("if (!popup.isPopupVisible()) { ").append("popup.show();}");
                    } else {
                        script.append("if (popup.isPopupVisible()) { ").append("popup.hide();}");
                    }
                    ExtendedRenderKitService erks =
                        Service.getService(context.getRenderKit(),
                                           ExtendedRenderKitService.class);
                    erks.addScript(context, script.toString());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void contractNumberValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        System.out.println(valueChangeEvent.getNewValue());
        ViewObjectImpl ch_vo = getAppModule().getContractHeaderVO1();
        ViewObjectImpl ldn_vo = getAppModule().getJobDeductionNameVO1();
        ViewObjectImpl nl_vo = getAppModule().getNonLaborResourcePVO1();
        if (valueChangeEvent.getNewValue() == null) {
            reset();
        } else if (valueChangeEvent.getNewValue() != null) {
            contractype = "";
            version = "";
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

            RowSetIterator ch_vo_iter = ch_vo.createRowSetIterator(null);
            contractype =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("ContractType"));
            version =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("Version"));
            deductionenable =
                    String.valueOf(ch_vo_iter.getRowAtRangeIndex(0).getAttribute("Deduction"));
            System.out.println(" populated deductionenable" + deductionenable);
            ch_vo_iter.closeRowSetIterator();

            if (deductionenable.equalsIgnoreCase("Yes")) {
                RowSetIterator ldn_vo_iter = ldn_vo.createRowSetIterator(null);
                while (ldn_vo_iter.hasNext()) {
                    Row r = ldn_vo_iter.next();
                    String dname = (String)r.getAttribute("DeductionName");
                    lddeductionnamelist.add(new SelectItem(dname));
                }
                ldn_vo_iter.closeRowSetIterator();

                RowSetIterator nl_vo_iter = nl_vo.createRowSetIterator(null);
                while (nl_vo_iter.hasNext()) {
                    Row r = nl_vo_iter.next();
                    String dname = (String)r.getAttribute("NonLaborName");
                    eddeductionnamelist.add(new SelectItem(dname));
                }
                nl_vo_iter.closeRowSetIterator();

                if (contractnum != "" && MONTHBINDVAR.getValue() != null &&
                    YEARBINDVAR.getValue() != null) {
                    getAllDeductionDetials(contractnum, PERIOD);
                }
            } else {
                MONTHBINDVAR.resetValue();
                MONTHBINDVAR.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(MONTHBINDVAR);

                YEARBINDVAR.resetValue();
                YEARBINDVAR.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(YEARBINDVAR);

                labourdeductionlist.clear();
                equipmentdeductionlist.clear();
                qualitydeductionlist.clear();
                otherdeductionlist.clear();


                this.showPopup(this.getDeductionpopupbind(), true);
            }
        }
    }

    public void monthValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null && contractnum != "" &&
            YEARBINDVAR.getValue() != null) {
            PERIOD =
                    valueChangeEvent.getNewValue().toString() + "-" + YEARBINDVAR.getValue().toString();
            getAllDeductionDetials(contractnum, PERIOD);
        } else {
            labourdeductionlist.clear();
            equipmentdeductionlist.clear();
            qualitydeductionlist.clear();
            otherdeductionlist.clear();
        }
    }

    public void yearValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null && contractnum != "" &&
            MONTHBINDVAR.getValue() != null) {
            PERIOD =
                    MONTHBINDVAR.getValue().toString() + "-" + valueChangeEvent.getNewValue().toString();
            getAllDeductionDetials(contractnum, PERIOD);
        } else {
            labourdeductionlist.clear();
            equipmentdeductionlist.clear();
            qualitydeductionlist.clear();
            otherdeductionlist.clear();
        }
    }

    public void getAllDeductionDetials(String contractnum, String period) {

        String responsejson = "";
        restclient rc = new restclient();
        rc.importCertificates();
        try {
            responsejson =
                    rc.RestGETOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/deductionsetupdetails/" +
                                                contractnum.replaceAll("\\s",
                                                                       "%20") +
                                                "/" + period));
        } catch (MalformedURLException e) {
            System.out.println(" *** Some error occurred");
        }
        allDeductionDetials_JsonParser(responsejson);
    }

    public void allDeductionDetials_JsonParser(String payload) {
        JSONParser parser = new JSONParser();
        try {
            labourdeductionlist.clear();
            equipmentdeductionlist.clear();
            qualitydeductionlist.clear();
            otherdeductionlist.clear();
            JSONObject jsonObject = (JSONObject)parser.parse(payload);
            JSONArray itemsArray = (JSONArray)jsonObject.get("items");
            if (itemsArray.size() != 0) {
                for (int i = 0; i < itemsArray.size(); i++) {
                    Object itemsArrayObj =
                        parser.parse(itemsArray.get(i).toString());
                    JSONObject jsonArrayObject = (JSONObject)itemsArrayObj;
                    if (jsonArrayObject.get("deduction_type").toString().equals("Labour Deduction")) {
                        System.out.println(String.valueOf(jsonArrayObject.get("deduction_type")));
                        labourdeductionlist.add(new deductionsetupPOJO(String.valueOf(jsonArrayObject.get("subcontract_num")),
                                                                       String.valueOf(jsonArrayObject.get("contract_type")),
                                                                       String.valueOf(jsonArrayObject.get("version")),
                                                                       String.valueOf(jsonArrayObject.get("deduction_type")),
                                                                       String.valueOf(jsonArrayObject.get("deduction_name")),
                                                                       String.valueOf(jsonArrayObject.get("uom")),
                                                                       String.valueOf(jsonArrayObject.get("unit_rate"))));
                    } else if (jsonArrayObject.get("deduction_type").toString().equals("Equipment Deduction")) {
                        System.out.println(String.valueOf(jsonArrayObject.get("deduction_type")));
                        equipmentdeductionlist.add(new deductionsetupPOJO(String.valueOf(jsonArrayObject.get("subcontract_num")),
                                                                          String.valueOf(jsonArrayObject.get("contract_type")),
                                                                          String.valueOf(jsonArrayObject.get("version")),
                                                                          String.valueOf(jsonArrayObject.get("deduction_type")),
                                                                          String.valueOf(jsonArrayObject.get("deduction_name")),
                                                                          String.valueOf(jsonArrayObject.get("uom")),
                                                                          String.valueOf(jsonArrayObject.get("unit_rate"))));
                    } else if (jsonArrayObject.get("deduction_type").toString().equals("Quality Deduction")) {
                        System.out.println(String.valueOf(jsonArrayObject.get("deduction_type")));
                        qualitydeductionlist.add(new deductionsetupPOJO(String.valueOf(jsonArrayObject.get("subcontract_num")),
                                                                        String.valueOf(jsonArrayObject.get("contract_type")),
                                                                        String.valueOf(jsonArrayObject.get("version")),
                                                                        String.valueOf(jsonArrayObject.get("deduction_type")),
                                                                        String.valueOf(jsonArrayObject.get("deduction_name")),
                                                                        String.valueOf(jsonArrayObject.get("uom")),
                                                                        String.valueOf(jsonArrayObject.get("unit_rate"))));
                    } else if (jsonArrayObject.get("deduction_type").toString().equals("Other Deduction")) {
                        System.out.println(String.valueOf(jsonArrayObject.get("deduction_type")));
                        otherdeductionlist.add(new deductionsetupPOJO(String.valueOf(jsonArrayObject.get("subcontract_num")),
                                                                      String.valueOf(jsonArrayObject.get("contract_type")),
                                                                      String.valueOf(jsonArrayObject.get("version")),
                                                                      String.valueOf(jsonArrayObject.get("deduction_type")),
                                                                      String.valueOf(jsonArrayObject.get("deduction_name")),
                                                                      String.valueOf(jsonArrayObject.get("uom")),
                                                                      String.valueOf(jsonArrayObject.get("unit_rate"))));
                    }
                }
                AdfFacesContext.getCurrentInstance().addPartialTarget(LABORDEDUCTIONTABLEBIND);
                AdfFacesContext.getCurrentInstance().addPartialTarget(EQUIPMENTDEDUCTIONTABLEBIND);
                AdfFacesContext.getCurrentInstance().addPartialTarget(QUALITYDEDUCTIONTABLEBIND);
                AdfFacesContext.getCurrentInstance().addPartialTarget(OTHERDEDUCTIONTABLEBIND);

            } else {
                System.out.println("No data found.");
            }
        } catch (ParseException e) {
            e.getMessage();
        }
    }

    public void addNewRow(ActionEvent actionEvent) {
        System.out.println(CONTRACTNUMBERLOVBINDVAR.getValue());
        if (CONTRACTNUMBERLOVBINDVAR.getValue() != null &&
            MONTHBINDVAR.getValue() != null &&
            YEARBINDVAR.getValue() != null &&
            deductionenabledbind.getValue().toString().equals("Yes")) {
            if (ldtabbind.isDisclosed()) {
                showPopup(ADDLABOURDEDUCTIONPOPUPBINDVAR, true);
            }
            if (edtabbind.isDisclosed()) {
                showPopup(ADDEQUIPMENTDEDUCTIONPOPUPBINDVAR, true);
            }
            if (qdtabbind.isDisclosed()) {
                showPopup(ADDQUALITYDEDUCTIONPOPUPBINDVAR, true);
            }
            if (odtabbind.isDisclosed()) {
                showPopup(ADDOTHERDEDUCTIONPOPUPBINDVAR, true);
            }
        } else {
            this.showPopup(ADDNEWROWPROMPTPOPUPBINDVAR, true);
        }
    }

    public void addNewDeductionDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().toString() == "ok") {
            Boolean deduction_name_exist = false;
            String record_json = "";
            getAllDeductionDetials(contractnum, PERIOD);
            if (ldtabbind.isDisclosed()) {
                for (int i = 0; i < labourdeductionlist.size(); i++) {
                    if (labourdeductionlist.get(i).getDeduction_name().toString().equals(lddeductionname.getValue().toString())) {
                        deduction_name_exist = true;
                    }
                }
                if (deduction_name_exist == false) {
                    record_json =
                            "{\"SUBCONTRACT_NUM\":\"" + contractnum + "\",\"PRIMARY_KEY\":\"" +
                            contractnum + "-" + PERIOD + "-Labour Deduction-" +
                            lddeductionname.getValue().toString() +
                            "\",\"PERIOD\":\"" + PERIOD +
                            "\",\"CONTRACT_TYPE\":\"" + contractype +
                            "\",\"VERSION\":\"" + version +
                            "\",\"DEDUCTION_TYPE\":\"" + "Labour Deduction" +
                            "\",\"DEDUCTION_NAME\":\"" +
                            lddeductionname.getValue().toString() +
                            "\",\"UOM\":\"" +
                            lduomnbind.getValue().toString() +
                            "\",\"UNIT_RATE\":\"" +
                            ldratebind.getValue().toString() + "\"}";

                    insertRecord(record_json);
                    getAllDeductionDetials(contractnum, PERIOD);
                    //                    labourdeductionlist.add(new deductionsetupPOJO(contractnum,
                    //                                                                   contractype,
                    //                                                                   version,
                    //                                                                   "Labour Deduction",
                    //                                                                   lddeductionname.getValue().toString(),
                    //                                                                   lduomnbind.getValue().toString(),
                    //                                                                   ldratebind.getValue().toString()));
                    //  AdfFacesContext.getCurrentInstance().addPartialTarget(LABORDEDUCTIONTABLEBIND);
                } else {
                    this.showPopup(DEDUCTIONEXISTPOPUPBIND, true);
                }
                lddeductionname.resetValue();
                lddeductionname.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(lddeductionname);
                ldratebind.resetValue();
                ldratebind.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ldratebind);
            }
            if (edtabbind.isDisclosed()) {
                for (int i = 0; i < equipmentdeductionlist.size(); i++) {
                    if (equipmentdeductionlist.get(i).getDeduction_name().toString().equals(eddeductionname.getValue().toString())) {
                        deduction_name_exist = true;
                    }
                }
                if (deduction_name_exist == false) {

                    record_json =
                            "{\"SUBCONTRACT_NUM\":\"" + contractnum + "\",\"PRIMARY_KEY\":\"" +
                            contractnum + "-" + PERIOD +
                            "-Equipment Deduction-" +
                            eddeductionname.getValue().toString() +
                            "\",\"PERIOD\":\"" + PERIOD +
                            "\",\"CONTRACT_TYPE\":\"" + contractype +
                            "\",\"VERSION\":\"" + version +
                            "\",\"DEDUCTION_TYPE\":\"" +
                            "Equipment Deduction" +
                            "\",\"DEDUCTION_NAME\":\"" +
                            eddeductionname.getValue().toString() +
                            "\",\"UOM\":\"" + eduombind.getValue().toString() +
                            "\",\"UNIT_RATE\":\"" +
                            edratebind.getValue().toString() + "\"}";
                    System.out.println("record_json for equipment" +
                                       record_json);
                    insertRecord(record_json);
                    getAllDeductionDetials(contractnum, PERIOD);
                    //                    equipmentdeductionlist.add(new deductionsetupPOJO(contractnum,
                    //                                                                      contractype,
                    //                                                                      version,
                    //                                                                      "Equipment Deduction",
                    //                                                                      eddeductionname.getValue().toString(),
                    //                                                                      eduombind.getValue().toString(),
                    //                                                                      edratebind.getValue().toString()));
                    //                    AdfFacesContext.getCurrentInstance().addPartialTarget(EQUIPMENTDEDUCTIONTABLEBIND);
                } else {
                    this.showPopup(DEDUCTIONEXISTPOPUPBIND, true);
                }
                eddeductionname.resetValue();
                eddeductionname.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(eddeductionname);
                edratebind.resetValue();
                edratebind.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(edratebind);
            }
            if (qdtabbind.isDisclosed()) {
                for (int i = 0; i < this.qualitydeductionlist.size(); i++) {
                    if (qualitydeductionlist.get(i).getDeduction_name().toString().equals(qddeductionname.getValue().toString())) {
                        deduction_name_exist = true;
                    }
                }
                if (deduction_name_exist == false) {

                    record_json =
                            "{\"SUBCONTRACT_NUM\":\"" + contractnum + "\",\"PRIMARY_KEY\":\"" +
                            contractnum + "-" + PERIOD +
                            "-Quality Deduction-" +
                            qddeductionname.getValue().toString() +
                            "\",\"PERIOD\":\"" + PERIOD +
                            "\",\"CONTRACT_TYPE\":\"" + contractype +
                            "\",\"VERSION\":\"" + version +
                            "\",\"DEDUCTION_TYPE\":\"" + "Quality Deduction" +
                            "\",\"DEDUCTION_NAME\":\"" +
                            qddeductionname.getValue().toString() +
                            "\",\"UOM\":\"" + qduombind.getValue().toString() +
                            "\",\"UNIT_RATE\":\"" +
                            qdratebind.getValue().toString() + "\"}";

                    insertRecord(record_json);
                    getAllDeductionDetials(contractnum, PERIOD);
                    //                    qualitydeductionlist.add(new deductionsetupPOJO(contractnum,
                    //                                                                    contractype,
                    //                                                                    version,
                    //                                                                    "Quality Deduction",
                    //                                                                    qddeductionname.getValue().toString(),
                    //                                                                    qduombind.getValue().toString(),
                    //                                                                    qdratebind.getValue().toString()));
                    //                    AdfFacesContext.getCurrentInstance().addPartialTarget(QUALITYDEDUCTIONTABLEBIND);
                } else {
                    this.showPopup(DEDUCTIONEXISTPOPUPBIND, true);
                }
                qddeductionname.resetValue();
                qddeductionname.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(qddeductionname);
                qdratebind.resetValue();
                qdratebind.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(qdratebind);
            }
            if (odtabbind.isDisclosed()) {
                for (int i = 0; i < this.otherdeductionlist.size(); i++) {
                    if (otherdeductionlist.get(i).getDeduction_name().toString().equals(oddeductionname.getValue().toString())) {
                        deduction_name_exist = true;
                    }
                }
                if (deduction_name_exist == false) {

                    record_json =
                            "{\"SUBCONTRACT_NUM\":\"" + contractnum + "\",\"PRIMARY_KEY\":\"" +
                            contractnum + "-" + PERIOD + "-Other Deduction-" +
                            oddeductionname.getValue().toString() +
                            "\",\"PERIOD\":\"" + PERIOD +
                            "\",\"CONTRACT_TYPE\":\"" + contractype +
                            "\",\"VERSION\":\"" + version +
                            "\",\"DEDUCTION_TYPE\":\"" + "Other Deduction" +
                            "\",\"DEDUCTION_NAME\":\"" +
                            oddeductionname.getValue().toString() +
                            "\",\"UOM\":\"" + oduombind.getValue().toString() +
                            "\",\"UNIT_RATE\":\"" +
                            odratebind.getValue().toString() + "\"}";

                    insertRecord(record_json);
                    getAllDeductionDetials(contractnum, PERIOD);
                    //                    otherdeductionlist.add(new deductionsetupPOJO(contractnum,
                    //                                                                  contractype,
                    //                                                                  version,
                    //                                                                  "Other Deduction",
                    //                                                                  oddeductionname.getValue().toString(),
                    //                                                                  oduombind.getValue().toString(),
                    //                                                                  odratebind.getValue().toString()));
                    //                    AdfFacesContext.getCurrentInstance().addPartialTarget(OTHERDEDUCTIONTABLEBIND);
                } else {
                    this.showPopup(DEDUCTIONEXISTPOPUPBIND, true);
                }
                oddeductionname.resetValue();
                oddeductionname.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(oddeductionname);
                odratebind.resetValue();
                odratebind.setValid(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(odratebind);
            }
        }
    }

    public void insertRecord(String json) {
        try {
            System.out.println("json for deduction" + json);
            restclient rc = new restclient();
            rc.importCertificates();
            rc.RestPOSTOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/insert_deduction_setup_record/"),
                                 json);
        } catch (MalformedURLException murle) {
            murle.printStackTrace();
        }
    }

    public void onRowRemoval(ActionEvent actionEvent) {
        if (ldtabbind.isDisclosed()) {
            int currentIndexld = getCurrentSelectedIndexld();

            deleterecordlist.add(new deductionsetupPOJO(labourdeductionlist.get(currentIndexld).getSubcontract_num(),
                                                        labourdeductionlist.get(currentIndexld).getContract_type(),
                                                        labourdeductionlist.get(currentIndexld).getVersion(),
                                                        labourdeductionlist.get(currentIndexld).getDeduction_type(),
                                                        labourdeductionlist.get(currentIndexld).getDeduction_name(),
                                                        labourdeductionlist.get(currentIndexld).getUOM(),
                                                        labourdeductionlist.get(currentIndexld).getUnit_Rate()));
            deductionsetupPOJO dT0 =
                labourdeductionlist.remove(currentIndexld);
            if (dT0 == null) {
                System.out.println("Element with index " + currentIndexld +
                                   " not found in list!");
            }
            UIComponent ui = (UIComponent)actionEvent.getSource();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ui.getParent().getParent().getParent());
        }
        if (edtabbind.isDisclosed()) {
            int currentIndexed = getCurrentSelectedIndexed();
            deleterecordlist.add(new deductionsetupPOJO(equipmentdeductionlist.get(currentIndexed).getSubcontract_num(),
                                                        equipmentdeductionlist.get(currentIndexed).getContract_type(),
                                                        equipmentdeductionlist.get(currentIndexed).getVersion(),
                                                        equipmentdeductionlist.get(currentIndexed).getDeduction_type(),
                                                        equipmentdeductionlist.get(currentIndexed).getDeduction_name(),
                                                        equipmentdeductionlist.get(currentIndexed).getUOM(),
                                                        equipmentdeductionlist.get(currentIndexed).getUnit_Rate()));
            deductionsetupPOJO dT1 =
                equipmentdeductionlist.remove(currentIndexed);

            if (dT1 == null) {
                System.out.println("Element with index " + currentIndexed +
                                   " not found in list!");
            }
            UIComponent ui = (UIComponent)actionEvent.getSource();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ui.getParent().getParent().getParent());
        }
        if (qdtabbind.isDisclosed()) {
            int currentIndexqd = getCurrentSelectedIndexqd();
            deleterecordlist.add(new deductionsetupPOJO(qualitydeductionlist.get(currentIndexqd).getSubcontract_num(),
                                                        qualitydeductionlist.get(currentIndexqd).getContract_type(),
                                                        qualitydeductionlist.get(currentIndexqd).getVersion(),
                                                        qualitydeductionlist.get(currentIndexqd).getDeduction_type(),
                                                        qualitydeductionlist.get(currentIndexqd).getDeduction_name(),
                                                        qualitydeductionlist.get(currentIndexqd).getUOM(),
                                                        qualitydeductionlist.get(currentIndexqd).getUnit_Rate()));
            deductionsetupPOJO dT2 =
                qualitydeductionlist.remove(currentIndexqd);
            if (dT2 == null) {
                System.out.println("Element with index " + currentIndexqd +
                                   " not found in list!");
            }
            UIComponent ui = (UIComponent)actionEvent.getSource();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ui.getParent().getParent().getParent());
        }
        if (odtabbind.isDisclosed()) {
            int currentIndexod = getCurrentSelectedIndexod();
            deleterecordlist.add(new deductionsetupPOJO(otherdeductionlist.get(currentIndexod).getSubcontract_num(),
                                                        otherdeductionlist.get(currentIndexod).getContract_type(),
                                                        otherdeductionlist.get(currentIndexod).getVersion(),
                                                        otherdeductionlist.get(currentIndexod).getDeduction_type(),
                                                        otherdeductionlist.get(currentIndexod).getDeduction_name(),
                                                        otherdeductionlist.get(currentIndexod).getUOM(),
                                                        otherdeductionlist.get(currentIndexod).getUnit_Rate()));
            deductionsetupPOJO dT3 = otherdeductionlist.remove(currentIndexod);
            if (dT3 == null) {
                System.out.println("Element with index " + currentIndexod +
                                   " not found in list!");
            }
            UIComponent ui = (UIComponent)actionEvent.getSource();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ui.getParent().getParent().getParent());
        }
    }

    public void unitRateValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            String unitrate = valueChangeEvent.getNewValue().toString();
            int currentIndex = CURRENTSELECTEDINDEX;
            String key = "";
            if (ldtabbind.isDisclosed()) {
                this.labourdeductionlist.get(currentIndex).setUnit_Rate(unitrate);
                key =
labourdeductionlist.get(currentIndex).getSubcontract_num() + "-" + PERIOD +
  "-" + labourdeductionlist.get(currentIndex).getDeduction_type() + "-" +
  labourdeductionlist.get(currentIndex).getDeduction_name();

                updateRecord(unitrate, key);
            }
            if (edtabbind.isDisclosed()) {
                this.equipmentdeductionlist.get(currentIndex).setUnit_Rate(unitrate);
                key =
equipmentdeductionlist.get(currentIndex).getSubcontract_num() + "-" + PERIOD +
  "-" + equipmentdeductionlist.get(currentIndex).getDeduction_type() + "-" +
  equipmentdeductionlist.get(currentIndex).getDeduction_name();

                updateRecord(unitrate, key);
            }
            if (qdtabbind.isDisclosed()) {
                this.qualitydeductionlist.get(currentIndex).setUnit_Rate(unitrate);

                key =
qualitydeductionlist.get(currentIndex).getSubcontract_num() + "-" + PERIOD +
  "-" + qualitydeductionlist.get(currentIndex).getDeduction_type() + "-" +
  qualitydeductionlist.get(currentIndex).getDeduction_name();

                updateRecord(unitrate, key);
            }
            if (odtabbind.isDisclosed()) {
                this.otherdeductionlist.get(currentIndex).setUnit_Rate(unitrate);

                key =
otherdeductionlist.get(currentIndex).getSubcontract_num() + "-" + PERIOD +
  "-" + otherdeductionlist.get(currentIndex).getDeduction_type() + "-" +
  otherdeductionlist.get(currentIndex).getDeduction_name();

                updateRecord(unitrate, key);
            }
        }
    }

    public void updateRecord(String unitrate, String key) {
        try {
            restclient rc = new restclient();
            rc.importCertificates();
            rc.RestPUTOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/update_deduction_setup_record/" +
                                        key.replaceAll("\\s", "%20") + "/" +
                                        unitrate), "");
        } catch (MalformedURLException murle) {
            murle.printStackTrace();
        }
    }

    public void onCancel(ActionEvent actionEvent) {
        reset();
    }

    public void onSubmit(ActionEvent actionEvent) {
        this.showPopup(DATASAVEDPOPUPBINDVAR, true);
        //        String NEW_DEDUCTION_JSON_ARRAY = "";
        //        String UPDATED_DEDUCTION_JSON_ARRAY = "";
        //        String DELETED_DEDUCTION_JSON_ARRAY = "";
        //        String DEDUCTION_JSON = "";
        //        String FINAL_DEDUCTION_JSON = "";
        //
        //        if (!newrecordlist.isEmpty()) {
        //            for (int i = 0; i < this.newrecordlist.size(); i++) {
        //                NEW_DEDUCTION_JSON_ARRAY =
        //                        NEW_DEDUCTION_JSON_ARRAY + "{\"SUBCONTRACT_NUM\":\"" +
        //                        newrecordlist.get(i).getSubcontract_num() +
        //                        "\",\"CONTRACT_TYPE\":\"" +
        //                        newrecordlist.get(i).getContract_type() +
        //                        "\",\"VERSION\":\"" +
        //                        newrecordlist.get(i).getVersion() +
        //                        "\",\"DEDUCTION_TYPE\":\"" +
        //                        newrecordlist.get(i).getDeduction_type() +
        //                        "\",\"DEDUCTION_NAME\":\"" +
        //                        newrecordlist.get(i).getDeduction_name() +
        //                        "\",\"UOM\":\"" + newrecordlist.get(i).getUOM() +
        //                        "\",\"UNIT_RATE\":\"" +
        //                        newrecordlist.get(i).getUnit_Rate() + "\"},";
        //            }
        //            NEW_DEDUCTION_JSON_ARRAY =
        //                    NEW_DEDUCTION_JSON_ARRAY.substring(0, NEW_DEDUCTION_JSON_ARRAY.length() -
        //                                                       1);
        //        }
        //        DEDUCTION_JSON =
        //                DEDUCTION_JSON + "\"newdeductions\":[" + NEW_DEDUCTION_JSON_ARRAY +
        //                "],";
        //
        //        if (!updaterecordlist.isEmpty()) {
        //            for (int i = 0; i < this.updaterecordlist.size(); i++) {
        //                UPDATED_DEDUCTION_JSON_ARRAY =
        //                        UPDATED_DEDUCTION_JSON_ARRAY + "{\"SUBCONTRACT_NUM\":\"" +
        //                        updaterecordlist.get(i).getSubcontract_num() +
        //                        "\",\"CONTRACT_TYPE\":\"" +
        //                        updaterecordlist.get(i).getContract_type() +
        //                        "\",\"VERSION\":\"" +
        //                        updaterecordlist.get(i).getVersion() +
        //                        "\",\"DEDUCTION_TYPE\":\"" +
        //                        updaterecordlist.get(i).getDeduction_type() +
        //                        "\",\"DEDUCTION_NAME\":\"" +
        //                        updaterecordlist.get(i).getDeduction_name() +
        //                        "\",\"UOM\":\"" + updaterecordlist.get(i).getUOM() +
        //                        "\",\"UNIT_RATE\":\"" +
        //                        updaterecordlist.get(i).getUnit_Rate() + "\"},";
        //            }
        //            UPDATED_DEDUCTION_JSON_ARRAY =
        //                    UPDATED_DEDUCTION_JSON_ARRAY.substring(0,
        //                                                           UPDATED_DEDUCTION_JSON_ARRAY.length() -
        //                                                           1);
        //        }
        //        DEDUCTION_JSON =
        //                DEDUCTION_JSON + "\"updateddeductions\":[" + UPDATED_DEDUCTION_JSON_ARRAY +
        //                "],";
        //
        //        if (!deleterecordlist.isEmpty()) {
        //            for (int i = 0; i < this.deleterecordlist.size(); i++) {
        //                DELETED_DEDUCTION_JSON_ARRAY =
        //                        DELETED_DEDUCTION_JSON_ARRAY + "{\"SUBCONTRACT_NUM\":\"" +
        //                        deleterecordlist.get(i).getSubcontract_num() +
        //                        "\",\"CONTRACT_TYPE\":\"" +
        //                        deleterecordlist.get(i).getContract_type() +
        //                        "\",\"VERSION\":\"" +
        //                        deleterecordlist.get(i).getVersion() +
        //                        "\",\"DEDUCTION_TYPE\":\"" +
        //                        deleterecordlist.get(i).getDeduction_type() +
        //                        "\",\"DEDUCTION_NAME\":\"" +
        //                        deleterecordlist.get(i).getDeduction_name() +
        //                        "\",\"UOM\":\"" + deleterecordlist.get(i).getUOM() +
        //                        "\",\"UNIT_RATE\":\"" +
        //                        deleterecordlist.get(i).getUnit_Rate() + "\"},";
        //            }
        //            DELETED_DEDUCTION_JSON_ARRAY =
        //                    DELETED_DEDUCTION_JSON_ARRAY.substring(0,
        //                                                           DELETED_DEDUCTION_JSON_ARRAY.length() -
        //                                                           1);
        //        }
        //        DEDUCTION_JSON =
        //                DEDUCTION_JSON + "\"updateddeductions\":[" + DELETED_DEDUCTION_JSON_ARRAY +
        //                "],";
        //
        //        DEDUCTION_JSON =
        //                DEDUCTION_JSON.substring(0, DEDUCTION_JSON.length() - 1);
        //
        //        FINAL_DEDUCTION_JSON = "{" + DEDUCTION_JSON + "}";
        //        System.out.println("DEDUCTION JSON : " + FINAL_DEDUCTION_JSON);

        //
        //                    restclient rc = new restclient();
        //                    rc.importCertificates();
        //                    rc.RestPOSTOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/deductionsetup/"),
        //                                         FINAL_DS_JSON);
        //                } catch (MalformedURLException murle) {
        //                    System.out.println("Error Occurred");
        //                    murle.printStackTrace();
        //                }
        //            } else if (labourdeductionlist.size() == 0 &&
        //                       equipmentdeductionlist.size() == 0 &&
        //                       qualitydeductionlist.size() == 0 &&
        //                       otherdeductionlist.size() == 0) {
        //                System.out.println("Nothing to save");
        //                this.showPopup(SUBMITPROMPTPOPUPBINDVAR, true);
        //            }

        reset();
    }

    public void reset() {
        contractype = "";
        version = "";
        deductionenable = "";


        //        CONTRACTNUMBERLOVBINDVAR.setValue("");
        //        CONTRACTNUMBERLOVBINDVAR.setValid(false);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(CONTRACTNUMBERLOVBINDVAR);

        MONTHBINDVAR.resetValue();
        MONTHBINDVAR.setValid(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(MONTHBINDVAR);

        YEARBINDVAR.resetValue();
        YEARBINDVAR.setValid(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(YEARBINDVAR);

        labourdeductionlist.clear();
        equipmentdeductionlist.clear();
        qualitydeductionlist.clear();
        otherdeductionlist.clear();
    }

    public void refreshtable(DialogEvent dialogEvent) {
        getAllDeductionDetials(contractnum, PERIOD);
    }

    public void deductionTypeDL(DisclosureEvent disclosureEvent) {
        // Add event code here...
        System.out.println("this is disclosureEvent");
    }
}

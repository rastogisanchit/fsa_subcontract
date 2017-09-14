package beans;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import model.AM.AppModuleImpl;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pojo.deductionsetupPOJO;
import pojo.deductiontxnPOJO;

import restclient.restclient;


public class deductiontxn {

    private RichInputText deductiontypebind;
    private RichInputText deductionnametxnbind;
    private RichInputText unitratebind;
    private RichInputText quantitybind;
    private RichInputText deductionamountbind;
    private RichInputText debitmemobind;
    private String contractnum = "";
    private String deductiontype = "";
    private String deductionname = "";
    private String _MONTH = "";
    private String _YEAR = "";
    private String _PERIOD = "";
    private boolean contractnumVC = false;
    private boolean deductiontypeVC = false;
    private boolean monthVC = false;
    private boolean yearVC = false;
    private boolean addrowflag = false;
    private boolean table_ReadOnly = false;

    private Integer _currentSelectedIndex;

    List<deductiontxnPOJO> deductiontxnlist;
    List<deductiontxnPOJO> newrecordlist;
    List<deductiontxnPOJO> updatedrecordlist;
    List<deductiontxnPOJO> deleterecordlist;
    List<deductionsetupPOJO> deductionsetuplist;
    List<SelectItem> deductionnamelist;
    private List<SelectItem> _PERIOD_MONTHLIST;
    private List<SelectItem> _PERIOD_YEARLIST;

    private RichInputText tablequantitybind;
    private RichInputText tabledeductionamount;
    private RichInputText tableUnitratebind;
    private RichOutputText totaldeductionamountbind;

    private String FINAL_TXN_JSON = "";
    private String TXN_JSON_ARRAY = "";
    private String TXN_TAMOUNT_JSON_ARRAY = "";
    private String FINAL_TAMOUNT_JSON_ARRAY = "";
    private RichCommandButton addRowbind;
    private RichCommandButton submitBind;
    private RichCommandButton cancelBind;
    private RichSelectOneChoice contractnumBind;
    private RichSelectOneChoice tableBind;
    private RichSelectOneChoice tabledeductiontypebind;
    private RichPopup addrecordpopupbindvar;
    private RichTable deductionentrytablebindvar;
    private RichSelectOneChoice deductionnamebindvar;
    private RichSelectOneChoice monthbind;
    private RichSelectOneChoice yearbind;
    private RichPopup deductionamepopup;
    private RichPopup nodatasubmitpopup;
    private RichPopup addrownodatapopup;

    public deductiontxn() {
        deductiontxnlist = new ArrayList<deductiontxnPOJO>();
        deductionsetuplist = new ArrayList<deductionsetupPOJO>();
        deductionnamelist = new ArrayList<SelectItem>();
        newrecordlist = new ArrayList<deductiontxnPOJO>();
        updatedrecordlist = new ArrayList<deductiontxnPOJO>();
        deleterecordlist = new ArrayList<deductiontxnPOJO>();
    }

    public void setDeductiontypebind(RichInputText deductiontypebind) {
        this.deductiontypebind = deductiontypebind;
    }

    public RichInputText getDeductiontypebind() {
        return deductiontypebind;
    }

    public void setDeductionnametxnbind(RichInputText deductionnametxnbind) {
        this.deductionnametxnbind = deductionnametxnbind;
    }

    public RichInputText getDeductionnametxnbind() {
        return deductionnametxnbind;
    }

    public void setUnitratebind(RichInputText unitratebind) {
        this.unitratebind = unitratebind;
    }

    public RichInputText getUnitratebind() {
        return unitratebind;
    }

    public void setQuantitybind(RichInputText quantitybind) {
        this.quantitybind = quantitybind;
    }

    public RichInputText getQuantitybind() {
        return quantitybind;
    }

    public void setDeductionamountbind(RichInputText deductionamountbind) {
        this.deductionamountbind = deductionamountbind;
    }

    public RichInputText getDeductionamountbind() {
        return deductionamountbind;
    }

    public void setDebitmemobind(RichInputText debitmemobind) {
        this.debitmemobind = debitmemobind;
    }

    public RichInputText getDebitmemobind() {
        return debitmemobind;
    }

    public void setCurrentSelectedIndex(Integer _currentSelectedIndex) {
        this._currentSelectedIndex = _currentSelectedIndex;
    }

    public Integer getCurrentSelectedIndex() {
        return _currentSelectedIndex;
    }

    public void setDeductiontxnlist(List<deductiontxnPOJO> deductiontxnlist) {
        this.deductiontxnlist = deductiontxnlist;
    }

    public List<deductiontxnPOJO> getDeductiontxnlist() {
        return deductiontxnlist;
    }

    public void setTotaldeductionamountbind(RichOutputText totaldeductionamountbind) {
        this.totaldeductionamountbind = totaldeductionamountbind;
    }

    public RichOutputText getTotaldeductionamountbind() {
        return totaldeductionamountbind;
    }

    public void setTablequantitybind(RichInputText tablequantitybind) {
        this.tablequantitybind = tablequantitybind;
    }

    public RichInputText getTablequantitybind() {
        return tablequantitybind;
    }

    public void setTabledeductionamount(RichInputText tabledeductionamount) {
        this.tabledeductionamount = tabledeductionamount;
    }

    public RichInputText getTabledeductionamount() {
        return tabledeductionamount;
    }

    public void setTableUnitratebind(RichInputText tableUnitratebind) {
        this.tableUnitratebind = tableUnitratebind;
    }

    public void setAddRowbind(RichCommandButton addRowbind) {
        this.addRowbind = addRowbind;
    }

    public RichCommandButton getAddRowbind() {
        return addRowbind;
    }

    public void setSubmitBind(RichCommandButton submitBind) {
        this.submitBind = submitBind;
    }

    public RichCommandButton getSubmitBind() {
        return submitBind;
    }

    public void setCancelBind(RichCommandButton cancelBind) {
        this.cancelBind = cancelBind;
    }

    public RichCommandButton getCancelBind() {
        return cancelBind;
    }

    public void setContractnumBind(RichSelectOneChoice contractnumBind) {
        this.contractnumBind = contractnumBind;
    }

    public RichSelectOneChoice getContractnumBind() {
        return contractnumBind;
    }

    public RichInputText getTableUnitratebind() {
        return tableUnitratebind;
    }

    public void setTableBind(RichSelectOneChoice tableBind) {
        this.tableBind = tableBind;
    }

    public RichSelectOneChoice getTableBind() {
        return tableBind;
    }

    public void setTable_ReadOnly(boolean table_ReadOnly) {
        this.table_ReadOnly = table_ReadOnly;
    }

    public boolean isTable_ReadOnly() {
        return table_ReadOnly;
    }

    public void setTabledeductiontypebind(RichSelectOneChoice tabledeductiontypebind) {
        this.tabledeductiontypebind = tabledeductiontypebind;
    }

    public RichSelectOneChoice getTabledeductiontypebind() {
        return tabledeductiontypebind;
    }

    public void setDeductionnamelist(List<SelectItem> deductionnamelist) {
        this.deductionnamelist = deductionnamelist;
    }

    public List<SelectItem> getDeductionnamelist() {
        return deductionnamelist;
    }

    public void deductionNameValueChange(ValueChangeEvent valueChangeEvent) {
        deductionname = valueChangeEvent.getNewValue().toString();
    }

    public void setDeductionentrytablebindvar(RichTable deductionentrytablebindvar) {
        this.deductionentrytablebindvar = deductionentrytablebindvar;
    }

    public RichTable getDeductionentrytablebindvar() {
        return deductionentrytablebindvar;
    }

    public void setDeductionnamebindvar(RichSelectOneChoice deductionnamebindvar) {
        this.deductionnamebindvar = deductionnamebindvar;
    }

    public RichSelectOneChoice getDeductionnamebindvar() {
        return deductionnamebindvar;
    }

    public void setMonthbind(RichSelectOneChoice monthbind) {
        this.monthbind = monthbind;
    }

    public RichSelectOneChoice getMonthbind() {
        return monthbind;
    }

    public void setYearbind(RichSelectOneChoice yearbind) {
        this.yearbind = yearbind;
    }

    public RichSelectOneChoice getYearbind() {
        return yearbind;
    }

    public void setPERIOD_MONTHLIST(List<SelectItem> _PERIOD_MONTHLIST) {
        this._PERIOD_MONTHLIST = _PERIOD_MONTHLIST;
    }

    public List<SelectItem> getPERIOD_MONTHLIST() {
        if (_PERIOD_MONTHLIST == null) {
            _PERIOD_MONTHLIST = new ArrayList<SelectItem>();
            _PERIOD_MONTHLIST.add(new SelectItem("08", "August"));
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

    public void setAddrecordpopupbindvar(RichPopup addrecordpopupbindvar) {
        this.addrecordpopupbindvar = addrecordpopupbindvar;
    }

    public RichPopup getAddrecordpopupbindvar() {
        return addrecordpopupbindvar;
    }

    public void setDeductionamepopup(RichPopup deductionamepopup) {
        this.deductionamepopup = deductionamepopup;
    }

    public RichPopup getDeductionamepopup() {
        return deductionamepopup;
    }

    public void setNodatasubmitpopup(RichPopup nodatasubmitpopup) {
        this.nodatasubmitpopup = nodatasubmitpopup;
    }

    public RichPopup getNodatasubmitpopup() {
        return nodatasubmitpopup;
    }

    public void setAddrownodatapopup(RichPopup addrownodatapopup) {
        this.addrownodatapopup = addrownodatapopup;
    }

    public RichPopup getAddrownodatapopup() {
        return addrownodatapopup;
    }

    public void setAddrowflag(boolean addrowflag) {
        this.addrowflag = addrowflag;
    }

    public boolean isAddrowflag() {
        return addrowflag;
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

    public void contractnumValueChange(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() == null) {
          reset();
        contractnumVC=false;
        } else {
            
            contractnum = valueChangeEvent.getNewValue().toString();
            String id_version = valueChangeEvent.getNewValue().toString();
            String[] temp = id_version.split("/");
            contractnum = temp[0];
            contractnumVC = true;
            checkValuechange();
        }
    }

    public void deductiontypeValueChange(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() == null) {
            reset();
            deductiontypeVC=false;
        } else {
            deductiontype = valueChangeEvent.getNewValue().toString();
            deductiontypeVC = true;
            checkValuechange();
        }
    }

    public void monthvalueCL(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() == null) {
            reset();
            monthVC=false;
        } else {
            _MONTH = valueChangeEvent.getNewValue().toString();
            monthVC = true;
            if (_YEAR != "" && _MONTH != "") {
                _PERIOD = _MONTH + "-" + _YEAR;
            }
            checkValuechange();
        }
    }

    public void yearvalueCL(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() == null) {
            reset();
            yearVC=false;
        } else {
            _YEAR = valueChangeEvent.getNewValue().toString();
            yearVC = true;
            if (_YEAR != "" && _MONTH != "") {
                _PERIOD = _MONTH + "-" + _YEAR;
            }
            checkValuechange();
        }
    }

    public void checkValuechange() {
        if (contractnumVC == true && deductiontypeVC == true &&
            monthVC == true && yearVC == true){
            String responsejson =
                getalldeductionDetailsData(contractnum, deductiontype,
                                           _PERIOD);
            if (responsejson != "") {
                this.alldeductionDetailsJsonParser(responsejson);
            }
            String deductiondetails_responsejson =
                getdeductionSetupData(contractnum, deductiontype, _PERIOD);
            if (deductiondetails_responsejson != "") {
                this.deductionSetupData_JsonParser(deductiondetails_responsejson);
             }
        } 
        else {
            
        }
    }

    public String getalldeductionDetailsData(String contract_num,
                                             String deduction_type,
                                             String period) {
        String alldeductionDetails_responsejson = "";
        contract_num = contract_num.replaceAll("\\s", "%20");
        deduction_type = deduction_type.replaceAll("\\s", "%20");
        period = period.replaceAll("\\s", "%20");
        restclient rc = new restclient();
        rc.importCertificates();
        try {
            alldeductionDetails_responsejson =
                    rc.RestGETOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/deductiontxnvalues/" +
                                                contract_num + "/" +
                                                deduction_type + "/" +
                                                period));
        } catch (MalformedURLException e) {
            System.out.println(" *** Some error occurred");
        }
        return alldeductionDetails_responsejson;
    }

    public void alldeductionDetailsJsonParser(String jsonresponse) {
        JSONParser parser = new JSONParser();
        deductiontxnlist.clear();
        try {
            JSONObject jsonObject = (JSONObject)parser.parse(jsonresponse);
            JSONArray itemsArray = (JSONArray)jsonObject.get("items");
            if (itemsArray.size() != 0) {
                for (int i = 0; i < itemsArray.size(); i++) {
                    Object itemsArrayObj =
                        parser.parse(itemsArray.get(i).toString());
                    JSONObject jsonArrayObject = (JSONObject)itemsArrayObj;
                    this.deductiontxnlist.add(new deductiontxnPOJO(String.valueOf(jsonArrayObject.get("subcontract_number")),
                                                                   String.valueOf(jsonArrayObject.get("deduction_type")),
                                                                   String.valueOf(jsonArrayObject.get("deduction_name")),
                                                                   String.valueOf(jsonArrayObject.get("unit_rate")),
                                                                   String.valueOf(jsonArrayObject.get("quantity")),
                                                                   String.valueOf(jsonArrayObject.get("deduction_amount")),
                                                                   String.valueOf(jsonArrayObject.get("")),
                                                                   String.valueOf(jsonArrayObject.get("")),
                                                                   String.valueOf(jsonArrayObject.get("period")),
                                                                   String.valueOf(jsonArrayObject.get("total_deduction_amount")),
                                                                   String.valueOf(jsonArrayObject.get("")),
                                                                   String.valueOf(jsonArrayObject.get(""))));
                }
                this.CalculateTotalAmount();
            } else {
                System.out.println("No data found for selected contract number.");
                totaldeductionamountbind.setValue(0);
                AdfFacesContext.getCurrentInstance().addPartialTarget(totaldeductionamountbind);
            }
        } catch (ParseException e) {
            e.getMessage();
        }
    }

    public String getdeductionSetupData(String contract_num,
                                        String deduction_type, String period) {
        String deductionDetails_responsejson = "";
        contract_num = contract_num.replaceAll("\\s", "%20");
        deduction_type = deduction_type.replaceAll("\\s", "%20");
        period = period.replaceAll("\\s", "%20");
        restclient rc = new restclient();
        rc.importCertificates();
        try {
            deductionDetails_responsejson =
                    rc.RestGETOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/deductionsetupvalues/" +
                                                contract_num + "/" +
                                                deduction_type + "/" +
                                                period));
        } catch (MalformedURLException e) {
            System.out.println(" *** Some error occurred");
        }
        return deductionDetails_responsejson;
    }

    public void deductionSetupData_JsonParser(String jsonresponse) {
        JSONParser parser = new JSONParser();
        deductionnamelist.clear();
        try {
            JSONObject jsonObject = (JSONObject)parser.parse(jsonresponse);
            JSONArray itemsArray = (JSONArray)jsonObject.get("items");
            if (itemsArray.size() != 0) {
                for (int i = 0; i < itemsArray.size(); i++) {
                    Object itemsArrayObj =
                        parser.parse(itemsArray.get(i).toString());
                    JSONObject jsonArrayObject = (JSONObject)itemsArrayObj;
                    this.deductionsetuplist.add(new deductionsetupPOJO(String.valueOf(jsonArrayObject.get("subcontract_num")),
                                                                       String.valueOf(jsonArrayObject.get("contract_type")),
                                                                       String.valueOf(jsonArrayObject.get("version")),
                                                                       String.valueOf(jsonArrayObject.get("deduction_type")),
                                                                       String.valueOf(jsonArrayObject.get("deduction_name")),
                                                                       String.valueOf(jsonArrayObject.get("uom")),
                                                                       String.valueOf(jsonArrayObject.get("unit_rate"))));
                    deductionnamelist.add(new SelectItem(String.valueOf(jsonArrayObject.get("deduction_name"))));
                }
            }
            else {
                System.out.println("No data found for selected contract number.");
            }
        } catch (ParseException e) {
            e.getMessage();
        }
    }


    public void addNewRow(ActionEvent actionEvent) {
        if (contractnumVC == true && deductiontypeVC == true &&
            monthVC == true && yearVC == true) {
            addrowflag = true;
            showPopup(this.addrecordpopupbindvar, true);
        } else {
            this.showPopup(addrownodatapopup, true);
        }
    }

    public void addRecordDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().toString() == "ok") {
            Boolean check_deduction_name_status = false;
            String record_json = "";
            for (int j = 0; j < deductiontxnlist.size(); j++) {
                if (deductiontxnlist.get(j).getDeduction_name().equals(deductionname)) {
                    check_deduction_name_status = true;
                }
            }
            if (check_deduction_name_status.equals(true)) {
                this.showPopup(deductionamepopup, true);
                deductionnamebindvar.resetValue();
            } else {
                for (int j = 0; j < this.deductionsetuplist.size(); j++) {
                    if (deductionsetuplist.get(j).getDeduction_name().equals(deductionname)) {

                        deductiontxnlist.add(new deductiontxnPOJO(contractnum,
                                                                  deductiontype,
                                                                  deductionname,
                                                                  deductionsetuplist.get(j).getUnit_Rate().toString(),
                                                                  "0", "0", "",
                                                                  "", _PERIOD,
                                                                  "0", "",
                                                                  ""));
                        CalculateTotalAmount();
                        record_json =
                                "{\"SUBCONTRACT_NUMBER\":\"" + contractnum +
                                "\",\"DEDUCTION_TYPE\":\"" + deductiontype +
                                "\",\"DEDUCTION_NAME\":\"" + deductionname +
                                "\",\"UNIT_RATE\":\"" +
                                deductionsetuplist.get(j).getUnit_Rate().toString() +
                                "\",\"QUANTITY\":\"" + "0" +
                                "\",\"DEDUCTION_AMOUNT\":\"" + "0" +
                                "\",\"MONTH\":\"" + "" +
                                "\",\"DEBIT_MEMO\":\"" + "" +
                                "\",\"DEBIT_MEMO_STATUS\":\"" + "" +
                                "\",\"SUBMITTED_DATE_TIME\":\"" + "" +
                                "\",\"PERIOD\":\"" + _PERIOD +
                                "\",\"PRIMARY_KEY_TXN\":\"" + contractnum +
                                "-" + _PERIOD + "-" + deductiontype + "-" +
                                deductionname + "\",\"PRIMARY_KEY_TTXN\":\"" +
                                contractnum + "-" + _PERIOD + "-" +
                                deductiontype +
                                "\",\"TOTAL_DEDUCTION_AMOUNT\":\"" +
                                totaldeductionamountbind.getValue().toString() +
                                "\"}";

                        System.out.println(record_json);
                        deductionnamebindvar.resetValue();
                        if (Integer.valueOf(totaldeductionamountbind.getValue().toString()) ==
                            0) {
                            System.out.println("insert");
                            insertRecord(record_json);
                        } else {
                            System.out.println("insertupdate");
                            insertUpdateRecord(record_json);
                        }

                        break;
                    }
                }
                AdfFacesContext.getCurrentInstance().addPartialTarget(deductionentrytablebindvar);
            }
        }
    }

    public void insertRecord(String json) {
        try {
            restclient rc = new restclient();
            rc.importCertificates();
            rc.RestPOSTOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/insert_deduction_txn_record/"),
                                 json);
        } catch (MalformedURLException murle) {
            murle.printStackTrace();
        }
    }

    public void insertUpdateRecord(String json) {
        try {
            restclient rc = new restclient();
            rc.importCertificates();
            rc.RestPOSTOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/insertupdate_deduction_txn_record/"),
                                 json);
        } catch (MalformedURLException murle) {
            murle.printStackTrace();
        }
    }

//    public void onCancel(ActionEvent actionEvent) {
//        addRowbind.setDisabled(false);
//        contractnumBind.setValue("");
//        tabledeductiontypebind.resetValue();
//        monthbind.resetValue();
//        yearbind.resetValue();
//        deductiontxnlist.clear();
//        totaldeductionamountbind.setValue(0);
//        addrowflag = false;
//        contractnum = "";
//        deductiontype = "";
//        _PERIOD = "";
//        _MONTH = "";
//        _YEAR = "";
//    }

    public void quantityValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            int quantity =
                Integer.valueOf(valueChangeEvent.getNewValue().toString());
            int currentindex = Integer.valueOf(_currentSelectedIndex);
            String record_json = "";
            String deductionamount =
                String.valueOf(Integer.valueOf(deductiontxnlist.get(currentindex).getUnit_rate()) *
                               quantity);
            deductiontxnlist.get(currentindex).setQuantity(valueChangeEvent.getNewValue().toString());
            deductiontxnlist.get(currentindex).setDeduction_amount(deductionamount);
            CalculateTotalAmount();

            record_json =
                    "{\"QUANTITY\":\"" + quantity + "\",\"DEDUCTION_AMOUNT\":\"" +
                    deductionamount + "\",\"SUBMITTED_DATE_TIME\":\"" + "" +
                    "\",\"PRIMARY_KEY_TXN\":\"" + contractnum + "-" + _PERIOD +
                    "-" + deductiontype + "-" +
                    deductiontxnlist.get(currentindex).getDeduction_name().toString() +
                    "\",\"PRIMARY_KEY_TTXN\":\"" + contractnum + "-" +
                    _PERIOD + "-" + deductiontype +
                    "\",\"TOTAL_DEDUCTION_AMOUNT\":\"" +
                    totaldeductionamountbind.getValue().toString() + "\"}";
            System.out.println(record_json);
            updateRecord(record_json);
            AdfFacesContext.getCurrentInstance().addPartialTarget(deductionentrytablebindvar);
        }
    }

    public void updateRecord(String json) {
        try {
            restclient rc = new restclient();
            rc.importCertificates();
            rc.RestPUTOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/update_deduction_txn_record/"),
                                json);
        } catch (MalformedURLException murle) {
            murle.printStackTrace();
        }
    }

    public void CalculateTotalAmount() {
        int totaldeductionamount = 0;
        for (int i = 0; i < this.deductiontxnlist.size(); i++) {
            totaldeductionamount =
                    totaldeductionamount + Integer.valueOf(deductiontxnlist.get(i).getDeduction_amount());
            System.out.println(deductiontxnlist.get(i).getDeduction_amount());
        }
        totaldeductionamountbind.setValue(totaldeductionamount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(totaldeductionamountbind);
    }

    public void onRowRemoval(ActionEvent actionEvent) {
        int currentindex = this.getCurrentSelectedIndex();
        deductiontxnlist.remove(currentindex);
        this.CalculateTotalAmount();
        AdfFacesContext.getCurrentInstance().addPartialTarget(deductionentrytablebindvar);
    }


//    public void onSubmit(ActionEvent actionEvent) {
//        if (deductiontxnlist.size() != 0) {
//                        try {
//                            Iterator i1 = deductiontxnlist.iterator();
//                            while (i1.hasNext()) {
//                                deductiontxnPOJO val = (deductiontxnPOJO)i1.next();
//                                System.out.println("SubContract Number :" +
//                                                   val.getSubcontract_number());
//                                System.out.println("DEDUCTION TYPE :" +
//                                                   val.getDeduction_type());
//                                System.out.println("DEDUCTION NAME :" +
//                                                   val.getDeduction_name());
//                                System.out.println("UNIT RATE :" + val.getUnit_rate());
//                                System.out.println("QUANTITY :" + val.getQuantity());
//                                System.out.println("DEDUCTION AMOUNT :" +
//                                                   val.getDeduction_amount());
//                                System.out.println("MONTH :" + val.getMonth());
//                                System.out.println("DEBIT MEMO :" + val.getDebit_memo());
//                                System.out.println("PERIOD :" + val.getPeriod());
//                                System.out.println("Total DEDUCTION AMOUNT :" +
//                                                   totaldeductionamountbind.getValue().toString());
//                                System.out.println("DEBIT_MEMO_STATUS :" +
//                                                   val.getDebit_memo_status());
//            
//                            }
//                            for (int i = 0; i < deductiontxnlist.size(); i++) {
//                                TXN_JSON_ARRAY =
//                                        TXN_JSON_ARRAY + "{\"SUBCONTRACT_NUMBER\":\"" +
//                                        deductiontxnlist.get(i).getSubcontract_number() +
//                                        "\",\"DEDUCTION_TYPE\":\"" +
//                                        deductiontxnlist.get(i).getDeduction_type() +
//                                        "\",\"DEDUCTION_NAME\":\"" +
//                                        deductiontxnlist.get(i).getDeduction_name() +
//                                        "\",\"UNIT_RATE\":\"" +
//                                        deductiontxnlist.get(i).getUnit_rate() +
//                                        "\",\"QUANTITY\":\"" +
//                                        deductiontxnlist.get(i).getQuantity() +
//                                        "\",\"DEDUCTION_AMOUNT\":\"" +
//                                        deductiontxnlist.get(i).getDeduction_amount() +
//                                        "\",\"DEBIT_MEMO\":\"" +
//                                        deductiontxnlist.get(i).getDebit_memo() +
//                                        "\",\"PERIOD\":\"" +
//                                        deductiontxnlist.get(i).getPeriod() +
//                                        "\",\"DEBIT_MEMO_STATUS\":\"" +
//                                        deductiontxnlist.get(i).getDebit_memo_status() +
//                                        "\",\"SUBMITTED_DATE_TIME\":\"" +
//                                        deductiontxnlist.get(i).getSubmitted_date_time() +
//                                        "\"},";
//                            }
//                            System.out.println("TXN_JSON_ARRAY : " + TXN_JSON_ARRAY);
//                            TXN_JSON_ARRAY =
//                                    TXN_JSON_ARRAY.substring(0, TXN_JSON_ARRAY.length() -
//                                                             1);
//                            FINAL_TXN_JSON = "{\"txn\":[" + TXN_JSON_ARRAY + "]}";
//                            System.out.println("Deduction Transaction JSON : " +
//                                               FINAL_TXN_JSON);
//            
//                            for (int i = 0; i < deductiontxnlist.size(); i++) {
//                                TXN_TAMOUNT_JSON_ARRAY =
//                                        TXN_TAMOUNT_JSON_ARRAY + "{\"SUBCONTRACT_NUMBER\":\"" +
//                                        deductiontxnlist.get(i).getSubcontract_number() +
//                                        "\",\"DEDUCTION_TYPE\":\"" +
//                                        deductiontxnlist.get(i).getDeduction_type() +
//                                        "\",\"PERIOD\":\"" +
//                                        deductiontxnlist.get(i).getPeriod() +
//                                        "\",\"TOTAL_DEDUCTION_AMOUNT\":\"" +
//                                        totaldeductionamountbind.getValue().toString() +
//                                        "\",\"DEBIT_MEMO\":\"" +
//                                        deductiontxnlist.get(i).getDebit_memo() +
//                                        "\",\"SUBMITTED_DATE_TIME\":\"" +
//                                        deductiontxnlist.get(i).getSubmitted_date_time() +
//                                        "\"},";
//                            }
//                            System.out.println("TXN_TAMOUNT_JSON_ARRAY : " +
//                                               TXN_TAMOUNT_JSON_ARRAY);
//                            TXN_TAMOUNT_JSON_ARRAY =
//                                    TXN_TAMOUNT_JSON_ARRAY.substring(0, TXN_TAMOUNT_JSON_ARRAY.length() -
//                                                                     1);
//                            FINAL_TAMOUNT_JSON_ARRAY =
//                                    "{\"txnamt\":[" + TXN_TAMOUNT_JSON_ARRAY + "]}";
//                            System.out.println("Total Deduction Amount JSON : " +
//                                               FINAL_TAMOUNT_JSON_ARRAY);
//            
//                            restclient rc = new restclient();
//                            rc.importCertificates();
//                            rc.RestPOSTOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/deductiontxn/"),
//                                                 FINAL_TXN_JSON);
//            
//                            rc.RestPOSTOperation(new URL("https://apex-a423930.db.em2.oraclecloudapps.com/apex/fsa_sc_webservices/txntotatdeductionamount/"),
//                                                 FINAL_TAMOUNT_JSON_ARRAY);
//            
//                            table_ReadOnly = false;
//            
//                        } catch (MalformedURLException e) {
//                            System.out.println("Error Occurred");
//                        }
//        } else if (deductiontxnlist.size() == 0) {
//            System.out.println("NO DATA");
//            this.showPopup(nodatasubmitpopup, true);
//        }
//        addrowflag = false;
//        deductiontxnlist.clear();
//        totaldeductionamountbind.setValue(0);
//        contractnumBind.setDisabled(false);
//        contractnumBind.setValue("");
//        tabledeductiontypebind.resetValue();
//        monthbind.resetValue();
//        yearbind.resetValue();
//    }

public void reset() {
    deductiontxnlist.clear();
    totaldeductionamountbind.setValue(0);
    AdfFacesContext.getCurrentInstance().addPartialTarget(totaldeductionamountbind);
}

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
}


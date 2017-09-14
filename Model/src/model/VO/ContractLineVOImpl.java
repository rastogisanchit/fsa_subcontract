package model.VO;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import model.beans.ServiceClientImpl;

import model.pojo.ContractLinePOJO;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 22 11:45:13 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ContractLineVOImpl extends ViewObjectImpl {

    //Array List to store Contrat_Line Information using POJO class
    private List<ContractLinePOJO> contractlineList =
        new ArrayList<ContractLinePOJO>();
    ServiceClientImpl sci;

    /**
     * This is the default constructor (do not remove).
     */
    public ContractLineVOImpl() {
        sci = new ServiceClientImpl();
    }

    /**
     * executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object[] params,
                                             int noUserParams) {
        if (getcl_parameterbind() == 1) {
            System.out.println("getcl_cntrctidbind : " + getcl_cntrctidbind() +
                               " || getcl_cntrctversionbind : " +
                               getcl_cntrctversionbind());
            contractlineList =
                    sci.getContractLines(getcl_cntrctidbind(), getcl_cntrctversionbind());
            //System.out.println("Boqnumber : " + contractlineList.get(0).getBoqnumber());
            setFetchIndex(qc, 0);
            super.executeQueryForCollection(qc, params, noUserParams);
        }
    }

    /**
     * hasNextForCollection - overridden for custom java data source support.
     */
    protected boolean hasNextForCollection(Object qc) {
        return getFetchIndex(qc) < contractlineList.size();
    }

    /**
     * createRowFromResultSet - overridden for custom java data source support.
     */
    protected ViewRowImpl createRowFromResultSet(Object qc,
                                                 ResultSet resultSet) {
        int curIndex = getFetchIndex(qc);
        ContractLineVORowImpl contractlinerow =
            (ContractLineVORowImpl)createNewRowForCollection(qc);
        contractlinerow.setBoqNumber(contractlineList.get(curIndex).getBoqnumber());
        contractlinerow.setBoqDescription(contractlineList.get(curIndex).getBoqdescription());
        contractlinerow.setUnitOfMeasure(contractlineList.get(curIndex).getUnitofmeasure());
        contractlinerow.setQuantity(contractlineList.get(curIndex).getQuantity());
        contractlinerow.setRate(contractlineList.get(curIndex).getRate());
        contractlinerow.setAmount(contractlineList.get(curIndex).getAmount());
        contractlinerow.setContractNumber(contractlineList.get(curIndex).getContractnumber());
        contractlinerow.setSupplier(contractlineList.get(curIndex).getSupplier());
        contractlinerow.setSupplierSiteName(contractlineList.get(curIndex).getSupplierSiteName());
        setFetchIndex(qc, curIndex + 1);
        return contractlinerow;
    }

    /**
     * getQueryHitCount - overridden for custom java data source support.
     */
    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
        long value = super.getQueryHitCount(viewRowSet);
        return value;
    }

    @Override
    public long getCappedQueryHitCount(ViewRowSetImpl viewRowSetImpl,
                                       Row[] row, long l, long l2) {
        long value = super.getCappedQueryHitCount(viewRowSetImpl, row, l, l2);
        return value;
    }

    private void setFetchIndex(Object rowset, int index) {
        if (index == contractlineList.size()) {
            setFetchCompleteForCollection(rowset, true);
        }
        setUserDataForCollection(rowset, new Integer(index));
    }

    private int getFetchIndex(Object rowset) {
        int value = ((Integer)getUserDataForCollection(rowset)).intValue();
        return value;
    }

    /**
     * Returns the bind variable value for cl_parameterbind.
     * @return bind variable value for cl_parameterbind
     */
    public Integer getcl_parameterbind() {
        return (Integer)getNamedWhereClauseParam("cl_parameterbind");
    }

    /**
     * Sets <code>value</code> for bind variable cl_parameterbind.
     * @param value value to bind as cl_parameterbind
     */
    public void setcl_parameterbind(Integer value) {
        setNamedWhereClauseParam("cl_parameterbind", value);
    }

    /**
     * Returns the variable value for cl_cntrctidbind.
     * @return variable value for cl_cntrctidbind
     */
    public String getcl_cntrctidbind() {
        return (String)ensureVariableManager().getVariableValue("cl_cntrctidbind");
    }

    /**
     * Sets <code>value</code> for variable cl_cntrctidbind.
     * @param value value to bind as cl_cntrctidbind
     */
    public void setcl_cntrctidbind(String value) {
        ensureVariableManager().setVariableValue("cl_cntrctidbind", value);
    }

    /**
     * Returns the variable value for cl_cntrctversionbind.
     * @return variable value for cl_cntrctversionbind
     */
    public String getcl_cntrctversionbind() {
        return (String)ensureVariableManager().getVariableValue("cl_cntrctversionbind");
    }

    /**
     * Sets <code>value</code> for variable cl_cntrctversionbind.
     * @param value value to bind as cl_cntrctversionbind
     */
    public void setcl_cntrctversionbind(String value) {
        ensureVariableManager().setVariableValue("cl_cntrctversionbind",
                                                 value);
    }

    /**
     * Returns the variable value for cl_amountbind.
     * @return variable value for cl_amountbind
     */
   
}

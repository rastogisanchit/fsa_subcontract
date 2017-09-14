package model.VO;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import model.beans.ServiceClientImpl;

import model.pojo.ContractIdPOJO;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 22 11:49:45 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ContractNumberVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */

    private List<ContractIdPOJO> contractnumberlist =
        new ArrayList<ContractIdPOJO>();
    ServiceClientImpl sci;

    public ContractNumberVOImpl() {
        sci = new ServiceClientImpl();
    }

    /**
     * executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object[] params,
                                             int noUserParams) {
        contractnumberlist = sci.getContractNumbers();
        setFetchIndex(qc, 0);
        super.executeQueryForCollection(qc, params, noUserParams);
    }

    /**
     * hasNextForCollection - overridden for custom java data source support.
     */
    protected boolean hasNextForCollection(Object qc) {
        return getFetchIndex(qc) < contractnumberlist.size();
    }

    /**
     * createRowFromResultSet - overridden for custom java data source support.
     */
    protected ViewRowImpl createRowFromResultSet(Object qc,
                                                 ResultSet resultSet) {
        int curIndex = getFetchIndex(qc);
        ContractNumberVORowImpl contractnumberrow =
            (ContractNumberVORowImpl)createNewRowForCollection(qc);
        contractnumberrow.setContractNumber(contractnumberlist.get(curIndex).getContractnumber());
        contractnumberrow.setContractId(contractnumberlist.get(curIndex).getContractid());
        setFetchIndex(qc, curIndex + 1);
        return contractnumberrow;
    }


    /**
     * getQueryHitCount - overridden for custom java data source support.
     */
    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
        long value = super.getQueryHitCount(viewRowSet);
        return value;
    }

    public long getCappedQueryHitCount(ViewRowSetImpl viewRowSetImpl,
                                       Row[] row, long l, long l2) {
        long value = super.getCappedQueryHitCount(viewRowSetImpl, row, l, l2);
        return value;
    }

    private void setFetchIndex(Object rowset, int index) {
        if (index == contractnumberlist.size()) {
            setFetchCompleteForCollection(rowset, true);
        }
        setUserDataForCollection(rowset, new Integer(index));
    }

    private int getFetchIndex(Object rowset) {
        int value = ((Integer)getUserDataForCollection(rowset)).intValue();
        return value;
    }
}
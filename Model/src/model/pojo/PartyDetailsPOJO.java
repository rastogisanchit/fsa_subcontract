package model.pojo;

public class PartyDetailsPOJO {
    private String partyid;
    private String partyname;
    private String partynumber;
    
    public PartyDetailsPOJO() {
        super();
    }

    public PartyDetailsPOJO(String partyid, String partyname,
                            String partynumber) {
        super();
        this.partyid = partyid;
        this.partyname = partyname;
        this.partynumber = partynumber;
    }

    public void setPartyid(String partyid) {
        this.partyid = partyid;
    }

    public String getPartyid() {
        return partyid;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartynumber(String partynumber) {
        this.partynumber = partynumber;
    }

    public String getPartynumber() {
        return partynumber;
    }
    }

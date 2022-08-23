package sample;

import java.io.Serializable;

public class DefaultMember implements Serializable {

    private String membershipID;
    private String membershipName;
    private Date membershipDate;

    public DefaultMember(){};

    public DefaultMember(String membershipID,String membershipName,Date membershipDate){
        super();
        this.membershipID = membershipID;
        this.membershipName = membershipName;
        this.membershipDate = membershipDate;
    }

    public String getMembershipID() {
        return membershipID;
    }
    public void setMembershipID(String membershipID) {
        this.membershipID = membershipID;
    }
    public String getMembershipName() {
        return membershipName;
    }
    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }
    public Date getMembershipDate() {
        return membershipDate;
    }
    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }
}

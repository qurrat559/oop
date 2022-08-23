package sample;

import java.util.List;

public interface GymManager {
    public void addMember (DefaultMember member);
    public boolean deleteMember (String membershipNumber);
    public void print();
    public void save();
    public void openGui();
    public List<DefaultMember> getMemberList();
    public DefaultMember getMemberbyMembershipNumber(String MembershipNumber);
    public DefaultMember getMemberbyName (String name);
}

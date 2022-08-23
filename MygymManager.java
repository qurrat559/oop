package sample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MygymManager implements GymManager{
    //add member list to array
    private List<DefaultMember> memberList = new ArrayList<>();

    @Override
    public void addMember(DefaultMember member) {
        if (memberList.size() < 100) {
            memberList.add(member);
        } else {
            System.out.println("No free spaces are available in new member.");
        }
        System.out.println("Number of occupied slots: " + memberList.size());
        System.out.println("Number of free slots: " + (100 - memberList.size()));

    }

    @Override
    public boolean deleteMember(String membershipNumber) {
        boolean flag = false;
        for (DefaultMember member : memberList) {
            if (member.getMembershipID().equals(membershipNumber)) {
                flag = true;
                memberList.remove(member);
                System.out.println("Member and membership number" + membershipNumber + " " + "successfully removed");
                System.out.println("Number of occupied slots:" + memberList.size());
                System.out.println("Number of free slots:" + (100 - memberList.size()));

                if (member instanceof StudentMember) {
                    System.out.println("Membership type: StudentMember");
                } else if (member instanceof Over60Member) {
                    System.out.println("Membership type: over60member");
                } else {
                    System.out.println("Membership type: defaultMember");
                }
            }
            break;
        }

        if (!flag) {
            System.out.println("Not found");
        }
        return flag;
    }

    @Override
    public void print() {
        for (DefaultMember member : memberList) {
            System.out.println("Membership number:" + member.getMembershipID());
            if (member instanceof StudentMember) {
                System.out.println("Membership type: StudentMember");
            } else if (member instanceof Over60Member)
            {
                System.out.println("Membership type: Over60Member");
            } else {
                System.out.println("Membership type: DefaultMember");

            }
            System.out.println("Name :" + member.getMembershipName() + " ");
            System.out.println("Membership start date:" + member.getMembershipDate());
        }
        if (memberList.size() == 0) {
            System.out.println("Empty List");
        }
    }

    @Override
    public void save() {
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("gym.txt"));
            for(int k=0;k<memberList.size();k++){
                DefaultMember writeGet = memberList.get(k);
                objectOutputStream.writeObject(writeGet);

                System.out.println("File save Successfully.");

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void openGui() {
        GUI gui = new GUI();
        gui.window.show();
    }


    @Override
    public List<DefaultMember> getMemberList() {
        return null;
    }

    @Override
    public DefaultMember getMemberbyMembershipNumber(String MembershipNumber) {
        return null;
    }

    @Override
    public DefaultMember getMemberbyName(String name) {
        return null;
    }
}

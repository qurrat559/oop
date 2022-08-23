package sample;

public class StudentMember extends DefaultMember{
    private String SchoolName;

    public StudentMember(String membershipID, String membershipName, Date membershipDate, String SchoolName){
        super(membershipID,membershipName,membershipDate);
        this.SchoolName = SchoolName;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }
}

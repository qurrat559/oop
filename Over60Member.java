package sample;

public class Over60Member extends DefaultMember{
    private int age;

    public Over60Member(String membershipID, String membershipName, Date membershipDate, int age) {

        super(membershipID, membershipName, membershipDate);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAccessException {
        if (age >= 60) {
            this.age = age;
        } else {
            throw new IllegalAccessException("Invalid age to add over 60 members");
        }
    }
}

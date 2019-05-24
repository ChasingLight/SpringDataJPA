package orika;

public class DestStu {
    private String stuName;
    private String stuHobby;
    private String stuId;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuHobby() {
        return stuHobby;
    }

    public void setStuHobby(String stuHobby) {
        this.stuHobby = stuHobby;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {
        return "DestStu{" +
                "stuName='" + stuName + '\'' +
                ", stuHobby='" + stuHobby + '\'' +
                ", stuId='" + stuId + '\'' +
                '}';
    }
}

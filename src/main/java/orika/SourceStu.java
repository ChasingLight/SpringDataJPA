package orika;

public class SourceStu {
    private String stuName;
    private String stuHobby;
    private String stuId;

    public SourceStu(String stuName, String stuHobby, String stuId) {
        this.stuName = stuName;
        this.stuHobby = stuHobby;
        this.stuId = stuId;
    }

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
}

package jdk.treeSetHashSet;

import java.util.Objects;

public class TerminalUserVo {

    private Long userId;

    private String userName;
    private String userMobile;

    public TerminalUserVo(){}

    public TerminalUserVo(Long userId, String userName, String userMobile){
        this.userId = userId;
        this.userName = userName;
        this.userMobile = userMobile;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Override
    public String toString() {
        return "TerminalUserVo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminalUserVo that = (TerminalUserVo) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId);
    }
}

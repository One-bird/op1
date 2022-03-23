package cn.zjf.online_xd.model.request;

/**
 * @author OneBird
 * @date 2022/3/19 16:45
 **/
public class LoginRequest {
    private String pwd;
    private Integer phone;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public LoginRequest(String pwd, Integer phone) {
        this.pwd = pwd;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "pwd='" + pwd + '\'' +
                ", phone=" + phone +
                '}';
    }
}

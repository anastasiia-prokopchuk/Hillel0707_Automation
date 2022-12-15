package lessons.lesson31;

public class SuccessUserReg {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    private String token;

    public SuccessUserReg(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessUserReg() {

    }
}

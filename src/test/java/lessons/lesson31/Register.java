package lessons.lesson31;

public class Register {
    public Register(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Register(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private String email;
    private String password;


}

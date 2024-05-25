package RestAssured.Misc.POJO;

public class AuthPayload {

    private String username;
    private String password;

    //Right Click and take generate and select constructor with no selection

    public AuthPayload() {
    }

    //Right Click and take generate and select getter setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwqord) {
        this.password = passwqord;
    }
}


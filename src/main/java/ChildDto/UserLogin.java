package ChildDto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserLogin {

    @Length(min = 8, max=20)
    @NotBlank
    private String Username;
    @Length(min = 8, max=20)
    @NotBlank
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

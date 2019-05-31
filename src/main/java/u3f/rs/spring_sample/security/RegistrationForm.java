package u3f.rs.spring_sample.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import u3f.rs.spring_sample.security.entity.Authority;
import u3f.rs.spring_sample.security.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Arrays;

public class RegistrationForm {

    @Size(min = 5, message = "نام کاربری باید شامل حداقل ۵ کاراکتر باشد.")
    private String username;

    @Email(message = "ایمیل معتبر نیست.")
    private String email;

    @Size(min = 8, message = "گذرواژه باید شامل حداقل ۸ کاراکتر باشد.")
    private String password;

    public RegistrationForm(){}

    public RegistrationForm(@Size(min = 3) String username, @Email String email, @Size(min = 8) String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser(PasswordEncoder encoder){
        User user = new User(username,email,encoder.encode(password),true,null, Arrays.asList(Authority.USER));
        return user;
    }
}

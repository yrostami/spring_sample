package u3f.rs.spring_sample.security.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_id_seq",allocationSize = 1)
    private long id;

    @NotEmpty
    @Column(nullable = false, unique=true)
    private String username;

    @Email
    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @CreationTimestamp
    @Column(name = "creation_time")
    private Timestamp creationTime;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(joinColumns = @JoinColumn(name="user_id"))
    private List<Authority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public List<Authority> authorityList(){
        return authorities;
    }

    private User(){}

    public User(@NotEmpty String username, @Email String email, @NotEmpty String password, boolean enabled, Timestamp creationTime, List<Authority> authorities) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.creationTime = creationTime;
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "\nid=" + id +
                "\n, username='" + username + '\'' +
                "\n, email='" + email + '\'' +
                "\n, password='" + password + '\'' +
                "\n, enabled=" + enabled +
                "\n, creationTime=" + creationTime +
                "\n, authorities=" + authorities +
                '}';
    }
}

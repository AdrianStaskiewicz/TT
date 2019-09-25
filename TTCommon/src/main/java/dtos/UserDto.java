package dtos;

import entities.*;
import enums.Language;
import enums.Location;
import enums.TimeZone;
import enums.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String displayName;
    private String email;
    private String login;
    private String password;
    private Boolean status;
    private UserType type;
    private Company company;
    private Language language;
    private Location location;
    private TimeZone timeZone;
    private Date registeredDate;
    private Date lastActivityDate;

    public UserDto(User user) {
        this.id = user.getId();
        this.displayName = user.getDisplayName();
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.type = user.getType();
        this.company = user.getCompany();
        this.language = user.getLanguage();
        this.location = user.getLocation();
        this.timeZone = user.getTimeZone();
        this.registeredDate = user.getRegisteredDate();
        this.lastActivityDate = user.getLastActivityDate();
    }

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setDisplayName(this.displayName);
        user.setEmail(this.email);
        user.setLogin(this.login);
        user.setPassword(this.password);
        user.setStatus(this.status);
        user.setType(this.type);
        user.setCompany(this.company);
        user.setLanguage(this.language);
        user.setLocation(this.location);
        user.setTimeZone(this.timeZone);
        user.setRegisteredDate(this.registeredDate);
        user.setLastActivityDate(this.lastActivityDate);
        return user;
    }
}

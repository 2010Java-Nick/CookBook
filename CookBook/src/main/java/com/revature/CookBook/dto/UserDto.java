package com.revature.CookBook.dto;

import com.revature.CookBook.pojos.Authorization;
import com.revature.CookBook.pojos.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Dto<User> {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String authorization;

    public UserDto(User user) {
        super();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.authorization = user.getAuthorization().getLevel();
    }

    @Override
    public User toPojo() {
        User user = new User();
        user.setUsername(this.getUsername());
        user.setPassword(this.getPassword());
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());

        Authorization auth = new Authorization();

        switch (this.getAuthorization()){

            case "STANDARD":
                auth.setId(1);
                auth.setLevel("STANDARD");
                break;

            case "AFFILIATED":
                auth.setId(2);
                auth.setLevel("AFFILIATED");
                break;

            case "MODERATOR":
                auth.setId(3);
                auth.setLevel("MODERATOR");
                break;

            default:
                auth.setId(0);
                auth.setLevel("ERROR");
        }

        user.setAuthorization(auth);
        return user;
    }
}

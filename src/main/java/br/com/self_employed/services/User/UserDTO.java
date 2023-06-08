package br.com.self_employed.services.User;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import br.com.self_employed.models.Entity.UserModel;
import br.com.self_employed.models.Enum.RoleEnum;
import br.com.self_employed.utils.GeneralUtilities;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull @NotEmpty @Email String name, @NotNull @NotEmpty @Email String email,
        @NotNull @NotEmpty @Length(min = 5, max = 15) String username,
        @NotNull @NotEmpty String password, @NotNull @NotEmpty @Email String location,
        @NotNull @NotEmpty @Email String biography) {
    public UserModel addCustomer(UserDTO userDTO) {
        LocalDateTime now = LocalDateTime.now();
        return new UserModel(null,
                this.name,
                this.email,
                this.username,
                this.password,
                this.location,
                this.biography,
                now,
                now,
                RoleEnum.COSTUMER);
    }

    public UserModel addStaff(UserDTO userDTO) {
        return new UserModel(null, this.name, this.email, this.username, GeneralUtilities.encode(this.password),
                this.location, this.biography, LocalDateTime.now(), LocalDateTime.now(), RoleEnum.STAFF);
    }
}

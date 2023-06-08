package br.com.self_employed.services.User;

import org.springframework.data.domain.Page;

import br.com.self_employed.models.Entity.UserModel;

public interface UserService {
    Page<UserModel> getUser(int page, int size);
    UserModel postUser(UserDTO userDTO, String role);
    UserModel getUser(String username);
}

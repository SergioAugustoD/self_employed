package br.com.self_employed.services.User;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.self_employed.models.Entity.UserModel;
import br.com.self_employed.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public Page<UserModel> getUser(int page, int size) {
        return userRepo.findAll(PageRequest.of(page, size));
    }

    @Override
    public UserModel postUser(UserDTO userDTO, String role) {
        UserModel user;
        if (role.equals("STAFF")) {
            user = userDTO.addStaff(userDTO);
        } else {
            user = userDTO.addCustomer(userDTO);
        }
        return userRepo.save(user);
    }

    @Override
    public UserModel getUser(String username) {
        Optional<UserModel> userOptional = userRepo.findByUsername(username);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new NoSuchElementException("User not found!");
    }

}
package br.com.self_employed.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.self_employed.models.Entity.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{
	Optional<UserModel> findByUsername(String username);
	Optional<UserModel> findByEmail(String email);
}

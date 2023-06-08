package br.com.self_employed.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(
		@NotBlank String name,
		@NotBlank String email,
		@NotBlank String password,
		@NotBlank String location, 
		String biography) {
	
}

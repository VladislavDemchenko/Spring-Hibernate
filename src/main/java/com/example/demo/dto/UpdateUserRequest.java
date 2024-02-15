package com.example.demo.dto;

import com.example.demo.entity.exemole1.Person;
import jakarta.validation.Valid;

public record UpdateUserRequest(Long id, @Valid Person user) {
}

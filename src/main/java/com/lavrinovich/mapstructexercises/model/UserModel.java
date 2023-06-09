package com.lavrinovich.mapstructexercises.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    private Long id;
    private String fullName;
    private String password;

    private String countryName;
}

package com.lavrinovich.mapstructexercises.mapper;

import com.lavrinovich.mapstructexercises.entity.User;
import com.lavrinovich.mapstructexercises.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    protected String secret = "secret";
    @Mapping(target = "fullName", expression = "java(String.format(\"%s %s\", user.getName(), user.getSurname()))")
    @Mapping(target = "password", expression = "java(user.getPassword() + secret)")
    public abstract UserModel mapToModel (User user);
    public abstract User mapToEntity (UserModel userModel);

}

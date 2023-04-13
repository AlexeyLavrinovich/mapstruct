package com.lavrinovich.mapstructexercises.mapper;

import com.lavrinovich.mapstructexercises.entity.User;
import com.lavrinovich.mapstructexercises.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    protected String secret = "secret";
    @Mapping(target = "fullName", expression = "java(user.getName() + ' ' + user.getSurname())")
    @Mapping(target = "password", expression = "java(user.getPassword() + secret)")
    public abstract UserModel mapToModel (User user);
    public abstract User mapToEntity (UserModel userModel);

}

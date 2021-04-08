package com.spmvc.springmvcdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
public class Login {
    private String emailId;
    private String password;
}

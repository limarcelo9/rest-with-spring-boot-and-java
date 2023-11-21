package com.core.domain;

import lombok.Data;

@Data
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
}

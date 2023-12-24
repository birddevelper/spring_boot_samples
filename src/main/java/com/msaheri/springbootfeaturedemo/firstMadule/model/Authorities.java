package com.msaheri.springbootfeaturedemo.firstMadule.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Authorities {

    @Id
    private String username;
    private String authority;
}

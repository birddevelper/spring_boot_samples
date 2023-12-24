package com.msaheri.springbootfeaturedemo.firstMadule.model;

import lombok.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private float credit;
    @NonNull
    private float debit;
    @NonNull
    private String description;

    @Version
    private int version;

}


package com.fatec.WBClients.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String telephone;
    private String birthdate;
    private String gender;

    public UserAccount(UserAccount userAccount) {
        this.id = userAccount.getId();
        this.name = userAccount.getName();
        this.telephone = userAccount.getTelephone();
        this.birthdate = userAccount.getBirthdate();
        this.gender = userAccount.getGender();
    }
}

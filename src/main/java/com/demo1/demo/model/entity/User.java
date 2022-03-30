package com.demo1.demo.model.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "banking_core_user")
public class User {
    @SequenceGenerator(name="userIdSeqGen",sequenceName = "userIdSeq",initialValue=10000,allocationSize = 1)
    @Id
    @GeneratedValue( generator = "userIdSeqGen")

    private Long id;

    @NotNull
    @Size(max=40)
    @Pattern(regexp="[a-zA-Z0-9]+")
    private String name;

    @NotNull
    @Size(max=100)
    @Email
    private String email;

    @NotNull
    @Size(max=10)
    private String mobileNumber;

    @Size(max=10)
    private String secondaryNumber;

    @NotNull
    @Size(max=10)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "DD/MM/YYYY")
    private String dob;

    @NotNull
    @Size(max=1)
    private String gender;

      @OneToMany(mappedBy = "userId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
       private List<Account> accounts;

}


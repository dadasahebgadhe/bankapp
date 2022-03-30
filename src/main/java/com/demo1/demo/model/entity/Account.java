package com.demo1.demo.model.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "banking_core_account")
public class Account {
  @SequenceGenerator(name="accIdSeqGen",sequenceName = "accountIdSeq",initialValue=1000,allocationSize = 1)
  @Id
  @GeneratedValue( generator = "accIdSeqGen")
  private Long accId;

  //@Pattern(regexp = "[10000-99999]")
   @NotNull
   private Long userId;

    @NotNull
    @Size(min=3,max=40)
    private String branch;

    @NotNull
    @Size(max=7)
    private String type;

    @NotNull
    @Positive
    private double balance;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

}
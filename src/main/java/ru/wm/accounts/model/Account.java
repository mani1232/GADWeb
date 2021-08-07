package ru.wm.accounts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  @NotBlank(message = "Login could not be empty")
  String login;

  @NotBlank(message = "Password could not be empty")
  String password;

  @NotBlank(message = "Mail could not be empty")
  String mail;

  @NotBlank(message = "Password of mail could not be empty")
  String mailPassword;
}

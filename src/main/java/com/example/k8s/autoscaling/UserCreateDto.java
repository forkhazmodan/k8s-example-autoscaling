package com.example.k8s.autoscaling;

public class UserCreateDto {
  private final String firstName;
  private final String lastName;
  private final String password;
  private final String repeatPassword;

  public UserCreateDto(String firstName, String lastName, String password, String repeatPassword) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.repeatPassword = repeatPassword;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPassword() {
    return password;
  }

  public String getRepeatPassword() {
    return repeatPassword;
  }
}

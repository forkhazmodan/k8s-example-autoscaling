package com.example.k8s.autoscaling;

public class UserDto {
  private final Long id;
  private final String firstName;
  private final String lastName;

  public UserDto(Long id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}

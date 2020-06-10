package com.company;

class Contact {
  private String name;
  private String phone;

  public Contact(String name, String phone) {
    if (name.length() == 0) this.name = "UNKOWN";
    this.name = name;
    this.phone = phone;
  }

  public String getName() { return this.name; }
  public String getPhone() { return this.phone; }
}
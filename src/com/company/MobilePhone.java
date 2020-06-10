package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class MobilePhone {
  private final ArrayList<Contact> contacts = new ArrayList<>();

  public void startPhone() {
    int choice;
    boolean isTurnedOn = true;
    while (isTurnedOn) {
      choice = makeChoice();

      switch (choice) {
        case 1 -> printContacts();
        case 2 -> addContact();
        case 3 -> updateContact();
        case 4 -> removeContact();
        case 0 -> {
          System.out.println("Thank you for using the phone application service!");
          isTurnedOn = false;
        }
      }
    }
  }

  private int makeChoice() {
    System.out.println(
      "\n1. Print all contacts\n2. Add a contact\n3. Update contact\n4. Remove contact\n0. Exit Application"
    );
    System.out.print("Please enter your choice: ");
    Scanner in = new Scanner(System.in);
    return in.nextInt();
  }

  public void printContacts() {
    if (contacts.size() == 0) System.out.println("\nNo contacts are in the list");
    else {
      System.out.println();
      for (Contact contact : contacts)
        System.out.println(contact.getName() + " --> " + contact.getPhone());
    }
  }

  public void addContact() {
    System.out.print("\nEnter the contact's name: ");
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();

    System.out.print("Enter the contact's number: ");
    String number = in.nextLine();

    Contact newContact = new Contact(name, number);

    this.contacts.add(newContact);
    System.out.println("The new contact " + newContact.getName() + " was added to a list.");
  }

  public void updateContact() {
    System.out.print("\nPlease enter contact's phone number: ");
    Scanner in = new Scanner(System.in);
    String phoneNumber = in.nextLine();

    if (phoneNumber.length() == 0) System.out.println("Please enter a full phone number");

    int contactIndex = -1;
    boolean containsContact = false;
    for (int i = 0; i < contacts.size(); i++) {
      Contact currentContact = contacts.get(i);
      if (currentContact.getPhone().matches(phoneNumber)) {
        contactIndex = i;
        containsContact = true;
        break;
      }
    }

    if (containsContact) {
      System.out.print("Enter a new name: ");
      String newName = in.nextLine();
      System.out.print("Enter a new phone: ");
      String newPhone = in.nextLine();
      Contact updatedContact = new Contact(newName, newPhone);
      contacts.set(contactIndex, updatedContact);
      System.out.println("Contact updated successfully!");
    } else System.out.println("Contact is not found...");
  }

  public void removeContact() {
    System.out.print("Please enter contact's phone number: ");
    Scanner in = new Scanner(System.in);
    String phoneNumberToRemove = in.nextLine();

    if (phoneNumberToRemove.length() == 0) System.out.println("Please enter a full phone number");

    boolean contactExists = false;
    int contactIndex = -1;
    for (int i = 0; i < contacts.size(); i++) {
      Contact contact = contacts.get(i);
      if (contact.getPhone().matches(phoneNumberToRemove)) {
        contactExists = true;
        contactIndex = i;
      }
    }

    if (contactExists) {
      contacts.remove(contactIndex);
      System.out.println("Contact was successfully removed!");
    } else System.out.println("Contact is not found...");
  }
}
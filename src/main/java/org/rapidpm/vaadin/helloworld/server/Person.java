package org.rapidpm.vaadin.helloworld.server;

import org.rapidpm.frp.model.Quad;

public class Person extends Quad<Integer, String, String, String> {


  public Person(int id, String firstName, String lastName, String email) {
    super(id, firstName, lastName, email);

  }

  public int id() {
    return getT1();
  }

  public String firstName() {
    return getT2();
  }

  public String lastName() {
    return getT3();
  }

  public String email() {
    return getT4();
  }
}

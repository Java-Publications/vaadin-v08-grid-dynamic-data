package org.rapidpm.vaadin.helloworld.server;

import org.rapidpm.frp.model.Triple;

public class Filter extends Triple<String, String, String> {

  public Filter(String firstName, String lastName, String email) {
    super(firstName, lastName, email);
  }

  public String firstName() {
    return getT1();
  }

  public String lastName() {
    return getT2();
  }

  public String email() {
    return getT3();
  }
}

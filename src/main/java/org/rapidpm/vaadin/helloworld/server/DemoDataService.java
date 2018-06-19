package org.rapidpm.vaadin.helloworld.server;

import org.rapidpm.dependencies.core.logger.HasLogger;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class DemoDataService implements HasLogger {


  private static final int DATA_SIZE = 2_000_000;

  public List<Person> find(String firstName, String lastName, String eMail,
                           int offset, int limit) {
    logger().info("Offset: " + offset + ", limit: " + limit);


    return IntStream
        .rangeClosed(offset, offset + limit)
        .mapToObj(id -> new Person(id,
                                   "firstName-" + id,
                                   "lastName-" + id,
                                   id + "@hotmail.com"
        ))
        .collect(toList());
  }

  public int count(String firstName, String lastName, String eMail) {
    return DATA_SIZE;
  }
}

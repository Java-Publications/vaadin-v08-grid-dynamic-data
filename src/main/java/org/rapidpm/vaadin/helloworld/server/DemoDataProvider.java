package org.rapidpm.vaadin.helloworld.server;

import com.vaadin.data.provider.AbstractBackEndDataProvider;
import com.vaadin.data.provider.Query;
import org.rapidpm.dependencies.core.logger.HasLogger;

import java.util.stream.Stream;

public class DemoDataProvider
    extends AbstractBackEndDataProvider<Person, Filter>
    implements HasLogger {

  private DemoDataService dataService = new DemoDataService();

  @Override
  protected Stream<Person> fetchFromBackEnd(Query<Person, Filter> query) {
    Filter filter = query.getFilter()
                         .orElseGet(() -> new Filter(null, null, null));

    logger().info("Fetch filter: " + filter);
    Stream<Person> stream = dataService
        .find(null, null, null, query.getOffset(), query.getLimit())
        .stream();
    logger().info("fetched data from backend");
    return stream;
  }

  @Override
  protected int sizeInBackEnd(Query<Person, Filter> query) {
    Filter filter = query.getFilter()
                         .orElseGet(() -> new Filter(null, null, null));
    logger().info("count filter: " + filter);
    int count = dataService.count(null, null, null);
    logger().info("counted data in backend");
    return count;
  }
}
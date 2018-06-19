package org.rapidpm.vaadin.helloworld.server;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.provider.BackEndDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.grid.ColumnResizeMode;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.apache.meecrowave.Meecrowave;
import org.rapidpm.dependencies.core.logger.HasLogger;

import javax.servlet.annotation.WebServlet;

public class HelloWorld implements HasLogger {

  public static void main(String[] args) {
    new Meecrowave(new Meecrowave.Builder() {
      {
        setHttpPort(9876);
        // randomHttpPort();
        setTomcatScanning(true);
        setTomcatAutoSetup(false);
        setHttp2(true);
      }
    }).bake()
      .await();
  }


  public static class MyUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
      final Layout layout = new VerticalLayout();

      Grid<Person> grid = new Grid<>(Person.class);

      BackEndDataProvider<Person, Filter> dataProvider = new DemoDataProvider();
      grid.setDataProvider(dataProvider
                               .withConfigurableFilter());
      grid.setFooterVisible(false);

      grid.setHeaderVisible(true);
      grid.setColumnResizeMode(ColumnResizeMode.SIMPLE);
      grid.setHeightMode(HeightMode.ROW);
      grid.setHeightByRows(10);
//      grid.setSizeFull();
      layout.addComponent(grid);
      layout.setSizeFull();
      // set the main Component
      setContent(layout);
    }

    @WebServlet("/*")
    @VaadinServletConfiguration(productionMode = false, ui = MyUI.class)
    public static class MyProjectServlet extends VaadinServlet {
    }
  }
}

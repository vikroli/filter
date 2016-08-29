package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;
import com.emnify.esc.spcapi.data.EventSeverity;
import com.emnify.esc.spcapi.data.Organisation;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {

    Organisation o = new Organisation();
    o.setId(2l);
    o.setName("org2");

    Event e = new Event();
    e.setId(1l);
    e.setOrganisation(o);
    e.setSeverity(EventSeverity.CRITICAL);
    e.setAlert(true);
    e.setDescription("some description");



    // orgs 2 || 3
    List<IFilter> or_list = new ArrayList<IFilter>();

    Organisation of1 = new Organisation();
    of1.setId(2l);
    of1.setName("org2VomFilter");
    Organisation of2 = new Organisation();
    of2.setId(3l);
    of2.setName("org2VomFilter");
    or_list.add(new ORG_Filter(of1));
    or_list.add(new ORG_Filter(of2));


    OR_Filter or_filter = new OR_Filter(or_list);

    
    // severity higher than warn
    SeverityFilter severity_filter = new SeverityFilter(EventSeverity.WARN);



    List<IFilter> and_list = new ArrayList<IFilter>();
    and_list.add(or_filter);
    and_list.add(severity_filter);



    AND_Filter and_filter = new AND_Filter(and_list);
    System.out.println(and_filter.filter(e));

  }
}

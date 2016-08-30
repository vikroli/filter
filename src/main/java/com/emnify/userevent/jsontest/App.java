package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;
import com.emnify.esc.spcapi.data.EventSeverity;
import com.emnify.esc.spcapi.data.Organisation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) {

    // Event
    Organisation o = new Organisation();
    o.setId(2l);
    o.setName("org2");

    Event e = new Event();
    e.setId(1l);
    e.setOrganisation(o);
    e.setSeverity(EventSeverity.CRITICAL);
    e.setAlert(true);
    e.setDescription("some description");


    // Filter: events for org 1 and for org 2, if the severity is higher than WARN

    // orgFilter: orgs 2 || 3
    List<IFilter> or_list = new ArrayList<IFilter>();

    // Organisation of1 = new Organisation();
    // of1.setId(2l);
    // of1.setName("org2VomFilter");
    // Organisation of2 = new Organisation();
    // of2.setId(3l);
    // of2.setName("org2VomFilter");
    or_list.add(new OrgFilter(1l));
    or_list.add(new OrgFilter(2l));

    OrFilter or_filter = new OrFilter(or_list);

    // severetyFilter: severity > warn
    SeverityFilter severity_filter = new SeverityFilter(EventSeverity.WARN);

    // orgFilter && severetyFilter
    List<IFilter> and_list = new ArrayList<IFilter>();
    and_list.add(or_filter);
    and_list.add(severity_filter);
    AndFilter and_filter = new AndFilter(and_list);

    // filtering
    System.out.println(and_filter.filter(e));

    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    String jsonInString;
    try {
      jsonInString = mapper.writeValueAsString(and_filter);
      System.out.println(jsonInString);
    } catch (JsonProcessingException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }



  }
}

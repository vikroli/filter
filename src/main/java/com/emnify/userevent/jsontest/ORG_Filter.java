package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;
import com.emnify.esc.spcapi.data.Organisation;

public class ORG_Filter implements IFilter {

  Organisation o;

  public boolean filter(Event e) {
    return (e.getOrganisation().getId() == o.getId());
  }

  public ORG_Filter(Organisation o) {
    super();
    this.o = o;
  }

}

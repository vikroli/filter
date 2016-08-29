package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;
import com.emnify.esc.spcapi.data.EventSeverity;

public class SeverityFilter implements IFilter {

  EventSeverity minSeverity;

  public boolean filter(Event e) {
    return (e.getSeverity().compareTo(minSeverity) == 1);
  }

  public SeverityFilter(EventSeverity minSeverity) {
    super();
    this.minSeverity = minSeverity;
  }

}

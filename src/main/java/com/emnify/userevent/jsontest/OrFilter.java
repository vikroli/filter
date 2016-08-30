package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;

import java.util.List;

public class OrFilter implements IFilter {

  List<IFilter> or;

  public boolean filter(Event event) {
    for (IFilter f : or) {
      if (f.filter(event)) {
        return true;
      }
    }
    return false;
  }

  public OrFilter(List<IFilter> filter) {
    super();
    this.or = filter;
  }

  public List<IFilter> getOr() {
    return or;
  }

  public void setOr(List<IFilter> or) {
    this.or = or;
  }
}

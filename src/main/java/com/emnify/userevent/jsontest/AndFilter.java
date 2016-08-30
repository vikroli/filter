package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;

import java.util.List;

public class AndFilter implements IFilter {

  List<IFilter> and;

  public boolean filter(Event e) {
    for (IFilter ff : and) {
      if (!ff.filter(e)) {
        return false;
      }
    }
    return true;
  }

  public AndFilter(List<IFilter> filter) {
    super();
    this.and = filter;
  }

  public List<IFilter> getAnd() {
    return and;
  }

  public void setAnd(List<IFilter> and) {
    this.and = and;
  }



}

package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;

import java.util.List;

public class AND_Filter implements IFilter {

  List<IFilter> f;

  public boolean filter(Event e) {
    for (IFilter ff : f) {
      if (!ff.filter(e)) {
        return false;
      }
    }
    return true;
  }

  public AND_Filter(List<IFilter> f) {
    super();
    this.f = f;
  }

}

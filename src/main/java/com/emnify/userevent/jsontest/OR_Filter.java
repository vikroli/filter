package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;

import java.util.List;

public class OR_Filter implements IFilter {

  List<IFilter> f;

  public boolean filter(Event e) {
    for (IFilter ff : f) {
      if (ff.filter(e)) {
        return true;
      }
    }
    return false;
  }

  public OR_Filter(List<IFilter> f) {
    super();
    this.f = f;
  }

}

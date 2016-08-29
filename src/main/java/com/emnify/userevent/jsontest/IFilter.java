package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;

public interface IFilter {

  abstract boolean filter(Event e);

}

package com.emnify.userevent.jsontest;

import com.emnify.esc.spcapi.data.Event;

public class OrgFilter implements IFilter {

  long orgId;

  public boolean filter(Event event) {
    return (event.getOrganisation().getId() == orgId);
  }

  public OrgFilter(long orgId) {
    super();
    this.orgId = orgId;
  }

  public long getOrgId() {
    return orgId;
  }

  public void setOrgId(long orgId) {
    this.orgId = orgId;
  }

}

package com.google.appengine.api.datastore;

import java.io.Serializable;

public class Key implements Serializable, Comparable {

  private String appId;

  private long id;

  private Key() {
  }

  public int compareTo(Object o) {
    throw new UnsupportedOperationException();
  }

}
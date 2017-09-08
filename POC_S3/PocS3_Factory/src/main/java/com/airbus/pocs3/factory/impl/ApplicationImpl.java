// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (C) Airbus Defence and Space, 2017 - All rights reserved
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocs3.factory.impl;

import com.airbus.pocS3.definitions.IApplication;

/**
 *
 */
public class ApplicationImpl implements IApplication {

  final String name;

  /**
   * @param name
   * @param applicationList
   */
  public ApplicationImpl(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  /*
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  /*
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ApplicationImpl other = (ApplicationImpl) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Application[name=" + this.name + "]";
  }
}

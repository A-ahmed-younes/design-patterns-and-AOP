package org.example;

public class ProxyResource implements Resource {
  private RealResource realResource;

  @Override
  public void operation() {
    if (realResource == null) {
      realResource = new RealResource();
    }
    realResource.operation();
  }
}

package org.example;

// The actual object, which should only be created when required
public class RealResource implements Resource {
  public RealResource() {
    System.out.println("Real Resource is being created...");
  }

  @Override
  public void operation() {
    System.out.println("Real Resource operation");
  }
}

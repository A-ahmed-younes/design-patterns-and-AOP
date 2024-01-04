package org.example;

public class Test {
  public static void main(String[] args) {
    Resource resource = new ProxyResource();

    // The actual object is created when the operation is executed
    resource.operation();

    resource.operation();

  }
}

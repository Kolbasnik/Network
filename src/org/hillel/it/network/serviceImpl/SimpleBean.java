package org.hillel.it.network.serviceImpl;

public class SimpleBean {
  private String message = "Text of message not install";

  public String getMessage() {
    return(message);
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
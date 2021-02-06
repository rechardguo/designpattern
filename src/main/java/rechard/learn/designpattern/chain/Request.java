package rechard.learn.designpattern.chain;

public class Request {
  private String reference;
  private String message;

    public Request(String reference, String message) {
        this.reference = reference;
        this.message = message;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package cn.game.admin.controller.http.req.system;



public class CreateResp<U> extends Resp {

  private U details;

  public CreateResp(int status, U details) {
    super(status);
    this.details = details;
  }

  public U getDetails() {
    return details;
  }

  public void setDetails(U details) {
    this.details = details;
  }
}

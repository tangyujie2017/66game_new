package cn.game.admin.controller.http.req.system;


public class UpdateReq<U> {

  private U details;

  public UpdateReq(U details) {
    this.details = details;
  }

  public U getDetails() {
    return details;
  }

  public void setDetails(U details) {
    this.details = details;
  }

}

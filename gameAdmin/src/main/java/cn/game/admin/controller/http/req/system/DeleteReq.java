package cn.game.admin.controller.http.req.system;


public class DeleteReq<T> {

  private T id;

  public DeleteReq(T id) {
    this.id = id;
  }

  public T getId() {
    return id;
  }

  public void setId(T id) {
    this.id = id;
  }
}

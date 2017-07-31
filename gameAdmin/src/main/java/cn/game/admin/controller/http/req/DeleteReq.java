package cn.game.admin.controller.http.req;


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

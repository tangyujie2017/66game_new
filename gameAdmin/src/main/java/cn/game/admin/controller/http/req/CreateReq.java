package cn.game.admin.controller.http.req;



public class CreateReq<T> {

  private T details;

  public CreateReq() {
    // 保留构造方法
  }

  public CreateReq(T details) {
    this.details = details;
  }

  public T getDetails() {
    return details;
  }

  public void setDetails(T details) {
    this.details = details;
  }
}

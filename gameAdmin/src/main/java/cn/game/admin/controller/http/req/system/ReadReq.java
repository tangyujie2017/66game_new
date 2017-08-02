package cn.game.admin.controller.http.req.system;


public class ReadReq<T> {
  private T value;

  public ReadReq(T field) {
    this.value = field;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}

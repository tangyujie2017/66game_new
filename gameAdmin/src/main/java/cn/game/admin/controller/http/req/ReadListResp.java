package cn.game.admin.controller.http.req;

import java.util.List;


public class ReadListResp<T> extends Resp {

  private List<T> all;

  public ReadListResp(int status, List<T> all) {
    super(status);
    this.all = all;
  }

  public List<T> getAll() {
    return all;
  }

  public void setAll(List<T> all) {
    this.all = all;
  }
}

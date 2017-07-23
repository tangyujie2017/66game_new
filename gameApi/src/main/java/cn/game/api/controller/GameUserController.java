package cn.game.api.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.game.api.controller.req.BaseRequest;
import cn.game.api.controller.req.user.LoadUserReq;
import cn.game.api.controller.resp.BaseResponse;
import cn.game.api.service.user.GameUserService;
import cn.game.core.entity.table.play.Player;
import cn.game.core.service.vo.PlayerVo;

@Controller
public class GameUserController {

	private static Logger logger = Logger.getLogger(GameLoginController.class);
	@Autowired
	private GameUserService gameUserService;

	@PostMapping(value = "/api/v1/user/loadUser")
	@ResponseBody
	public ResponseEntity<BaseResponse> loadUser(@RequestBody BaseRequest<LoadUserReq> req, BindingResult result) {
		if (result.hasErrors()) {
			return BaseResponse.systemError("请求参数错误");
		}

		Player player = gameUserService.loadPlayer(req.getData().getUserId());
		PlayerVo vo = PlayerVo.playerToVo(player);
		return BaseResponse.success(vo);

	}
}

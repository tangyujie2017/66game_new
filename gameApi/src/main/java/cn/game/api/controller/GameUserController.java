package cn.game.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import cn.game.core.entity.table.play.GameFriends;
import cn.game.core.entity.table.play.Player;
import cn.game.core.service.vo.PlayerFriendVo;
import cn.game.core.service.vo.PlayerSimpleVo;
import cn.game.core.service.vo.PlayerVo;

@Controller
public class GameUserController {

	private static Logger logger = LogManager.getLogger(GameUserController.class);
	@Autowired
	private GameUserService gameUserService;

	@PostMapping(value = "/api/v1/user/loadUser")
	@ResponseBody
	public ResponseEntity<BaseResponse> loadUser(@RequestBody BaseRequest<LoadUserReq> req, BindingResult result) {
		logger.info("客户端调用/api/v1/user/loadUser接口");
		if (result.hasErrors()) {
			return BaseResponse.systemError("请求参数错误");
		}

		Player player = gameUserService.loadPlayer(req.getData().getUserId());
		PlayerVo vo = PlayerVo.playerToVo(player);
		return BaseResponse.success(vo);

	}

	@PostMapping(value = "/api/v1/user/loadUserFriends")
	@ResponseBody
	public ResponseEntity<BaseResponse> loadUserFriends(@RequestBody BaseRequest<LoadUserReq> req,
			BindingResult result) {
		if (result.hasErrors()) {
			return BaseResponse.systemError("请求参数错误");
		}

		Player player = gameUserService.loadFriends(req.getData().getUserId());
		PlayerFriendVo vo = new PlayerFriendVo();
		vo.setUserId(player.getUserId());
		List<GameFriends> friends = player.getFridends();
		if (friends != null && friends.size() > 0) {
			List<PlayerSimpleVo> list = new ArrayList<>();
			for (GameFriends friend : friends) {

				list.add(PlayerSimpleVo.playerToSimpleVo(friend.getPlayer()));

			}
			vo.setFriends(list);
		}

		return BaseResponse.success(vo);

	}

}

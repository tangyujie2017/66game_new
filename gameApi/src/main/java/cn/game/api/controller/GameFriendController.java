package cn.game.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.game.api.controller.req.BaseRequest;
import cn.game.api.controller.req.friend.SendFriendScoreReq;
import cn.game.api.controller.resp.BaseResponse;
import cn.game.api.service.friend.GameFriendService;

@Controller
public class GameFriendController {
	@Autowired

	private GameFriendService gameFriendService;

	@PostMapping(value = "/api/v1/friend/send")
	@ResponseBody
	public ResponseEntity<BaseResponse> sendScore(@RequestBody BaseRequest<SendFriendScoreReq> req,
			BindingResult result) {
		if (result.hasErrors()) {
			return BaseResponse.systemError("请求参数错误");
		}
		try {

			gameFriendService.sendScoreToFriend(req.getData().getSendUserId(), req.getData().getReceiverUserId(),
					req.getData().getScore());
			return BaseResponse.success("赠送成功");
		} catch (Exception e) {
			return BaseResponse.systemError(e.getMessage());
		}

	}
}

package cn.game.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.game.api.service.friend.GameFriendService;

@Controller
public class GameFriendController {
	@Autowired

	private GameFriendService gameFriendService;
}

package cn.game.api.service.friend;



public interface GameFriendService {
	
	public void sendScoreToFriend(Long sendUserId,Long receiverUserId,Long score);

}

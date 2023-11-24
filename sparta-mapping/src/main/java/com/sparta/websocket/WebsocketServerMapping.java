package com.sparta.websocket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gitee.magic.framework.head.vo.BaseVO;
import com.gitee.magic.framework.head.vo.ObjectVO;
import com.sparta.ao.websocket.WebsocketBroadcastListMessageAO;
import com.sparta.ao.websocket.WebsocketBroadcastMessageAO;
import com.sparta.ao.websocket.WebsocketListMessageAO;
import com.sparta.ao.websocket.WebsocketMessageAO;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author JodeXu
 */
@Tag(name = "Websocket server API")
public interface WebsocketServerMapping {
	
	/**
	 * Send a message to the specified user ids
	 * @param message 
	 */
	@PostMapping("/v1/ws/sendMessage")
	BaseVO sendMessageToUsers(@RequestBody WebsocketMessageAO ao);

	/**
	 * broadcast message to all online users
	 * @param message
	 * @return
	 */
	@PostMapping("/v1/ws/broadcast")
	BaseVO broadcastMessage(@RequestBody WebsocketBroadcastMessageAO ao);
	
	/**
	 * Send list message to the specified user ids
	 * @param message 
	 */
	@PostMapping("/v1/ws/list/sendMessage")
	BaseVO sendListMessageToUsers(@RequestBody WebsocketListMessageAO ao);

	/**
	 * broadcast list message to all online users
	 * @param message
	 * @return
	 */
	@PostMapping("/v1/ws/list/broadcast")
	BaseVO broadcastListMessage(@RequestBody WebsocketBroadcastListMessageAO ao);
	
	/**
	 * count online users 
	 * @param message
	 * @return
	 */
	@GetMapping("/v1/ws/online/count")
	ObjectVO<Integer> onlineCount();
	
}

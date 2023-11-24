package com.sparta.system;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gitee.magic.framework.head.vo.BaseVO;
import com.sparta.ao.message.MessageAO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author start
 */
@Tag(name = "Message center")
public interface MessageMapping {

	/**
	 * Send a message
	 * @param ao
	 * @return
	 */
	@Operation(summary = "Send a message")
	@PostMapping("/v1/send/message")
	BaseVO sendMessage(@RequestBody MessageAO ao);

	/**
	 * Send the file
	 * @param ao
	 * @return
	 */
	@Operation(summary = "Send the file")
	@PostMapping("/v1/send/file")
	BaseVO sendFile(@RequestBody MessageAO ao);

}

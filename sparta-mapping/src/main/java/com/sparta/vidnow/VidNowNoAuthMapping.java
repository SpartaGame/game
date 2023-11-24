package com.sparta.vidnow;

import com.sparta.dto.base.UpdateNickNameDTO;
import com.sparta.dto.game.GameAdFloatingBarDTO;
import com.sparta.vo.system.DeviceVO;
import com.sparta.vo.vn.VidObjectVO;
import com.sparta.vo.vn.VnUserInfoForBackgroundVO;
import com.sparta.vo.vn.VnUserInfoVO;
import com.sparta.vo.vn.VnUserTaskWatchVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author start
 */
@Tag(name = "VidNow API No Auth")
public interface VidNowNoAuthMapping {

	/**
	 * Get user information
	 * @param userId
	 * @param vsign
	 * @return
	 */
	@GetMapping("/vu/vproject/getUserInfoByUserId")
	VidObjectVO<VnUserInfoVO> userInfo(
			@RequestParam Long userId,
			@RequestHeader String vsign);
	/**
	 * Find out how often people watch videos and how many ads they watch per day
	 * @param userId
	 * @param vsign
	 * @return
	 */
	@GetMapping("/vu/vproject/getTask")
	VidObjectVO<VnUserTaskWatchVO> getTask(@RequestParam Long userId,
			@RequestHeader String vsign);

	/**
	 * Obtain basic user information
	 * @param userIds
	 * @param vsign
	 * @return
	 */
	@GetMapping("/vu/vproject/getUserInfoByUserIds")
	VidObjectVO<List<VnUserInfoVO>> getUserInfoByUserIds(@RequestParam String userIds,
			@RequestHeader String vsign);

	/**
	 *Notify Vid Now game announcements
	 * @param gameAdFloatingBarDTO
	 * @param vsign
	 * @return
	 */
	@PostMapping("/vu/vproject/pushFloatingBar")
	VidObjectVO pushFloatingBar(@RequestBody GameAdFloatingBarDTO gameAdFloatingBarDTO,
			@RequestHeader String vsign);
	
	/**
	 * Get user information - user basic information, device information, etc
	 * @param userIds
	 * @param vsign
	 * @return
	 */
	@GetMapping("/vu/vproject/getBackGroundUserInfoByUserIds")
	VidObjectVO<List<VnUserInfoForBackgroundVO>> getBackGroundUserInfoByUserIds(@RequestParam String userIds,
			@RequestHeader String vsign);
	
	/**
	 * Edit the user nickname
	 * @param updateNickName
	 * @param vsign
	 * @return
	 */
	@PostMapping("/vu/admin/vproject/updateUserNickByUserId")
	VidObjectVO<Boolean> updateNickNameByUserId(@RequestBody UpdateNickNameDTO updateNickName,@RequestHeader String vsign);

	/**
	 * queryPushToken
	 * @param userId
	 * @param vsign
	 * @return
	 */
	@GetMapping("/vu/vproject/pushToken")
	VidObjectVO<String> queryPushToken(@RequestParam Long userId, @RequestHeader String vsign);

	/**
	 * queryPushToken
	 * @param userId
	 * @param vsign
	 * @return
	 */
	@GetMapping("/vu/vproject/deviceInfo")
	VidObjectVO<DeviceVO> queryDeviceInfo(@RequestParam Long userId, @RequestHeader String vsign);
}

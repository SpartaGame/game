package com.sparta.vidnow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sparta.vo.vn.VidObjectVO;
import com.sparta.vo.vn.VnUserInfoVO;
import com.sparta.vo.vn.VnUserTokenCheckVO;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author start
 */
@Tag(name = "VidNow API")
public interface VidNowMapping {

	/**
	 * Get user information
	 * @return
	 */
	@GetMapping("/vu/vproject/getUserInfo")
	VidObjectVO<VnUserInfoVO> userInfo();
	
	/**
	 * Query the user ID by invitation code
	 * @param code
	 * @return
	 */
	@GetMapping("/vu/vproject/getUserIdByCode")
	VidObjectVO<Long> getUserIdByCode(@RequestParam String code);
	
	/**
	 * Verify the token
	 * @return
	 */
	@GetMapping("/vu/vproject/userTokenCheck")
	VidObjectVO<VnUserTokenCheckVO> userTokenCheck();
	
}

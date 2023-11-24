package com.sparta.system;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.gitee.magic.core.valid.annotation.NotNull;
import com.gitee.magic.core.valid.annotation.number.LongValid;
import com.gitee.magic.framework.head.vo.BaseVO;
import com.gitee.magic.framework.head.vo.ObjectVO;
import com.gitee.magic.framework.head.vo.PageVO;
import com.sparta.ao.system.UserAO;
import com.sparta.ao.system.UserLoginAO;
import com.sparta.ao.system.UserPageAO;
import com.sparta.ao.system.UserPwdAO;
import com.sparta.ao.system.UserUpdateAO;
import com.sparta.vo.system.UserLoginVO;
import com.sparta.vo.system.UserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author start
 */
@Tag(name = "System administration")
public interface UserMapping {

	/**
	 * Login
	 * @param ao Parameter
	 * @return ObjectVO
	 */
	@Operation(summary="The user logs on")
	@PostMapping("/v1/user/login")
	ObjectVO<UserLoginVO> login(@RequestBody UserLoginAO ao);

	/**
	 * Import
	 * @param file
	 * @return
	 */
	@Operation(summary="User import")
    @PostMapping(value="/v1/user/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	BaseVO importFile(@Parameter(description = "File") @RequestPart MultipartFile file);

	/**
	 * Create a user
	 * @param ao Parameter
	 * @return BaseVO
	 */
	@Operation(summary="Create a user")
	@PostMapping("/v1/user")
	BaseVO save(@RequestBody UserAO ao);

	/**
	 * User updates
	 * @param ao
	 * @return BaseVO
	 */
	@Operation(summary="User updates")
	@PutMapping("/v1/user")
	BaseVO update(@RequestBody UserUpdateAO ao);

	/**
	 * Delete users
	 * @param ao
	 * @return
	 */
	@Operation(summary="Delete users")
	@DeleteMapping("/v1/user")
	ObjectVO<Integer> remove(@RequestBody List<Long> ao);
	
	/**
	 * Paginated queries
	 * @param ao Parameter
	 * @return BaseVO
	 */
	@Operation(summary="User pagination")
	@PostMapping("/v1/user/page")
	PageVO<UserVO> page(@RequestBody UserPageAO ao);

	/**
	 * Change the password
	 * @param ao
	 * @return
	 */
	@Operation(summary="Change the password")
	@PutMapping("/v1/user/password")
	ObjectVO<Integer> password(@RequestBody UserPwdAO ao);
	
	/**
	 * Generate a gooogle authentication key
	 * @param userId
	 * @return  Returns the latest QR code link address
	 */
	@Operation(summary="Generate a gooogle authentication key")
	@PutMapping("/v1/user/generateSecretKey/{userId}")
	ObjectVO<String> generateSecretKey(@PathVariable @Parameter(description="user id") @NotNull @LongValid Long userId);

}

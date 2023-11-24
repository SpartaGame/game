package com.sparta.system;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gitee.magic.core.valid.annotation.NotNull;
import com.gitee.magic.core.valid.annotation.number.LongValid;
import com.gitee.magic.framework.head.vo.ListVO;
import com.gitee.magic.framework.head.vo.ObjectVO;
import com.sparta.ao.system.AuthAO;
import com.sparta.vo.system.AuthVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author start
 */
@Tag(name = "System administration")
public interface AuthMapping {

	/**
	 * Permission saving
	 * @param ao
	 * @return
	 */
	@Operation(summary="Permission saving")
	@PostMapping("/v1/auth")
	ObjectVO<Long> saveForUpdate(@RequestBody AuthAO ao);
	
	/**
	 * Permission removal
	 * @param ao parameter
	 * @return BaseVO
	 */
	@Operation(summary="Permission removal")
	@DeleteMapping("/v1/auth")
	ObjectVO<Integer> remove(@RequestBody List<Long> ao);

	/**
	 * All configuration permissions
	 * @param parentId
	 * @return
	 */
	@Operation(summary="All configuration permissions")
	@GetMapping("/v1/auth/menu/layer/all/{parentId}")
	ListVO<AuthVO> allMenu(
			@PathVariable @Parameter(description="Father ID") @NotNull @LongValid Long parentId);

	/**
	 * Permissions granted by the current user
	 * @param parentId
	 * @return
	 */
	@Operation(summary="Permissions granted by the current user")
	@GetMapping("/v1/auth/menu/layer/self/{parentId}")
	ListVO<AuthVO> selfMenu(
			@PathVariable @Parameter(description="Father ID") @NotNull @LongValid Long parentId);
	
}

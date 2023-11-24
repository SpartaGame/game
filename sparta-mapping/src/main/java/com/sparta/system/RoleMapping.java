package com.sparta.system;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.base.core.head.ao.PageAO;
import com.gitee.magic.core.valid.annotation.NotNull;
import com.gitee.magic.core.valid.annotation.number.LongValid;
import com.gitee.magic.framework.head.vo.ListVO;
import com.gitee.magic.framework.head.vo.ObjectVO;
import com.gitee.magic.framework.head.vo.PageVO;
import com.sparta.ao.system.RoleAO;
import com.sparta.vo.system.AuthVO;
import com.sparta.vo.system.RoleVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author start
 */
@Tag(name = "System administration")
public interface RoleMapping {

	/**
	 * Role saving
	 * @param ao
	 * @return
	 */
	@Operation(summary="Role saving")
	@PostMapping("/v1/role")
	ObjectVO<Long> saveForUpdate(@RequestBody RoleAO ao);

	/**
	 * Role deletion
	 * @param ao Parameter
	 * @return BaseVO
	 */
	@Operation(summary="Role deletion")
	@DeleteMapping("/v1/role")
	ObjectVO<Integer> remove(@RequestBody List<Long> ao);
	
	/**
	 * Paginated queries
	 * @param ao Parameter
	 * @return PageVO
	 */
	@Operation(summary="Role Pagination")
	@PostMapping("/v1/role/page")
	PageVO<RoleVO> page(@RequestBody PageAO ao);

	/**
	 * Gets the list of permissions for the role
	 * @param roleId
	 * @return
	 */
	@Operation(summary="Role configuration permissions")
	@GetMapping("/v1/role/auth/{roleId}")
	ListVO<AuthVO> haveAuths(
			@PathVariable @Parameter(description = "Role ID") @NotNull @LongValid Long roleId);

}

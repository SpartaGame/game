package com.sparta.system;

import com.gitee.magic.core.json.JsonArray;
import com.gitee.magic.core.json.JsonObject;
import com.gitee.magic.core.valid.annotation.Length;
import com.gitee.magic.core.valid.annotation.NotEmpty;
import com.gitee.magic.core.valid.annotation.NotNull;
import com.gitee.magic.framework.head.vo.BaseVO;
import com.gitee.magic.framework.head.vo.ObjectVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author start
 */
@Tag(name = "System administration")
public interface ConfigMapping {
	
	/**
	 * Data dictionary
	 * @param key Field
	 * @return ObjectVO
	 */
	@Operation(summary="Data dictionary")
	@GetMapping("/v1/config/data/dictionary/{key}")
	ObjectVO<Map<String,String>> dictionary(@PathVariable @Parameter(description = "Filed") @NotNull @Length String key);

    /**
     * Get the configuration
     * @param code Code
     * @return ObjectVO
     */
    @Operation(summary="Get the configuration")
    @GetMapping("/v1/config/{code}")
    ObjectVO<Object> get(
            @PathVariable @Parameter(description = "code") @NotNull @Length String code);

    /**
     * Update the configuration
     * @param code Code
     * @param value Value
     * @return BaseVO
     */
    @Operation(summary="Update the configuration")
    @PutMapping("/v1/config/string/{code}")
    BaseVO set(
            @PathVariable @Parameter(description = "code") @NotNull @Length String code,
    		@RequestParam @Parameter(description = "value") @NotEmpty String value);

    /**
     * Update the configuration
     * @param code Code
     * @param value Value
     * @return BaseVO
     */
    @Operation(summary="Update the configuration")
    @PutMapping("/v1/config/json/{code}")
    BaseVO set(
            @PathVariable @Parameter(description = "Encode") @NotNull @Length String code,
    		@RequestBody @NotEmpty JsonObject value);

    /**
     * Update the configuration
     * @param code Code
     * @param value
     * @return BaseVO
     */
    @Operation(summary="Update the configuration")
    @PutMapping("/v1/config/array/{code}")
    BaseVO set(
            @PathVariable @Parameter(description = "Code") @NotNull @Length String code,
    		@RequestBody @NotEmpty JsonArray value);

}

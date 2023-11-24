package com.sparta.risk;

import com.gitee.magic.framework.head.vo.ObjectVO;
import com.sparta.ao.risk.RiskDstExchangeGoldCoinOrderAO;
import com.sparta.dto.risk.*;
import com.sparta.vo.risk.RiskCheckResultVO;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author payton
 */

@Tag(name = "Risk Check API")
public interface RiskMapping {
    /**
     * Mapping method for preCheckFiatDeposit.
     * @param riskFiatDepositData Fiat top-up data.
     * @return Data pre-check result.
     */
    @PostMapping("/v1/risk/preCheckFiatDeposit")
    ObjectVO<RiskCheckResultVO> preCheckFiatDeposit(@RequestBody RiskFiatDepositOrderDTO riskFiatDepositData);

    /**
     * Mapping method for preCheckFiatWithdraw.
     * @param riskFiatWithdrawOrder Fiat withdraw data.
     * @return Data pre-check result.
     */
    @PostMapping("/v1/risk/preCheckFiatWithdraw")
    ObjectVO<RiskCheckResultVO> preCheckFiatWithdraw(@RequestBody RiskFiatWithdrawOrderDTO riskFiatWithdrawOrder);

    /**
     * Mapping method for preCheckGoldCoinExchangeGameToken.
     * @param riskGoldCoinExchangeGameTokenOrder Gold coin exchange game token data.
     * @return Data pre-check result.
     */
    @PostMapping("/v1/risk/preCheckGoldCoinExchangeGameToken")
    ObjectVO<RiskCheckResultVO> preCheckGoldCoinExchangeGameToken(@RequestBody RiskGoldCoinExchangeGameTokenOrderDTO riskGoldCoinExchangeGameTokenOrder);

    /**
     * Mapping method for preCheckGameTokenExchangeGoldCoin.
     * @param riskGameTokenExchangeGoldCoinOrder
     * @return Data pre-check result.
     */
    @PostMapping("/v1/risk/preCheckGameTokenExchangeGoldCoin")
    ObjectVO<RiskCheckResultVO> preCheckGameTokenExchangeGoldCoin(@RequestBody RiskGameTokenExchangeGoldCoinOrderDTO riskGameTokenExchangeGoldCoinOrder);

    /**
     * Mapping method for preCheckDstExchangeGoldCoin.
     * @param riskDstExchangeGoldCoinOrder
     * @return Data pre-check result.
     */
    @PostMapping("/v1/risk/preCheckDstExchangeGoldCoin")
    ObjectVO<RiskCheckResultVO> preCheckDstExchangeGoldCoin(@RequestBody RiskDstExchangeGoldCoinOrderAO riskDstExchangeGoldCoinOrder);

    /**
     * Mapping method for check.
     * @param riskCheckRequest
     * @return Data check result.
     */
    @PostMapping("/v1/risk/check")
    ObjectVO<RiskCheckResultVO> riskCheck(@RequestBody RiskCheckRequestDTO riskCheckRequest);

    /**
     * Mapping method for postCheck.
     * @param riskCheckRequest
     * @return Data post-check result.
     */
    @PostMapping("/v1/risk/postCheck")
    ObjectVO<RiskCheckResultVO> riskPostCheck(@RequestBody RiskCheckRequestDTO riskCheckRequest);
}

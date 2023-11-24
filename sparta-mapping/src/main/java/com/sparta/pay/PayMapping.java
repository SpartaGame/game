package com.sparta.pay;

import com.gitee.magic.framework.head.vo.ObjectVO;
import com.sparta.ao.pay.PayoutRequestAO;
import com.sparta.vo.pay.PayoutRequestResultVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author JimmyXu
 * @date 2023-10-30 15:50:44
 */
@Tag(name = "Pay service")
public interface PayMapping {
    /**
     * call pay to do payout request
     * @param ao
     * @return
     */
    @PostMapping("/v1/payout/payoutRequest")
    ObjectVO<PayoutRequestResultVO> payoutRequest(@RequestBody PayoutRequestAO ao);
}

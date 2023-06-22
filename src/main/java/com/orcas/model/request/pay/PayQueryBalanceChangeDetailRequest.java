package com.orcas.model.request.pay;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.pay.PayQueryBalanceChangeDetailResponse;
import com.orcas.util.Assert;
import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PayQueryBalanceChangeDetailRequest
    extends BaseRequest<PayQueryBalanceChangeDetailResponse> {
  /** 分页查询当前页数，默认为1 */
  @Builder.Default public Integer pageNum = 1;
  /** 每页记录数，默认为20，最大100 */
  @Builder.Default public Integer pageSize = 20;
  /** 订单号或流水单 例如：42747145688 */
  public String orderId;
  /** 开始日期，格式必须：yyyyMMdd，起止时间不能超过7天 */
  public LocalDate startDate;
  /** 截止日期，格式必须：yyyyMMdd，起止时间不能超过7天 */
  public LocalDate endDate;

  @Override
  public void validate() {
    Assert.validateIntegerMaxIfPresent(pageSize, "pageSize", BigInteger.valueOf(20));
  }

  @Data
  public static class JdPayQueryBalanceChangeDetailRequest implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    public Integer pageNum = 1;
    public Integer pageSize = 20;
    public String orderId;
    public String startDate;
    public String endDate;
  }

  @Override
  public TypeReference<PayQueryBalanceChangeDetailResponse> getRespTypeReference() {
    return new TypeReference<PayQueryBalanceChangeDetailResponse>() {};
  }

  @Override
  public Object into() {
    JdPayQueryBalanceChangeDetailRequest request = new JdPayQueryBalanceChangeDetailRequest();
    request.setPageNum(pageNum);
    request.setPageSize(pageSize);
    request.setOrderId(orderId);
    request.setStartDate(
        startDate == null ? null : startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    request.setEndDate(
        endDate == null ? null : endDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    return request;
  }
}

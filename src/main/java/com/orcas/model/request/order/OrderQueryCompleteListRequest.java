package com.orcas.model.request.order;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.order.OrderQueryCompleteListResponse;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderQueryCompleteListRequest extends BaseRequest<OrderQueryCompleteListResponse> {
  /** 查询日期，格式2018-11-7（不包含当天） */
  private LocalDate date;
  /** 说明：查询该pin下的订单列表 【注】该pin和授权token_pin应属于同一个合同（client），为空时查client下所有PIN订单 */
  private String pin;
  /** 页码，默认1 */
  @Builder.Default private Integer pageNo = 1;
  /** 页大小取值范围[1,100]，默认20 */
  @Builder.Default private Integer pageSize = 20;
  /**
   * 最小订单号索引游标，为解决大于1W条订单无法查询问题。
   * 注意事项：该字段和pageNo互斥，订单数小于1W可以用pageNo分页的方式来查询，订单数大于1W则需要使用索引游标的方式来读取数据。
   * 使用方式：第一次查询无需传入该字段，返回订单信息后（第一次记录订单总条数）；第二次查询将第一次查询结果中最小的订单号传入，查询返回结果中不包含传入的订单号；递归这个流程，直到接口返回无数据为止，订单查询完毕，核对本地订单数和第一次接口返回的订单数目是否一致。
   * 如果使用本字段：订单号必须大于1
   */
  private Long jdOrderIdIndex;
  /** 结束日期，格式2018-11-7。主要用于查询时间段内，跟date配合使用。 */
  private LocalDate endDate;

  @Override
  public void validate() {
    Assert.isNotNull(date, "查询日期");
  }

  @Data
  public static class JdOrderQueryCompleteListRequest implements Serializable {
    public static final long serialVersionUID = 1L;
    private String date;
    private String pin;
    private Integer pageNo = 1;
    private Integer pageSize = 20;
    private Long jdOrderIdIndex;
    private String endDate;
  }

  @Override
  public TypeReference<OrderQueryCompleteListResponse> getRespTypeReference() {
    return new TypeReference<OrderQueryCompleteListResponse>() {};
  }

  @Override
  public Object into() {
    JdOrderQueryCompleteListRequest request = new JdOrderQueryCompleteListRequest();
    if (Objects.nonNull(date)) {
      request.setDate(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    request.setPin(pin);
    request.setPageNo(pageNo);
    request.setPageSize(pageSize);
    request.setJdOrderIdIndex(jdOrderIdIndex);
    request.setEndDate(
        endDate == null ? null : endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    return request;
  }
}

package com.orcas.model.response.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryOrderPromiseInfoResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 履约信息 */
  private String promiseTips;
  /** 预计发货天数 */
  private Integer deliveryDays;
  /** 预计到达时间，日期类型(Date)，精确到天维度 */
  private Date promiseDate;
  /** 预计xx天后送达 */
  private Integer arrivalDays;
}

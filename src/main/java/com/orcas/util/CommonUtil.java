package com.orcas.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
public class CommonUtil {
  /**
   * md5加密
   *
   * @param input
   * @return
   */
  public static String MD5encrypt(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(input.getBytes());
      byte[] digest = md.digest();
      StringBuilder sb = new StringBuilder();
      for (byte b : digest) {
        sb.append(String.format("%02x", b & 0xff));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }
}

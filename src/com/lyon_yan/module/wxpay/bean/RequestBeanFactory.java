package com.lyon_yan.module.wxpay.bean;

import java.util.Map;

import com.lyon_yan.module.wxpay.bean.close_order.CloseOrderReqData;
import com.lyon_yan.module.wxpay.bean.create_order_protocol.CreateOrderReqData;
import com.lyon_yan.module.wxpay.bean.downloadbill_protocol.DownloadBillReqData;
import com.lyon_yan.module.wxpay.bean.pay_protocol.ScanPayReqData;
import com.lyon_yan.module.wxpay.bean.pay_query_protocol.PayQueryReqData;
import com.lyon_yan.module.wxpay.bean.refund_protocol.RefundReqData;
import com.lyon_yan.module.wxpay.bean.refund_query_protocol.RefundQueryReqData;
import com.lyon_yan.module.wxpay.bean.reverse_protocol.ReverseReqData;
import com.lyon_yan.module.wxpay.bean.short_url.ShortUrlReqData;
import com.lyon_yan.module.wxpay.core.RandomStringGenerator;
import com.lyon_yan.module.wxpay.core.Signature;

public class RequestBeanFactory {
	public static CloseOrderReqData getCloseOrderReqData(
			Map<String, Object> map, String key) {

		CloseOrderReqData reqData = new CloseOrderReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		reqData.setOut_trade_no(getValue(map, "out_trade_no"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	public static CreateOrderReqData getCreateOrderReqData(
			Map<String, Object> map, String key) {

		CreateOrderReqData reqData = new CreateOrderReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		reqData.setDevice_info(getValue(map, "device_info"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setBody(getValue(map, "body"));
		reqData.setAttach(getValue(map, "attach"));
		reqData.setOut_trade_no(getValue(map, "out_trade_no"));
		reqData.setTotal_fee(getInteger(map, "total_fee"));
		reqData.setSpbill_create_ip(getValue(map, "spbill_create_ip"));
		reqData.setTime_start(getValue(map, "time_start"));
		reqData.setTime_expire(getValue(map, "time_expire"));
		reqData.setGoods_tag(getValue(map, "goods_tag"));
		reqData.setNotify_url(getValue(map, "notify_url"));
		reqData.setProduct_id(getValue(map, "product_id"));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	public static DownloadBillReqData getDownloadBillReqData(
			Map<String, Object> map, String key) {

		DownloadBillReqData reqData = new DownloadBillReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		reqData.setDevice_info(getValue(map, "device_info"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setBill_date(getValue(map, "bill_date"));
		reqData.setBill_type(getValue(map, "bill_type"));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	public static ScanPayReqData getScanPayReqData(Map<String, Object> map,
			String key) {

		ScanPayReqData reqData = new ScanPayReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		reqData.setDevice_info(getValue(map, "device_info"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setBody(getValue(map, "body"));
		reqData.setAttach(getValue(map, "attach"));
		reqData.setOut_trade_no(getValue(map, "out_trade_no"));
		reqData.setTotal_fee(getInteger(map, "total_fee"));
		reqData.setSpbill_create_ip(getValue(map, "spbill_create_ip"));
		reqData.setTime_start(getValue(map, "time_start"));
		reqData.setTime_expire(getValue(map, "time_expire"));
		reqData.setGoods_tag(getValue(map, "goods_tag"));
		reqData.setAuth_code(getValue(map, "auth_code"));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	public static PayQueryReqData getPayQueryReqData(Map<String, Object> map,
			String key) {

		PayQueryReqData reqData = new PayQueryReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		// reqData.setDevice_info(getValue(map, "device_info"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setTransaction_id(getValue(map, "transaction_id"));
		reqData.setOut_trade_no(getValue(map, "out_trade_no"));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	public static RefundReqData getRefundReqData(Map<String, Object> map,
			String key) {

		RefundReqData reqData = new RefundReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		reqData.setDevice_info(getValue(map, "device_info"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setTransaction_id(getValue(map, "transaction_id"));
		reqData.setOut_trade_no(getValue(map, "out_trade_no"));
		reqData.setOut_refund_no(getValue(map, "out_refund_no"));
		reqData.setTotal_fee(getInteger(map, "total_fee"));
		reqData.setRefund_fee(getInteger(map, "refund_fee"));
		reqData.setOp_user_id(getValue(map, "op_user_id"));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	public static RefundQueryReqData getRefundQueryReqData(
			Map<String, Object> map, String key) {

		RefundQueryReqData reqData = new RefundQueryReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		reqData.setDevice_info(getValue(map, "device_info"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setTransaction_id(getValue(map, "transaction_id"));
		reqData.setOut_trade_no(getValue(map, "out_trade_no"));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	public static ReverseReqData getReverseReqData(Map<String, Object> map, String key) {

		ReverseReqData reqData = new ReverseReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		// reqData.setDevice_info(getValue(map, "device_info"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setTransaction_id(getValue(map, "transaction_id"));
		reqData.setOut_trade_no(getValue(map, "out_trade_no"));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	public static ShortUrlReqData getShortUrlReqData(Map<String, Object> map,
			String key) {

		ShortUrlReqData reqData = new ShortUrlReqData();
		reqData.setAppid(getValue(map, "appid"));
		reqData.setMch_id(getValue(map, "mch_id"));
		// reqData.setDevice_info(getValue(map, "device_info"));
		reqData.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		reqData.setLong_url(getValue(map, "long_url"));
		reqData.setSign(Signature.getSign(reqData.toMap(), key));
		return reqData;
	}

	private static String getValue(Map<String, Object> map, String key) {
		if (map.containsKey(key)) {
			return map.get(key).toString();
		}
		return "";
	}

	private static int getInteger(Map<String, Object> map, String key) {
		try {
			if (map.containsKey(key)) {
				return Integer.valueOf(map.get(key).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}

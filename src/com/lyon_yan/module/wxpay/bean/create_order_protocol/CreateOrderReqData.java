package com.lyon_yan.module.wxpay.bean.create_order_protocol;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lyon_yan.module.wxpay.config.Configure;
import com.lyon_yan.module.wxpay.core.RandomStringGenerator;
import com.lyon_yan.module.wxpay.core.Signature;

/**
 * @author Lyon
 */
@SuppressWarnings("serial")
public class CreateOrderReqData  implements Serializable{

	/**
	 * 
	 */
	// 每个字段具体的意思请查看API文档
	private String appid = "";
	private String mch_id = "";
	private String device_info = "";
	private String nonce_str = "";
	private String sign = "";
	private String body = "";
	private String attach = "";
	private String out_trade_no = "";
	private int total_fee = 0;
	private String spbill_create_ip = "";
	private String time_start = "";
	private String time_expire = "";
	private String goods_tag = "";
	private String notify_url = "";
	private String trade_type = "NATIVE";
	private String product_id = "";

	public CreateOrderReqData(String device_info, String body, String attach,
			String out_trade_no, int total_fee, String spbill_create_ip,
			String time_start, String time_expire, String goods_tag,
			String notify_url, String product_id) {
		super();
		// 微信分配的公众号ID（开通公众号之后可以获取到）
		setAppid(Configure.getAppid());
		setMch_id(Configure.getMchid());
		this.device_info = device_info;
		this.body = body;
		this.attach = attach;
		this.out_trade_no = out_trade_no;
		this.total_fee = total_fee;
		this.spbill_create_ip = spbill_create_ip;
		this.time_start = time_start;
		this.time_expire = time_expire;
		this.goods_tag = goods_tag;
		setNotify_url(notify_url);
		setTrade_type("NATIVE");
		this.product_id = product_id;
		setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		// 根据API给的签名规则进行签名
		String sign = Signature.getSign(toMap(),Configure.getKey());
		setSign(sign);
	}
	

	public CreateOrderReqData() {
		// TODO Auto-generated constructor stub
		super();
	}

	public CreateOrderReqData(String body, String out_trade_no, int total_fee,
			String spbill_create_ip, String notify_url,
			String product_id) {
		super();
		// 微信分配的公众号ID（开通公众号之后可以获取到）
		setAppid(Configure.getAppid());
		setMch_id(Configure.getMchid());
		this.body = body;
		this.out_trade_no = out_trade_no;
		this.total_fee = total_fee;
		this.spbill_create_ip = spbill_create_ip;
		this.notify_url = notify_url;
		setTrade_type("NATIVE");
		this.product_id = product_id;
		setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		String sign = Signature.getSign(toMap(),Configure.getKey());

		setSign(sign);
	}



	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if (obj != null&&!obj.toString().equals("")&&!obj.toString().equals("0")) {
					map.put(field.getName(), obj);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

}

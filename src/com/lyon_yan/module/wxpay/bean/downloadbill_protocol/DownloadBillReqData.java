package com.lyon_yan.module.wxpay.bean.downloadbill_protocol;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lyon_yan.module.wxpay.config.Configure;
import com.lyon_yan.module.wxpay.core.RandomStringGenerator;
import com.lyon_yan.module.wxpay.core.Signature;

/**
 * 
 * @author Lyon
 *
 */
@SuppressWarnings("serial")
public class DownloadBillReqData implements Serializable {
	/**
	 * 
	 */
	// 每个字段具体的意思请查看API文档
	private String appid = "";
	private String mch_id = "";
	private String device_info = "";
	private String nonce_str = "";
	private String sign = "";
	private String bill_date = "";
	private String bill_type = "";

	/**
	 *
	 * @param deviceInfo
	 * @param billDate
	 * @param billType
	 */
	public DownloadBillReqData(String deviceInfo, String billDate,
			String billType) {
		setAppid(Configure.getAppid());

		setMch_id(Configure.getMchid());

		setDevice_info(deviceInfo);

		setBill_date(billDate);

		setBill_type(billType);

		setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		String sign = Signature.getSign(toMap(),Configure.getKey());
		setSign(sign);

	}

	public DownloadBillReqData() {
		// TODO Auto-generated constructor stub
		super();
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

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if (obj != null && !obj.toString().equals("")&&!obj.toString().equals("0")) {
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

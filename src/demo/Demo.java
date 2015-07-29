package demo;

import com.lyon_yan.module.wxpay.bean.pay_protocol.ScanPayReqData;
import com.lyon_yan.module.wxpay.core.NetClentProxy;
import com.lyon_yan.module.wxpay.core.Signature;
import com.lyon_yan.module.wxpay.core.XMLFactory;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScanPayReqData reqData = new ScanPayReqData();
		reqData.setAppid("wxf5b5e87a6a0fde94");
		reqData.setMch_id("10000097");
		reqData.setBody("test測試");
		reqData.setAuth_code("auth_code");
		reqData.setTotal_fee(1);
		reqData.setSpbill_create_ip("127.0.0.1");
		reqData.setOut_trade_no("41548548");
		reqData.setNonce_str("12345678912345678978965412365412");
		String s="";
		reqData.setSign(s=Signature.getSign(reqData.toMap(),
				"40a8f8aa8ebe45a40bdc4e0f7307bc66"));
		String temp = new NetClentProxy(true).sendPost(
				"https://api.mch.weixin.qq.com/pay/micropay",
				XMLFactory.getXMLFromObject(reqData));
		System.out.println(s+" "+temp);
	}
}

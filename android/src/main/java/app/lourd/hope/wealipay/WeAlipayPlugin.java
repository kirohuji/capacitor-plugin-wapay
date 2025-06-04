package app.lourd.hope.wealipay;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

@CapacitorPlugin(name = "WeAlipayPlugin")
public class WeAlipayPlugin extends Plugin {

    public static PluginCall getCall() { return _call; }
    public static Alipay alipay = new Alipay();

    @PluginMethod
    public void aliPayRequest(PluginCall call) {
        String orderInfo = call.getString("orderInfo");
        saveCall(call);
        alipay.createPayment(orderInfo);
    }

    @PluginMethod
    public void wxPayRequest(PluginCall call) {
        String appId = getWxAppId(); //appid
        PayReq req = new PayReq();
        req.appId = appId;
        req.partnerId = call.getString("mch_id"); // 商户号
        req.prepayId = call.getString("prepay_id"); // 预支付交易会话标识
        req.nonceStr = call.getString("nonce"); // 随机字符串
        req.timeStamp = call.getString("timestamp"); // 时间戳
        req.sign = call.getString("sign"); // 签名
        req.packageValue = "Sign=WXPay"; // 签名

        saveCall(call);
        if(!req.checkArgs()) {
            call.reject(ERROR_INVALID_PARAMETERS,"-7");
            return;
        }

        final IWXAPI api = WXAPIFactory.createWXAPI(this.getContext(),appId,true);
        if(!api.isWXAppInstalled()) {
            call.reject(ERROR_WECHAT_NOT_INSTALLED,"-7");
            return;
        }

        api.registerApp(appId);
        if(!api.sendReq(req)) {
            call.reject(ERROR_SEND_REQUEST_FAILED,"-7");
        }
    }
}

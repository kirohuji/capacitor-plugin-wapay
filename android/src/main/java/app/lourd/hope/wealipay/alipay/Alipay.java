package app.lourd.hope.wealipay.alipay;
import java.util.Map;

import com.alipay.sdk.app.PayTask;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.getcapacitor.Bridge;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import app.lourd.hope.wealipay.WeAlipayPlugin;

public class Alipay {
    
    private static final int SDK_PAY_FLAG = 1;

    public static final String AliPAY_RESPONSE_OK = "操作成功";
    public static final String ERROR_ALIPAY_RESPONSE_COMMON = "操作失败";

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            PluginCall call = WeAlipayPlugin.getCall();
            JSObject ret = new JSObject();
            
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。
                     * 同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult(); // 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        ret.put("code", 0);
                        ret.put("message", AliPAY_RESPONSE_OK);
                        call.resolve(ret);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        call.reject(ERROR_ALIPAY_RESPONSE_COMMON, "-1");
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };

    public void createPayment(String orderInfo, Bridge bridge) {        
        final Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(bridge.getContext());
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("AlipayPlugin", result.toString());
                
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}

import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(WeAlipayPlugin)
public class WeAlipayPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "WeAlipayPlugin"
    public let jsName = "WeAlipayPlugin"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise)
    ]

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }

    @objc func aliPayRequest(_ call: CAPPluginCall) {
        // let orderInfo = call.getString("orderInfo") ?? ""
        // let alipay = Alipay()
        // alipay.createPayment(orderInfo)
    }

    @objc func wxPayRequest(_ call: CAPPluginCall) {
        // let mch_id = call.getString("mch_id") ?? ""
        // let prepay_id = call.getString("prepay_id") ?? ""
        // let nonce = call.getString("nonce") ?? ""
        // let timestamp = call.getDouble("timestamp") ?? 0
        // let sign = call.getString("sign") ?? ""

        // // let wxpay = WXPay()
        // // wxpay.createPayment(mch_id, prepay_id, nonce, timestamp, sign)
    }
}
}

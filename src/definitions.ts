export interface WeAlipayPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  aliPayRequest(options: { orderInfo: string }): Promise<any>;
  wxPayRequest(options: { mch_id: string, prepay_id: string, nonce: string, timestamp: number, sign: string }): Promise<any>;
}

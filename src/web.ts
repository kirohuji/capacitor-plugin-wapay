import { WebPlugin } from '@capacitor/core';

import type { WeAlipayPlugin } from './definitions';

export class WeAlipayPluginWeb extends WebPlugin implements WeAlipayPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  
  async wxPayRequest(options: { mch_id: string, prepay_id: string, nonce: string, timestamp: number, sign: string }): Promise<any> {
    return options;
  }

  async aliPayRequest(options: { orderInfo: string }): Promise<any> {
    return options
  }
}

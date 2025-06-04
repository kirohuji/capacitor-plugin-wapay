import { WebPlugin } from '@capacitor/core';

import type { WeAlipayPluginPlugin } from './definitions';

export class WeAlipayPluginWeb extends WebPlugin implements WeAlipayPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

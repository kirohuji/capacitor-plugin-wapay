import { registerPlugin } from '@capacitor/core';

import { WeAlipayPlugin } from './definitions';

const WeAlipayPlugin = registerPlugin<WeAlipayPlugin>('WeAlipayPlugin', {
  web: () => import('./web').then((m) => new m.WeAlipayPluginWeb()),
});

export * from './definitions';
export { WeAlipayPlugin };

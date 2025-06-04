import { registerPlugin } from '@capacitor/core';

import type { WeAlipayPluginPlugin } from './definitions';

const WeAlipayPlugin = registerPlugin<WeAlipayPluginPlugin>('WeAlipayPlugin', {
  web: () => import('./web').then((m) => new m.WeAlipayPluginWeb()),
});

export * from './definitions';
export { WeAlipayPlugin };

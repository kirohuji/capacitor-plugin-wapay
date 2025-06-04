export interface WeAlipayPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

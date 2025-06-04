# capacitor-plugin-wapay

Provides unified access to Alipay and WeChat Pay on Capacitor-based apps, supporting seamless mobile payment integration on both Android and iOS platforms.

## Install

```bash
npm install capacitor-plugin-wapay
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`aliPayRequest(...)`](#alipayrequest)
* [`wxPayRequest(...)`](#wxpayrequest)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### aliPayRequest(...)

```typescript
aliPayRequest(options: { orderInfo: string; }) => Promise<any>
```

| Param         | Type                                |
| ------------- | ----------------------------------- |
| **`options`** | <code>{ orderInfo: string; }</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### wxPayRequest(...)

```typescript
wxPayRequest(options: { mch_id: string; prepay_id: string; nonce: string; timestamp: number; sign: string; }) => Promise<any>
```

| Param         | Type                                                                                                |
| ------------- | --------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ mch_id: string; prepay_id: string; nonce: string; timestamp: number; sign: string; }</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------

</docgen-api>

import { WeAlipayPlugin } from 'capacitor-plugin-wapay';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    WeAlipayPlugin.echo({ value: inputValue })
}

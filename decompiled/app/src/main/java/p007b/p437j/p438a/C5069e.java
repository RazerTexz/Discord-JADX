package p007b.p437j.p438a;

import android.webkit.JavascriptInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.HCaptchaError;
import com.hcaptcha.sdk.HCaptchaException;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.p200p.SegmentedStringWriter;
import p007b.p195g.p196a.p198b.p204t.BufferRecycler;
import p007b.p195g.p196a.p198b.p204t.TextBuffer;
import p007b.p195g.p196a.p205c.ObjectMapper;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p437j.p438a.p439f.InterfaceC5070a;
import p007b.p437j.p438a.p439f.InterfaceC5071b;
import p007b.p437j.p438a.p439f.InterfaceC5072c;

/* renamed from: b.j.a.e */
/* loaded from: classes3.dex */
public class C5069e implements Serializable {
    private final HCaptchaConfig hCaptchaConfig;
    private final InterfaceC5070a onFailureListener;
    private final InterfaceC5071b onLoadedListener;
    private final InterfaceC5072c<HCaptchaTokenResponse> onSuccessListener;

    public C5069e(HCaptchaConfig hCaptchaConfig, InterfaceC5071b interfaceC5071b, InterfaceC5072c<HCaptchaTokenResponse> interfaceC5072c, InterfaceC5070a interfaceC5070a) {
        this.hCaptchaConfig = hCaptchaConfig;
        this.onLoadedListener = interfaceC5071b;
        this.onSuccessListener = interfaceC5072c;
        this.onFailureListener = interfaceC5070a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5069e)) {
            return false;
        }
        C5069e c5069e = (C5069e) obj;
        Objects.requireNonNull(c5069e);
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        HCaptchaConfig hCaptchaConfig2 = c5069e.hCaptchaConfig;
        if (hCaptchaConfig != null ? !hCaptchaConfig.equals(hCaptchaConfig2) : hCaptchaConfig2 != null) {
            return false;
        }
        InterfaceC5071b interfaceC5071b = this.onLoadedListener;
        InterfaceC5071b interfaceC5071b2 = c5069e.onLoadedListener;
        if (interfaceC5071b != null ? !interfaceC5071b.equals(interfaceC5071b2) : interfaceC5071b2 != null) {
            return false;
        }
        InterfaceC5072c<HCaptchaTokenResponse> interfaceC5072c = this.onSuccessListener;
        InterfaceC5072c<HCaptchaTokenResponse> interfaceC5072c2 = c5069e.onSuccessListener;
        if (interfaceC5072c != null ? !interfaceC5072c.equals(interfaceC5072c2) : interfaceC5072c2 != null) {
            return false;
        }
        InterfaceC5070a interfaceC5070a = this.onFailureListener;
        InterfaceC5070a interfaceC5070a2 = c5069e.onFailureListener;
        return interfaceC5070a != null ? interfaceC5070a.equals(interfaceC5070a2) : interfaceC5070a2 == null;
    }

    @JavascriptInterface
    public String getConfig() throws JsonProcessingException {
        char[] cArr;
        ObjectMapper objectMapper = new ObjectMapper(null, null, null);
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        SegmentedStringWriter segmentedStringWriter = new SegmentedStringWriter(objectMapper._jsonFactory.m1626a());
        try {
            objectMapper.m2224b(objectMapper.m2225c(segmentedStringWriter), hCaptchaConfig);
            String strM1741c = segmentedStringWriter.f4557j.m1741c();
            TextBuffer textBuffer = segmentedStringWriter.f4557j;
            textBuffer.f4606c = -1;
            textBuffer.f4611h = 0;
            textBuffer.f4613j = null;
            if (textBuffer.f4608e) {
                textBuffer.f4608e = false;
                textBuffer.f4607d.clear();
                textBuffer.f4609f = 0;
                textBuffer.f4611h = 0;
            }
            BufferRecycler bufferRecycler = textBuffer.f4605b;
            if (bufferRecycler != null && (cArr = textBuffer.f4610g) != null) {
                textBuffer.f4610g = null;
                bufferRecycler.f4594d.set(2, cArr);
            }
            return strM1741c;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw new JsonMappingException(null, String.format("Unexpected IOException (of type %s): %s", e2.getClass().getName(), ClassUtil.m2176h(e2)));
        }
    }

    public int hashCode() {
        HCaptchaConfig hCaptchaConfig = this.hCaptchaConfig;
        int iHashCode = hCaptchaConfig == null ? 43 : hCaptchaConfig.hashCode();
        InterfaceC5071b interfaceC5071b = this.onLoadedListener;
        int iHashCode2 = ((iHashCode + 59) * 59) + (interfaceC5071b == null ? 43 : interfaceC5071b.hashCode());
        InterfaceC5072c<HCaptchaTokenResponse> interfaceC5072c = this.onSuccessListener;
        int iHashCode3 = (iHashCode2 * 59) + (interfaceC5072c == null ? 43 : interfaceC5072c.hashCode());
        InterfaceC5070a interfaceC5070a = this.onFailureListener;
        return (iHashCode3 * 59) + (interfaceC5070a != null ? interfaceC5070a.hashCode() : 43);
    }

    @JavascriptInterface
    public void onError(int i) {
        this.onFailureListener.onFailure(new HCaptchaException(HCaptchaError.fromId(i)));
    }

    @JavascriptInterface
    public void onLoaded() {
        C5067c c5067c = (C5067c) this.onLoadedListener;
        c5067c.f13583k.post(new RunnableC5066b(c5067c));
    }

    @JavascriptInterface
    public void onPass(String str) {
        this.onSuccessListener.onSuccess(new HCaptchaTokenResponse(str));
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("HCaptchaJSInterface(hCaptchaConfig=");
        sbM833U.append(this.hCaptchaConfig);
        sbM833U.append(", onLoadedListener=");
        sbM833U.append(this.onLoadedListener);
        sbM833U.append(", onSuccessListener=");
        sbM833U.append(this.onSuccessListener);
        sbM833U.append(", onFailureListener=");
        sbM833U.append(this.onFailureListener);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

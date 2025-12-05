package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.outline;
import p630i0.Converter2;

/* compiled from: ScalarResponseBodyConverters.java */
/* renamed from: i0.e0.b.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarResponseBodyConverters3 implements Converter2<ResponseBody, Character> {

    /* renamed from: a */
    public static final ScalarResponseBodyConverters3 f26521a = new ScalarResponseBodyConverters3();

    @Override // p630i0.Converter2
    public Character convert(ResponseBody responseBody) throws IOException {
        String strM10998d = responseBody.m10998d();
        if (strM10998d.length() == 1) {
            return Character.valueOf(strM10998d.charAt(0));
        }
        StringBuilder sbM833U = outline.m833U("Expected body of length 1 for Character conversion but was ");
        sbM833U.append(strM10998d.length());
        throw new IOException(sbM833U.toString());
    }
}

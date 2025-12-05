package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.Converter2;

/* compiled from: ScalarResponseBodyConverters.java */
/* renamed from: i0.e0.b.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarResponseBodyConverters5 implements Converter2<ResponseBody, Float> {

    /* renamed from: a */
    public static final ScalarResponseBodyConverters5 f26523a = new ScalarResponseBodyConverters5();

    @Override // p630i0.Converter2
    public Float convert(ResponseBody responseBody) throws IOException {
        return Float.valueOf(responseBody.m10998d());
    }
}

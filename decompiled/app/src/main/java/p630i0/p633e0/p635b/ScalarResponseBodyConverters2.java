package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.Converter2;

/* compiled from: ScalarResponseBodyConverters.java */
/* renamed from: i0.e0.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarResponseBodyConverters2 implements Converter2<ResponseBody, Byte> {

    /* renamed from: a */
    public static final ScalarResponseBodyConverters2 f26520a = new ScalarResponseBodyConverters2();

    @Override // p630i0.Converter2
    public Byte convert(ResponseBody responseBody) throws IOException {
        return Byte.valueOf(responseBody.m10998d());
    }
}

package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.Converter2;

/* JADX INFO: renamed from: i0.e0.b.h, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters7 implements Converter2<ResponseBody, Long> {

    /* JADX INFO: renamed from: a */
    public static final ScalarResponseBodyConverters7 f26525a = new ScalarResponseBodyConverters7();

    @Override // p630i0.Converter2
    public Long convert(ResponseBody responseBody) throws IOException {
        return Long.valueOf(responseBody.m10998d());
    }
}

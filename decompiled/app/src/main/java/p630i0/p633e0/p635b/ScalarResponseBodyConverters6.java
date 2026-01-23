package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.Converter2;

/* JADX INFO: renamed from: i0.e0.b.g, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters6 implements Converter2<ResponseBody, Integer> {

    /* JADX INFO: renamed from: a */
    public static final ScalarResponseBodyConverters6 f26524a = new ScalarResponseBodyConverters6();

    @Override // p630i0.Converter2
    public Integer convert(ResponseBody responseBody) throws IOException {
        return Integer.valueOf(responseBody.m10998d());
    }
}

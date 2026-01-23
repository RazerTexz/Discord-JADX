package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.Converter2;

/* JADX INFO: renamed from: i0.e0.b.e, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters4 implements Converter2<ResponseBody, Double> {

    /* JADX INFO: renamed from: a */
    public static final ScalarResponseBodyConverters4 f26522a = new ScalarResponseBodyConverters4();

    @Override // p630i0.Converter2
    public Double convert(ResponseBody responseBody) throws IOException {
        return Double.valueOf(responseBody.m10998d());
    }
}

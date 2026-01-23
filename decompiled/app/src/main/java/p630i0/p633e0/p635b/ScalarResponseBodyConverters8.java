package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.Converter2;

/* JADX INFO: renamed from: i0.e0.b.i, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters8 implements Converter2<ResponseBody, Short> {

    /* JADX INFO: renamed from: a */
    public static final ScalarResponseBodyConverters8 f26526a = new ScalarResponseBodyConverters8();

    @Override // p630i0.Converter2
    public Short convert(ResponseBody responseBody) throws IOException {
        return Short.valueOf(responseBody.m10998d());
    }
}

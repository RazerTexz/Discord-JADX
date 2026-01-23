package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.Converter2;

/* JADX INFO: renamed from: i0.e0.b.j, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters9 implements Converter2<ResponseBody, String> {

    /* JADX INFO: renamed from: a */
    public static final ScalarResponseBodyConverters9 f26527a = new ScalarResponseBodyConverters9();

    @Override // p630i0.Converter2
    public String convert(ResponseBody responseBody) throws IOException {
        return responseBody.m10998d();
    }
}

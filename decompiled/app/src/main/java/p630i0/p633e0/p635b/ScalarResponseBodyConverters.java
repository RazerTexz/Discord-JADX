package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.Converter2;

/* JADX INFO: renamed from: i0.e0.b.b, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters implements Converter2<ResponseBody, Boolean> {

    /* JADX INFO: renamed from: a */
    public static final ScalarResponseBodyConverters f26519a = new ScalarResponseBodyConverters();

    @Override // p630i0.Converter2
    public Boolean convert(ResponseBody responseBody) throws IOException {
        return Boolean.valueOf(responseBody.m10998d());
    }
}

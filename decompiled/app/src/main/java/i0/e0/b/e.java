package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* compiled from: ScalarResponseBodyConverters.java */
/* loaded from: classes3.dex */
public final class e implements i0.h<ResponseBody, Double> {
    public static final e a = new e();

    @Override // i0.h
    public Double convert(ResponseBody responseBody) throws IOException {
        return Double.valueOf(responseBody.d());
    }
}

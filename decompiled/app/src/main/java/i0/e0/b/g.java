package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* compiled from: ScalarResponseBodyConverters.java */
/* loaded from: classes3.dex */
public final class g implements i0.h<ResponseBody, Integer> {
    public static final g a = new g();

    @Override // i0.h
    public Integer convert(ResponseBody responseBody) throws IOException {
        return Integer.valueOf(responseBody.d());
    }
}

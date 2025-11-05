package i0.e0.b;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: ScalarRequestBodyConverter.java */
/* loaded from: classes3.dex */
public final class a<T> implements i0.h<T, RequestBody> {
    public static final a<Object> a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    public static final MediaType f3739b;

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        f3739b = MediaType.Companion.a("text/plain; charset=UTF-8");
    }

    @Override // i0.h
    public RequestBody convert(Object obj) throws IOException {
        return RequestBody.create(f3739b, String.valueOf(obj));
    }
}

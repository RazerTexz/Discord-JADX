package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p630i0.Converter2;

/* compiled from: ScalarRequestBodyConverter.java */
/* renamed from: i0.e0.b.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarRequestBodyConverter<T> implements Converter2<T, RequestBody> {

    /* renamed from: a */
    public static final ScalarRequestBodyConverter<Object> f26517a = new ScalarRequestBodyConverter<>();

    /* renamed from: b */
    public static final MediaType f26518b;

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        f26518b = MediaType.Companion.m10967a("text/plain; charset=UTF-8");
    }

    @Override // p630i0.Converter2
    public RequestBody convert(Object obj) throws IOException {
        return RequestBody.create(f26518b, String.valueOf(obj));
    }
}

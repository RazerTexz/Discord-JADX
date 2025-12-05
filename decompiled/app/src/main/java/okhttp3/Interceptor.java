package okhttp3;

import java.io.IOException;

/* compiled from: Interceptor.kt */
/* loaded from: classes3.dex */
public interface Interceptor {

    /* renamed from: a */
    public static final /* synthetic */ int f27513a = 0;

    /* compiled from: Interceptor.kt */
    public interface Chain {
        /* renamed from: a */
        Response mo10228a(Request request) throws IOException;

        /* renamed from: c */
        Request mo10230c();
    }

    Response intercept(Chain chain) throws IOException;
}

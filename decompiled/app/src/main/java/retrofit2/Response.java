package retrofit2;

import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public final class Response<T> {

    /* renamed from: a */
    public final okhttp3.Response f27631a;

    /* renamed from: b */
    public final T f27632b;

    /* renamed from: c */
    public final ResponseBody f27633c;

    public Response(okhttp3.Response response, T t, ResponseBody responseBody) {
        this.f27631a = response;
        this.f27632b = t;
        this.f27633c = responseBody;
    }

    /* renamed from: b */
    public static <T> Response<T> m11056b(T t, okhttp3.Response response) {
        if (response.m10990b()) {
            return new Response<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    /* renamed from: a */
    public boolean m11057a() {
        return this.f27631a.m10990b();
    }

    public String toString() {
        return this.f27631a.toString();
    }
}

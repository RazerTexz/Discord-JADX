package p630i0.p631d0.p632a;

import p007b.p100d.p104b.p105a.outline;
import retrofit2.Response;

/* compiled from: Result.java */
/* renamed from: i0.d0.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Result4<T> {

    /* renamed from: a */
    public final Response<T> f26501a;

    /* renamed from: b */
    public final Throwable f26502b;

    public Result4(Response<T> response, Throwable th) {
        this.f26501a = response;
        this.f26502b = th;
    }

    public String toString() {
        if (this.f26502b != null) {
            StringBuilder sbM833U = outline.m833U("Result{isError=true, error=\"");
            sbM833U.append(this.f26502b);
            sbM833U.append("\"}");
            return sbM833U.toString();
        }
        StringBuilder sbM833U2 = outline.m833U("Result{isError=false, response=");
        sbM833U2.append(this.f26501a);
        sbM833U2.append('}');
        return sbM833U2.toString();
    }
}

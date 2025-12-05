package p630i0;

import java.io.IOException;
import okhttp3.Request;
import retrofit2.Response;

/* compiled from: Call.java */
/* renamed from: i0.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface Call3<T> extends Cloneable {
    /* renamed from: C */
    void mo10697C(Callback3<T> callback3);

    /* renamed from: L */
    Call3<T> mo10698L();

    /* renamed from: c */
    Request mo10699c();

    void cancel();

    /* renamed from: d */
    boolean mo10700d();

    Response<T> execute() throws IOException;
}

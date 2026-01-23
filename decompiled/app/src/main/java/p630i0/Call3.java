package p630i0;

import java.io.IOException;
import okhttp3.Request;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d, reason: use source file name */
/* JADX INFO: compiled from: Call.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Call3<T> extends Cloneable {
    /* JADX INFO: renamed from: C */
    void mo10697C(Callback3<T> callback3);

    /* JADX INFO: renamed from: L */
    Call3<T> mo10698L();

    /* JADX INFO: renamed from: c */
    Request mo10699c();

    void cancel();

    /* JADX INFO: renamed from: d */
    boolean mo10700d();

    Response<T> execute() throws IOException;
}

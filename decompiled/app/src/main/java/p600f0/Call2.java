package p600f0;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: Call.kt */
/* renamed from: f0.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface Call2 extends Cloneable {

    /* compiled from: Call.kt */
    /* renamed from: f0.e$a */
    public interface a {
        /* renamed from: b */
        Call2 mo10114b(Request request);
    }

    /* renamed from: c */
    Request mo10111c();

    void cancel();

    /* renamed from: d */
    boolean mo10112d();

    /* renamed from: e */
    void mo10113e(Callback2 callback2);

    Response execute() throws IOException;
}

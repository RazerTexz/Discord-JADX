package p600f0;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: renamed from: f0.e, reason: use source file name */
/* JADX INFO: compiled from: Call.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Call2 extends Cloneable {

    /* JADX INFO: renamed from: f0.e$a */
    /* JADX INFO: compiled from: Call.kt */
    public interface a {
        /* JADX INFO: renamed from: b */
        Call2 mo10114b(Request request);
    }

    /* JADX INFO: renamed from: c */
    Request mo10111c();

    void cancel();

    /* JADX INFO: renamed from: d */
    boolean mo10112d();

    /* JADX INFO: renamed from: e */
    void mo10113e(Callback2 callback2);

    Response execute() throws IOException;
}

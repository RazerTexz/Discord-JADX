package p600f0;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import p600f0.p601e0.p602d.JavaNetAuthenticator;

/* JADX INFO: renamed from: f0.c, reason: use source file name */
/* JADX INFO: compiled from: Authenticator.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Authenticator2 {

    /* JADX INFO: renamed from: a */
    public static final Authenticator2 f25369a = new Authenticator();

    static {
        new JavaNetAuthenticator(null, 1);
    }

    /* JADX INFO: renamed from: a */
    Request mo10102a(Route route, Response response) throws IOException;
}

package p677y.p678a.p680b;

import android.net.Uri;
import androidx.browser.trusted.TrustedWebActivityServiceConnectionPool;

/* JADX INFO: renamed from: y.a.b.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC13189c implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ TrustedWebActivityServiceConnectionPool f27954j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Uri f27955k;

    public /* synthetic */ RunnableC13189c(TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool, Uri uri) {
        this.f27954j = trustedWebActivityServiceConnectionPool;
        this.f27955k = uri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f27954j.m79a(this.f27955k);
    }
}

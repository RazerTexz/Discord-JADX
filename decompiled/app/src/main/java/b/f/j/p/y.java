package b.f.j.p;

import b.f.j.p.a0;
import b.f.j.p.n0;
import b.f.j.p.o0;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Objects;

/* compiled from: HttpUrlConnectionNetworkFetcher.java */
/* loaded from: classes3.dex */
public class y implements Runnable {
    public final /* synthetic */ a0.a j;
    public final /* synthetic */ o0.a k;
    public final /* synthetic */ a0 l;

    public y(a0 a0Var, a0.a aVar, o0.a aVar2) {
        this.l = a0Var;
        this.j = aVar;
        this.k = aVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() throws Throwable {
        HttpURLConnection httpURLConnectionA;
        a0 a0Var = this.l;
        a0.a aVar = this.j;
        o0.a aVar2 = this.k;
        Objects.requireNonNull(a0Var);
        InputStream inputStream = null;
        try {
            httpURLConnectionA = a0Var.a(aVar.f642b.e().c, 5);
            try {
                try {
                    aVar.e = a0Var.c.now();
                    if (httpURLConnectionA != null) {
                        inputStream = httpURLConnectionA.getInputStream();
                        ((n0.a) aVar2).b(inputStream, -1);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (httpURLConnectionA == null) {
                        return;
                    }
                } catch (IOException e) {
                    e = e;
                    ((n0.a) aVar2).a(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (httpURLConnectionA == null) {
                        return;
                    }
                    httpURLConnectionA.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (httpURLConnectionA != null) {
                    throw th;
                }
                httpURLConnectionA.disconnect();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnectionA = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionA = null;
            if (inputStream != null) {
            }
            if (httpURLConnectionA != null) {
            }
        }
        httpURLConnectionA.disconnect();
    }
}

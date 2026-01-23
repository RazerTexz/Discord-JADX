package p007b.p225i.p226a.p288f.p330i.p332b;

import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.i.b.f7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public final class RunnableC4036f7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final URL f10722j;

    /* JADX INFO: renamed from: k */
    public final C4235x4 f10723k;

    /* JADX INFO: renamed from: l */
    public final String f10724l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C4012d7 f10725m;

    public RunnableC4036f7(C4012d7 c4012d7, String str, URL url, C4235x4 c4235x4) {
        this.f10725m = c4012d7;
        AnimatableValueParser.m583w(str);
        this.f10722j = url;
        this.f10723k = c4235x4;
        this.f10724l = str;
    }

    /* JADX INFO: renamed from: a */
    public final void m5598a(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.f10725m.mo5725f().m5852v(new RunnableC4024e7(this, i, exc, bArr, map));
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnectionM5583s;
        Map<String, List<String>> headerFields;
        this.f10725m.mo5847a();
        int responseCode = 0;
        try {
            httpURLConnectionM5583s = this.f10725m.m5583s(this.f10722j);
            try {
                responseCode = httpURLConnectionM5583s.getResponseCode();
                headerFields = httpURLConnectionM5583s.getHeaderFields();
            } catch (IOException e) {
                e = e;
                headerFields = null;
            } catch (Throwable th) {
                th = th;
                headerFields = null;
            }
            try {
                byte[] bArrM5582t = C4012d7.m5582t(httpURLConnectionM5583s);
                httpURLConnectionM5583s.disconnect();
                m5598a(responseCode, null, bArrM5582t, headerFields);
            } catch (IOException e2) {
                e = e2;
                if (httpURLConnectionM5583s != null) {
                    httpURLConnectionM5583s.disconnect();
                }
                m5598a(responseCode, e, null, headerFields);
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnectionM5583s != null) {
                    httpURLConnectionM5583s.disconnect();
                }
                m5598a(responseCode, null, null, headerFields);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnectionM5583s = null;
            headerFields = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnectionM5583s = null;
            headerFields = null;
        }
    }
}

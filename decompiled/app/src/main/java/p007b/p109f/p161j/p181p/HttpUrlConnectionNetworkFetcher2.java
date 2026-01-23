package p007b.p109f.p161j.p181p;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Objects;
import p007b.p109f.p161j.p181p.HttpUrlConnectionNetworkFetcher;
import p007b.p109f.p161j.p181p.NetworkFetchProducer;
import p007b.p109f.p161j.p181p.NetworkFetcher2;

/* JADX INFO: renamed from: b.f.j.p.y, reason: use source file name */
/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpUrlConnectionNetworkFetcher2 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ HttpUrlConnectionNetworkFetcher.a f4261j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ NetworkFetcher2.a f4262k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ HttpUrlConnectionNetworkFetcher f4263l;

    public HttpUrlConnectionNetworkFetcher2(HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher, HttpUrlConnectionNetworkFetcher.a aVar, NetworkFetcher2.a aVar2) {
        this.f4263l = httpUrlConnectionNetworkFetcher;
        this.f4261j = aVar;
        this.f4262k = aVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() throws Throwable {
        HttpURLConnection httpURLConnectionM1418a;
        HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher = this.f4263l;
        HttpUrlConnectionNetworkFetcher.a aVar = this.f4261j;
        NetworkFetcher2.a aVar2 = this.f4262k;
        Objects.requireNonNull(httpUrlConnectionNetworkFetcher);
        InputStream inputStream = null;
        try {
            httpURLConnectionM1418a = httpUrlConnectionNetworkFetcher.m1418a(aVar.f4259b.mo1447e().f19585c, 5);
            try {
                try {
                    aVar.f3991e = httpUrlConnectionNetworkFetcher.f3989c.now();
                    if (httpURLConnectionM1418a != null) {
                        inputStream = httpURLConnectionM1418a.getInputStream();
                        ((NetworkFetchProducer.a) aVar2).m1509b(inputStream, -1);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (httpURLConnectionM1418a == null) {
                        return;
                    }
                } catch (IOException e) {
                    e = e;
                    ((NetworkFetchProducer.a) aVar2).m1508a(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (httpURLConnectionM1418a == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (httpURLConnectionM1418a != null) {
                    throw th;
                }
                httpURLConnectionM1418a.disconnect();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnectionM1418a = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionM1418a = null;
            if (inputStream != null) {
            }
            if (httpURLConnectionM1418a != null) {
            }
        }
        httpURLConnectionM1418a.disconnect();
    }
}

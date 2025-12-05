package p007b.p109f.p161j.p181p;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p126k.MonotonicClock;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: HttpUrlConnectionNetworkFetcher.java */
/* renamed from: b.f.j.p.a0, reason: use source file name */
/* loaded from: classes3.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<a> {

    /* renamed from: a */
    public int f3987a;

    /* renamed from: b */
    public final ExecutorService f3988b;

    /* renamed from: c */
    public final MonotonicClock f3989c;

    /* compiled from: HttpUrlConnectionNetworkFetcher.java */
    /* renamed from: b.f.j.p.a0$a */
    public static class a extends FetchState2 {

        /* renamed from: d */
        public long f3990d;

        /* renamed from: e */
        public long f3991e;

        /* renamed from: f */
        public long f3992f;

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
            super(consumer2, producerContext);
        }
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        RealtimeSinceBootClock realtimeSinceBootClock = RealtimeSinceBootClock.get();
        this.f3988b = Executors.newFixedThreadPool(3);
        this.f3989c = realtimeSinceBootClock;
        this.f3987a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HttpURLConnection m1418a(Uri uri, int i) throws IOException {
        URL url;
        boolean z2;
        Uri uri2 = UriUtil.f3138a;
        if (uri == null) {
            url = null;
        } else {
            try {
                url = new URL(uri.toString());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f3987a);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return httpURLConnection;
        }
        if (responseCode != 307 && responseCode != 308) {
            switch (responseCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    z2 = false;
                    break;
            }
        } else {
            z2 = true;
        }
        if (!z2) {
            httpURLConnection.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        Uri uri3 = headerField != null ? Uri.parse(headerField) : null;
        String scheme = uri.getScheme();
        if (i <= 0 || uri3 == null || AnimatableValueParser.m520g0(uri3.getScheme(), scheme)) {
            throw new IOException(i == 0 ? String.format(Locale.getDefault(), "URL %s follows too many redirects", uri.toString()) : String.format(Locale.getDefault(), "URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        return m1418a(uri3, i - 1);
    }
}

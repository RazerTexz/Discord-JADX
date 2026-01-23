package p007b.p225i.p226a.p288f.p330i.p332b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.e6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4023e6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final C3999c6 f10688j;

    public RunnableC4023e6(C3999c6 c3999c6) {
        this.f10688j = c3999c6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pair pair;
        NetworkInfo activeNetworkInfo;
        URL url;
        C3999c6 c3999c6 = this.f10688j;
        c3999c6.mo5848b();
        if (c3999c6.m5867l().f10655y.m5597b()) {
            c3999c6.mo5726g().f11148m.m5860a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jM5648a = c3999c6.m5867l().f10656z.m5648a();
        c3999c6.m5867l().f10656z.m5649b(jM5648a + 1);
        if (jM5648a >= 5) {
            c3999c6.mo5726g().f11144i.m5860a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            c3999c6.m5867l().f10655y.m5596a(true);
            return;
        }
        C4202u4 c4202u4 = c3999c6.f11202a;
        c4202u4.mo5725f().mo5848b();
        C4202u4.m5936q(c4202u4.m5945n());
        C4124n3 c4124n3M5955z = c4202u4.m5955z();
        c4124n3M5955z.m5497t();
        String str = c4124n3M5955z.f10979c;
        C4009d4 c4009d4M5946o = c4202u4.m5946o();
        c4009d4M5946o.mo5848b();
        Objects.requireNonNull((C3401c) c4009d4M5946o.f11202a.f11267o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (c4009d4M5946o.f10644n == null || jElapsedRealtime >= c4009d4M5946o.f10646p) {
            C3992c c3992c = c4009d4M5946o.f11202a.f11260h;
            Objects.requireNonNull(c3992c);
            c4009d4M5946o.f10646p = c3992c.m5525n(str, C4142p.f11063b) + jElapsedRealtime;
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(c4009d4M5946o.f11202a.f11254b);
                if (advertisingIdInfo != null) {
                    c4009d4M5946o.f10644n = advertisingIdInfo.getId();
                    c4009d4M5946o.f10645o = advertisingIdInfo.isLimitAdTrackingEnabled();
                }
                if (c4009d4M5946o.f10644n == null) {
                    c4009d4M5946o.f10644n = "";
                }
            } catch (Exception e) {
                c4009d4M5946o.mo5726g().f11148m.m5861b("Unable to get advertising id", e);
                c4009d4M5946o.f10644n = "";
            }
            pair = new Pair(c4009d4M5946o.f10644n, Boolean.valueOf(c4009d4M5946o.f10645o));
        } else {
            pair = new Pair(c4009d4M5946o.f10644n, Boolean.valueOf(c4009d4M5946o.f10645o));
        }
        if (!c4202u4.f11260h.m5536y().booleanValue() || ((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
            c4202u4.mo5726g().f11148m.m5860a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        C4012d7 c4012d7M5945n = c4202u4.m5945n();
        c4012d7M5945n.m5857o();
        try {
            activeNetworkInfo = ((ConnectivityManager) c4012d7M5945n.f11202a.f11254b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            activeNetworkInfo = null;
        }
        if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
            c4202u4.mo5726g().f11144i.m5860a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        C4196t9 c4196t9M5949t = c4202u4.m5949t();
        c4202u4.m5955z();
        String str2 = (String) pair.first;
        long jM5648a2 = c4202u4.m5946o().f10656z.m5648a() - 1;
        Objects.requireNonNull(c4196t9M5949t);
        try {
            AnimatableValueParser.m583w(str2);
            AnimatableValueParser.m583w(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 33025L, Integer.valueOf(c4196t9M5949t.m5928y0())), str2, str, Long.valueOf(jM5648a2));
            if (str.equals(c4196t9M5949t.f11202a.f11260h.m5523h("debug.deferred.deeplink", ""))) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            url = new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            c4196t9M5949t.mo5726g().f11141f.m5861b("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            url = null;
        }
        C4012d7 c4012d7M5945n2 = c4202u4.m5945n();
        C4235x4 c4235x4 = new C4235x4(c4202u4);
        c4012d7M5945n2.mo5848b();
        c4012d7M5945n2.m5857o();
        Objects.requireNonNull(url, "null reference");
        c4012d7M5945n2.mo5725f().m5854x(new RunnableC4036f7(c4012d7M5945n2, str, url, c4235x4));
    }
}

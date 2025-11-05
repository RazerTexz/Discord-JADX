package b.i.a.b.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.b.i.e.f;
import b.i.a.b.i.e.i;
import b.i.a.b.i.e.j;
import b.i.a.b.i.e.k;
import b.i.a.b.i.e.o;
import b.i.a.b.i.e.p;
import b.i.a.b.j.f;
import b.i.a.b.j.q.f;
import b.i.a.b.j.q.g;
import b.i.a.b.j.q.m;
import b.i.c.p.h.e;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: CctTransportBackend.java */
/* loaded from: classes3.dex */
public final class d implements m {
    public final b.i.c.p.a a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f744b;
    public final Context c;
    public final URL d;
    public final b.i.a.b.j.v.a e;
    public final b.i.a.b.j.v.a f;
    public final int g;

    /* compiled from: CctTransportBackend.java */
    public static final class a {
        public final URL a;

        /* renamed from: b, reason: collision with root package name */
        public final j f745b;

        @Nullable
        public final String c;

        public a(URL url, j jVar, @Nullable String str) {
            this.a = url;
            this.f745b = jVar;
            this.c = str;
        }
    }

    /* compiled from: CctTransportBackend.java */
    public static final class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final URL f746b;
        public final long c;

        public b(int i, @Nullable URL url, long j) {
            this.a = i;
            this.f746b = url;
            this.c = j;
        }
    }

    public d(Context context, b.i.a.b.j.v.a aVar, b.i.a.b.j.v.a aVar2) {
        e eVar = new e();
        ((b.i.a.b.i.e.b) b.i.a.b.i.e.b.a).a(eVar);
        eVar.e = true;
        this.a = new b.i.c.p.h.d(eVar);
        this.c = context;
        this.f744b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = c(b.i.a.b.i.a.a);
        this.e = aVar2;
        this.f = aVar;
        this.g = 40000;
    }

    public static URL c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(b.d.b.a.a.w("Invalid url: ", str), e);
        }
    }

    @Override // b.i.a.b.j.q.m
    public g a(f fVar) {
        g.a aVar;
        Integer numValueOf;
        String str;
        g.a aVar2;
        f.b bVar;
        g.a aVar3 = g.a.TRANSIENT_ERROR;
        HashMap map = new HashMap();
        b.i.a.b.j.q.a aVar4 = (b.i.a.b.j.q.a) fVar;
        for (b.i.a.b.j.f fVar2 : aVar4.a) {
            String strG = fVar2.g();
            if (map.containsKey(strG)) {
                ((List) map.get(strG)).add(fVar2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(fVar2);
                map.put(strG, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                b.i.a.b.j.f fVar3 = (b.i.a.b.j.f) ((List) entry.getValue()).get(0);
                p pVar = p.DEFAULT;
                Long lValueOf = Long.valueOf(this.f.a());
                Long lValueOf2 = Long.valueOf(this.e.a());
                b.i.a.b.i.e.e eVar = new b.i.a.b.i.e.e(k.a.ANDROID_FIREBASE, new b.i.a.b.i.e.c(Integer.valueOf(fVar3.f("sdk-version")), fVar3.a("model"), fVar3.a("hardware"), fVar3.a("device"), fVar3.a("product"), fVar3.a("os-uild"), fVar3.a("manufacturer"), fVar3.a("fingerprint"), fVar3.a("locale"), fVar3.a("country"), fVar3.a("mcc_mnc"), fVar3.a("application_build"), null), null);
                try {
                    str = null;
                    numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                } catch (NumberFormatException unused) {
                    numValueOf = null;
                    str = (String) entry.getKey();
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    b.i.a.b.j.f fVar4 = (b.i.a.b.j.f) it2.next();
                    b.i.a.b.j.e eVarD = fVar4.d();
                    Iterator it3 = it;
                    b.i.a.b.b bVar2 = eVarD.a;
                    Iterator it4 = it2;
                    if (bVar2.equals(new b.i.a.b.b("proto"))) {
                        byte[] bArr = eVarD.f766b;
                        bVar = new f.b();
                        bVar.d = bArr;
                    } else if (bVar2.equals(new b.i.a.b.b("json"))) {
                        String str2 = new String(eVarD.f766b, Charset.forName(Constants.ENCODING));
                        bVar = new f.b();
                        bVar.e = str2;
                    } else {
                        aVar2 = aVar3;
                        Log.w(b.c.a.a0.d.D0("CctTransportBackend"), String.format("Received event of unsupported encoding %s. Skipping...", bVar2));
                        it2 = it4;
                        it = it3;
                        aVar3 = aVar2;
                    }
                    bVar.a = Long.valueOf(fVar4.e());
                    bVar.c = Long.valueOf(fVar4.h());
                    String str3 = fVar4.b().get("tz-offset");
                    bVar.f = Long.valueOf(str3 == null ? 0L : Long.valueOf(str3).longValue());
                    aVar2 = aVar3;
                    bVar.g = new i(o.b.C.get(fVar4.f("net-type")), o.a.E.get(fVar4.f("mobile-subtype")), null);
                    if (fVar4.c() != null) {
                        bVar.f750b = fVar4.c();
                    }
                    String strW = bVar.a == null ? " eventTimeMs" : "";
                    if (bVar.c == null) {
                        strW = b.d.b.a.a.w(strW, " eventUptimeMs");
                    }
                    if (bVar.f == null) {
                        strW = b.d.b.a.a.w(strW, " timezoneOffsetSeconds");
                    }
                    if (!strW.isEmpty()) {
                        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
                    }
                    arrayList3.add(new b.i.a.b.i.e.f(bVar.a.longValue(), bVar.f750b, bVar.c.longValue(), bVar.d, bVar.e, bVar.f.longValue(), bVar.g, null));
                    it2 = it4;
                    it = it3;
                    aVar3 = aVar2;
                }
                Iterator it5 = it;
                g.a aVar5 = aVar3;
                String strW2 = lValueOf == null ? " requestTimeMs" : "";
                if (lValueOf2 == null) {
                    strW2 = b.d.b.a.a.w(strW2, " requestUptimeMs");
                }
                if (!strW2.isEmpty()) {
                    throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW2));
                }
                arrayList2.add(new b.i.a.b.i.e.g(lValueOf.longValue(), lValueOf2.longValue(), eVar, numValueOf, str, arrayList3, pVar, null));
                it = it5;
                aVar3 = aVar5;
            } else {
                g.a aVar6 = aVar3;
                b.i.a.b.i.e.d dVar = new b.i.a.b.i.e.d(arrayList2);
                URL urlC = this.d;
                if (aVar4.f771b != null) {
                    try {
                        b.i.a.b.i.a aVarA = b.i.a.b.i.a.a(((b.i.a.b.j.q.a) fVar).f771b);
                        String str4 = aVarA.g;
                        str = str4 != null ? str4 : null;
                        String str5 = aVarA.f;
                        if (str5 != null) {
                            urlC = c(str5);
                        }
                    } catch (IllegalArgumentException unused2) {
                        return g.a();
                    }
                }
                try {
                    b bVar3 = (b) b.c.a.a0.d.V1(5, new a(urlC, dVar, str), new b.i.a.b.i.b(this), c.a);
                    int i = bVar3.a;
                    if (i == 200) {
                        return new b.i.a.b.j.q.b(g.a.OK, bVar3.c);
                    }
                    if (i < 500 && i != 404) {
                        return g.a();
                    }
                    aVar = aVar6;
                    try {
                        return new b.i.a.b.j.q.b(aVar, -1L);
                    } catch (IOException e) {
                        e = e;
                        b.c.a.a0.d.c0("CctTransportBackend", "Could not make request to the backend", e);
                        return new b.i.a.b.j.q.b(aVar, -1L);
                    }
                } catch (IOException e2) {
                    e = e2;
                    aVar = aVar6;
                }
            }
        }
    }

    @Override // b.i.a.b.j.q.m
    public b.i.a.b.j.f b(b.i.a.b.j.f fVar) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f744b.getActiveNetworkInfo();
        f.a aVarI = fVar.i();
        aVarI.c().put("sdk-version", String.valueOf(Build.VERSION.SDK_INT));
        aVarI.c().put("model", Build.MODEL);
        aVarI.c().put("hardware", Build.HARDWARE);
        aVarI.c().put("device", Build.DEVICE);
        aVarI.c().put("product", Build.PRODUCT);
        aVarI.c().put("os-uild", Build.ID);
        aVarI.c().put("manufacturer", Build.MANUFACTURER);
        aVarI.c().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        aVarI.c().put("tz-offset", String.valueOf(TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        aVarI.c().put("net-type", String.valueOf(activeNetworkInfo == null ? o.b.NONE.f() : activeNetworkInfo.getType()));
        int i = -1;
        if (activeNetworkInfo == null) {
            subtype = o.a.UNKNOWN_MOBILE_SUBTYPE.f();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = o.a.COMBINED.f();
            } else if (o.a.E.get(subtype) == null) {
                subtype = 0;
            }
        }
        aVarI.c().put("mobile-subtype", String.valueOf(subtype));
        aVarI.c().put("country", Locale.getDefault().getCountry());
        aVarI.c().put("locale", Locale.getDefault().getLanguage());
        aVarI.c().put("mcc_mnc", ((TelephonyManager) this.c.getSystemService("phone")).getSimOperator());
        Context context = this.c;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            b.c.a.a0.d.c0("CctTransportBackend", "Unable to find version code for package", e);
        }
        aVarI.c().put("application_build", Integer.toString(i));
        return aVarI.b();
    }
}

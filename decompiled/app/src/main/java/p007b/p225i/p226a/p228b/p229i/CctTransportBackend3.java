package p007b.p225i.p226a.p228b.p229i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.Nullable;
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
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.p229i.p230e.AutoBatchedLogRequestEncoder;
import p007b.p225i.p226a.p228b.p229i.p230e.AutoValue_AndroidClientInfo;
import p007b.p225i.p226a.p228b.p229i.p230e.AutoValue_BatchedLogRequest;
import p007b.p225i.p226a.p228b.p229i.p230e.AutoValue_ClientInfo;
import p007b.p225i.p226a.p228b.p229i.p230e.AutoValue_LogEvent;
import p007b.p225i.p226a.p228b.p229i.p230e.AutoValue_LogRequest;
import p007b.p225i.p226a.p228b.p229i.p230e.AutoValue_NetworkConnectionInfo;
import p007b.p225i.p226a.p228b.p229i.p230e.BatchedLogRequest;
import p007b.p225i.p226a.p228b.p229i.p230e.ClientInfo2;
import p007b.p225i.p226a.p228b.p229i.p230e.NetworkConnectionInfo;
import p007b.p225i.p226a.p228b.p229i.p230e.QosTier;
import p007b.p225i.p226a.p228b.p231j.EncodedPayload;
import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.p232q.AutoValue_BackendRequest;
import p007b.p225i.p226a.p228b.p231j.p232q.AutoValue_BackendResponse;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendRequest;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendResponse;
import p007b.p225i.p226a.p228b.p231j.p232q.TransportBackend;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;
import p007b.p225i.p361c.p393p.DataEncoder;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder4;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder5;

/* compiled from: CctTransportBackend.java */
/* renamed from: b.i.a.b.i.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class CctTransportBackend3 implements TransportBackend {

    /* renamed from: a */
    public final DataEncoder f5132a;

    /* renamed from: b */
    public final ConnectivityManager f5133b;

    /* renamed from: c */
    public final Context f5134c;

    /* renamed from: d */
    public final URL f5135d;

    /* renamed from: e */
    public final Clock3 f5136e;

    /* renamed from: f */
    public final Clock3 f5137f;

    /* renamed from: g */
    public final int f5138g;

    /* compiled from: CctTransportBackend.java */
    /* renamed from: b.i.a.b.i.d$a */
    public static final class a {

        /* renamed from: a */
        public final URL f5139a;

        /* renamed from: b */
        public final BatchedLogRequest f5140b;

        /* renamed from: c */
        @Nullable
        public final String f5141c;

        public a(URL url, BatchedLogRequest batchedLogRequest, @Nullable String str) {
            this.f5139a = url;
            this.f5140b = batchedLogRequest;
            this.f5141c = str;
        }
    }

    /* compiled from: CctTransportBackend.java */
    /* renamed from: b.i.a.b.i.d$b */
    public static final class b {

        /* renamed from: a */
        public final int f5142a;

        /* renamed from: b */
        @Nullable
        public final URL f5143b;

        /* renamed from: c */
        public final long f5144c;

        public b(int i, @Nullable URL url, long j) {
            this.f5142a = i;
            this.f5143b = url;
            this.f5144c = j;
        }
    }

    public CctTransportBackend3(Context context, Clock3 clock3, Clock3 clock32) {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = new JsonDataEncoderBuilder5();
        ((AutoBatchedLogRequestEncoder) AutoBatchedLogRequestEncoder.f5145a).m2311a(jsonDataEncoderBuilder5);
        jsonDataEncoderBuilder5.f12825e = true;
        this.f5132a = new JsonDataEncoderBuilder4(jsonDataEncoderBuilder5);
        this.f5134c = context;
        this.f5133b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f5135d = m2296c(CCTDestination.f5123a);
        this.f5136e = clock32;
        this.f5137f = clock3;
        this.f5138g = 40000;
    }

    /* renamed from: c */
    public static URL m2296c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(outline.m883w("Invalid url: ", str), e);
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.TransportBackend
    /* renamed from: a */
    public BackendResponse mo2297a(BackendRequest backendRequest) {
        BackendResponse.a aVar;
        Integer numValueOf;
        String str;
        BackendResponse.a aVar2;
        AutoValue_LogEvent.b bVar;
        BackendResponse.a aVar3 = BackendResponse.a.TRANSIENT_ERROR;
        HashMap map = new HashMap();
        AutoValue_BackendRequest autoValue_BackendRequest = (AutoValue_BackendRequest) backendRequest;
        for (EventInternal eventInternal : autoValue_BackendRequest.f5300a) {
            String strMo2340g = eventInternal.mo2340g();
            if (map.containsKey(strMo2340g)) {
                ((List) map.get(strMo2340g)).add(eventInternal);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                map.put(strMo2340g, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
                QosTier qosTier = QosTier.DEFAULT;
                Long lValueOf = Long.valueOf(this.f5137f.mo2413a());
                Long lValueOf2 = Long.valueOf(this.f5136e.mo2413a());
                AutoValue_ClientInfo autoValue_ClientInfo = new AutoValue_ClientInfo(ClientInfo2.a.ANDROID_FIREBASE, new AutoValue_AndroidClientInfo(Integer.valueOf(eventInternal2.m2355f("sdk-version")), eventInternal2.m2354a("model"), eventInternal2.m2354a("hardware"), eventInternal2.m2354a("device"), eventInternal2.m2354a("product"), eventInternal2.m2354a("os-uild"), eventInternal2.m2354a("manufacturer"), eventInternal2.m2354a("fingerprint"), eventInternal2.m2354a("locale"), eventInternal2.m2354a("country"), eventInternal2.m2354a("mcc_mnc"), eventInternal2.m2354a("application_build"), null), null);
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
                    EventInternal eventInternal3 = (EventInternal) it2.next();
                    EncodedPayload encodedPayloadMo2338d = eventInternal3.mo2338d();
                    Iterator it3 = it;
                    Encoding2 encoding2 = encodedPayloadMo2338d.f5276a;
                    Iterator it4 = it2;
                    if (encoding2.equals(new Encoding2("proto"))) {
                        byte[] bArr = encodedPayloadMo2338d.f5277b;
                        bVar = new AutoValue_LogEvent.b();
                        bVar.f5177d = bArr;
                    } else if (encoding2.equals(new Encoding2("json"))) {
                        String str2 = new String(encodedPayloadMo2338d.f5277b, Charset.forName(Constants.ENCODING));
                        bVar = new AutoValue_LogEvent.b();
                        bVar.f5178e = str2;
                    } else {
                        aVar2 = aVar3;
                        Log.w(AnimatableValueParser.m427D0("CctTransportBackend"), String.format("Received event of unsupported encoding %s. Skipping...", encoding2));
                        it2 = it4;
                        it = it3;
                        aVar3 = aVar2;
                    }
                    bVar.f5174a = Long.valueOf(eventInternal3.mo2339e());
                    bVar.f5176c = Long.valueOf(eventInternal3.mo2341h());
                    String str3 = eventInternal3.mo2336b().get("tz-offset");
                    bVar.f5179f = Long.valueOf(str3 == null ? 0L : Long.valueOf(str3).longValue());
                    aVar2 = aVar3;
                    bVar.f5180g = new AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.b.f5219C.get(eventInternal3.m2355f("net-type")), NetworkConnectionInfo.a.f5198E.get(eventInternal3.m2355f("mobile-subtype")), null);
                    if (eventInternal3.mo2337c() != null) {
                        bVar.f5175b = eventInternal3.mo2337c();
                    }
                    String strM883w = bVar.f5174a == null ? " eventTimeMs" : "";
                    if (bVar.f5176c == null) {
                        strM883w = outline.m883w(strM883w, " eventUptimeMs");
                    }
                    if (bVar.f5179f == null) {
                        strM883w = outline.m883w(strM883w, " timezoneOffsetSeconds");
                    }
                    if (!strM883w.isEmpty()) {
                        throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
                    }
                    arrayList3.add(new AutoValue_LogEvent(bVar.f5174a.longValue(), bVar.f5175b, bVar.f5176c.longValue(), bVar.f5177d, bVar.f5178e, bVar.f5179f.longValue(), bVar.f5180g, null));
                    it2 = it4;
                    it = it3;
                    aVar3 = aVar2;
                }
                Iterator it5 = it;
                BackendResponse.a aVar4 = aVar3;
                String strM883w2 = lValueOf == null ? " requestTimeMs" : "";
                if (lValueOf2 == null) {
                    strM883w2 = outline.m883w(strM883w2, " requestUptimeMs");
                }
                if (!strM883w2.isEmpty()) {
                    throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w2));
                }
                arrayList2.add(new AutoValue_LogRequest(lValueOf.longValue(), lValueOf2.longValue(), autoValue_ClientInfo, numValueOf, str, arrayList3, qosTier, null));
                it = it5;
                aVar3 = aVar4;
            } else {
                BackendResponse.a aVar5 = aVar3;
                AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = new AutoValue_BatchedLogRequest(arrayList2);
                URL urlM2296c = this.f5135d;
                if (autoValue_BackendRequest.f5301b != null) {
                    try {
                        CCTDestination cCTDestinationM2293a = CCTDestination.m2293a(((AutoValue_BackendRequest) backendRequest).f5301b);
                        String str4 = cCTDestinationM2293a.f5129g;
                        str = str4 != null ? str4 : null;
                        String str5 = cCTDestinationM2293a.f5128f;
                        if (str5 != null) {
                            urlM2296c = m2296c(str5);
                        }
                    } catch (IllegalArgumentException unused2) {
                        return BackendResponse.m2370a();
                    }
                }
                try {
                    b bVar2 = (b) AnimatableValueParser.m482V1(5, new a(urlM2296c, autoValue_BatchedLogRequest, str), new CctTransportBackend(this), CctTransportBackend2.f5131a);
                    int i = bVar2.f5142a;
                    if (i == 200) {
                        return new AutoValue_BackendResponse(BackendResponse.a.OK, bVar2.f5144c);
                    }
                    if (i < 500 && i != 404) {
                        return BackendResponse.m2370a();
                    }
                    aVar = aVar5;
                    try {
                        return new AutoValue_BackendResponse(aVar, -1L);
                    } catch (IOException e) {
                        e = e;
                        AnimatableValueParser.m504c0("CctTransportBackend", "Could not make request to the backend", e);
                        return new AutoValue_BackendResponse(aVar, -1L);
                    }
                } catch (IOException e2) {
                    e = e2;
                    aVar = aVar5;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.TransportBackend
    /* renamed from: b */
    public EventInternal mo2298b(EventInternal eventInternal) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f5133b.getActiveNetworkInfo();
        EventInternal.a aVarM2356i = eventInternal.m2356i();
        aVarM2356i.mo2343c().put("sdk-version", String.valueOf(Build.VERSION.SDK_INT));
        aVarM2356i.mo2343c().put("model", Build.MODEL);
        aVarM2356i.mo2343c().put("hardware", Build.HARDWARE);
        aVarM2356i.mo2343c().put("device", Build.DEVICE);
        aVarM2356i.mo2343c().put("product", Build.PRODUCT);
        aVarM2356i.mo2343c().put("os-uild", Build.ID);
        aVarM2356i.mo2343c().put("manufacturer", Build.MANUFACTURER);
        aVarM2356i.mo2343c().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        aVarM2356i.mo2343c().put("tz-offset", String.valueOf(TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        aVarM2356i.mo2343c().put("net-type", String.valueOf(activeNetworkInfo == null ? NetworkConnectionInfo.b.NONE.m2335f() : activeNetworkInfo.getType()));
        int i = -1;
        if (activeNetworkInfo == null) {
            subtype = NetworkConnectionInfo.a.UNKNOWN_MOBILE_SUBTYPE.m2334f();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = NetworkConnectionInfo.a.COMBINED.m2334f();
            } else if (NetworkConnectionInfo.a.f5198E.get(subtype) == null) {
                subtype = 0;
            }
        }
        aVarM2356i.mo2343c().put("mobile-subtype", String.valueOf(subtype));
        aVarM2356i.mo2343c().put("country", Locale.getDefault().getCountry());
        aVarM2356i.mo2343c().put("locale", Locale.getDefault().getLanguage());
        aVarM2356i.mo2343c().put("mcc_mnc", ((TelephonyManager) this.f5134c.getSystemService("phone")).getSimOperator());
        Context context = this.f5134c;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            AnimatableValueParser.m504c0("CctTransportBackend", "Unable to find version code for package", e);
        }
        aVarM2356i.mo2343c().put("application_build", Integer.toString(i));
        return aVarM2356i.mo2342b();
    }
}

package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.h.l.y1 */
/* loaded from: classes3.dex */
public final class C3900y1 implements InterfaceC3594b2 {

    /* renamed from: a */
    @GuardedBy("ConfigurationContentLoader.class")
    public static final Map<Uri, C3900y1> f10417a = new ArrayMap();

    /* renamed from: b */
    public static final String[] f10418b = {"key", "value"};

    /* renamed from: c */
    public final ContentResolver f10419c;

    /* renamed from: d */
    public final Uri f10420d;

    /* renamed from: e */
    public final ContentObserver f10421e;

    /* renamed from: f */
    public final Object f10422f;

    /* renamed from: g */
    public volatile Map<String, String> f10423g;

    /* renamed from: h */
    @GuardedBy("this")
    public final List<InterfaceC3913z1> f10424h;

    public C3900y1(ContentResolver contentResolver, Uri uri) {
        C3580a2 c3580a2 = new C3580a2(this);
        this.f10421e = c3580a2;
        this.f10422f = new Object();
        this.f10424h = new ArrayList();
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri);
        this.f10419c = contentResolver;
        this.f10420d = uri;
        contentResolver.registerContentObserver(uri, false, c3580a2);
    }

    /* renamed from: a */
    public static C3900y1 m5376a(ContentResolver contentResolver, Uri uri) {
        C3900y1 c3900y1;
        synchronized (C3900y1.class) {
            Map<Uri, C3900y1> map = f10417a;
            c3900y1 = map.get(uri);
            if (c3900y1 == null) {
                try {
                    C3900y1 c3900y12 = new C3900y1(contentResolver, uri);
                    try {
                        map.put(uri, c3900y12);
                    } catch (SecurityException unused) {
                    }
                    c3900y1 = c3900y12;
                } catch (SecurityException unused2) {
                }
            }
        }
        return c3900y1;
    }

    /* renamed from: c */
    public static synchronized void m5377c() {
        for (C3900y1 c3900y1 : f10417a.values()) {
            c3900y1.f10419c.unregisterContentObserver(c3900y1.f10421e);
        }
        f10417a.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final Map<String, String> m5378b() {
        Map<String, String> map;
        Map<String, String> map2;
        Map<String, String> map3 = this.f10423g;
        Map<String, String> map4 = map3;
        if (map3 == null) {
            synchronized (this.f10422f) {
                Map<String, String> map5 = this.f10423g;
                map = map5;
                if (map5 == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map2 = (Map) C3404f.m4248T1(new C3887x1(this));
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        map2 = null;
                    }
                    this.f10423g = map2;
                    threadPolicyAllowThreadDiskReads = map2;
                    map = threadPolicyAllowThreadDiskReads;
                }
            }
            map4 = map;
        }
        return map4 != null ? map4 : Collections.emptyMap();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3594b2
    /* renamed from: g */
    public final /* synthetic */ Object mo4567g(String str) {
        return m5378b().get(str);
    }
}

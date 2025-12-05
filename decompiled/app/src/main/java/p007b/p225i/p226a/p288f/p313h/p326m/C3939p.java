package p007b.p225i.p226a.p288f.p313h.p326m;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* renamed from: b.i.a.f.h.m.p */
/* loaded from: classes3.dex */
public class C3939p {

    /* renamed from: f */
    public static HashMap<String, String> f10471f;

    /* renamed from: k */
    public static Object f10476k;

    /* renamed from: l */
    public static boolean f10477l;

    /* renamed from: a */
    public static final Uri f10466a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b */
    public static final Uri f10467b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c */
    public static final Pattern f10468c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d */
    public static final Pattern f10469d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e */
    public static final AtomicBoolean f10470e = new AtomicBoolean();

    /* renamed from: g */
    public static final HashMap<String, Boolean> f10472g = new HashMap<>();

    /* renamed from: h */
    public static final HashMap<String, Integer> f10473h = new HashMap<>();

    /* renamed from: i */
    public static final HashMap<String, Long> f10474i = new HashMap<>();

    /* renamed from: j */
    public static final HashMap<String, Float> f10475j = new HashMap<>();

    /* renamed from: m */
    public static String[] f10478m = new String[0];

    /* renamed from: a */
    public static void m5409a(ContentResolver contentResolver) {
        if (f10471f == null) {
            f10470e.set(false);
            f10471f = new HashMap<>();
            f10476k = new Object();
            f10477l = false;
            contentResolver.registerContentObserver(f10466a, true, new C3940q());
            return;
        }
        if (f10470e.getAndSet(false)) {
            f10471f.clear();
            f10472g.clear();
            f10473h.clear();
            f10474i.clear();
            f10475j.clear();
            f10476k = new Object();
            f10477l = false;
        }
    }

    /* renamed from: b */
    public static void m5410b(Object obj, String str, String str2) {
        synchronized (C3939p.class) {
            if (obj == f10476k) {
                f10471f.put(str, str2);
            }
        }
    }
}

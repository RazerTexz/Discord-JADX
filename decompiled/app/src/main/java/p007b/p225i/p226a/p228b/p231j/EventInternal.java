package p007b.p225i.p226a.p228b.p231j;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.Map;
import p007b.p225i.p226a.p228b.p231j.AutoValue_EventInternal;

/* compiled from: EventInternal.java */
@AutoValue
/* renamed from: b.i.a.b.j.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class EventInternal {

    /* compiled from: EventInternal.java */
    @AutoValue.Builder
    /* renamed from: b.i.a.b.j.f$a */
    public static abstract class a {
        /* renamed from: a */
        public final a m2357a(String str, String str2) {
            mo2343c().put(str, str2);
            return this;
        }

        /* renamed from: b */
        public abstract EventInternal mo2342b();

        /* renamed from: c */
        public abstract Map<String, String> mo2343c();
    }

    /* renamed from: a */
    public final String m2354a(String str) {
        String str2 = mo2336b().get(str);
        return str2 == null ? "" : str2;
    }

    /* renamed from: b */
    public abstract Map<String, String> mo2336b();

    @Nullable
    /* renamed from: c */
    public abstract Integer mo2337c();

    /* renamed from: d */
    public abstract EncodedPayload mo2338d();

    /* renamed from: e */
    public abstract long mo2339e();

    /* renamed from: f */
    public final int m2355f(String str) {
        String str2 = mo2336b().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    /* renamed from: g */
    public abstract String mo2340g();

    /* renamed from: h */
    public abstract long mo2341h();

    /* renamed from: i */
    public a m2356i() {
        AutoValue_EventInternal.b bVar = new AutoValue_EventInternal.b();
        bVar.m2346f(mo2340g());
        bVar.f5253b = mo2337c();
        bVar.m2344d(mo2338d());
        bVar.m2345e(mo2339e());
        bVar.m2347g(mo2341h());
        bVar.f5257f = new HashMap(mo2336b());
        return bVar;
    }
}

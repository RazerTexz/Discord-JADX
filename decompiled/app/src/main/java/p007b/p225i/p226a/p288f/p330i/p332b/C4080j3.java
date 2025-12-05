package p007b.p225i.p226a.p288f.p330i.p332b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.j3 */
/* loaded from: classes3.dex */
public final class C4080j3<V> {

    /* renamed from: a */
    public static final Object f10838a = new Object();

    /* renamed from: b */
    public final String f10839b;

    /* renamed from: c */
    public final InterfaceC4056h3<V> f10840c;

    /* renamed from: d */
    public final V f10841d;

    /* renamed from: e */
    public final V f10842e;

    /* renamed from: f */
    public final Object f10843f = new Object();

    /* renamed from: g */
    @GuardedBy("cachingLock")
    public volatile V f10844g = null;

    /* JADX WARN: Multi-variable type inference failed */
    public C4080j3(String str, Object obj, Object obj2, InterfaceC4056h3 interfaceC4056h3, C4032f3 c4032f3) {
        this.f10839b = str;
        this.f10841d = obj;
        this.f10842e = obj2;
        this.f10840c = interfaceC4056h3;
    }

    /* renamed from: a */
    public final V m5693a(@Nullable V v) {
        synchronized (this.f10843f) {
        }
        if (v != null) {
            return v;
        }
        if (C3404f.f9589c == null) {
            return this.f10841d;
        }
        synchronized (f10838a) {
            if (C4051ga.m5647a()) {
                return this.f10844g == null ? this.f10841d : this.f10844g;
            }
            try {
                for (C4080j3<?> c4080j3 : C4142p.f11061a) {
                    if (C4051ga.m5647a()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v2 = null;
                    try {
                        InterfaceC4056h3<?> interfaceC4056h3 = c4080j3.f10840c;
                        if (interfaceC4056h3 != null) {
                            v2 = (V) interfaceC4056h3.mo5446a();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (f10838a) {
                        c4080j3.f10844g = v2;
                    }
                }
            } catch (SecurityException unused2) {
            }
            InterfaceC4056h3<V> interfaceC4056h32 = this.f10840c;
            if (interfaceC4056h32 == null) {
                return this.f10841d;
            }
            try {
                return interfaceC4056h32.mo5446a();
            } catch (IllegalStateException unused3) {
                return this.f10841d;
            } catch (SecurityException unused4) {
                return this.f10841d;
            }
        }
    }
}

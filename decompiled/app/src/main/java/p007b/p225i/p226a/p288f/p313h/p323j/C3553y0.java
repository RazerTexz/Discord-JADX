package p007b.p225i.p226a.p288f.p313h.p323j;

import android.os.SystemClock;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.InterfaceC3400b;

/* renamed from: b.i.a.f.h.j.y0 */
/* loaded from: classes3.dex */
public final class C3553y0 {

    /* renamed from: a */
    public final InterfaceC3400b f9824a;

    /* renamed from: b */
    public long f9825b;

    public C3553y0(InterfaceC3400b interfaceC3400b) {
        Objects.requireNonNull(interfaceC3400b, "null reference");
        this.f9824a = interfaceC3400b;
    }

    /* renamed from: a */
    public final void m4506a() {
        Objects.requireNonNull((C3401c) this.f9824a);
        this.f9825b = SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public final boolean m4507b(long j) {
        if (this.f9825b == 0) {
            return true;
        }
        Objects.requireNonNull((C3401c) this.f9824a);
        return SystemClock.elapsedRealtime() - this.f9825b > j;
    }
}

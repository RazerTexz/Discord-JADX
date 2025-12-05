package p007b.p225i.p226a.p288f.p313h.p325l;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.h.l.y2 */
/* loaded from: classes3.dex */
public final class C3901y2<T> extends AbstractC3888x2<T> {
    private final T zza;

    public C3901y2(T t) {
        this.zza = t;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3888x2
    /* renamed from: b */
    public final boolean mo5342b() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3888x2
    /* renamed from: c */
    public final T mo5343c() {
        return this.zza;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof C3901y2) {
            return this.zza.equals(((C3901y2) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        return outline.m859k(strValueOf.length() + 13, "Optional.of(", strValueOf, ")");
    }
}

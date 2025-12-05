package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: SeekMap.java */
/* renamed from: b.i.a.c.x2.t, reason: use source file name */
/* loaded from: classes3.dex */
public interface SeekMap {

    /* compiled from: SeekMap.java */
    /* renamed from: b.i.a.c.x2.t$b */
    public static class b implements SeekMap {

        /* renamed from: a */
        public final long f8995a;

        /* renamed from: b */
        public final a f8996b;

        public b(long j, long j2) {
            this.f8995a = j;
            this.f8996b = new a(j2 == 0 ? SeekPoint.f8997a : new SeekPoint(0L, j2));
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: c */
        public boolean mo3619c() {
            return false;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: h */
        public a mo3620h(long j) {
            return this.f8996b;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
        /* renamed from: i */
        public long mo3621i() {
            return this.f8995a;
        }
    }

    /* renamed from: c */
    boolean mo3619c();

    /* renamed from: h */
    a mo3620h(long j);

    /* renamed from: i */
    long mo3621i();

    /* compiled from: SeekMap.java */
    /* renamed from: b.i.a.c.x2.t$a */
    public static final class a {

        /* renamed from: a */
        public final SeekPoint f8993a;

        /* renamed from: b */
        public final SeekPoint f8994b;

        public a(SeekPoint seekPoint) {
            this.f8993a = seekPoint;
            this.f8994b = seekPoint;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8993a.equals(aVar.f8993a) && this.f8994b.equals(aVar.f8994b);
        }

        public int hashCode() {
            return this.f8994b.hashCode() + (this.f8993a.hashCode() * 31);
        }

        public String toString() {
            String strM857j;
            String strValueOf = String.valueOf(this.f8993a);
            if (this.f8993a.equals(this.f8994b)) {
                strM857j = "";
            } else {
                String strValueOf2 = String.valueOf(this.f8994b);
                strM857j = outline.m857j(strValueOf2.length() + 2, ", ", strValueOf2);
            }
            return outline.m861l(outline.m841b(strM857j, strValueOf.length() + 2), "[", strValueOf, strM857j, "]");
        }

        public a(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.f8993a = seekPoint;
            this.f8994b = seekPoint2;
        }
    }
}

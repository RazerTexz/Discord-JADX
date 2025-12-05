package p007b.p225i.p361c.p368l;

import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: Dependency.java */
/* renamed from: b.i.c.l.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class Dependency2 {

    /* renamed from: a */
    public final Class<?> f12201a;

    /* renamed from: b */
    public final int f12202b;

    /* renamed from: c */
    public final int f12203c;

    public Dependency2(Class<?> cls, int i, int i2) {
        Objects.requireNonNull(cls, "Null dependency anInterface.");
        this.f12201a = cls;
        this.f12202b = i;
        this.f12203c = i2;
    }

    /* renamed from: a */
    public boolean m6358a() {
        return this.f12202b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency2)) {
            return false;
        }
        Dependency2 dependency2 = (Dependency2) obj;
        return this.f12201a == dependency2.f12201a && this.f12202b == dependency2.f12202b && this.f12203c == dependency2.f12203c;
    }

    public int hashCode() {
        return ((((this.f12201a.hashCode() ^ 1000003) * 1000003) ^ this.f12202b) * 1000003) ^ this.f12203c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f12201a);
        sb.append(", type=");
        int i = this.f12202b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        return outline.m827O(sb, this.f12203c == 0, "}");
    }
}

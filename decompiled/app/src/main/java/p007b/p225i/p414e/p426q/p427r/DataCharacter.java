package p007b.p225i.p414e.p426q.p427r;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: DataCharacter.java */
/* renamed from: b.i.e.q.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public class DataCharacter {

    /* renamed from: a */
    public final int f13405a;

    /* renamed from: b */
    public final int f13406b;

    public DataCharacter(int i, int i2) {
        this.f13405a = i;
        this.f13406b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        return this.f13405a == dataCharacter.f13405a && this.f13406b == dataCharacter.f13406b;
    }

    public final int hashCode() {
        return this.f13405a ^ this.f13406b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13405a);
        sb.append("(");
        return outline.m813A(sb, this.f13406b, ')');
    }
}

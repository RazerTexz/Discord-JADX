package b.i.e.q.r;

/* compiled from: DataCharacter.java */
/* loaded from: classes3.dex */
public class b {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1863b;

    public b(int i, int i2) {
        this.a = i;
        this.f1863b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.f1863b == bVar.f1863b;
    }

    public final int hashCode() {
        return this.a ^ this.f1863b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("(");
        return b.d.b.a.a.A(sb, this.f1863b, ')');
    }
}

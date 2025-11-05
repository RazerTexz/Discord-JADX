package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import b.i.a.b.i.e.k;

/* compiled from: AutoValue_ClientInfo.java */
/* loaded from: classes3.dex */
public final class e extends k {
    public final k.a a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.a.b.i.e.a f748b;

    public e(k.a aVar, b.i.a.b.i.e.a aVar2, a aVar3) {
        this.a = aVar;
        this.f748b = aVar2;
    }

    @Override // b.i.a.b.i.e.k
    @Nullable
    public b.i.a.b.i.e.a a() {
        return this.f748b;
    }

    @Override // b.i.a.b.i.e.k
    @Nullable
    public k.a b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k.a aVar = this.a;
        if (aVar != null ? aVar.equals(kVar.b()) : kVar.b() == null) {
            b.i.a.b.i.e.a aVar2 = this.f748b;
            if (aVar2 == null) {
                if (kVar.a() == null) {
                    return true;
                }
            } else if (aVar2.equals(kVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k.a aVar = this.a;
        int iHashCode = ((aVar == null ? 0 : aVar.hashCode()) ^ 1000003) * 1000003;
        b.i.a.b.i.e.a aVar2 = this.f748b;
        return iHashCode ^ (aVar2 != null ? aVar2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ClientInfo{clientType=");
        sbU.append(this.a);
        sbU.append(", androidClientInfo=");
        sbU.append(this.f748b);
        sbU.append("}");
        return sbU.toString();
    }
}

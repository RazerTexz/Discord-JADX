package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import b.i.a.b.i.e.o;

/* compiled from: AutoValue_NetworkConnectionInfo.java */
/* loaded from: classes3.dex */
public final class i extends o {
    public final o.b a;

    /* renamed from: b, reason: collision with root package name */
    public final o.a f752b;

    public i(o.b bVar, o.a aVar, a aVar2) {
        this.a = bVar;
        this.f752b = aVar;
    }

    @Override // b.i.a.b.i.e.o
    @Nullable
    public o.a a() {
        return this.f752b;
    }

    @Override // b.i.a.b.i.e.o
    @Nullable
    public o.b b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.b bVar = this.a;
        if (bVar != null ? bVar.equals(oVar.b()) : oVar.b() == null) {
            o.a aVar = this.f752b;
            if (aVar == null) {
                if (oVar.a() == null) {
                    return true;
                }
            } else if (aVar.equals(oVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.b bVar = this.a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        o.a aVar = this.f752b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("NetworkConnectionInfo{networkType=");
        sbU.append(this.a);
        sbU.append(", mobileSubtype=");
        sbU.append(this.f752b);
        sbU.append("}");
        return sbU.toString();
    }
}

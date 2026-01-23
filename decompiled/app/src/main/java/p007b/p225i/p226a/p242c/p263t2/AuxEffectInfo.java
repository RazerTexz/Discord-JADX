package p007b.p225i.p226a.p242c.p263t2;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.t2.u, reason: use source file name */
/* JADX INFO: compiled from: AuxEffectInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AuxEffectInfo {

    /* JADX INFO: renamed from: a */
    public final int f7835a;

    /* JADX INFO: renamed from: b */
    public final float f7836b;

    public AuxEffectInfo(int i, float f) {
        this.f7835a = i;
        this.f7836b = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuxEffectInfo.class != obj.getClass()) {
            return false;
        }
        AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
        return this.f7835a == auxEffectInfo.f7835a && Float.compare(auxEffectInfo.f7836b, this.f7836b) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f7836b) + ((527 + this.f7835a) * 31);
    }
}

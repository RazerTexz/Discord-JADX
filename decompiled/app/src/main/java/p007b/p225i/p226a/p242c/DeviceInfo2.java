package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;

/* compiled from: DeviceInfo.java */
/* renamed from: b.i.a.c.c1, reason: use source file name */
/* loaded from: classes3.dex */
public final class DeviceInfo2 implements Bundleable {

    /* renamed from: j */
    public final int f6167j;

    /* renamed from: k */
    public final int f6168k;

    /* renamed from: l */
    public final int f6169l;

    public DeviceInfo2(int i, int i2, int i3) {
        this.f6167j = i;
        this.f6168k = i2;
        this.f6169l = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo2)) {
            return false;
        }
        DeviceInfo2 deviceInfo2 = (DeviceInfo2) obj;
        return this.f6167j == deviceInfo2.f6167j && this.f6168k == deviceInfo2.f6168k && this.f6169l == deviceInfo2.f6169l;
    }

    public int hashCode() {
        return ((((527 + this.f6167j) * 31) + this.f6168k) * 31) + this.f6169l;
    }
}

package p007b.p109f.p161j.p175j;

/* compiled from: ImmutableQualityInfo.java */
/* renamed from: b.f.j.j.h, reason: use source file name */
/* loaded from: classes.dex */
public class ImmutableQualityInfo implements QualityInfo {

    /* renamed from: a */
    public static final QualityInfo f3908a = new ImmutableQualityInfo(Integer.MAX_VALUE, true, true);

    /* renamed from: b */
    public int f3909b;

    /* renamed from: c */
    public boolean f3910c;

    /* renamed from: d */
    public boolean f3911d;

    public ImmutableQualityInfo(int i, boolean z2, boolean z3) {
        this.f3909b = i;
        this.f3910c = z2;
        this.f3911d = z3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableQualityInfo)) {
            return false;
        }
        ImmutableQualityInfo immutableQualityInfo = (ImmutableQualityInfo) obj;
        return this.f3909b == immutableQualityInfo.f3909b && this.f3910c == immutableQualityInfo.f3910c && this.f3911d == immutableQualityInfo.f3911d;
    }

    public int hashCode() {
        return (this.f3909b ^ (this.f3910c ? 4194304 : 0)) ^ (this.f3911d ? 8388608 : 0);
    }
}

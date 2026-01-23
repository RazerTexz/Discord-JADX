package p007b.p109f.p161j.p175j;

/* JADX INFO: renamed from: b.f.j.j.h, reason: use source file name */
/* JADX INFO: compiled from: ImmutableQualityInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class ImmutableQualityInfo implements QualityInfo {

    /* JADX INFO: renamed from: a */
    public static final QualityInfo f3908a = new ImmutableQualityInfo(Integer.MAX_VALUE, true, true);

    /* JADX INFO: renamed from: b */
    public int f3909b;

    /* JADX INFO: renamed from: c */
    public boolean f3910c;

    /* JADX INFO: renamed from: d */
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

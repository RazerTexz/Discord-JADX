package p007b.p485q.p486a.p488i;

/* compiled from: ExifInfo.java */
/* renamed from: b.q.a.i.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ExifInfo {

    /* renamed from: a */
    public int f14402a;

    /* renamed from: b */
    public int f14403b;

    /* renamed from: c */
    public int f14404c;

    public ExifInfo(int i, int i2, int i3) {
        this.f14402a = i;
        this.f14403b = i2;
        this.f14404c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ExifInfo.class != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        return this.f14402a == exifInfo.f14402a && this.f14403b == exifInfo.f14403b && this.f14404c == exifInfo.f14404c;
    }

    public int hashCode() {
        return (((this.f14402a * 31) + this.f14403b) * 31) + this.f14404c;
    }
}

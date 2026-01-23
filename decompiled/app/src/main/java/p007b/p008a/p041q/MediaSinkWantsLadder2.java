package p007b.p008a.p041q;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.b, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsLadder2 {

    /* JADX INFO: renamed from: a */
    public final int f1602a;

    /* JADX INFO: renamed from: b */
    public final int f1603b;

    /* JADX INFO: renamed from: c */
    public final int f1604c;

    /* JADX INFO: renamed from: d */
    public final Integer f1605d;

    public MediaSinkWantsLadder2(int i, int i2, int i3, Integer num) {
        this.f1602a = i;
        this.f1603b = i2;
        this.f1604c = i3;
        this.f1605d = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSinkWantsLadder2)) {
            return false;
        }
        MediaSinkWantsLadder2 mediaSinkWantsLadder2 = (MediaSinkWantsLadder2) obj;
        return this.f1602a == mediaSinkWantsLadder2.f1602a && this.f1603b == mediaSinkWantsLadder2.f1603b && this.f1604c == mediaSinkWantsLadder2.f1604c && Intrinsics3.areEqual(this.f1605d, mediaSinkWantsLadder2.f1605d);
    }

    public int hashCode() {
        int i = ((((this.f1602a * 31) + this.f1603b) * 31) + this.f1604c) * 31;
        Integer num = this.f1605d;
        return i + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("IVideoQuality(width=");
        sbM833U.append(this.f1602a);
        sbM833U.append(", height=");
        sbM833U.append(this.f1603b);
        sbM833U.append(", framerate=");
        sbM833U.append(this.f1604c);
        sbM833U.append(", pixelCount=");
        return outline.m818F(sbM833U, this.f1605d, ")");
    }
}

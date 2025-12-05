package p007b.p008a.p041q;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MediaSinkWantsLadder.kt */
/* renamed from: b.a.q.a, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaSinkWantsLadder {

    /* renamed from: a */
    public final int f1599a;

    /* renamed from: b */
    public final int f1600b;

    /* renamed from: c */
    public final Integer f1601c;

    public MediaSinkWantsLadder(int i, int i2, Integer num) {
        this.f1599a = i;
        this.f1600b = i2;
        this.f1601c = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSinkWantsLadder)) {
            return false;
        }
        MediaSinkWantsLadder mediaSinkWantsLadder = (MediaSinkWantsLadder) obj;
        return this.f1599a == mediaSinkWantsLadder.f1599a && this.f1600b == mediaSinkWantsLadder.f1600b && Intrinsics3.areEqual(this.f1601c, mediaSinkWantsLadder.f1601c);
    }

    public int hashCode() {
        int i = ((this.f1599a * 31) + this.f1600b) * 31;
        Integer num = this.f1601c;
        return i + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Bitrate(min=");
        sbM833U.append(this.f1599a);
        sbM833U.append(", max=");
        sbM833U.append(this.f1600b);
        sbM833U.append(", target=");
        return outline.m818F(sbM833U, this.f1601c, ")");
    }
}

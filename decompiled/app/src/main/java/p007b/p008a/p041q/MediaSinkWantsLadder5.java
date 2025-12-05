package p007b.p008a.p041q;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MediaSinkWantsLadder.kt */
/* renamed from: b.a.q.j0, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaSinkWantsLadder5 {

    /* renamed from: a */
    public final MediaSinkWantsLadder2 f1635a;

    /* renamed from: b */
    public final MediaSinkWantsLadder2 f1636b;

    /* renamed from: c */
    public final MediaSinkWantsLadder f1637c;

    /* renamed from: d */
    public final int f1638d;

    /* renamed from: e */
    public final MediaSinkWantsLadder f1639e;

    public MediaSinkWantsLadder5(MediaSinkWantsLadder2 mediaSinkWantsLadder2, MediaSinkWantsLadder2 mediaSinkWantsLadder22, MediaSinkWantsLadder mediaSinkWantsLadder, int i, MediaSinkWantsLadder mediaSinkWantsLadder3) {
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder2, "videoBudget");
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder22, "videoCapture");
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder, "videoBitrate");
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder3, "desktopBitrate");
        this.f1635a = mediaSinkWantsLadder2;
        this.f1636b = mediaSinkWantsLadder22;
        this.f1637c = mediaSinkWantsLadder;
        this.f1638d = i;
        this.f1639e = mediaSinkWantsLadder3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSinkWantsLadder5)) {
            return false;
        }
        MediaSinkWantsLadder5 mediaSinkWantsLadder5 = (MediaSinkWantsLadder5) obj;
        return Intrinsics3.areEqual(this.f1635a, mediaSinkWantsLadder5.f1635a) && Intrinsics3.areEqual(this.f1636b, mediaSinkWantsLadder5.f1636b) && Intrinsics3.areEqual(this.f1637c, mediaSinkWantsLadder5.f1637c) && this.f1638d == mediaSinkWantsLadder5.f1638d && Intrinsics3.areEqual(this.f1639e, mediaSinkWantsLadder5.f1639e);
    }

    public int hashCode() {
        MediaSinkWantsLadder2 mediaSinkWantsLadder2 = this.f1635a;
        int iHashCode = (mediaSinkWantsLadder2 != null ? mediaSinkWantsLadder2.hashCode() : 0) * 31;
        MediaSinkWantsLadder2 mediaSinkWantsLadder22 = this.f1636b;
        int iHashCode2 = (iHashCode + (mediaSinkWantsLadder22 != null ? mediaSinkWantsLadder22.hashCode() : 0)) * 31;
        MediaSinkWantsLadder mediaSinkWantsLadder = this.f1637c;
        int iHashCode3 = (((iHashCode2 + (mediaSinkWantsLadder != null ? mediaSinkWantsLadder.hashCode() : 0)) * 31) + this.f1638d) * 31;
        MediaSinkWantsLadder mediaSinkWantsLadder3 = this.f1639e;
        return iHashCode3 + (mediaSinkWantsLadder3 != null ? mediaSinkWantsLadder3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("VideoQualityManagerOptions(videoBudget=");
        sbM833U.append(this.f1635a);
        sbM833U.append(", videoCapture=");
        sbM833U.append(this.f1636b);
        sbM833U.append(", videoBitrate=");
        sbM833U.append(this.f1637c);
        sbM833U.append(", videoBitrateFloor=");
        sbM833U.append(this.f1638d);
        sbM833U.append(", desktopBitrate=");
        sbM833U.append(this.f1639e);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

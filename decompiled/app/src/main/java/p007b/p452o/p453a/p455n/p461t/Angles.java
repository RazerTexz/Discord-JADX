package p007b.p452o.p453a.p455n.p461t;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import p007b.p100d.p104b.p105a.outline;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p454m.Facing;

/* compiled from: Angles.java */
/* renamed from: b.o.a.n.t.a, reason: use source file name */
/* loaded from: classes3.dex */
public class Angles {

    /* renamed from: a */
    public static final CameraLogger f13995a = new CameraLogger(Angles.class.getSimpleName());

    /* renamed from: b */
    public Facing f13996b;

    /* renamed from: c */
    @VisibleForTesting
    public int f13997c = 0;

    /* renamed from: d */
    @VisibleForTesting
    public int f13998d = 0;

    /* renamed from: e */
    @VisibleForTesting
    public int f13999e = 0;

    /* renamed from: a */
    public final int m7356a(@NonNull Reference2 reference2, @NonNull Reference2 reference22) {
        if (reference2 == reference22) {
            return 0;
        }
        Reference2 reference23 = Reference2.BASE;
        if (reference22 == reference23) {
            return ((360 - m7356a(reference22, reference2)) + 360) % 360;
        }
        if (reference2 != reference23) {
            return ((m7356a(reference23, reference22) - m7356a(reference23, reference2)) + 360) % 360;
        }
        int iOrdinal = reference22.ordinal();
        if (iOrdinal == 1) {
            return ((360 - this.f13997c) + 360) % 360;
        }
        if (iOrdinal == 2) {
            return ((360 - this.f13998d) + 360) % 360;
        }
        if (iOrdinal == 3) {
            return (this.f13999e + 360) % 360;
        }
        throw new RuntimeException("Unknown reference: " + reference22);
    }

    /* renamed from: b */
    public boolean m7357b(@NonNull Reference2 reference2, @NonNull Reference2 reference22) {
        return m7358c(reference2, reference22, 1) % 180 != 0;
    }

    /* renamed from: c */
    public int m7358c(@NonNull Reference2 reference2, @NonNull Reference2 reference22, @NonNull int i) {
        int iM7356a = m7356a(reference2, reference22);
        return (i == 2 && this.f13996b == Facing.FRONT) ? ((360 - iM7356a) + 360) % 360 : iM7356a;
    }

    /* renamed from: d */
    public final void m7359d() {
        f13995a.m7159a(1, "Angles changed:", "sensorOffset:", Integer.valueOf(this.f13997c), "displayOffset:", Integer.valueOf(this.f13998d), "deviceOrientation:", Integer.valueOf(this.f13999e));
    }

    /* renamed from: e */
    public final void m7360e(int i) {
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            throw new IllegalStateException(outline.m871q("This value is not sanitized: ", i));
        }
    }

    /* renamed from: f */
    public void m7361f(@NonNull Facing facing, int i) {
        m7360e(i);
        this.f13996b = facing;
        this.f13997c = i;
        if (facing == Facing.FRONT) {
            this.f13997c = ((360 - i) + 360) % 360;
        }
        m7359d();
    }
}

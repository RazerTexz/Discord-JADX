package p007b.p452o.p453a.p454m;

import androidx.annotation.Nullable;

/* compiled from: Facing.java */
/* renamed from: b.o.a.m.e, reason: use source file name */
/* loaded from: classes3.dex */
public enum Facing implements Control {
    BACK(0),
    FRONT(1);

    private int value;

    Facing(int i) {
        this.value = i;
    }

    @Nullable
    /* renamed from: f */
    public static Facing m7172f(int i) {
        Facing[] facingArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            Facing facing = facingArrValues[i2];
            if (facing.value == i) {
                return facing;
            }
        }
        return null;
    }

    /* renamed from: g */
    public int m7173g() {
        return this.value;
    }
}

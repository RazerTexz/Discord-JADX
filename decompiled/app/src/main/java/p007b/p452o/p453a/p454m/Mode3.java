package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* compiled from: Mode.java */
/* renamed from: b.o.a.m.i, reason: use source file name */
/* loaded from: classes3.dex */
public enum Mode3 implements Control {
    PICTURE(0),
    VIDEO(1);

    private int value;

    Mode3(int i) {
        this.value = i;
    }

    @NonNull
    /* renamed from: f */
    public static Mode3 m7180f(int i) {
        Mode3[] mode3ArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            Mode3 mode3 = mode3ArrValues[i2];
            if (mode3.value == i) {
                return mode3;
            }
        }
        return PICTURE;
    }

    /* renamed from: g */
    public int m7181g() {
        return this.value;
    }
}

package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* compiled from: Engine.java */
/* renamed from: b.o.a.m.d, reason: use source file name */
/* loaded from: classes3.dex */
public enum Engine implements Control {
    CAMERA1(0),
    CAMERA2(1);

    private int value;

    Engine(int i) {
        this.value = i;
    }

    @NonNull
    /* renamed from: f */
    public static Engine m7170f(int i) {
        Engine[] engineArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            Engine engine = engineArrValues[i2];
            if (engine.value == i) {
                return engine;
            }
        }
        return CAMERA1;
    }

    /* renamed from: g */
    public int m7171g() {
        return this.value;
    }
}

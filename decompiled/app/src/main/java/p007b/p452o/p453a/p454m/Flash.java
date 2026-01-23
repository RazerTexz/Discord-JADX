package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.f, reason: use source file name */
/* JADX INFO: compiled from: Flash.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Flash implements Control {
    OFF(0),
    ON(1),
    AUTO(2),
    TORCH(3);

    private int value;

    Flash(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static Flash m7174f(int i) {
        Flash[] flashArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            Flash flash = flashArrValues[i2];
            if (flash.value == i) {
                return flash;
            }
        }
        return OFF;
    }

    /* JADX INFO: renamed from: g */
    public int m7175g() {
        return this.value;
    }
}

package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.m, reason: use source file name */
/* JADX INFO: compiled from: WhiteBalance.java */
/* JADX INFO: loaded from: classes3.dex */
public enum WhiteBalance implements Control {
    AUTO(0),
    INCANDESCENT(1),
    FLUORESCENT(2),
    DAYLIGHT(3),
    CLOUDY(4);

    private int value;

    WhiteBalance(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static WhiteBalance m7188f(int i) {
        WhiteBalance[] whiteBalanceArrValues = values();
        for (int i2 = 0; i2 < 5; i2++) {
            WhiteBalance whiteBalance = whiteBalanceArrValues[i2];
            if (whiteBalance.value == i) {
                return whiteBalance;
            }
        }
        return AUTO;
    }

    /* JADX INFO: renamed from: g */
    public int m7189g() {
        return this.value;
    }
}

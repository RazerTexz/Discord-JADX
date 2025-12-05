package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* compiled from: Grid.java */
/* renamed from: b.o.a.m.g, reason: use source file name */
/* loaded from: classes3.dex */
public enum Grid implements Control {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);

    private int value;

    Grid(int i) {
        this.value = i;
    }

    @NonNull
    /* renamed from: f */
    public static Grid m7176f(int i) {
        Grid[] gridArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            Grid grid = gridArrValues[i2];
            if (grid.value == i) {
                return grid;
            }
        }
        return OFF;
    }

    /* renamed from: g */
    public int m7177g() {
        return this.value;
    }
}

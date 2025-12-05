package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* compiled from: Audio.java */
/* renamed from: b.o.a.m.a, reason: use source file name */
/* loaded from: classes3.dex */
public enum Audio implements Control {
    OFF(0),
    ON(1),
    MONO(2),
    STEREO(3);

    private int value;

    Audio(int i) {
        this.value = i;
    }

    @NonNull
    /* renamed from: f */
    public static Audio m7166f(int i) {
        Audio[] audioArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            Audio audio = audioArrValues[i2];
            if (audio.value == i) {
                return audio;
            }
        }
        return ON;
    }

    /* renamed from: g */
    public int m7167g() {
        return this.value;
    }
}

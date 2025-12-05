package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* compiled from: AudioCodec.java */
/* renamed from: b.o.a.m.b, reason: use source file name */
/* loaded from: classes3.dex */
public enum AudioCodec implements Control {
    DEVICE_DEFAULT(0),
    AAC(1),
    HE_AAC(2),
    AAC_ELD(3);

    private int value;

    AudioCodec(int i) {
        this.value = i;
    }

    @NonNull
    /* renamed from: f */
    public static AudioCodec m7168f(int i) {
        AudioCodec[] audioCodecArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            AudioCodec audioCodec = audioCodecArrValues[i2];
            if (audioCodec.value == i) {
                return audioCodec;
            }
        }
        return DEVICE_DEFAULT;
    }

    /* renamed from: g */
    public int m7169g() {
        return this.value;
    }
}

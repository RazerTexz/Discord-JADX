package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.l, reason: use source file name */
/* JADX INFO: compiled from: VideoCodec.java */
/* JADX INFO: loaded from: classes3.dex */
public enum VideoCodec implements Control {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);

    private int value;

    VideoCodec(int i) {
        this.value = i;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static VideoCodec m7186f(int i) {
        VideoCodec[] videoCodecArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            VideoCodec videoCodec = videoCodecArrValues[i2];
            if (videoCodec.value == i) {
                return videoCodec;
            }
        }
        return DEVICE_DEFAULT;
    }

    /* JADX INFO: renamed from: g */
    public int m7187g() {
        return this.value;
    }
}

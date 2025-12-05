package p007b.p452o.p453a.p454m;

import androidx.annotation.NonNull;

/* compiled from: PictureFormat.java */
/* renamed from: b.o.a.m.j, reason: use source file name */
/* loaded from: classes3.dex */
public enum PictureFormat implements Control {
    JPEG(0),
    DNG(1);

    private int value;

    PictureFormat(int i) {
        this.value = i;
    }

    @NonNull
    /* renamed from: f */
    public static PictureFormat m7182f(int i) {
        PictureFormat[] pictureFormatArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            PictureFormat pictureFormat = pictureFormatArrValues[i2];
            if (pictureFormat.value == i) {
                return pictureFormat;
            }
        }
        return JPEG;
    }

    /* renamed from: g */
    public int m7183g() {
        return this.value;
    }
}

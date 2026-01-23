package p007b.p109f.p186k;

import android.graphics.ColorSpace;
import android.util.Pair;

/* JADX INFO: renamed from: b.f.k.b, reason: use source file name */
/* JADX INFO: compiled from: ImageMetaData.java */
/* JADX INFO: loaded from: classes3.dex */
public class ImageMetaData {

    /* JADX INFO: renamed from: a */
    public final Pair<Integer, Integer> f4277a;

    /* JADX INFO: renamed from: b */
    public final ColorSpace f4278b;

    public ImageMetaData(int i, int i2, ColorSpace colorSpace) {
        this.f4277a = (i == -1 || i2 == -1) ? null : new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        this.f4278b = colorSpace;
    }
}

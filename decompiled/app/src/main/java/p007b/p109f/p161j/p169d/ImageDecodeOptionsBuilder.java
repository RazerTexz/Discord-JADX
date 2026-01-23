package p007b.p109f.p161j.p169d;

import android.graphics.Bitmap;
import p007b.p109f.p161j.p169d.ImageDecodeOptionsBuilder;

/* JADX INFO: renamed from: b.f.j.d.c, reason: use source file name */
/* JADX INFO: compiled from: ImageDecodeOptionsBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageDecodeOptionsBuilder<T extends ImageDecodeOptionsBuilder> {

    /* JADX INFO: renamed from: a */
    public Bitmap.Config f3711a;

    /* JADX INFO: renamed from: b */
    public Bitmap.Config f3712b;

    public ImageDecodeOptionsBuilder() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        this.f3711a = config;
        this.f3712b = config;
    }
}

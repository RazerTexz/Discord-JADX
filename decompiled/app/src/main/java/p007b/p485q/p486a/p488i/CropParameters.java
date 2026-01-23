package p007b.p485q.p486a.p488i;

import android.graphics.Bitmap;

/* JADX INFO: renamed from: b.q.a.i.a, reason: use source file name */
/* JADX INFO: compiled from: CropParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public class CropParameters {

    /* JADX INFO: renamed from: a */
    public int f14395a;

    /* JADX INFO: renamed from: b */
    public int f14396b;

    /* JADX INFO: renamed from: c */
    public Bitmap.CompressFormat f14397c;

    /* JADX INFO: renamed from: d */
    public int f14398d;

    /* JADX INFO: renamed from: e */
    public String f14399e;

    /* JADX INFO: renamed from: f */
    public String f14400f;

    /* JADX INFO: renamed from: g */
    public ExifInfo f14401g;

    public CropParameters(int i, int i2, Bitmap.CompressFormat compressFormat, int i3, String str, String str2, ExifInfo exifInfo) {
        this.f14395a = i;
        this.f14396b = i2;
        this.f14397c = compressFormat;
        this.f14398d = i3;
        this.f14399e = str;
        this.f14400f = str2;
        this.f14401g = exifInfo;
    }
}

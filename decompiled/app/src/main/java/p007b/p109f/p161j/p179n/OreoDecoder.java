package p007b.p109f.p161j.p179n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;
import p007b.p109f.p161j.p177l.BitmapPool;
import p007b.p109f.p186k.BitmapUtil;

/* JADX INFO: renamed from: b.f.j.n.c, reason: use source file name */
/* JADX INFO: compiled from: OreoDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(26)
public class OreoDecoder extends DefaultDecoder {
    public OreoDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        super(bitmapPool, i, synchronizedPool);
    }

    @Override // p007b.p109f.p161j.p179n.DefaultDecoder
    /* JADX INFO: renamed from: d */
    public int mo1412d(int i, int i2, BitmapFactory.Options options) {
        ColorSpace colorSpace = options.outColorSpace;
        if ((colorSpace == null || !colorSpace.isWideGamut() || options.inPreferredConfig == Bitmap.Config.RGBA_F16) ? false : true) {
            return i * i2 * 8;
        }
        Bitmap.Config config = options.inPreferredConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return BitmapUtil.m1540c(i, i2, config);
    }
}

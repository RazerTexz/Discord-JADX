package p007b.p109f.p161j.p179n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import androidx.core.util.Preconditions;
import p007b.p109f.p161j.p177l.BitmapPool;
import p007b.p109f.p186k.BitmapUtil;

/* JADX INFO: renamed from: b.f.j.n.a, reason: use source file name */
/* JADX INFO: compiled from: ArtDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class ArtDecoder extends DefaultDecoder {
    public ArtDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        super(bitmapPool, i, synchronizedPool);
    }

    @Override // p007b.p109f.p161j.p179n.DefaultDecoder
    /* JADX INFO: renamed from: d */
    public int mo1412d(int i, int i2, BitmapFactory.Options options) {
        return BitmapUtil.m1540c(i, i2, (Bitmap.Config) Preconditions.checkNotNull(options.inPreferredConfig));
    }
}

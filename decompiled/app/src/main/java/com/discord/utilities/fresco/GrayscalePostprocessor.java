package com.discord.utilities.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.facebook.cache.common.CacheKey;
import p007b.p109f.p111b.p112a.SimpleCacheKey;
import p007b.p109f.p161j.p182q.BasePostprocessor;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GrayscalePostprocessor.kt */
/* loaded from: classes2.dex */
public final class GrayscalePostprocessor extends BasePostprocessor {
    @Override // p007b.p109f.p161j.p182q.BasePostprocessor, p007b.p109f.p161j.p182q.Postprocessor
    public String getName() {
        String simpleName = GrayscalePostprocessor.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // p007b.p109f.p161j.p182q.BasePostprocessor, p007b.p109f.p161j.p182q.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey(getName());
    }

    @Override // p007b.p109f.p161j.p182q.BasePostprocessor
    public void process(Bitmap destBitmap, Bitmap sourceBitmap) throws IllegalArgumentException {
        super.process(destBitmap, sourceBitmap);
        if (destBitmap == null || sourceBitmap == null) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        new Canvas(destBitmap).drawBitmap(sourceBitmap, 0.0f, 0.0f, paint);
    }
}

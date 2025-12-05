package com.discord.utilities.view.extensions;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ImageViewExtensions.kt */
/* renamed from: com.discord.utilities.view.extensions.ImageViewExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ImageViewExtensions {
    public static final void setGrayscale(ImageView imageView, boolean z2) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$setGrayscale");
        setSaturation(imageView, z2 ? 0.0f : 1.0f);
    }

    public static final void setSaturation(ImageView imageView, @FloatRange(from = 0.0d, m75to = 3.4028234663852886E38d) float f) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$setSaturation");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }
}

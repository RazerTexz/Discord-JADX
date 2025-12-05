package com.discord.utilities.images;

import android.graphics.Bitmap;
import p007b.p109f.p161j.p180o.RoundAsCirclePostprocessor2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RoundAsCirclePostProcessor.kt */
/* renamed from: com.discord.utilities.images.RoundAsCirclePostprocessor, reason: use source file name */
/* loaded from: classes2.dex */
public final class RoundAsCirclePostProcessor2 extends RoundAsCirclePostprocessor2 {
    private final String imageUri;

    public RoundAsCirclePostProcessor2(String str) {
        Intrinsics3.checkNotNullParameter(str, "imageUri");
        this.imageUri = str;
    }

    @Override // p007b.p109f.p161j.p180o.RoundAsCirclePostprocessor2, p007b.p109f.p161j.p182q.BasePostprocessor
    public void process(Bitmap bitmap) {
        int width = bitmap != null ? bitmap.getWidth() : 0;
        int height = bitmap != null ? bitmap.getHeight() : 0;
        if (width < 2 || height < 2) {
            return;
        }
        super.process(bitmap);
    }
}

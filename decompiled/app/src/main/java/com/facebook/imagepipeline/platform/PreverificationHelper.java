package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import p007b.p109f.p190m.DoNotOptimize;

/* JADX INFO: loaded from: classes3.dex */
@DoNotOptimize
public class PreverificationHelper {
    @DoNotOptimize
    @TargetApi(26)
    public boolean shouldUseHardwareBitmapConfig(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}

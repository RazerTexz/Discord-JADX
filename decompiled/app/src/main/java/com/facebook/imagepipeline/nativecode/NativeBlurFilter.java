package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p190m.p191n.NativeLoader;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeBlurFilter {
    static {
        NativeLoader.m1589c("native-filters");
    }

    @DoNotStrip
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);
}

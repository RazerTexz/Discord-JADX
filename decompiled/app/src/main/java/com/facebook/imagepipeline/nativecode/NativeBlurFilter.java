package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import b.f.d.d.c;
import b.f.m.n.a;

@c
/* loaded from: classes3.dex */
public class NativeBlurFilter {
    static {
        a.c("native-filters");
    }

    @c
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);
}

package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p161j.p178m.ImagePipelineNativeLoader;
import p007b.p109f.p190m.p191n.NativeLoader;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class Bitmaps {
    static {
        List<String> list = ImagePipelineNativeLoader.f3980a;
        NativeLoader.m1589c("imagepipeline");
    }

    @DoNotStrip
    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        AnimatableValueParser.m527i(Boolean.valueOf(bitmap2.getConfig() == bitmap.getConfig()));
        AnimatableValueParser.m527i(Boolean.valueOf(bitmap.isMutable()));
        AnimatableValueParser.m527i(Boolean.valueOf(bitmap.getWidth() == bitmap2.getWidth()));
        AnimatableValueParser.m527i(Boolean.valueOf(bitmap.getHeight() == bitmap2.getHeight()));
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @DoNotStrip
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);
}

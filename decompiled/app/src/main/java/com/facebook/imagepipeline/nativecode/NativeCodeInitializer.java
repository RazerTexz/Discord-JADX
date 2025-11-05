package com.facebook.imagepipeline.nativecode;

import android.content.Context;
import b.f.d.d.c;
import com.facebook.soloader.SoLoader;
import java.io.IOException;

@c
/* loaded from: classes3.dex */
public class NativeCodeInitializer {
    @c
    public static void init(Context context) throws IOException {
        SoLoader.init(context, 0);
    }
}

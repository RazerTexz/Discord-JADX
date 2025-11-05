package com.facebook.imagepipeline.nativecode;

import b.f.d.d.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@c
/* loaded from: classes3.dex */
public class WebpTranscoderImpl {
    @c
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    @c
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;
}

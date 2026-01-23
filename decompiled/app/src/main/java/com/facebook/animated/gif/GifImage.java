package com.facebook.animated.gif;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableFrameInfo;
import p007b.p109f.p161j.p162a.p163a.AnimatedImage;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame;
import p007b.p109f.p161j.p162a.p164b.AnimatedImageDecoder;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p190m.p191n.NativeLoader;

/* JADX INFO: loaded from: classes.dex */
@DoNotStrip
public class GifImage implements AnimatedImage, AnimatedImageDecoder {

    /* JADX INFO: renamed from: a */
    public static volatile boolean f19418a;

    /* JADX INFO: renamed from: b */
    public Bitmap.Config f19419b = null;

    @DoNotStrip
    private long mNativeContext;

    @DoNotStrip
    public GifImage() {
    }

    /* JADX INFO: renamed from: k */
    public static synchronized void m8629k() {
        if (!f19418a) {
            f19418a = true;
            NativeLoader.m1589c("gifimage");
        }
    }

    @DoNotStrip
    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i, boolean z2);

    @DoNotStrip
    private static native GifImage nativeCreateFromFileDescriptor(int i, int i2, boolean z2);

    @DoNotStrip
    private static native GifImage nativeCreateFromNativeMemory(long j, int i, int i2, boolean z2);

    @DoNotStrip
    private native void nativeDispose();

    @DoNotStrip
    private native void nativeFinalize();

    @DoNotStrip
    private native int nativeGetDuration();

    @DoNotStrip
    private native GifFrame nativeGetFrame(int i);

    @DoNotStrip
    private native int nativeGetFrameCount();

    @DoNotStrip
    private native int[] nativeGetFrameDurations();

    @DoNotStrip
    private native int nativeGetHeight();

    @DoNotStrip
    private native int nativeGetLoopCount();

    @DoNotStrip
    private native int nativeGetSizeInBytes();

    @DoNotStrip
    private native int nativeGetWidth();

    @DoNotStrip
    private native boolean nativeIsAnimated();

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: a */
    public int mo1177a() {
        return nativeGetFrameCount();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: b */
    public int mo1178b() {
        int iNativeGetLoopCount = nativeGetLoopCount();
        if (iNativeGetLoopCount == -1) {
            return 1;
        }
        if (iNativeGetLoopCount != 0) {
            return iNativeGetLoopCount + 1;
        }
        return 0;
    }

    @Override // p007b.p109f.p161j.p162a.p164b.AnimatedImageDecoder
    /* JADX INFO: renamed from: c */
    public AnimatedImage mo1192c(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        m8629k();
        byteBuffer.rewind();
        GifImage gifImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer, imageDecodeOptions.f3708c, false);
        gifImageNativeCreateFromDirectByteBuffer.f19419b = imageDecodeOptions.f3710e;
        return gifImageNativeCreateFromDirectByteBuffer;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: d */
    public Bitmap.Config mo1179d() {
        return this.f19419b;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: e */
    public AnimatedImageFrame mo1180e(int i) {
        return nativeGetFrame(i);
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: f */
    public boolean mo1181f() {
        return false;
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: g */
    public AnimatedDrawableFrameInfo mo1182g(int i) {
        int i2;
        GifFrame gifFrameNativeGetFrame = nativeGetFrame(i);
        try {
            int iMo1186b = gifFrameNativeGetFrame.mo1186b();
            int iMo1187c = gifFrameNativeGetFrame.mo1187c();
            int width = gifFrameNativeGetFrame.getWidth();
            int height = gifFrameNativeGetFrame.getHeight();
            int iM8628d = gifFrameNativeGetFrame.m8628d();
            if (iM8628d != 0 && iM8628d != 1) {
                i2 = 3;
                if (iM8628d == 2) {
                    i2 = 2;
                } else if (iM8628d == 3) {
                }
                return new AnimatedDrawableFrameInfo(i, iMo1186b, iMo1187c, width, height, 1, i2);
            }
            i2 = 1;
            return new AnimatedDrawableFrameInfo(i, iMo1186b, iMo1187c, width, height, 1, i2);
        } finally {
            gifFrameNativeGetFrame.dispose();
        }
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // p007b.p109f.p161j.p162a.p164b.AnimatedImageDecoder
    /* JADX INFO: renamed from: h */
    public AnimatedImage mo1193h(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        m8629k();
        AnimatableValueParser.m527i(Boolean.valueOf(j != 0));
        GifImage gifImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i, imageDecodeOptions.f3708c, false);
        gifImageNativeCreateFromNativeMemory.f19419b = imageDecodeOptions.f3710e;
        return gifImageNativeCreateFromNativeMemory;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: i */
    public int[] mo1183i() {
        return nativeGetFrameDurations();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: j */
    public int mo1184j() {
        return nativeGetSizeInBytes();
    }

    @DoNotStrip
    public GifImage(long j) {
        this.mNativeContext = j;
    }
}

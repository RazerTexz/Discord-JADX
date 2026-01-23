package com.facebook.animated.webp;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableFrameInfo;
import p007b.p109f.p161j.p162a.p163a.AnimatedImage;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame;
import p007b.p109f.p161j.p162a.p164b.AnimatedImageDecoder;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p161j.p178m.StaticWebpNativeLoader;

/* JADX INFO: loaded from: classes.dex */
@DoNotStrip
public class WebPImage implements AnimatedImage, AnimatedImageDecoder {

    /* JADX INFO: renamed from: a */
    public Bitmap.Config f19420a = null;

    @DoNotStrip
    private long mNativeContext;

    @DoNotStrip
    public WebPImage() {
    }

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native WebPImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: a */
    public int mo1177a() {
        return nativeGetFrameCount();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: b */
    public int mo1178b() {
        return nativeGetLoopCount();
    }

    @Override // p007b.p109f.p161j.p162a.p164b.AnimatedImageDecoder
    /* JADX INFO: renamed from: c */
    public AnimatedImage mo1192c(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        StaticWebpNativeLoader.m1411a();
        byteBuffer.rewind();
        WebPImage webPImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer);
        if (imageDecodeOptions != null) {
            webPImageNativeCreateFromDirectByteBuffer.f19420a = imageDecodeOptions.f3710e;
        }
        return webPImageNativeCreateFromDirectByteBuffer;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: d */
    public Bitmap.Config mo1179d() {
        return this.f19420a;
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: e */
    public AnimatedImageFrame mo1180e(int i) {
        return nativeGetFrame(i);
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: f */
    public boolean mo1181f() {
        return true;
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImage
    /* JADX INFO: renamed from: g */
    public AnimatedDrawableFrameInfo mo1182g(int i) {
        WebPFrame webPFrameNativeGetFrame = nativeGetFrame(i);
        try {
            return new AnimatedDrawableFrameInfo(i, webPFrameNativeGetFrame.mo1186b(), webPFrameNativeGetFrame.mo1187c(), webPFrameNativeGetFrame.getWidth(), webPFrameNativeGetFrame.getHeight(), webPFrameNativeGetFrame.m8630d() ? 1 : 2, webPFrameNativeGetFrame.m8631e() ? 2 : 1);
        } finally {
            webPFrameNativeGetFrame.dispose();
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
        StaticWebpNativeLoader.m1411a();
        AnimatableValueParser.m527i(Boolean.valueOf(j != 0));
        WebPImage webPImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i);
        if (imageDecodeOptions != null) {
            webPImageNativeCreateFromNativeMemory.f19420a = imageDecodeOptions.f3710e;
        }
        return webPImageNativeCreateFromNativeMemory;
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
    public WebPImage(long j) {
        this.mNativeContext = j;
    }
}

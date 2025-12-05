package com.facebook.animated.gif;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame;

/* loaded from: classes.dex */
public class GifFrame implements AnimatedImageFrame {

    @DoNotStrip
    private long mNativeContext;

    @DoNotStrip
    public GifFrame(long j) {
        this.mNativeContext = j;
    }

    @DoNotStrip
    private native void nativeDispose();

    @DoNotStrip
    private native void nativeFinalize();

    @DoNotStrip
    private native int nativeGetDisposalMode();

    @DoNotStrip
    private native int nativeGetDurationMs();

    @DoNotStrip
    private native int nativeGetHeight();

    @DoNotStrip
    private native int nativeGetTransparentPixelColor();

    @DoNotStrip
    private native int nativeGetWidth();

    @DoNotStrip
    private native int nativeGetXOffset();

    @DoNotStrip
    private native int nativeGetYOffset();

    @DoNotStrip
    private native boolean nativeHasTransparency();

    @DoNotStrip
    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    /* renamed from: a */
    public void mo1185a(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    /* renamed from: b */
    public int mo1186b() {
        return nativeGetXOffset();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    /* renamed from: c */
    public int mo1187c() {
        return nativeGetYOffset();
    }

    /* renamed from: d */
    public int m8628d() {
        return nativeGetDisposalMode();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    public void dispose() {
        nativeDispose();
    }

    public void finalize() {
        nativeFinalize();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    public int getWidth() {
        return nativeGetWidth();
    }
}

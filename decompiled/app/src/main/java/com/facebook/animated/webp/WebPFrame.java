package com.facebook.animated.webp;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame;

/* JADX INFO: loaded from: classes.dex */
public class WebPFrame implements AnimatedImageFrame {

    @DoNotStrip
    private long mNativeContext;

    @DoNotStrip
    public WebPFrame(long j) {
        this.mNativeContext = j;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeIsBlendWithPreviousFrame();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    private native boolean nativeShouldDisposeToBackgroundColor();

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    /* JADX INFO: renamed from: a */
    public void mo1185a(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    /* JADX INFO: renamed from: b */
    public int mo1186b() {
        return nativeGetXOffset();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    /* JADX INFO: renamed from: c */
    public int mo1187c() {
        return nativeGetYOffset();
    }

    /* JADX INFO: renamed from: d */
    public boolean m8630d() {
        return nativeIsBlendWithPreviousFrame();
    }

    @Override // p007b.p109f.p161j.p162a.p163a.AnimatedImageFrame
    public void dispose() {
        nativeDispose();
    }

    /* JADX INFO: renamed from: e */
    public boolean m8631e() {
        return nativeShouldDisposeToBackgroundColor();
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

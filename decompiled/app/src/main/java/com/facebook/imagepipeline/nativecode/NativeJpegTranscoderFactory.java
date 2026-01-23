package com.facebook.imagepipeline.nativecode;

import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p184s.ImageTranscoder;
import p007b.p109f.p161j.p184s.ImageTranscoderFactory;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeJpegTranscoderFactory implements ImageTranscoderFactory {

    /* JADX INFO: renamed from: a */
    public final int f19571a;

    /* JADX INFO: renamed from: b */
    public final boolean f19572b;

    /* JADX INFO: renamed from: c */
    public final boolean f19573c;

    @DoNotStrip
    public NativeJpegTranscoderFactory(int i, boolean z2, boolean z3) {
        this.f19571a = i;
        this.f19572b = z2;
        this.f19573c = z3;
    }

    @Override // p007b.p109f.p161j.p184s.ImageTranscoderFactory
    @DoNotStrip
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z2) {
        if (imageFormat != DefaultImageFormats.f3585a) {
            return null;
        }
        return new NativeJpegTranscoder(z2, this.f19571a, this.f19572b, this.f19573c);
    }
}

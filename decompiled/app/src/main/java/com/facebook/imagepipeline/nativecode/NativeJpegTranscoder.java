package com.facebook.imagepipeline.nativecode;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Closeables;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p115d.p119d.ImmutableList;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p184s.ImageTranscodeResult;
import p007b.p109f.p161j.p184s.ImageTranscoder;
import p007b.p109f.p161j.p184s.JpegTranscoderUtils;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeJpegTranscoder implements ImageTranscoder {

    /* JADX INFO: renamed from: a */
    public boolean f19568a;

    /* JADX INFO: renamed from: b */
    public int f19569b;

    /* JADX INFO: renamed from: c */
    public boolean f19570c;

    public NativeJpegTranscoder(boolean z2, int i, boolean z3, boolean z4) {
        this.f19568a = z2;
        this.f19569b = i;
        this.f19570c = z3;
        if (z4) {
            AnimatableValueParser.m512e0();
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: e */
    public static void m8713e(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        AnimatableValueParser.m512e0();
        AnimatableValueParser.m527i(Boolean.valueOf(i2 >= 1));
        AnimatableValueParser.m527i(Boolean.valueOf(i2 <= 16));
        AnimatableValueParser.m527i(Boolean.valueOf(i3 >= 0));
        AnimatableValueParser.m527i(Boolean.valueOf(i3 <= 100));
        ImmutableList<Integer> immutableList = JpegTranscoderUtils.f4268a;
        AnimatableValueParser.m527i(Boolean.valueOf(i >= 0 && i <= 270 && i % 90 == 0));
        AnimatableValueParser.m535k((i2 == 8 && i == 0) ? false : true, "no transformation requested");
        Objects.requireNonNull(outputStream);
        nativeTranscodeJpeg(inputStream, outputStream, i, i2, i3);
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: f */
    public static void m8714f(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z2;
        AnimatableValueParser.m512e0();
        AnimatableValueParser.m527i(Boolean.valueOf(i2 >= 1));
        AnimatableValueParser.m527i(Boolean.valueOf(i2 <= 16));
        AnimatableValueParser.m527i(Boolean.valueOf(i3 >= 0));
        AnimatableValueParser.m527i(Boolean.valueOf(i3 <= 100));
        ImmutableList<Integer> immutableList = JpegTranscoderUtils.f4268a;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z2 = true;
                break;
            default:
                z2 = false;
                break;
        }
        AnimatableValueParser.m527i(Boolean.valueOf(z2));
        AnimatableValueParser.m535k((i2 == 8 && i == 1) ? false : true, "no transformation requested");
        Objects.requireNonNull(outputStream);
        nativeTranscodeJpegWithExifOrientation(inputStream, outputStream, i, i2, i3);
    }

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @DoNotStrip
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @Override // p007b.p109f.p161j.p184s.ImageTranscoder
    /* JADX INFO: renamed from: a */
    public String mo1528a() {
        return "NativeJpegTranscoder";
    }

    @Override // p007b.p109f.p161j.p184s.ImageTranscoder
    /* JADX INFO: renamed from: b */
    public boolean mo1529b(EncodedImage2 encodedImage2, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.f3721a;
        }
        return JpegTranscoderUtils.m1534c(rotationOptions, resizeOptions, encodedImage2, this.f19568a) < 8;
    }

    @Override // p007b.p109f.p161j.p184s.ImageTranscoder
    /* JADX INFO: renamed from: c */
    public ImageTranscodeResult mo1530c(EncodedImage2 encodedImage2, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.f3721a;
        }
        int iM496a0 = AnimatableValueParser.m496a0(rotationOptions, resizeOptions, encodedImage2, this.f19569b);
        try {
            int iM1534c = JpegTranscoderUtils.m1534c(rotationOptions, resizeOptions, encodedImage2, this.f19568a);
            int iMax = Math.max(1, 8 / iM496a0);
            if (this.f19570c) {
                iM1534c = iMax;
            }
            InputStream inputStreamM1342e = encodedImage2.m1342e();
            ImmutableList<Integer> immutableList = JpegTranscoderUtils.f4268a;
            encodedImage2.m1347x();
            if (immutableList.contains(Integer.valueOf(encodedImage2.f3895n))) {
                int iM1532a = JpegTranscoderUtils.m1532a(rotationOptions, encodedImage2);
                AnimatableValueParser.m591y(inputStreamM1342e, "Cannot transcode from null input stream!");
                m8714f(inputStreamM1342e, outputStream, iM1532a, iM1534c, num.intValue());
            } else {
                int iM1533b = JpegTranscoderUtils.m1533b(rotationOptions, encodedImage2);
                AnimatableValueParser.m591y(inputStreamM1342e, "Cannot transcode from null input stream!");
                m8713e(inputStreamM1342e, outputStream, iM1533b, iM1534c, num.intValue());
            }
            Closeables.m966b(inputStreamM1342e);
            return new ImageTranscodeResult(iM496a0 != 1 ? 0 : 1);
        } catch (Throwable th) {
            Closeables.m966b(null);
            throw th;
        }
    }

    @Override // p007b.p109f.p161j.p184s.ImageTranscoder
    /* JADX INFO: renamed from: d */
    public boolean mo1531d(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.f3585a;
    }
}

package p007b.p109f.p161j.p173h;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.decoder.DecodeException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p160i.ImageFormatChecker;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.CloseableStaticBitmap;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p175j.ImmutableQualityInfo;
import p007b.p109f.p161j.p175j.QualityInfo;
import p007b.p109f.p161j.p179n.PlatformDecoder;

/* compiled from: DefaultImageDecoder.java */
/* renamed from: b.f.j.h.a, reason: use source file name */
/* loaded from: classes.dex */
public class DefaultImageDecoder implements ImageDecoder2 {

    /* renamed from: a */
    public final ImageDecoder2 f3868a;

    /* renamed from: b */
    public final ImageDecoder2 f3869b;

    /* renamed from: c */
    public final PlatformDecoder f3870c;

    /* renamed from: d */
    public final ImageDecoder2 f3871d = new a();

    /* compiled from: DefaultImageDecoder.java */
    /* renamed from: b.f.j.h.a$a */
    public class a implements ImageDecoder2 {
        public a() {
        }

        @Override // p007b.p109f.p161j.p173h.ImageDecoder2
        /* renamed from: a */
        public CloseableImage mo1322a(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            encodedImage2.m1347x();
            ImageFormat imageFormat = encodedImage2.f3893l;
            if (imageFormat == DefaultImageFormats.f3585a) {
                CloseableReference<Bitmap> closeableReferenceMo1415b = DefaultImageDecoder.this.f3870c.mo1415b(encodedImage2, imageDecodeOptions.f3709d, null, i, null);
                try {
                    AnimatableValueParser.m521g1(null, closeableReferenceMo1415b);
                    encodedImage2.m1347x();
                    int i2 = encodedImage2.f3894m;
                    encodedImage2.m1347x();
                    CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(closeableReferenceMo1415b, qualityInfo, i2, encodedImage2.f3895n);
                    Boolean bool = Boolean.FALSE;
                    if (CloseableImage.f3884j.contains("is_rounded")) {
                        closeableStaticBitmap.f3885k.put("is_rounded", bool);
                    }
                    return closeableStaticBitmap;
                } finally {
                    closeableReferenceMo1415b.close();
                }
            }
            if (imageFormat != DefaultImageFormats.f3587c) {
                if (imageFormat != DefaultImageFormats.f3594j) {
                    if (imageFormat != ImageFormat.f3597a) {
                        return DefaultImageDecoder.this.m1323b(encodedImage2, imageDecodeOptions);
                    }
                    throw new DecodeException("unknown image format", encodedImage2);
                }
                ImageDecoder2 imageDecoder2 = DefaultImageDecoder.this.f3869b;
                if (imageDecoder2 != null) {
                    return imageDecoder2.mo1322a(encodedImage2, i, qualityInfo, imageDecodeOptions);
                }
                throw new DecodeException("Animated WebP support not set up!", encodedImage2);
            }
            DefaultImageDecoder defaultImageDecoder = DefaultImageDecoder.this;
            Objects.requireNonNull(defaultImageDecoder);
            encodedImage2.m1347x();
            if (encodedImage2.f3896o != -1) {
                encodedImage2.m1347x();
                if (encodedImage2.f3897p != -1) {
                    Objects.requireNonNull(imageDecodeOptions);
                    ImageDecoder2 imageDecoder22 = defaultImageDecoder.f3868a;
                    return imageDecoder22 != null ? imageDecoder22.mo1322a(encodedImage2, i, qualityInfo, imageDecodeOptions) : defaultImageDecoder.m1323b(encodedImage2, imageDecodeOptions);
                }
            }
            throw new DecodeException("image width or height is incorrect", encodedImage2);
        }
    }

    public DefaultImageDecoder(ImageDecoder2 imageDecoder2, ImageDecoder2 imageDecoder22, PlatformDecoder platformDecoder) {
        this.f3868a = imageDecoder2;
        this.f3869b = imageDecoder22;
        this.f3870c = platformDecoder;
    }

    @Override // p007b.p109f.p161j.p173h.ImageDecoder2
    /* renamed from: a */
    public CloseableImage mo1322a(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InputStream inputStreamM1342e;
        Objects.requireNonNull(imageDecodeOptions);
        encodedImage2.m1347x();
        ImageFormat imageFormat = encodedImage2.f3893l;
        if ((imageFormat == null || imageFormat == ImageFormat.f3597a) && (inputStreamM1342e = encodedImage2.m1342e()) != null) {
            encodedImage2.f3893l = ImageFormatChecker.m1174b(inputStreamM1342e);
        }
        return this.f3871d.mo1322a(encodedImage2, i, qualityInfo, imageDecodeOptions);
    }

    /* renamed from: b */
    public CloseableStaticBitmap m1323b(EncodedImage2 encodedImage2, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> closeableReferenceMo1414a = this.f3870c.mo1414a(encodedImage2, imageDecodeOptions.f3709d, null, null);
        try {
            AnimatableValueParser.m521g1(null, closeableReferenceMo1414a);
            QualityInfo qualityInfo = ImmutableQualityInfo.f3908a;
            encodedImage2.m1347x();
            int i = encodedImage2.f3894m;
            encodedImage2.m1347x();
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(closeableReferenceMo1414a, qualityInfo, i, encodedImage2.f3895n);
            Boolean bool = Boolean.FALSE;
            if (CloseableImage.f3884j.contains("is_rounded")) {
                closeableStaticBitmap.f3885k.put("is_rounded", bool);
            }
            return closeableStaticBitmap;
        } finally {
            closeableReferenceMo1414a.close();
        }
    }
}

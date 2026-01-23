package p007b.p109f.p161j.p184s;

import java.lang.reflect.InvocationTargetException;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p170e.NativeCodeSetup;

/* JADX INFO: renamed from: b.f.j.s.e, reason: use source file name */
/* JADX INFO: compiled from: MultiImageTranscoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class MultiImageTranscoderFactory implements ImageTranscoderFactory {

    /* JADX INFO: renamed from: a */
    public final int f4269a;

    /* JADX INFO: renamed from: b */
    public final ImageTranscoderFactory f4270b;

    /* JADX INFO: renamed from: c */
    public final Integer f4271c;

    /* JADX INFO: renamed from: d */
    public final boolean f4272d;

    public MultiImageTranscoderFactory(int i, boolean z2, ImageTranscoderFactory imageTranscoderFactory, Integer num, boolean z3) {
        this.f4269a = i;
        this.f4270b = imageTranscoderFactory;
        this.f4271c = num;
        this.f4272d = z3;
    }

    /* JADX INFO: renamed from: a */
    public final ImageTranscoder m1535a(ImageFormat imageFormat, boolean z2) {
        int i = this.f4269a;
        boolean z3 = this.f4272d;
        try {
            Class<?> cls = Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory");
            Class<?> cls2 = Boolean.TYPE;
            return ((ImageTranscoderFactory) cls.getConstructor(Integer.TYPE, cls2, cls2).newInstance(Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(z3))).createImageTranscoder(imageFormat, z2);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
        }
    }

    @Override // p007b.p109f.p161j.p184s.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z2) {
        ImageTranscoderFactory imageTranscoderFactory = this.f4270b;
        ImageTranscoder imageTranscoderM1535a = null;
        ImageTranscoder imageTranscoderCreateImageTranscoder = imageTranscoderFactory == null ? null : imageTranscoderFactory.createImageTranscoder(imageFormat, z2);
        if (imageTranscoderCreateImageTranscoder == null) {
            Integer num = this.f4271c;
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    imageTranscoderM1535a = m1535a(imageFormat, z2);
                } else {
                    if (iIntValue != 1) {
                        throw new IllegalArgumentException("Invalid ImageTranscoderType");
                    }
                    imageTranscoderM1535a = new SimpleImageTranscoder(z2, this.f4269a);
                }
            }
            imageTranscoderCreateImageTranscoder = imageTranscoderM1535a;
        }
        if (imageTranscoderCreateImageTranscoder == null && NativeCodeSetup.f3808a) {
            imageTranscoderCreateImageTranscoder = m1535a(imageFormat, z2);
        }
        return imageTranscoderCreateImageTranscoder == null ? new SimpleImageTranscoder(z2, this.f4269a) : imageTranscoderCreateImageTranscoder;
    }
}

package p007b.p109f.p161j.p184s;

import java.io.IOException;
import java.io.OutputStream;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.s.b, reason: use source file name */
/* JADX INFO: compiled from: ImageTranscoder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ImageTranscoder {
    /* JADX INFO: renamed from: a */
    String mo1528a();

    /* JADX INFO: renamed from: b */
    boolean mo1529b(EncodedImage2 encodedImage2, RotationOptions rotationOptions, ResizeOptions resizeOptions);

    /* JADX INFO: renamed from: c */
    ImageTranscodeResult mo1530c(EncodedImage2 encodedImage2, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) throws IOException;

    /* JADX INFO: renamed from: d */
    boolean mo1531d(ImageFormat imageFormat);
}

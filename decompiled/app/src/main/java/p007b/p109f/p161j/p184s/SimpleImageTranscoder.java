package p007b.p109f.p161j.p184s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.OutputStream;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.ImmutableList;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.s.f, reason: use source file name */
/* JADX INFO: compiled from: SimpleImageTranscoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleImageTranscoder implements ImageTranscoder {

    /* JADX INFO: renamed from: a */
    public final boolean f4273a;

    /* JADX INFO: renamed from: b */
    public final int f4274b;

    public SimpleImageTranscoder(boolean z2, int i) {
        this.f4273a = z2;
        this.f4274b = i;
    }

    /* JADX INFO: renamed from: e */
    public static Bitmap.CompressFormat m1536e(ImageFormat imageFormat) {
        return imageFormat == null ? Bitmap.CompressFormat.JPEG : imageFormat == DefaultImageFormats.f3585a ? Bitmap.CompressFormat.JPEG : imageFormat == DefaultImageFormats.f3586b ? Bitmap.CompressFormat.PNG : DefaultImageFormats.m1172a(imageFormat) ? Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG;
    }

    @Override // p007b.p109f.p161j.p184s.ImageTranscoder
    /* JADX INFO: renamed from: a */
    public String mo1528a() {
        return "SimpleImageTranscoder";
    }

    @Override // p007b.p109f.p161j.p184s.ImageTranscoder
    /* JADX INFO: renamed from: b */
    public boolean mo1529b(EncodedImage2 encodedImage2, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.f3721a;
        }
        return this.f4273a && AnimatableValueParser.m496a0(rotationOptions, resizeOptions, encodedImage2, this.f4274b) > 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    @Override // p007b.p109f.p161j.p184s.ImageTranscoder
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageTranscodeResult mo1530c(EncodedImage2 encodedImage2, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) throws Throwable {
        Matrix matrix;
        Bitmap bitmapCreateBitmap;
        Throwable th;
        OutOfMemoryError e;
        Integer num2 = num == null ? 85 : num;
        RotationOptions rotationOptions2 = rotationOptions == null ? RotationOptions.f3721a : rotationOptions;
        int iM496a0 = !this.f4273a ? 1 : AnimatableValueParser.m496a0(rotationOptions2, resizeOptions, encodedImage2, this.f4274b);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = iM496a0;
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(encodedImage2.m1342e(), null, options);
            if (bitmapDecodeStream == null) {
                FLog.m977e("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new ImageTranscodeResult(2);
            }
            ImmutableList<Integer> immutableList = JpegTranscoderUtils.f4268a;
            encodedImage2.m1347x();
            if (immutableList.contains(Integer.valueOf(encodedImage2.f3895n))) {
                int iM1532a = JpegTranscoderUtils.m1532a(rotationOptions2, encodedImage2);
                matrix = new Matrix();
                if (iM1532a == 2) {
                    matrix.setScale(-1.0f, 1.0f);
                } else if (iM1532a == 7) {
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else if (iM1532a == 4) {
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else if (iM1532a != 5) {
                    matrix = null;
                } else {
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                }
            } else {
                int iM1533b = JpegTranscoderUtils.m1533b(rotationOptions2, encodedImage2);
                if (iM1533b != 0) {
                    matrix = new Matrix();
                    matrix.setRotate(iM1533b);
                }
            }
            Matrix matrix2 = matrix;
            if (matrix2 != null) {
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix2, false);
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    bitmapCreateBitmap = bitmapDecodeStream;
                    FLog.m978f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    ImageTranscodeResult imageTranscodeResult = new ImageTranscodeResult(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult;
                } catch (Throwable th2) {
                    th = th2;
                    bitmapCreateBitmap = bitmapDecodeStream;
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    throw th;
                }
            } else {
                bitmapCreateBitmap = bitmapDecodeStream;
            }
            try {
                try {
                    bitmapCreateBitmap.compress(m1536e(null), num2.intValue(), outputStream);
                    ImageTranscodeResult imageTranscodeResult2 = new ImageTranscodeResult(iM496a0 > 1 ? 0 : 1);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult2;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    FLog.m978f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    ImageTranscodeResult imageTranscodeResult3 = new ImageTranscodeResult(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult3;
                }
            } catch (Throwable th3) {
                th = th3;
                bitmapCreateBitmap.recycle();
                bitmapDecodeStream.recycle();
                throw th;
            }
        } catch (OutOfMemoryError e4) {
            FLog.m978f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e4);
            return new ImageTranscodeResult(2);
        }
    }

    @Override // p007b.p109f.p161j.p184s.ImageTranscoder
    /* JADX INFO: renamed from: d */
    public boolean mo1531d(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.f3595k || imageFormat == DefaultImageFormats.f3585a;
    }
}

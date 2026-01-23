package p492b0.p493a.p494a.p495e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Tuples2;
import kotlin.TypeCastException;
import p492b0.p493a.p494a.C5312c;
import p492b0.p493a.p494a.Util3;
import p507d0.Tuples;
import p507d0.p579g0.Strings4;
import p507d0.p591y.Utils7;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b0.a.a.e.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultConstraint.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultConstraint implements Constraint2 {

    /* JADX INFO: renamed from: a */
    public boolean f14506a;

    /* JADX INFO: renamed from: b */
    public final int f14507b;

    /* JADX INFO: renamed from: c */
    public final int f14508c;

    /* JADX INFO: renamed from: d */
    public final Bitmap.CompressFormat f14509d;

    /* JADX INFO: renamed from: e */
    public final int f14510e;

    public DefaultConstraint(int i, int i2, Bitmap.CompressFormat compressFormat, int i3) {
        Intrinsics3.checkParameterIsNotNull(compressFormat, "format");
        this.f14507b = i;
        this.f14508c = i2;
        this.f14509d = compressFormat;
        this.f14510e = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x010c  */
    @Override // p492b0.p493a.p494a.p495e.Constraint2
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File mo7489a(File file) throws Throwable {
        int i;
        Bitmap.CompressFormat compressFormat;
        File file2;
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        int i2 = this.f14507b;
        int i3 = this.f14508c;
        String str = Util3.f14504a;
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        Intrinsics3.checkParameterIsNotNull(options, "options");
        Tuples2 tuples2M10073to = Tuples.m10073to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int iIntValue = ((Number) tuples2M10073to.component1()).intValue();
        int iIntValue2 = ((Number) tuples2M10073to.component2()).intValue();
        if (iIntValue > i3 || iIntValue2 > i2) {
            int i4 = iIntValue / 2;
            int i5 = iIntValue2 / 2;
            i = 1;
            while (i4 / i >= i3 && i5 / i >= i2) {
                i *= 2;
            }
        } else {
            i = 1;
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        Intrinsics3.checkExpressionValueIsNotNull(bitmapDecodeFile, "BitmapFactory.decodeFile…eFile.absolutePath, this)");
        Intrinsics3.checkExpressionValueIsNotNull(bitmapDecodeFile, "BitmapFactory.Options().…absolutePath, this)\n    }");
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        Intrinsics3.checkParameterIsNotNull(bitmapDecodeFile, "bitmap");
        int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        Matrix matrix = new Matrix();
        if (attributeInt == 3) {
            matrix.postRotate(180.0f);
        } else if (attributeInt == 6) {
            matrix.postRotate(90.0f);
        } else if (attributeInt == 8) {
            matrix.postRotate(270.0f);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
        Intrinsics3.checkExpressionValueIsNotNull(bitmapCreateBitmap, "Bitmap.createBitmap(bitm…map.height, matrix, true)");
        Bitmap.CompressFormat compressFormat2 = this.f14509d;
        int i6 = this.f14510e;
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        Intrinsics3.checkParameterIsNotNull(bitmapCreateBitmap, "bitmap");
        Intrinsics3.checkParameterIsNotNull(compressFormat2, "format");
        Intrinsics3.checkParameterIsNotNull(file, "$this$compressFormat");
        String extension = Utils7.getExtension(file);
        if (extension == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = extension.toLowerCase();
        Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
        int iHashCode = lowerCase.hashCode();
        String str2 = "webp";
        if (iHashCode != 111145) {
            compressFormat = (iHashCode == 3645340 && lowerCase.equals("webp")) ? Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG;
        } else if (lowerCase.equals("png")) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        FileOutputStream fileOutputStream = null;
        if (compressFormat2 == compressFormat) {
            file2 = file;
        } else {
            StringBuilder sb = new StringBuilder();
            String absolutePath = file.getAbsolutePath();
            Intrinsics3.checkExpressionValueIsNotNull(absolutePath, "imageFile.absolutePath");
            sb.append(Strings4.substringBeforeLast$default(absolutePath, ".", (String) null, 2, (Object) null));
            sb.append('.');
            Intrinsics3.checkParameterIsNotNull(compressFormat2, "$this$extension");
            int i7 = C5312c.f14503a[compressFormat2.ordinal()];
            if (i7 == 1) {
                str2 = "png";
            } else if (i7 != 2) {
                str2 = "jpg";
            }
            sb.append(str2);
            file2 = new File(sb.toString());
        }
        file.delete();
        Intrinsics3.checkParameterIsNotNull(bitmapCreateBitmap, "bitmap");
        Intrinsics3.checkParameterIsNotNull(file2, "destination");
        Intrinsics3.checkParameterIsNotNull(compressFormat2, "format");
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2.getAbsolutePath());
            try {
                bitmapCreateBitmap.compress(compressFormat2, i6, fileOutputStream2);
                fileOutputStream2.flush();
                fileOutputStream2.close();
                this.f14506a = true;
                return file2;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // p492b0.p493a.p494a.p495e.Constraint2
    /* JADX INFO: renamed from: b */
    public boolean mo7490b(File file) {
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        return this.f14506a;
    }
}

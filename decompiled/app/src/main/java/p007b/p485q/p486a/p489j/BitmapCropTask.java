package p007b.p485q.p486a.p489j;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.yalantis.ucrop.UCropActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import p007b.p485q.p486a.UCropActivity7;
import p007b.p485q.p486a.p487h.BitmapCropCallback;
import p007b.p485q.p486a.p488i.CropParameters;
import p007b.p485q.p486a.p488i.ImageState;
import p007b.p485q.p486a.p490k.ImageHeaderParser;

/* JADX INFO: renamed from: b.q.a.j.a, reason: use source file name */
/* JADX INFO: compiled from: BitmapCropTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {

    /* JADX INFO: renamed from: a */
    public final WeakReference<Context> f14409a;

    /* JADX INFO: renamed from: b */
    public Bitmap f14410b;

    /* JADX INFO: renamed from: c */
    public final RectF f14411c;

    /* JADX INFO: renamed from: d */
    public final RectF f14412d;

    /* JADX INFO: renamed from: e */
    public float f14413e;

    /* JADX INFO: renamed from: f */
    public float f14414f;

    /* JADX INFO: renamed from: g */
    public final int f14415g;

    /* JADX INFO: renamed from: h */
    public final int f14416h;

    /* JADX INFO: renamed from: i */
    public final Bitmap.CompressFormat f14417i;

    /* JADX INFO: renamed from: j */
    public final int f14418j;

    /* JADX INFO: renamed from: k */
    public final String f14419k;

    /* JADX INFO: renamed from: l */
    public final String f14420l;

    /* JADX INFO: renamed from: m */
    public final BitmapCropCallback f14421m;

    /* JADX INFO: renamed from: n */
    public int f14422n;

    /* JADX INFO: renamed from: o */
    public int f14423o;

    /* JADX INFO: renamed from: p */
    public int f14424p;

    /* JADX INFO: renamed from: q */
    public int f14425q;

    public BitmapCropTask(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull ImageState imageState, @NonNull CropParameters cropParameters, @Nullable BitmapCropCallback bitmapCropCallback) {
        this.f14409a = new WeakReference<>(context);
        this.f14410b = bitmap;
        this.f14411c = imageState.f14405a;
        this.f14412d = imageState.f14406b;
        this.f14413e = imageState.f14407c;
        this.f14414f = imageState.f14408d;
        this.f14415g = cropParameters.f14395a;
        this.f14416h = cropParameters.f14396b;
        this.f14417i = cropParameters.f14397c;
        this.f14418j = cropParameters.f14398d;
        this.f14419k = cropParameters.f14399e;
        this.f14420l = cropParameters.f14400f;
        this.f14421m = bitmapCropCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0261 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e3  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m7471a() throws Throwable {
        boolean z2;
        FileChannel fileChannel;
        ByteArrayOutputStream byteArrayOutputStream;
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        if (this.f14415g > 0 && this.f14416h > 0) {
            float fWidth = this.f14411c.width() / this.f14413e;
            float fHeight = this.f14411c.height() / this.f14413e;
            int i = this.f14415g;
            if (fWidth > i || fHeight > this.f14416h) {
                float fMin = Math.min(i / fWidth, this.f14416h / fHeight);
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.f14410b, Math.round(r3.getWidth() * fMin), Math.round(this.f14410b.getHeight() * fMin), false);
                Bitmap bitmap = this.f14410b;
                if (bitmap != bitmapCreateScaledBitmap) {
                    bitmap.recycle();
                }
                this.f14410b = bitmapCreateScaledBitmap;
                this.f14413e /= fMin;
            }
        }
        if (this.f14414f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f14414f, this.f14410b.getWidth() / 2, this.f14410b.getHeight() / 2);
            Bitmap bitmap2 = this.f14410b;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.f14410b.getHeight(), matrix, true);
            Bitmap bitmap3 = this.f14410b;
            if (bitmap3 != bitmapCreateBitmap) {
                bitmap3.recycle();
            }
            this.f14410b = bitmapCreateBitmap;
        }
        this.f14424p = Math.round((this.f14411c.left - this.f14412d.left) / this.f14413e);
        this.f14425q = Math.round((this.f14411c.top - this.f14412d.top) / this.f14413e);
        this.f14422n = Math.round(this.f14411c.width() / this.f14413e);
        this.f14423o = Math.round(this.f14411c.height() / this.f14413e);
        int iRound = Math.round(Math.max(this.f14422n, r0) / 1000.0f) + 1;
        if (this.f14415g <= 0 || this.f14416h <= 0) {
            float f = iRound;
            z2 = Math.abs(this.f14411c.left - this.f14412d.left) > f || Math.abs(this.f14411c.top - this.f14412d.top) > f || Math.abs(this.f14411c.bottom - this.f14412d.bottom) > f || Math.abs(this.f14411c.right - this.f14412d.right) > f || this.f14414f != 0.0f;
        }
        Log.i("BitmapCropTask", "Should crop: " + z2);
        FileChannel fileChannel2 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        ByteArrayOutputStream byteArrayOutputStream4 = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileChannel channel = null;
        if (!z2) {
            String str = this.f14419k;
            String str2 = this.f14420l;
            if (!str.equalsIgnoreCase(str2)) {
                try {
                    FileChannel channel2 = new FileInputStream(new File(str)).getChannel();
                    try {
                        channel = new FileOutputStream(new File(str2)).getChannel();
                        channel2.transferTo(0L, channel2.size(), channel);
                        channel2.close();
                        channel2.close();
                        if (channel != null) {
                            channel.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = channel;
                        fileChannel2 = channel2;
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            }
            return false;
        }
        ExifInterface exifInterface = new ExifInterface(this.f14419k);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f14410b, this.f14424p, this.f14425q, this.f14422n, this.f14423o);
        try {
            if (this.f14409a.get() != null) {
                try {
                    fileOutputStream = new FileOutputStream(new File(this.f14420l), false);
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                    } catch (IOException e) {
                        e = e;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                }
                try {
                    bitmapCreateBitmap2.compress(this.f14417i, this.f14418j, byteArrayOutputStream2);
                    fileOutputStream.write(byteArrayOutputStream2.toByteArray());
                    bitmapCreateBitmap2.recycle();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    byteArrayOutputStream = byteArrayOutputStream3;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        Log.e("BitmapCropTask", e.getLocalizedMessage());
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (this.f14417i.equals(Bitmap.CompressFormat.JPEG)) {
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            throw th;
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (IOException unused4) {
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream4 = byteArrayOutputStream2;
                    byteArrayOutputStream = byteArrayOutputStream4;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                }
            }
        } catch (IOException unused5) {
        }
        if (this.f14417i.equals(Bitmap.CompressFormat.JPEG)) {
            int i2 = this.f14422n;
            int i3 = this.f14423o;
            String str3 = this.f14420l;
            byte[] bArr = ImageHeaderParser.f14440a;
            String[] strArr = {ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
            try {
                ExifInterface exifInterface2 = new ExifInterface(str3);
                for (int i4 = 0; i4 < 22; i4++) {
                    String str4 = strArr[i4];
                    String attribute = exifInterface.getAttribute(str4);
                    if (!TextUtils.isEmpty(attribute)) {
                        exifInterface2.setAttribute(str4, attribute);
                    }
                }
                exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i2));
                exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i3));
                exifInterface2.setAttribute(ExifInterface.TAG_ORIENTATION, "0");
                exifInterface2.saveAttributes();
            } catch (IOException e4) {
                Log.d("ImageHeaderParser", e4.getMessage());
            }
        }
        return true;
    }

    @Override // android.os.AsyncTask
    @Nullable
    public Throwable doInBackground(Void[] voidArr) {
        Bitmap bitmap = this.f14410b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.f14412d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            m7471a();
            this.f14410b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@Nullable Throwable th) {
        Throwable th2 = th;
        BitmapCropCallback bitmapCropCallback = this.f14421m;
        if (bitmapCropCallback != null) {
            if (th2 != null) {
                UCropActivity7 uCropActivity7 = (UCropActivity7) bitmapCropCallback;
                uCropActivity7.f14394a.m9320b(th2);
                uCropActivity7.f14394a.finish();
                return;
            }
            Uri uriFromFile = Uri.fromFile(new File(this.f14420l));
            BitmapCropCallback bitmapCropCallback2 = this.f14421m;
            int i = this.f14424p;
            int i2 = this.f14425q;
            int i3 = this.f14422n;
            int i4 = this.f14423o;
            UCropActivity7 uCropActivity72 = (UCropActivity7) bitmapCropCallback2;
            UCropActivity uCropActivity = uCropActivity72.f14394a;
            uCropActivity.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uriFromFile).putExtra("com.yalantis.ucrop.CropAspectRatio", uCropActivity.f22194w.getTargetAspectRatio()).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
            uCropActivity72.f14394a.finish();
        }
    }
}

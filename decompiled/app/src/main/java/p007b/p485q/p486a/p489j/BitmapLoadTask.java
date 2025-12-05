package p007b.p485q.p486a.p489j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.yalantis.ucrop.UCropActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.outline;
import p007b.p485q.p486a.p487h.BitmapLoadCallback;
import p007b.p485q.p486a.p488i.ExifInfo;
import p007b.p485q.p486a.p490k.ImageHeaderParser;
import p007b.p485q.p486a.p491l.TransformImageView;
import p007b.p485q.p486a.p491l.TransformImageView2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.OkHttpClient;
import p600f0.p601e0.p605g.RealCall;
import p615g0.BufferedSource;
import p615g0.JvmOkio2;
import p615g0.Timeout2;

/* compiled from: BitmapLoadTask.java */
/* renamed from: b.q.a.j.b, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, a> {

    /* renamed from: a */
    public final Context f14426a;

    /* renamed from: b */
    public Uri f14427b;

    /* renamed from: c */
    public Uri f14428c;

    /* renamed from: d */
    public final int f14429d;

    /* renamed from: e */
    public final int f14430e;

    /* renamed from: f */
    public final BitmapLoadCallback f14431f;

    public BitmapLoadTask(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        this.f14426a = context;
        this.f14427b = uri;
        this.f14428c = uri2;
        this.f14429d = i;
        this.f14430e = i2;
        this.f14431f = bitmapLoadCallback;
    }

    /* renamed from: a */
    public final void m7472a(@NonNull Uri uri, @Nullable Uri uri2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        Log.d("BitmapWorkerTask", "copyFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot copy image");
        FileOutputStream fileOutputStream = null;
        try {
            inputStreamOpenInputStream = this.f14426a.getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                try {
                    if (inputStreamOpenInputStream == null) {
                        throw new NullPointerException("InputStream for given input Uri is null");
                    }
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamOpenInputStream.read(bArr);
                        if (i > 0) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileOutputStream2.close();
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                    this.f14427b = this.f14428c;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    this.f14427b = this.f14428c;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenInputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7473b(@NonNull Uri uri, @Nullable Uri uri2) throws Throwable {
        Response responseExecute;
        JvmOkio2 jvmOkio2;
        ResponseBody responseBody;
        Log.d("BitmapWorkerTask", "downloadFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot download image");
        OkHttpClient okHttpClient = new OkHttpClient();
        BufferedSource bufferedSource = null;
        try {
            Request.C12935a c12935a = new Request.C12935a();
            c12935a.m10983f(uri.toString());
            try {
                responseExecute = ((RealCall) okHttpClient.mo10114b(c12935a.m10978a())).execute();
                try {
                    BufferedSource bufferedSourceMo10105c = responseExecute.body.mo10105c();
                    try {
                        OutputStream outputStreamOpenOutputStream = this.f14426a.getContentResolver().openOutputStream(uri2);
                        if (outputStreamOpenOutputStream == null) {
                            throw new NullPointerException("OutputStream for given output Uri is null");
                        }
                        Intrinsics3.checkParameterIsNotNull(outputStreamOpenOutputStream, "$this$sink");
                        jvmOkio2 = new JvmOkio2(outputStreamOpenOutputStream, new Timeout2());
                        try {
                            bufferedSourceMo10105c.mo10459k0(jvmOkio2);
                            try {
                                bufferedSourceMo10105c.close();
                            } catch (IOException unused) {
                            }
                            try {
                                jvmOkio2.close();
                            } catch (IOException unused2) {
                            }
                            ResponseBody responseBody2 = responseExecute.body;
                            if (responseBody2 != null) {
                                try {
                                    responseBody2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            okHttpClient.f26012m.m10388a();
                            this.f14427b = this.f14428c;
                        } catch (Throwable th) {
                            th = th;
                            bufferedSource = bufferedSourceMo10105c;
                            if (bufferedSource != null) {
                                try {
                                    bufferedSource.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (jvmOkio2 != null) {
                                try {
                                    jvmOkio2.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (responseExecute != null && (responseBody = responseExecute.body) != null) {
                                try {
                                    responseBody.close();
                                } catch (IOException unused6) {
                                }
                            }
                            okHttpClient.f26012m.m10388a();
                            this.f14427b = this.f14428c;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        jvmOkio2 = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jvmOkio2 = null;
                }
            } catch (Throwable th4) {
                th = th4;
                responseExecute = null;
                jvmOkio2 = null;
                if (bufferedSource != null) {
                }
                if (jvmOkio2 != null) {
                }
                if (responseExecute != null) {
                    responseBody.close();
                }
                okHttpClient.f26012m.m10388a();
                this.f14427b = this.f14428c;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: c */
    public final void m7474c() throws IOException, NullPointerException {
        String scheme = this.f14427b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        if ("http".equals(scheme) || Constants.SCHEME.equals(scheme)) {
            try {
                m7473b(this.f14427b, this.f14428c);
                return;
            } catch (IOException | NullPointerException e) {
                Log.e("BitmapWorkerTask", "Downloading failed", e);
                throw e;
            }
        }
        if ("content".equals(scheme)) {
            try {
                m7472a(this.f14427b, this.f14428c);
                return;
            } catch (IOException | NullPointerException e2) {
                Log.e("BitmapWorkerTask", "Copying failed", e2);
                throw e2;
            }
        }
        if ("file".equals(scheme)) {
            return;
        }
        Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
        throw new IllegalArgumentException(outline.m883w("Invalid Uri scheme", scheme));
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0194  */
    @Override // android.os.AsyncTask
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a doInBackground(Void[] voidArr) {
        int i;
        int iM7475a;
        int i2;
        Matrix matrix;
        InputStream inputStreamOpenInputStream;
        InputStream inputStreamOpenInputStream2;
        boolean z2;
        if (this.f14427b == null) {
            return new a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            m7474c();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int i3 = this.f14429d;
            int i4 = this.f14430e;
            int i5 = options.outHeight;
            int i6 = options.outWidth;
            if (i5 > i4 || i6 > i3) {
                int i7 = 1;
                while (true) {
                    if (i5 / i7 <= i4 && i6 / i7 <= i3) {
                        break;
                    }
                    i7 *= 2;
                }
                i = i7;
            } else {
                i = 1;
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            boolean z3 = false;
            Bitmap bitmapDecodeStream = null;
            while (true) {
                int i8 = -1;
                if (!z3) {
                    try {
                        try {
                            inputStreamOpenInputStream2 = this.f14426a.getContentResolver().openInputStream(this.f14427b);
                            try {
                                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
                            } catch (Throwable th) {
                                if (inputStreamOpenInputStream2 != null) {
                                    try {
                                        inputStreamOpenInputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e) {
                            Log.e("BitmapWorkerTask", "doInBackground: ImageDecoder.createSource: ", e);
                            StringBuilder sbM833U = outline.m833U("Bitmap could not be decoded from the Uri: [");
                            sbM833U.append(this.f14427b);
                            sbM833U.append("]");
                            return new a(new IllegalArgumentException(sbM833U.toString(), e));
                        }
                    } catch (OutOfMemoryError e2) {
                        Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e2);
                        options.inSampleSize *= 2;
                    }
                    if (options.outWidth == -1 || options.outHeight == -1) {
                        break;
                    }
                    if (inputStreamOpenInputStream2 != null) {
                        try {
                            inputStreamOpenInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if ((bitmapDecodeStream != null ? bitmapDecodeStream.getByteCount() : 0) > 104857600) {
                        options.inSampleSize *= 2;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        z3 = true;
                    }
                } else {
                    if (bitmapDecodeStream == null) {
                        StringBuilder sbM833U2 = outline.m833U("Bitmap could not be decoded from the Uri: [");
                        sbM833U2.append(this.f14427b);
                        sbM833U2.append("]");
                        return new a(new IllegalArgumentException(sbM833U2.toString()));
                    }
                    Context context = this.f14426a;
                    Uri uri = this.f14427b;
                    try {
                        inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    } catch (IOException e3) {
                        StringBuilder sbM833U3 = outline.m833U("getExifOrientation: ");
                        sbM833U3.append(uri.toString());
                        Log.e("BitmapLoadUtils", sbM833U3.toString(), e3);
                    }
                    if (inputStreamOpenInputStream == null) {
                        iM7475a = 0;
                        switch (iM7475a) {
                            case 3:
                            case 4:
                                i2 = 180;
                                break;
                            case 5:
                            case 6:
                                i2 = 90;
                                break;
                            case 7:
                            case 8:
                                i2 = 270;
                                break;
                            default:
                                i2 = 0;
                                break;
                        }
                        if (iM7475a != 2 && iM7475a != 7 && iM7475a != 4 && iM7475a != 5) {
                            i8 = 1;
                        }
                        ExifInfo exifInfo = new ExifInfo(iM7475a, i2, i8);
                        matrix = new Matrix();
                        if (i2 != 0) {
                            matrix.preRotate(i2);
                        }
                        if (i8 != 1) {
                            matrix.postScale(i8, 1.0f);
                        }
                        if (!matrix.isIdentity()) {
                            return new a(bitmapDecodeStream, exifInfo);
                        }
                        try {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
                            if (!bitmapDecodeStream.sameAs(bitmapCreateBitmap)) {
                                bitmapDecodeStream = bitmapCreateBitmap;
                            }
                        } catch (OutOfMemoryError e4) {
                            Log.e("BitmapLoadUtils", "transformBitmap: ", e4);
                        }
                        return new a(bitmapDecodeStream, exifInfo);
                    }
                    iM7475a = new ImageHeaderParser(inputStreamOpenInputStream).m7475a();
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused3) {
                    }
                    switch (iM7475a) {
                    }
                    if (iM7475a != 2) {
                        i8 = 1;
                    }
                    ExifInfo exifInfo2 = new ExifInfo(iM7475a, i2, i8);
                    matrix = new Matrix();
                    if (i2 != 0) {
                    }
                    if (i8 != 1) {
                    }
                    if (!matrix.isIdentity()) {
                    }
                }
            }
            a aVar = new a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f14427b + "]"));
            if (inputStreamOpenInputStream2 != null) {
                try {
                    inputStreamOpenInputStream2.close();
                } catch (IOException unused4) {
                }
            }
            return aVar;
        } catch (IOException | NullPointerException e5) {
            return new a(e5);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@NonNull a aVar) {
        a aVar2 = aVar;
        Exception exc = aVar2.f14434c;
        if (exc != null) {
            TransformImageView transformImageView = (TransformImageView) this.f14431f;
            Objects.requireNonNull(transformImageView);
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            TransformImageView2.a aVar3 = transformImageView.f14483a.f14490p;
            if (aVar3 != null) {
                UCropActivity.C11200a c11200a = (UCropActivity.C11200a) aVar3;
                UCropActivity.this.m9320b(exc);
                UCropActivity.this.finish();
                return;
            }
            return;
        }
        BitmapLoadCallback bitmapLoadCallback = this.f14431f;
        Bitmap bitmap = aVar2.f14432a;
        ExifInfo exifInfo = aVar2.f14433b;
        String path = this.f14427b.getPath();
        Uri uri = this.f14428c;
        String path2 = uri == null ? null : uri.getPath();
        TransformImageView2 transformImageView2 = ((TransformImageView) bitmapLoadCallback).f14483a;
        transformImageView2.f14496v = path;
        transformImageView2.f14497w = path2;
        transformImageView2.f14498x = exifInfo;
        transformImageView2.f14493s = true;
        transformImageView2.setImageBitmap(bitmap);
    }

    /* compiled from: BitmapLoadTask.java */
    /* renamed from: b.q.a.j.b$a */
    public static class a {

        /* renamed from: a */
        public Bitmap f14432a;

        /* renamed from: b */
        public ExifInfo f14433b;

        /* renamed from: c */
        public Exception f14434c;

        public a(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo) {
            this.f14432a = bitmap;
            this.f14433b = exifInfo;
        }

        public a(@NonNull Exception exc) {
            this.f14434c = exc;
        }
    }
}

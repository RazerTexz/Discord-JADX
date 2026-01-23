package p007b.p225i.p361c.p406w;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.esotericsoftware.kryo.p502io.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p313h.p322i.C3488b;
import p007b.p225i.p226a.p288f.p313h.p322i.C3490d;
import p007b.p225i.p226a.p288f.p313h.p322i.C3491e;

/* JADX INFO: renamed from: b.i.c.w.n */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CallableC4876n implements Callable {

    /* JADX INFO: renamed from: j */
    public final C4877o f13033j;

    public CallableC4876n(C4877o c4877o) {
        this.f13033j = c4877o;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        byte[] bArrM4412a;
        C4877o c4877o = this.f13033j;
        String strValueOf = String.valueOf(c4877o.f13034j);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Starting download of: ");
        sb.append(strValueOf);
        Log.i("FirebaseMessaging", sb.toString());
        URLConnection uRLConnectionOpenConnection = c4877o.f13034j.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            c4877o.f13036l = inputStream;
            int i = C3488b.f9652a;
            C3490d c3490d = new C3490d(inputStream);
            ArrayDeque arrayDeque = new ArrayDeque(20);
            int i2 = 8192;
            int i3 = 0;
            loop0: while (true) {
                if (i3 < 2147483639) {
                    int iMin = Math.min(i2, Util.MAX_SAFE_ARRAY_SIZE - i3);
                    byte[] bArr = new byte[iMin];
                    arrayDeque.add(bArr);
                    int i4 = 0;
                    while (i4 < iMin) {
                        int i5 = c3490d.read(bArr, i4, iMin - i4);
                        if (i5 == -1) {
                            bArrM4412a = C3488b.m4412a(arrayDeque, i3);
                            break loop0;
                        }
                        i4 += i5;
                        i3 += i5;
                    }
                    long j = ((long) i2) << 1;
                    i2 = j > 2147483647L ? Integer.MAX_VALUE : j < -2147483648L ? Integer.MIN_VALUE : (int) j;
                } else {
                    if (c3490d.read() != -1) {
                        throw new OutOfMemoryError("input is too large to fit in a byte array");
                    }
                    bArrM4412a = C3488b.m4412a(arrayDeque, Util.MAX_SAFE_ARRAY_SIZE);
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                int length = bArrM4412a.length;
                String strValueOf2 = String.valueOf(c4877o.f13034j);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 34);
                sb2.append("Downloaded ");
                sb2.append(length);
                sb2.append(" bytes from ");
                sb2.append(strValueOf2);
                Log.v("FirebaseMessaging", sb2.toString());
            }
            if (bArrM4412a.length > 1048576) {
                throw new IOException("Image exceeds max size of 1048576");
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM4412a, 0, bArrM4412a.length);
            if (bitmapDecodeByteArray == null) {
                String strValueOf3 = String.valueOf(c4877o.f13034j);
                throw new IOException(outline.m857j(strValueOf3.length() + 24, "Failed to decode image: ", strValueOf3));
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String strValueOf4 = String.valueOf(c4877o.f13034j);
                StringBuilder sb3 = new StringBuilder(strValueOf4.length() + 31);
                sb3.append("Successfully downloaded image: ");
                sb3.append(strValueOf4);
                Log.d("FirebaseMessaging", sb3.toString());
            }
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    C3491e.f9656a.mo4413a(th, th2);
                }
            }
            throw th;
        }
    }
}

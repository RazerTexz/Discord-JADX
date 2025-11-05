package b.o.a;

import android.os.Handler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: CameraUtils.java */
/* loaded from: classes3.dex */
public class d implements Runnable {
    public final /* synthetic */ byte[] j;
    public final /* synthetic */ File k;
    public final /* synthetic */ Handler l;
    public final /* synthetic */ k m;

    /* compiled from: CameraUtils.java */
    public class a implements Runnable {
        public final /* synthetic */ File j;

        public a(File file) {
            this.j = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m.a(this.j);
        }
    }

    public d(byte[] bArr, File file, Handler handler, k kVar) {
        this.j = bArr;
        this.k = file;
        this.l = handler;
        this.m = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArr = this.j;
        File file = this.k;
        if (!file.exists() || file.delete()) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } finally {
                }
            } catch (IOException e) {
                e.a.a(3, "writeToFile:", "could not write file.", e);
            }
        } else {
            file = null;
        }
        this.l.post(new a(file));
    }
}

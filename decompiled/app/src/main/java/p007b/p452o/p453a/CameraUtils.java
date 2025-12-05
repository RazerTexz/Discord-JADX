package p007b.p452o.p453a;

import android.os.Handler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: CameraUtils.java */
/* renamed from: b.o.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraUtils implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ byte[] f13699j;

    /* renamed from: k */
    public final /* synthetic */ File f13700k;

    /* renamed from: l */
    public final /* synthetic */ Handler f13701l;

    /* renamed from: m */
    public final /* synthetic */ FileCallback f13702m;

    /* compiled from: CameraUtils.java */
    /* renamed from: b.o.a.d$a */
    public class a implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ File f13703j;

        public a(File file) {
            this.f13703j = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraUtils.this.f13702m.mo7165a(this.f13703j);
        }
    }

    public CameraUtils(byte[] bArr, File file, Handler handler, FileCallback fileCallback) {
        this.f13699j = bArr;
        this.f13700k = file;
        this.f13701l = handler;
        this.f13702m = fileCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArr = this.f13699j;
        File file = this.f13700k;
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
                CameraUtils2.f13705a.m7159a(3, "writeToFile:", "could not write file.", e);
            }
        } else {
            file = null;
        }
        this.f13701l.post(new a(file));
    }
}

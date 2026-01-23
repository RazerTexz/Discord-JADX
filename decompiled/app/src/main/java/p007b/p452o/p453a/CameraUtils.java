package p007b.p452o.p453a;

import android.os.Handler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: renamed from: b.o.a.d, reason: use source file name */
/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraUtils implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ byte[] f13699j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ File f13700k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Handler f13701l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ FileCallback f13702m;

    /* JADX INFO: renamed from: b.o.a.d$a */
    /* JADX INFO: compiled from: CameraUtils.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
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
                file = null;
            }
        } else {
            file = null;
        }
        this.f13701l.post(new a(file));
    }
}

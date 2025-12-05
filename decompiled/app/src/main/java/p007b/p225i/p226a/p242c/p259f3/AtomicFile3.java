package p007b.p225i.p226a.p242c.p259f3;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: AtomicFile.java */
/* renamed from: b.i.a.c.f3.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class AtomicFile3 {

    /* renamed from: a */
    public final File f6704a;

    /* renamed from: b */
    public final File f6705b;

    /* compiled from: AtomicFile.java */
    /* renamed from: b.i.a.c.f3.e$a */
    public static final class a extends OutputStream {

        /* renamed from: j */
        public final FileOutputStream f6706j;

        /* renamed from: k */
        public boolean f6707k = false;

        public a(File file) throws FileNotFoundException {
            this.f6706j = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f6707k) {
                return;
            }
            this.f6707k = true;
            this.f6706j.flush();
            try {
                this.f6706j.getFD().sync();
            } catch (IOException e) {
                Log2.m3040c("AtomicFile", "Failed to sync file descriptor:", e);
            }
            this.f6706j.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f6706j.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f6706j.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f6706j.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f6706j.write(bArr, i, i2);
        }
    }

    public AtomicFile3(File file) {
        this.f6704a = file;
        this.f6705b = new File(String.valueOf(file.getPath()).concat(".bak"));
    }

    /* renamed from: a */
    public boolean m2977a() {
        return this.f6704a.exists() || this.f6705b.exists();
    }

    /* renamed from: b */
    public InputStream m2978b() throws FileNotFoundException {
        if (this.f6705b.exists()) {
            this.f6704a.delete();
            this.f6705b.renameTo(this.f6704a);
        }
        return new FileInputStream(this.f6704a);
    }

    /* renamed from: c */
    public OutputStream m2979c() throws IOException {
        if (this.f6704a.exists()) {
            if (this.f6705b.exists()) {
                this.f6704a.delete();
            } else if (!this.f6704a.renameTo(this.f6705b)) {
                String strValueOf = String.valueOf(this.f6704a);
                String strValueOf2 = String.valueOf(this.f6705b);
                Log.w("AtomicFile", outline.m861l(strValueOf2.length() + strValueOf.length() + 37, "Couldn't rename file ", strValueOf, " to backup file ", strValueOf2));
            }
        }
        try {
            return new a(this.f6704a);
        } catch (FileNotFoundException e) {
            File parentFile = this.f6704a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                String strValueOf3 = String.valueOf(this.f6704a);
                throw new IOException(outline.m857j(strValueOf3.length() + 16, "Couldn't create ", strValueOf3), e);
            }
            try {
                return new a(this.f6704a);
            } catch (FileNotFoundException e2) {
                String strValueOf4 = String.valueOf(this.f6704a);
                throw new IOException(outline.m857j(strValueOf4.length() + 16, "Couldn't create ", strValueOf4), e2);
            }
        }
    }
}

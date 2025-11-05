package b.i.c.m.d.l;

import android.util.Log;
import b.i.c.m.d.k.h;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

/* compiled from: QueueFileLogStore.java */
/* loaded from: classes3.dex */
public class e implements b.i.c.m.d.l.a {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* renamed from: b, reason: collision with root package name */
    public final File f1711b;
    public final int c;
    public c d;

    /* compiled from: QueueFileLogStore.java */
    public class a {
        public final byte[] a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1712b;

        public a(e eVar, byte[] bArr, int i) {
            this.a = bArr;
            this.f1712b = i;
        }
    }

    public e(File file, int i) {
        this.f1711b = file;
        this.c = i;
    }

    @Override // b.i.c.m.d.l.a
    public void a() {
        h.c(this.d, "There was a problem closing the Crashlytics log file.");
        this.d = null;
    }

    @Override // b.i.c.m.d.l.a
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, a);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    @Override // b.i.c.m.d.l.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] c() {
        a aVar;
        if (this.f1711b.exists()) {
            f();
            c cVar = this.d;
            if (cVar != null) {
                int[] iArr = {0};
                byte[] bArr = new byte[cVar.x()];
                try {
                    this.d.e(new d(this, bArr, iArr));
                } catch (IOException e) {
                    if (b.i.c.m.d.b.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "A problem occurred while reading the Crashlytics log file.", e);
                    }
                }
                aVar = new a(this, bArr, iArr[0]);
            }
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        int i = aVar.f1712b;
        byte[] bArr2 = new byte[i];
        System.arraycopy(aVar.a, 0, bArr2, 0, i);
        return bArr2;
    }

    @Override // b.i.c.m.d.l.a
    public void d() {
        h.c(this.d, "There was a problem closing the Crashlytics log file.");
        this.d = null;
        this.f1711b.delete();
    }

    @Override // b.i.c.m.d.l.a
    public void e(long j, String str) {
        f();
        if (this.d == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.c / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.d.b(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(a));
            while (!this.d.f() && this.d.x() > this.c) {
                this.d.s();
            }
        } catch (IOException e) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }

    public final void f() {
        if (this.d == null) {
            try {
                this.d = new c(this.f1711b);
            } catch (IOException e) {
                b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
                StringBuilder sbU = b.d.b.a.a.U("Could not open log file: ");
                sbU.append(this.f1711b);
                bVar.e(sbU.toString(), e);
            }
        }
    }
}

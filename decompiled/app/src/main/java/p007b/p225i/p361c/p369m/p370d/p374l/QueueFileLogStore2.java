package p007b.p225i.p361c.p369m.p370d.p374l;

import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;

/* compiled from: QueueFileLogStore.java */
/* renamed from: b.i.c.m.d.l.e, reason: use source file name */
/* loaded from: classes3.dex */
public class QueueFileLogStore2 implements FileLogStore {

    /* renamed from: a */
    public static final Charset f12491a = Charset.forName(Constants.ENCODING);

    /* renamed from: b */
    public final File f12492b;

    /* renamed from: c */
    public final int f12493c;

    /* renamed from: d */
    public QueueFile f12494d;

    /* compiled from: QueueFileLogStore.java */
    /* renamed from: b.i.c.m.d.l.e$a */
    public class a {

        /* renamed from: a */
        public final byte[] f12495a;

        /* renamed from: b */
        public final int f12496b;

        public a(QueueFileLogStore2 queueFileLogStore2, byte[] bArr, int i) {
            this.f12495a = bArr;
            this.f12496b = i;
        }
    }

    public QueueFileLogStore2(File file, int i) {
        this.f12492b = file;
        this.f12493c = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
    /* renamed from: a */
    public void mo6491a() {
        CommonUtils.m6409c(this.f12494d, "There was a problem closing the Crashlytics log file.");
        this.f12494d = null;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
    /* renamed from: b */
    public String mo6492b() {
        byte[] bArrMo6493c = mo6493c();
        if (bArrMo6493c != null) {
            return new String(bArrMo6493c, f12491a);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] mo6493c() {
        a aVar;
        if (this.f12492b.exists()) {
            m6513f();
            QueueFile queueFile = this.f12494d;
            if (queueFile != null) {
                int[] iArr = {0};
                byte[] bArr = new byte[queueFile.m6510x()];
                try {
                    this.f12494d.m6504e(new QueueFileLogStore(this, bArr, iArr));
                } catch (IOException e) {
                    if (Logger3.f12227a.m6370a(6)) {
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
        int i = aVar.f12496b;
        byte[] bArr2 = new byte[i];
        System.arraycopy(aVar.f12495a, 0, bArr2, 0, i);
        return bArr2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
    /* renamed from: d */
    public void mo6494d() {
        CommonUtils.m6409c(this.f12494d, "There was a problem closing the Crashlytics log file.");
        this.f12494d = null;
        this.f12492b.delete();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
    /* renamed from: e */
    public void mo6495e(long j, String str) {
        m6513f();
        if (this.f12494d == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.f12493c / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.f12494d.m6501b(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f12491a));
            while (!this.f12494d.m6505f() && this.f12494d.m6510x() > this.f12493c) {
                this.f12494d.m6507s();
            }
        } catch (IOException e) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }

    /* renamed from: f */
    public final void m6513f() {
        if (this.f12494d == null) {
            try {
                this.f12494d = new QueueFile(this.f12492b);
            } catch (IOException e) {
                Logger3 logger3 = Logger3.f12227a;
                StringBuilder sbM833U = outline.m833U("Could not open log file: ");
                sbM833U.append(this.f12492b);
                logger3.m6374e(sbM833U.toString(), e);
            }
        }
    }
}

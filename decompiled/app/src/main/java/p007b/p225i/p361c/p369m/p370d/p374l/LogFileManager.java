package p007b.p225i.p361c.p369m.p370d.p374l;

import android.content.Context;
import java.io.File;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;

/* JADX INFO: renamed from: b.i.c.m.d.l.b, reason: use source file name */
/* JADX INFO: compiled from: LogFileManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class LogFileManager {

    /* JADX INFO: renamed from: a */
    public static final c f12470a = new c(null);

    /* JADX INFO: renamed from: b */
    public final Context f12471b;

    /* JADX INFO: renamed from: c */
    public final b f12472c;

    /* JADX INFO: renamed from: d */
    public FileLogStore f12473d = f12470a;

    /* JADX INFO: renamed from: b.i.c.m.d.l.b$b */
    /* JADX INFO: compiled from: LogFileManager.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.c.m.d.l.b$c */
    /* JADX INFO: compiled from: LogFileManager.java */
    public static final class c implements FileLogStore {
        public c(a aVar) {
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
        /* JADX INFO: renamed from: a */
        public void mo6491a() {
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
        /* JADX INFO: renamed from: b */
        public String mo6492b() {
            return null;
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
        /* JADX INFO: renamed from: c */
        public byte[] mo6493c() {
            return null;
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
        /* JADX INFO: renamed from: d */
        public void mo6494d() {
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p374l.FileLogStore
        /* JADX INFO: renamed from: e */
        public void mo6495e(long j, String str) {
        }
    }

    public LogFileManager(Context context, b bVar) {
        this.f12471b = context;
        this.f12472c = bVar;
        m6496a(null);
    }

    /* JADX INFO: renamed from: a */
    public final void m6496a(String str) {
        this.f12473d.mo6491a();
        this.f12473d = f12470a;
        if (str == null) {
            return;
        }
        if (!CommonUtils.m6416j(this.f12471b, "com.crashlytics.CollectCustomLogs", true)) {
            Logger3.f12227a.m6371b("Preferences requested no custom logs. Aborting log file creation.");
        } else {
            this.f12473d = new QueueFileLogStore2(new File(((C4663x.j) this.f12472c).m6487a(), outline.m886y("crashlytics-userlog-", str, ".temp")), 65536);
        }
    }

    public LogFileManager(Context context, b bVar, String str) {
        this.f12471b = context;
        this.f12472c = bVar;
        m6496a(str);
    }
}

package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import java.util.Date;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsUncaughtExceptionHandler;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsDataProvider;

/* compiled from: CrashlyticsController.java */
/* renamed from: b.i.c.m.d.k.b0 */
/* loaded from: classes3.dex */
public class C4611b0 implements CrashlyticsUncaughtExceptionHandler.a {

    /* renamed from: a */
    public final /* synthetic */ C4663x f12266a;

    public C4611b0(C4663x c4663x) {
        this.f12266a = c4663x;
    }

    /* renamed from: a */
    public void m6395a(@NonNull SettingsDataProvider settingsDataProvider, @NonNull Thread thread, @NonNull Throwable th) {
        C4663x c4663x = this.f12266a;
        synchronized (c4663x) {
            Logger3.f12227a.m6371b("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            try {
                Utils3.m6432a(c4663x.f12433m.m6438c(new CallableC4617d0(c4663x, new Date(), th, thread, settingsDataProvider)));
            } catch (Exception unused) {
            }
        }
    }
}

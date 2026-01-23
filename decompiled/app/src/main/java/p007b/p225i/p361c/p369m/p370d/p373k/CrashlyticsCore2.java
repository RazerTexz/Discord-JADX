package p007b.p225i.p361c.p369m.p370d.p373k;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsDataProvider;

/* JADX INFO: renamed from: b.i.c.m.d.k.j0, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsCore2 implements Callable<Task<Void>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ SettingsDataProvider f12323j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CrashlyticsCore3 f12324k;

    public CrashlyticsCore2(CrashlyticsCore3 crashlyticsCore3, SettingsDataProvider settingsDataProvider) {
        this.f12324k = crashlyticsCore3;
        this.f12323j = settingsDataProvider;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return CrashlyticsCore3.m6439a(this.f12324k, this.f12323j);
    }
}

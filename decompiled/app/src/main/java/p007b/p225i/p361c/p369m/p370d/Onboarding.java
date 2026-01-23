package p007b.p225i.p361c.p369m.p370d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;

/* JADX INFO: renamed from: b.i.c.m.d.e, reason: use source file name */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class Onboarding implements InterfaceC4362f<AppSettingsData, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f12229a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingsController f12230b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Executor f12231c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Onboarding4 f12232d;

    public Onboarding(Onboarding4 onboarding4, String str, SettingsController settingsController, Executor executor) {
        this.f12232d = onboarding4;
        this.f12229a = str;
        this.f12230b = settingsController;
        this.f12231c = executor;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<Void> mo4013a(@Nullable AppSettingsData appSettingsData) throws Exception {
        try {
            Onboarding4.m6383a(this.f12232d, appSettingsData, this.f12229a, this.f12230b, this.f12231c, true);
            return null;
        } catch (Exception e) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Error performing auto configuration.", e);
            }
            throw e;
        }
    }
}

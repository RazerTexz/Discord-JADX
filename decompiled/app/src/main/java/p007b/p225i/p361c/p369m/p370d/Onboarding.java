package p007b.p225i.p361c.p369m.p370d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;

/* compiled from: Onboarding.java */
/* renamed from: b.i.c.m.d.e, reason: use source file name */
/* loaded from: classes3.dex */
public class Onboarding implements InterfaceC4362f<AppSettingsData, Void> {

    /* renamed from: a */
    public final /* synthetic */ String f12229a;

    /* renamed from: b */
    public final /* synthetic */ SettingsController f12230b;

    /* renamed from: c */
    public final /* synthetic */ Executor f12231c;

    /* renamed from: d */
    public final /* synthetic */ Onboarding4 f12232d;

    public Onboarding(Onboarding4 onboarding4, String str, SettingsController settingsController, Executor executor) {
        this.f12232d = onboarding4;
        this.f12229a = str;
        this.f12230b = settingsController;
        this.f12231c = executor;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* renamed from: a */
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

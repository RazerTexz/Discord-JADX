package p007b.p225i.p361c.p369m.p370d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;

/* JADX INFO: renamed from: b.i.c.m.d.f, reason: use source file name */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class Onboarding2 implements InterfaceC4362f<Void, AppSettingsData> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SettingsController f12233a;

    public Onboarding2(Onboarding4 onboarding4, SettingsController settingsController) {
        this.f12233a = settingsController;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<AppSettingsData> mo4013a(@Nullable Void r1) throws Exception {
        return this.f12233a.m6683a();
    }
}

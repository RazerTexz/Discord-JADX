package p677y.p678a.p679a;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsSessionToken;

/* compiled from: lambda */
/* renamed from: y.a.a.a */
/* loaded from: classes.dex */
public final /* synthetic */ class C13186a implements IBinder.DeathRecipient {

    /* renamed from: a */
    public final /* synthetic */ CustomTabsService.BinderC01531 f27950a;

    /* renamed from: b */
    public final /* synthetic */ CustomTabsSessionToken f27951b;

    public /* synthetic */ C13186a(CustomTabsService.BinderC01531 binderC01531, CustomTabsSessionToken customTabsSessionToken) {
        this.f27950a = binderC01531;
        this.f27951b = customTabsSessionToken;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        CustomTabsService.BinderC01531 binderC01531 = this.f27950a;
        CustomTabsService.this.cleanUpSession(this.f27951b);
    }
}

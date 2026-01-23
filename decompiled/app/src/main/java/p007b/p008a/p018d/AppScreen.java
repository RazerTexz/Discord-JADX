package p007b.p008a.p018d;

import com.discord.app.AppActivity;

/* JADX INFO: renamed from: b.a.d.i, reason: use source file name */
/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppScreen implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppActivity f517j;

    public AppScreen(AppActivity appActivity) {
        this.f517j = appActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f517j.recreate();
    }
}

package b.a.d;

import com.discord.app.AppActivity;

/* compiled from: AppScreen.kt */
/* loaded from: classes.dex */
public final class i implements Runnable {
    public final /* synthetic */ AppActivity j;

    public i(AppActivity appActivity) {
        this.j = appActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.recreate();
    }
}

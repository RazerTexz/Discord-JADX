package com.discord.widgets.servers.settings.invites;

import android.view.View;
import com.discord.utilities.dimen.DimenUtils;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvitesListItem$onConfigure$$inlined$doOnPreDraw$1 */
/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC9586xe6575b2a implements Runnable {
    public final /* synthetic */ View $this_doOnPreDraw;

    public RunnableC9586xe6575b2a(View view) {
        this.$this_doOnPreDraw = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.$this_doOnPreDraw;
        view.setMinimumWidth(DimenUtils.dpToPixels(4) + view.getWidth());
    }
}

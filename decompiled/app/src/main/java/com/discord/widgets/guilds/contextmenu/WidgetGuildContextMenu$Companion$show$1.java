package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* compiled from: WidgetGuildContextMenu.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildContextMenu$Companion$show$1 implements View.OnClickListener {
    public final /* synthetic */ FragmentActivity $activity;

    public WidgetGuildContextMenu$Companion$show$1(FragmentActivity fragmentActivity) {
        this.$activity = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildContextMenu.INSTANCE.hide(this.$activity, true);
    }
}

package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* compiled from: WidgetGuildContextMenu.kt */
/* renamed from: com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu$Companion$show$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildContextMenu2 implements View.OnClickListener {
    public final /* synthetic */ FragmentActivity $activity;

    public WidgetGuildContextMenu2(FragmentActivity fragmentActivity) {
        this.$activity = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildContextMenu.INSTANCE.hide(this.$activity, true);
    }
}

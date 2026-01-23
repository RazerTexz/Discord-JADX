package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$Companion$show$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu2 implements View.OnClickListener {
    public final /* synthetic */ FragmentActivity $activity;

    public WidgetFolderContextMenu2(FragmentActivity fragmentActivity) {
        this.$activity = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetFolderContextMenu.INSTANCE.hide(this.$activity, true);
    }
}

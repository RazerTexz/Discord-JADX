package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetDirectoryChannel.kt */
/* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannel6 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    public WidgetDirectoryChannel6(Guild guild, WidgetDirectoryChannel widgetDirectoryChannel) {
        this.$guild = guild;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
        Context contextX = outline.x(view, "it", "it.context");
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetGuildInviteShare.Companion.launch$default(companion, contextX, childFragmentManager, this.$guild.getId(), null, false, null, null, "Guild Header", 120, null);
    }
}

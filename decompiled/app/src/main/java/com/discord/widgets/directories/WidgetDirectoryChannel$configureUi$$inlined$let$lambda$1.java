package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import d0.z.d.m;

/* compiled from: WidgetDirectoryChannel.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    public WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1(Guild guild, WidgetDirectoryChannel widgetDirectoryChannel) {
        this.$guild = guild;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
        Context contextX = a.x(view, "it", "it.context");
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetGuildInviteShare.Companion.launch$default(companion, contextX, childFragmentManager, this.$guild.getId(), null, false, null, null, "Guild Header", 120, null);
    }
}

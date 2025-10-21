package com.discord.widgets.servers.auditlog;

import android.view.View;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter2 implements View.OnClickListener {
    public final /* synthetic */ GuildMember $guildMember;
    public final /* synthetic */ User $user;
    public final /* synthetic */ WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder this$0;

    public WidgetServerSettingsAuditLogAdapter2(WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder auditLogEntryViewHolder, User user, GuildMember guildMember) {
        this.this$0 = auditLogEntryViewHolder;
        this.$user = user;
        this.$guildMember = guildMember;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.$user != null) {
            Function2<Long, Long, Unit> onAuditLogAvatarClicked = WidgetServerSettingsAuditLogAdapter.AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getOnAuditLogAvatarClicked();
            Long lValueOf = Long.valueOf(this.$user.getId());
            GuildMember guildMember = this.$guildMember;
            onAuditLogAvatarClicked.invoke(lValueOf, guildMember != null ? Long.valueOf(guildMember.getGuildId()) : null);
        }
    }
}

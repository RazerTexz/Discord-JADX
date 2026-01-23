package com.discord.widgets.servers.auditlog;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter5 extends Lambda implements Function1<User, WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem> {
    public final /* synthetic */ StoreAuditLog.AuditLogState $auditLogState;
    public final /* synthetic */ Map $guildMembers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter5(Map map, StoreAuditLog.AuditLogState auditLogState) {
        super(1);
        this.$guildMembers = map;
        this.$auditLogState = auditLogState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem invoke(User user) {
        return invoke2(user);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem(user, (GuildMember) outline.m849f(user, this.$guildMembers), user.getId(), null, Integer.valueOf(user.getDiscriminator()), this.$auditLogState.getFilter().getUserFilter() == user.getId());
    }
}

package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.member.GuildMember;
import com.discord.stores.DiscoverCommands;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import java.util.List;
import java.util.Map;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func5;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource$Companion$getDiscoveryCommands$1, reason: use source file name */
/* JADX INFO: compiled from: ApplicationCommandsAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCommandsAutocompletableSource2<T1, T2, T3, T4, T5, R> implements Func5<Long, Map<Long, ? extends GuildMember>, DiscoverCommands, List<? extends Application>, List<? extends ApplicationCommand>, WidgetChatInputDiscoveryCommandsModel> {
    public final /* synthetic */ boolean $includeHeaders;
    public final /* synthetic */ int $placeholdersCount;

    public ApplicationCommandsAutocompletableSource2(boolean z2, int i) {
        this.$includeHeaders = z2;
        this.$placeholdersCount = i;
    }

    @Override // p658rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChatInputDiscoveryCommandsModel call(Long l, Map<Long, ? extends GuildMember> map, DiscoverCommands discoverCommands, List<? extends Application> list, List<? extends ApplicationCommand> list2) {
        return call2(l, (Map<Long, GuildMember>) map, discoverCommands, (List<Application>) list, list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatInputDiscoveryCommandsModel call2(Long l, Map<Long, GuildMember> map, DiscoverCommands discoverCommands, List<Application> list, List<? extends ApplicationCommand> list2) {
        WidgetChatInputDiscoveryCommandsModel.Companion companion = WidgetChatInputDiscoveryCommandsModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(l, "meId");
        long jLongValue = l.longValue();
        GuildMember guildMember = map.get(l);
        List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
        if (roles == null) {
            roles = Collections2.emptyList();
        }
        Intrinsics3.checkNotNullExpressionValue(list, "apps");
        Intrinsics3.checkNotNullExpressionValue(discoverCommands, "discoveryCommands");
        boolean z2 = this.$includeHeaders;
        int i = this.$placeholdersCount;
        Intrinsics3.checkNotNullExpressionValue(list2, "frecency");
        return companion.parseModelDiscoveryCommands(jLongValue, roles, list, discoverCommands, z2, i, list2);
    }
}

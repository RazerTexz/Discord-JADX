package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.member.GuildMember;
import com.discord.stores.CommandAutocompleteState;
import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import d0.t.n;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.Observable;
import rx.functions.Func9;

/* compiled from: AutocompleteViewModel.kt */
/* loaded from: classes2.dex */
public final class AutocompleteViewModel$Companion$observeStores$1<T, R> implements b<Channel, Observable<? extends AutocompleteViewModel.StoreState>> {
    public final /* synthetic */ StoreApplicationCommands $storeApplicationCommands;
    public final /* synthetic */ StoreApplicationCommandFrecency $storeApplicationCommandsFrecency;

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Long, Map<Long, ? extends GuildMember>, WidgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>, List<? extends Application>, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>>, List<? extends String>, List<? extends ApplicationCommand>, AutocompleteViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func9
        public /* bridge */ /* synthetic */ AutocompleteViewModel.StoreState call(Long l, Map<Long, ? extends GuildMember> map, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand> list, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, List<? extends Application> list2, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, List<? extends String> list3, List<? extends ApplicationCommand> list4) {
            return call2(l, (Map<Long, GuildMember>) map, widgetChatInputDiscoveryCommandsModel, list, map2, (List<Application>) list2, map3, (List<String>) list3, list4);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final AutocompleteViewModel.StoreState call2(Long l, Map<Long, GuildMember> map, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand> list, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, List<Application> list2, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, List<String> list3, List<? extends ApplicationCommand> list4) {
            m.checkNotNullExpressionValue(l, "userId");
            long jLongValue = l.longValue();
            GuildMember guildMember = map.get(l);
            List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
            if (roles == null) {
                roles = n.emptyList();
            }
            Channel channel = this.$channel;
            m.checkNotNullExpressionValue(channel, "channel");
            m.checkNotNullExpressionValue(list, "queriedCommands");
            m.checkNotNullExpressionValue(list2, "apps");
            m.checkNotNullExpressionValue(map3, "autoOptions");
            m.checkNotNullExpressionValue(map2, "autocompletables");
            m.checkNotNullExpressionValue(list3, "frecencyIds");
            m.checkNotNullExpressionValue(list4, "frecencyApps");
            return new AutocompleteViewModel.StoreState(jLongValue, roles, channel, list, list2, map3, map2, widgetChatInputDiscoveryCommandsModel, list3, list4);
        }
    }

    public AutocompleteViewModel$Companion$observeStores$1(StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        this.$storeApplicationCommands = storeApplicationCommands;
        this.$storeApplicationCommandsFrecency = storeApplicationCommandFrecency;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends AutocompleteViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends AutocompleteViewModel.StoreState> call2(Channel channel) {
        m.checkNotNullExpressionValue(channel, "channel");
        Observable<List<ApplicationCommand>> kVar = ChannelUtils.j(channel) ? new k<>(n.emptyList()) : this.$storeApplicationCommands.observeQueryCommands(channel.getId());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.c(companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), ApplicationCommandsAutocompletableSource.INSTANCE.getDiscoveryCommands(true, 3, channel), kVar, ChatInputAutocompletables.INSTANCE.observeChannelAutocompletables(channel.getId()), this.$storeApplicationCommands.observeGuildApplications(channel.getId()), this.$storeApplicationCommands.observeAutocompleteResults(), this.$storeApplicationCommandsFrecency.observeTopCommandIds(Long.valueOf(channel.getGuildId())), this.$storeApplicationCommands.observeFrecencyCommands(channel.getGuildId()), new AnonymousClass1(channel));
    }
}

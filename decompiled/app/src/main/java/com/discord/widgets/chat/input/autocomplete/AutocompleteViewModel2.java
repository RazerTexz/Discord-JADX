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
import java.util.List;
import java.util.Map;
import java.util.Set;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func9;

/* compiled from: AutocompleteViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AutocompleteViewModel2<T, R> implements Func1<Channel, Observable<? extends AutocompleteViewModel.StoreState>> {
    public final /* synthetic */ StoreApplicationCommands $storeApplicationCommands;
    public final /* synthetic */ StoreApplicationCommandFrecency $storeApplicationCommandsFrecency;

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$Companion$observeStores$1$1 */
    public static final class C77751<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Long, Map<Long, ? extends GuildMember>, WidgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>, List<? extends Application>, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>>, List<? extends String>, List<? extends ApplicationCommand>, AutocompleteViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;

        public C77751(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func9
        public /* bridge */ /* synthetic */ AutocompleteViewModel.StoreState call(Long l, Map<Long, ? extends GuildMember> map, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand> list, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, List<? extends Application> list2, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, List<? extends String> list3, List<? extends ApplicationCommand> list4) {
            return call2(l, (Map<Long, GuildMember>) map, widgetChatInputDiscoveryCommandsModel, list, map2, (List<Application>) list2, map3, (List<String>) list3, list4);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final AutocompleteViewModel.StoreState call2(Long l, Map<Long, GuildMember> map, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand> list, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, List<Application> list2, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, List<String> list3, List<? extends ApplicationCommand> list4) {
            Intrinsics3.checkNotNullExpressionValue(l, "userId");
            long jLongValue = l.longValue();
            GuildMember guildMember = map.get(l);
            List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
            if (roles == null) {
                roles = Collections2.emptyList();
            }
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            Intrinsics3.checkNotNullExpressionValue(list, "queriedCommands");
            Intrinsics3.checkNotNullExpressionValue(list2, "apps");
            Intrinsics3.checkNotNullExpressionValue(map3, "autoOptions");
            Intrinsics3.checkNotNullExpressionValue(map2, "autocompletables");
            Intrinsics3.checkNotNullExpressionValue(list3, "frecencyIds");
            Intrinsics3.checkNotNullExpressionValue(list4, "frecencyApps");
            return new AutocompleteViewModel.StoreState(jLongValue, roles, channel, list, list2, map3, map2, widgetChatInputDiscoveryCommandsModel, list3, list4);
        }
    }

    public AutocompleteViewModel2(StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        this.$storeApplicationCommands = storeApplicationCommands;
        this.$storeApplicationCommandsFrecency = storeApplicationCommandFrecency;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends AutocompleteViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends AutocompleteViewModel.StoreState> call2(Channel channel) {
        Intrinsics3.checkNotNullExpressionValue(channel, "channel");
        Observable<List<ApplicationCommand>> scalarSynchronousObservable = ChannelUtils.m7686j(channel) ? new ScalarSynchronousObservable<>(Collections2.emptyList()) : this.$storeApplicationCommands.observeQueryCommands(channel.getId());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11066c(companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), ApplicationCommandsAutocompletableSource.INSTANCE.getDiscoveryCommands(true, 3, channel), scalarSynchronousObservable, InputAutocompletables.INSTANCE.observeChannelAutocompletables(channel.getId()), this.$storeApplicationCommands.observeGuildApplications(channel.getId()), this.$storeApplicationCommands.observeAutocompleteResults(), this.$storeApplicationCommandsFrecency.observeTopCommandIds(Long.valueOf(channel.getGuildId())), this.$storeApplicationCommands.observeFrecencyCommands(channel.getGuildId()), new C77751(channel));
    }
}

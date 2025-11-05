package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandKt;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandAutocompletable;
import com.discord.widgets.chat.input.autocomplete.ApplicationCommandChoiceAutocompletable;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.t.g0;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: ApplicationCommandsAutocompletableSource.kt */
/* loaded from: classes2.dex */
public final class ApplicationCommandsAutocompletableSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreApplicationCommands storeApplicationCommands;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUsers;

    /* compiled from: ApplicationCommandsAutocompletableSource.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<Autocompletable> createFromCommandOption(ApplicationCommandOption option) {
            m.checkNotNullParameter(option, "option");
            ArrayList arrayList = new ArrayList();
            if (option.getType() == ApplicationCommandType.BOOLEAN) {
                arrayList.add(new ApplicationCommandChoiceAutocompletable(new CommandChoice("true", "true"), null, 2, null));
                arrayList.add(new ApplicationCommandChoiceAutocompletable(new CommandChoice("false", "false"), null, 2, null));
            } else {
                List<CommandChoice> choices = option.getChoices();
                if (!(choices == null || choices.isEmpty())) {
                    List<CommandChoice> choices2 = option.getChoices();
                    ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(choices2, 10));
                    Iterator<T> it = choices2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new ApplicationCommandChoiceAutocompletable((CommandChoice) it.next(), null, 2, null));
                    }
                    arrayList.addAll(arrayList2);
                }
            }
            return arrayList;
        }

        public final Observable<WidgetChatInputDiscoveryCommandsModel> getDiscoveryCommands(boolean includeHeaders, int placeholdersCount, Channel channel) {
            m.checkNotNullParameter(channel, "channel");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<WidgetChatInputDiscoveryCommandsModel> observableG = Observable.g(companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), companion.getApplicationCommands().observeDiscoverCommands(channel.getId()), companion.getApplicationCommands().observeGuildApplications(channel.getId()), companion.getApplicationCommands().observeFrecencyCommands(channel.getGuildId()), new ApplicationCommandsAutocompletableSource$Companion$getDiscoveryCommands$1(includeHeaders, placeholdersCount));
            m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…recency\n        )\n      }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ApplicationCommandsAutocompletableSource.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource$observeApplicationCommandAutocompletables$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Long, Map<Long, ? extends GuildMember>, List<? extends Application>, List<? extends ApplicationCommand>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Long l, Map<Long, ? extends GuildMember> map, List<? extends Application> list, List<? extends ApplicationCommand> list2) {
            return call2(l, (Map<Long, GuildMember>) map, (List<Application>) list, list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Long l, Map<Long, GuildMember> map, List<Application> list, List<? extends ApplicationCommand> list2) {
            m.checkNotNullExpressionValue(list2, "queries");
            if (!(!list2.isEmpty())) {
                return g0.mapOf(d0.o.to(LeadingIdentifier.APP_COMMAND, new TreeSet()));
            }
            ApplicationCommandsAutocompletableSource applicationCommandsAutocompletableSource = ApplicationCommandsAutocompletableSource.this;
            m.checkNotNullExpressionValue(l, "myId");
            long jLongValue = l.longValue();
            GuildMember guildMember = map.get(l);
            List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
            if (roles == null) {
                roles = n.emptyList();
            }
            m.checkNotNullExpressionValue(list, "apps");
            return ApplicationCommandsAutocompletableSource.access$createAutocompletablesForApplicationCommands(applicationCommandsAutocompletableSource, jLongValue, roles, list, list2);
        }
    }

    public ApplicationCommandsAutocompletableSource(StoreUser storeUser, StoreGuilds storeGuilds, StoreApplicationCommands storeApplicationCommands) {
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeApplicationCommands = storeApplicationCommands;
    }

    public static final /* synthetic */ Map access$createAutocompletablesForApplicationCommands(ApplicationCommandsAutocompletableSource applicationCommandsAutocompletableSource, long j, List list, List list2, List list3) {
        return applicationCommandsAutocompletableSource.createAutocompletablesForApplicationCommands(j, list, list2, list3);
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForApplicationCommands(long myId, List<Long> myChannelRoles, List<Application> apps, List<? extends ApplicationCommand> appCommands) {
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        HashMap map = new HashMap();
        for (Application application : apps) {
            map.put(Long.valueOf(application.getId()), application);
        }
        for (ApplicationCommand applicationCommand : appCommands) {
            treeSet.add(new ApplicationCommandAutocompletable((Application) map.get(Long.valueOf(applicationCommand.getApplicationId())), applicationCommand, ApplicationCommandKt.hasPermission(applicationCommand, myId, myChannelRoles), true));
        }
        return g0.mapOf(d0.o.to(LeadingIdentifier.APP_COMMAND, treeSet));
    }

    public final StoreApplicationCommands getStoreApplicationCommands() {
        return this.storeApplicationCommands;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StoreUser getStoreUsers() {
        return this.storeUsers;
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeApplicationCommandAutocompletables(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        Observable observableH = Observable.h(ObservableExtensionsKt.computationLatest(this.storeUsers.observeMeId()), ObservableExtensionsKt.computationLatest(this.storeGuilds.observeComputed(channel.getGuildId())), ObservableExtensionsKt.computationLatest(this.storeApplicationCommands.observeGuildApplications(channel.getId())), ObservableExtensionsKt.computationLatest(this.storeApplicationCommands.observeQueryCommands(channel.getId())), new AnonymousClass1());
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest… TreeSet())\n      }\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableR = ObservableExtensionsKt.computationLatest(observableH).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }
}

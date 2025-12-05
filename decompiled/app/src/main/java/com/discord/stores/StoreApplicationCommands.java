package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import com.discord.api.commands.GuildApplicationCommands;
import com.discord.api.permission.Permission;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandLocalSendData3;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.NonceGenerator;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.CommandAutocompleteState;
import com.discord.stores.DiscoverCommands;
import com.discord.stores.LoadState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t.ReversedViews3;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: StoreApplicationCommands.kt */
/* loaded from: classes2.dex */
public final class StoreApplicationCommands extends StoreV2 {
    public static final int COMMANDS_LIMIT_PER_REQUEST = 20;
    public static final long TYPE_APPLICATION_COMMAND = 2;
    public static final long TYPE_APPLICATION_COMMAND_AUTOCOMPLETE = 4;
    private Map<Long, Integer> applicationCommandIndexes;
    private String applicationNonce;
    private List<Application> applications;
    private Map<Long, Application> applicationsMapSnapshot;
    private List<Application> applicationsSnapshot;
    private Map<String, CommandOptionAutocompleteQuery> autocompleteNonceData;
    private Map<String, Map<String, CommandAutocompleteState>> autocompleteOptionResults;
    private Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> autocompleteOptionResultsSnapshot;
    private final BuiltInCommandsProvider builtInCommandsProvider;
    private boolean connectionReady;
    private int currentEndOffset;
    private int currentStartOffset;
    private Long discoverApplicationId;
    private DiscoverCommands discoverCommands;
    private String discoverCommandsNonce;
    private DiscoverCommands discoverCommandsSnapshot;
    private Long discoverGuildId;
    private final Dispatcher dispatcher;
    private Map<Long, List<ApplicationCommand>> frecencyCommands;
    private Map<Long, ? extends List<? extends ApplicationCommand>> frecencyCommandsSnapshot;
    private Map<String, FrecencyRequest> frecencyRequests;
    private boolean initialApplicationsRequested;
    private boolean isLoadingDiscoveryCommands;
    private Long jumpedApplicationId;
    private int jumpedSequenceId;
    private boolean loadDirectionDown;
    private boolean loadDirectionUp;
    private final NonceGenerator nonceGenerator;
    private int numRemoteCommands;
    private final ObservationDeck observationDeck;
    private User pendingBotUser;
    private Long pendingGatewayGuildId;
    private String query;
    private final List<ApplicationCommand> queryCommands;
    private List<? extends ApplicationCommand> queryCommandsSnapshot;
    private Long queryGuildId;
    private String queryNonce;
    private final RestAPI restApi;
    private String sessionId;
    private final StoreApplicationCommandFrecency storeApplicationCommandFrecency;
    private final StoreExperiments storeExperiments;
    private final StoreGatewayConnection storeGatewayConnection;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUser storeUsers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObservationDeck.UpdateSource DiscoverCommandsUpdate = new StoreApplicationCommands$Companion$DiscoverCommandsUpdate$1();
    private static final ObservationDeck.UpdateSource QueryCommandsUpdate = new StoreApplicationCommands$Companion$QueryCommandsUpdate$1();
    private static final ObservationDeck.UpdateSource GuildApplicationsUpdate = new StoreApplicationCommands$Companion$GuildApplicationsUpdate$1();
    private static final ObservationDeck.UpdateSource AutocompleteResultsUpdate = new StoreApplicationCommands$Companion$AutocompleteResultsUpdate$1();
    private static final ObservationDeck.UpdateSource FrecencyCommandsUpdate = new StoreApplicationCommands$Companion$FrecencyCommandsUpdate$1();

    /* compiled from: StoreApplicationCommands.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ObservationDeck.UpdateSource getAutocompleteResultsUpdate() {
            return StoreApplicationCommands.access$getAutocompleteResultsUpdate$cp();
        }

        public final ObservationDeck.UpdateSource getDiscoverCommandsUpdate() {
            return StoreApplicationCommands.access$getDiscoverCommandsUpdate$cp();
        }

        public final ObservationDeck.UpdateSource getFrecencyCommandsUpdate() {
            return StoreApplicationCommands.access$getFrecencyCommandsUpdate$cp();
        }

        public final ObservationDeck.UpdateSource getGuildApplicationsUpdate() {
            return StoreApplicationCommands.access$getGuildApplicationsUpdate$cp();
        }

        public final ObservationDeck.UpdateSource getQueryCommandsUpdate() {
            return StoreApplicationCommands.access$getQueryCommandsUpdate$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    public static final /* data */ class FrecencyRequest {
        private final List<String> applicationCommandIds;
        private final Long guildId;

        public FrecencyRequest(Long l, List<String> list) {
            Intrinsics3.checkNotNullParameter(list, "applicationCommandIds");
            this.guildId = l;
            this.applicationCommandIds = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FrecencyRequest copy$default(FrecencyRequest frecencyRequest, Long l, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                l = frecencyRequest.guildId;
            }
            if ((i & 2) != 0) {
                list = frecencyRequest.applicationCommandIds;
            }
            return frecencyRequest.copy(l, list);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        public final List<String> component2() {
            return this.applicationCommandIds;
        }

        public final FrecencyRequest copy(Long guildId, List<String> applicationCommandIds) {
            Intrinsics3.checkNotNullParameter(applicationCommandIds, "applicationCommandIds");
            return new FrecencyRequest(guildId, applicationCommandIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FrecencyRequest)) {
                return false;
            }
            FrecencyRequest frecencyRequest = (FrecencyRequest) other;
            return Intrinsics3.areEqual(this.guildId, frecencyRequest.guildId) && Intrinsics3.areEqual(this.applicationCommandIds, frecencyRequest.applicationCommandIds);
        }

        public final List<String> getApplicationCommandIds() {
            return this.applicationCommandIds;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            List<String> list = this.applicationCommandIds;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("FrecencyRequest(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", applicationCommandIds=");
            return outline.m824L(sbM833U, this.applicationCommandIds, ")");
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$clearAutocompleteResults$1 */
    public static final class C57011 extends Lambda implements Function0<Unit> {
        public C57011() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.access$getAutocompleteOptionResults$p(StoreApplicationCommands.this).clear();
            StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getAutocompleteResultsUpdate());
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$clearQueryCommands$1 */
    public static final class C57021 extends Lambda implements Function0<Unit> {
        public C57021() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.access$getQueryCommands$p(StoreApplicationCommands.this).clear();
            StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getQueryCommandsUpdate());
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$getApplicationCommandsViaRest$1 */
    public static final class C57031 extends Lambda implements Function1<List<? extends com.discord.api.commands.ApplicationCommand>, Unit> {
        public final /* synthetic */ long $applicationId;

        /* compiled from: StoreApplicationCommands.kt */
        /* renamed from: com.discord.stores.StoreApplicationCommands$getApplicationCommandsViaRest$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $commands;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$commands = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                List listEmptyList;
                Collection collectionEmptyList;
                Object next;
                boolean z2;
                Object next2;
                com.discord.api.commands.ApplicationCommand applicationCommand;
                StoreApplicationCommands.access$setDiscoverApplicationId$p(StoreApplicationCommands.this, null);
                StoreApplicationCommands.access$setLoadingDiscoveryCommands$p(StoreApplicationCommands.this, false);
                Iterator it = StoreApplicationCommands.access$getApplications$p(StoreApplicationCommands.this).iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (((Application) it.next()).getId() == C57031.this.$applicationId) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    List list = this.$commands;
                    int size = list != null ? list.size() : 0;
                    ArrayList arrayList = new ArrayList(StoreApplicationCommands.access$getApplications$p(StoreApplicationCommands.this));
                    Application application = (Application) arrayList.remove(i);
                    if (size > 0) {
                        List list2 = this.$commands;
                        if (list2 == null || (applicationCommand = (com.discord.api.commands.ApplicationCommand) list2.get(0)) == null) {
                            return;
                        } else {
                            arrayList.add(i, new Application(applicationCommand.getApplicationId(), application.getName(), application.getIcon(), null, size, application.getBot(), application.getBuiltIn(), 8, null));
                        }
                    }
                    StoreApplicationCommands.access$setApplications$p(StoreApplicationCommands.this, arrayList);
                    List list3 = this.$commands;
                    if (list3 != null) {
                        listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(list3, 10));
                        Iterator it2 = list3.iterator();
                        while (it2.hasNext()) {
                            listEmptyList.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it2.next()));
                        }
                    } else {
                        listEmptyList = Collections2.emptyList();
                    }
                    StoreApplicationCommands storeApplicationCommands = StoreApplicationCommands.this;
                    StoreApplicationCommands.access$handleGuildApplicationsUpdate(storeApplicationCommands, _Collections.toList(StoreApplicationCommands.access$getApplications$p(storeApplicationCommands)));
                    List<String> topCommandIds = StoreApplicationCommands.access$getStoreApplicationCommandFrecency$p(StoreApplicationCommands.this).getTopCommandIds(0L);
                    ArrayList<String> arrayList2 = new ArrayList();
                    for (Object obj : topCommandIds) {
                        String str = (String) obj;
                        Integer intOrNull = StringNumberConversions.toIntOrNull(str);
                        if ((intOrNull != null ? intOrNull.intValue() : 0) >= 0) {
                            Iterator it3 = listEmptyList.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    next2 = it3.next();
                                    if (Intrinsics3.areEqual(((ApplicationCommand) next2).getId(), str)) {
                                        break;
                                    }
                                } else {
                                    next2 = null;
                                    break;
                                }
                            }
                            z2 = next2 != null;
                        }
                        if (z2) {
                            arrayList2.add(obj);
                        }
                    }
                    List listPlus = _Collections.plus((Collection) listEmptyList, (Iterable) StoreApplicationCommands.access$getBuiltInCommandsProvider$p(StoreApplicationCommands.this).getBuiltInCommands());
                    Map mapAccess$getFrecencyCommands$p = StoreApplicationCommands.access$getFrecencyCommands$p(StoreApplicationCommands.this);
                    ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
                    for (String str2 : arrayList2) {
                        Iterator it4 = listPlus.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                next = it4.next();
                                if (Intrinsics3.areEqual(((ApplicationCommand) next).getId(), str2)) {
                                    break;
                                }
                            } else {
                                next = null;
                                break;
                            }
                        }
                        arrayList3.add((ApplicationCommand) next);
                    }
                    mapAccess$getFrecencyCommands$p.put(0L, _Collections.filterNotNull(arrayList3));
                    StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getFrecencyCommandsUpdate());
                    StoreApplicationCommands.access$handleDiscoverCommandsUpdate(StoreApplicationCommands.this, listEmptyList);
                    List list4 = this.$commands;
                    if (list4 != null) {
                        collectionEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(list4, 10));
                        Iterator it5 = list4.iterator();
                        while (it5.hasNext()) {
                            collectionEmptyList.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it5.next()));
                        }
                    } else {
                        collectionEmptyList = Collections2.emptyList();
                    }
                    StoreApplicationCommands.access$handleQueryCommandsUpdate(StoreApplicationCommands.this, _Collections.plus(collectionEmptyList, (Iterable) StoreApplicationCommands.access$getBuiltInCommandsProvider$p(StoreApplicationCommands.this).getBuiltInCommands()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57031(long j) {
            super(1);
            this.$applicationId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.commands.ApplicationCommand> list) {
            invoke2((List<com.discord.api.commands.ApplicationCommand>) list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.api.commands.ApplicationCommand> list) {
            StoreApplicationCommands.access$getDispatcher$p(StoreApplicationCommands.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$getApplicationCommandsViaRest$2 */
    public static final class C57042 extends Lambda implements Function1<Error, Unit> {

        /* compiled from: StoreApplicationCommands.kt */
        /* renamed from: com.discord.stores.StoreApplicationCommands$getApplicationCommandsViaRest$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreApplicationCommands.access$setLoadingDiscoveryCommands$p(StoreApplicationCommands.this, false);
            }
        }

        public C57042() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreApplicationCommands.access$getDispatcher$p(StoreApplicationCommands.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$handleDmUserApplication$1 */
    public static final class C57061 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ User $botUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57061(User user) {
            super(0);
            this.$botUser = user;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.access$getFrecencyCommands$p(StoreApplicationCommands.this).put(0L, Collections2.emptyList());
            StoreApplicationCommands.access$setPendingGatewayGuildId$p(StoreApplicationCommands.this, null);
            StoreApplicationCommands.access$setApplications$p(StoreApplicationCommands.this, Collections2.emptyList());
            StoreApplicationCommands.access$getApplicationCommandIndexes$p(StoreApplicationCommands.this).clear();
            StoreApplicationCommands storeApplicationCommands = StoreApplicationCommands.this;
            StoreApplicationCommands.access$handleGuildApplicationsUpdate(storeApplicationCommands, Collections2.listOf((Object[]) new Application[]{StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands).getFrecencyApplication(), new Application(this.$botUser.getId(), this.$botUser.getUsername(), null, null, 0, UserUtils.INSTANCE.synthesizeApiUser(this.$botUser), false, 8, null), StoreApplicationCommands.access$getBuiltInCommandsProvider$p(StoreApplicationCommands.this).getBuiltInApplication()}));
            StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getFrecencyCommandsUpdate());
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$observeAutocompleteResults$1 */
    public static final class C57071 extends Lambda implements Function0<Map<String, ? extends Map<String, ? extends CommandAutocompleteState>>> {
        public C57071() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> invoke2() {
            return StoreApplicationCommands.this.getAutocompleteOptionResults();
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$observeDiscoverCommands$1 */
    public static final class C57081 extends Lambda implements Function0<DiscoverCommands> {
        public C57081() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ DiscoverCommands invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DiscoverCommands invoke() {
            return StoreApplicationCommands.this.getDiscoverCommandsSnapshot();
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$observeDiscoverCommands$2 */
    public static final class C57092<T1, T2, R> implements Func2<DiscoverCommands, Long, DiscoverCommands> {
        public C57092() {
        }

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ DiscoverCommands call(DiscoverCommands discoverCommands, Long l) {
            return call2(discoverCommands, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final DiscoverCommands call2(DiscoverCommands discoverCommands, Long l) {
            if (StoreApplicationCommands.access$shouldReturnApplicationCommands(StoreApplicationCommands.this, l)) {
                return discoverCommands;
            }
            List<ApplicationCommand> builtInCommands = StoreApplicationCommands.access$getBuiltInCommandsProvider$p(StoreApplicationCommands.this).getBuiltInCommands();
            return new DiscoverCommands(builtInCommands, 0, builtInCommands.size(), false, false, 0, null, null, 128, null);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$observeFrecencyCommands$1 */
    public static final class C57101 extends Lambda implements Function0<List<? extends ApplicationCommand>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57101(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ApplicationCommand> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ApplicationCommand> invoke2() {
            Experiment userExperiment = StoreApplicationCommands.access$getStoreExperiments$p(StoreApplicationCommands.this).getUserExperiment("2021-09_android_app_commands_frecency", false);
            return (userExperiment == null || userExperiment.getBucket() != 1) ? Collections2.emptyList() : _Collections.take(StoreApplicationCommands.this.getFrecencyCommands(this.$guildId), 5);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$observeGuildApplications$1 */
    public static final class C57111 extends Lambda implements Function0<List<? extends Application>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57111(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Application> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Application> invoke2() {
            if (StoreApplicationCommands.access$shouldReturnApplicationCommands(StoreApplicationCommands.this, StoreApplicationCommands.access$getStorePermissions$p(StoreApplicationCommands.this).getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return StoreApplicationCommands.this.getApplications();
            }
            List<Application> applications = StoreApplicationCommands.this.getApplications();
            ArrayList arrayList = new ArrayList();
            for (Object obj : applications) {
                if (((Application) obj).getBuiltIn()) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$observeQueryCommands$1 */
    public static final class C57121 extends Lambda implements Function0<List<? extends ApplicationCommand>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57121(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ApplicationCommand> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ApplicationCommand> invoke2() {
            if (StoreApplicationCommands.access$shouldReturnApplicationCommands(StoreApplicationCommands.this, StoreApplicationCommands.access$getStorePermissions$p(StoreApplicationCommands.this).getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return StoreApplicationCommands.this.getQueryCommands();
            }
            List<ApplicationCommand> queryCommands = StoreApplicationCommands.this.getQueryCommands();
            ArrayList arrayList = new ArrayList();
            for (Object obj : queryCommands) {
                if (((ApplicationCommand) obj).getBuiltIn()) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1 */
    public static final class C57131 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ ApplicationCommandData $data;
        public final /* synthetic */ Long $guildId;

        /* compiled from: StoreApplicationCommands.kt */
        /* renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ ApplicationCommandValue $option;

            /* compiled from: StoreApplicationCommands.kt */
            /* renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132481 extends Lambda implements Function0<Unit> {
                public C132481() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreApplicationCommands.this.setAutocompleteFailed(anonymousClass1.$option.getName(), String.valueOf(AnonymousClass1.this.$option.getValue()));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ApplicationCommandValue applicationCommandValue) {
                super(1);
                this.$option = applicationCommandValue;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreApplicationCommands.access$getDispatcher$p(StoreApplicationCommands.this).schedule(new C132481());
            }
        }

        /* compiled from: StoreApplicationCommands.kt */
        /* renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57131(ApplicationCommandData applicationCommandData, long j, Long l) {
            super(0);
            this.$data = applicationCommandData;
            this.$channelId = j;
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Object next;
            String strAccess$generateNonce = StoreApplicationCommands.access$generateNonce(StoreApplicationCommands.this);
            String version = this.$data.getApplicationCommand().getVersion();
            Long guildId = this.$data.getApplicationCommand().getGuildId();
            com.discord.api.commands.ApplicationCommandData applicationCommandData = new com.discord.api.commands.ApplicationCommandData(version, guildId != null ? String.valueOf(guildId.longValue()) : null, this.$data.getApplicationCommand().getId(), this.$data.getApplicationCommand().getName(), ApplicationCommandLocalSendData3.toRestParams(this.$data.getValues(), C5714xda384e10.INSTANCE), null);
            String strValueOf = String.valueOf(this.$channelId);
            String strValueOf2 = String.valueOf(this.$data.getApplication().getId());
            Long l = this.$guildId;
            RestAPIParams.ApplicationCommand applicationCommand = new RestAPIParams.ApplicationCommand(4L, strValueOf, strValueOf2, l != null ? String.valueOf(l.longValue()) : null, applicationCommandData, StoreApplicationCommands.access$getSessionId$p(StoreApplicationCommands.this), strAccess$generateNonce);
            Iterator<T> it = StoreApplicationCommandsKt.flatten(this.$data.getValues()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics3.areEqual(((ApplicationCommandValue) next).getFocused(), Boolean.TRUE)) {
                        break;
                    }
                }
            }
            ApplicationCommandValue applicationCommandValue = (ApplicationCommandValue) next;
            if (applicationCommandValue != null) {
                StoreApplicationCommands.access$getAutocompleteNonceData$p(StoreApplicationCommands.this).put(strAccess$generateNonce, new CommandOptionAutocompleteQuery(String.valueOf(applicationCommandValue.getValue()), applicationCommandValue.getName()));
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationCommands.access$getRestApi$p(StoreApplicationCommands.this).sendApplicationCommand(applicationCommand), false, 1, null), StoreApplicationCommands.this.getClass(), (Context) null, (Function1) null, new AnonymousClass1(applicationCommandValue), (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 54, (Object) null);
            }
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommands$1 */
    public static final class C57151 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $applicationId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ int $limit;
        public final /* synthetic */ int $offset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57151(Long l, int i, int i2, Long l2) {
            super(0);
            this.$guildId = l;
            this.$offset = i;
            this.$limit = i2;
            this.$applicationId = l2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreApplicationCommands.access$isLoadingDiscoveryCommands$p(StoreApplicationCommands.this)) {
                return;
            }
            String strAccess$generateNonce = StoreApplicationCommands.access$generateNonce(StoreApplicationCommands.this);
            StoreApplicationCommands.access$setDiscoverCommandsNonce$p(StoreApplicationCommands.this, strAccess$generateNonce);
            LoadState loadState = (StoreApplicationCommands.access$getLoadDirectionDown$p(StoreApplicationCommands.this) || StoreApplicationCommands.access$getLoadDirectionUp$p(StoreApplicationCommands.this)) ? StoreApplicationCommands.access$getDiscoverCommands$p(StoreApplicationCommands.this).getLoadState() : LoadState.Loading.INSTANCE;
            if (!Intrinsics3.areEqual(StoreApplicationCommands.access$getDiscoverGuildId$p(StoreApplicationCommands.this), this.$guildId)) {
                StoreApplicationCommands storeApplicationCommands = StoreApplicationCommands.this;
                StoreApplicationCommands.access$setDiscoverCommands$p(storeApplicationCommands, DiscoverCommands.copy$default(StoreApplicationCommands.access$getDiscoverCommands$p(storeApplicationCommands), Collections2.emptyList(), 0, 0, false, false, 0, null, loadState, 126, null));
                StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getDiscoverCommandsUpdate());
            } else {
                StoreApplicationCommands storeApplicationCommands2 = StoreApplicationCommands.this;
                StoreApplicationCommands.access$setDiscoverCommands$p(storeApplicationCommands2, DiscoverCommands.copy$default(StoreApplicationCommands.access$getDiscoverCommands$p(storeApplicationCommands2), null, 0, 0, false, false, 0, null, loadState, Opcodes.LAND, null));
                StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getDiscoverCommandsUpdate());
            }
            StoreApplicationCommands.access$setDiscoverGuildId$p(StoreApplicationCommands.this, this.$guildId);
            Long l = this.$guildId;
            if (l == null || l.longValue() <= 0) {
                if (this.$applicationId == null) {
                    StoreApplicationCommands storeApplicationCommands3 = StoreApplicationCommands.this;
                    StoreApplicationCommands.access$handleDiscoverCommandsUpdate(storeApplicationCommands3, StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands3).getBuiltInCommands());
                } else if (!Intrinsics3.areEqual(r1, StoreApplicationCommands.access$getDiscoverApplicationId$p(StoreApplicationCommands.this))) {
                    StoreApplicationCommands.access$setLoadingDiscoveryCommands$p(StoreApplicationCommands.this, true);
                    StoreApplicationCommands.access$getApplicationCommandsViaRest(StoreApplicationCommands.this, this.$applicationId.longValue());
                }
            } else {
                boolean zRequestApplicationCommands$default = StoreGatewayConnection.requestApplicationCommands$default(StoreApplicationCommands.access$getStoreGatewayConnection$p(StoreApplicationCommands.this), this.$guildId.longValue(), strAccess$generateNonce, false, null, Integer.valueOf(this.$offset), this.$limit, null, 72, null);
                StoreApplicationCommands.access$setLoadingDiscoveryCommands$p(StoreApplicationCommands.this, zRequestApplicationCommands$default);
                if (!zRequestApplicationCommands$default) {
                    StoreApplicationCommands storeApplicationCommands4 = StoreApplicationCommands.this;
                    StoreApplicationCommands.access$handleDiscoverCommandsUpdate(storeApplicationCommands4, StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands4).getBuiltInCommands());
                }
            }
            StoreApplicationCommands.access$setDiscoverApplicationId$p(StoreApplicationCommands.this, this.$applicationId);
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandsQuery$1 */
    public static final class C57161 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57161(Long l, String str) {
            super(0);
            this.$guildId = l;
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String strAccess$generateNonce = StoreApplicationCommands.access$generateNonce(StoreApplicationCommands.this);
            StoreApplicationCommands.access$setQueryNonce$p(StoreApplicationCommands.this, strAccess$generateNonce);
            if (!Intrinsics3.areEqual(StoreApplicationCommands.access$getQueryGuildId$p(StoreApplicationCommands.this), this.$guildId)) {
                StoreApplicationCommands.access$getQueryCommands$p(StoreApplicationCommands.this).clear();
                StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getQueryCommandsUpdate());
            }
            StoreApplicationCommands.access$setQueryGuildId$p(StoreApplicationCommands.this, this.$guildId);
            StoreApplicationCommands.access$setQuery$p(StoreApplicationCommands.this, this.$query);
            Long l = this.$guildId;
            if (l == null || l.longValue() <= 0) {
                StoreApplicationCommands.access$handleQueryCommandsUpdate(StoreApplicationCommands.this, Collections2.emptyList());
            } else {
                StoreGatewayConnection.requestApplicationCommands$default(StoreApplicationCommands.access$getStoreGatewayConnection$p(StoreApplicationCommands.this), this.$guildId.longValue(), strAccess$generateNonce, false, this.$query, null, 20, null, 80, null);
            }
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$requestApplications$1 */
    public static final class C57171 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57171(Long l) {
            super(0);
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String strAccess$generateNonce = StoreApplicationCommands.access$generateNonce(StoreApplicationCommands.this);
            StoreApplicationCommands.access$setApplicationNonce$p(StoreApplicationCommands.this, strAccess$generateNonce);
            StoreApplicationCommands.access$setApplications$p(StoreApplicationCommands.this, Collections2.emptyList());
            StoreApplicationCommands.access$getApplicationCommandIndexes$p(StoreApplicationCommands.this).clear();
            StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getGuildApplicationsUpdate());
            Long l = this.$guildId;
            if (l != null && l.longValue() > 0) {
                StoreGatewayConnection.requestApplicationCommands$default(StoreApplicationCommands.access$getStoreGatewayConnection$p(StoreApplicationCommands.this), this.$guildId.longValue(), strAccess$generateNonce, true, null, null, 0, null, 88, null);
            } else {
                StoreApplicationCommands storeApplicationCommands = StoreApplicationCommands.this;
                StoreApplicationCommands.access$handleGuildApplicationsUpdate(storeApplicationCommands, Collections2.listOf((Object[]) new Application[]{StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands).getFrecencyApplication(), StoreApplicationCommands.access$getBuiltInCommandsProvider$p(StoreApplicationCommands.this).getBuiltInApplication()}));
            }
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$requestFrecencyCommands$1 */
    public static final class C57181 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $nonce;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57181(String str) {
            super(0);
            this.$nonce = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.access$handleFrecencyCommandsUpdate(StoreApplicationCommands.this, this.$nonce, Collections2.emptyList());
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.StoreApplicationCommands$requestFrecencyCommands$2 */
    public static final class C57192 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $nonce;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57192(String str) {
            super(0);
            this.$nonce = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.access$handleFrecencyCommandsUpdate(StoreApplicationCommands.this, this.$nonce, Collections2.emptyList());
        }
    }

    public /* synthetic */ StoreApplicationCommands(StoreGatewayConnection storeGatewayConnection, StorePermissions storePermissions, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreGuilds storeGuilds, StoreUser storeUser, StoreExperiments storeExperiments, Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, BuiltInCommandsProvider builtInCommandsProvider, NonceGenerator nonceGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeGatewayConnection, storePermissions, storeApplicationCommandFrecency, storeGuilds, storeUser, storeExperiments, dispatcher, (i & 128) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 256) != 0 ? ObservationDeck4.get() : observationDeck, (i & 512) != 0 ? new BuiltInCommands() : builtInCommandsProvider, (i & 1024) != 0 ? new NonceGenerator() : nonceGenerator);
    }

    public static final /* synthetic */ String access$generateNonce(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.generateNonce();
    }

    public static final /* synthetic */ Map access$getApplicationCommandIndexes$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.applicationCommandIndexes;
    }

    public static final /* synthetic */ void access$getApplicationCommandsViaRest(StoreApplicationCommands storeApplicationCommands, long j) {
        storeApplicationCommands.getApplicationCommandsViaRest(j);
    }

    public static final /* synthetic */ String access$getApplicationNonce$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.applicationNonce;
    }

    public static final /* synthetic */ List access$getApplications$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.applications;
    }

    public static final /* synthetic */ Map access$getAutocompleteNonceData$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.autocompleteNonceData;
    }

    public static final /* synthetic */ Map access$getAutocompleteOptionResults$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.autocompleteOptionResults;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getAutocompleteResultsUpdate$cp() {
        return AutocompleteResultsUpdate;
    }

    public static final /* synthetic */ BuiltInCommandsProvider access$getBuiltInCommandsProvider$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.builtInCommandsProvider;
    }

    public static final /* synthetic */ Long access$getDiscoverApplicationId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.discoverApplicationId;
    }

    public static final /* synthetic */ DiscoverCommands access$getDiscoverCommands$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.discoverCommands;
    }

    public static final /* synthetic */ String access$getDiscoverCommandsNonce$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.discoverCommandsNonce;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getDiscoverCommandsUpdate$cp() {
        return DiscoverCommandsUpdate;
    }

    public static final /* synthetic */ Long access$getDiscoverGuildId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.discoverGuildId;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.dispatcher;
    }

    public static final /* synthetic */ Map access$getFrecencyCommands$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.frecencyCommands;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getFrecencyCommandsUpdate$cp() {
        return FrecencyCommandsUpdate;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getGuildApplicationsUpdate$cp() {
        return GuildApplicationsUpdate;
    }

    public static final /* synthetic */ boolean access$getLoadDirectionDown$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.loadDirectionDown;
    }

    public static final /* synthetic */ boolean access$getLoadDirectionUp$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.loadDirectionUp;
    }

    public static final /* synthetic */ Long access$getPendingGatewayGuildId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.pendingGatewayGuildId;
    }

    public static final /* synthetic */ String access$getQuery$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.query;
    }

    public static final /* synthetic */ List access$getQueryCommands$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.queryCommands;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getQueryCommandsUpdate$cp() {
        return QueryCommandsUpdate;
    }

    public static final /* synthetic */ Long access$getQueryGuildId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.queryGuildId;
    }

    public static final /* synthetic */ String access$getQueryNonce$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.queryNonce;
    }

    public static final /* synthetic */ RestAPI access$getRestApi$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.restApi;
    }

    public static final /* synthetic */ String access$getSessionId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.sessionId;
    }

    public static final /* synthetic */ StoreApplicationCommandFrecency access$getStoreApplicationCommandFrecency$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.storeApplicationCommandFrecency;
    }

    public static final /* synthetic */ StoreExperiments access$getStoreExperiments$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.storeExperiments;
    }

    public static final /* synthetic */ StoreGatewayConnection access$getStoreGatewayConnection$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.storeGatewayConnection;
    }

    public static final /* synthetic */ StorePermissions access$getStorePermissions$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.storePermissions;
    }

    public static final /* synthetic */ void access$handleDiscoverCommandsUpdate(StoreApplicationCommands storeApplicationCommands, List list) {
        storeApplicationCommands.handleDiscoverCommandsUpdate(list);
    }

    public static final /* synthetic */ void access$handleFrecencyCommandsUpdate(StoreApplicationCommands storeApplicationCommands, String str, List list) {
        storeApplicationCommands.handleFrecencyCommandsUpdate(str, list);
    }

    public static final /* synthetic */ void access$handleGuildApplicationsUpdate(StoreApplicationCommands storeApplicationCommands, List list) {
        storeApplicationCommands.handleGuildApplicationsUpdate(list);
    }

    public static final /* synthetic */ void access$handleQueryCommandsUpdate(StoreApplicationCommands storeApplicationCommands, List list) {
        storeApplicationCommands.handleQueryCommandsUpdate(list);
    }

    public static final /* synthetic */ boolean access$isLoadingDiscoveryCommands$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.isLoadingDiscoveryCommands;
    }

    public static final /* synthetic */ void access$setApplicationCommandIndexes$p(StoreApplicationCommands storeApplicationCommands, Map map) {
        storeApplicationCommands.applicationCommandIndexes = map;
    }

    public static final /* synthetic */ void access$setApplicationNonce$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.applicationNonce = str;
    }

    public static final /* synthetic */ void access$setApplications$p(StoreApplicationCommands storeApplicationCommands, List list) {
        storeApplicationCommands.applications = list;
    }

    public static final /* synthetic */ void access$setAutocompleteNonceData$p(StoreApplicationCommands storeApplicationCommands, Map map) {
        storeApplicationCommands.autocompleteNonceData = map;
    }

    public static final /* synthetic */ void access$setAutocompleteOptionResults$p(StoreApplicationCommands storeApplicationCommands, Map map) {
        storeApplicationCommands.autocompleteOptionResults = map;
    }

    public static final /* synthetic */ void access$setDiscoverApplicationId$p(StoreApplicationCommands storeApplicationCommands, Long l) {
        storeApplicationCommands.discoverApplicationId = l;
    }

    public static final /* synthetic */ void access$setDiscoverCommands$p(StoreApplicationCommands storeApplicationCommands, DiscoverCommands discoverCommands) {
        storeApplicationCommands.discoverCommands = discoverCommands;
    }

    public static final /* synthetic */ void access$setDiscoverCommandsNonce$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.discoverCommandsNonce = str;
    }

    public static final /* synthetic */ void access$setDiscoverGuildId$p(StoreApplicationCommands storeApplicationCommands, Long l) {
        storeApplicationCommands.discoverGuildId = l;
    }

    public static final /* synthetic */ void access$setFrecencyCommands$p(StoreApplicationCommands storeApplicationCommands, Map map) {
        storeApplicationCommands.frecencyCommands = map;
    }

    public static final /* synthetic */ void access$setLoadDirectionDown$p(StoreApplicationCommands storeApplicationCommands, boolean z2) {
        storeApplicationCommands.loadDirectionDown = z2;
    }

    public static final /* synthetic */ void access$setLoadDirectionUp$p(StoreApplicationCommands storeApplicationCommands, boolean z2) {
        storeApplicationCommands.loadDirectionUp = z2;
    }

    public static final /* synthetic */ void access$setLoadingDiscoveryCommands$p(StoreApplicationCommands storeApplicationCommands, boolean z2) {
        storeApplicationCommands.isLoadingDiscoveryCommands = z2;
    }

    public static final /* synthetic */ void access$setPendingGatewayGuildId$p(StoreApplicationCommands storeApplicationCommands, Long l) {
        storeApplicationCommands.pendingGatewayGuildId = l;
    }

    public static final /* synthetic */ void access$setQuery$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.query = str;
    }

    public static final /* synthetic */ void access$setQueryGuildId$p(StoreApplicationCommands storeApplicationCommands, Long l) {
        storeApplicationCommands.queryGuildId = l;
    }

    public static final /* synthetic */ void access$setQueryNonce$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.queryNonce = str;
    }

    public static final /* synthetic */ void access$setSessionId$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.sessionId = str;
    }

    public static final /* synthetic */ boolean access$shouldReturnApplicationCommands(StoreApplicationCommands storeApplicationCommands, Long l) {
        return storeApplicationCommands.shouldReturnApplicationCommands(l);
    }

    @Store3
    private final String generateNonce() {
        return String.valueOf(this.nonceGenerator.nonce());
    }

    private final void getApplicationCommandsViaRest(long applicationId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getApplicationCommands(applicationId), false, 1, null), StoreApplicationCommands.class, (Context) null, (Function1) null, new C57042(), (Function0) null, (Function0) null, new C57031(applicationId), 54, (Object) null);
    }

    @Store3
    private final void handleDiscoverCommandsUpdate(List<? extends ApplicationCommand> commands) {
        this.isLoadingDiscoveryCommands = false;
        List mutableList = _Collections.toMutableList((Collection) this.discoverCommands.getCommands());
        int size = mutableList.size();
        Long l = this.jumpedApplicationId;
        if (l != null) {
            mutableList = _Collections.toMutableList((Collection) commands);
            Integer num = this.applicationCommandIndexes.get(l);
            this.currentStartOffset = num != null ? num.intValue() : 0;
        } else if (this.loadDirectionUp) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : commands) {
                ApplicationCommand applicationCommand = (ApplicationCommand) obj;
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(mutableList, 10));
                Iterator it = mutableList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((ApplicationCommand) it.next()).getId());
                }
                if (!arrayList2.contains(applicationCommand.getId())) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = ReversedViews3.asReversed(arrayList).iterator();
            while (it2.hasNext()) {
                mutableList.add(0, (ApplicationCommand) it2.next());
            }
            this.currentStartOffset -= mutableList.size() - size;
        } else if (this.loadDirectionDown) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : commands) {
                ApplicationCommand applicationCommand2 = (ApplicationCommand) obj2;
                ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(mutableList, 10));
                Iterator it3 = mutableList.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(((ApplicationCommand) it3.next()).getId());
                }
                if (!arrayList4.contains(applicationCommand2.getId())) {
                    arrayList3.add(obj2);
                }
            }
            mutableList = _Collections.toMutableList((Collection) _Collections.plus((Collection) mutableList, (Iterable) arrayList3));
        } else {
            mutableList = _Collections.toMutableList((Collection) commands);
            this.currentStartOffset = 0;
        }
        List list = mutableList;
        if ((list.size() + this.currentStartOffset) - 1 == this.numRemoteCommands - 1) {
            list.addAll(this.builtInCommandsProvider.getBuiltInCommands());
        }
        this.currentEndOffset = (list.size() + this.currentStartOffset) - 1;
        this.discoverCommands = new DiscoverCommands(list, this.currentStartOffset, this.currentEndOffset, this.currentStartOffset > 0 && (list.isEmpty() ^ true), this.currentEndOffset < this.numRemoteCommands - 1, this.jumpedSequenceId, this.jumpedApplicationId, this.loadDirectionUp ? LoadState.JustLoadedUp.INSTANCE : this.loadDirectionDown ? LoadState.JustLoadedDown.INSTANCE : LoadState.JustLoadedAll.INSTANCE);
        markChanged(DiscoverCommandsUpdate);
    }

    @Store3
    private final void handleFrecencyCommandsUpdate(String nonce, List<? extends ApplicationCommand> commands) {
        int iIntValue;
        FrecencyRequest frecencyRequest = this.frecencyRequests.get(nonce);
        if (frecencyRequest != null) {
            this.frecencyRequests.remove(nonce);
            List<ApplicationCommand> listFlattenSubCommands = StoreApplicationCommandsKt.flattenSubCommands(commands);
            Map<Long, List<ApplicationCommand>> map = this.frecencyCommands;
            Long guildId = frecencyRequest.getGuildId();
            Long lValueOf = Long.valueOf(guildId != null ? guildId.longValue() : 0L);
            List<String> applicationCommandIds = frecencyRequest.getApplicationCommandIds();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(applicationCommandIds, 10));
            for (String str : applicationCommandIds) {
                Integer intOrNull = StringNumberConversions.toIntOrNull(str);
                Object obj = null;
                if (intOrNull == null || (iIntValue = intOrNull.intValue()) >= 0) {
                    Iterator<T> it = listFlattenSubCommands.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (Intrinsics3.areEqual(((ApplicationCommand) next).getId(), str)) {
                                obj = next;
                                break;
                            }
                        }
                    }
                } else {
                    Iterator<T> it2 = this.builtInCommandsProvider.getBuiltInCommands().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object next2 = it2.next();
                            Integer intOrNull2 = StringNumberConversions.toIntOrNull(((ApplicationCommand) next2).getId());
                            if (intOrNull2 != null && intOrNull2.intValue() == iIntValue) {
                                obj = next2;
                                break;
                            }
                        }
                    }
                }
                arrayList.add((ApplicationCommand) obj);
            }
            map.put(lValueOf, _Collections.filterNotNull(arrayList));
            markChanged(FrecencyCommandsUpdate);
        }
    }

    @Store3
    private final void handleGuildApplicationsUpdate(List<Application> commands) {
        this.applications = commands;
        this.numRemoteCommands = 0;
        int commandCount = 0;
        for (Application application : commands) {
            this.applicationCommandIndexes.put(Long.valueOf(application.getId()), Integer.valueOf(commandCount));
            commandCount += application.getCommandCount();
            if (!application.getBuiltIn()) {
                this.numRemoteCommands = application.getCommandCount() + this.numRemoteCommands;
            }
        }
        markChanged(GuildApplicationsUpdate);
    }

    @Store3
    private final void handleQueryCommandsUpdate(List<? extends ApplicationCommand> commands) {
        this.queryCommands.clear();
        this.queryCommands.addAll(commands);
        String str = this.query;
        if (str != null) {
            List<ApplicationCommand> list = this.queryCommands;
            List<ApplicationCommand> builtInCommands = this.builtInCommandsProvider.getBuiltInCommands();
            ArrayList arrayList = new ArrayList();
            for (Object obj : builtInCommands) {
                if (StringsJVM.startsWith(((ApplicationCommand) obj).getName(), str, true)) {
                    arrayList.add(obj);
                }
            }
            list.addAll(arrayList);
        }
        markChanged(QueryCommandsUpdate);
    }

    private final void requestApplicationCommands(Long guildId, int offset, Long applicationId, int limit) {
        this.dispatcher.schedule(new C57151(guildId, offset, limit, applicationId));
    }

    public static /* synthetic */ void requestApplicationCommands$default(StoreApplicationCommands storeApplicationCommands, Long l, int i, Long l2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            l2 = null;
        }
        if ((i3 & 8) != 0) {
            i2 = 20;
        }
        storeApplicationCommands.requestApplicationCommands(l, i, l2, i2);
    }

    public static /* synthetic */ void requestInitialApplicationCommands$default(StoreApplicationCommands storeApplicationCommands, Long l, Long l2, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeApplicationCommands.requestInitialApplicationCommands(l, l2, z2);
    }

    @Store3
    private final void setAutocompleteState(String commandOptionName, String queryString, CommandAutocompleteState state) {
        Map<String, CommandAutocompleteState> mapEmptyMap = this.autocompleteOptionResults.get(commandOptionName);
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        if (mapEmptyMap.get(queryString) instanceof CommandAutocompleteState.Choices) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, CommandAutocompleteState> mapEmptyMap2 = this.autocompleteOptionResults.get(commandOptionName);
        if (mapEmptyMap2 == null) {
            mapEmptyMap2 = Maps6.emptyMap();
        }
        linkedHashMap.putAll(mapEmptyMap2);
        linkedHashMap.put(queryString, state);
        this.autocompleteOptionResults.put(commandOptionName, linkedHashMap);
        markChanged(AutocompleteResultsUpdate);
    }

    private final boolean shouldReturnApplicationCommands(Long channelPermissions) {
        Long l = this.discoverGuildId;
        return l == null || (l != null && l.longValue() == 0) || PermissionUtils.can(Permission.USE_APPLICATION_COMMANDS, channelPermissions);
    }

    public final void clearAutocompleteResults() {
        this.dispatcher.schedule(new C57011());
    }

    public final void clearQueryCommands() {
        this.dispatcher.schedule(new C57021());
    }

    public final Map<Long, Application> getApplicationMap() {
        return this.applicationsMapSnapshot;
    }

    public final List<Application> getApplications() {
        return this.applicationsSnapshot;
    }

    public final Map<String, Map<String, CommandAutocompleteState>> getAutocompleteOptionResults() {
        return this.autocompleteOptionResultsSnapshot;
    }

    /* renamed from: getDiscoverCommands, reason: from getter */
    public final DiscoverCommands getDiscoverCommandsSnapshot() {
        return this.discoverCommandsSnapshot;
    }

    public final List<ApplicationCommand> getFrecencyCommands(long guildId) {
        List<ApplicationCommand> list = (List) this.frecencyCommandsSnapshot.get(Long.valueOf(guildId));
        return list != null ? list : Collections2.emptyList();
    }

    public final List<ApplicationCommand> getQueryCommands() {
        return this.queryCommandsSnapshot;
    }

    @Store3
    public final void handleApplicationCommandAutocompleteResult(ApplicationCommandAutocompleteResult autocompleteResult) {
        Intrinsics3.checkNotNullParameter(autocompleteResult, "autocompleteResult");
        CommandOptionAutocompleteQuery commandOptionAutocompleteQuery = this.autocompleteNonceData.get(autocompleteResult.getNonce());
        if (commandOptionAutocompleteQuery != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, CommandAutocompleteState> mapEmptyMap = this.autocompleteOptionResults.get(commandOptionAutocompleteQuery.getCommandOptionName());
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            linkedHashMap.putAll(mapEmptyMap);
            linkedHashMap.put(commandOptionAutocompleteQuery.getQueryString(), new CommandAutocompleteState.Choices(autocompleteResult.m7722a()));
            this.autocompleteOptionResults.put(commandOptionAutocompleteQuery.getCommandOptionName(), linkedHashMap);
            markChanged(AutocompleteResultsUpdate);
        }
    }

    @Store3
    public final void handleApplicationCommandsUpdate(GuildApplicationCommands commandsGateway) {
        Intrinsics3.checkNotNullParameter(commandsGateway, "commandsGateway");
        if (this.frecencyRequests.containsKey(commandsGateway.getNonce())) {
            String nonce = commandsGateway.getNonce();
            List<com.discord.api.commands.ApplicationCommand> listM7746a = commandsGateway.m7746a();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listM7746a, 10));
            Iterator<T> it = listM7746a.iterator();
            while (it.hasNext()) {
                arrayList.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it.next()));
            }
            handleFrecencyCommandsUpdate(nonce, arrayList);
            return;
        }
        String nonce2 = commandsGateway.getNonce();
        if (Intrinsics3.areEqual(nonce2, this.applicationNonce)) {
            List listListOf = CollectionsJVM.listOf(this.builtInCommandsProvider.getFrecencyApplication());
            List<com.discord.api.commands.Application> listM7747b = commandsGateway.m7747b();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listM7747b, 10));
            Iterator<T> it2 = listM7747b.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StoreApplicationCommandsKt.toDomainApplication((com.discord.api.commands.Application) it2.next()));
            }
            handleGuildApplicationsUpdate(_Collections.plus((Collection<? extends Application>) _Collections.plus((Collection) listListOf, (Iterable) _Collections.sortedWith(arrayList2, new C5705x3d14edc6())), this.builtInCommandsProvider.getBuiltInApplication()));
            return;
        }
        if (Intrinsics3.areEqual(nonce2, this.queryNonce)) {
            List<com.discord.api.commands.ApplicationCommand> listM7746a2 = commandsGateway.m7746a();
            ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listM7746a2, 10));
            Iterator<T> it3 = listM7746a2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it3.next()));
            }
            handleQueryCommandsUpdate(arrayList3);
            return;
        }
        if (Intrinsics3.areEqual(nonce2, this.discoverCommandsNonce)) {
            List<com.discord.api.commands.ApplicationCommand> listM7746a3 = commandsGateway.m7746a();
            ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(listM7746a3, 10));
            Iterator<T> it4 = listM7746a3.iterator();
            while (it4.hasNext()) {
                arrayList4.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it4.next()));
            }
            handleDiscoverCommandsUpdate(arrayList4);
        }
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
    }

    public final void handleConnectionReady(boolean connectionReady) {
        this.connectionReady = connectionReady;
        if (!connectionReady || this.initialApplicationsRequested) {
            return;
        }
        Long l = this.pendingGatewayGuildId;
        requestFrecencyCommands(l != null ? l.longValue() : 0L);
        Long l2 = this.pendingGatewayGuildId;
        if (l2 != null) {
            requestApplications(l2);
        }
        User user = this.pendingBotUser;
        if (user != null) {
            handleDmUserApplication(user);
        }
        if (this.pendingGatewayGuildId == null && this.pendingBotUser == null) {
            requestApplications(null);
        }
        this.initialApplicationsRequested = true;
        this.pendingGatewayGuildId = null;
        this.pendingBotUser = null;
    }

    public final void handleDmUserApplication(User botUser) {
        Intrinsics3.checkNotNullParameter(botUser, "botUser");
        if (botUser.getIsBot()) {
            if (this.connectionReady) {
                this.dispatcher.schedule(new C57061(botUser));
            } else {
                this.pendingBotUser = botUser;
            }
        }
    }

    public final boolean hasFetchedApplicationCommands(long applicationId) {
        Integer num = this.applicationCommandIndexes.get(Long.valueOf(applicationId));
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        return this.currentStartOffset <= iIntValue && this.currentEndOffset >= iIntValue;
    }

    public final Observable<Map<String, Map<String, CommandAutocompleteState>>> observeAutocompleteResults() {
        Observable<Map<String, Map<String, CommandAutocompleteState>>> observableM11094T = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{AutocompleteResultsUpdate}, false, null, null, new C57071(), 14, null).m11094T(Maps6.emptyMap());
        Intrinsics3.checkNotNullExpressionValue(observableM11094T, "observationDeck.connectR…  }.startWith(emptyMap())");
        return observableM11094T;
    }

    public final Observable<DiscoverCommands> observeDiscoverCommands(long channelId) {
        Observable<DiscoverCommands> observableM11076j = Observable.m11076j(ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{DiscoverCommandsUpdate}, false, null, null, new C57081(), 14, null).m11112r(), this.storePermissions.observePermissionsForChannel(channelId), new C57092());
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…  )\n          }\n        }");
        return observableM11076j;
    }

    public final Observable<List<ApplicationCommand>> observeFrecencyCommands(long guildId) {
        Observable<List<ApplicationCommand>> observableM11094T = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{FrecencyCommandsUpdate, this.storeExperiments}, false, null, null, new C57101(guildId), 14, null).m11094T(Collections2.emptyList());
        Intrinsics3.checkNotNullExpressionValue(observableM11094T, "observationDeck.connectR…st<ApplicationCommand>())");
        return observableM11094T;
    }

    public final Observable<List<Application>> observeGuildApplications(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildApplicationsUpdate, this.storePermissions}, false, null, null, new C57111(channelId), 14, null);
    }

    public final Observable<List<ApplicationCommand>> observeQueryCommands(long channelId) {
        Observable<List<ApplicationCommand>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{QueryCommandsUpdate, this.storePermissions}, false, null, null, new C57121(channelId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void requestApplicationCommandAutocompleteData(Long guildId, long channelId, ApplicationCommandData data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.dispatcher.schedule(new C57131(data, channelId, guildId));
    }

    public final void requestApplicationCommandsQuery(Long guildId, String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new C57161(guildId, query));
    }

    public final void requestApplications(Long guildId) {
        if (this.connectionReady) {
            this.dispatcher.schedule(new C57171(guildId));
        } else {
            this.pendingGatewayGuildId = guildId;
        }
    }

    public final void requestDiscoverCommands(long applicationId) {
        Long l = this.discoverGuildId;
        if (l != null) {
            l.longValue();
            requestInitialApplicationCommands$default(this, l, Long.valueOf(applicationId), false, 4, null);
        }
    }

    public final void requestFrecencyCommands(long guildId) {
        List<String> topCommandIds = this.storeApplicationCommandFrecency.getTopCommandIds(Long.valueOf(guildId));
        String strGenerateNonce = generateNonce();
        FrecencyRequest frecencyRequest = new FrecencyRequest(Long.valueOf(guildId), topCommandIds);
        if (this.frecencyRequests.containsValue(frecencyRequest)) {
            return;
        }
        this.frecencyRequests.put(strGenerateNonce, frecencyRequest);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(topCommandIds, 10));
        for (String str : topCommandIds) {
            if (Strings4.contains$default((CharSequence) str, (CharSequence) " ", false, 2, (Object) null)) {
                str = (String) Strings4.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null).get(0);
            }
            arrayList.add(str);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long longOrNull = StringNumberConversions.toLongOrNull((String) next);
            if ((longOrNull != null ? longOrNull.longValue() : 0L) > 0) {
                arrayList2.add(next);
            }
        }
        if (!(!arrayList2.isEmpty())) {
            this.dispatcher.schedule(new C57192(strGenerateNonce));
        } else {
            if (StoreGatewayConnection.requestApplicationCommands$default(this.storeGatewayConnection, guildId, strGenerateNonce, false, null, null, 20, _Collections.distinct(arrayList2), 24, null)) {
                return;
            }
            this.dispatcher.schedule(new C57181(strGenerateNonce));
        }
    }

    public final void requestInitialApplicationCommands(Long guildId, Long applicationId, boolean forDmDiscover) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        this.loadDirectionUp = false;
        this.loadDirectionDown = false;
        if (!forDmDiscover) {
            this.jumpedApplicationId = applicationId;
        }
        if (this.jumpedApplicationId != null) {
            this.jumpedSequenceId++;
        }
        if (applicationId != null) {
            long jLongValue = applicationId.longValue();
            this.discoverCommands = DiscoverCommands.copy$default(this.discoverCommands, Collections2.emptyList(), 0, 0, false, false, 0, null, null, 254, null);
            if (this.applicationCommandIndexes.containsKey(Long.valueOf(jLongValue))) {
                Integer num = this.applicationCommandIndexes.get(Long.valueOf(jLongValue));
                int iIntValue = num != null ? num.intValue() : 0;
                ref$IntRef.element = iIntValue;
                this.currentStartOffset = iIntValue;
                this.currentEndOffset = iIntValue;
            }
            if (jLongValue == this.builtInCommandsProvider.getBuiltInApplication().getId()) {
                this.dispatcher.schedule(new C5720xe407722c(this, ref$IntRef));
                return;
            }
        }
        requestApplicationCommands$default(this, guildId, ref$IntRef.element, applicationId, 0, 8, null);
    }

    public final void requestLoadMoreDown() {
        Long l = this.discoverGuildId;
        if (l != null) {
            long jLongValue = l.longValue();
            requestApplicationCommands$default(this, Long.valueOf(jLongValue), this.currentEndOffset + 1, null, 20, 4, null);
            this.loadDirectionUp = false;
            this.loadDirectionDown = true;
            this.jumpedApplicationId = null;
            this.discoverCommands = DiscoverCommands.copy$default(this.discoverCommands, null, 0, 0, false, false, 0, null, LoadState.LoadingDown.INSTANCE, Opcodes.LAND, null);
        }
    }

    public final void requestLoadMoreUp() {
        int i;
        int i2;
        Long l = this.discoverGuildId;
        if (l != null) {
            long jLongValue = l.longValue();
            int i3 = this.currentStartOffset;
            int i4 = i3 - 20;
            if (i4 < 0) {
                i2 = i3;
                i = 0;
            } else {
                i = i4;
                i2 = 20;
            }
            requestApplicationCommands$default(this, Long.valueOf(jLongValue), i, null, i2, 4, null);
            this.loadDirectionUp = true;
            this.loadDirectionDown = false;
            this.jumpedApplicationId = null;
            this.discoverCommands = DiscoverCommands.copy$default(this.discoverCommands, null, 0, 0, false, false, 0, null, LoadState.LoadingUp.INSTANCE, Opcodes.LAND, null);
        }
    }

    @Store3
    public final void setAutocompleteFailed(String commandOptionName, String queryString) {
        Intrinsics3.checkNotNullParameter(commandOptionName, "commandOptionName");
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        setAutocompleteState(commandOptionName, queryString, CommandAutocompleteState.Failed.INSTANCE);
    }

    @Store3
    public final void setAutocompleteLoading(String commandOptionName, String queryString) {
        Intrinsics3.checkNotNullParameter(commandOptionName, "commandOptionName");
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        setAutocompleteState(commandOptionName, queryString, CommandAutocompleteState.Loading.INSTANCE);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        if (getUpdateSources().contains(DiscoverCommandsUpdate)) {
            DiscoverCommands discoverCommands = this.discoverCommands;
            this.discoverCommandsSnapshot = DiscoverCommands.copy$default(discoverCommands, StoreApplicationCommandsKt.flattenSubCommands(discoverCommands.getCommands()), 0, 0, false, false, 0, null, null, 254, null);
        }
        if (getUpdateSources().contains(QueryCommandsUpdate)) {
            this.queryCommandsSnapshot = new ArrayList(StoreApplicationCommandsKt.flattenSubCommands(this.queryCommands));
        }
        if (getUpdateSources().contains(GuildApplicationsUpdate)) {
            ArrayList arrayList = new ArrayList(this.applications);
            this.applicationsSnapshot = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj : arrayList) {
                linkedHashMap.put(Long.valueOf(((Application) obj).getId()), obj);
            }
            this.applicationsMapSnapshot = linkedHashMap;
        }
        if (getUpdateSources().contains(AutocompleteResultsUpdate)) {
            this.autocompleteOptionResultsSnapshot = new HashMap(this.autocompleteOptionResults);
        }
        if (getUpdateSources().contains(FrecencyCommandsUpdate)) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.putAll(this.frecencyCommands);
            this.frecencyCommandsSnapshot = linkedHashMap2;
        }
    }

    public StoreApplicationCommands(StoreGatewayConnection storeGatewayConnection, StorePermissions storePermissions, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreGuilds storeGuilds, StoreUser storeUser, StoreExperiments storeExperiments, Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, BuiltInCommandsProvider builtInCommandsProvider, NonceGenerator nonceGenerator) {
        Intrinsics3.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeApplicationCommandFrecency, "storeApplicationCommandFrecency");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(builtInCommandsProvider, "builtInCommandsProvider");
        Intrinsics3.checkNotNullParameter(nonceGenerator, "nonceGenerator");
        this.storeGatewayConnection = storeGatewayConnection;
        this.storePermissions = storePermissions;
        this.storeApplicationCommandFrecency = storeApplicationCommandFrecency;
        this.storeGuilds = storeGuilds;
        this.storeUsers = storeUser;
        this.storeExperiments = storeExperiments;
        this.dispatcher = dispatcher;
        this.restApi = restAPI;
        this.observationDeck = observationDeck;
        this.builtInCommandsProvider = builtInCommandsProvider;
        this.nonceGenerator = nonceGenerator;
        DiscoverCommands.Companion companion = DiscoverCommands.INSTANCE;
        this.discoverCommands = companion.getDefaultModelDiscoveryCommands();
        this.discoverCommandsSnapshot = companion.getDefaultModelDiscoveryCommands();
        this.applicationCommandIndexes = new LinkedHashMap();
        this.applications = Collections2.emptyList();
        this.applicationsSnapshot = Collections2.emptyList();
        this.applicationsMapSnapshot = Maps6.emptyMap();
        this.queryCommands = new ArrayList();
        this.queryCommandsSnapshot = Collections2.emptyList();
        this.autocompleteNonceData = new LinkedHashMap();
        this.autocompleteOptionResults = new LinkedHashMap();
        this.autocompleteOptionResultsSnapshot = Maps6.emptyMap();
        this.frecencyRequests = new LinkedHashMap();
        this.frecencyCommands = new LinkedHashMap();
        this.frecencyCommandsSnapshot = Maps6.emptyMap();
    }
}

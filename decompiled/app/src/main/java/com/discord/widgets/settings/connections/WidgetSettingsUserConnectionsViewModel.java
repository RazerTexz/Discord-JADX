package com.discord.widgets.settings.connections;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BehaviorSubject<Map<String, JoinStatus>> joinStateSubject;
    private final Map<String, JoinStatus> joinStatusMap;
    private final RestAPI restApi;

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<StoreState, Map<String, ? extends JoinStatus>, List<? extends ConnectionState>> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends ConnectionState> call(StoreState storeState, Map<String, ? extends JoinStatus> map) {
            return call2(storeState, map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ConnectionState> call2(StoreState storeState, Map<String, ? extends JoinStatus> map) {
            WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel = WidgetSettingsUserConnectionsViewModel.this;
            m.checkNotNullExpressionValue(storeState, "storeState");
            m.checkNotNullExpressionValue(map, "joinMap");
            return WidgetSettingsUserConnectionsViewModel.access$combineState(widgetSettingsUserConnectionsViewModel, storeState, map);
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<List<? extends ConnectionState>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ConnectionState> list) {
            invoke2((List<ConnectionState>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ConnectionState> list) {
            WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel = WidgetSettingsUserConnectionsViewModel.this;
            m.checkNotNullExpressionValue(list, "storeState");
            WidgetSettingsUserConnectionsViewModel.access$handleConnectionsState(widgetSettingsUserConnectionsViewModel, list);
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion) {
            return companion.observeStores();
        }

        private final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableJ = Observable.j(companion.getUserConnections().observeConnectedAccounts(), companion.getGuilds().observeGuilds(), WidgetSettingsUserConnectionsViewModel$Companion$observeStores$1.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…= \"contacts\" }, guilds) }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final /* data */ class ConnectionState {
        private final ConnectedAccount connection;
        private final Map<String, JoinStatus> integrationGuildJoinStatus;

        /* JADX WARN: Multi-variable type inference failed */
        public ConnectionState(ConnectedAccount connectedAccount, Map<String, ? extends JoinStatus> map) {
            m.checkNotNullParameter(connectedAccount, "connection");
            m.checkNotNullParameter(map, "integrationGuildJoinStatus");
            this.connection = connectedAccount;
            this.integrationGuildJoinStatus = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConnectionState copy$default(ConnectionState connectionState, ConnectedAccount connectedAccount, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                connectedAccount = connectionState.connection;
            }
            if ((i & 2) != 0) {
                map = connectionState.integrationGuildJoinStatus;
            }
            return connectionState.copy(connectedAccount, map);
        }

        /* renamed from: component1, reason: from getter */
        public final ConnectedAccount getConnection() {
            return this.connection;
        }

        public final Map<String, JoinStatus> component2() {
            return this.integrationGuildJoinStatus;
        }

        public final ConnectionState copy(ConnectedAccount connection, Map<String, ? extends JoinStatus> integrationGuildJoinStatus) {
            m.checkNotNullParameter(connection, "connection");
            m.checkNotNullParameter(integrationGuildJoinStatus, "integrationGuildJoinStatus");
            return new ConnectionState(connection, integrationGuildJoinStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectionState)) {
                return false;
            }
            ConnectionState connectionState = (ConnectionState) other;
            return m.areEqual(this.connection, connectionState.connection) && m.areEqual(this.integrationGuildJoinStatus, connectionState.integrationGuildJoinStatus);
        }

        public final ConnectedAccount getConnection() {
            return this.connection;
        }

        public final Map<String, JoinStatus> getIntegrationGuildJoinStatus() {
            return this.integrationGuildJoinStatus;
        }

        public int hashCode() {
            ConnectedAccount connectedAccount = this.connection;
            int iHashCode = (connectedAccount != null ? connectedAccount.hashCode() : 0) * 31;
            Map<String, JoinStatus> map = this.integrationGuildJoinStatus;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ConnectionState(connection=");
            sbU.append(this.connection);
            sbU.append(", integrationGuildJoinStatus=");
            return a.M(sbU, this.integrationGuildJoinStatus, ")");
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static abstract class JoinStatus {

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class JoinFailed extends JoinStatus {
            public static final JoinFailed INSTANCE = new JoinFailed();

            private JoinFailed() {
                super(null);
            }
        }

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class Joined extends JoinStatus {
            public static final Joined INSTANCE = new Joined();

            private Joined() {
                super(null);
            }
        }

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class Joining extends JoinStatus {
            public static final Joining INSTANCE = new Joining();

            private Joining() {
                super(null);
            }
        }

        private JoinStatus() {
        }

        public /* synthetic */ JoinStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static final /* data */ class StoreState {
        private final List<ConnectedAccount> connectedAccounts;
        private final Map<Long, Guild> guilds;

        public StoreState(List<ConnectedAccount> list, Map<Long, Guild> map) {
            m.checkNotNullParameter(list, "connectedAccounts");
            m.checkNotNullParameter(map, "guilds");
            this.connectedAccounts = list;
            this.guilds = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.connectedAccounts;
            }
            if ((i & 2) != 0) {
                map = storeState.guilds;
            }
            return storeState.copy(list, map);
        }

        public final List<ConnectedAccount> component1() {
            return this.connectedAccounts;
        }

        public final Map<Long, Guild> component2() {
            return this.guilds;
        }

        public final StoreState copy(List<ConnectedAccount> connectedAccounts, Map<Long, Guild> guilds) {
            m.checkNotNullParameter(connectedAccounts, "connectedAccounts");
            m.checkNotNullParameter(guilds, "guilds");
            return new StoreState(connectedAccounts, guilds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.connectedAccounts, storeState.connectedAccounts) && m.areEqual(this.guilds, storeState.guilds);
        }

        public final List<ConnectedAccount> getConnectedAccounts() {
            return this.connectedAccounts;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public int hashCode() {
            List<ConnectedAccount> list = this.connectedAccounts;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, Guild> map = this.guilds;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(connectedAccounts=");
            sbU.append(this.connectedAccounts);
            sbU.append(", guilds=");
            return a.M(sbU, this.guilds, ")");
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<ConnectionState> data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<ConnectionState> list) {
                super(null);
                m.checkNotNullParameter(list, "data");
                this.data = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.data;
                }
                return loaded.copy(list);
            }

            public final List<ConnectionState> component1() {
                return this.data;
            }

            public final Loaded copy(List<ConnectionState> data) {
                m.checkNotNullParameter(data, "data");
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final List<ConnectionState> getData() {
                return this.data;
            }

            public int hashCode() {
                List<ConnectionState> list = this.data;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.L(a.U("Loaded(data="), this.data, ")");
            }
        }

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$joinConnectionIntegrationGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $integrationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$integrationId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetSettingsUserConnectionsViewModel.access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel.this).put(this.$integrationId, JoinStatus.JoinFailed.INSTANCE);
            WidgetSettingsUserConnectionsViewModel.access$getJoinStateSubject$p(WidgetSettingsUserConnectionsViewModel.this).onNext(WidgetSettingsUserConnectionsViewModel.access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel.this));
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$joinConnectionIntegrationGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Void, Unit> {
        public final /* synthetic */ String $integrationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$integrationId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            WidgetSettingsUserConnectionsViewModel.access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel.this).put(this.$integrationId, JoinStatus.Joined.INSTANCE);
            WidgetSettingsUserConnectionsViewModel.access$getJoinStateSubject$p(WidgetSettingsUserConnectionsViewModel.this).onNext(WidgetSettingsUserConnectionsViewModel.access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel.this));
        }
    }

    public WidgetSettingsUserConnectionsViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ WidgetSettingsUserConnectionsViewModel(Observable observable, StoreUserConnections storeUserConnections, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.access$observeStores(INSTANCE) : observable, (i & 2) != 0 ? StoreStream.INSTANCE.getUserConnections() : storeUserConnections, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ List access$combineState(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel, StoreState storeState, Map map) {
        return widgetSettingsUserConnectionsViewModel.combineState(storeState, map);
    }

    public static final /* synthetic */ BehaviorSubject access$getJoinStateSubject$p(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel) {
        return widgetSettingsUserConnectionsViewModel.joinStateSubject;
    }

    public static final /* synthetic */ Map access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel) {
        return widgetSettingsUserConnectionsViewModel.joinStatusMap;
    }

    public static final /* synthetic */ void access$handleConnectionsState(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel, List list) {
        widgetSettingsUserConnectionsViewModel.handleConnectionsState(list);
    }

    private final List<ConnectionState> combineState(StoreState storeState, Map<String, ? extends JoinStatus> joinMap) {
        ArrayList arrayList = new ArrayList();
        for (ConnectedAccount connectedAccount : storeState.getConnectedAccounts()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<ConnectedAccountIntegration> listC = connectedAccount.c();
            if (listC != null) {
                for (ConnectedAccountIntegration connectedAccountIntegration : listC) {
                    ConnectedIntegrationGuild guild = connectedAccountIntegration.getGuild();
                    if (guild != null) {
                        if (storeState.getGuilds().containsKey(Long.valueOf(guild.getId()))) {
                            linkedHashMap.put(connectedAccountIntegration.getId(), JoinStatus.Joined.INSTANCE);
                        }
                        JoinStatus joinStatus = joinMap.get(connectedAccountIntegration.getId());
                        if (joinStatus != null) {
                            linkedHashMap.put(connectedAccountIntegration.getId(), joinStatus);
                        }
                    }
                }
            }
            arrayList.add(new ConnectionState(connectedAccount, linkedHashMap));
        }
        return arrayList;
    }

    private final void handleConnectionsState(List<ConnectionState> state) {
        if (state == null || state.isEmpty()) {
            updateViewState(ViewState.Empty.INSTANCE);
        } else {
            updateViewState(new ViewState.Loaded(state));
        }
    }

    public final void joinConnectionIntegrationGuild(String integrationId) {
        m.checkNotNullParameter(integrationId, "integrationId");
        this.joinStatusMap.put(integrationId, JoinStatus.Joining.INSTANCE);
        this.joinStateSubject.onNext(this.joinStatusMap);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.joinGuildFromIntegration(integrationId), false, 1, null), WidgetSettingsUserConnectionsViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(integrationId), (Function0) null, (Function0) null, new AnonymousClass2(integrationId), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsViewModel(Observable<StoreState> observable, StoreUserConnections storeUserConnections, RestAPI restAPI) {
        super(ViewState.Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(storeUserConnections, "storeUserConnections");
        m.checkNotNullParameter(restAPI, "restApi");
        this.restApi = restAPI;
        this.joinStatusMap = new LinkedHashMap();
        BehaviorSubject<Map<String, JoinStatus>> behaviorSubjectL0 = BehaviorSubject.l0(h0.emptyMap());
        this.joinStateSubject = behaviorSubjectL0;
        storeUserConnections.fetchConnectedAccounts();
        Observable observableJ = Observable.j(observable, behaviorSubjectL0, new AnonymousClass1());
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…te(storeState, joinMap) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableJ), this, null, 2, null), WidgetSettingsUserConnectionsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}

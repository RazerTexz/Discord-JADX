package com.discord.widgets.guilds.contextmenu;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.a.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: FolderContextMenuViewModel.kt */
/* loaded from: classes2.dex */
public final class FolderContextMenuViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long folderId;
    private List<Long> guildIds;
    private final RestAPI restAPI;
    private final Observable<StoreState> storeStateObservable;
    private Set<Long> unreadGuildIds;

    /* compiled from: FolderContextMenuViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<StoreState, Unit> {
        public AnonymousClass1(FolderContextMenuViewModel folderContextMenuViewModel) {
            super(1, folderContextMenuViewModel, FolderContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "p1");
            FolderContextMenuViewModel.access$handleStoreState((FolderContextMenuViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: FolderContextMenuViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreUserSettings storeUserSettings, StoreReadStates storeReadStates) {
            return companion.observeStoreState(j, storeUserSettings, storeReadStates);
        }

        private final Observable<StoreState> observeStoreState(long folderId, StoreUserSettings userSettingsStore, StoreReadStates readStateStore) {
            Observable<StoreState> observableJ = Observable.j(userSettingsStore.observeGuildFolders(), readStateStore.getUnreadGuildIds(), new FolderContextMenuViewModel$Companion$observeStoreState$1(folderId));
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…      )\n        }\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FolderContextMenuViewModel.kt */
    public static abstract class Event {

        /* compiled from: FolderContextMenuViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FolderContextMenuViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: FolderContextMenuViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: FolderContextMenuViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final ModelGuildFolder folder;
            private final Set<Long> unreadGuildIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(ModelGuildFolder modelGuildFolder, Set<Long> set) {
                super(null);
                m.checkNotNullParameter(modelGuildFolder, "folder");
                m.checkNotNullParameter(set, "unreadGuildIds");
                this.folder = modelGuildFolder;
                this.unreadGuildIds = set;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, ModelGuildFolder modelGuildFolder, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildFolder = valid.folder;
                }
                if ((i & 2) != 0) {
                    set = valid.unreadGuildIds;
                }
                return valid.copy(modelGuildFolder, set);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final Set<Long> component2() {
                return this.unreadGuildIds;
            }

            public final Valid copy(ModelGuildFolder folder, Set<Long> unreadGuildIds) {
                m.checkNotNullParameter(folder, "folder");
                m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
                return new Valid(folder, unreadGuildIds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return m.areEqual(this.folder, valid.folder) && m.areEqual(this.unreadGuildIds, valid.unreadGuildIds);
            }

            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final Set<Long> getUnreadGuildIds() {
                return this.unreadGuildIds;
            }

            public int hashCode() {
                ModelGuildFolder modelGuildFolder = this.folder;
                int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
                Set<Long> set = this.unreadGuildIds;
                return iHashCode + (set != null ? set.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Valid(folder=");
                sbU.append(this.folder);
                sbU.append(", unreadGuildIds=");
                return a.N(sbU, this.unreadGuildIds, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FolderContextMenuViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: FolderContextMenuViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: FolderContextMenuViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final ModelGuildFolder folder;
            private final boolean showMarkAsRead;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(ModelGuildFolder modelGuildFolder, boolean z2) {
                super(null);
                m.checkNotNullParameter(modelGuildFolder, "folder");
                this.folder = modelGuildFolder;
                this.showMarkAsRead = z2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, ModelGuildFolder modelGuildFolder, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildFolder = valid.folder;
                }
                if ((i & 2) != 0) {
                    z2 = valid.showMarkAsRead;
                }
                return valid.copy(modelGuildFolder, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            public final Valid copy(ModelGuildFolder folder, boolean showMarkAsRead) {
                m.checkNotNullParameter(folder, "folder");
                return new Valid(folder, showMarkAsRead);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return m.areEqual(this.folder, valid.folder) && this.showMarkAsRead == valid.showMarkAsRead;
            }

            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelGuildFolder modelGuildFolder = this.folder;
                int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
                boolean z2 = this.showMarkAsRead;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = a.U("Valid(folder=");
                sbU.append(this.folder);
                sbU.append(", showMarkAsRead=");
                return a.O(sbU, this.showMarkAsRead, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FolderContextMenuViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$onMarkAsReadClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<Void>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<Void> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Void> list) {
            PublishSubject publishSubjectAccess$getEventSubject$p = FolderContextMenuViewModel.access$getEventSubject$p(FolderContextMenuViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FolderContextMenuViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        restAPI = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, j, companion2.getUserSettings(), companion2.getReadStates());
        }
        this(j, restAPI, observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(FolderContextMenuViewModel folderContextMenuViewModel) {
        return folderContextMenuViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(FolderContextMenuViewModel folderContextMenuViewModel, StoreState storeState) {
        folderContextMenuViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (!(storeState instanceof StoreState.Valid)) {
            if (m.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
                updateViewState(ViewState.Invalid.INSTANCE);
                return;
            }
            return;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        this.guildIds = valid.getFolder().getGuildIds();
        this.unreadGuildIds = valid.getUnreadGuildIds();
        ModelGuildFolder folder = valid.getFolder();
        List<Long> guildIds = valid.getFolder().getGuildIds();
        boolean z2 = false;
        if (!(guildIds instanceof Collection) || !guildIds.isEmpty()) {
            Iterator<T> it = guildIds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (this.unreadGuildIds.contains(Long.valueOf(((Number) it.next()).longValue()))) {
                    z2 = true;
                    break;
                }
            }
        }
        updateViewState(new ViewState.Valid(folder, z2));
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        Set setIntersect = u.intersect(this.guildIds, this.unreadGuildIds);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(setIntersect, 10));
        Iterator it = setIntersect.iterator();
        while (it.hasNext()) {
            arrayList.add(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(((Number) it.next()).longValue()), false, 1, null));
        }
        Observable observableF0 = Observable.H(Observable.h0(new q(arrayList))).f0();
        m.checkNotNullExpressionValue(observableF0, "Observable\n        .merg…tCalls)\n        .toList()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableF0, this, null, 2, null), FolderContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final void onSettingsClicked() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderContextMenuViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.folderId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        this.guildIds = n.emptyList();
        this.unreadGuildIds = n0.emptySet();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), FolderContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}

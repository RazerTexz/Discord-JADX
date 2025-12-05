package com.discord.widgets.guilds.contextmenu;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p643a.OnSubscribeFromIterable;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: FolderContextMenuViewModel.kt */
/* loaded from: classes2.dex */
public final class FolderContextMenuViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long folderId;
    private List<Long> guildIds;
    private final RestAPI restAPI;
    private final Observable<StoreState> storeStateObservable;
    private Set<Long> unreadGuildIds;

    /* compiled from: FolderContextMenuViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$1 */
    public static final /* synthetic */ class C85831 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public C85831(FolderContextMenuViewModel folderContextMenuViewModel) {
            super(1, folderContextMenuViewModel, FolderContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
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
            Observable<StoreState> observableM11076j = Observable.m11076j(userSettingsStore.observeGuildFolders(), readStateStore.getUnreadGuildIds(), new FolderContextMenuViewModel2(folderId));
            Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…      )\n        }\n      }");
            return observableM11076j;
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
                Intrinsics3.checkNotNullParameter(modelGuildFolder, "folder");
                Intrinsics3.checkNotNullParameter(set, "unreadGuildIds");
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
                Intrinsics3.checkNotNullParameter(folder, "folder");
                Intrinsics3.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
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
                return Intrinsics3.areEqual(this.folder, valid.folder) && Intrinsics3.areEqual(this.unreadGuildIds, valid.unreadGuildIds);
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
                StringBuilder sbM833U = outline.m833U("Valid(folder=");
                sbM833U.append(this.folder);
                sbM833U.append(", unreadGuildIds=");
                return outline.m826N(sbM833U, this.unreadGuildIds, ")");
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
                Intrinsics3.checkNotNullParameter(modelGuildFolder, "folder");
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
                Intrinsics3.checkNotNullParameter(folder, "folder");
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
                return Intrinsics3.areEqual(this.folder, valid.folder) && this.showMarkAsRead == valid.showMarkAsRead;
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
                StringBuilder sbM833U = outline.m833U("Valid(folder=");
                sbM833U.append(this.folder);
                sbM833U.append(", showMarkAsRead=");
                return outline.m827O(sbM833U, this.showMarkAsRead, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FolderContextMenuViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$onMarkAsReadClicked$1 */
    public static final class C85841 extends Lambda implements Function1<List<Void>, Unit> {
        public C85841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<Void> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Void> list) {
            PublishSubject publishSubjectAccess$getEventSubject$p = FolderContextMenuViewModel.access$getEventSubject$p(FolderContextMenuViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.Dismiss.INSTANCE);
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
            if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
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
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        Set setIntersect = _Collections.intersect(this.guildIds, this.unreadGuildIds);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setIntersect, 10));
        Iterator it = setIntersect.iterator();
        while (it.hasNext()) {
            arrayList.add(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(((Number) it.next()).longValue()), false, 1, null));
        }
        Observable observableM11105f0 = Observable.m11063H(Observable.m11074h0(new OnSubscribeFromIterable(arrayList))).m11105f0();
        Intrinsics3.checkNotNullExpressionValue(observableM11105f0, "Observable\n        .merg…tCalls)\n        .toList()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11105f0, this, null, 2, null), FolderContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85841(), 62, (Object) null);
    }

    public final void onSettingsClicked() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.Dismiss.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderContextMenuViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.folderId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.m11133k0();
        this.guildIds = Collections2.emptyList();
        this.unreadGuildIds = Sets5.emptySet();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), FolderContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85831(this), 62, (Object) null);
    }
}

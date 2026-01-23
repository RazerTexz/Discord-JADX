package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: compiled from: GuildInviteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteViewModel extends AppViewModel<ViewState> implements AppComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreInstantInvites instantInvitesStore;
    private final StoreInviteSettings.InviteCode inviteCode;
    private boolean inviteResolved;
    private final Observable<StoreState> storeStateObservable;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$1 */
    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static final class C86261 extends Lambda implements Function1<StoreState, Unit> {
        public C86261() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GuildInviteViewModel.access$handleStoreState(GuildInviteViewModel.this, storeState);
        }
    }

    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreInstantInvites storeInstantInvites, StoreInviteSettings.InviteCode inviteCode) {
            return companion.observeStoreState(storeInstantInvites, inviteCode);
        }

        private final Observable<StoreState> observeStoreState(StoreInstantInvites instantInvitesStore, StoreInviteSettings.InviteCode inviteCode) {
            if (inviteCode == null) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(StoreState.Invalid.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(StoreState.Invalid)");
                return scalarSynchronousObservable;
            }
            Observable observableM11083G = instantInvitesStore.observeInvite(ModelInvite.getInviteStoreKey(inviteCode.getInviteCode(), inviteCode.getEventId())).m11083G(GuildInviteViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "instantInvitesStore\n    …            }\n          }");
            return observableM11083G;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelInvite modelInvite) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = loaded.invite;
                }
                return loaded.copy(modelInvite);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Loaded copy(ModelInvite invite) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Loaded(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.invite, ((Loaded) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Loading extends StoreState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelInvite modelInvite) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = loaded.invite;
                }
                return loaded.copy(modelInvite);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Loaded copy(ModelInvite invite) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Loaded(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.invite, ((Loaded) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$fetchInviteIfNotLoaded$1 */
    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static final class C86271 extends Lambda implements Function0<Unit> {
        public C86271() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = outline.m833U("Failed to resolve invite[");
            sbM833U.append(GuildInviteViewModel.this.getInviteCode().getInviteCode());
            sbM833U.append("] from ");
            sbM833U.append(GuildInviteViewModel.this.getInviteCode().getSource());
            Logger.d$default(appLog, sbM833U.toString(), null, 2, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildInviteViewModel(StoreInviteSettings.InviteCode inviteCode, StoreInstantInvites storeInstantInvites, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeInstantInvites = (i & 2) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites;
        this(inviteCode, storeInstantInvites, (i & 4) != 0 ? Companion.access$observeStoreState(INSTANCE, storeInstantInvites, inviteCode) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildInviteViewModel guildInviteViewModel, StoreState storeState) {
        guildInviteViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Loading) {
            updateViewState(ViewState.Loading.INSTANCE);
        } else if (storeState instanceof StoreState.Invalid) {
            updateViewState(ViewState.Invalid.INSTANCE);
        } else if (storeState instanceof StoreState.Loaded) {
            updateViewState(new ViewState.Loaded(((StoreState.Loaded) storeState).getInvite()));
        }
    }

    public final void fetchInviteIfNotLoaded() {
        if (this.inviteCode == null) {
            return;
        }
        StoreStream.INSTANCE.getInstantInvites().fetchInviteIfNotLoaded(this.inviteCode.getInviteCode(), this.inviteCode.getEventId(), this.inviteCode.getSource(), Boolean.valueOf(this.inviteResolved), new C86271());
    }

    public final StoreInviteSettings.InviteCode getInviteCode() {
        return this.inviteCode;
    }

    public final boolean getInviteResolved() {
        return this.inviteResolved;
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final void setInviteResolved(boolean z2) {
        this.inviteResolved = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteViewModel(StoreInviteSettings.InviteCode inviteCode, StoreInstantInvites storeInstantInvites, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeInstantInvites, "instantInvitesStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.inviteCode = inviteCode;
        this.instantInvitesStore = storeInstantInvites;
        this.storeStateObservable = observable;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildInviteViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C86261(), 62, (Object) null);
    }
}

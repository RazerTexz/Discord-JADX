package com.discord.widgets.auth;

import android.content.Context;
import androidx.view.ViewModel3;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Result3;
import d0.g0.StringsJVM;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetRemoteAuthViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetRemoteAuthViewModel extends AppViewModel<ViewState> {
    private final RestAPI restAPI;
    private final BehaviorSubject<Boolean> temporaryBehaviorSubject;

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelRemoteAuthHandshake, Unit> {

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        @DebugMetadata(c = "com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1", f = "WidgetRemoteAuthViewModel.kt", l = {54}, m = "invokeSuspend")
        /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02371 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ ModelRemoteAuthHandshake $handshakeData;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02371(ModelRemoteAuthHandshake modelRemoteAuthHandshake, Continuation continuation) {
                super(2, continuation);
                this.$handshakeData = modelRemoteAuthHandshake;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass1.this.new C02371(this.$handshakeData, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02371) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (f.P(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = WidgetRemoteAuthViewModel.this;
                String handshakeToken = this.$handshakeData.getHandshakeToken();
                BehaviorSubject behaviorSubjectAccess$getTemporaryBehaviorSubject$p = WidgetRemoteAuthViewModel.access$getTemporaryBehaviorSubject$p(WidgetRemoteAuthViewModel.this);
                Intrinsics3.checkNotNullExpressionValue(behaviorSubjectAccess$getTemporaryBehaviorSubject$p, "temporaryBehaviorSubject");
                Object objN0 = behaviorSubjectAccess$getTemporaryBehaviorSubject$p.n0();
                Intrinsics3.checkNotNullExpressionValue(objN0, "temporaryBehaviorSubject.value");
                WidgetRemoteAuthViewModel.access$updateViewState(widgetRemoteAuthViewModel, new ViewState.Loaded(handshakeToken, ((Boolean) objN0).booleanValue(), true));
                return Unit.a;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
            invoke2(modelRemoteAuthHandshake);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
            Intrinsics3.checkNotNullParameter(modelRemoteAuthHandshake, "handshakeData");
            WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = WidgetRemoteAuthViewModel.this;
            String handshakeToken = modelRemoteAuthHandshake.getHandshakeToken();
            BehaviorSubject behaviorSubjectAccess$getTemporaryBehaviorSubject$p = WidgetRemoteAuthViewModel.access$getTemporaryBehaviorSubject$p(WidgetRemoteAuthViewModel.this);
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectAccess$getTemporaryBehaviorSubject$p, "temporaryBehaviorSubject");
            Object objN0 = behaviorSubjectAccess$getTemporaryBehaviorSubject$p.n0();
            Intrinsics3.checkNotNullExpressionValue(objN0, "temporaryBehaviorSubject.value");
            WidgetRemoteAuthViewModel.access$updateViewState(widgetRemoteAuthViewModel, new ViewState.Loaded(handshakeToken, ((Boolean) objN0).booleanValue(), false));
            f.H0(ViewModel3.getViewModelScope(WidgetRemoteAuthViewModel.this), null, null, new C02371(modelRemoteAuthHandshake, null), 3, null);
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            if (response.getCode() != 10056) {
                return;
            }
            WidgetRemoteAuthViewModel.access$updateViewState(WidgetRemoteAuthViewModel.this, ViewState.Failed.INSTANCE);
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final String handshakeToken;
            private final boolean isTemporary;
            private final boolean loginAllowed;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(String str, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "handshakeToken");
                this.handshakeToken = str;
                this.isTemporary = z2;
                this.loginAllowed = z3;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.handshakeToken;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isTemporary;
                }
                if ((i & 4) != 0) {
                    z3 = loaded.loginAllowed;
                }
                return loaded.copy(str, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final String getHandshakeToken() {
                return this.handshakeToken;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsTemporary() {
                return this.isTemporary;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getLoginAllowed() {
                return this.loginAllowed;
            }

            public final Loaded copy(String handshakeToken, boolean isTemporary, boolean loginAllowed) {
                Intrinsics3.checkNotNullParameter(handshakeToken, "handshakeToken");
                return new Loaded(handshakeToken, isTemporary, loginAllowed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.handshakeToken, loaded.handshakeToken) && this.isTemporary == loaded.isTemporary && this.loginAllowed == loaded.loginAllowed;
            }

            public final String getHandshakeToken() {
                return this.handshakeToken;
            }

            public final boolean getLoginAllowed() {
                return this.loginAllowed;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String str = this.handshakeToken;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.isTemporary;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.loginAllowed;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isTemporary() {
                return this.isTemporary;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(handshakeToken=");
                sbU.append(this.handshakeToken);
                sbU.append(", isTemporary=");
                sbU.append(this.isTemporary);
                sbU.append(", loginAllowed=");
                return outline.O(sbU, this.loginAllowed, ")");
            }
        }

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        public static final class Succeeded extends ViewState {
            public static final Succeeded INSTANCE = new Succeeded();

            private Succeeded() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$cancelLogin$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$remoteLogin$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetRemoteAuthViewModel.access$updateViewState(WidgetRemoteAuthViewModel.this, ViewState.Succeeded.INSTANCE);
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$remoteLogin$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetRemoteAuthViewModel.access$updateViewState(WidgetRemoteAuthViewModel.this, ViewState.Failed.INSTANCE);
        }
    }

    public /* synthetic */ WidgetRemoteAuthViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ BehaviorSubject access$getTemporaryBehaviorSubject$p(WidgetRemoteAuthViewModel widgetRemoteAuthViewModel) {
        return widgetRemoteAuthViewModel.temporaryBehaviorSubject;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetRemoteAuthViewModel widgetRemoteAuthViewModel, ViewState viewState) {
        widgetRemoteAuthViewModel.updateViewState(viewState);
    }

    public final void cancelLogin() {
        if (getViewState() instanceof ViewState.Loaded) {
            RestAPI restAPI = this.restAPI;
            ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.postRemoteAuthCancel(new RestAPIParams.RemoteAuthCancel(((ViewState.Loaded) viewState).getHandshakeToken())), false, 1, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
        }
    }

    public final void remoteLogin() {
        if (getViewState() instanceof ViewState.Loaded) {
            RestAPI restAPI = this.restAPI;
            ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthFinish(new RestAPIParams.RemoteAuthFinish(false, ((ViewState.Loaded) viewState).getHandshakeToken())), false), this, null, 2, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }

    public final void toggleTemporary(boolean isTemporary) {
        this.temporaryBehaviorSubject.onNext(Boolean.valueOf(isTemporary));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel(String str, RestAPI restAPI) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "fingerprint");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.temporaryBehaviorSubject = BehaviorSubject.l0(Boolean.TRUE);
        if (StringsJVM.isBlank(str)) {
            updateViewState(ViewState.Failed.INSTANCE);
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthInitialize(new RestAPIParams.RemoteAuthInitialize(str)), false), this, null, 2, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }
}

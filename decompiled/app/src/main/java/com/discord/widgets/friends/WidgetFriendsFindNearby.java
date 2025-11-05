package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFriendsNearbyBinding;
import com.discord.rlottie.RLottieDrawable;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.friends.NearbyManager;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import defpackage.WidgetFriendsAddUserRequestsModel;
import defpackage.j;
import defpackage.v;
import defpackage.w;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/* compiled from: WidgetFriendsFindNearby.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearby extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFriendsFindNearby.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private Long meUserId;
    private final NearbyManager nearbyManager;
    private WidgetFriendsAddUserAdapter resultsAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetFriendsFindNearby.kt */
    public static abstract class Model {

        /* compiled from: WidgetFriendsFindNearby.kt */
        public static final class Empty extends Model {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* compiled from: WidgetFriendsFindNearby.kt */
        public static final /* data */ class Error extends Model {
            private final Integer errorCode;

            public Error(Integer num) {
                super(null);
                this.errorCode = num;
            }

            public static /* synthetic */ Error copy$default(Error error, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = error.errorCode;
                }
                return error.copy(num);
            }

            /* renamed from: component1, reason: from getter */
            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public final Error copy(Integer errorCode) {
                return new Error(errorCode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && m.areEqual(this.errorCode, ((Error) other).errorCode);
                }
                return true;
            }

            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public int hashCode() {
                Integer num = this.errorCode;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.F(a.U("Error(errorCode="), this.errorCode, ")");
            }
        }

        /* compiled from: WidgetFriendsFindNearby.kt */
        public static final /* data */ class NearbyUsers extends Model {
            private final List<WidgetFriendsAddUserAdapter.ItemUser> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NearbyUsers(List<WidgetFriendsAddUserAdapter.ItemUser> list) {
                super(null);
                m.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ NearbyUsers copy$default(NearbyUsers nearbyUsers, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = nearbyUsers.items;
                }
                return nearbyUsers.copy(list);
            }

            public final List<WidgetFriendsAddUserAdapter.ItemUser> component1() {
                return this.items;
            }

            public final NearbyUsers copy(List<WidgetFriendsAddUserAdapter.ItemUser> items) {
                m.checkNotNullParameter(items, "items");
                return new NearbyUsers(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof NearbyUsers) && m.areEqual(this.items, ((NearbyUsers) other).items);
                }
                return true;
            }

            public final List<WidgetFriendsAddUserAdapter.ItemUser> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<WidgetFriendsAddUserAdapter.ItemUser> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.L(a.U("NearbyUsers(items="), this.items, ")");
            }
        }

        /* compiled from: WidgetFriendsFindNearby.kt */
        public static final class Uninitialized extends Model {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public static final /* synthetic */ Observable access$getUserModels(ModelProvider modelProvider, Collection collection) {
            return modelProvider.getUserModels(collection);
        }

        private final Observable<Model.NearbyUsers> getUserModels(Collection<Long> userIds) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model.NearbyUsers> observableI = Observable.i(companion.getUsers().observeUsers(userIds, true), companion.getPresences().observePresencesForUsers(userIds), companion.getUserRelationships().observe(userIds), WidgetFriendsFindNearby$ModelProvider$getUserModels$1.INSTANCE);
            m.checkNotNullExpressionValue(observableI, "Observable\n          .co…yUsers(items)\n          }");
            return observableI;
        }

        public final Observable<Model> get(Observable<NearbyManager.NearbyState> nearbyStateObservable) {
            m.checkNotNullParameter(nearbyStateObservable, "nearbyStateObservable");
            Observable observableY = nearbyStateObservable.Y(WidgetFriendsFindNearby$ModelProvider$get$1.INSTANCE);
            m.checkNotNullExpressionValue(observableY, "nearbyStateObservable\n  …          }\n            }");
            return observableY;
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$acceptFriendRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            b.a.d.m.g(WidgetFriendsFindNearby.this.getContext(), R.string.accept_request_button_after, 0, null, 12);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$declineFriendRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            b.a.d.m.g(WidgetFriendsFindNearby.this.getContext(), this.$successMessageStringRes, 0, null, 12);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<String, Integer, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
            invoke(str, num.intValue());
            return Unit.a;
        }

        public final void invoke(String str, int i) {
            m.checkNotNullParameter(str, "username");
            WidgetFriendsFindNearby.sendFriendRequest$default(WidgetFriendsFindNearby.this, str, i, null, 4, null);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetFriendsFindNearby.access$acceptFriendRequest(WidgetFriendsFindNearby.this, j);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function2<Long, Boolean, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetFriendsFindNearby.access$declineFriendRequest(WidgetFriendsFindNearby.this, j, z2);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Long, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetFriendsFindNearby.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsFindNearby.access$enableScanning(WidgetFriendsFindNearby.this);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), f.a.a(360014894392L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetFriendsAddUserRequestsModel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            invoke2(widgetFriendsAddUserRequestsModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            WidgetFriendsFindNearby.access$getResultsAdapter$p(WidgetFriendsFindNearby.this).addFriendRequestUserIds(widgetFriendsAddUserRequestsModel.outgoingIds, widgetFriendsAddUserRequestsModel.incomingIds);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            m.checkNotNullParameter(model, "it");
            WidgetFriendsFindNearby.access$configureUI(WidgetFriendsFindNearby.this, model);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public final /* synthetic */ String $username;

        public AnonymousClass1(String str) {
            this.$username = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r7) {
            Context context = WidgetFriendsFindNearby.this.getContext();
            Context context2 = WidgetFriendsFindNearby.this.getContext();
            b.a.d.m.h(context, context2 != null ? b.h(context2, R.string.add_friend_confirmation, new Object[]{this.$username}, null, 4) : null, 0, null, 12);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public final /* synthetic */ int $discriminator;
        public final /* synthetic */ String $username;

        /* compiled from: WidgetFriendsFindNearby.kt */
        /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Error error = this.$error;
                m.checkNotNullExpressionValue(error, "error");
                if (WidgetCaptchaKt.isCaptchaError(error)) {
                    WidgetFriendsFindNearby widgetFriendsFindNearby = WidgetFriendsFindNearby.this;
                    Error error2 = this.$error;
                    m.checkNotNullExpressionValue(error2, "error");
                    WidgetFriendsFindNearby.access$launchCaptchaFlow(widgetFriendsFindNearby, error2);
                    return;
                }
                RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                Context context = WidgetFriendsFindNearby.this.getContext();
                Error error3 = this.$error;
                m.checkNotNullExpressionValue(error3, "error");
                Error.Response response = error3.getResponse();
                m.checkNotNullExpressionValue(response, "error.response");
                b.a.d.m.h(WidgetFriendsFindNearby.this.getContext(), responseResolver.getRelationshipResponse(context, response.getCode(), AnonymousClass2.this.$username + MentionUtilsKt.CHANNELS_CHAR + UserUtils.INSTANCE.padDiscriminator(AnonymousClass2.this.$discriminator)), 0, null, 12);
            }
        }

        public AnonymousClass2(String str, int i) {
            this.$username = str;
            this.$discriminator = i;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
            m.checkNotNullExpressionValue(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    public WidgetFriendsFindNearby() {
        super(R.layout.widget_friends_nearby);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFriendsFindNearby$binding$2.INSTANCE, null, 2, null);
        WidgetFriendsFindNearby$viewModel$2 widgetFriendsFindNearby$viewModel$2 = WidgetFriendsFindNearby$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetFriendsFindNearbyViewModel.class), new WidgetFriendsFindNearby$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetFriendsFindNearby$viewModel$2));
        this.nearbyManager = new NearbyManager();
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetFriendsFindNearby$captchaLauncher$1(this));
    }

    private final void acceptFriendRequest(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(RestAPI.INSTANCE.getApi(), "Nearby - Accept Friend Request", userId, null, null, null, 28, null), false, 1, null), this, null, 2, null), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public static final /* synthetic */ void access$acceptFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, long j) {
        widgetFriendsFindNearby.acceptFriendRequest(j);
    }

    public static final /* synthetic */ void access$configureUI(WidgetFriendsFindNearby widgetFriendsFindNearby, Model model) {
        widgetFriendsFindNearby.configureUI(model);
    }

    public static final /* synthetic */ void access$declineFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, long j, boolean z2) {
        widgetFriendsFindNearby.declineFriendRequest(j, z2);
    }

    public static final /* synthetic */ void access$enableScanning(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        widgetFriendsFindNearby.enableScanning();
    }

    public static final /* synthetic */ WidgetFriendsAddUserAdapter access$getResultsAdapter$p(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = widgetFriendsFindNearby.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        return widgetFriendsAddUserAdapter;
    }

    public static final /* synthetic */ WidgetFriendsFindNearbyViewModel access$getViewModel$p(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        return widgetFriendsFindNearby.getViewModel();
    }

    public static final /* synthetic */ void access$launchCaptchaFlow(WidgetFriendsFindNearby widgetFriendsFindNearby, Error error) {
        widgetFriendsFindNearby.launchCaptchaFlow(error);
    }

    public static final /* synthetic */ void access$sendFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetFriendsFindNearby.sendFriendRequest(str, i, captchaPayload);
    }

    public static final /* synthetic */ void access$setResultsAdapter$p(WidgetFriendsFindNearby widgetFriendsFindNearby, WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        widgetFriendsFindNearby.resultsAdapter = widgetFriendsAddUserAdapter;
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Uninitialized) {
            TextView textView = getBinding().g;
            m.checkNotNullExpressionValue(textView, "binding.nearbyFriendsSearchingTitle");
            textView.setText(getString(R.string.add_friend_nearby_title));
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.nearbyFriendsSearchingBody");
            textView2.setText(getString(R.string.add_friend_nearby_body));
            TextView textView3 = getBinding().e;
            TextView textView4 = getBinding().e;
            m.checkNotNullExpressionValue(textView4, "binding.nearbyFriendsSearchingBody");
            textView3.setTextColor(ColorCompat.getThemedColor(textView4, R.attr.colorHeaderSecondary));
            MaterialButton materialButton = getBinding().f2399b;
            m.checkNotNullExpressionValue(materialButton, "binding.nearbyFriendsEnable");
            materialButton.setVisibility(0);
            RecyclerView recyclerView = getBinding().d;
            m.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
            recyclerView.setVisibility(8);
            RLottieImageView rLottieImageView = getBinding().f;
            RLottieDrawable rLottieDrawable = rLottieImageView.drawable;
            if (rLottieDrawable == null) {
                return;
            }
            rLottieImageView.playing = false;
            if (rLottieImageView.attachedToWindow) {
                rLottieDrawable.P = false;
                return;
            }
            return;
        }
        if (model instanceof Model.Error) {
            TextView textView5 = getBinding().g;
            m.checkNotNullExpressionValue(textView5, "binding.nearbyFriendsSearchingTitle");
            textView5.setText(getString(R.string.add_friend_nearby_title));
            TextView textView6 = getBinding().e;
            m.checkNotNullExpressionValue(textView6, "binding.nearbyFriendsSearchingBody");
            textView6.setText(getErrorMessage(((Model.Error) model).getErrorCode()));
            TextView textView7 = getBinding().e;
            TextView textView8 = getBinding().e;
            m.checkNotNullExpressionValue(textView8, "binding.nearbyFriendsSearchingBody");
            textView7.setTextColor(ColorCompat.getColor(textView8, R.color.status_red_500));
            MaterialButton materialButton2 = getBinding().f2399b;
            m.checkNotNullExpressionValue(materialButton2, "binding.nearbyFriendsEnable");
            materialButton2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().d;
            m.checkNotNullExpressionValue(recyclerView2, "binding.nearbyFriendsRecycler");
            recyclerView2.setVisibility(8);
            RLottieImageView rLottieImageView2 = getBinding().f;
            RLottieDrawable rLottieDrawable2 = rLottieImageView2.drawable;
            if (rLottieDrawable2 == null) {
                return;
            }
            rLottieImageView2.playing = false;
            if (rLottieImageView2.attachedToWindow) {
                rLottieDrawable2.P = false;
                return;
            }
            return;
        }
        if (model instanceof Model.Empty) {
            TextView textView9 = getBinding().g;
            m.checkNotNullExpressionValue(textView9, "binding.nearbyFriendsSearchingTitle");
            textView9.setText(getString(R.string.add_friend_nearby_title));
            TextView textView10 = getBinding().e;
            m.checkNotNullExpressionValue(textView10, "binding.nearbyFriendsSearchingBody");
            textView10.setText(getString(R.string.add_friend_nearby_body));
            TextView textView11 = getBinding().e;
            TextView textView12 = getBinding().e;
            m.checkNotNullExpressionValue(textView12, "binding.nearbyFriendsSearchingBody");
            textView11.setTextColor(ColorCompat.getThemedColor(textView12, R.attr.colorHeaderSecondary));
            MaterialButton materialButton3 = getBinding().f2399b;
            m.checkNotNullExpressionValue(materialButton3, "binding.nearbyFriendsEnable");
            materialButton3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().d;
            m.checkNotNullExpressionValue(recyclerView3, "binding.nearbyFriendsRecycler");
            recyclerView3.setVisibility(8);
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                return;
            }
            getBinding().f.b();
            return;
        }
        if (model instanceof Model.NearbyUsers) {
            TextView textView13 = getBinding().g;
            m.checkNotNullExpressionValue(textView13, "binding.nearbyFriendsSearchingTitle");
            textView13.setText(getString(R.string.add_friend_nearby_found_title));
            TextView textView14 = getBinding().e;
            m.checkNotNullExpressionValue(textView14, "binding.nearbyFriendsSearchingBody");
            textView14.setText(getString(R.string.add_friend_nearby_found_body));
            TextView textView15 = getBinding().e;
            TextView textView16 = getBinding().e;
            m.checkNotNullExpressionValue(textView16, "binding.nearbyFriendsSearchingBody");
            textView15.setTextColor(ColorCompat.getThemedColor(textView16, R.attr.colorHeaderSecondary));
            MaterialButton materialButton4 = getBinding().f2399b;
            m.checkNotNullExpressionValue(materialButton4, "binding.nearbyFriendsEnable");
            materialButton4.setVisibility(8);
            WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
            if (widgetFriendsAddUserAdapter == null) {
                m.throwUninitializedPropertyAccessException("resultsAdapter");
            }
            widgetFriendsAddUserAdapter.setData(((Model.NearbyUsers) model).getItems());
            RecyclerView recyclerView4 = getBinding().d;
            m.checkNotNullExpressionValue(recyclerView4, "binding.nearbyFriendsRecycler");
            recyclerView4.setVisibility(0);
        }
    }

    private final void declineFriendRequest(long userId, boolean incomingFriendRequest) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeRelationship("Nearby - Remove Friend Request", userId), false, 1, null), this, null, 2, null), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(incomingFriendRequest ? R.string.friend_request_ignored : R.string.friend_request_cancelled), 62, (Object) null);
    }

    private final void enableScanning() {
        if (this.meUserId == null) {
            updateMeUserIdAndInitNearbyManager();
        }
        if (this.meUserId != null) {
            NearbyManager nearbyManager = this.nearbyManager;
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            nearbyManager.buildClientAndPublish(activity);
        }
    }

    private final WidgetFriendsNearbyBinding getBinding() {
        return (WidgetFriendsNearbyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getErrorMessage(Integer resultCode) {
        if (resultCode != null && resultCode.intValue() == 99) {
            Context context = getContext();
            if (context != null) {
                return context.getString(R.string.add_friend_nearby_connection_error);
            }
            return null;
        }
        if (resultCode != null && resultCode.intValue() == 98) {
            Context context2 = getContext();
            if (context2 != null) {
                return context2.getString(R.string.add_friend_nearby_stopped);
            }
            return null;
        }
        Context context3 = getContext();
        if (context3 != null) {
            return context3.getString(R.string.add_friend_nearby_generic_error);
        }
        return null;
    }

    private final WidgetFriendsFindNearbyViewModel getViewModel() {
        return (WidgetFriendsFindNearbyViewModel) this.viewModel.getValue();
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.INSTANCE.launch(requireContext(), this.captchaLauncher, CaptchaErrorBody.INSTANCE.createFromError(error));
    }

    private final void sendFriendRequest(String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        getViewModel().setUsername(username);
        getViewModel().setDiscriminator(Integer.valueOf(discriminator));
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Nearby - Add Friend Suggestion", username, discriminator, captchaPayload), this, null, 2, null).k(b.a.d.o.h(new AnonymousClass1(username), getAppActivity(), new AnonymousClass2(username, discriminator)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetFriendsFindNearby widgetFriendsFindNearby, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaPayload = null;
        }
        widgetFriendsFindNearby.sendFriendRequest(str, i, captchaPayload);
    }

    private final void updateMeUserIdAndInitNearbyManager() {
        long id2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
        this.meUserId = Long.valueOf(id2);
        this.nearbyManager.initialize(id2);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.nearbyManager.disableNearby();
        super.onPause();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        enableScanning();
        AnalyticsTracker.INSTANCE.friendAddViewed("Nearby");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        updateMeUserIdAndInitNearbyManager();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = (WidgetFriendsAddUserAdapter) companion.configure(new WidgetFriendsAddUserAdapter(recyclerView));
        this.resultsAdapter = widgetFriendsAddUserAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter.setSendHandler(new AnonymousClass1());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter2 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter2.setAcceptHandler(new AnonymousClass2());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter3 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter3.setDeclineHandler(new AnonymousClass3());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter4 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter4.setOnItemClick(new AnonymousClass4());
        getBinding().f2399b.setOnClickListener(new AnonymousClass5());
        getBinding().c.setOnClickListener(AnonymousClass6.INSTANCE);
        getBinding().f.c(R.raw.anim_friends_add_nearby_looking, DimenUtils.dpToPixels(200), DimenUtils.dpToPixels(200));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<R> observableG = companion.getUserRelationships().observeForType(4).G(j.j);
        Observable<R> observableG2 = companion.getUserRelationships().observeForType(3).G(j.k);
        v vVar = v.j;
        Object wVar = vVar;
        if (vVar != null) {
            wVar = new w(vVar);
        }
        Observable observableJ = Observable.j(observableG, observableG2, (Func2) wVar);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…erRequestsModel\n        )");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.ui$default(observableR, this, null, 2, null).k(b.a.d.o.a.g(getContext(), new AnonymousClass1(), null));
        Observable<Model> observable = ModelProvider.INSTANCE.get(this.nearbyManager.getState());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observable, this, widgetFriendsAddUserAdapter), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}

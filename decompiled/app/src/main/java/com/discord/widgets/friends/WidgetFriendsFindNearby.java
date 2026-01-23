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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.friends.NearbyManager;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.button.MaterialButton;
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
import p000.C12574j;
import p000.WidgetFriendsAddUserRequestsModel;
import p000.WidgetFriendsAddUserRequestsModel2;
import p000.WidgetFriendsAddUserRequestsModel3;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetFriendsFindNearby.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private Long meUserId;
    private final NearbyManager nearbyManager;
    private WidgetFriendsAddUserAdapter resultsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static abstract class Model {

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
        public static final class Empty extends Model {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
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

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public final Error copy(Integer errorCode) {
                return new Error(errorCode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && Intrinsics3.areEqual(this.errorCode, ((Error) other).errorCode);
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
                return outline.m818F(outline.m833U("Error(errorCode="), this.errorCode, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
        public static final /* data */ class NearbyUsers extends Model {
            private final List<WidgetFriendsAddUserAdapter.ItemUser> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NearbyUsers(List<WidgetFriendsAddUserAdapter.ItemUser> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
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
                Intrinsics3.checkNotNullParameter(items, "items");
                return new NearbyUsers(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof NearbyUsers) && Intrinsics3.areEqual(this.items, ((NearbyUsers) other).items);
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
                return outline.m824L(outline.m833U("NearbyUsers(items="), this.items, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
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

    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public static final /* synthetic */ Observable access$getUserModels(ModelProvider modelProvider, Collection collection) {
            return modelProvider.getUserModels(collection);
        }

        private final Observable<Model.NearbyUsers> getUserModels(Collection<Long> userIds) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model.NearbyUsers> observableM11075i = Observable.m11075i(companion.getUsers().observeUsers(userIds, true), companion.getPresences().observePresencesForUsers(userIds), companion.getUserRelationships().observe(userIds), WidgetFriendsFindNearby3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable\n          .co…yUsers(items)\n          }");
            return observableM11075i;
        }

        public final Observable<Model> get(Observable<NearbyManager.NearbyState> nearbyStateObservable) {
            Intrinsics3.checkNotNullParameter(nearbyStateObservable, "nearbyStateObservable");
            Observable observableM11099Y = nearbyStateObservable.m11099Y(WidgetFriendsFindNearby2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "nearbyStateObservable\n  …          }\n            }");
            return observableM11099Y;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$acceptFriendRequest$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83861 extends Lambda implements Function1<Void, Unit> {
        public C83861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            AppToast.m169g(WidgetFriendsFindNearby.this.getContext(), C5419R.string.accept_request_button_after, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$declineFriendRequest$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83871 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83871(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            AppToast.m169g(WidgetFriendsFindNearby.this.getContext(), this.$successMessageStringRes, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83881 extends Lambda implements Function2<String, Integer, Unit> {
        public C83881() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
            invoke(str, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(String str, int i) {
            Intrinsics3.checkNotNullParameter(str, "username");
            WidgetFriendsFindNearby.sendFriendRequest$default(WidgetFriendsFindNearby.this, str, i, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83892 extends Lambda implements Function1<Long, Unit> {
        public C83892() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetFriendsFindNearby.access$acceptFriendRequest(WidgetFriendsFindNearby.this, j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83903 extends Lambda implements Function2<Long, Boolean, Unit> {
        public C83903() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetFriendsFindNearby.access$declineFriendRequest(WidgetFriendsFindNearby.this, j, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83914 extends Lambda implements Function1<Long, Unit> {
        public C83914() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetFriendsFindNearby.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class ViewOnClickListenerC83925 implements View.OnClickListener {
        public ViewOnClickListenerC83925() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsFindNearby.access$enableScanning(WidgetFriendsFindNearby.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$6 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class ViewOnClickListenerC83936 implements View.OnClickListener {
        public static final ViewOnClickListenerC83936 INSTANCE = new ViewOnClickListenerC83936();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.m885x(view, "it", "it.context"), AppHelpDesk.f507a.m149a(360014894392L, null), false, false, null, 28, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83941 extends Lambda implements Function1<WidgetFriendsAddUserRequestsModel, Unit> {
        public C83941() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            invoke2(widgetFriendsAddUserRequestsModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            WidgetFriendsFindNearby.access$getResultsAdapter$p(WidgetFriendsFindNearby.this).addFriendRequestUserIds(widgetFriendsAddUserRequestsModel.outgoingIds, widgetFriendsAddUserRequestsModel.incomingIds);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83952 extends Lambda implements Function1<Model, Unit> {
        public C83952() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetFriendsFindNearby.access$configureUI(WidgetFriendsFindNearby.this, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$1 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83961<T> implements Action1<Void> {
        public final /* synthetic */ String $username;

        public C83961(String str) {
            this.$username = str;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r7) {
            Context context = WidgetFriendsFindNearby.this.getContext();
            Context context2 = WidgetFriendsFindNearby.this.getContext();
            AppToast.m170h(context, context2 != null ? FormatUtils.m216h(context2, C5419R.string.add_friend_confirmation, new Object[]{this.$username}, null, 4) : null, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$2 */
    /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
    public static final class C83972<T> implements Action1<Error> {
        public final /* synthetic */ int $discriminator;
        public final /* synthetic */ String $username;

        /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Error error = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                if (WidgetCaptcha4.isCaptchaError(error)) {
                    WidgetFriendsFindNearby widgetFriendsFindNearby = WidgetFriendsFindNearby.this;
                    Error error2 = this.$error;
                    Intrinsics3.checkNotNullExpressionValue(error2, "error");
                    WidgetFriendsFindNearby.access$launchCaptchaFlow(widgetFriendsFindNearby, error2);
                    return;
                }
                RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                Context context = WidgetFriendsFindNearby.this.getContext();
                Error error3 = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error3, "error");
                Error.Response response = error3.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                AppToast.m170h(WidgetFriendsFindNearby.this.getContext(), responseResolver.getRelationshipResponse(context, response.getCode(), C83972.this.$username + MentionUtils.CHANNELS_CHAR + UserUtils.INSTANCE.padDiscriminator(C83972.this.$discriminator)), 0, null, 12);
            }
        }

        public C83972(String str, int i) {
            this.$username = str;
            this.$discriminator = i;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    public WidgetFriendsFindNearby() {
        super(C5419R.layout.widget_friends_nearby);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFriendsFindNearby4.INSTANCE, null, 2, null);
        WidgetFriendsFindNearby6 widgetFriendsFindNearby6 = WidgetFriendsFindNearby6.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetFriendsFindNearbyViewModel.class), new WidgetFriendsFindNearby$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFriendsFindNearby6));
        this.nearbyManager = new NearbyManager();
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetFriendsFindNearby5(this));
    }

    private final void acceptFriendRequest(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(RestAPI.INSTANCE.getApi(), "Nearby - Accept Friend Request", userId, null, null, null, 28, null), false, 1, null), this, null, 2, null), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C83861(), 62, (Object) null);
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
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
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
            TextView textView = getBinding().f16692g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.nearbyFriendsSearchingTitle");
            textView.setText(getString(C5419R.string.add_friend_nearby_title));
            TextView textView2 = getBinding().f16690e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nearbyFriendsSearchingBody");
            textView2.setText(getString(C5419R.string.add_friend_nearby_body));
            TextView textView3 = getBinding().f16690e;
            TextView textView4 = getBinding().f16690e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.nearbyFriendsSearchingBody");
            textView3.setTextColor(ColorCompat.getThemedColor(textView4, C5419R.attr.colorHeaderSecondary));
            MaterialButton materialButton = getBinding().f16687b;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.nearbyFriendsEnable");
            materialButton.setVisibility(0);
            RecyclerView recyclerView = getBinding().f16689d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
            recyclerView.setVisibility(8);
            RLottieImageView rLottieImageView = getBinding().f16691f;
            RLottieDrawable rLottieDrawable = rLottieImageView.drawable;
            if (rLottieDrawable == null) {
                return;
            }
            rLottieImageView.playing = false;
            if (rLottieImageView.attachedToWindow) {
                rLottieDrawable.f18711P = false;
                return;
            }
            return;
        }
        if (model instanceof Model.Error) {
            TextView textView5 = getBinding().f16692g;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.nearbyFriendsSearchingTitle");
            textView5.setText(getString(C5419R.string.add_friend_nearby_title));
            TextView textView6 = getBinding().f16690e;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.nearbyFriendsSearchingBody");
            textView6.setText(getErrorMessage(((Model.Error) model).getErrorCode()));
            TextView textView7 = getBinding().f16690e;
            TextView textView8 = getBinding().f16690e;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.nearbyFriendsSearchingBody");
            textView7.setTextColor(ColorCompat.getColor(textView8, C5419R.color.status_red_500));
            MaterialButton materialButton2 = getBinding().f16687b;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.nearbyFriendsEnable");
            materialButton2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().f16689d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.nearbyFriendsRecycler");
            recyclerView2.setVisibility(8);
            RLottieImageView rLottieImageView2 = getBinding().f16691f;
            RLottieDrawable rLottieDrawable2 = rLottieImageView2.drawable;
            if (rLottieDrawable2 == null) {
                return;
            }
            rLottieImageView2.playing = false;
            if (rLottieImageView2.attachedToWindow) {
                rLottieDrawable2.f18711P = false;
                return;
            }
            return;
        }
        if (model instanceof Model.Empty) {
            TextView textView9 = getBinding().f16692g;
            Intrinsics3.checkNotNullExpressionValue(textView9, "binding.nearbyFriendsSearchingTitle");
            textView9.setText(getString(C5419R.string.add_friend_nearby_title));
            TextView textView10 = getBinding().f16690e;
            Intrinsics3.checkNotNullExpressionValue(textView10, "binding.nearbyFriendsSearchingBody");
            textView10.setText(getString(C5419R.string.add_friend_nearby_body));
            TextView textView11 = getBinding().f16690e;
            TextView textView12 = getBinding().f16690e;
            Intrinsics3.checkNotNullExpressionValue(textView12, "binding.nearbyFriendsSearchingBody");
            textView11.setTextColor(ColorCompat.getThemedColor(textView12, C5419R.attr.colorHeaderSecondary));
            MaterialButton materialButton3 = getBinding().f16687b;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.nearbyFriendsEnable");
            materialButton3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().f16689d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.nearbyFriendsRecycler");
            recyclerView3.setVisibility(8);
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                return;
            }
            getBinding().f16691f.m8449b();
            return;
        }
        if (model instanceof Model.NearbyUsers) {
            TextView textView13 = getBinding().f16692g;
            Intrinsics3.checkNotNullExpressionValue(textView13, "binding.nearbyFriendsSearchingTitle");
            textView13.setText(getString(C5419R.string.add_friend_nearby_found_title));
            TextView textView14 = getBinding().f16690e;
            Intrinsics3.checkNotNullExpressionValue(textView14, "binding.nearbyFriendsSearchingBody");
            textView14.setText(getString(C5419R.string.add_friend_nearby_found_body));
            TextView textView15 = getBinding().f16690e;
            TextView textView16 = getBinding().f16690e;
            Intrinsics3.checkNotNullExpressionValue(textView16, "binding.nearbyFriendsSearchingBody");
            textView15.setTextColor(ColorCompat.getThemedColor(textView16, C5419R.attr.colorHeaderSecondary));
            MaterialButton materialButton4 = getBinding().f16687b;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.nearbyFriendsEnable");
            materialButton4.setVisibility(8);
            WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
            if (widgetFriendsAddUserAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
            }
            widgetFriendsAddUserAdapter.setData(((Model.NearbyUsers) model).getItems());
            RecyclerView recyclerView4 = getBinding().f16689d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.nearbyFriendsRecycler");
            recyclerView4.setVisibility(0);
        }
    }

    private final void declineFriendRequest(long userId, boolean incomingFriendRequest) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeRelationship("Nearby - Remove Friend Request", userId), false, 1, null), this, null, 2, null), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C83871(incomingFriendRequest ? C5419R.string.friend_request_ignored : C5419R.string.friend_request_cancelled), 62, (Object) null);
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
                return context.getString(C5419R.string.add_friend_nearby_connection_error);
            }
            return null;
        }
        if (resultCode != null && resultCode.intValue() == 98) {
            Context context2 = getContext();
            if (context2 != null) {
                return context2.getString(C5419R.string.add_friend_nearby_stopped);
            }
            return null;
        }
        Context context3 = getContext();
        if (context3 != null) {
            return context3.getString(C5419R.string.add_friend_nearby_generic_error);
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
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Nearby - Add Friend Suggestion", username, discriminator, captchaPayload), this, null, 2, null).m11108k(C0879o.m181h(new C83961(username), getAppActivity(), new C83972(username, discriminator)));
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        updateMeUserIdAndInitNearbyManager();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16689d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = (WidgetFriendsAddUserAdapter) companion.configure(new WidgetFriendsAddUserAdapter(recyclerView));
        this.resultsAdapter = widgetFriendsAddUserAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter.setSendHandler(new C83881());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter2 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter2.setAcceptHandler(new C83892());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter3 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter3.setDeclineHandler(new C83903());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter4 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter4.setOnItemClick(new C83914());
        getBinding().f16687b.setOnClickListener(new ViewOnClickListenerC83925());
        getBinding().f16688c.setOnClickListener(ViewOnClickListenerC83936.INSTANCE);
        getBinding().f16691f.m8450c(C5419R.raw.anim_friends_add_nearby_looking, DimenUtils.dpToPixels(200), DimenUtils.dpToPixels(200));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<R> observableM11083G = companion.getUserRelationships().observeForType(4).m11083G(C12574j.f26680j);
        Observable<R> observableM11083G2 = companion.getUserRelationships().observeForType(3).m11083G(C12574j.f26681k);
        WidgetFriendsAddUserRequestsModel2 widgetFriendsAddUserRequestsModel2 = WidgetFriendsAddUserRequestsModel2.f27929j;
        Object widgetFriendsAddUserRequestsModel3 = widgetFriendsAddUserRequestsModel2;
        if (widgetFriendsAddUserRequestsModel2 != null) {
            widgetFriendsAddUserRequestsModel3 = new WidgetFriendsAddUserRequestsModel3(widgetFriendsAddUserRequestsModel2);
        }
        Observable observableM11076j = Observable.m11076j(observableM11083G, observableM11083G2, (Func2) widgetFriendsAddUserRequestsModel3);
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…erRequestsModel\n        )");
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observableM11076j).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null).m11108k(C0879o.f566a.m184g(getContext(), new C83941(), null));
        Observable<Model> observable = ModelProvider.INSTANCE.get(this.nearbyManager.getState());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8519ui(observable, this, widgetFriendsAddUserAdapter), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C83952(), 62, (Object) null);
    }
}

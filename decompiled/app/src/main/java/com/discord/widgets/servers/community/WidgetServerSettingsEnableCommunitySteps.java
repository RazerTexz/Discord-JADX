package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Func0;

/* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsEnableCommunitySteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.m156d(context, WidgetServerSettingsEnableCommunitySteps.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$1 */
    public static final class C93971 extends Lambda implements Function0<Unit> {
        public C93971() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity activity = WidgetServerSettingsEnableCommunitySteps.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$2 */
    public static final class C93982 extends Lambda implements Function1<Integer, Unit> {
        public C93982() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetServerSettingsEnableCommunitySteps.access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps.this).updateCurrentPage(i);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$3 */
    public static final class C93993<R> implements Func0<Boolean> {
        public C93993() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetServerSettingsEnableCommunitySteps.access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps.this).goBackToPreviousPage();
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C94021 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState, Unit> {
        public C94021(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
            super(1, widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunitySteps.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetServerSettingsEnableCommunitySteps.access$configureUI((WidgetServerSettingsEnableCommunitySteps) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$2 */
    public static final class C94032 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public C94032() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "it");
            int currentPage = loaded.getCurrentPage();
            if (currentPage < 0) {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
            } else {
                WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f16583b.m8610b(currentPage);
            }
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f16583b.setIsNextButtonEnabled(loaded.getCommunityGuildConfig().getExplicitContentFilter() && loaded.getCommunityGuildConfig().getVerificationLevel());
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f16583b.setIsDoneButtonEnabled(loaded.getCommunityGuildConfig().isPrivacyPolicyAccepted());
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f16583b.setIsLoading(loaded.isLoading());
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$3 */
    public static final class C94043 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.Event, Unit> {
        public C94043() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (!Intrinsics3.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.SaveSuccess.INSTANCE)) {
                if (Intrinsics3.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.Error.INSTANCE)) {
                    AppToast.m171i(WidgetServerSettingsEnableCommunitySteps.this, C5419R.string.guild_settings_public_update_failed, 0, 4);
                }
            } else {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
                WidgetServerSettingsCommunityOverview.Companion companion = WidgetServerSettingsCommunityOverview.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsEnableCommunitySteps.this.requireActivity();
                Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsEnableCommunitySteps.this.getGuildId());
            }
        }
    }

    public WidgetServerSettingsEnableCommunitySteps() {
        super(C5419R.layout.widget_enable_community_steps);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEnableCommunitySteps2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9395x4876c14a(this), new AppViewModelDelegates2(new WidgetServerSettingsEnableCommunitySteps5(this)));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsEnableCommunitySteps3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
        widgetServerSettingsEnableCommunitySteps.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetEnableCommunityStepsBinding access$getBinding$p(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        return widgetServerSettingsEnableCommunitySteps.getBinding();
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        return widgetServerSettingsEnableCommunitySteps.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetServerSettingsEnableCommunityViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        }
    }

    private final WidgetEnableCommunityStepsBinding getBinding() {
        return (WidgetEnableCommunityStepsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f16583b.m8609a(new StepsView.C7125d(this, Collections2.listOf((Object[]) new StepsView.AbstractC7123b.a[]{new StepsView.AbstractC7123b.a(WidgetServerSettingsEnableCommunity.class, 0, 0, 0, null, null, null, null, false, false, false, 254), new StepsView.AbstractC7123b.a(WidgetServerSettingsCommunityFirstStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.AbstractC7123b.a(WidgetServerSettingsCommunitySecondStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.AbstractC7123b.a(WidgetServerSettingsCommunityThirdStep.class, 0, 0, C5419R.string.enable_community_button_text, null, null, null, new WidgetServerSettingsEnableCommunitySteps4(this), false, false, false, 374)})), new C93971(), new C93982());
        AppFragment.setOnBackPressed$default(this, new C93993(), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetServerSettingsEnableCommunityViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C94021(this), 62, (Object) null);
        Observable observableM11083G = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11118y(C9400x2efa3158.INSTANCE).m11083G(C9401x2efa3159.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableM11083G, WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C94032(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C94043(), 62, (Object) null);
    }
}

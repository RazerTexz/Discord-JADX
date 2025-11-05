package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import d0.g;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEnableCommunitySteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0)};

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
            m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            j.d(context, WidgetServerSettingsEnableCommunitySteps.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetServerSettingsEnableCommunitySteps.access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps.this).updateCurrentPage(i);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3<R> implements Func0<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetServerSettingsEnableCommunitySteps.access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps.this).goBackToPreviousPage();
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
            super(1, widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunitySteps.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetServerSettingsEnableCommunitySteps.access$configureUI((WidgetServerSettingsEnableCommunitySteps) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            m.checkNotNullParameter(loaded, "it");
            int currentPage = loaded.getCurrentPage();
            if (currentPage < 0) {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
            } else {
                WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f2378b.b(currentPage);
            }
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f2378b.setIsNextButtonEnabled(loaded.getCommunityGuildConfig().getExplicitContentFilter() && loaded.getCommunityGuildConfig().getVerificationLevel());
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f2378b.setIsDoneButtonEnabled(loaded.getCommunityGuildConfig().isPrivacyPolicyAccepted());
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(WidgetServerSettingsEnableCommunitySteps.this).f2378b.setIsLoading(loaded.isLoading());
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<WidgetServerSettingsEnableCommunityViewModel.Event, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            m.checkNotNullParameter(event, "event");
            if (!m.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.SaveSuccess.INSTANCE)) {
                if (m.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.Error.INSTANCE)) {
                    b.a.d.m.i(WidgetServerSettingsEnableCommunitySteps.this, R.string.guild_settings_public_update_failed, 0, 4);
                }
            } else {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
                WidgetServerSettingsCommunityOverview.Companion companion = WidgetServerSettingsCommunityOverview.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsEnableCommunitySteps.this.requireActivity();
                m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsEnableCommunitySteps.this.getGuildId());
            }
        }
    }

    public WidgetServerSettingsEnableCommunitySteps() {
        super(R.layout.widget_enable_community_steps);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEnableCommunitySteps$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsEnableCommunitySteps$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetServerSettingsEnableCommunitySteps$viewModel$2(this)));
        this.guildId = g.lazy(new WidgetServerSettingsEnableCommunitySteps$guildId$2(this));
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
        if (m.areEqual(viewState, WidgetServerSettingsEnableCommunityViewModel.ViewState.Invalid.INSTANCE)) {
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2378b.a(new StepsView.d(this, n.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetServerSettingsEnableCommunity.class, 0, 0, 0, null, null, null, null, false, false, false, 254), new StepsView.b.a(WidgetServerSettingsCommunityFirstStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.b.a(WidgetServerSettingsCommunitySecondStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.b.a(WidgetServerSettingsCommunityThirdStep.class, 0, 0, R.string.enable_community_button_text, null, null, null, new WidgetServerSettingsEnableCommunitySteps$onViewBound$steps$1(this), false, false, false, 374)})), new AnonymousClass1(), new AnonymousClass2());
        AppFragment.setOnBackPressed$default(this, new AnonymousClass3(), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetServerSettingsEnableCommunityViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}

package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetPruneUsersBinding;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.user.WidgetPruneUsersViewModel;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetPruneUsers.kt */
/* loaded from: classes.dex */
public final class WidgetPruneUsers extends AppDialog {
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: radioManager$delegate, reason: from kotlin metadata */
    private final Lazy radioManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetPruneUsers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPruneUsersBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetPruneUsers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(long guildId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetPruneUsers widgetPruneUsers = new WidgetPruneUsers();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetPruneUsers.ARG_GUILD_ID, guildId);
            widgetPruneUsers.setArguments(bundle);
            widgetPruneUsers.show(fragmentManager, WidgetPruneUsers.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetPruneUsersViewModel.PruneDays.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetPruneUsersViewModel.PruneDays.Seven.ordinal()] = 1;
            iArr[WidgetPruneUsersViewModel.PruneDays.Thirty.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetPruneUsers.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Context, Integer, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ CharSequence invoke(Context context, Integer num) {
            return invoke(context, num.intValue());
        }

        public final CharSequence invoke(Context context, int i) {
            Intrinsics3.checkNotNullParameter(context, "$this$formatLastSeenDays");
            return FormatUtils.h(context, R.string.last_seen, new Object[]{StringResourceUtils.getI18nPluralString(context, R.plurals.last_seen_days, i, Integer.valueOf(i))}, null, 4);
        }
    }

    /* compiled from: WidgetPruneUsers.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPruneUsers.this.dismiss();
        }
    }

    /* compiled from: WidgetPruneUsers.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPruneUsers.access$getViewModel$p(WidgetPruneUsers.this).pruneClicked();
        }
    }

    /* compiled from: WidgetPruneUsers.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetPruneUsersViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetPruneUsers widgetPruneUsers) {
            super(1, widgetPruneUsers, WidgetPruneUsers.class, "updateUI", "updateUI(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetPruneUsersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetPruneUsersViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetPruneUsers.access$updateUI((WidgetPruneUsers) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetPruneUsers.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetPruneUsersViewModel.Event, Unit> {
        public AnonymousClass2(WidgetPruneUsers widgetPruneUsers) {
            super(1, widgetPruneUsers, WidgetPruneUsers.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetPruneUsersViewModel.Event event) throws Throwable {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetPruneUsersViewModel.Event event) throws Throwable {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetPruneUsers.access$handleEvent((WidgetPruneUsers) this.receiver, event);
        }
    }

    public WidgetPruneUsers() {
        super(R.layout.widget_prune_users);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPruneUsers2.INSTANCE, null, 2, null);
        this.radioManager = LazyJVM.lazy(new WidgetPruneUsers5(this));
        WidgetPruneUsers6 widgetPruneUsers6 = new WidgetPruneUsers6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetPruneUsersViewModel.class), new WidgetPruneUsers$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetPruneUsers6));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetPruneUsers widgetPruneUsers) {
        return widgetPruneUsers.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetPruneUsersBinding access$getBinding$p(WidgetPruneUsers widgetPruneUsers) {
        return widgetPruneUsers.getBinding();
    }

    public static final /* synthetic */ WidgetPruneUsersViewModel access$getViewModel$p(WidgetPruneUsers widgetPruneUsers) {
        return widgetPruneUsers.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetPruneUsers widgetPruneUsers, WidgetPruneUsersViewModel.Event event) throws Throwable {
        widgetPruneUsers.handleEvent(event);
    }

    public static final /* synthetic */ void access$updateUI(WidgetPruneUsers widgetPruneUsers, WidgetPruneUsersViewModel.ViewState viewState) {
        widgetPruneUsers.updateUI(viewState);
    }

    public static final void create(long j, FragmentManager fragmentManager) {
        INSTANCE.create(j, fragmentManager);
    }

    private final WidgetPruneUsersBinding getBinding() {
        return (WidgetPruneUsersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final RadioManager getRadioManager() {
        return (RadioManager) this.radioManager.getValue();
    }

    private final WidgetPruneUsersViewModel getViewModel() {
        return (WidgetPruneUsersViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetPruneUsersViewModel.Event event) throws Throwable {
        Unit unit;
        if (event instanceof WidgetPruneUsersViewModel.Event.Dismiss) {
            dismiss();
            unit = Unit.a;
        } else {
            if (!(event instanceof WidgetPruneUsersViewModel.Event.RestClientFailed)) {
                throw new NoWhenBranchMatchedException();
            }
            Error.handle(((WidgetPruneUsersViewModel.Event.RestClientFailed) event).getThrowable(), "restClient", null, getContext());
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final void updateUI(WidgetPruneUsersViewModel.ViewState state) {
        Unit unit;
        CheckedSetting checkedSetting;
        if (state instanceof WidgetPruneUsersViewModel.ViewState.Loading) {
            StringBuilder sb = new StringBuilder();
            sb.append(FormatUtils.k(this, R.string.prune_members, new Object[0], null, 4));
            sb.append(" - ");
            WidgetPruneUsersViewModel.ViewState.Loading loading = (WidgetPruneUsersViewModel.ViewState.Loading) state;
            sb.append(loading.getGuildName());
            String string = sb.toString();
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.pruneUserHeader");
            textView.setText(string);
            int iOrdinal = loading.getWhichPruneDays().ordinal();
            if (iOrdinal == 0) {
                checkedSetting = getBinding().f;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                checkedSetting = getBinding().g;
            }
            RadioManager radioManager = getRadioManager();
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "button");
            radioManager.a(checkedSetting);
            ProgressBar progressBar = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.pruneUsersLoadingProgressbar");
            progressBar.setVisibility(0);
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.pruneUsersEstimateText");
            textView2.setVisibility(8);
            MaterialButton materialButton = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.pruneUserPrune");
            ViewExtensions.disable(materialButton);
            unit = Unit.a;
        } else if (state instanceof WidgetPruneUsersViewModel.ViewState.Loaded) {
            ProgressBar progressBar2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.pruneUsersLoadingProgressbar");
            progressBar2.setVisibility(8);
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPruneUsersViewModel.ViewState.Loaded loaded = (WidgetPruneUsersViewModel.ViewState.Loaded) state;
            CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(contextRequireContext, R.plurals.form_help_last_seen_1_members, loaded.getPruneCount(), Integer.valueOf(loaded.getPruneCount()));
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            CharSequence i18nPluralString2 = StringResourceUtils.getI18nPluralString(contextRequireContext2, R.plurals.form_help_last_seen_1_days, loaded.getPruneDays().getCount(), Integer.valueOf(loaded.getPruneDays().getCount()));
            TextView textView3 = getBinding().e;
            FormatUtils.n(textView3, R.string.form_help_last_seen_1, new Object[]{i18nPluralString, i18nPluralString2}, null, 4);
            textView3.setVisibility(0);
            MaterialButton materialButton2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.pruneUserPrune");
            materialButton2.setEnabled(loaded.getPruneButtonEnabled());
            unit = Unit.a;
        } else {
            if (!(state instanceof WidgetPruneUsersViewModel.ViewState.LoadFailed)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((WidgetPruneUsersViewModel.ViewState.LoadFailed) state).getDismiss()) {
                dismiss();
                unit = Unit.a;
            } else {
                ProgressBar progressBar3 = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(progressBar3, "binding.pruneUsersLoadingProgressbar");
                progressBar3.setVisibility(8);
                TextView textView4 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.pruneUsersEstimateText");
                textView4.setVisibility(8);
                MaterialButton materialButton3 = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.pruneUserPrune");
                ViewExtensions.disable(materialButton3);
                unit = Unit.a;
            }
        }
        KotlinExtensions.getExhaustive(unit);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        CheckedSetting checkedSetting = getBinding().f;
        Context context = checkedSetting.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        checkedSetting.setText(anonymousClass1.invoke(context, 7));
        checkedSetting.e(new WidgetPruneUsers3(this));
        CheckedSetting checkedSetting2 = getBinding().g;
        Context context2 = checkedSetting2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        checkedSetting2.setText(anonymousClass1.invoke(context2, 30));
        checkedSetting2.e(new WidgetPruneUsers4(this));
        getBinding().f2514b.setOnClickListener(new AnonymousClass4());
        getBinding().d.setOnClickListener(new AnonymousClass5());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetPruneUsersViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetPruneUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetPruneUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}

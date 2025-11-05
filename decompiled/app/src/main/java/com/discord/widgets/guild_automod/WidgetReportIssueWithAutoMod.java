package com.discord.widgets.guild_automod;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetReportIssueWithAutomodBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetReportIssueWithAutoMod.kt */
/* loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetReportIssueWithAutoMod.class, "binding", "getBinding()Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: messageId$delegate, reason: from kotlin metadata */
    private final Lazy messageId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId, long messageId) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            j.d(context, WidgetReportIssueWithAutoMod.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureOption$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ FeedbackType $settingValue;

        public AnonymousClass1(FeedbackType feedbackType) {
            this.$settingValue = feedbackType;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetReportIssueWithAutoMod.access$getViewModel$p(WidgetReportIssueWithAutoMod.this).onFeedbackTypeSelected(this.$settingValue);
        }
    }

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetReportIssueWithAutoMod.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetReportIssueWithAutoMod.kt */
        /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureUI$2$1, reason: invalid class name */
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
                FragmentActivity activity = WidgetReportIssueWithAutoMod.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetReportIssueWithAutoMod.access$getViewModel$p(WidgetReportIssueWithAutoMod.this).onSubmit(new AnonymousClass1());
        }
    }

    /* compiled from: WidgetReportIssueWithAutoMod.kt */
    /* renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ReportIssueWithAutoModViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportIssueWithAutoModViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportIssueWithAutoModViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetReportIssueWithAutoMod.this.configureUI(viewState);
        }
    }

    public WidgetReportIssueWithAutoMod() {
        super(R.layout.widget_report_issue_with_automod);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetReportIssueWithAutoMod$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetReportIssueWithAutoMod$channelId$2(this));
        this.messageId = g.lazy(new WidgetReportIssueWithAutoMod$messageId$2(this));
        WidgetReportIssueWithAutoMod$viewModel$2 widgetReportIssueWithAutoMod$viewModel$2 = new WidgetReportIssueWithAutoMod$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ReportIssueWithAutoModViewModel.class), new WidgetReportIssueWithAutoMod$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetReportIssueWithAutoMod$viewModel$2));
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getChannelId();
    }

    public static final /* synthetic */ long access$getMessageId$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getMessageId();
    }

    public static final /* synthetic */ ReportIssueWithAutoModViewModel access$getViewModel$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getViewModel();
    }

    private final void configureOption(ReportIssueWithAutoModViewModel.ViewState.Valid viewState, CheckedSetting setting, FeedbackType settingValue) {
        setting.setChecked(m.areEqual(viewState.getSelectedOption(), settingValue.getValue()));
        setting.e(new AnonymousClass1(settingValue));
    }

    private final WidgetReportIssueWithAutomodBinding getBinding() {
        return (WidgetReportIssueWithAutomodBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getMessageId() {
        return ((Number) this.messageId.getValue()).longValue();
    }

    private final ReportIssueWithAutoModViewModel getViewModel() {
        return (ReportIssueWithAutoModViewModel) this.viewModel.getValue();
    }

    public final void configureUI(ReportIssueWithAutoModViewModel.ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        getBinding().f2520b.setOnClickListener(new AnonymousClass1());
        getBinding().e.setOnClickListener(new AnonymousClass2());
        if (viewState instanceof ReportIssueWithAutoModViewModel.ViewState.Valid) {
            ReportIssueWithAutoModViewModel.ViewState.Valid valid = (ReportIssueWithAutoModViewModel.ViewState.Valid) viewState;
            CheckedSetting checkedSetting = getBinding().c;
            m.checkNotNullExpressionValue(checkedSetting, "binding.option1");
            configureOption(valid, checkedSetting, FeedbackType.ALLOWED);
            CheckedSetting checkedSetting2 = getBinding().d;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.option2");
            configureOption(valid, checkedSetting2, FeedbackType.BUG);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetReportIssueWithAutoMod.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

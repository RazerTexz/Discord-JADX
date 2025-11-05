package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventCreateSuccessBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.GuildInviteUiHelperKt;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel;
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
import rx.Observable;

/* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventCreateSuccess.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: guildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy guildScheduledEventId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, Long channelId, long guildId, long guildScheduledEventId) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            j.d(context, WidgetGuildScheduledEventCreateSuccess.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass1(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildInviteUiHelperKt.copyLinkClick(a.x(view, "it", "it.context"), this.$invite, WidgetGuildScheduledEventCreateSuccess.this.getMostRecentIntent());
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Experiment $inviteExperiment;
        public final /* synthetic */ WidgetInviteModel $widgetInviteModel;

        public AnonymousClass2(WidgetInviteModel widgetInviteModel, Experiment experiment) {
            this.$widgetInviteModel = widgetInviteModel;
            this.$inviteExperiment = experiment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            WidgetGuildScheduledEventCreateSuccess.access$getBinding$p(WidgetGuildScheduledEventCreateSuccess.this).d.toggle();
            ModelInvite.Settings settings = this.$widgetInviteModel.getSettings();
            if (settings != null) {
                WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModelAccess$getViewModel$p = WidgetGuildScheduledEventCreateSuccess.access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess.this);
                CheckedSetting checkedSetting = WidgetGuildScheduledEventCreateSuccess.access$getBinding$p(WidgetGuildScheduledEventCreateSuccess.this).d;
                m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
                if (checkedSetting.isChecked()) {
                    i = 0;
                } else {
                    Experiment experiment = this.$inviteExperiment;
                    i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite.Settings.SEVEN_DAYS;
                }
                ModelInvite.Settings settingsMergeMaxAge = settings.mergeMaxAge(i);
                m.checkNotNullExpressionValue(settingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
                widgetGuildScheduledEventCreateSuccessViewModelAccess$getViewModel$p.updateInviteSettings(settingsMergeMaxAge);
            }
            Channel targetChannel = this.$widgetInviteModel.getTargetChannel();
            if (targetChannel != null) {
                WidgetGuildScheduledEventCreateSuccess.access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess.this).generateInviteLink(Long.valueOf(Long.valueOf(targetChannel.getId()).longValue()));
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetGuildScheduledEventCreateSuccess.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass4(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelperKt.shareLinkClick(WidgetGuildScheduledEventCreateSuccess.this.getContext(), modelInvite);
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            m.checkNotNullParameter(loaded, "viewState");
            WidgetGuildScheduledEventCreateSuccess.access$configureUI(WidgetGuildScheduledEventCreateSuccess.this, loaded);
        }
    }

    public WidgetGuildScheduledEventCreateSuccess() {
        super(R.layout.widget_guild_scheduled_event_create_success);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventCreateSuccess$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetGuildScheduledEventCreateSuccess$channelId$2(this));
        this.guildId = g.lazy(new WidgetGuildScheduledEventCreateSuccess$guildId$2(this));
        this.guildScheduledEventId = g.lazy(new WidgetGuildScheduledEventCreateSuccess$guildScheduledEventId$2(this));
        WidgetGuildScheduledEventCreateSuccess$viewModel$2 widgetGuildScheduledEventCreateSuccess$viewModel$2 = new WidgetGuildScheduledEventCreateSuccess$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildScheduledEventCreateSuccessViewModel.class), new WidgetGuildScheduledEventCreateSuccess$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventCreateSuccess$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess, WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
        widgetGuildScheduledEventCreateSuccess.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventCreateSuccessBinding access$getBinding$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getBinding();
    }

    public static final /* synthetic */ Long access$getChannelId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getGuildId();
    }

    public static final /* synthetic */ long access$getGuildScheduledEventId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getGuildScheduledEventId();
    }

    public static final /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getViewModel();
    }

    private final void configureUI(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.guildInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().c.setOnClickListener(new AnonymousClass1(invite));
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.i(getBinding().d, GuildInviteUiHelperKt.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().d.e(new AnonymousClass2(widgetInviteModel, defaultInviteExperiment));
        getBinding().f2442b.setOnClickListener(new AnonymousClass3());
        getBinding().e.setOnClickListener(new AnonymousClass4(invite));
    }

    private final WidgetGuildScheduledEventCreateSuccessBinding getBinding() {
        return (WidgetGuildScheduledEventCreateSuccessBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getChannelId() {
        return (Long) this.channelId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildScheduledEventId() {
        return ((Number) this.guildScheduledEventId.getValue()).longValue();
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildScheduledEventCreateSuccessViewModel getViewModel() {
        return (WidgetGuildScheduledEventCreateSuccessViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<R> observableG = getViewModel().observeViewState().y(WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), WidgetGuildScheduledEventCreateSuccess.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getViewModel().generateInviteLink(getChannelId());
    }
}

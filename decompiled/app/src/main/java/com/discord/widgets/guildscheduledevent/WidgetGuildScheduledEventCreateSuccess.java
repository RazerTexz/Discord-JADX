package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventCreateSuccessBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.GuildInviteUiHelper;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildScheduledEventCreateSuccess.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: guildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy guildScheduledEventId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, Long channelId, long guildId, long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            AppScreen2.m156d(context, WidgetGuildScheduledEventCreateSuccess.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class ViewOnClickListenerC88451 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public ViewOnClickListenerC88451(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildInviteUiHelper.copyLinkClick(outline.m885x(view, "it", "it.context"), this.$invite, WidgetGuildScheduledEventCreateSuccess.this.getMostRecentIntent());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$2 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class ViewOnClickListenerC88462 implements View.OnClickListener {
        public final /* synthetic */ Experiment $inviteExperiment;
        public final /* synthetic */ WidgetInviteModel $widgetInviteModel;

        public ViewOnClickListenerC88462(WidgetInviteModel widgetInviteModel, Experiment experiment) {
            this.$widgetInviteModel = widgetInviteModel;
            this.$inviteExperiment = experiment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            WidgetGuildScheduledEventCreateSuccess.access$getBinding$p(WidgetGuildScheduledEventCreateSuccess.this).f16977d.toggle();
            ModelInvite.Settings settings = this.$widgetInviteModel.getSettings();
            if (settings != null) {
                WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModelAccess$getViewModel$p = WidgetGuildScheduledEventCreateSuccess.access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess.this);
                CheckedSetting checkedSetting = WidgetGuildScheduledEventCreateSuccess.access$getBinding$p(WidgetGuildScheduledEventCreateSuccess.this).f16977d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
                if (checkedSetting.isChecked()) {
                    i = 0;
                } else {
                    Experiment experiment = this.$inviteExperiment;
                    i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite.Settings.SEVEN_DAYS;
                }
                ModelInvite.Settings settingsMergeMaxAge = settings.mergeMaxAge(i);
                Intrinsics3.checkNotNullExpressionValue(settingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
                widgetGuildScheduledEventCreateSuccessViewModelAccess$getViewModel$p.updateInviteSettings(settingsMergeMaxAge);
            }
            Channel targetChannel = this.$widgetInviteModel.getTargetChannel();
            if (targetChannel != null) {
                WidgetGuildScheduledEventCreateSuccess.access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess.this).generateInviteLink(Long.valueOf(Long.valueOf(targetChannel.getId()).longValue()));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$3 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class ViewOnClickListenerC88473 implements View.OnClickListener {
        public ViewOnClickListenerC88473() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetGuildScheduledEventCreateSuccess.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$4 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class ViewOnClickListenerC88484 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public ViewOnClickListenerC88484(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelper.shareLinkClick(WidgetGuildScheduledEventCreateSuccess.this.getContext(), modelInvite);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    public static final class C88511 extends Lambda implements Function1<WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded, Unit> {
        public C88511() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "viewState");
            WidgetGuildScheduledEventCreateSuccess.access$configureUI(WidgetGuildScheduledEventCreateSuccess.this, loaded);
        }
    }

    public WidgetGuildScheduledEventCreateSuccess() {
        super(C5419R.layout.widget_guild_scheduled_event_create_success);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventCreateSuccess2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess3(this));
        this.guildId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess4(this));
        this.guildScheduledEventId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess5(this));
        WidgetGuildScheduledEventCreateSuccess6 widgetGuildScheduledEventCreateSuccess6 = new WidgetGuildScheduledEventCreateSuccess6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildScheduledEventCreateSuccessViewModel.class), new C8844x6415a92c(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventCreateSuccess6));
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
        TextView textView = getBinding().f16976c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().f16976c.setOnClickListener(new ViewOnClickListenerC88451(invite));
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().f16977d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.m8524i(getBinding().f16977d, GuildInviteUiHelper.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().f16977d.m8527e(new ViewOnClickListenerC88462(widgetInviteModel, defaultInviteExperiment));
        getBinding().f16975b.setOnClickListener(new ViewOnClickListenerC88473());
        getBinding().f16978e.setOnClickListener(new ViewOnClickListenerC88484(invite));
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
        Observable<R> observableM11083G = getViewModel().observeViewState().m11118y(C8849xa5572e8d.INSTANCE).m11083G(C8850xa5572e8e.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11083G, this, null, 2, null), WidgetGuildScheduledEventCreateSuccess.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C88511(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getViewModel().generateInviteLink(getChannelId());
    }
}

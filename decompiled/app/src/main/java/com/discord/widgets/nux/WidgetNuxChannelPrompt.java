package com.discord.widgets.nux;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetNuxChannelPrompt.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.m156d(context, WidgetNuxChannelPrompt.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class C91071 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Channel, TrackNetworkMetadata2> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Channel channel) {
                return invoke2(channel);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(Channel channel) {
                List<PermissionOverwrite> listM7655v;
                return new TrackNetworkActionChannelCreate((channel == null || (listM7655v = channel.m7655v()) == null) ? null : Boolean.valueOf(!listM7655v.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(C91071.this.$guildId));
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                C91071 c91071 = C91071.this;
                WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, c91071.$guildId);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
        public static final class AnonymousClass3<T> implements Action1<Error> {
            public AnonymousClass3() {
            }

            @Override // p658rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Error error) {
                call2(error);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Error error) {
                WidgetNuxChannelPrompt widgetNuxChannelPrompt = WidgetNuxChannelPrompt.this;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                widgetNuxChannelPrompt.handleError(error);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C91071(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).f17317b.setIsLoading(false);
                return;
            }
            TextInputLayout textInputLayout = WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).f17322g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().createGuildChannel(this.$guildId, new RestAPIParams.CreateGuildChannel(0, null, textOrEmpty, Long.valueOf(channel.getParentId()), null, FormatUtils.m219k(WidgetNuxChannelPrompt.this, C5419R.string.nuf_channel_prompt_channel_topic_template, new Object[]{textOrEmpty}, null, 4).toString())), new AnonymousClass1()), false, 1, null), WidgetNuxChannelPrompt.this, null, 2, null).m11108k(C0879o.f566a.m184g(WidgetNuxChannelPrompt.this.requireContext(), new AnonymousClass2(), new AnonymousClass3()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class C91081 extends Lambda implements Function1<Guild, Unit> {
        public C91081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            WidgetNuxChannelPrompt.access$handleGuild(WidgetNuxChannelPrompt.this, guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class ViewOnClickListenerC91092 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC91092(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class C91103<R> implements Func0<Boolean> {
        public final /* synthetic */ long $guildId;

        public C91103(long j) {
            this.$guildId = j;
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, this.$guildId);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class ViewOnClickListenerC91114 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC91114(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNuxChannelPrompt.access$handleSubmit(WidgetNuxChannelPrompt.this, this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
    public static final class C91125 extends Lambda implements Function1<TextView, Unit> {
        public C91125() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).f17317b.performClick();
        }
    }

    public WidgetNuxChannelPrompt() {
        super(C5419R.layout.widget_nux_channel_prompt);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNuxChannelPrompt2.INSTANCE, null, 2, null);
        this.validationManager = LazyJVM.lazy(new WidgetNuxChannelPrompt4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetNuxChannelPrompt3.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$finishActivity(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        widgetNuxChannelPrompt.finishActivity(j);
    }

    public static final /* synthetic */ WidgetNuxChannelPromptBinding access$getBinding$p(WidgetNuxChannelPrompt widgetNuxChannelPrompt) {
        return widgetNuxChannelPrompt.getBinding();
    }

    public static final /* synthetic */ void access$handleGuild(WidgetNuxChannelPrompt widgetNuxChannelPrompt, Guild guild) {
        widgetNuxChannelPrompt.handleGuild(guild);
    }

    public static final /* synthetic */ void access$handleSubmit(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        widgetNuxChannelPrompt.handleSubmit(j);
    }

    private final void finishActivity(long guildId) {
        if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
            WidgetGuildInviteShareSheet.Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.INSTANCE, null, guildId, "Guild Create", 1, null);
            AppScreen2.m155c(requireContext(), false, null, 6);
        } else {
            WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetGuildInviteShare.Companion.launch$default(companion, contextRequireContext, parentFragmentManager, guildId, null, true, null, null, "Guild Create", 96, null);
        }
        requireActivity().finish();
    }

    private final WidgetNuxChannelPromptBinding getBinding() {
        return (WidgetNuxChannelPromptBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleGuild(Guild guild) {
        if (guild == null) {
            return;
        }
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_large))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().f17319d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.nufChannelPromptGuildIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().f17318c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        } else {
            TextView textView2 = getBinding().f17319d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nufChannelPromptGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().f17319d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.nufChannelPromptGuildIconName");
            textView3.setText(guild.getShortName());
            SimpleDraweeView simpleDraweeView2 = getBinding().f17318c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        }
        TextView textView4 = getBinding().f17320e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.nufChannelPromptGuildName");
        textView4.setText(guild.getName());
    }

    private final void handleSubmit(long guildId) {
        getBinding().f17317b.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId), 0L, false, 3, null), WidgetNuxChannelPrompt.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91071(guildId), 62, (Object) null);
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleError(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        getBinding().f17317b.setIsLoading(false);
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        if (response.getMessages().isEmpty()) {
            error.setShowErrorToasts(true);
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        Intrinsics3.checkNotNullExpressionValue(response2.getMessages(), "error.response.messages");
        error.setShowErrorToasts(!validationManager.setErrors(r1).isEmpty());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getGuilds().observeGuild(longExtra), this, null, 2, null), WidgetNuxChannelPrompt.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91081(), 62, (Object) null);
        getBinding().f17321f.setOnClickListener(new ViewOnClickListenerC91092(longExtra));
        AppFragment.setOnBackPressed$default(this, new C91103(longExtra), 0, 2, null);
        getBinding().f17317b.setIsLoading(false);
        getBinding().f17317b.setOnClickListener(new ViewOnClickListenerC91114(longExtra));
        TextInputLayout textInputLayout = getBinding().f17322g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        ViewExtensions.setOnImeActionDone(textInputLayout, true, new C91125());
    }
}

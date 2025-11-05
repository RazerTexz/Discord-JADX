package com.discord.widgets.nux;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;
import rx.functions.Func0;

/* compiled from: WidgetNuxChannelPrompt.kt */
/* loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNuxChannelPrompt.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetNuxChannelPrompt.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            j.d(context, WidgetNuxChannelPrompt.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: WidgetNuxChannelPrompt.kt */
        /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04221 extends o implements Function1<Channel, TrackNetworkMetadataReceiver> {
            public C04221() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Channel channel) {
                return invoke2(channel);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadataReceiver invoke2(Channel channel) {
                List<PermissionOverwrite> listV;
                return new TrackNetworkActionChannelCreate((channel == null || (listV = channel.v()) == null) ? null : Boolean.valueOf(!listV.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(AnonymousClass1.this.$guildId));
            }
        }

        /* compiled from: WidgetNuxChannelPrompt.kt */
        /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Channel, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, anonymousClass1.$guildId);
            }
        }

        /* compiled from: WidgetNuxChannelPrompt.kt */
        /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T> implements Action1<Error> {
            public AnonymousClass3() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Error error) {
                call2(error);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Error error) {
                WidgetNuxChannelPrompt widgetNuxChannelPrompt = WidgetNuxChannelPrompt.this;
                m.checkNotNullExpressionValue(error, "error");
                widgetNuxChannelPrompt.handleError(error);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).f2504b.setIsLoading(false);
                return;
            }
            TextInputLayout textInputLayout = WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).g;
            m.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().createGuildChannel(this.$guildId, new RestAPIParams.CreateGuildChannel(0, null, textOrEmpty, Long.valueOf(channel.getParentId()), null, b.k(WidgetNuxChannelPrompt.this, R.string.nuf_channel_prompt_channel_topic_template, new Object[]{textOrEmpty}, null, 4).toString())), new C04221()), false, 1, null), WidgetNuxChannelPrompt.this, null, 2, null).k(b.a.d.o.a.g(WidgetNuxChannelPrompt.this.requireContext(), new AnonymousClass2(), new AnonymousClass3()));
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            WidgetNuxChannelPrompt.access$handleGuild(WidgetNuxChannelPrompt.this, guild);
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, this.$guildId);
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3<R> implements Func0<Boolean> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass3(long j) {
            this.$guildId = j;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, this.$guildId);
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public AnonymousClass4(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNuxChannelPrompt.access$handleSubmit(WidgetNuxChannelPrompt.this, this.$guildId);
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<TextView, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            m.checkNotNullParameter(textView, "it");
            WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).f2504b.performClick();
        }
    }

    public WidgetNuxChannelPrompt() {
        super(R.layout.widget_nux_channel_prompt);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNuxChannelPrompt$binding$2.INSTANCE, null, 2, null);
        this.validationManager = g.lazy(new WidgetNuxChannelPrompt$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetNuxChannelPrompt$loggingConfig$1.INSTANCE, 3);
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
            j.c(requireContext(), false, null, 6);
        } else {
            WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.avatar_size_large))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.nufChannelPromptGuildIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        } else {
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.nufChannelPromptGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().d;
            m.checkNotNullExpressionValue(textView3, "binding.nufChannelPromptGuildIconName");
            textView3.setText(guild.getShortName());
            SimpleDraweeView simpleDraweeView2 = getBinding().c;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        }
        TextView textView4 = getBinding().e;
        m.checkNotNullExpressionValue(textView4, "binding.nufChannelPromptGuildName");
        textView4.setText(guild.getName());
    }

    private final void handleSubmit(long guildId) {
        getBinding().f2504b.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId), 0L, false, 3, null), WidgetNuxChannelPrompt.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleError(Error error) {
        m.checkNotNullParameter(error, "error");
        getBinding().f2504b.setIsLoading(false);
        Error.Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        if (response.getMessages().isEmpty()) {
            error.setShowErrorToasts(true);
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response2 = error.getResponse();
        m.checkNotNullExpressionValue(response2, "error.response");
        m.checkNotNullExpressionValue(response2.getMessages(), "error.response.messages");
        error.setShowErrorToasts(!validationManager.setErrors(r1).isEmpty());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getGuilds().observeGuild(longExtra), this, null, 2, null), WidgetNuxChannelPrompt.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        getBinding().f.setOnClickListener(new AnonymousClass2(longExtra));
        AppFragment.setOnBackPressed$default(this, new AnonymousClass3(longExtra), 0, 2, null);
        getBinding().f2504b.setIsLoading(false);
        getBinding().f2504b.setOnClickListener(new AnonymousClass4(longExtra));
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        ViewExtensions.setOnImeActionDone(textInputLayout, true, new AnonymousClass5());
    }
}

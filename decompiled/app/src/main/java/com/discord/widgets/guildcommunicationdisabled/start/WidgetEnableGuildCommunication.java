package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserCommunicationDisabledUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableGuildCommunicationBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.duration.DurationUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.Subscription;

/* compiled from: WidgetEnableGuildCommunication.kt */
/* loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetEnableGuildCommunication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Clock clock;
    private Subscription communicationDisabledCountdownSubscription;

    /* compiled from: WidgetEnableGuildCommunication.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long userId, long guildId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetEnableGuildCommunication widgetEnableGuildCommunication = new WidgetEnableGuildCommunication();
            Bundle bundleM832T = outline.m832T("com.discord.intent.extra.EXTRA_USER_ID", userId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            widgetEnableGuildCommunication.setArguments(bundleM832T);
            widgetEnableGuildCommunication.show(fragmentManager, WidgetEnableGuildCommunication.class.getSimpleName());
            AnalyticsTracker.INSTANCE.viewedEnableCommunicationModal(guildId, userId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$1 */
    public static final class C85651 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ long $communicationDisabledTimestampMs;
        public final /* synthetic */ CharSequence $username;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C85651(long j, CharSequence charSequence) {
            super(1);
            this.$communicationDisabledTimestampMs = j;
            this.$username = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            long jMax = Math.max(this.$communicationDisabledTimestampMs - WidgetEnableGuildCommunication.access$getClock$p(WidgetEnableGuildCommunication.this).currentTimeMillis(), 0L);
            TextView textView = WidgetEnableGuildCommunication.access$getBinding$p(WidgetEnableGuildCommunication.this).f16587d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableGuildCommunicationBody");
            Context contextRequireContext = WidgetEnableGuildCommunication.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            FormatUtils.m222n(textView, C5419R.string.enable_guild_communication_body, new Object[]{this.$username, DurationUtils.humanizeCountdownDuration(contextRequireContext, jMax)}, null, 4);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$2 */
    public static final class C85662 extends Lambda implements Function1<Subscription, Unit> {
        public C85662() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetEnableGuildCommunication.access$setCommunicationDisabledCountdownSubscription$p(WidgetEnableGuildCommunication.this, subscription);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$handleEnableGuildCommunication$1 */
    public static final class C85671 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C85671(long j, long j2) {
            super(1);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Void r1) {
            return invoke2(r1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(Void r7) {
            return new TrackNetworkActionUserCommunicationDisabledUpdate(Long.valueOf(this.$guildId), Long.valueOf(this.$userId), null, null, null);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$handleEnableGuildCommunication$2 */
    public static final class C85682 extends Lambda implements Function1<Void, Unit> {
        public C85682() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            WidgetEnableGuildCommunication.this.dismiss();
            Context context = WidgetEnableGuildCommunication.this.getContext();
            Context context2 = WidgetEnableGuildCommunication.this.getContext();
            AppToast.m170h(context, context2 != null ? FormatUtils.m216h(context2, C5419R.string.guild_enable_communication_success, new Object[0], null, 4) : null, 0, null, 12);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$onViewBound$1 */
    public static final class ViewOnClickListenerC85691 implements View.OnClickListener {
        public ViewOnClickListenerC85691() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.m821I(WidgetEnableGuildCommunication.access$getBinding$p(WidgetEnableGuildCommunication.this).f16588e, "binding.enableGuildCommunicationBodyHelpText", "binding.enableGuildCommu…ationBodyHelpText.context"), AppHelpDesk.f507a.m149a(4413305239191L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$onViewBound$2 */
    public static final class ViewOnClickListenerC85702 implements View.OnClickListener {
        public ViewOnClickListenerC85702() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableGuildCommunication.this.dismiss();
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$onViewBound$3 */
    public static final class ViewOnClickListenerC85713 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        public ViewOnClickListenerC85713(long j, long j2) {
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableGuildCommunication.access$handleEnableGuildCommunication(WidgetEnableGuildCommunication.this, this.$guildId, this.$userId);
        }
    }

    public WidgetEnableGuildCommunication() {
        super(C5419R.layout.widget_enable_guild_communication);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableGuildCommunication2.INSTANCE, null, 2, null);
        this.clock = ClockFactory.get();
    }

    public static final /* synthetic */ WidgetEnableGuildCommunicationBinding access$getBinding$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.getBinding();
    }

    public static final /* synthetic */ Clock access$getClock$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.clock;
    }

    public static final /* synthetic */ Subscription access$getCommunicationDisabledCountdownSubscription$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.communicationDisabledCountdownSubscription;
    }

    public static final /* synthetic */ void access$handleEnableGuildCommunication(WidgetEnableGuildCommunication widgetEnableGuildCommunication, long j, long j2) {
        widgetEnableGuildCommunication.handleEnableGuildCommunication(j, j2);
    }

    public static final /* synthetic */ void access$setCommunicationDisabledCountdownSubscription$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication, Subscription subscription) {
        widgetEnableGuildCommunication.communicationDisabledCountdownSubscription = subscription;
    }

    private final void configureCommunicationDisabledTimer(long communicationDisabledTimestampMs, CharSequence username) {
        if (this.communicationDisabledCountdownSubscription != null) {
            return;
        }
        Observable<Long> observableM11061E = Observable.m11061E(0L, 1L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11061E, "Observable\n        .inte…0L, 1L, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11061E, this, null, 2, null), WidgetEnableGuildCommunication.class, (Context) null, new C85662(), (Function1) null, (Function0) null, (Function0) null, new C85651(communicationDisabledTimestampMs, username), 58, (Object) null);
    }

    private final WidgetEnableGuildCommunicationBinding getBinding() {
        return (WidgetEnableGuildCommunicationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleEnableGuildCommunication(long guildId, long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().disableGuildCommunication(guildId, userId, new RestAPIParams.DisableGuildCommunication(null), null), false, 1, null), new C85671(guildId, userId)), this, null, 2, null), WidgetEnableGuildCommunication.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85682(), 60, (Object) null);
    }

    public static final void launch(long j, long j2, FragmentManager fragmentManager) {
        INSTANCE.launch(j, j2, fragmentManager);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.communicationDisabledCountdownSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreUser users = companion.getUsers();
        GuildMember member = companion.getGuilds().getMember(j, j2);
        User user = users.getUsers().get(Long.valueOf(j2));
        if (member == null || user == null || !member.isCommunicationDisabled()) {
            return;
        }
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
        UtcDateTime communicationDisabledUntil = member.getCommunicationDisabledUntil();
        long dateTimeMillis = communicationDisabledUntil != null ? communicationDisabledUntil.getDateTimeMillis() : 0L;
        configureCommunicationDisabledTimer(dateTimeMillis, userNameWithDiscriminator$default);
        long jMax = Math.max(dateTimeMillis - this.clock.currentTimeMillis(), 0L);
        TextView textView = getBinding().f16587d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableGuildCommunicationBody");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.m222n(textView, C5419R.string.enable_guild_communication_body, new Object[]{userNameWithDiscriminator$default, DurationUtils.humanizeCountdownDuration(contextRequireContext, jMax)}, null, 4);
        Context context = getContext();
        CharSequence charSequenceM216h = context != null ? FormatUtils.m216h(context, C5419R.string.enable_guild_communication_body_help_text, new Object[]{AppHelpDesk.f507a.m149a(4413305239191L, null)}, null, 4) : null;
        TextView textView2 = getBinding().f16588e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.enableGuildCommunicationBodyHelpText");
        textView2.setText(charSequenceM216h);
        getBinding().f16588e.setOnClickListener(new ViewOnClickListenerC85691());
        getBinding().f16585b.setOnClickListener(new ViewOnClickListenerC85702());
        getBinding().f16586c.setOnClickListener(new ViewOnClickListenerC85713(j, j2));
    }
}

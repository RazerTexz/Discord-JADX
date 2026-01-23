package com.discord.widgets.nux;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxPostRegistrationJoin extends WidgetGuildJoin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NUX_FLOW_TYPE = "Mobile NUX Post Reg";
    private static final String NUX_STEP = "Ask to join";

    /* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetNuxPostRegistrationJoin.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
    public static final class ViewOnClickListenerC91131 implements View.OnClickListener {
        public final /* synthetic */ long $startTimeMs;

        public ViewOnClickListenerC91131(long j) {
            this.$startTimeMs = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetNuxPostRegistrationJoin.this.getBinding().f16853c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
            if (StringsJVM.isBlank(ViewExtensions.getTextOrEmpty(textInputLayout))) {
                AnalyticsTracker.INSTANCE.newUserOnboarding(WidgetNuxPostRegistrationJoin.NUX_FLOW_TYPE, WidgetNuxPostRegistrationJoin.NUX_STEP, "Friend List", Long.valueOf(this.$startTimeMs), true);
                FragmentActivity activity = WidgetNuxPostRegistrationJoin.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                    return;
                }
                return;
            }
            AnalyticsTracker.INSTANCE.newUserOnboarding(WidgetNuxPostRegistrationJoin.NUX_FLOW_TYPE, WidgetNuxPostRegistrationJoin.NUX_STEP, "Accept Instant Invite", Long.valueOf(this.$startTimeMs), false);
            WidgetNuxPostRegistrationJoin.access$handleGuildJoin(WidgetNuxPostRegistrationJoin.this);
            FragmentActivity activity2 = WidgetNuxPostRegistrationJoin.this.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
    public static final class C91142 extends Lambda implements Function1<Editable, Unit> {
        public C91142() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetNuxPostRegistrationJoin.this.getBinding().f16852b.setText(StringsJVM.isBlank(editable) ? C5419R.string.nux_post_reg_join_server_skip : C5419R.string.join);
        }
    }

    public WidgetNuxPostRegistrationJoin() {
        super(C5419R.layout.widget_nux_post_registration);
    }

    public static final /* synthetic */ void access$handleGuildJoin(WidgetNuxPostRegistrationJoin widgetNuxPostRegistrationJoin) {
        widgetNuxPostRegistrationJoin.handleGuildJoin();
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, NUX_FLOW_TYPE, GuildTemplateAnalytics.STEP_REGISTRATION, NUX_STEP, null, false, 24, null);
        getBinding().f16852b.setOnClickListener(new ViewOnClickListenerC91131(ClockFactory.get().currentTimeMillis()));
        TextInputLayout textInputLayout = getBinding().f16853c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C91142());
    }
}

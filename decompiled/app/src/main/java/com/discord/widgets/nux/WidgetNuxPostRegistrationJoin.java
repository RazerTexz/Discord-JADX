package com.discord.widgets.nux;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import b.a.d.j;
import com.discord.R;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetNuxPostRegistrationJoin.kt */
/* loaded from: classes2.dex */
public final class WidgetNuxPostRegistrationJoin extends WidgetGuildJoin {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NUX_FLOW_TYPE = "Mobile NUX Post Reg";
    private static final String NUX_STEP = "Ask to join";

    /* compiled from: WidgetNuxPostRegistrationJoin.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context) {
            m.checkNotNullParameter(context, "context");
            j.e(context, WidgetNuxPostRegistrationJoin.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNuxPostRegistrationJoin.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ long $startTimeMs;

        public AnonymousClass1(long j) {
            this.$startTimeMs = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetNuxPostRegistrationJoin.this.getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
            if (t.isBlank(ViewExtensions.getTextOrEmpty(textInputLayout))) {
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

    /* compiled from: WidgetNuxPostRegistrationJoin.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            m.checkNotNullParameter(editable, "editable");
            WidgetNuxPostRegistrationJoin.this.getBinding().f2423b.setText(t.isBlank(editable) ? R.string.nux_post_reg_join_server_skip : R.string.join);
        }
    }

    public WidgetNuxPostRegistrationJoin() {
        super(R.layout.widget_nux_post_registration);
    }

    public static final /* synthetic */ void access$handleGuildJoin(WidgetNuxPostRegistrationJoin widgetNuxPostRegistrationJoin) {
        widgetNuxPostRegistrationJoin.handleGuildJoin();
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, NUX_FLOW_TYPE, GuildTemplateAnalytics.STEP_REGISTRATION, NUX_STEP, null, false, 24, null);
        getBinding().f2423b.setOnClickListener(new AnonymousClass1(ClockFactory.get().currentTimeMillis()));
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
    }
}

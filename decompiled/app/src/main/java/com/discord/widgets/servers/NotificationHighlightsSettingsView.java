package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.d.f;
import b.d.b.a.a;
import com.discord.R;
import com.discord.databinding.NotificationHighlightsSettingsViewBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.uri.UriHandler;
import com.discord.views.CheckedSetting;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: NotificationHighlightsSettingsView.kt */
/* loaded from: classes2.dex */
public final class NotificationHighlightsSettingsView extends LinearLayout {
    private final NotificationHighlightsSettingsViewBinding binding;

    /* compiled from: NotificationHighlightsSettingsView.kt */
    public static final /* data */ class ViewState {
        private final boolean isMuted;
        private final int notifyHighlights;
        private final boolean serverTooLarge;

        public ViewState(boolean z2, int i, boolean z3) {
            this.isMuted = z2;
            this.notifyHighlights = i;
            this.serverTooLarge = z3;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, int i, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = viewState.isMuted;
            }
            if ((i2 & 2) != 0) {
                i = viewState.notifyHighlights;
            }
            if ((i2 & 4) != 0) {
                z3 = viewState.serverTooLarge;
            }
            return viewState.copy(z2, i, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* renamed from: component2, reason: from getter */
        public final int getNotifyHighlights() {
            return this.notifyHighlights;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getServerTooLarge() {
            return this.serverTooLarge;
        }

        public final ViewState copy(boolean isMuted, int notifyHighlights, boolean serverTooLarge) {
            return new ViewState(isMuted, notifyHighlights, serverTooLarge);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isMuted == viewState.isMuted && this.notifyHighlights == viewState.notifyHighlights && this.serverTooLarge == viewState.serverTooLarge;
        }

        public final int getNotifyHighlights() {
            return this.notifyHighlights;
        }

        public final boolean getServerTooLarge() {
            return this.serverTooLarge;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = ((r0 * 31) + this.notifyHighlights) * 31;
            boolean z3 = this.serverTooLarge;
            return i + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(isMuted=");
            sbU.append(this.isMuted);
            sbU.append(", notifyHighlights=");
            sbU.append(this.notifyHighlights);
            sbU.append(", serverTooLarge=");
            return a.O(sbU, this.serverTooLarge, ")");
        }
    }

    /* compiled from: NotificationHighlightsSettingsView.kt */
    /* renamed from: com.discord.widgets.servers.NotificationHighlightsSettingsView$updateView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ int $notifyHighlights;
        public final /* synthetic */ Function1 $onToggled;

        public AnonymousClass1(int i, Function1 function1) {
            this.$notifyHighlights = i;
            this.$onToggled = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationHighlightsSettingsView.access$getBinding$p(NotificationHighlightsSettingsView.this).c.toggle();
            int i = this.$notifyHighlights;
            int i2 = ModelNotificationSettings.HIGHLIGHTS_DISABLED;
            if (i == i2) {
                i2 = ModelNotificationSettings.HIGHLIGHTS_ENABLED;
            }
            this.$onToggled.invoke(Integer.valueOf(i2));
        }
    }

    /* compiled from: NotificationHighlightsSettingsView.kt */
    /* renamed from: com.discord.widgets.servers.NotificationHighlightsSettingsView$updateView$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, a.I(NotificationHighlightsSettingsView.access$getBinding$p(NotificationHighlightsSettingsView.this).f2130b, "binding.highlightsLearnMore", "binding.highlightsLearnMore.context"), f.a.a(5304469213079L, null), false, false, null, 28, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationHighlightsSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.notification_highlights_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.highlights_learn_more;
        TextView textView = (TextView) viewInflate.findViewById(R.id.highlights_learn_more);
        if (textView != null) {
            i = R.id.highlights_switch;
            CheckedSetting checkedSetting = (CheckedSetting) viewInflate.findViewById(R.id.highlights_switch);
            if (checkedSetting != null) {
                i = R.id.highlights_warning;
                MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(R.id.highlights_warning);
                if (materialCardView != null) {
                    NotificationHighlightsSettingsViewBinding notificationHighlightsSettingsViewBinding = new NotificationHighlightsSettingsViewBinding((LinearLayout) viewInflate, textView, checkedSetting, materialCardView);
                    m.checkNotNullExpressionValue(notificationHighlightsSettingsViewBinding, "NotificationHighlightsSe…rom(context), this, true)");
                    this.binding = notificationHighlightsSettingsViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ NotificationHighlightsSettingsViewBinding access$getBinding$p(NotificationHighlightsSettingsView notificationHighlightsSettingsView) {
        return notificationHighlightsSettingsView.binding;
    }

    public final void updateView(ViewState viewState, Function1<? super Integer, Unit> onToggled) {
        m.checkNotNullParameter(viewState, "viewState");
        m.checkNotNullParameter(onToggled, "onToggled");
        boolean zIsMuted = viewState.isMuted();
        int notifyHighlights = viewState.getNotifyHighlights();
        boolean serverTooLarge = viewState.getServerTooLarge();
        this.binding.c.setLabelTagText(R.string.beta);
        this.binding.c.setLabelTagVisibility(true);
        CheckedSetting checkedSetting = this.binding.c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.highlightsSwitch");
        checkedSetting.setChecked((notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED || zIsMuted) ? false : true);
        if (zIsMuted) {
            CheckedSetting.d(this.binding.c, null, 1);
        } else {
            this.binding.c.e(new AnonymousClass1(notifyHighlights, onToggled));
        }
        this.binding.f2130b.setOnClickListener(new AnonymousClass2());
        MaterialCardView materialCardView = this.binding.d;
        m.checkNotNullExpressionValue(materialCardView, "binding.highlightsWarning");
        materialCardView.setVisibility((!serverTooLarge || zIsMuted || notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED) ? false : true ? 0 : 8);
    }
}

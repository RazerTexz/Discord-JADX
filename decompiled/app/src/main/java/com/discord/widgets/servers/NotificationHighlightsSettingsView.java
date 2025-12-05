package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.NotificationHighlightsSettingsViewBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.uri.UriHandler;
import com.discord.views.CheckedSetting;
import com.google.android.material.card.MaterialCardView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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
            StringBuilder sbM833U = outline.m833U("ViewState(isMuted=");
            sbM833U.append(this.isMuted);
            sbM833U.append(", notifyHighlights=");
            sbM833U.append(this.notifyHighlights);
            sbM833U.append(", serverTooLarge=");
            return outline.m827O(sbM833U, this.serverTooLarge, ")");
        }
    }

    /* compiled from: NotificationHighlightsSettingsView.kt */
    /* renamed from: com.discord.widgets.servers.NotificationHighlightsSettingsView$updateView$1 */
    public static final class ViewOnClickListenerC91451 implements View.OnClickListener {
        public final /* synthetic */ int $notifyHighlights;
        public final /* synthetic */ Function1 $onToggled;

        public ViewOnClickListenerC91451(int i, Function1 function1) {
            this.$notifyHighlights = i;
            this.$onToggled = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationHighlightsSettingsView.access$getBinding$p(NotificationHighlightsSettingsView.this).f15191c.toggle();
            int i = this.$notifyHighlights;
            int i2 = ModelNotificationSettings.HIGHLIGHTS_DISABLED;
            if (i == i2) {
                i2 = ModelNotificationSettings.HIGHLIGHTS_ENABLED;
            }
            this.$onToggled.invoke(Integer.valueOf(i2));
        }
    }

    /* compiled from: NotificationHighlightsSettingsView.kt */
    /* renamed from: com.discord.widgets.servers.NotificationHighlightsSettingsView$updateView$2 */
    public static final class ViewOnClickListenerC91462 implements View.OnClickListener {
        public ViewOnClickListenerC91462() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.m821I(NotificationHighlightsSettingsView.access$getBinding$p(NotificationHighlightsSettingsView.this).f15190b, "binding.highlightsLearnMore", "binding.highlightsLearnMore.context"), AppHelpDesk.f507a.m149a(5304469213079L, null), false, false, null, 28, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationHighlightsSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.notification_highlights_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.highlights_learn_more;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.highlights_learn_more);
        if (textView != null) {
            i = C5419R.id.highlights_switch;
            CheckedSetting checkedSetting = (CheckedSetting) viewInflate.findViewById(C5419R.id.highlights_switch);
            if (checkedSetting != null) {
                i = C5419R.id.highlights_warning;
                MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(C5419R.id.highlights_warning);
                if (materialCardView != null) {
                    NotificationHighlightsSettingsViewBinding notificationHighlightsSettingsViewBinding = new NotificationHighlightsSettingsViewBinding((LinearLayout) viewInflate, textView, checkedSetting, materialCardView);
                    Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsViewBinding, "NotificationHighlightsSe…rom(context), this, true)");
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
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        Intrinsics3.checkNotNullParameter(onToggled, "onToggled");
        boolean zIsMuted = viewState.isMuted();
        int notifyHighlights = viewState.getNotifyHighlights();
        boolean serverTooLarge = viewState.getServerTooLarge();
        this.binding.f15191c.setLabelTagText(C5419R.string.beta);
        this.binding.f15191c.setLabelTagVisibility(true);
        CheckedSetting checkedSetting = this.binding.f15191c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.highlightsSwitch");
        checkedSetting.setChecked((notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED || zIsMuted) ? false : true);
        if (zIsMuted) {
            CheckedSetting.m8523d(this.binding.f15191c, null, 1);
        } else {
            this.binding.f15191c.m8527e(new ViewOnClickListenerC91451(notifyHighlights, onToggled));
        }
        this.binding.f15190b.setOnClickListener(new ViewOnClickListenerC91462());
        MaterialCardView materialCardView = this.binding.f15192d;
        Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.highlightsWarning");
        materialCardView.setVisibility((!serverTooLarge || zIsMuted || notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED) ? false : true ? 0 : 8);
    }
}

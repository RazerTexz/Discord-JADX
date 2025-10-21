package com.discord.widgets.hubs.events;

import android.widget.LinearLayout;
import com.discord.databinding.WidgetHubEventsFooterBinding;
import com.discord.stores.utilities.RestCallState4;
import com.discord.views.LoadingButton;
import com.discord.widgets.hubs.events.WidgetHubEventsPageAdapter2;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetHubEventsPageViewHolder.kt */
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPageFooterViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder3 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsFooterBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageViewHolder3(WidgetHubEventsFooterBinding widgetHubEventsFooterBinding, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(widgetHubEventsFooterBinding, "binding");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "listener");
        LinearLayout linearLayout = widgetHubEventsFooterBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = widgetHubEventsFooterBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind(WidgetHubEventsPageAdapter2.Footer footer) {
        Intrinsics3.checkNotNullParameter(footer, "footer");
        LoadingButton loadingButton = this.binding.f2475b;
        loadingButton.setOnClickListener(new WidgetHubEventsPageViewHolder4(this, footer));
        loadingButton.setIsLoading(footer.getEventsAsync() instanceof RestCallState4);
    }

    public final WidgetHubEventsFooterBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}

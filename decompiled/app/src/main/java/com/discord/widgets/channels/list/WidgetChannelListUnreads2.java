package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelsListUnreadsBinding;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChannelListUnreads.kt */
/* renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelListUnreads2 extends Lambda implements Function0<WidgetChannelsListUnreadsBinding> {
    public final /* synthetic */ WidgetChannelListUnreads this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListUnreads2(WidgetChannelListUnreads widgetChannelListUnreads) {
        super(0);
        this.this$0 = widgetChannelListUnreads;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelsListUnreadsBinding invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelsListUnreadsBinding invoke() {
        View viewInflate = WidgetChannelListUnreads.access$getUnreadsStub$p(this.this$0).inflate();
        int i = C5419R.id.channels_list_unreads;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channels_list_unreads);
        if (textView != null) {
            i = C5419R.id.channels_list_unreads_background;
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(C5419R.id.channels_list_unreads_background);
            if (relativeLayout != null) {
                WidgetChannelsListUnreadsBinding widgetChannelsListUnreadsBinding = new WidgetChannelsListUnreadsBinding((FrameLayout) viewInflate, textView, relativeLayout);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelsListUnreadsBinding, "WidgetChannelsListUnread…nd(unreadsStub.inflate())");
                return widgetChannelsListUnreadsBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}

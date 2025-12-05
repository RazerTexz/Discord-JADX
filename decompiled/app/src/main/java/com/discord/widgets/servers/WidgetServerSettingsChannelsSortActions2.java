package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsChannelsSortActionsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsChannelsSortActions.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannelsSortActions2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsChannelsSortActionsBinding> {
    public static final WidgetServerSettingsChannelsSortActions2 INSTANCE = new WidgetServerSettingsChannelsSortActions2();

    public WidgetServerSettingsChannelsSortActions2() {
        super(1, WidgetServerSettingsChannelsSortActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsSortActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannelsSortActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsChannelsSortActionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(C5419R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = C5419R.id.server_settings_channels_sort_actions_category;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.server_settings_channels_sort_actions_category);
            if (textView2 != null) {
                i = C5419R.id.server_settings_channels_sort_actions_text;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.server_settings_channels_sort_actions_text);
                if (textView3 != null) {
                    i = C5419R.id.server_settings_channels_sort_actions_voice;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.server_settings_channels_sort_actions_voice);
                    if (textView4 != null) {
                        return new WidgetServerSettingsChannelsSortActionsBinding((NestedScrollView) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

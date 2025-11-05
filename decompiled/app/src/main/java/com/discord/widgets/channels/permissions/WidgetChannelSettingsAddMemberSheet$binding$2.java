package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSettingsAddMemberSheetBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsAddMemberSheet$binding$2 extends k implements Function1<View, WidgetChannelSettingsAddMemberSheetBinding> {
    public static final WidgetChannelSettingsAddMemberSheet$binding$2 INSTANCE = new WidgetChannelSettingsAddMemberSheet$binding$2();

    public WidgetChannelSettingsAddMemberSheet$binding$2() {
        super(1, WidgetChannelSettingsAddMemberSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsAddMemberSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsAddMemberSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.add_button;
        TextView textView = (TextView) view.findViewById(R.id.add_button);
        if (textView != null) {
            i = R.id.content;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.content);
            if (fragmentContainerView != null) {
                i = R.id.subtitle;
                TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
                if (textView2 != null) {
                    i = R.id.title;
                    TextView textView3 = (TextView) view.findViewById(R.id.title);
                    if (textView3 != null) {
                        return new WidgetChannelSettingsAddMemberSheetBinding((LinearLayout) view, textView, fragmentContainerView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

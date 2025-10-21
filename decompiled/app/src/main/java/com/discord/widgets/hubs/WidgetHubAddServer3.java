package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetHubAddServerBinding;
import com.discord.views.ScreenTitleView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubAddServer.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAddServer3 extends FunctionReferenceImpl implements Function1<View, WidgetHubAddServerBinding> {
    public static final WidgetHubAddServer3 INSTANCE = new WidgetHubAddServer3();

    public WidgetHubAddServer3() {
        super(1, WidgetHubAddServerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubAddServerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubAddServerBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubAddServerBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.discord_u_add_server_create_server;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.discord_u_add_server_create_server);
        if (materialButton != null) {
            i = R.id.header;
            ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.header);
            if (screenTitleView != null) {
                i = R.id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                if (recyclerView != null) {
                    i = R.id.segmented_control;
                    SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(R.id.segmented_control);
                    if (segmentedControlContainer != null) {
                        i = R.id.segmented_control_guilds_added;
                        CardSegment cardSegment = (CardSegment) view.findViewById(R.id.segmented_control_guilds_added);
                        if (cardSegment != null) {
                            i = R.id.segmented_control_guilds_not_added;
                            CardSegment cardSegment2 = (CardSegment) view.findViewById(R.id.segmented_control_guilds_not_added);
                            if (cardSegment2 != null) {
                                return new WidgetHubAddServerBinding((LinearLayout) view, materialButton, screenTitleView, recyclerView, segmentedControlContainer, cardSegment, cardSegment2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

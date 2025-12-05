package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildScheduledEventListBottomSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventListBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildScheduledEventListBottomSheetBinding> {
    public static final WidgetGuildScheduledEventListBottomSheet2 INSTANCE = new WidgetGuildScheduledEventListBottomSheet2();

    public WidgetGuildScheduledEventListBottomSheet2() {
        super(1, WidgetGuildScheduledEventListBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventListBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildScheduledEventListBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.create_event_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.create_event_button);
        if (textView != null) {
            i = C5419R.id.guild_scheduled_event_list_empty_state;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.guild_scheduled_event_list_empty_state);
            if (constraintLayout != null) {
                i = C5419R.id.guild_scheduled_event_list_empty_state_icon;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.guild_scheduled_event_list_empty_state_icon);
                if (imageView != null) {
                    i = C5419R.id.guild_scheduled_event_list_empty_state_subtitle;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_list_empty_state_subtitle);
                    if (textView2 != null) {
                        i = C5419R.id.guild_scheduled_event_list_empty_state_title;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_list_empty_state_title);
                        if (textView3 != null) {
                            i = C5419R.id.guild_scheduled_event_list_recycler_view;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.guild_scheduled_event_list_recycler_view);
                            if (recyclerView != null) {
                                i = C5419R.id.guild_scheduled_event_list_toolbar_container;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(C5419R.id.guild_scheduled_event_list_toolbar_container);
                                if (constraintLayout2 != null) {
                                    i = C5419R.id.guild_scheduled_event_list_toolbar_title;
                                    TextView textView4 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_list_toolbar_title);
                                    if (textView4 != null) {
                                        return new WidgetGuildScheduledEventListBottomSheetBinding((ConstraintLayout) view, textView, constraintLayout, imageView, textView2, textView3, recyclerView, constraintLayout2, textView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

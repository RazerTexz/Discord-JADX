package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetStartCallSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStartCallSheet.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetStartCallSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetStartCallSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetStartCallSheetBinding> {
    public static final WidgetStartCallSheet2 INSTANCE = new WidgetStartCallSheet2();

    public WidgetStartCallSheet2() {
        super(1, WidgetStartCallSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStartCallSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStartCallSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStartCallSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.start_call_sheet_video_item;
        TextView textView = (TextView) view.findViewById(R.id.start_call_sheet_video_item);
        if (textView != null) {
            i = R.id.start_call_sheet_voice_item;
            TextView textView2 = (TextView) view.findViewById(R.id.start_call_sheet_voice_item);
            if (textView2 != null) {
                return new WidgetStartCallSheetBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

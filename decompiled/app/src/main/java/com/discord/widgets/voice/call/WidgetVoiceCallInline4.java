package com.discord.widgets.voice.call;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetVoiceCallInlineBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetVoiceCallInline.kt */
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceCallInline4 extends FunctionReferenceImpl implements Function1<View, WidgetVoiceCallInlineBinding> {
    public static final WidgetVoiceCallInline4 INSTANCE = new WidgetVoiceCallInline4();

    public WidgetVoiceCallInline4() {
        super(1, WidgetVoiceCallInlineBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetVoiceCallInlineBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallInlineBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        LinearLayout linearLayout = (LinearLayout) view;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.voice_connected_ptt);
        if (materialButton != null) {
            return new WidgetVoiceCallInlineBinding((LinearLayout) view, linearLayout, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.voice_connected_ptt)));
    }
}

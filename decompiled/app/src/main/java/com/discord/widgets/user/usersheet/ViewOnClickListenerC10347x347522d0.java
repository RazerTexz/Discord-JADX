package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetUserSheet.kt */
/* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureDeveloperSection$$inlined$apply$lambda$1 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC10347x347522d0 implements View.OnClickListener {
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetUserSheetViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetUserSheet this$0;

    public ViewOnClickListenerC10347x347522d0(TextView textView, WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel.ViewState.Loaded loaded) {
        this.$this_apply = textView;
        this.this$0 = widgetUserSheet;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.$this_apply.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        AppToast.m165c(context, String.valueOf(this.$viewState$inlined.getUser().getId()), 0, 4);
        this.this$0.dismiss();
    }
}

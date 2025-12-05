package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelPrestartDetailsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StageCallViewHolder.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.stage.PrestartDetailsViewHolder, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallViewHolder7 extends StageCallViewHolder {
    private final WidgetStageChannelPrestartDetailsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder7(StageCallAdapter stageCallAdapter) {
        super(C5419R.layout.widget_stage_channel_prestart_details, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.subtitle;
        TextView textView = (TextView) view.findViewById(C5419R.id.subtitle);
        if (textView != null) {
            i = C5419R.id.title;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.title);
            if (textView2 != null) {
                WidgetStageChannelPrestartDetailsBinding widgetStageChannelPrestartDetailsBinding = new WidgetStageChannelPrestartDetailsBinding((ConstraintLayout) view, textView, textView2);
                Intrinsics3.checkNotNullExpressionValue(widgetStageChannelPrestartDetailsBinding, "WidgetStageChannelPresta…ilsBinding.bind(itemView)");
                this.binding = widgetStageChannelPrestartDetailsBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem.PreStartDetailsItem preStartDetailsItem = (StageCallItem.PreStartDetailsItem) data;
        TextView textView = this.binding.f18157c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(preStartDetailsItem.getTitle());
        TextView textView2 = this.binding.f18156b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitle");
        textView2.setText(preStartDetailsItem.getSubtitle());
        boolean z2 = preStartDetailsItem.getNumSpeakers() > 0;
        boolean z3 = preStartDetailsItem.getNumAudience() > 0;
        ConstraintLayout constraintLayout = this.binding.f18155a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = (z2 || !z3) ? DimenUtils.dpToPixels(0) : DimenUtils.dpToPixels(24);
        constraintLayout.setLayoutParams(marginLayoutParams);
    }
}

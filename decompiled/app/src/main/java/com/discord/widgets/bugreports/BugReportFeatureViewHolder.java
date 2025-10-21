package com.discord.widgets.bugreports;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.bugreport.BugReportConfig2;
import com.discord.databinding.WidgetBugReportFeatureListItemBinding;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetBugReport.kt */
/* loaded from: classes2.dex */
public final class BugReportFeatureViewHolder extends RecyclerView.ViewHolder {
    private final WidgetBugReportFeatureListItemBinding binding;
    private final Function1<BugReportConfig2, Unit> onClickListener;

    /* compiled from: WidgetBugReport.kt */
    /* renamed from: com.discord.widgets.bugreports.BugReportFeatureViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ BugReportConfig2 $data;

        public AnonymousClass1(BugReportConfig2 bugReportConfig2) {
            this.$data = bugReportConfig2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BugReportFeatureViewHolder.this.getOnClickListener().invoke(this.$data);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureViewHolder(WidgetBugReportFeatureListItemBinding widgetBugReportFeatureListItemBinding, Function1<? super BugReportConfig2, Unit> function1) {
        super(widgetBugReportFeatureListItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetBugReportFeatureListItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        this.binding = widgetBugReportFeatureListItemBinding;
        this.onClickListener = function1;
    }

    public final void bind(BugReportConfig2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.f2244b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.featureListItemFeature");
        textView.setText(data.getName());
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.featureListItemSquad");
        textView2.setText(data.getSquad());
        this.binding.a.setOnClickListener(new AnonymousClass1(data));
    }

    public final WidgetBugReportFeatureListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<BugReportConfig2, Unit> getOnClickListener() {
        return this.onClickListener;
    }
}

package com.discord.widgets.bugreports;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.bugreport.Feature;
import com.discord.databinding.WidgetBugReportFeatureHeaderListItemBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetBugReport.kt */
/* loaded from: classes2.dex */
public final class BugReportFeatureHeaderViewHolder extends RecyclerView.ViewHolder {
    private final WidgetBugReportFeatureHeaderListItemBinding binding;
    private final Function1<Feature, Unit> onClickListener;

    /* compiled from: WidgetBugReport.kt */
    /* renamed from: com.discord.widgets.bugreports.BugReportFeatureHeaderViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Feature $feature;

        public AnonymousClass1(Feature feature) {
            this.$feature = feature;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BugReportFeatureHeaderViewHolder.this.getOnClickListener().invoke(this.$feature);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BugReportFeatureHeaderViewHolder(WidgetBugReportFeatureHeaderListItemBinding widgetBugReportFeatureHeaderListItemBinding, Function1<? super Feature, Unit> function1) {
        super(widgetBugReportFeatureHeaderListItemBinding.a);
        m.checkNotNullParameter(widgetBugReportFeatureHeaderListItemBinding, "binding");
        m.checkNotNullParameter(function1, "onClickListener");
        this.binding = widgetBugReportFeatureHeaderListItemBinding;
        this.onClickListener = function1;
    }

    public final void bind(boolean isTop, Feature feature) {
        m.checkNotNullParameter(feature, "feature");
        View view = this.binding.f2243b;
        m.checkNotNullExpressionValue(view, "binding.gap");
        view.setVisibility(isTop ^ true ? 0 : 8);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.header");
        textView.setText(feature.getName());
        this.binding.c.setOnClickListener(new AnonymousClass1(feature));
    }

    public final WidgetBugReportFeatureHeaderListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<Feature, Unit> getOnClickListener() {
        return this.onClickListener;
    }
}

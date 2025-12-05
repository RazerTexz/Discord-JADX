package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.databinding.ViewMobileReportsBottomButtonBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MobileReportsBottomButton.kt */
/* loaded from: classes2.dex */
public final class MobileReportsBottomButton extends LinearLayout {
    private final ViewMobileReportsBottomButtonBinding binding;

    /* compiled from: MobileReportsBottomButton.kt */
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsBottomButton$setup$1 */
    public static final class ViewOnClickListenerC90701 implements View.OnClickListener {
        public final /* synthetic */ ReportNodeBottomButton $bottomButton;
        public final /* synthetic */ Function1 $handleButtonPress;

        public ViewOnClickListenerC90701(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
            this.$handleButtonPress = function1;
            this.$bottomButton = reportNodeBottomButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$handleButtonPress;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: MobileReportsBottomButton.kt */
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsBottomButton$setup$2 */
    public static final class ViewOnClickListenerC90712 implements View.OnClickListener {
        public final /* synthetic */ ReportNodeBottomButton $bottomButton;
        public final /* synthetic */ Function1 $handleButtonPress;

        public ViewOnClickListenerC90712(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
            this.$handleButtonPress = function1;
            this.$bottomButton = reportNodeBottomButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$handleButtonPress;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: MobileReportsBottomButton.kt */
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsBottomButton$setup$3 */
    public static final class ViewOnClickListenerC90723 implements View.OnClickListener {
        public final /* synthetic */ ReportNodeBottomButton $bottomButton;
        public final /* synthetic */ Function1 $handleButtonPress;

        public ViewOnClickListenerC90723(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
            this.$handleButtonPress = function1;
            this.$bottomButton = reportNodeBottomButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$handleButtonPress;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: MobileReportsBottomButton.kt */
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsBottomButton$setup$4 */
    public static final class ViewOnClickListenerC90734 implements View.OnClickListener {
        public final /* synthetic */ ReportNodeBottomButton $bottomButton;
        public final /* synthetic */ Function1 $handleButtonPress;

        public ViewOnClickListenerC90734(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
            this.$handleButtonPress = function1;
            this.$bottomButton = reportNodeBottomButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$handleButtonPress;
            if (function1 != null) {
            }
        }
    }

    public MobileReportsBottomButton(Context context) {
        this(context, null, 0, 6, null);
    }

    public MobileReportsBottomButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MobileReportsBottomButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setup(ReportNodeBottomButton bottomButton, MobileReportsViewModel.SubmitState submitState, Function1<? super ReportNodeBottomButton, Unit> handleButtonPress) {
        this.binding.f15514c.setOnClickListener(null);
        this.binding.f15513b.setOnClickListener(null);
        LinkifiedTextView linkifiedTextView = this.binding.f15515d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.reportNodeBottomButtonDescription");
        boolean z2 = bottomButton instanceof ReportNodeBottomButton.Submit;
        linkifiedTextView.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = this.binding.f15514c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.reportNodeBottomButtonCancel");
        boolean z3 = bottomButton instanceof ReportNodeBottomButton.Cancel;
        materialButton.setVisibility(z3 ? 0 : 8);
        LoadingButton loadingButton = this.binding.f15513b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportNodeBottomButton");
        MaterialButton materialButton2 = this.binding.f15514c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.reportNodeBottomButtonCancel");
        loadingButton.setVisibility((materialButton2.getVisibility() == 0) ^ true ? 0 : 8);
        boolean z4 = submitState instanceof MobileReportsViewModel.SubmitState.Loading;
        TextView textView = this.binding.f15516e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportNodeBottomButtonErrorText");
        textView.setVisibility(submitState instanceof MobileReportsViewModel.SubmitState.Error ? 0 : 8);
        this.binding.f15513b.setIsLoading(z4);
        LoadingButton loadingButton2 = this.binding.f15513b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportNodeBottomButton");
        loadingButton2.setEnabled(!z4);
        if (z2) {
            LinkifiedTextView linkifiedTextView2 = this.binding.f15515d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.reportNodeBottomButtonDescription");
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            linkifiedTextView2.setText(FormatUtils.m216h(context, C5419R.string.mobile_reports_submit_info_text, new Object[0], null, 4));
            this.binding.f15513b.setText(getContext().getString(C5419R.string.mobile_reports_submit_report));
            this.binding.f15513b.setBackgroundColor(ColorCompat.getColor(getContext(), C5419R.color.status_red));
            this.binding.f15513b.setOnClickListener(new ViewOnClickListenerC90701(handleButtonPress, bottomButton));
            return;
        }
        if (bottomButton instanceof ReportNodeBottomButton.Done) {
            this.binding.f15513b.setText(getContext().getString(C5419R.string.done));
            this.binding.f15513b.setOnClickListener(new ViewOnClickListenerC90712(handleButtonPress, bottomButton));
        } else if (bottomButton instanceof ReportNodeBottomButton.Next) {
            this.binding.f15513b.setText(getContext().getString(C5419R.string.next));
            this.binding.f15513b.setOnClickListener(new ViewOnClickListenerC90723(handleButtonPress, bottomButton));
        } else if (z3) {
            this.binding.f15514c.setOnClickListener(new ViewOnClickListenerC90734(handleButtonPress, bottomButton));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsBottomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_mobile_reports_bottom_button, this);
        int i2 = C5419R.id.report_node_bottom_button;
        LoadingButton loadingButton = (LoadingButton) findViewById(C5419R.id.report_node_bottom_button);
        if (loadingButton != null) {
            i2 = C5419R.id.report_node_bottom_button_cancel;
            MaterialButton materialButton = (MaterialButton) findViewById(C5419R.id.report_node_bottom_button_cancel);
            if (materialButton != null) {
                i2 = C5419R.id.report_node_bottom_button_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) findViewById(C5419R.id.report_node_bottom_button_description);
                if (linkifiedTextView != null) {
                    i2 = C5419R.id.report_node_bottom_button_error_text;
                    TextView textView = (TextView) findViewById(C5419R.id.report_node_bottom_button_error_text);
                    if (textView != null) {
                        ViewMobileReportsBottomButtonBinding viewMobileReportsBottomButtonBinding = new ViewMobileReportsBottomButtonBinding(this, loadingButton, materialButton, linkifiedTextView, textView);
                        Intrinsics3.checkNotNullExpressionValue(viewMobileReportsBottomButtonBinding, "ViewMobileReportsBottomB…ater.from(context), this)");
                        this.binding = viewMobileReportsBottomButtonBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}

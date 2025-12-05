package com.discord.views.experiments;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import java.util.Objects;
import p007b.p008a.p025i.ViewExperimentOverrideBinding;
import p007b.p008a.p025i.ViewSimpleSpinnerDropdownItemBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ExperimentOverrideView.kt */
/* loaded from: classes2.dex */
public final class ExperimentOverrideView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewExperimentOverrideBinding binding;

    /* compiled from: ExperimentOverrideView.kt */
    /* renamed from: com.discord.views.experiments.ExperimentOverrideView$a */
    public static final class C7112a extends ArrayAdapter<C7113b> {

        /* renamed from: j */
        public final List<C7113b> f19266j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7112a(Context context, List<C7113b> list) {
            super(context, C5419R.layout.view_simple_spinner_dropdown_item, list);
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(list, "items");
            this.f19266j = list;
        }

        /* renamed from: a */
        public final View m8591a(int i, View view) {
            View view2 = view;
            if (view == null) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_simple_spinner_dropdown_item, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new ViewSimpleSpinnerDropdownItemBinding(textView), "ViewSimpleSpinnerDropdow…om(context), null, false)");
                Intrinsics3.checkNotNullExpressionValue(textView, "ViewSimpleSpinnerDropdow…ntext), null, false).root");
                view2 = textView;
            }
            ((TextView) view2).setText(this.f19266j.get(i).f19268b);
            return view2;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.f19266j.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            return m8591a(i, view);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Object getItem(int i) {
            return this.f19266j.get(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            if (this.f19266j.get(i).f19267a != null) {
                return r3.intValue();
            }
            return -1L;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            return m8591a(i, view);
        }
    }

    /* compiled from: ExperimentOverrideView.kt */
    /* renamed from: com.discord.views.experiments.ExperimentOverrideView$b */
    public static final class C7113b {

        /* renamed from: a */
        public final Integer f19267a;

        /* renamed from: b */
        public final String f19268b;

        public C7113b(Integer num, String str) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.f19267a = num;
            this.f19268b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C7113b)) {
                return false;
            }
            C7113b c7113b = (C7113b) obj;
            return Intrinsics3.areEqual(this.f19267a, c7113b.f19267a) && Intrinsics3.areEqual(this.f19268b, c7113b.f19268b);
        }

        public int hashCode() {
            Integer num = this.f19267a;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            String str = this.f19268b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("SpinnerItem(bucket=");
            sbM833U.append(this.f19267a);
            sbM833U.append(", text=");
            return outline.m822J(sbM833U, this.f19268b, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentOverrideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_experiment_override, this);
        int i = C5419R.id.experiment_override_bucket_descriptions;
        TextView textView = (TextView) findViewById(C5419R.id.experiment_override_bucket_descriptions);
        if (textView != null) {
            i = C5419R.id.experiment_override_buckets_spinner;
            Spinner spinner = (Spinner) findViewById(C5419R.id.experiment_override_buckets_spinner);
            if (spinner != null) {
                i = C5419R.id.experiment_override_buckets_spinner_container;
                MaterialCardView materialCardView = (MaterialCardView) findViewById(C5419R.id.experiment_override_buckets_spinner_container);
                if (materialCardView != null) {
                    i = C5419R.id.experiment_override_clear;
                    TextView textView2 = (TextView) findViewById(C5419R.id.experiment_override_clear);
                    if (textView2 != null) {
                        i = C5419R.id.experiment_override_experiment_api_name;
                        TextView textView3 = (TextView) findViewById(C5419R.id.experiment_override_experiment_api_name);
                        if (textView3 != null) {
                            i = C5419R.id.experiment_override_experiment_name;
                            TextView textView4 = (TextView) findViewById(C5419R.id.experiment_override_experiment_name);
                            if (textView4 != null) {
                                ViewExperimentOverrideBinding viewExperimentOverrideBinding = new ViewExperimentOverrideBinding(this, textView, spinner, materialCardView, textView2, textView3, textView4);
                                Intrinsics3.checkNotNullExpressionValue(viewExperimentOverrideBinding, "ViewExperimentOverrideBi…ater.from(context), this)");
                                this.binding = viewExperimentOverrideBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}

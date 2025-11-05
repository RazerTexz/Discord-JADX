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
import b.a.i.i2;
import b.a.i.u3;
import com.discord.R;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;

/* compiled from: ExperimentOverrideView.kt */
/* loaded from: classes2.dex */
public final class ExperimentOverrideView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final i2 binding;

    /* compiled from: ExperimentOverrideView.kt */
    public static final class a extends ArrayAdapter<b> {
        public final List<b> j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, List<b> list) {
            super(context, R.layout.view_simple_spinner_dropdown_item, list);
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(list, "items");
            this.j = list;
        }

        public final View a(int i, View view) {
            View view2 = view;
            if (view == null) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_simple_spinner_dropdown_item, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                m.checkNotNullExpressionValue(new u3(textView), "ViewSimpleSpinnerDropdow…om(context), null, false)");
                m.checkNotNullExpressionValue(textView, "ViewSimpleSpinnerDropdow…ntext), null, false).root");
                view2 = textView;
            }
            ((TextView) view2).setText(this.j.get(i).f2842b);
            return view2;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.j.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            m.checkNotNullParameter(viewGroup, "parent");
            return a(i, view);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Object getItem(int i) {
            return this.j.get(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            if (this.j.get(i).a != null) {
                return r3.intValue();
            }
            return -1L;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            m.checkNotNullParameter(viewGroup, "parent");
            return a(i, view);
        }
    }

    /* compiled from: ExperimentOverrideView.kt */
    public static final class b {
        public final Integer a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2842b;

        public b(Integer num, String str) {
            m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.a = num;
            this.f2842b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.areEqual(this.a, bVar.a) && m.areEqual(this.f2842b, bVar.f2842b);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            String str = this.f2842b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("SpinnerItem(bucket=");
            sbU.append(this.a);
            sbU.append(", text=");
            return b.d.b.a.a.J(sbU, this.f2842b, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperimentOverrideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_experiment_override, this);
        int i = R.id.experiment_override_bucket_descriptions;
        TextView textView = (TextView) findViewById(R.id.experiment_override_bucket_descriptions);
        if (textView != null) {
            i = R.id.experiment_override_buckets_spinner;
            Spinner spinner = (Spinner) findViewById(R.id.experiment_override_buckets_spinner);
            if (spinner != null) {
                i = R.id.experiment_override_buckets_spinner_container;
                MaterialCardView materialCardView = (MaterialCardView) findViewById(R.id.experiment_override_buckets_spinner_container);
                if (materialCardView != null) {
                    i = R.id.experiment_override_clear;
                    TextView textView2 = (TextView) findViewById(R.id.experiment_override_clear);
                    if (textView2 != null) {
                        i = R.id.experiment_override_experiment_api_name;
                        TextView textView3 = (TextView) findViewById(R.id.experiment_override_experiment_api_name);
                        if (textView3 != null) {
                            i = R.id.experiment_override_experiment_name;
                            TextView textView4 = (TextView) findViewById(R.id.experiment_override_experiment_name);
                            if (textView4 != null) {
                                i2 i2Var = new i2(this, textView, spinner, materialCardView, textView2, textView3, textView4);
                                m.checkNotNullExpressionValue(i2Var, "ViewExperimentOverrideBi…ater.from(context), this)");
                                this.binding = i2Var;
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

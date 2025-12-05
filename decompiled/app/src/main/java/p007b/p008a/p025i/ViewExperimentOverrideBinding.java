package p007b.p008a.p025i;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

/* compiled from: ViewExperimentOverrideBinding.java */
/* renamed from: b.a.i.i2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewExperimentOverrideBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f946a;

    /* renamed from: b */
    @NonNull
    public final TextView f947b;

    /* renamed from: c */
    @NonNull
    public final Spinner f948c;

    /* renamed from: d */
    @NonNull
    public final TextView f949d;

    /* renamed from: e */
    @NonNull
    public final TextView f950e;

    /* renamed from: f */
    @NonNull
    public final TextView f951f;

    public ViewExperimentOverrideBinding(@NonNull View view, @NonNull TextView textView, @NonNull Spinner spinner, @NonNull MaterialCardView materialCardView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f946a = view;
        this.f947b = textView;
        this.f948c = spinner;
        this.f949d = textView2;
        this.f950e = textView3;
        this.f951f = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f946a;
    }
}

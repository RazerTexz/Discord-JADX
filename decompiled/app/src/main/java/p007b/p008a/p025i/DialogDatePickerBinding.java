package p007b.p008a.p025i;

import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: DialogDatePickerBinding.java */
/* renamed from: b.a.i.k, reason: use source file name */
/* loaded from: classes.dex */
public final class DialogDatePickerBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f987a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f988b;

    /* renamed from: c */
    @NonNull
    public final DatePicker f989c;

    /* renamed from: d */
    @NonNull
    public final TextView f990d;

    public DialogDatePickerBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull DatePicker datePicker, @NonNull TextView textView) {
        this.f987a = linearLayout;
        this.f988b = materialButton;
        this.f989c = datePicker;
        this.f990d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f987a;
    }
}

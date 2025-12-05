package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetChatInputGuardBinding.java */
/* renamed from: b.a.i.u4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChatInputGuardBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1291a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f1292b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f1293c;

    /* renamed from: d */
    @NonNull
    public final TextView f1294d;

    /* renamed from: e */
    @NonNull
    public final TextView f1295e;

    public WidgetChatInputGuardBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1291a = linearLayout;
        this.f1292b = materialButton;
        this.f1293c = materialButton2;
        this.f1294d = textView;
        this.f1295e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1291a;
    }
}

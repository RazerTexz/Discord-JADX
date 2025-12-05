package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetHubEmailFlowWaitlistBinding.java */
/* renamed from: b.a.i.p5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetHubEmailFlowWaitlistBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final NestedScrollView f1139a;

    /* renamed from: b */
    @NonNull
    public final TextView f1140b;

    public WidgetHubEmailFlowWaitlistBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView) {
        this.f1139a = nestedScrollView;
        this.f1140b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1139a;
    }
}

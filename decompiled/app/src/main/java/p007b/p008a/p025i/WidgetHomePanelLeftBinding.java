package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetHomePanelLeftBinding.java */
/* renamed from: b.a.i.l5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetHomePanelLeftBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f1035a;

    /* renamed from: b */
    @NonNull
    public final TextView f1036b;

    /* renamed from: c */
    @NonNull
    public final FragmentContainerView f1037c;

    public WidgetHomePanelLeftBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FrameLayout frameLayout) {
        this.f1035a = relativeLayout;
        this.f1036b = textView;
        this.f1037c = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1035a;
    }
}

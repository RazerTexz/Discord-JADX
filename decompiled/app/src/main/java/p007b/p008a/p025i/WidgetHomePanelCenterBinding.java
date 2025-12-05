package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;

/* compiled from: WidgetHomePanelCenterBinding.java */
/* renamed from: b.a.i.i5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetHomePanelCenterBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RoundedRelativeLayout f960a;

    /* renamed from: b */
    @NonNull
    public final FragmentContainerView f961b;

    /* renamed from: c */
    @NonNull
    public final WidgetHomePanelCenterChatBinding f962c;

    /* renamed from: d */
    @NonNull
    public final FragmentContainerView f963d;

    public WidgetHomePanelCenterBinding(@NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull WidgetHomePanelCenterChatBinding widgetHomePanelCenterChatBinding, @NonNull FragmentContainerView fragmentContainerView2) {
        this.f960a = roundedRelativeLayout;
        this.f961b = fragmentContainerView;
        this.f962c = widgetHomePanelCenterChatBinding;
        this.f963d = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f960a;
    }
}

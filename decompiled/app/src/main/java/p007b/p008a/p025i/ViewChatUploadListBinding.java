package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.FailedUploadView;

/* compiled from: ViewChatUploadListBinding.java */
/* renamed from: b.a.i.d2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewChatUploadListBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f778a;

    /* renamed from: b */
    @NonNull
    public final FailedUploadView f779b;

    /* renamed from: c */
    @NonNull
    public final FailedUploadView f780c;

    /* renamed from: d */
    @NonNull
    public final FailedUploadView f781d;

    public ViewChatUploadListBinding(@NonNull LinearLayout linearLayout, @NonNull FailedUploadView failedUploadView, @NonNull FailedUploadView failedUploadView2, @NonNull FailedUploadView failedUploadView3) {
        this.f778a = linearLayout;
        this.f779b = failedUploadView;
        this.f780c = failedUploadView2;
        this.f781d = failedUploadView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f778a;
    }
}

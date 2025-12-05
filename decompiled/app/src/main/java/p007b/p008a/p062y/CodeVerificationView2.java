package p007b.p008a.p062y;

import android.view.View;
import com.discord.views.CodeVerificationView;

/* compiled from: CodeVerificationView.kt */
/* renamed from: b.a.y.b, reason: use source file name */
/* loaded from: classes2.dex */
public final class CodeVerificationView2 implements View.OnFocusChangeListener {

    /* renamed from: j */
    public final /* synthetic */ CodeVerificationView f2007j;

    public CodeVerificationView2(CodeVerificationView codeVerificationView) {
        this.f2007j = codeVerificationView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            CodeVerificationView.m8537a(this.f2007j);
        }
    }
}

package b.a.y;

import android.view.View;
import com.discord.views.CodeVerificationView;

/* compiled from: CodeVerificationView.kt */
/* loaded from: classes2.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ CodeVerificationView j;

    public c(CodeVerificationView codeVerificationView) {
        this.j = codeVerificationView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CodeVerificationView.a(this.j);
    }
}

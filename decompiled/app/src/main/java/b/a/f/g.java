package b.a.f;

import android.view.View;
import com.discord.chips_view.ChipsView;

/* compiled from: ChipsView.kt */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ ChipsView j;

    public g(ChipsView chipsView) {
        this.j = chipsView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.j.mEditText.requestFocus();
        this.j.f(null);
    }
}

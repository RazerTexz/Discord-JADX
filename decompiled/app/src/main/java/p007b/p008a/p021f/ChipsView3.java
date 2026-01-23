package p007b.p008a.p021f;

import android.view.View;
import com.discord.chips_view.ChipsView;

/* JADX INFO: renamed from: b.a.f.g, reason: use source file name */
/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipsView3 implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ChipsView f622j;

    public ChipsView3(ChipsView chipsView) {
        this.f622j = chipsView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f622j.mEditText.requestFocus();
        this.f622j.m8380f(null);
    }
}

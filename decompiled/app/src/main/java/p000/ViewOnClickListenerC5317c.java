package p000;

import android.view.View;
import com.discord.views.TernaryCheckBox;

/* compiled from: java-style lambda group */
/* renamed from: c */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC5317c implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ int f14511j;

    /* renamed from: k */
    public final /* synthetic */ Object f14512k;

    public ViewOnClickListenerC5317c(int i, Object obj) {
        this.f14511j = i;
        this.f14512k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f14511j;
        if (i == 0) {
            TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) this.f14512k;
            TernaryCheckBox.Companion c7093a = TernaryCheckBox.INSTANCE;
            TernaryCheckBox.m8558a(ternaryCheckBox, 1);
        } else if (i == 1) {
            TernaryCheckBox ternaryCheckBox2 = (TernaryCheckBox) this.f14512k;
            TernaryCheckBox.Companion c7093a2 = TernaryCheckBox.INSTANCE;
            TernaryCheckBox.m8558a(ternaryCheckBox2, -1);
        } else {
            if (i != 2) {
                throw null;
            }
            TernaryCheckBox ternaryCheckBox3 = (TernaryCheckBox) this.f14512k;
            TernaryCheckBox.Companion c7093a3 = TernaryCheckBox.INSTANCE;
            TernaryCheckBox.m8558a(ternaryCheckBox3, 0);
        }
    }
}

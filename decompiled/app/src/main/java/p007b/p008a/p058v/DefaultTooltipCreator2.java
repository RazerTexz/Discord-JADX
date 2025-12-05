package p007b.p008a.p058v;

import android.view.View;
import com.discord.tooltips.DefaultTooltipCreator;
import com.discord.tooltips.TooltipManager;

/* compiled from: DefaultTooltipCreator.kt */
/* renamed from: b.a.v.b, reason: use source file name */
/* loaded from: classes2.dex */
public final class DefaultTooltipCreator2 implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ DefaultTooltipCreator f2000j;

    /* renamed from: k */
    public final /* synthetic */ TooltipManager.C6648b f2001k;

    public DefaultTooltipCreator2(DefaultTooltipCreator defaultTooltipCreator, TooltipManager.C6648b c6648b) {
        this.f2000j = defaultTooltipCreator;
        this.f2001k = c6648b;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2000j.tooltipManager.m8512a(this.f2001k);
        this.f2000j.tooltipManager.m8514c(this.f2001k);
    }
}

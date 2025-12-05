package p007b.p008a.p009a.p011a0;

import android.view.View;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreStream;

/* compiled from: WidgetGiftAcceptDialog.kt */
/* renamed from: b.a.a.a0.f, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGiftAcceptDialog4 implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ ModelGift f241j;

    public WidgetGiftAcceptDialog4(ModelGift modelGift) {
        this.f241j = modelGift;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreStream.INSTANCE.getGifting().acceptGift(this.f241j);
    }
}

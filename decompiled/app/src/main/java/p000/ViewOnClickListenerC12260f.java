package p000;

import android.content.Context;
import android.view.View;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.views.OverlayMenuView;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p062y.OverlayMenuView4;
import p007b.p008a.p062y.OverlayMenuView5;

/* JADX INFO: renamed from: f */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC12260f implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f25350j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f25351k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Object f25352l;

    public ViewOnClickListenerC12260f(int i, Object obj, Object obj2) {
        this.f25350j = i;
        this.f25351k = obj;
        this.f25352l = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f25350j;
        if (i != 0) {
            if (i != 1) {
                throw null;
            }
            OverlayMenuView overlayMenuView = (OverlayMenuView) this.f25351k;
            Long lValueOf = Long.valueOf(((OverlayMenuView.C7085a) this.f25352l).f19104c.getChannel().getId());
            int i2 = OverlayMenuView.f19098j;
            Objects.requireNonNull(overlayMenuView);
            overlayMenuView.getContext().startActivity(IntentUtils.RouteBuilders.INSTANCE.connectVoice(lValueOf != null ? lValueOf.longValue() : 0L).setClass(overlayMenuView.getContext(), AppActivity.Main.class).addFlags(268435456));
            overlayMenuView.onDismissRequested.invoke();
            return;
        }
        OverlayMenuView overlayMenuView2 = (OverlayMenuView) this.f25351k;
        Long lValueOf2 = Long.valueOf(((OverlayMenuView.C7085a) this.f25352l).f19104c.getChannel().getId());
        int i3 = OverlayMenuView.f19098j;
        Objects.requireNonNull(overlayMenuView2);
        if (lValueOf2 != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), lValueOf2.longValue(), null, 2, null), overlayMenuView2, null, 2, null), OverlayMenuView.class, (Context) null, (Function1) null, new OverlayMenuView4(overlayMenuView2), (Function0) null, (Function0) null, new OverlayMenuView5(overlayMenuView2), 54, (Object) null);
        } else {
            AppToast.m169g(overlayMenuView2.getContext(), C5419R.string.instant_invite_failed_to_generate, 0, null, 12);
        }
    }
}

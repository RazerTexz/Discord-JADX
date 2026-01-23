package p007b.p008a.p062y;

import android.content.Context;
import android.view.View;
import com.discord.app.DiscordConnectService;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.y.y, reason: use source file name */
/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayVoiceSelectorBubbleDialog2 extends Lambda implements Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $searchModel$inlined;
    public final /* synthetic */ OverlayVoiceSelectorBubbleDialog3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayVoiceSelectorBubbleDialog2(OverlayVoiceSelectorBubbleDialog3 overlayVoiceSelectorBubbleDialog3, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(4);
        this.this$0 = overlayVoiceSelectorBubbleDialog3;
        this.$searchModel$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function4
    public Unit invoke(View view, Integer num, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, Boolean bool) {
        View view2 = view;
        num.intValue();
        WidgetGlobalSearchModel.ItemDataPayload itemDataPayload2 = itemDataPayload;
        bool.booleanValue();
        Intrinsics3.checkNotNullParameter(view2, "view");
        Intrinsics3.checkNotNullParameter(itemDataPayload2, "data");
        if (itemDataPayload2 instanceof WidgetGlobalSearchModel.ItemChannel) {
            DiscordConnectService.Companion c5458a = DiscordConnectService.INSTANCE;
            Context context = view2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            c5458a.m8375b(context, ((WidgetGlobalSearchModel.ItemChannel) itemDataPayload2).getChannel().getId());
            this.this$0.m387g();
        }
        return Unit.f27425a;
    }
}

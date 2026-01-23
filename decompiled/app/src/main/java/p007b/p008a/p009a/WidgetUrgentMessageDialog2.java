package p007b.p008a.p009a;

import android.content.Context;
import android.view.View;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.WidgetUrgentMessageDialogViewModel3;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.a.u, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialog2 implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ WidgetUrgentMessageDialog f444j;

    public WidgetUrgentMessageDialog2(WidgetUrgentMessageDialog widgetUrgentMessageDialog) {
        this.f444j = widgetUrgentMessageDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer num;
        WidgetUrgentMessageDialog widgetUrgentMessageDialog = this.f444j;
        KProperty[] kPropertyArr = WidgetUrgentMessageDialog.f438j;
        WidgetUrgentMessageDialogViewModel3 widgetUrgentMessageDialogViewModel3M146h = widgetUrgentMessageDialog.m146h();
        Intrinsics3.checkNotNullExpressionValue(view, "button");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "button.context");
        Objects.requireNonNull(widgetUrgentMessageDialogViewModel3M146h);
        Intrinsics3.checkNotNullParameter(context, "context");
        ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(context, UserUtils.SYSTEM_USER_ID);
        WidgetUrgentMessageDialogViewModel3.d viewState = widgetUrgentMessageDialogViewModel3M146h.getViewState();
        if (viewState == null || (num = viewState.f452a) == null) {
            return;
        }
        RestAPIParams.UserInfo userInfo = new RestAPIParams.UserInfo(null, null, null, null, null, null, null, null, null, Integer.valueOf(num.intValue() & (-8193)), null, 1535, null);
        widgetUrgentMessageDialogViewModel3M146h.updateViewState(new WidgetUrgentMessageDialogViewModel3.d(viewState.f452a, true));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(widgetUrgentMessageDialogViewModel3M146h.f448l.patchUser(userInfo), false, 1, null), widgetUrgentMessageDialogViewModel3M146h, null, 2, null), WidgetUrgentMessageDialogViewModel3.class, (Context) null, (Function1) null, new WidgetUrgentMessageDialogViewModel5(widgetUrgentMessageDialogViewModel3M146h), (Function0) null, (Function0) null, new WidgetUrgentMessageDialogViewModel4(widgetUrgentMessageDialogViewModel3M146h), 54, (Object) null);
    }
}

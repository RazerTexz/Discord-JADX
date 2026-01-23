package p007b.p008a.p009a;

import android.view.View;
import com.discord.C5419R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.a.l, reason: use source file name */
/* JADX INFO: compiled from: FriendRequestDialogs.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FriendRequestDialogs extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Function1 $onConfirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendRequestDialogs(Function1 function1) {
        super(1);
        this.$onConfirm = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        this.$onConfirm.invoke(Integer.valueOf(C5419R.string.friend_request_cancelled));
        return Unit.f27425a;
    }
}

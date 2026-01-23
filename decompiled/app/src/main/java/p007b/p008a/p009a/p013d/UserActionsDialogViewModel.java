package p007b.p008a.p009a.p013d;

import com.discord.C5419R;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p013d.UserActionsDialogViewModel5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.a.d.b, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel extends Lambda implements Function1<UserActionsDialogViewModel5.c, Unit> {
    public final /* synthetic */ UserActionsDialogViewModel5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserActionsDialogViewModel(UserActionsDialogViewModel5 userActionsDialogViewModel5) {
        super(1);
        this.this$0 = userActionsDialogViewModel5;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(UserActionsDialogViewModel5.c cVar) {
        UserActionsDialogViewModel5.c cVar2 = cVar;
        Intrinsics3.checkNotNullParameter(cVar2, "storeState");
        UserActionsDialogViewModel5 userActionsDialogViewModel5 = this.this$0;
        Objects.requireNonNull(userActionsDialogViewModel5);
        User user = cVar2.f335a;
        if (user == null) {
            userActionsDialogViewModel5.f330k.f27650k.onNext(new UserActionsDialogViewModel5.b.a(C5419R.string.default_failure_to_perform_action_message));
        } else {
            int type = ModelUserRelationship.getType(cVar2.f336b);
            boolean z2 = type != 2;
            boolean z3 = type == 2;
            boolean z4 = type == 1;
            GuildMember guildMember = cVar2.f337c;
            userActionsDialogViewModel5.updateViewState(new UserActionsDialogViewModel5.d.a(user, guildMember != null ? guildMember.getNick() : null, z2, z3, z4));
        }
        return Unit.f27425a;
    }
}

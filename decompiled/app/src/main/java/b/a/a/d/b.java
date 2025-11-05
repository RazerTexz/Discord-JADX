package b.a.a.d;

import b.a.a.d.f;
import com.discord.R;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: UserActionsDialogViewModel.kt */
/* loaded from: classes.dex */
public final class b extends o implements Function1<f.c, Unit> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        super(1);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(f.c cVar) {
        f.c cVar2 = cVar;
        m.checkNotNullParameter(cVar2, "storeState");
        f fVar = this.this$0;
        Objects.requireNonNull(fVar);
        User user = cVar2.a;
        if (user == null) {
            fVar.k.k.onNext(new f.b.a(R.string.default_failure_to_perform_action_message));
        } else {
            int type = ModelUserRelationship.getType(cVar2.f46b);
            boolean z2 = type != 2;
            boolean z3 = type == 2;
            boolean z4 = type == 1;
            GuildMember guildMember = cVar2.c;
            fVar.updateViewState(new f.d.a(user, guildMember != null ? guildMember.getNick() : null, z2, z3, z4));
        }
        return Unit.a;
    }
}

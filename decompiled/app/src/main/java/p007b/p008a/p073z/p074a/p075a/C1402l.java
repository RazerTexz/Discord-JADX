package p007b.p008a.p073z.p074a.p075a;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.models.user.User;
import java.util.List;
import p637j0.p641k.Func1;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.l */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1402l implements Func1 {

    /* renamed from: j */
    public final /* synthetic */ List f2101j;

    public /* synthetic */ C1402l(List list) {
        this.f2101j = list;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        List list = this.f2101j;
        User user = (User) obj;
        if (list == null) {
            return Boolean.TRUE;
        }
        for (int i = 0; i < list.size(); i++) {
            if (((PermissionOverwrite) list.get(i)).m8131e() == user.getId()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}

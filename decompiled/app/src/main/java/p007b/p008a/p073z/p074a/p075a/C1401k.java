package p007b.p008a.p073z.p074a.p075a;

import com.discord.models.user.User;
import java.util.Locale;
import p637j0.p641k.Func1;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.k */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1401k implements Func1 {

    /* renamed from: j */
    public final /* synthetic */ String f2100j;

    public /* synthetic */ C1401k(String str) {
        this.f2100j = str;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        return Boolean.valueOf(((User) obj).getUsername().toLowerCase(Locale.ROOT).contains(this.f2100j));
    }
}

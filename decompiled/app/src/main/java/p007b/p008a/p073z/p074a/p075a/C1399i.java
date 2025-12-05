package p007b.p008a.p073z.p074a.p075a;

import com.discord.stores.StoreStream;
import java.util.List;
import java.util.Map;
import p637j0.p641k.Func1;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.i */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1399i implements Func1 {

    /* renamed from: j */
    public final /* synthetic */ List f2097j;

    /* renamed from: k */
    public final /* synthetic */ String f2098k;

    public /* synthetic */ C1399i(List list, String str) {
        this.f2097j = list;
        this.f2098k = str;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        Map map = (Map) obj;
        return StoreStream.getUsers().observeUsers(map.keySet()).m11099Y(new C1398h(this.f2097j, map, this.f2098k));
    }
}

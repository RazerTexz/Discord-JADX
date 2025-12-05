package p007b.p008a.p073z.p074a.p075a;

import com.discord.api.channel.Channel;
import java.util.List;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeFromIterable;
import p658rx.Observable;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.s */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1409s implements Func1 {

    /* renamed from: j */
    public final /* synthetic */ Channel f2108j;

    public /* synthetic */ C1409s(Channel channel) {
        this.f2108j = channel;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        return Observable.m11074h0(new OnSubscribeFromIterable((List) obj)).m11118y(new C1410t(this.f2108j)).m11083G(C1412v.f2112j).m11105f0();
    }
}

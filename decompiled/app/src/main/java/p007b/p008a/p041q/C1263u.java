package p007b.p008a.p041q;

import com.discord.rtcconnection.RtcConnection;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.q.u */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1263u extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Throwable $throwable;
    public final /* synthetic */ C1264v this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1263u(C1264v c1264v, Throwable th) {
        super(0);
        this.this$0 = c1264v;
        this.$throwable = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RtcConnection rtcConnection = this.this$0.f1872j.this$0;
        Throwable th = this.$throwable;
        Intrinsics3.checkNotNullExpressionValue(th, "throwable");
        Objects.requireNonNull(rtcConnection);
        rtcConnection.m8476s(new C1267y(rtcConnection, th));
        return Unit.f27425a;
    }
}

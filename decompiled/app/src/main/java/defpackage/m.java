package defpackage;

import b.a.q.m0.c.e;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import d0.g0.w;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: kotlin-style lambda group */
/* loaded from: classes2.dex */
public final class m extends o implements Function1<MediaEngineConnection.d, Unit> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(int i, Object obj, Object obj2) {
        super(1);
        this.j = i;
        this.k = obj;
        this.l = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(MediaEngineConnection.d dVar) {
        MediaEngineConnection.FailedConnectionException.FailureType failureType;
        int i = this.j;
        if (i == 0) {
            MediaEngineConnection.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "it");
            e eVar = (e) this.k;
            dVar2.onConnected(eVar, (MediaEngineConnection.TransportInfo) this.l, eVar.i);
            return Unit.a;
        }
        if (i == 1) {
            MediaEngineConnection.d dVar3 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar3, "it");
            dVar3.onError((e) this.k, new MediaEngineConnection.FailedConnectionException("No connection info. Error message from media engine: " + ((String) this.l), MediaEngineConnection.FailedConnectionException.FailureType.NO_CONNECTION_INFO));
            return Unit.a;
        }
        if (i != 2) {
            throw null;
        }
        MediaEngineConnection.d dVar4 = dVar;
        d0.z.d.m.checkNotNullParameter(dVar4, "it");
        e eVar2 = (e) this.k;
        String str = (String) this.l;
        Objects.requireNonNull(MediaEngineConnection.FailedConnectionException.FailureType.INSTANCE);
        if (str != null ? w.contains((CharSequence) str, (CharSequence) "Disconnected before we managed to connect", true) : false) {
            failureType = MediaEngineConnection.FailedConnectionException.FailureType.DISCONNECTED_BEFORE_CONNECTION_ESTABLISHED;
        } else {
            if (str != null ? w.contains((CharSequence) str, (CharSequence) "OnConnectAttemptTimedOut", true) : false) {
                failureType = MediaEngineConnection.FailedConnectionException.FailureType.TIMEOUT;
            } else {
                failureType = str != null ? w.contains((CharSequence) str, (CharSequence) "OnAddressIPResolved", true) : false ? MediaEngineConnection.FailedConnectionException.FailureType.ADDRESS_IP_RESOLVED : MediaEngineConnection.FailedConnectionException.FailureType.UNKNOWN;
            }
        }
        dVar4.onError(eVar2, new MediaEngineConnection.FailedConnectionException(str, failureType));
        return Unit.a;
    }
}

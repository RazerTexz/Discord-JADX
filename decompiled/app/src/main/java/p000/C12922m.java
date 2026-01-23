package p000;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.p044m0.p045c.MediaEngineConnectionLegacy5;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: m */
/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class C12922m extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f27492j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f27493k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Object f27494l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12922m(int i, Object obj, Object obj2) {
        super(1);
        this.f27492j = i;
        this.f27493k = obj;
        this.f27494l = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        MediaEngineConnection.FailedConnectionException.FailureType failureType;
        int i = this.f27492j;
        if (i == 0) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
            MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5 = (MediaEngineConnectionLegacy5) this.f27493k;
            interfaceC5648d2.onConnected(mediaEngineConnectionLegacy5, (MediaEngineConnection.TransportInfo) this.f27494l, mediaEngineConnectionLegacy5.f1706i);
            return Unit.f27425a;
        }
        if (i == 1) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d3 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d3, "it");
            interfaceC5648d3.onError((MediaEngineConnectionLegacy5) this.f27493k, new MediaEngineConnection.FailedConnectionException("No connection info. Error message from media engine: " + ((String) this.f27494l), MediaEngineConnection.FailedConnectionException.FailureType.NO_CONNECTION_INFO));
            return Unit.f27425a;
        }
        if (i != 2) {
            throw null;
        }
        MediaEngineConnection.InterfaceC5648d interfaceC5648d4 = interfaceC5648d;
        Intrinsics3.checkNotNullParameter(interfaceC5648d4, "it");
        MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy52 = (MediaEngineConnectionLegacy5) this.f27493k;
        String str = (String) this.f27494l;
        Objects.requireNonNull(MediaEngineConnection.FailedConnectionException.FailureType.INSTANCE);
        if (str != null ? Strings4.contains((CharSequence) str, (CharSequence) "Disconnected before we managed to connect", true) : false) {
            failureType = MediaEngineConnection.FailedConnectionException.FailureType.DISCONNECTED_BEFORE_CONNECTION_ESTABLISHED;
        } else {
            if (str != null ? Strings4.contains((CharSequence) str, (CharSequence) "OnConnectAttemptTimedOut", true) : false) {
                failureType = MediaEngineConnection.FailedConnectionException.FailureType.TIMEOUT;
            } else {
                failureType = str != null ? Strings4.contains((CharSequence) str, (CharSequence) "OnAddressIPResolved", true) : false ? MediaEngineConnection.FailedConnectionException.FailureType.ADDRESS_IP_RESOLVED : MediaEngineConnection.FailedConnectionException.FailureType.UNKNOWN;
            }
        }
        interfaceC5648d4.onError(mediaEngineConnectionLegacy52, new MediaEngineConnection.FailedConnectionException(str, failureType));
        return Unit.f27425a;
    }
}

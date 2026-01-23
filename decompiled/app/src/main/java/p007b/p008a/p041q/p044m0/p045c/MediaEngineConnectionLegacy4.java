package p007b.p008a.p041q.p044m0.p045c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.webrtc.MediaStreamTrack;
import p000.C12922m;
import p007b.p008a.p041q.p044m0.Codec2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.q.m0.c.d, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy4 implements Discord.ConnectToServerCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ MediaEngineConnectionLegacy5 f1697a;

    /* JADX INFO: renamed from: b.a.q.m0.c.d$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Discord.ConnectionInfo $connectionInfo;
        public final /* synthetic */ String $errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Discord.ConnectionInfo connectionInfo, String str) {
            super(0);
            this.$connectionInfo = connectionInfo;
            this.$errorMessage = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Unit invoke() {
            MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5 = MediaEngineConnectionLegacy4.this.f1697a;
            Discord.ConnectionInfo connectionInfo = this.$connectionInfo;
            String str = this.$errorMessage;
            Logger.i$default(mediaEngineConnectionLegacy5.f1709l, "MediaEngineConnectionLegacy", outline.m883w("handleConnection(). errorMessage: ", str), null, 4, null);
            if (connectionInfo != null) {
                if (str == null || str.length() == 0) {
                    String str2 = connectionInfo.localAddress;
                    Intrinsics3.checkNotNullExpressionValue(str2, "connectionInfo.localAddress");
                    int i = connectionInfo.localPort;
                    String str3 = connectionInfo.protocol;
                    Intrinsics3.checkNotNullExpressionValue(str3, "connectionInfo.protocol");
                    Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = str3.toUpperCase();
                    Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                    MediaEngineConnection.TransportInfo transportInfo = new MediaEngineConnection.TransportInfo(str2, i, MediaEngineConnection.TransportInfo.Protocol.valueOf(upperCase));
                    MediaEngineConnection.ConnectionState connectionState = MediaEngineConnection.ConnectionState.CONNECTED;
                    mediaEngineConnectionLegacy5.f1699b = connectionState;
                    mediaEngineConnectionLegacy5.m318y(new MediaEngineConnectionLegacy(mediaEngineConnectionLegacy5, connectionState));
                    Codec2 codec2 = new Codec2("opus", 1, MediaStreamTrack.AUDIO_TRACK_KIND, 120, null);
                    mediaEngineConnectionLegacy5.f1706i.clear();
                    mediaEngineConnectionLegacy5.f1706i.add(codec2);
                    mediaEngineConnectionLegacy5.f1706i.addAll(mediaEngineConnectionLegacy5.f1712o);
                    mediaEngineConnectionLegacy5.m318y(new C12922m(0, mediaEngineConnectionLegacy5, transportInfo));
                }
            } else if (connectionInfo == null) {
                mediaEngineConnectionLegacy5.m318y(new C12922m(1, mediaEngineConnectionLegacy5, str));
            } else {
                mediaEngineConnectionLegacy5.m318y(new C12922m(2, mediaEngineConnectionLegacy5, str));
            }
            return Unit.f27425a;
        }
    }

    public MediaEngineConnectionLegacy4(MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5) {
        this.f1697a = mediaEngineConnectionLegacy5;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.ConnectToServerCallback
    public final void onConnectToServer(Discord.ConnectionInfo connectionInfo, String str) {
        Intrinsics3.checkNotNullParameter(connectionInfo, "connectionInfo");
        Intrinsics3.checkNotNullParameter(str, "errorMessage");
        MediaEngineConnectionLegacy5.m294x(this.f1697a, new a(connectionInfo, str));
    }
}

package h0.c;

import org.webrtc.CalledByNative;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.PeerConnection;
import org.webrtc.RtpTransceiver;

/* compiled from: PeerConnection.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class o0 {
    @CalledByNative("Observer")
    public static void a(PeerConnection.Observer observer, PeerConnection.PeerConnectionState peerConnectionState) {
    }

    @CalledByNative("Observer")
    public static void b(PeerConnection.Observer observer, CandidatePairChangeEvent candidatePairChangeEvent) {
    }

    @CalledByNative("Observer")
    public static void c(PeerConnection.Observer observer, PeerConnection.IceConnectionState iceConnectionState) {
    }

    @CalledByNative("Observer")
    public static void d(PeerConnection.Observer observer, RtpTransceiver rtpTransceiver) {
    }
}

package p007b.p445m.p446a.p447g.p448d;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.m.a.g.d.b, reason: use source file name */
/* JADX INFO: compiled from: DatagramFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DatagramFactory2 implements DatagramFactory {
    @Override // p007b.p445m.p446a.p447g.p448d.DatagramFactory
    /* JADX INFO: renamed from: a */
    public DatagramPacket mo7140a(byte[] bArr) {
        Intrinsics3.checkParameterIsNotNull(bArr, "buffer");
        return new DatagramPacket(bArr, bArr.length);
    }

    @Override // p007b.p445m.p446a.p447g.p448d.DatagramFactory
    /* JADX INFO: renamed from: b */
    public DatagramPacket mo7141b(byte[] bArr, InetAddress inetAddress, int i) {
        Intrinsics3.checkParameterIsNotNull(bArr, "buffer");
        Intrinsics3.checkParameterIsNotNull(inetAddress, "address");
        return new DatagramPacket(bArr, bArr.length, inetAddress, i);
    }

    @Override // p007b.p445m.p446a.p447g.p448d.DatagramFactory
    /* JADX INFO: renamed from: c */
    public DatagramSocket mo7142c() throws SocketException {
        return new DatagramSocket();
    }
}

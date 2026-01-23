package p007b.p445m.p446a.p447g.p448d;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* JADX INFO: renamed from: b.m.a.g.d.a, reason: use source file name */
/* JADX INFO: compiled from: DatagramFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DatagramFactory {
    /* JADX INFO: renamed from: a */
    DatagramPacket mo7140a(byte[] bArr);

    /* JADX INFO: renamed from: b */
    DatagramPacket mo7141b(byte[] bArr, InetAddress inetAddress, int i);

    /* JADX INFO: renamed from: c */
    DatagramSocket mo7142c() throws SocketException;
}

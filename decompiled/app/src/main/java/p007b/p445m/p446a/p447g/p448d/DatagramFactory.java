package p007b.p445m.p446a.p447g.p448d;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* compiled from: DatagramFactory.kt */
/* renamed from: b.m.a.g.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface DatagramFactory {
    /* renamed from: a */
    DatagramPacket mo7140a(byte[] bArr);

    /* renamed from: b */
    DatagramPacket mo7141b(byte[] bArr, InetAddress inetAddress, int i);

    /* renamed from: c */
    DatagramSocket mo7142c() throws SocketException;
}

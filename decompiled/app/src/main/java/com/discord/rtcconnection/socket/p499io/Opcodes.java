package com.discord.rtcconnection.socket.p499io;

import java.util.Map;
import p507d0.Tuples;
import p507d0.p580t.Maps6;

/* compiled from: Opcodes.kt */
/* loaded from: classes.dex */
public final class Opcodes {
    public static final int CLIENT_DISCONNECT = 13;
    public static final int HEARTBEAT = 3;
    public static final int HEARTBEAT_ACK = 6;
    public static final int HELLO = 8;
    public static final int IDENTIFY = 0;
    public static final int MEDIA_SINK_WANTS = 15;
    public static final int READY = 2;
    public static final int RESUME = 7;
    public static final int RESUMED = 9;
    public static final int SELECT_PROTOCOL = 1;
    public static final int SELECT_PROTOCOL_ACK = 4;
    public static final int SESSION_UPDATE = 14;
    public static final int SPEAKING = 5;
    public static final int VIDEO = 12;
    public static final Opcodes INSTANCE = new Opcodes();
    private static final Map<Integer, String> nameLookup = Maps6.mapOf(Tuples.m10073to(0, "IDENTIFY"), Tuples.m10073to(1, "SELECT_PROTOCOL"), Tuples.m10073to(2, "READY"), Tuples.m10073to(3, "HEARTBEAT"), Tuples.m10073to(4, "SELECT_PROTOCOL_ACK"), Tuples.m10073to(5, "SPEAKING"), Tuples.m10073to(6, "HEARTBEAT_ACK"), Tuples.m10073to(7, "RESUME"), Tuples.m10073to(8, "HELLO"), Tuples.m10073to(9, "RESUMED"), Tuples.m10073to(12, "VIDEO"), Tuples.m10073to(13, "CLIENT_DISCONNECT"), Tuples.m10073to(14, "SESSION_UPDATE"), Tuples.m10073to(15, "MEDIA_SINK_WANTS"));

    private Opcodes() {
    }

    public final String getNameOf(int opcode) {
        String str = nameLookup.get(Integer.valueOf(opcode));
        if (str == null) {
            str = "Unknown (" + opcode + ')';
        }
        return str;
    }
}

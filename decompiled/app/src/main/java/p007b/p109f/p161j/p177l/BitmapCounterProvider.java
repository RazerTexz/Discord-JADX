package p007b.p109f.p161j.p177l;

import com.discord.api.permission.Permission;

/* compiled from: BitmapCounterProvider.java */
/* renamed from: b.f.j.l.c, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapCounterProvider {

    /* renamed from: a */
    public static final int f3923a;

    /* renamed from: b */
    public static int f3924b;

    /* renamed from: c */
    public static volatile BitmapCounter f3925c;

    static {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        f3923a = ((long) iMin) > Permission.MOVE_MEMBERS ? (iMin / 4) * 3 : iMin / 2;
        f3924b = 384;
    }
}
